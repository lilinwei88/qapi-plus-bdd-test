package com.qaipi.init;



import com.qaipi.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

import java.util.Optional;
import java.util.Properties;

public class PropertiesManager {
    private static Properties properties;
    private static Properties commonProperties;
    private static Properties androidProperties = null;
    private static Properties iosProperties = null;
//    private static Logger logger = LogManager.getRootLogger();

    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    //LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
//    Logger logger = LogManager.getRootLogger();

    /**
     * A private constructor.
     */
    private PropertiesManager() {
        // Keep it empty.
    }

    static {
        try {
            commonProperties = loadFile(Constants.COMMON_PROPERTIES_FILE);
            androidProperties = loadFile(Constants.ANDROID_PROPERTIES_FILE);
            iosProperties = loadFile(Constants.IOS_PROPERTIES_FILE);

            //Setting up testing env properties.
            String env = getEnv();
            if (!env.isEmpty() && !env.equals("lab")) {
                properties = loadFile("src/main/resources/" + env + ".properties");
            }
        } catch (Exception e) {
            logger.error("Unable to find the properties file", e);
        }
    }

    private static Properties loadFile(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException ex) {
            logger.error("unable to find the properties file", ex);
            return null;
        }
    }

    /**
     * Loads a property by key.
     *
     * @param prop the property key
     * @return the property value if it exists
     */
    public static String loadProp(String prop) {
        String val = System.getProperty(prop);
        if (val == null && properties != null) {
            val = properties.getProperty(prop);
        }
        if (val == null && commonProperties != null) {
            val = commonProperties.getProperty(prop);
        }
        return val;
    }

    /**
     * Loads a property by key.
     *
     * @param prop      the property key
     * @param isAndroid if it is android device
     * @return the property value if it exists
     */
    public static String loadProp(String prop, boolean isAndroid) {
        if (isAndroid) {
            return androidProperties.getProperty(prop);
        } else {
            // return iOS locator
            return iosProperties.getProperty(prop);
        }
    }

    /**
     * Loads a property by key with default value.
     *
     * @param prop  the property key
     * @param deflt default value if it is not exist
     * @return the property value if it exists, default value if it doesn't
     */
    public static String loadProp(String prop, String deflt) {
        String val;
        val = loadProp(prop);

        if (val == null) {
            val = deflt;
        }

        return val;
    }

    /**
     * Return which test environment.
     *
     * @return environment e.g. lab, dev (or null if others)
     */
    public static String getEnv() {
        final String ENV = "-Denv=";
        String result = "";
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> vmOptions = runtimeMxBean.getInputArguments();
        boolean hasElement = vmOptions.stream().noneMatch(option -> option.contains(ENV));
        Optional<String> element = vmOptions.stream().filter(option -> option.contains(ENV)).findFirst();
        if (element.isPresent()) {
            result = element.get().replace(ENV, "");
        }
        return hasElement && element.isPresent() ? "" : result;
    }
}
