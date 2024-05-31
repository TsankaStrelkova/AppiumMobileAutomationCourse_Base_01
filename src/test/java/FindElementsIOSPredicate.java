import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class FindElementsIOSPredicate {

    // For reference https://learnautomation.medium.com/improving-appium-ios-automation-performance-by-replacing-xpaths-1f5d0217d9a
    //https://appium.github.io/appium-xcuitest-driver/4.19/ios-predicate/
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        // Finding element using type and name
        String textSelector = "type == 'XCUIElementTypeStaticText' AND name == 'Activity Indicators'";

        WebElement element1 = driver.findElement(AppiumBy.iOSNsPredicateString(textSelector));

        System.out.println("Element found with text " + element1.getText());

        // Finding element using type and label
        String chainedLocator = "type == 'XCUIElementTypeStaticText' AND label=='ActivityIndicatorViewController'";
        WebElement element2 = driver.findElement(AppiumBy.iOSNsPredicateString(chainedLocator));

        System.out.println("Element found with text " + element2.getText());

    }
}
