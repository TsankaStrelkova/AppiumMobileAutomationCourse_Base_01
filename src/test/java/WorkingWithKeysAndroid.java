import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class WorkingWithKeysAndroid {

    // This class shows how to use Keyboard (instead of sendKeys) or it can be used to put app in background (Clicking HOME button)
    // or opening some native apps as CALENDAR
    // the code is based on lecture  120 in https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Click on Views
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        // Scroll by element (by size of list element on Views screen) until end of the screen
        WebElement listOnTheViewsScreen = driver.findElement(AppiumBy.id("android:id/list"));

        boolean canScrollMore = true;
        while (canScrollMore) {
            canScrollMore = MobileGesturesAndroid.scroll(driver, listOnTheViewsScreen, "down");

        }

        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
        Thread.sleep(2000);

        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).click();

        if (((AndroidDriver) driver).isKeyboardShown()) {
            ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
            ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.B));
        }

        ((AndroidDriver) driver).hideKeyboard();


    }


}
