package InsertPackeName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccessRegistrationFormTest {
    private static final String NEW_YORK_TIMES_URL = "https://www.nytimes.com";

    public static void main(String[] args) {
        	WebDriver driver = initializeWebdriver();
            driver.get(NEW_YORK_TIMES_URL);
            driver.manage().window().maximize();

            WebElement loginButton = driver.findElement(By.xpath("//button[@data-testid=\"login-button\"]"));
            loginButton.click();

            WebElement createAccountAnchor = driver.findElement(By.xpath("//a[@data-testid=\"switch-to-register\"]"));
            createAccountAnchor.click();

            String expectedTitle = "Create account - The New York Times";
            String actualTitle = driver.getTitle();

            if (expectedTitle.equals(actualTitle)) {
                System.out.println("Registration form successfully opened");
            } else {
                System.out.println("Registration form not accessed");
            }
         // close the web browser
            driver.close();
            System.out.println("Test script executed successfully.");
        }
    

    private static WebDriver initializeWebdriver() {
        System.setProperty("webdriver.chrome.driver", "InsertChromeDriverPath");
        return new ChromeDriver();
    }
}
