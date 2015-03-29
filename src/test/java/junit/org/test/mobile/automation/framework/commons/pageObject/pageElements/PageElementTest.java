package junit.org.test.mobile.automation.framework.commons.pageObject.pageElements;

import org.junit.Before;
import org.junit.Test;
import org.test.mobile.automation.framework.commons.device.Device;
import org.test.mobile.automation.framework.commons.pageObject.pageElements.Button;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author marcandreuf
 */
public class PageElementTest {

    private String sampleElemId;
    private Device mocked_device;
    private String mocked_options;
    private Button pageElement;


    @Before
    public void setUp(){
        sampleElemId = "sampleId";
        mocked_device = mock(Device.class);
        mocked_options = "{sampleOption:1}";
        pageElement = new Button(mocked_device, sampleElemId, mocked_options);
    }


    @Test
    public void shouldReturnElementId(){
        assertTrue(pageElement.getElemId().equals(sampleElemId));
    }

    @Test
    public void shouldCallDeviceClickMethod(){
        pageElement.click();
        verify(mocked_device).click(sampleElemId, mocked_options);
    }

    @Test
    public void shouldCallDeviceClickMethodWithSpecificOptions(){
        String[] special_options = new String[1];
        pageElement.click(special_options);
        verify(mocked_device).click(sampleElemId, special_options);
    }

    @Test
    public void shouldCallDeviceIsElementFoundMethod(){
        pageElement.isVisible();
        verify(mocked_device).isElementFound(sampleElemId, mocked_options);
    }

    @Test
    public void shouldCallDeviceGetElementPropertyMethod(){
        pageElement.isEnabled();
        verify(mocked_device).getElementProperty(sampleElemId, "enabled", mocked_options);
    }

    @Test
    public void shouldCallDeviceWaitToAppearMethod(){
        pageElement.waitToAppear(1000);
        verify(mocked_device).waitToAppear(sampleElemId, "{timeout:"+1000+"}");
    }

    @Test
    public void shouldCallDeviceWaitToVanishMethod(){
        pageElement.waitToVanish(1000);
        verify(mocked_device).waitToVanish(sampleElemId, "{timeout:" + 1000 + "}");
    }

    @Test
    public void shouldCallDeviceVerifyMethod(){
        pageElement.verify();
        verify(mocked_device).verify(sampleElemId, mocked_options);
    }

    @Test
    public void shouldCallDevicegetElementTextMethod(){
        pageElement.getText();
        verify(mocked_device).getElementText(sampleElemId, mocked_options);
    }

    @Test
    public void shouldCallDeviceDragMethod(){
        pageElement.drag(100, 200);
        verify(mocked_device).drag(sampleElemId, 100, 200, mocked_options);
    }

    @Test
    public void shouldCallDeviceSwipeOnElementMethod(){
        pageElement.swipe("up", 100, 200);
        verify(mocked_device).swipeOnElement(sampleElemId, "up", 100, 200, mocked_options);
    }

}
