import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.openqa.selenium.remote.DesiredCapabilities
import java.lang.Exception
import java.net.URL

open class BaseTest {
    protected var driver: AndroidDriver? = null
    protected open var caps: DesiredCapabilities? = null
    private val webDriverURL: URL = URL("http://127.0.0.1:4723/wd/hub")

    @BeforeEach
    fun setUp() {
        this.driver = AndroidDriver(webDriverURL, caps)
    }

    @AfterEach
    fun tearDown() {
        this.driver?.quit() ?: throw Exception("Driver instance was unable to quit.")
    }

}