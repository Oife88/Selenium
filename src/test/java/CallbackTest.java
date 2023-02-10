import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    }



    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTestSomething() throws InterruptedException {
    driver.get("http://localhost:9999/");
    driver.findElement(By.cssSelector("input[type=text]")).sendKeys("Иванов Василий");
    driver.findElement(By.cssSelector("input[type=tel]")).sendKeys("+79009990909");
    driver.findElement(By.tagName("label")).click();
    driver.findElement(By.className("button__text")).click();
    String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
    String actual = driver.findElement(By.tagName("p")).getText();
    assertEquals(expected, actual);

        }
}