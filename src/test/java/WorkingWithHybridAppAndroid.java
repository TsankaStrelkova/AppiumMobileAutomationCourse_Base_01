import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WorkingWithHybridAppAndroid {
    public static void main(String[] args) throws Exception {
        // install Demo app
        AndroidDriver driver = (AndroidDriver) CreateDriverSession.initializeDriver("Android");

        // click on Views
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Animation")));

        // Scroll down to WebView
        WebElement scrollableList = driver.findElement(AppiumBy.id("android:id/list"));
        boolean canScrollMore = true;
        while (canScrollMore)
        {
           canScrollMore = (Boolean) (driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) scrollableList),
                    "direction", "down",
                    "percent", 1.0
            ));
        }

        // Click on WebView
        driver.findElement(AppiumBy.accessibilityId("WebView")).click();

        // Switch context
        Set<String> contexts = driver.getContextHandles();
        System.out.println("Contexts " + contexts);
        for (String con:contexts) {
            System.out.println("Context " + con);
            if (con.contains("WEBVIEW")) {
                driver.context(con);
                break;
            }
        }


        // Find elements on the webpage and interact with them
        WebElement textBox = driver.findElement(By.xpath("//input[@name=\"i_am_a_textbox\"]"));
        textBox.click();
        textBox.clear();
        textBox.sendKeys("1234");

    }
}
