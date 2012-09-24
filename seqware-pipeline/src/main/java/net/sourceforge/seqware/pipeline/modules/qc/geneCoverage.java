package net.sourceforge.seqware.pipeline.modules.qc;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.sourceforge.seqware.common.module.FileMetadata;
import net.sourceforge.seqware.common.module.ReturnValue;
import net.sourceforge.seqware.common.util.filetools.FileTools;
import net.sourceforge.seqware.common.util.runtools.RunTools;
import net.sourceforge.seqware.pipeline.module.Module;
import net.sourceforge.seqware.pipeline.module.ModuleInterface;

import org.openide.util.lookup.ServiceProvider;

/**
 * To get coverage across transcript plot
 * 
 * 
 *  
 * Underlying script:  sw_module_CoverageAcrossTranscript.pl (by Sara Grimm)
 *               
 * Necessary programs:  perl, path to samtools
 *  
 * Input: alignment file (bam)
 *        a map file, which is generated by the PrepTranscriptDB module, currently, 
 *        ~/svnroot/seqware-complete/trunk/seqware-pipeline/data/annotation_reference/hg19_transcripts.hg19.20091027.trmap
 * Expected output: coverage across transcript plot
 * 
 * 
 * 
 * @author jyli@med.unc.edu
 *
 */
@ServiceProvider(service=ModuleInterface.class)
public class geneCoverage extends Module {
  
  private OptionSet options = null;
  private File tempDir = null;
  
  /**
   * getOptionParser is an internal method to parse command line args.
   * 
   * @return OptionParser this is used to get command line options
   */  
  protected OptionParser getOptionParser() {
    OptionParser parser = new OptionParser();
    parser.accepts("infile", "gene level quantification file").withRequiredArg();
    parser.accepts("outfile",  "gene coverage output file with 2 column, average coverage & # of genes").withRequiredArg();
    parser.accepts("perl", "Path to perl").withRequiredArg();
    parser.accepts("script", "Path to perl script: sw_module_geneCoverage.pl").withRequiredArg();
    parser.accepts("Rcom", "Path to R, /urs/bin/R").withRequiredArg();
    parser.accepts("Rscript", "Path to R: /home/jyli/svnroot/seqware/trunk/seqware-pipeline/R/plot_geneCoverage.R").withRequiredArg();
    parser.accepts("geneCoveragePlot",  "output figure file").withRequiredArg();
    return (parser);
  }
  
  /**
   * A method used to return the syntax for this module
   * @return a string describing the syntax
   */
  @Override
  public String get_syntax() {
    OptionParser parser = getOptionParser();
    StringWriter output = new StringWriter();
    try {
      parser.printHelpOn(output);
      return(output.toString());
    } catch (IOException e) {
      e.printStackTrace();
      return(e.getMessage());
    }
  }

  /**
   * All necessary setup for the module.
   * Populate the "processing" table in seqware_meta_db. 
   * Create a temporary directory.
   *  
   * @return A ReturnValue object that contains information about the status of init.
   */
  @Override
  public ReturnValue init() {

    ReturnValue ret = new ReturnValue();
    ret.setExitStatus(ReturnValue.SUCCESS);
    // fill in the [xxx] fields in the processing table
    ret.setAlgorithm("geneConverage");
    ret.setDescription("Getting gene coverage plot");
    ret.setVersion("0.7.0");
    
    try {
      OptionParser parser = getOptionParser();
      // The parameters object is actually an ArrayList of Strings created
      // by splitting the command line options by space. JOpt expects a String[]
      options = parser.parse(this.getParameters().toArray(new String[0]));
      // create a temp directory in current working directory
      tempDir = FileTools.createTempDirectory(new File("."));
      // you can write to "stdout" or "stderr" which will be persisted back to the DB
      ret.setStdout(ret.getStdout()+"Output: "+(String)options.valueOf("outfile")+"\n");
    } catch (OptionException e) {
      e.printStackTrace();
      ret.setStderr(e.getMessage());
      ret.setExitStatus(ReturnValue.INVALIDPARAMETERS);
    } catch (IOException e) {
      e.printStackTrace();
      ret.setStderr(e.getMessage());
      ret.setExitStatus(ReturnValue.DIRECTORYNOTWRITABLE);
    }
    
    return (ret);
  }
  
  /**
   * Verify that the parameters are defined & make sense.
   * 
   * @return a ReturnValue object
   */
  @Override
  public ReturnValue do_verify_parameters() {

    ReturnValue ret = new ReturnValue();
    ret.setExitStatus(ReturnValue.SUCCESS);
    
    // now look at the options and make sure they make sense
    for (String option : new String[] {
        "infile", "outfile", "perl", "script",  "Rcom", "Rscript", "geneCoveragePlot"
      }) {
      if (!options.has(option)) {
        ret.setExitStatus(ReturnValue.INVALIDPARAMETERS);
        String stdErr = ret.getStderr();
        ret.setStderr(stdErr+"Must include parameter: --"+option+"\n");
      }
    }

    return ret;
  }
  /**
   * Verify anything needed to run the module is ready (e.g. input files exist, etc).
   * 
   * @return a ReturnValue object
   */
  @Override

