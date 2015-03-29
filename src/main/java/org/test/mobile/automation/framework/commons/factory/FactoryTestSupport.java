package org.test.mobile.automation.framework.commons.factory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.test.mobile.automation.framework.android.device.AndroidDevice;
import org.test.mobile.automation.framework.commons.app.App;
import org.test.mobile.automation.framework.commons.app.MobileApp;
import org.test.mobile.automation.framework.commons.config.ConfigLoader;
import org.test.mobile.automation.framework.commons.device.Device;
import org.test.mobile.automation.framework.commons.device.Device.PLATFORM;
import org.test.mobile.automation.framework.commons.driver.Driver;
import org.test.mobile.automation.framework.commons.exceptions.AppLaunchException;
import org.test.mobile.automation.framework.commons.exceptions.DeviceFactoryException;
import org.test.mobile.automation.framework.commons.user.GenericUser;
import org.test.mobile.automation.framework.commons.user.User;
import org.test.mobile.automation.framework.ios.device.IosDevice;



/**
 * @author marcandreuf
 */
public class FactoryTestSupport implements Factory {

    private final ConfigLoader configLoader;
    private final Logger logger = LoggerFactory.getLogger(FactoryTestSupport.class);

    @Inject
    public FactoryTestSupport(ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    public Device instantiateDeviceByClassName(String deviceConfigFileName) throws DeviceFactoryException {
        try {
            return createDevice(deviceConfigFileName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DeviceFactoryException("Unable to instantiate the device: " + e.getMessage());
        }
    }

    private Device createDevice(String deviceConfigFileName) throws IOException, Exception, DeviceFactoryException {
        Properties config = getConfigurationProperties(deviceConfigFileName);
        Driver driver = instantiateDriverByClassName(config);
        return createDeviceByPlatformType(config, driver);
    }

    private Properties getConfigurationProperties(String deviceConfigFileName) throws IOException {
        Properties config = configLoader.loadConfig(deviceConfigFileName);
        return config;
    }

    private Driver instantiateDriverByClassName(Properties config) throws Exception {
        String dirverClassTypeName = config.getProperty("driver.class");
        Class<Driver> driverClassType = (Class<Driver>) Class.forName(dirverClassTypeName);
        Constructor<Driver> constructor = driverClassType.getConstructor(Properties.class);
        Driver driver = constructor.newInstance(config);
        return driver;
    }

    private Device createDeviceByPlatformType(Properties config, Driver driver) {
        Device device = null;
        String platform = config.getProperty("platform");
        switch (PLATFORM.valueOf(platform.toUpperCase())) {
            case ANDROID:
                device = new AndroidDevice(config, driver);
                break;
            case IOS:
                device = new IosDevice(config, driver);
                break;
        }
        return device;
    }

    public App instantiateApplicationByClassName(String appConfigFile, Device device) throws AppLaunchException, Exception {
        try {
            Properties config = getConfigurationProperties(appConfigFile);
            return FactoryTestSupport.this.instantiateApplicationByClassName(config, device);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new AppLaunchException("Unnable to instantiate the app: " + e.getMessage());
        }
    }

    private App instantiateApplicationByClassName(Properties config, Device device) throws Exception {
        String appClassTypeName = config.getProperty("mobileApp.class");
        Class<MobileApp> mobileAppClassType = (Class<MobileApp>) Class.forName(appClassTypeName);
        Constructor<MobileApp> constructor = mobileAppClassType.getConstructor(Properties.class, Device.class, FactoryTestSupport.class);
        return constructor.newInstance(config, device, this);
    }

    public User getUser(String fileName) throws IOException {
        Properties profileConfiguration = configLoader.loadConfig(fileName);
        return new GenericUser(profileConfiguration);
    }
    
}
