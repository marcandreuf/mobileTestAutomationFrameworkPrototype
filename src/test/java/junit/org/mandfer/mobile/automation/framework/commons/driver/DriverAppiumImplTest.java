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
public class DriverAppiumImplTest {

    private static final String APP_IDENTIFIER = "appIdentifier";
    private static final String ELEM_IDENTIFIER = "sampleElementId";
    private static final int THREE = 3;
    private static final int LONG_TIMEOUT = 3000;

    private final String NON_DEFAULT_CLICK =
            "{"+DriverWrapper.PARAM_CLICKS+":"+ THREE +"}";
    private final String NON_DEFAULT_TIMEOUT =
            "{"+DriverWrapper.PARAM_TIMEOUT+":"+LONG_TIMEOUT+"}";

    private MobileElement mocked_sampleElement;
    private Properties mocked_config;
    private AppiumDriver mocked_appiumDriver;
    private DriverAppiumImpl driver;
    
    

    @Before
    public void setUpDriver(){
        mocked_sampleElement = mock(MobileElement.class);
        mocked_config = mock(Properties.class);
        mocked_appiumDriver = mock(AppiumDriver.class);
        driver = new DriverAppiumImpl(mocked_config, mocked_appiumDriver);
    }

    @Test
    public void testInstallApplication() {
        driver.installApplication(APP_IDENTIFIER);
        verify(mocked_appiumDriver).installApp(APP_IDENTIFIER);
        verifyNoMoreInteractions(mocked_appiumDriver);
    }

    @Test
    public void testSimpleClick(){
        when(mocked_appiumDriver.findElementById(ELEM_IDENTIFIER)).thenReturn(mocked_sampleElement);
        driver.click(ELEM_IDENTIFIER);
        verify(mocked_appiumDriver).findElementById(ELEM_IDENTIFIER);
        verify(mocked_sampleElement).click();
        verifyNoMoreInteractions(mocked_appiumDriver);
    }

    @Test
    public void test(){
        //appiumDriver.findElementsByTagName()
    }


}
