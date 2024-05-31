import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class WorkingWithKeysiOS {

    // This class shows how to use Keyboard (instead of sendKeys)
    // the code is based on lecture  122 in https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/
    public static void main(String[] args) throws Exception {
        IOSDriver driver = (IOSDriver) CreateDriverSession.initializeDriver("iOS");

        driver.findElement(AppiumBy.accessibilityId("Text Fields")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Placeholder text\"`][1]")).click();

        // when text field is clicked the keyboard is expected to be shown
        // then all buttons of keyboard can be found in the XML of the page
        // in this way we will be able to click on buttons
        // For example if we like to type abc12
        driver.findElement(AppiumBy.accessibilityId("a")).click();
        driver.findElement(AppiumBy.accessibilityId("b")).click();
        driver.findElement(AppiumBy.accessibilityId("c")).click();
        driver.findElement(AppiumBy.accessibilityId("more")).click();
        driver.findElement(AppiumBy.accessibilityId("1")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();
        //driver.findElement(AppiumBy.accessibilityId("Done")).click();

        // To hide keyboard we can use hideKeyboard or click on Done button of the keyboard
        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }

    }
}
