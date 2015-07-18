package junit.org.mandfer.mobile.automation.framework.commons.driver;

import io.appium.java_client.AppiumDriver;
import org.junit.Before;
import org.junit.Test;
import org.mandfer.mobile.automation.framework.commons.driver.Driver;
import org.mandfer.mobile.automation.framework.commons.driver.DriverWrapper;

import java.io.IOException;
import java.util.Properties;
import org.mandfer.mobile.automation.framework.commons.driver.DriverAppiumImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author marcandreuf
 *
 * This is an example of how to test an implementation of a real third party driver.
 *
 */
public class AppiumDriverImplTest {

    private static final String APP_IDENTIFIER = "appIdentifier";
    private static final String ELEM_IDENTIFIER = "elemIndentifier";
    private static final int THREE = 3;
    private static final int LONG_TIMEOUT = 3000;


    private final String NON_DEFAULT_CLICK =
            "{"+DriverWrapper.PARAM_CLICKS+":"+ THREE +"}";
    private final String NON_DEFAULT_TIMEOUT =
            "{"+DriverWrapper.PARAM_TIMEOUT+":"+LONG_TIMEOUT+"}";

    private Properties mocked_properties;
    private AppiumDriver mocked_ApppiumDriver;
    private Driver driver;

    @Before
    public void setUpDriver(){
        mocked_properties = mock(Properties.class);
        mocked_ApppiumDriver = mock(AppiumDriver.class);
        driver = new DriverAppiumImpl(mocked_properties, mocked_ApppiumDriver);
    }

    @Test
    public void testInstallApplication() throws IOException {
        driver.installApplication(APP_IDENTIFIER);
        verify(mocked_ApppiumDriver).installApp(APP_IDENTIFIER);
        verifyNoMoreInteractions(mocked_ApppiumDriver);
    }

//    @Test
//    public void testInstallApplicationWithDriverSettings() throws IOException {
//        driver.installApplication(APP_IDENTIFIER, NON_DEFAULT_TIMEOUT);
//        verify(mocked_ApppiumDriver).install(APP_IDENTIFIER, LONG_TIMEOUT);
//        verifyNoMoreInteractions(mocked_ApppiumDriver);
//    }
//
//
//    @Test
//    public void testSimpleClick(){
//        driver.click(ELEM_IDENTIFIER);
//        verify(mocked_ApppiumDriver).click(ELEM_IDENTIFIER, Driver.DEFAULT_CLICK);
//        verifyNoMoreInteractions(mocked_ApppiumDriver);
//    }
//
//    @Test
//    public void testSimpleClickWithDriverSettings(){
//        driver.click(ELEM_IDENTIFIER, NON_DEFAULT_CLICK);
//        verify(mocked_ApppiumDriver).click(ELEM_IDENTIFIER, THREE);
//        verifyNoMoreInteractions(mocked_ApppiumDriver);
//    }
}
