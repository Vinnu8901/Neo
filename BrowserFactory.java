package base;

import com.microsoft.playwright.*;

public class BrowserFactory {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static Page initBrowser(String browserName) {
        playwright = Playwright.create();

        switch (browserName) {
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        }

        context = browser.newContext();
        page = context.newPage();
        return page;
    }

    public static void closeBrowser() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
