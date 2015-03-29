package junit.org.test.mobile.automation.framework.commons.device;

import java.util.Properties;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import org.test.mobile.automation.framework.android.device.AndroidDevice;
import org.test.mobile.automation.framework.commons.app.App;
import org.test.mobile.automation.framework.commons.app.InstalledApp;
import org.test.mobile.automation.framework.commons.app.MobileApp;
import org.test.mobile.automation.framework.commons.device.Device;
import org.test.mobile.automation.framework.commons.driver.Driver;

public class GenericDeviceTest {

    private final String SAMPLE_APP_IDENTIFIER = "url application identifier";
    
    private final App mocked_app = mock(MobileApp.class);
    private final Properties mocked_config = mock(Properties.class);
    private final Driver mocked_driver = mock(Driver.class);
    private Device device;

    private String identifier = "sampleId", sampleParameter = "sampleParameter";;
    private String sampleDriverConfigOption = "jsonSampleParam";
    private int sampleTimeout = 1000, sampleOffset =10;

    @Before
    public void setUp() {        
        Mockito.reset(mocked_app, mocked_config, mocked_driver);
        device = new AndroidDevice(mocked_config, mocked_driver);
    }

    @Test
    public void shouldCallTheDriverToInstallTheApp() throws Exception {
        when(mocked_app.getAppIdentifier()).thenReturn(SAMPLE_APP_IDENTIFIER);

        InstalledApp installedApp =  device.installApp(mocked_app);

        verify(mocked_app).getAppIdentifier();
        verify(mocked_driver).installApplication(SAMPLE_APP_IDENTIFIER);
        verifyNoMoreInteractions(mocked_driver);
        verifyZeroInteractions(mocked_app);
        verifyZeroInteractions(mocked_config);
        assertTrue(installedApp instanceof InstalledApp);
    }

    @Test
    public void shouldLaunchAnApplicationByItsUrlIdentifier() {
        when(mocked_app.getAppIdentifier()).thenReturn(SAMPLE_APP_IDENTIFIER);
        
        device.launch(mocked_app);

        verify(mocked_app).getAppIdentifier();
        verify(mocked_driver).launch(SAMPLE_APP_IDENTIFIER);
        verifyNoMoreInteractions(mocked_driver);
        verifyZeroInteractions(mocked_app);
        verifyZeroInteractions(mocked_config);
    }

    @Test
    public void shouldCloseApplicationByItsUrlIdentifier() {
        when(mocked_app.getAppIdentifier()).thenReturn(SAMPLE_APP_IDENTIFIER);

        device.close(mocked_app);

        verify(mocked_app).getAppIdentifier();
        verify(mocked_driver).closeApplication(SAMPLE_APP_IDENTIFIER);
        verifyNoMoreInteractions(mocked_driver);
        verifyZeroInteractions(mocked_app);
        verifyZeroInteractions(mocked_config);
    }

    @Test
    public void shouldCallDriverClickMethod(){
        device.click(identifier);
        verify(mocked_driver).click(identifier);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverVerifyFound(){
        device.verify(identifier);
        verify(mocked_driver).verifyElementFound(identifier);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverVerifyElementNotFound(){
        device.verifyNotFound(identifier);
        verify(mocked_driver).verifyElementNotFound(identifier);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverVerifyElementNotFoundWithOptionalParameters(){
        device.verifyNotFound(identifier, sampleDriverConfigOption);
        verify(mocked_driver).verifyElementNotFound(identifier, sampleDriverConfigOption);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverSendTextToThePage(){
        device.sendText(sampleParameter);
        verify(mocked_driver).sendText(sampleParameter);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverSendTextToAnElement(){
        device.sendTextTo(identifier, sampleParameter);
        verify(mocked_driver).sendTextTo(identifier, sampleParameter);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverIsElementFound(){
        device.isElementFound(identifier);
        verify(mocked_driver).isElementFound(identifier);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverIsElementFoundWithOptionalParameters(){
        device.isElementFound(identifier, sampleDriverConfigOption);
        verify(mocked_driver).isElementFound(identifier, sampleDriverConfigOption);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverWaitToAppear(){
        device.waitToAppear(identifier, sampleParameter);
        verify(mocked_driver).waitElemToAppear(identifier, sampleParameter);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverWaitToVanish(){
        device.waitToVanish(identifier, sampleParameter);
        verify(mocked_driver).waitElemToVanish(identifier, sampleParameter);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverGetElementTextContent(){
        device.getElementText(identifier);
        verify(mocked_driver).getElementText(identifier);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverGetElementTextContentWithOptionalParameters(){
        device.getElementText(identifier, sampleDriverConfigOption);
        verify(mocked_driver).getElementText(identifier, sampleDriverConfigOption);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverIsEnabledElement(){
        device.getElementProperty(identifier, sampleParameter);
        verify(mocked_driver).getElementProperty(identifier, sampleParameter);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverIsEnabledElementWithOptionalParameters(){
        device.getElementProperty(identifier, sampleParameter, sampleDriverConfigOption);
        verify(mocked_driver).getElementProperty(identifier, sampleParameter, sampleDriverConfigOption);
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverGetPageTextContent(){
        device.getPageTextContent();
        verify(mocked_driver).getElementHtmlContent("");
        verifyNoMoreInteractions(mocked_driver, mocked_app, mocked_config);
    }

    @Test
    public void shouldCallDriverDragDown(){
        int xOffset, yOffset;
        xOffset = 0;
        yOffset = -500;
        device.drag(identifier, xOffset, yOffset);
        verify(mocked_driver).dragElement(identifier, xOffset, yOffset);
    }

    @Test
    public void shouldCallDriverSwipeElement() {
        device.swipeOnElement(identifier, sampleParameter, sampleOffset, sampleTimeout);
        verify(mocked_driver).swipeElement(identifier, sampleParameter, sampleOffset, sampleTimeout);
    }

    @Test
    public void shouldCallDriverSwipe() {
        device.swipe(sampleParameter, sampleOffset, sampleTimeout);
        verify(mocked_driver).swipe(sampleParameter, sampleOffset, sampleTimeout);
    }

    @Test
    public void shouldGetTheTestDataFromTheProperties() {
        device.getTestData(sampleParameter);
        verify(mocked_config).getProperty(sampleParameter);
    }

}
