package junit.org.mandfer.mobile.automation.framework.commons.factory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import junit.org.mandfer.mobile.automation.framework.commons.JunitTestConstants;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mandfer.mobile.automation.framework.commons.app.App;
import org.mandfer.mobile.automation.framework.commons.app.MobileApp;
import org.mandfer.mobile.automation.framework.commons.config.ConfigLoader;
import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.exceptions.AppFactoryException;
import org.mandfer.mobile.automation.framework.commons.factory.Factory;
import org.mandfer.mobile.automation.framework.commons.guice.AppFactory;
import org.mandfer.mobile.automation.framework.commons.guice.AppFactoryGuice;
import org.mandfer.mobile.automation.framework.commons.guice.MAF_Module;

import java.io.IOException;
import java.util.Properties;

import static junit.org.mandfer.mobile.automation.framework.commons.JunitTestConstants.TEST_APP_SAMPLE_FILE_NAME;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author marcandreuf
 */
public class GuiceAppFactoryTest {

    private Device mocked_device;
    private ConfigLoader mocked_configLoader;
    private Properties mocked_config;
    private Factory mocked_factory;
    private AppFactory appFactory;

    @Before
    public void setUp(){
        mocked_device = mock(Device.class);
        mocked_configLoader = mock(ConfigLoader.class);
        mocked_config = mock(Properties.class);
        mocked_factory = mock(Factory.class);
        appFactory = new AppFactoryGuice(mocked_configLoader, mocked_factory);
    }

    @Test
    public void createMobileAppFromConfigFileNameWithGuice() throws Exception {
        Injector injector = Guice.createInjector(new MAF_Module());
        AppFactory appFactory = injector.getInstance(AppFactoryGuice.class);

        App mobApp = appFactory.create(
                JunitTestConstants.TEST_APP_SAMPLE_FILE_NAME, mocked_device);

        assertTrue(mobApp != null && mobApp instanceof MobileApp);
    }


    @Test
    public void testAppFactoryBehaviour() throws Exception {
        App app = appFactory.create(TEST_APP_SAMPLE_FILE_NAME, mocked_device);

        when(mocked_configLoader.loadConfig(TEST_APP_SAMPLE_FILE_NAME))
                .thenReturn(mocked_config);

        verify(mocked_configLoader).loadConfig(TEST_APP_SAMPLE_FILE_NAME);
        assertTrue(app instanceof MobileApp);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFailLoadingWrongConfigFile() throws Exception {

        when(mocked_configLoader.loadConfig(TEST_APP_SAMPLE_FILE_NAME)).thenThrow(IOException.class);

        expectedException.expect(AppFactoryException.class);
        expectedException.expectMessage(containsString("Unable to load " + TEST_APP_SAMPLE_FILE_NAME));

        appFactory.create(TEST_APP_SAMPLE_FILE_NAME, mocked_device);
    }
}
