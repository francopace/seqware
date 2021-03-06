package net.sourceforge.seqware.common.util.configtools;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Xiaoshu Wang (xiao@renci.org)
 * Date: 8/11/11
 * Time: 4:34 PM
 *
 * @author boconnor
 * @version $Id: $Id
 */
public class OptionParsing {

    /**
     * <p>parseOption.</p>
     *
     * @param obj a {@link java.lang.Object} object.
     * @param params a {@link java.util.List} object.
     * @throws org.kohsuke.args4j.CmdLineException if any.
     */
    public static void parseOption(Object obj, List<String> params) throws CmdLineException {
        if (params == null || params.size() == 0) return;

        CmdLineParser parser = new CmdLineParser(obj);
        parser.parseArgument(params.toArray(new String[params.size()]));
    }
}
