package junit.org.test.mobile.automation.framework.commons.factory;

import com.google.inject.Guice;
import com.google.inject.Injector;

import static junit.org.test.mobile.automation.framework.commons.JunitTestConstants.TEST_SAMPLE_PROPS_FILE;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.mock;
import junit.org.test.mobile.automation.framework.commons.JunitTestConstants;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.test.mobile.automation.framework.commons.config.ConfigLoader;
import org.test.mobile.automation.framework.commons.driver.Driver;
import org.test.mobile.automation.framework.commons.driver.SampleThirdPartyDriver;
import org.test.mobile.automation.framework.commons.driver.ThirdPartyDriverWrapper;
import org.test.mobile.automation.framework.commons.exceptions.DriverFactoryException;
import org.test.mobile.automation.framework.commons.guice.DriverFactory;
import org.test.mobile.automation.framework.commons.guice.DriverFactoryGuice;
import org.test.mobile.automation.framework.commons.guice.MAF_Module;

import java.io.IOException;
import java.util.Properties;

/**
 * @author marcandreuf
 */
public class GuiceDirverFactoryTest {

    private ConfigLoader mocked_configLoader;
    private Properties mocked_config;
    private SampleThirdPartyDriver mocked_thirdPartyDriver;

    @Before
    public void setUp(){
        mocked_configLoader = mock(ConfigLoader.class);
        mocked_config = mock(Properties.class);
    }

    @Test
    public void createDriverGivenConfigFileName() throws Exception {
        Injector injector = Guice.createInjector(new MAF_Module());
        DriverFactory driverFactory = injector.getInstance(DriverFactory.class);

        Driver driver = driverFactory.create(
                JunitTestConstants.TEST_SAMPLE_PROPS_FILE);

        assertTrue(driver != null && driver instanceof Driver);
    }


    @Test
    public void testDriverFactoryBehaviour() throws Exception {
        DriverFactory driverFactory = new DriverFactoryGuice(mocked_configLoader);

        when(mocked_configLoader.loadConfig(TEST_SAMPLE_PROPS_FILE)).thenReturn(mocked_config);
        when(mocked_config.getProperty(DriverFactory.DRIVER_CLASS_NAME))
                .thenReturn(JunitTestConstants.SAMPLE_THIRD_PARTY_DRIVER_CLASS);

        Driver driver = driverFactory.create(TEST_SAMPLE_PROPS_FILE);

        verify(mocked_configLoader).loadConfig(TEST_SAMPLE_PROPS_FILE);
        verify(mocked_config).getProperty(DriverFactory.DRIVER_CLASS_NAME);
        assertTrue(driver instanceof ThirdPartyDriverWrapper);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFailToInstantiateAWrongDriverClass() throws Exception {
        DriverFactory driverFactory = new DriverFactoryGuice(mocked_configLoader);

        when(mocked_configLoader.loadConfig(TEST_SAMPLE_PROPS_FILE)).thenReturn(mocked_config);
        when(mocked_config.getProperty(DriverFactory.DRIVER_CLASS_NAME))
                .thenReturn("worngdriverclassname");

        expectedException.expect(DriverFactoryException.class);
        expectedException.expectMessage(containsString("Driver class error: "));

        driverFactory.create(TEST_SAMPLE_PROPS_FILE);
    }

    @Test
    public void testFailToLoadDriverConfigFile() throws Exception {
        DriverFactory driverFactory = new DriverFactoryGuice(mocked_configLoader);

        when(mocked_configLoader.loadConfig(TEST_SAMPLE_PROPS_FILE))
                .thenThrow(IOException.class);

        expectedException.expect(DriverFactoryException.class);
        expectedException.expectMessage(containsString("Config file name not found: "));

        driverFactory.create(TEST_SAMPLE_PROPS_FILE);
    }

}
