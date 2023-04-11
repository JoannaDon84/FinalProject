package pl.coderslab.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sk.Tak;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v110.indexeddb.model.Key;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class BuyAProduct {
    private WebDriver driver;

    @Given("I am on a main page")
    public void iAmOnAMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/");
    }

    @When("I login to account created in First Task")
    public void iLoginToAccountCreatedInFirstTask() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("hdjnrpzzteqdihfcac@bbitq.com", "KlauN2828!");
    }


    @And("I choose a product")
    public void iChooseAProduct() {
//        WebElement clothesDropdownList = driver.findElement(By.id("dropdown-item"));
//        Select clothesDropDownList = new Select(clothesDropdownList);
//        clothesDropDownList.selectByVisibleText("Women");
        driver.findElement(By.name("s")).clear();
        driver.findElement(By.name("s")).sendKeys("Hummingbird Printed Sweater");
        driver.findElement(By.name("s")).submit();
        driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article")).click();
    }


    @Then("I choose {string}")
    public void iChoose(String size) {
        WebElement sizeDropdownList = driver.findElement(By.className("form-control-select"));
        Select sizeDropDownList = new Select(sizeDropdownList);
        sizeDropDownList.selectByVisibleText(size);

    }

    @And("I choose {string} of product")
    public void iChooseOfProduct(String number) {
        driver.findElement(By.id("quantity_wanted"));

        driver.findElement(By.id("quantity_wanted")).sendKeys(number + Keys.DELETE);
    }

    @And("I add this products to a cart")
    public void iAddThisProductsToACart() {
        driver.findElement(By.cssSelector("button.add-to-cart")).click();
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")).click();
    }

    @Then("I confirm an address")
    public void iConfirmAnAddress() {
        driver.findElement(By.name("confirm-addresses")).click();
    }

    @And("I choose delivery method")
    public void iChooseDeliveryMethod() {
        driver.findElement(By.id("delivery_option_8")).sendKeys(Keys.ENTER);
    }

    @And("I confirm delivery")
    public void iConfirmDelivery() {
        driver.findElement(By.name("confirmDeliveryOption")).click();
    }

    @And("I choose the payment method")
    public void iChooseThePaymentMethod() {
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/div[1]/section[4]/div/div[2]/div[1]/div/span/input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.cssSelector("button.btn.btn-primary.center-block")).click();

    }

    @And("I take a screenshot of confirmation")
    public void iMakeAScreenshotOfConfirmation() {

        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Call getScreenshotAs method to create image file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Create destination file path
//        LocalTime currentTime = LocalTime.now();
//        String currentTimeString = currentTime.toString();
        String destFilePath = "C:/Users/joann/Praca-Koncowa z page object/src/screenshots/screenshot" +  ".png";

// Copy file to destination folder
        try {
            FileHandler.copy(srcFile, new File(destFilePath));
            System.out.println("Screenshot saved at: " + destFilePath);
        } catch (IOException e) {
            System.out.println("Error occurred while saving screenshot: " + e.getMessage());
        }
    }


    @And("I quit the page")
    public void iQuitThePage() {
        driver.quit();
    }

}