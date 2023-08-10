import io.appium.java_client.AppiumBy
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class AppleSearchTest: BaseTest() {
    override var caps: DesiredCapabilities? = Caps.AndroidBaseCapabilities()
    @Test
    fun wikiAppTestApple() {

        val searchElement = WebDriverWait(driver, Duration.ofSeconds(30)).until(
            ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Search Wikipedia"))
        ) as WebElement

        searchElement.click()
        val insertTextElement = WebDriverWait(driver, Duration.ofSeconds(30)).until(
            ExpectedConditions.elementToBeClickable(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
        ) as WebElement
        insertTextElement.sendKeys("Apple")
        Thread.sleep(5000)

    }
}