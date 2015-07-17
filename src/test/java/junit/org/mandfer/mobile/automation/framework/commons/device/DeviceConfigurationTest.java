package junit.org.mandfer.mobile.automation.framework.commons.device;

import org.mandfer.mobile.automation.framework.commons.device.Device;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import org.mandfer.mobile.automation.framework.android.device.AndroidDevice;
import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.driver.Driver;

/**
 *
 * @author marcandreuf
 */
public class DeviceConfigurationTest {

    private Properties mocked_config;
    private Driver mocked_driver;
    private Device device;

    @Before
    public void setUp() {
        mocked_config = mock(Properties.class);
        mocked_driver = mock(Driver.class);
        device = new AndroidDevice(mocked_config, mocked_driver);
    }

    @Test
    public void shouldGetTheNameFromProperties() {
        device.getName();

        verify(mocked_config).getProperty(Device.PROP_KEY_NAME);
        verifyZeroInteractions(mocked_driver);
    }

    @Test
    public void shouldGetThePlatformFromProperties() {
        when(mocked_config.getProperty(Device.PROP_KEY_PLATFORM))
                .thenReturn(Device.PLATFORM.ANDROID.toString());

        device.getPlatform();

        verify(mocked_config).getProperty(Device.PROP_KEY_PLATFORM);
        verifyZeroInteractions(mocked_driver);
    }

    @Test
    public void shouldGetTheVersionFromProperties() {
        device.getVersion();

        verify(mocked_config).getProperty(Device.PROP_KEY_VERSION);
        verifyZeroInteractions(mocked_driver);
    }

    @Test
    public void shouldGetTheDeviceUrlFromProperties() {
        device.getDeviceUrl();

        verify(mocked_config).getProperty(Device.PROP_KEY_DEVICE_URL);
        verifyZeroInteractions(mocked_driver);
    }

}
