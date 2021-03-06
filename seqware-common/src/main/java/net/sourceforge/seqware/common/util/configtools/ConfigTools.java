package net.sourceforge.seqware.common.util.configtools;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import net.sourceforge.seqware.common.util.Log;
import net.sourceforge.seqware.common.util.filetools.FileTools;

import net.sourceforge.seqware.common.util.maptools.MapTools;

/**
 * <p>ConfigTools class.</p>
 *
 * @author boconnor
 * @version $Id: $Id
 */
public class ConfigTools {

  /** Constant <code>SEQWARE_SETTINGS_PROPERTY="SEQWARE_SETTINGS"</code> */
  public static final String SEQWARE_SETTINGS_PROPERTY = "SEQWARE_SETTINGS";

  /**
   * The output keys are always uppercase!
   *
   * @throws java.lang.Exception if any.
   * @return a {@link java.util.Map} object.
   */
  public static Map<String, String> getSettings() {

    // first, try to figure out the location of the settings file
    String settings = getSettingsFilePath();

    // Log.info(settings);
    File settingsFile = new File(settings);

    if (!settingsFile.exists()) {
      throw new RuntimeException("The settings file " + settings + " does not exist, or user '"+System.getProperty("user.name")+"' does not have permissions to read it!");
    } else if (!settingsFile.isFile()) {
      throw new RuntimeException("The settings file " + settings + " is not a file!");
    }

    HashMap<String, String> hm = new HashMap<String, String>();

    // now read back the values from the settings file
    MapTools.ini2Map(settings, hm, true);

    return (hm);
  }

  /**
   * <p>getProperty.</p>
   *
   * @param name a {@link java.lang.String} object.
   * @return a {@link java.lang.String} object.
   */
  public static String getProperty(String name) {

    String value = null;

    // try pulling from standard env variable for running as standalone web
    // server
    value = System.getProperty(name);

    if (value == null) {
      value = System.getenv(name);
    }

    // if that's null then try pulling from web.xml or context.xml
    if (value == null) {
      Context initCtx;
      try {
        initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        value = (String) envCtx.lookup(name);
      } catch (NamingException e) {
        // WARNING: This method of pulling env vars from a Context works
        // in a web server, this may fail in a stand-alone application.
        // If you see this warning you probably don't have a
        // needed/recommended environmental variable set
        // (e.g. SEQWARE_SETTINGS). SEQWARE_SETTINGS by default points
        // to ~/.seqware/settings.");
        // e.printStackTrace();
        value = null;
      }
    }

    return value;

  }

    public static String getSettingsFilePath() {
        String settings = ConfigTools.getProperty(SEQWARE_SETTINGS_PROPERTY);
        if (settings == null || "".equals(settings)) {
          settings = ConfigTools.getProperty("HOME") + File.separator + ".seqware/settings";
        }
        if (ConfigTools.getProperty("HOME") == null || "".equals(ConfigTools.getProperty("HOME"))) {
          settings = ConfigTools.getProperty("user.home") + File.separator + ".seqware/settings";
        }
        return settings;
    }
}
