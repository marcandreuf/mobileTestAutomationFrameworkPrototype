package junit.org.mandfer.mobile.automation.framework.commons.driver;

import org.junit.Before;
import org.junit.Test;
import org.mandfer.mobile.automation.framework.commons.driver.Driver;
import org.mandfer.mobile.automation.framework.commons.driver.SampleThirdPartyDriver;
import org.mandfer.mobile.automation.framework.commons.driver.ThirdPartyDriverWrapper;

import java.io.IOException;
import java.util.Properties;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author marcandreuf
 *
 * This is an example of how to test an implementation of a real third party driver.
 *
 */
public class SampleThirdPartyDriverWrapperTest {

    private static final String APP_IDENTIFIER = "appIdentifier";
    private static final String ELEM_IDENTIFIER = "elemIndentifier";
    private static final int THREE = 3;
    private static final int LONG_TIMEOUT = 3000;


    private final String NON_DEFAULT_CLICK =
            "{"+ThirdPartyDriverWrapper.PARAM_CLICKS+":"+ THREE +"}";
    private final String NON_DEFAULT_TIMEOUT =
            "{"+ThirdPartyDriverWrapper.PARAM_TIMEOUT+":"+LONG_TIMEOUT+"}";

    private Properties mocked_properties;
    private SampleThirdPartyDriver mocked_thirdPartyDriver;
    private Driver driver;

    @Before
    public void setUpDriver(){
        mocked_properties = mock(Properties.class);
        mocked_thirdPartyDriver = mock(SampleThirdPartyDriver.class);
        driver = new ThirdPartyDriverWrapper(mocked_properties, mocked_thirdPartyDriver);
    }

    @Test
    public void testInstallApplication() throws IOException {
        driver.installApplication(APP_IDENTIFIER);
        verify(mocked_thirdPartyDriver).install(APP_IDENTIFIER, Driver.DEFAULT_TIMEOUT);
        verifyNoMoreInteractions(mocked_thirdPartyDriver);
    }

    @Test
    public void testInstallApplicationWithDriverSettings() throws IOException {
        driver.installApplication(APP_IDENTIFIER, NON_DEFAULT_TIMEOUT);
        verify(mocked_thirdPartyDriver).install(APP_IDENTIFIER, LONG_TIMEOUT);
        verifyNoMoreInteractions(mocked_thirdPartyDriver);
    }


    @Test
    public void testSimpleClick(){
        driver.click(ELEM_IDENTIFIER);
        verify(mocked_thirdPartyDriver).click(ELEM_IDENTIFIER, Driver.DEFAULT_CLICK);
        verifyNoMoreInteractions(mocked_thirdPartyDriver);
    }

    @Test
    public void testSimpleClickWithDriverSettings(){
        driver.click(ELEM_IDENTIFIER, NON_DEFAULT_CLICK);
        verify(mocked_thirdPartyDriver).click(ELEM_IDENTIFIER, THREE);
        verifyNoMoreInteractions(mocked_thirdPartyDriver);
    }
}
