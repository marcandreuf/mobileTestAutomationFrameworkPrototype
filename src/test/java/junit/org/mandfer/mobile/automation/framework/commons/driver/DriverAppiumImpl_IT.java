package junit.org.mandfer.mobile.automation.framework.commons.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Before;
import org.junit.Test;
import org.mandfer.mobile.automation.framework.commons.driver.Driver;
import org.mandfer.mobile.automation.framework.commons.driver.DriverWrapper;

import java.io.IOException;
import java.util.Properties;
import org.mandfer.mobile.automation.framework.commons.driver.DriverAppiumImpl;

import static org.mockito.Mockito.*;

/**
 * @author marcandreuf
 *
 * This is an example of how to test an implementation of a real third party driver.
 *
 */
public class DriverAppiumImpl_IT {

    private DriverAppiumImpl driver;    

    @Test
    public void createAppiumAndroidDriver(){
        // TODO: 
        // 1. Add apache commons configuration
        // 2. Load configuration from driver_android_test.properties.
        // 3. Instantiate Driver
        driver = new DriverAppiumImpl(mocked_config, mocked_appiumDriver);
        // 4. Verify Driver
    }
    
    //TODO: Set of Appium learning tests to check how the driver actually works.

    
    /**
     * 1. Configuration app, device, driver is in different files and the appium
     * driver capabilities requires values from all of them.
     * 
     * How to get values from app.props and device.props when creating the driver ?
     * 
     * 
     * 2. How to abstract driver specific options between page objects and driver ?
     * a. Create a new interface DriverOption and create ... 
     */
    

}
