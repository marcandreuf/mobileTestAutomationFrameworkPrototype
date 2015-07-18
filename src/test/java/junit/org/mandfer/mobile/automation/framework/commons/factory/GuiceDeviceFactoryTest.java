package junit.org.mandfer.mobile.automation.framework.commons.factory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import junit.org.mandfer.mobile.automation.framework.commons.JunitTestConstants;
import static junit.org.mandfer.mobile.automation.framework.commons.JunitTestConstants.TEST_SAMPLE_PROPS_FILE;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mandfer.mobile.automation.framework.commons.config.ConfigLoader;
import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.driver.Driver;
import org.mandfer.mobile.automation.framework.commons.exceptions.DeviceFactoryException;
import org.mandfer.mobile.automation.framework.commons.guice.DeviceFactory;
import org.mandfer.mobile.automation.framework.commons.guice.DeviceFactoryGuice;
import org.mandfer.mobile.automation.framework.commons.guice.DriverFactory;
import org.mandfer.mobile.automation.framework.commons.guice.MAF_Module;
import org.mandfer.mobile.automation.framework.ios.device.IosDevice;

import java.io.IOException;
import java.util.Properties;
import org.junit.Ignore;

/**
 * @author marcandreuf
 */
public class GuiceDeviceFactoryTest {

    private ConfigLoader mocked_configLoader;
    private Properties mocked_config;
    private DriverFactory mocked_driverFactory;
    private Driver mocked_driver;
    private String sampleDriverFileName;

    @Before
    public void setUp(){
        mocked_configLoader = mock(ConfigLoader.class);
        mocked_config = mock(Properties.class);
        mocked_driverFactory = mock(DriverFactory.class);
        mocked_driver = mock(Driver.class);
        sampleDriverFileName = "sampleDriverPropsFileName";
    }

    @Test
    @Ignore //Fix Driver factory
    public void createDeviceFromConfigFileNameWithGuice() throws Exception {
        Injector injector = Guice.createInjector(new MAF_Module());
        DeviceFactoryGuice deviceFactory = injector.getInstance(DeviceFactoryGuice.class);

        Device device = deviceFactory.create(
                JunitTestConstants.TEST_DEVICE_PROPS_FILE);

        assertTrue(device != null && device instanceof Device);
        assertTrue(device.getDriver() != null);
    }


    @Test
    @Ignore //Fix Driver factory
    public void testDeviceFactoryBehaviour() throws Exception {
        DeviceFactory deviceFactory =
                new DeviceFactoryGuice(mocked_configLoader, mocked_driverFactory);

        when(mocked_configLoader.loadConfig(TEST_SAMPLE_PROPS_FILE))
                .thenReturn(mocked_config);
        when(mocked_config.getProperty(DeviceFactory.DRIVER_CONFIG_FILENAME))
                .thenReturn(sampleDriverFileName);
        when(mocked_driverFactory.create(sampleDriverFileName))
                .thenReturn(mocked_driver);
        when(mocked_config.getProperty(DeviceFactory.DEVICE_PLATFORM))
                .thenReturn(Device.PLATFORM.IOS.toString());

        Device device = deviceFactory.create(JunitTestConstants.TEST_SAMPLE_PROPS_FILE);

        verify(mocked_configLoader).loadConfig(TEST_SAMPLE_PROPS_FILE);
        verify(mocked_config).getProperty(DeviceFactory.DRIVER_CONFIG_FILENAME);
        verify(mocked_config).getProperty(DeviceFactory.DEVICE_PLATFORM);
        assertTrue(device instanceof IosDevice);


    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    @Ignore //Fix Driver factory
    public void testFailLoadingWrongConfigFile() throws Exception {
        DeviceFactory deviceFactory =
                new DeviceFactoryGuice(mocked_configLoader, mocked_driverFactory);

        when(mocked_configLoader.loadConfig(TEST_SAMPLE_PROPS_FILE))
                .thenThrow(IOException.class);

        expectedException.expect(DeviceFactoryException.class);
        expectedException.expectMessage(containsString("Unable to load " + TEST_SAMPLE_PROPS_FILE));

        deviceFactory.create(TEST_SAMPLE_PROPS_FILE);
    }

    @Test
    @Ignore //Fix Driver factory
    public void testFailLoadingWrongDriverClassName() throws Exception {
        DeviceFactory deviceFactory =
                new DeviceFactoryGuice(mocked_configLoader, mocked_driverFactory);

        when(mocked_configLoader.loadConfig(TEST_SAMPLE_PROPS_FILE))
                .thenReturn(mocked_config);
        when(mocked_config.getProperty(DeviceFactory.DRIVER_CONFIG_FILENAME))
                .thenReturn(sampleDriverFileName);
        when(mocked_driverFactory.create(sampleDriverFileName))
                .thenThrow(Exception.class);

        expectedException.expect(DeviceFactoryException.class);
        expectedException.expectMessage(containsString("Unable create a driver "));

        deviceFactory.create(TEST_SAMPLE_PROPS_FILE);
    }

    //TODO: Test WRong platform
    @Test
    @Ignore //Fix Driver factory
    public void testFailLoadingWrongPlatformName() throws Exception {
        DeviceFactory deviceFactory =
                new DeviceFactoryGuice(mocked_configLoader, mocked_driverFactory);

        when(mocked_configLoader.loadConfig(TEST_SAMPLE_PROPS_FILE))
                .thenReturn(mocked_config);
        when(mocked_config.getProperty(DeviceFactory.DRIVER_CONFIG_FILENAME))
                .thenReturn(sampleDriverFileName);
        when(mocked_driverFactory.create(sampleDriverFileName))
                .thenReturn(mocked_driver);
        when(mocked_config.getProperty(DeviceFactory.DEVICE_PLATFORM))
                .thenReturn(null);

        expectedException.expect(DeviceFactoryException.class);
        expectedException.expectMessage(
                containsString("Platform name not recognised in the device config file. "));

        deviceFactory.create(TEST_SAMPLE_PROPS_FILE);
    }

}