  public ReturnValue do_verify_input() {
    
    ReturnValue ret = new ReturnValue();
    ret.setExitStatus(ReturnValue.SUCCESS);
    
        
    // Does input quantification file exist?
    if (FileTools.fileExistsAndReadable(new File((String) options.valueOf("infile"))).getExitStatus() != ReturnValue.SUCCESS) {
      ret.setExitStatus(ReturnValue.FILENOTREADABLE);
      ret.setStderr("Input file " + (String)options.valueOf("infile") + " is not readable");
    }

    
    // Is output file path writable?
    File output = new File((String) options.valueOf("outfile"));
    if (FileTools.dirPathExistsAndWritable(output.getParentFile()).getExitStatus() != ReturnValue.SUCCESS) {
      ret.setExitStatus(ReturnValue.DIRECTORYNOTWRITABLE);
      ret.setStderr("Can't write to output directory");
    }
   
    // Is 'perl' executable?
    if (FileTools.fileExistsAndExecutable(new File((String) options.valueOf("perl"))).getExitStatus() != ReturnValue.SUCCESS) {
      ret.setExitStatus(ReturnValue.FILENOTEXECUTABLE);
      ret.setStderr("Not executable: " +(String)options.valueOf("perl"));
    }
    
    // Does 'script'  sw_module_CoverageAcrossTranscript.pl exist?
    if (FileTools.fileExistsAndReadable(new File((String) options.valueOf("script"))).getExitStatus() != ReturnValue.SUCCESS) {
      ret.setExitStatus(ReturnValue.FILENOTREADABLE);
      ret.setStderr("Could not find script at "+(String)options.valueOf("script"));
    }

 
    // Is 'R' executable?
    if (FileTools.fileExistsAndExecutable(new File((String) options.valueOf("Rcom"))).getExitStatus() != ReturnValue.SUCCESS) {
      ret.setExitStatus(ReturnValue.FILENOTEXECUTABLE);
      ret.setStderr("Not executable: " +(String)options.valueOf("Rcom"));
    }
    
    // Does 'Rscript'  exist?
    if (FileTools.fileExistsAndReadable(new File((String) options.valueOf("Rscript"))).getExitStatus() != ReturnValue.SUCCESS) {
      ret.setExitStatus(ReturnValue.FILENOTREADABLE);
      ret.setStderr("Could not find script at "+(String)options.valueOf("Rscript"));
    }
    
    // Is output file path writable?
    File outplot = new File((String) options.valueOf("geneCoveragePlot"));
    if (FileTools.dirPathExistsAndWritable(outplot.getParentFile()).getExitStatus() != ReturnValue.SUCCESS) {
      ret.setExitStatus(ReturnValue.DIRECTORYNOTWRITABLE);
      ret.setStderr("Can't write to outplot directory");
    }
        
    // Is tempDir writeable?
    if (FileTools.dirPathExistsAndWritable(tempDir).getExitStatus() != ReturnValue.SUCCESS) {
      ret.setExitStatus(ReturnValue.DIRECTORYNOTWRITABLE);
      ret.setStderr("Can't write to temp directory");
    }
    
    return (ret);

  }
  
  /**
   * Optional:  Test program on a known dataset.  Not implemented in this module.
   * 
   * @return a ReturnValue object
   */
  @Override
  public ReturnValue do_test() {
    ReturnValue ret = new ReturnValue();
    ret.setExitStatus(ReturnValue.NOTIMPLEMENTED);
    return(ret);
  }
  
  
  @Override
public ReturnValue do_run() {
    
    ReturnValue ret = new ReturnValue();
    ret.setExitStatus(ReturnValue.SUCCESS);
    ret.setRunStartTstmp(new Date());
    String output  = (String)options.valueOf("outfile");
    String outplot = (String)options.valueOf("geneCoveragePlot");
    
    StringBuffer cmd = new StringBuffer();
    cmd.append(options.valueOf("perl") + " " + options.valueOf("script") + " " + options.valueOf("infile") + " ");
    cmd.append(options.valueOf("outfile") + " " +  options.valueOf("geneCoveragePlot") + " ");
    cmd.append(options.valueOf("Rcom") + " " + options.valueOf("Rscript") + " "); 
    
    RunTools.runCommand( new String[] { "bash", "-c", cmd.toString() } );
    
      
    // record the file output
    FileMetadata fm = new FileMetadata();
    fm.setMetaType("text/geneCoverage");
    fm.setFilePath(output);
    fm.setType("Getting gene coverage");
    fm.setDescription("Text file output of qc/geneCoverage module.");
    ret.getFiles().add(fm);
    
       
    //Need to fix here for plot in R, jyl 
    //FIXME Only register single file??
    FileMetadata fm2 = new FileMetadata();
    fm2.setMetaType("png/geneCoverage plot");
    fm2.setFilePath(outplot);
    fm2.setType("Plotting gene coverage.");
    fm2.setDescription("Gene coverage plot file/geneCoverage module.");
    ret.getFiles().add(fm2);
    
    ret.setRunStopTstmp(new Date());
    return(ret);
  }

  @Override
  public ReturnValue do_verify_output() {
    // just make sure the file exists
    return(FileTools.fileExistsAndReadable(new File((String)options.valueOf("outfile"))));
  }
  /**
   * Optional:  Cleanup.  Remove tempDir.
   * Cleanup files that are outside the current working directory since Pegasus won't do that for you.
   * 
   */
  @Override
  public ReturnValue clean_up() {
    ReturnValue ret = new ReturnValue();
    ret.setExitStatus(ReturnValue.SUCCESS);
    if (!FileTools.deleteDirectoryRecursive(tempDir)) {
      ret.setExitStatus(ReturnValue.DIRECTORYNOTWRITABLE);
      ret.setStderr("Can't delete folder: "+tempDir.getAbsolutePath());
    }
    return(ret);
  }
}