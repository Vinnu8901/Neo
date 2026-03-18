package hooks;

import base.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.capture(BrowserFactory.page, scenario.getName());
        }
        BrowserFactory.closeBrowser();
    }
}
