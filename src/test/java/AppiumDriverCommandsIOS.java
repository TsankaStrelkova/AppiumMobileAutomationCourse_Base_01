import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AppiumDriverCommandsIOS {

    // Here are shown methods to interact with app
    // Code is based on
    // https://appium.readthedocs.io/en/latest/en/writing-running-appium/ios/ios-xctest-mobile-apps-management/
    public static void main(String[] args) throws Exception {
        IOSDriver driver = (IOSDriver) CreateDriverSession.initializeDriver("iOS");
        // Finding element using type and name
        String textSelector = "type == 'XCUIElementTypeStaticText' AND name == 'Activity Indicators'";
        driver.findElement(AppiumBy.iOSNsPredicateString(textSelector)).click();
        System.out.println("AFTER DRIVER INITSIALIZATION AND ACTIVITY INDICATORS CLICK - APP STATUS " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));

        // Terminate app
        driver.terminateApp("com.example.apple-samplecode.UICatalog");
        System.out.println("AFTER TERMINATE - APP STATUS " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));

        // Activate app
        driver.activateApp("com.example.apple-samplecode.UICatalog");
        //activateApp(driver,"com.example.apple-samplecode.UICatalog");
        System.out.println("AFTER ACTIVATE - APP STATUS " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));

        // Install app
        String appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "app" + File.separator + "UIKitCatalog-iphonesimulator.app";
        driver.installApp(appPath); //installApp(driver, appPath);
        System.out.println("AFTER INSTALL - APP STATUS " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));

        // Activate
        driver.activateApp("com.example.apple-samplecode.UICatalog");//activateApp(driver, "com.example.apple-samplecode.UICatalog");
        System.out.println("AFTER ACTIVATE - APP STATUS " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));

        // Run app in background
        driver.runAppInBackground(Duration.ofSeconds(5));
        System.out.println("AFTER GOING IN BACKGROUND - APP STATUS " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));


        // Activate Settings app (bundle id can be taken from https://github.com/joeblau/apple-bundle-identifiers
        driver.activateApp("com.apple.Preferences");//activateApp(driver, "com.apple.Preferences");

        // Activate back UICatalog and then remove it
        driver.activateApp("com.example.apple-samplecode.UICatalog");//activateApp(driver, "com.example.apple-samplecode.UICatalog");

        driver.removeApp("com.example.apple-samplecode.UICatalog");
        System.out.println("AFTER REMOVE - APP STATUS " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));

        // Install app , activate it , open Activity indicators and then RESET app
        driver.installApp(appPath);
        System.out.println("AFTER INSTALL - APP STATUS " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));

        driver.activateApp("com.example.apple-samplecode.UICatalog");
        System.out.println("AFTER ACTIVATE - APP STATUS " + driver.queryAppState("com.example.apple-samplecode.UICatalog"));

    }


    // All code above can be refactored using following methods written based on
    //https://appium.readthedocs.io/en/latest/en/writing-running-appium/ios/ios-xctest-mobile-apps-management/
    public static void installApp(IOSDriver driver, String appPath) {
        Map<String, Object> params = new HashMap<>();
        params.put("app", appPath);
        driver.executeScript("mobile: installApp", params);
    }


    //mobile: launchApp
    //Executes an existing application on the device. If the application is already running then it will be brought to the foreground.
    //
    //Supported arguments
    //bundleId: The bundle identifier of the application, which is going to be executed. Mandatory argument.
    //arguments: The list of command line arguments. Optional.
    //environment: Environemnt variables mapping. Optional.

    public static void activateApp(IOSDriver driver, String bundleId) {
        Map<String, Object> params = new HashMap<>();
        params.put("bundleId", bundleId);
        driver.executeScript("mobile: activateApp", params);
    }

    // In the same manner we can write methods for app terminate, queryAppState...
}
