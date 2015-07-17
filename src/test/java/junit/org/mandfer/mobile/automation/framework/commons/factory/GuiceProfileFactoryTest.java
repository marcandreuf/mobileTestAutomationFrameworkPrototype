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
import org.mandfer.mobile.automation.framework.commons.exceptions.AppFactoryException;
import org.mandfer.mobile.automation.framework.commons.exceptions.ProfileFactoryException;
import org.mandfer.mobile.automation.framework.commons.guice.MAF_Module;
import org.mandfer.mobile.automation.framework.commons.guice.ProfileFactory;
import org.mandfer.mobile.automation.framework.commons.guice.ProfileFactoryGuice;
import org.mandfer.mobile.automation.framework.commons.profile.GenericProfile;
import org.mandfer.mobile.automation.framework.commons.profile.Profile;

import java.io.IOException;
import java.util.Properties;

import static junit.org.mandfer.mobile.automation.framework.commons.JunitTestConstants.TEST_APP_SAMPLE_FILE_NAME;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author marcandreuf
 */
public class GuiceProfileFactoryTest {

    private ConfigLoader mocked_configLoader;
    private Properties mocked_config;
    private ProfileFactory profileFactory;

    @Before
    public void setUp(){
        mocked_configLoader = mock(ConfigLoader.class);
        mocked_config = mock(Properties.class);
        profileFactory = new ProfileFactoryGuice(mocked_configLoader);
    }

    @Test
    public void createMobileProfileFromConfigFileNameWithGuice() throws Exception {
        Injector injector = Guice.createInjector(new MAF_Module());
        ProfileFactory profileFactory = injector.getInstance(ProfileFactoryGuice.class);

        Profile profile = profileFactory.create(
                JunitTestConstants.TEST_APP_SAMPLE_FILE_NAME);

        assertTrue(profile != null && profile instanceof GenericProfile);
    }


    @Test
    public void testProfileFactoryBehaviour() throws Exception {
        Profile profile = profileFactory.create(TEST_APP_SAMPLE_FILE_NAME);

        when(mocked_configLoader.loadConfig(TEST_APP_SAMPLE_FILE_NAME))
                .thenReturn(mocked_config);

        verify(mocked_configLoader).loadConfig(TEST_APP_SAMPLE_FILE_NAME);
        assertTrue(profile instanceof GenericProfile);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFailLoadingWrongConfigFile() throws Exception {

        when(mocked_configLoader.loadConfig(TEST_APP_SAMPLE_FILE_NAME))
                .thenThrow(IOException.class);

        expectedException.expect(ProfileFactoryException.class);
        expectedException.expectMessage(
                containsString("Unable to load " + TEST_APP_SAMPLE_FILE_NAME));

        profileFactory.create(TEST_APP_SAMPLE_FILE_NAME);
    }
}
