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
public class DriverAppiumImplTest extends DriverAppiumImpl {

    private static final String APP_IDENTIFIER = "appIdentifier";
    private static final String ELEM_IDENTIFIER = "sampleElementId";
    private static final int THREE = 3;
    private static final int LONG_TIMEOUT = 3000;

    private final String NON_DEFAULT_CLICK =
            "{"+DriverWrapper.PARAM_CLICKS+":"+ THREE +"}";
    private final String NON_DEFAULT_TIMEOUT =
            "{"+DriverWrapper.PARAM_TIMEOUT+":"+LONG_TIMEOUT+"}";

    private MobileElement mocked_sampleElement;

    /**
     * To avoid a second constructor to pass the Appium Driver as a mocked object.
     * This test class extends the class under test so we can assign the mocked driver and
     * do the verifications between the calls of the Driver interface calls and the external driver.
     */
    public DriverAppiumImplTest() {
        super(null);
    }

    @Before
    public void setUpDriver(){
        mocked_sampleElement = mock(MobileElement.class);
        this.config = mock(Properties.class);
        this.appiumDriver = mock(AppiumDriver.class);
    }

    @Test
    public void testInstallApplication() {
        this.installApplication(APP_IDENTIFIER);
        verify(appiumDriver).installApp(APP_IDENTIFIER);
        verifyNoMoreInteractions(appiumDriver);
    }

    @Test
    public void testSimpleClick(){
        when(appiumDriver.findElementById(ELEM_IDENTIFIER)).thenReturn(mocked_sampleElement);
        this.click(ELEM_IDENTIFIER);
        verify(appiumDriver).findElementById(ELEM_IDENTIFIER);
        verify(mocked_sampleElement).click();
        verifyNoMoreInteractions(appiumDriver);
    }

    @Test
    public void test(){
        //appiumDriver.findElementsByTagName()
    }


}
