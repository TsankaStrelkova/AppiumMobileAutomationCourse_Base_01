import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CreateDriverSessionUsingOptions {
    public static void main(String[] args) throws MalformedURLException {

//        // iOS
//        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "app" + File.separator + "UIKitCatalog-iphonesimulator.app";
//
//        XCUITestOptions options = new XCUITestOptions()
//                .setApp(appUrl)
//                .setAutomationName("XCUITest")
//                .setDeviceName("iPhone 15")
//                .setUdid("A996BD59-545C-42F5-955B-A83D08384CE3");
//
//        URL url = new URL("http://0.0.0.0:4723/wd/hub");
//        AppiumDriver driver = new IOSDriver(url, options);

        // Android

        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "app" + File.separator + "ApiDemos-debug.apk";
        UiAutomator2Options optionsA = new UiAutomator2Options()
                .setApp(appUrl)
                .setDeviceName("Pixel_6_Pro_API_34")
                .setAutomationName("UIAutomator2")
                .setAvd("Pixel_6_Pro_API_34")
                .setAvdReadyTimeout(Duration.ofMillis(24000))
                .setAvdLaunchTimeout(Duration.ofMillis(24000));

        URL appiumURL = new URL("http://0.0.0.0:4723/wd/hub");
        AppiumDriver driver = new AndroidDriver(appiumURL, optionsA);

    }

}
