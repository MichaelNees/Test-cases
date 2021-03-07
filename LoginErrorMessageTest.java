package InsertPackeName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginErrorMessageTest {

    private static final String NEW_YORK_TIMES_URL = "https://myaccount.nytimes.com/auth/login?response_type=cookie&client_id=vi&redirect_uri=https%3A%2F%2Fwww.nytimes.com%2Fsubscription%2Fmultiproduct%2Flp8KQUS.html%3FcampaignId%3D7JFJX%26EXIT_URI%3Dhttps%253A%252F%252Fwww.nytimes.com%252F&asset=masthead";

    public static void main(String[] args) {
        	WebDriver driver = initializeWebdriver();
            driver.get(NEW_YORK_TIMES_URL);
            driver.manage().window().maximize();

            WebElement loginButton = driver.findElement(By.xpath("//button[@data-testid=\"login-button\"]"));
            loginButton.click();

            String emailAddressErrorMessage = driver.findElement(By.id("err-id-username")).getText();
            String expectedErrorMessage = "Please enter your username or email address.";

            if (emailAddressErrorMessage.equals(expectedErrorMessage)) {
                System.out.println("Error Message text ok");
            } else {
                System.out.println("Error message text not ok");
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
