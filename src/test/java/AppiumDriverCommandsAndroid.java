import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.appmanagement.AndroidTerminateApplicationOptions;

import java.time.Duration;

public class AppiumDriverCommandsAndroid {

    // Methods below shows how to interact with app
    // They are written using https://github.com/appium/appium-uiautomator2-driver (Platform-Specific Extensions)
    // and https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/ lecture 118
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();


        // Put app in background for 6 sec
        putAppInBackgroundForTime(driver, 6);


        // Terminate app
        String demoAppBundle = "io.appium.android.apis";
        terminateApp(driver, demoAppBundle);
        System.out.println("APP STATE " + ((AndroidDriver) driver).queryAppState(demoAppBundle));

        // Activate settings app
        String settingsAppId = "io.appium.android.apis";
        activateApp(driver, settingsAppId);


        // Activate again demo app
        activateApp(driver, demoAppBundle);

        // Take app state
        System.out.println("APP STATE " + ((AndroidDriver) driver).queryAppState(demoAppBundle));


//
//        // Activate app
//        activateApp(driver,demoAppBundle );


//        // Install app
//        String appUrlAndroid = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator +"app" + File.separator +"ApiDemos-debug.apk";
//        installApp(driver, appUrlAndroid);
//
//        // Remove app
//        System.out.println("APP is removed "  + removeApp(driver, demoAppBundle));
//
//
//        // Check if app is installed
//        boolean isAppInstalled = isAppInstalled(driver, demoAppBundle);
//        System.out.println("IS DEMO APP INSTALLED " + isAppInstalled);
//
//        // Install app
//        installApp(driver, appUrlAndroid);
//
//        // Check if app is installed
//        isAppInstalled = isAppInstall(driver, demoAppBundle);
//        System.out.println("IS DEMO APP INSTALLED " + isAppInstalled);

    }


    // Methods below are written using https://github.com/appium/appium-uiautomator2-driver (Platform-Specific Extensions)
    // and https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/ lecture 118

    public static void terminateApp(AppiumDriver driver, String appBundle) {
        ((AndroidDriver) driver).terminateApp(appBundle, new AndroidTerminateApplicationOptions().withTimeout(Duration.ofMillis(1000)));
    }

    public static void installApp(AppiumDriver driver, String appUrl) {
        // install with some options
        ((AndroidDriver) driver).installApp(appUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());
        // install without options
        //((AndroidDriver) driver).installApp(appUrl);
    }

    public static boolean isAppInstalled(AppiumDriver driver, String appBundle) {
        return ((AndroidDriver) driver).isAppInstalled(appBundle);
    }


    public static boolean removeApp(AppiumDriver driver, String appPackage) {
        boolean removed = (boolean) driver.executeScript("mobile: removeApp", ImmutableMap.of(
                "appId", appPackage
        ));
        return removed;
    }

    public static boolean isAppInstall(AppiumDriver driver, String appId) {
        boolean installed = (boolean) driver.executeScript("mobile: removeApp", ImmutableMap.of(
                "appId", appId));
        return installed;
    }

    //mobile: activateApp
    //Activates the given application or launches it if necessary. The action literally simulates clicking the corresponding application icon on the dashboard.
    public static void activateApp(AppiumDriver driver, String appId) {
        driver.executeScript("mobile: activateApp", ImmutableMap.of(
                "appId", appId));
    }

    public static void putAppInBackgroundForTime(AppiumDriver driver, int sec) {
        ((AndroidDriver) driver).runAppInBackground(Duration.ofSeconds(sec));
    }


    public void takeAppState(AppiumDriver driver, String appId) {
        ((AndroidDriver) driver).queryAppState(appId);
    }

}
