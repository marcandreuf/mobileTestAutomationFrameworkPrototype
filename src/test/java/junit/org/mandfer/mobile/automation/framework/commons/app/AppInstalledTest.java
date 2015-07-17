package junit.org.mandfer.mobile.automation.framework.commons.app;


import org.mandfer.mobile.automation.applications.sampleApp.pageObjects.PageObjectTemplate;
import org.junit.Before;
import org.junit.Test;
import org.mandfer.mobile.automation.framework.commons.app.App;
import org.mandfer.mobile.automation.framework.commons.app.InstalledApp;
import org.mandfer.mobile.automation.framework.commons.app.MobileApp;
import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.factory.FactoryTestSupport;

import java.util.Properties;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class AppInstalledTest {
	private Device mocked_device;
	private Properties mocked_configApp;
	private FactoryTestSupport mocked_Factory;
	private InstalledApp appInstalled;

	
	@Before
	public void setUp(){
		mocked_device = mock(Device.class);
		mocked_configApp = mock(Properties.class);
		mocked_Factory = mock(FactoryTestSupport.class);
		appInstalled = new MobileApp(mocked_configApp, mocked_device, mocked_Factory);
	}


	@Test
	public void shouldLaunchTheApplicationByCallingTheDeviceApi() throws Exception {
		String deviceUrl = "deviceUrl";
		String name = "name";

		when(mocked_device.getDeviceUrl()).thenReturn(deviceUrl);
		when(mocked_configApp.getProperty(App.PROP_KEY_APPLICATION_NAME)).thenReturn(name);

        PageObjectTemplate firstPageObject = appInstalled.launchTo(PageObjectTemplate.class);

		verify(mocked_device).launch((App) appInstalled);
        verifyNoMoreInteractions(mocked_device);
        verifyZeroInteractions(mocked_configApp);
        verifyZeroInteractions(mocked_Factory);
        assertTrue(firstPageObject instanceof PageObjectTemplate);
	}

    @Test
    public void shouldReturnAPageObjectInstance() throws Exception {
        PageObjectTemplate pageObject = appInstalled.onPage(PageObjectTemplate.class);
        assertTrue(pageObject instanceof PageObjectTemplate);
    }

}
