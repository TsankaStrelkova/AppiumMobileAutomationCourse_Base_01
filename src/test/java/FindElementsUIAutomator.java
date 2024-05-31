import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class FindElementsUIAutomator {

    // For reference check https://developer.android.com/reference/androidx/test/uiautomator/BySelector
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        // Finding element using UiSelector().text()
        String text = "new UiSelector().text(\"Accessibility\")";

        WebElement element1 = driver.findElement(AppiumBy.androidUIAutomator(text));

        System.out.println("Element found with text " + element1.getText());

        // Finding element using UiSelector().textContains()
        String textContains = "new UiSelector().textContains(\"Pref\")";

        WebElement element2 = driver.findElement(AppiumBy.androidUIAutomator(textContains));

        System.out.println("Element found with text " + element2.getText());


        // Finding element using UiSelector().checked()
        String checked = "new UiSelector().checked(false)";

        WebElement element3 = driver.findElement(AppiumBy.androidUIAutomator(checked));

        System.out.println("Element found with text " + element3.getText());

    }
}
