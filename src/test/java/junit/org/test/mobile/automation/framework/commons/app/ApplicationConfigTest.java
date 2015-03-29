package junit.org.test.mobile.automation.framework.commons.app;

import org.junit.Before;
import org.junit.Test;
import org.test.mobile.automation.framework.commons.app.App;
import org.test.mobile.automation.framework.commons.app.MobileApp;
import org.test.mobile.automation.framework.commons.device.Device;
import org.test.mobile.automation.framework.commons.factory.FactoryTestSupport;

import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


/**
 * 
 * @author marcandreuf
 */
public class ApplicationConfigTest {

    private final String SAMPLE_KEY = "testDataKey";

    private Device mocked_device;
    private Properties mocked_configApp;
    private FactoryTestSupport mocked_Factory;
    private App app;

    @Before
    public void setUp() {
        mocked_device = mock(Device.class);
        mocked_configApp = mock(Properties.class);
        mocked_Factory = mock(FactoryTestSupport.class);
        app = new MobileApp(mocked_configApp, mocked_device, mocked_Factory);
    }

    @Test
    public void shouldGetTheAppNameFromTheProperties() {
        app.getName();

        verify(mocked_configApp).getProperty(App.PROP_KEY_APPLICATION_NAME);
        zeroInteractionsWithOtherDependencies();
    }

    private void zeroInteractionsWithOtherDependencies() {
        verifyZeroInteractions(mocked_device);
        verifyZeroInteractions(mocked_Factory);
    }


    @Test
    public void shouldGetTheAppIdentifierFromTheProperties() {
        app.getAppIdentifier();

        verify(mocked_configApp).getProperty(App.PROP_KEY_APP_IDENTIFIER);
        zeroInteractionsWithOtherDependencies();
    }

    @Test
    public void shouldGetTheAppFullPathFromTheProperties() {
        app.getAppFullPath();

        verify(mocked_configApp).getProperty(App.PROP_KEY_PATH);
        zeroInteractionsWithOtherDependencies();
    }

    @Test
    public void shouldGetTheTimeoutFromTheProperties() {
        when(mocked_configApp.getProperty(App.PROP_KEY_TIMEOUT))
                .thenReturn("2000");

        app.getTimeout();

        verify(mocked_configApp).getProperty(App.PROP_KEY_TIMEOUT);
        zeroInteractionsWithOtherDependencies();
    }

    @Test
    public void shouldGetTheReportPathFromTheProperties() {
        app.getReportPath();

        verify(mocked_configApp).getProperty(App.PROP_KEY_REPORT_PATH);
        zeroInteractionsWithOtherDependencies();
    }

    @Test
    public void shouldGetTheLiteralFromTheProperties() {
        app.getLiteral(SAMPLE_KEY);

        verify(mocked_configApp).getProperty(SAMPLE_KEY);
        zeroInteractionsWithOtherDependencies();
    }

    @Test
    public void shouldGetTheTestDataFromTheProperties() {
        app.getTestData(SAMPLE_KEY);

        verify(mocked_configApp).getProperty(SAMPLE_KEY);
        zeroInteractionsWithOtherDependencies();
    }

    @Test
    public void shouldGetTheTestDataListFromTheProperties() {
        when(mocked_configApp.getProperty(SAMPLE_KEY)).thenReturn("1200,1201,1202,1203");

        List<String> listSample = app.getTestDataList(SAMPLE_KEY);

        verify(mocked_configApp).getProperty(SAMPLE_KEY);
        assertTrue(listSample.contains("1200"));
        assertTrue(listSample.contains("1201"));
        assertTrue(listSample.contains("1202"));
        assertTrue(listSample.contains("1203"));
        zeroInteractionsWithOtherDependencies();
    }

}
