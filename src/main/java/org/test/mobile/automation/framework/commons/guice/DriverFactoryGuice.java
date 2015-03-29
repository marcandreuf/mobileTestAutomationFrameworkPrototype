package org.test.mobile.automation.framework.commons.guice;

import com.google.inject.Inject;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

import org.test.mobile.automation.framework.commons.config.ConfigLoader;
import org.test.mobile.automation.framework.commons.driver.Driver;
import org.test.mobile.automation.framework.commons.exceptions.DriverFactoryException;

/**
 * @author marcandreuf
 */
public class DriverFactoryGuice implements DriverFactory {

    private final ConfigLoader configLoader;

    @Inject
    public DriverFactoryGuice(ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    @Override
    public Driver create(String configFilename) throws DriverFactoryException {
        Properties config = null;
        try {
            config = configLoader.loadConfig(configFilename);
            return instantiateDriverByClassName(config);
        } catch (IOException e) {
            throw new DriverFactoryException("Config file name not found: "+e.getMessage(), e);
        } catch (Exception e) {
            throw new DriverFactoryException("Driver class error: "+e.getMessage(), e);
        }
    }

    private Driver instantiateDriverByClassName(Properties config) throws Exception {
        String dirverClassTypeName = config.getProperty(DRIVER_CLASS_NAME);
        Class<Driver> driverClassType = (Class<Driver>) Class.forName(dirverClassTypeName);
        Constructor<Driver> constructor = driverClassType.getConstructor(Properties.class);
        Driver driver = constructor.newInstance(config);
        return driver;
    }

}
