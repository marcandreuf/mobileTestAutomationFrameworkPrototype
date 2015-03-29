package org.test.mobile.automation.framework.commons.guice;

import org.test.mobile.automation.framework.commons.driver.Driver;

/**
 * @author marcandreuf
 */
public interface DriverFactory {

    public static final String DRIVER_CLASS_NAME = "driver.class";

    public Driver create(String configFilename) throws Exception;
}
