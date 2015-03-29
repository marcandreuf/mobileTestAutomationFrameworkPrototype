package org.test.mobile.automation.framework.commons.guice;

import org.test.mobile.automation.framework.commons.device.Device;
import org.test.mobile.automation.framework.commons.driver.Driver;

/**
 * @author marcandreuf
 */
public interface DeviceFactory {

    public static final String DRIVER_CONFIG_FILENAME = "driver.config.filename";
    public static final String DEVICE_PLATFORM = "platform";

    public Device create(String configFilename) throws Exception;
}
