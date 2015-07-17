package org.mandfer.mobile.automation.framework.commons.guice;

import com.google.inject.Inject;

import java.io.IOException;
import java.util.Properties;

import org.mandfer.mobile.automation.framework.android.device.AndroidDevice;
import org.mandfer.mobile.automation.framework.commons.config.ConfigLoader;
import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.driver.Driver;
import org.mandfer.mobile.automation.framework.commons.exceptions.DeviceFactoryException;
import org.mandfer.mobile.automation.framework.ios.device.IosDevice;

/**
 * @author marcandreuf
 */
public class DeviceFactoryGuice implements DeviceFactory {

    private final ConfigLoader configLoader;
    private final DriverFactory driverFactory;

    @Inject
    public DeviceFactoryGuice(
            ConfigLoader configLoader,
            DriverFactory driverFactory) {
        this.configLoader = configLoader;
        this.driverFactory = driverFactory;
    }

    @Override
    public Device create(String configFileName) throws DeviceFactoryException {
        Properties config = null;
        try {
            config = configLoader.loadConfig(configFileName);
            String driverConfigFileName = config.getProperty(DRIVER_CONFIG_FILENAME);
            Driver driver = driverFactory.create(driverConfigFileName);
            return createDeviceByPlatformType(config, driver);
        } catch (IOException e) {
            throw new DeviceFactoryException("Unable to load "+configFileName
                       +". "+e.getMessage(), e);
        } catch (Exception e) {
            throw new DeviceFactoryException("Unable create a driver "+e.getMessage(), e);
        }
    }

    private Device createDeviceByPlatformType(Properties config, Driver driver) throws DeviceFactoryException {
        Device device = null;
        String platform = config.getProperty(DEVICE_PLATFORM);
        if(platform != null) {
            switch (Device.PLATFORM.valueOf(platform.toUpperCase())) {
                case ANDROID:
                    device = new AndroidDevice(config, driver);
                    break;
                case IOS:
                    device = new IosDevice(config, driver);
                    break;
            }
        }else{
            throw new DeviceFactoryException("Platform name not recognised in the device config file. ");
        }
        return device;
    }

}
