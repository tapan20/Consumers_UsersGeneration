
    
package users.maven.users;


import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Users {


    static By inbox = By.xpath("//*[@id=\"addOverlay\"]");


    static By go = By.xpath("//*[@id=\"go-to-public\"]");


    static By mail = By.xpath("//td[contains(text(), \"no-reply@verificationemail.com\")]");


    static By verifyEmailURL = By.xpath(
            "/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/span/a");


    static By signUpText = By.xpath(
            "//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/form/div[4]/div[2]/span[2]/span");


    static By signupEmail = By.xpath("//*[@id=\"signup-email\"]");


    static By signupPassword = By.xpath("//*[@id=\"signup-password\"]");


    static By termsOfServiceCheckBox = By.xpath("//*[@id=\"terms\"]");


    static By createAccBtn = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div[2]/div/div/div[2]/form/div[4]");


    protected static String getSaltString() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000000);
        String email_id = randomInt + "_pentair";
        System.out.println(email_id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return email_id.toString();


    }


    // TC = 2
    // 1. Open the Mailinator in Chrome browser.
    // 2. Enter the email address that was used while signing up.
    // 3. Verify the user


    public static void main(String args[]) throws Exception {


        for (int i = 0; i < 30; i++) {


            String signupUser = getSaltString() + "@mailinator.com";
            System.out.println(signupUser);


            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");


            WebDriver chromeDriver;


            chromeDriver = new ChromeDriver();


            chromeDriver.manage().window().maximize();
            chromeDriver.manage().deleteAllCookies();
            Thread.sleep(2500);


            chromeDriver.findElement(signUpText).click();
            Thread.sleep(2000);


            chromeDriver.findElement(signupEmail).click();
            chromeDriver.findElement(signupEmail).sendKeys(signupUser);


            Thread.sleep(1500);


            chromeDriver.findElement(signupPassword).click();
            chromeDriver.findElement(signupPassword).sendKeys("Password@123");


            Thread.sleep(1500);


            chromeDriver.findElement(termsOfServiceCheckBox).click();


            Thread.sleep(1000);


            chromeDriver.findElement(createAccBtn).click();


            Thread.sleep(2500);


            String url = "https://www.mailinator.com";


            chromeDriver.get(url);
            // String link = "window.open('https://www.mailinator.com','_blank');";
            // ((JavascriptExecutor) driver).executeScript(link);


            // ((JavascriptExecutor) driver).executeScript("window.open()");


            Thread.sleep(7000);
            chromeDriver.findElement(inbox).sendKeys(signupUser);


            Thread.sleep(2000);
            chromeDriver.findElement(go).click();


            Thread.sleep(3000);


            chromeDriver.findElement(mail).click();


            Thread.sleep(9000);


            chromeDriver.switchTo().frame("msg_body");


            // WebElement verifyEmail = driver.findElement(By.xpath(
            // "//*[@id=\"msg_body\"]/html/table/table/table/table/table/table/table/table[2]/table/tbody/tr/td/a"));
            //


            WebElement verifyEmail = chromeDriver.findElement(By.xpath(
                    "/html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/span/a"));


            Actions ob = new Actions(chromeDriver);
            ob.click(verifyEmail);


            chromeDriver.get(verifyEmail.getAttribute("href"));


            // verifyEmail.click();


            Thread.sleep(2500);
            System.out.println("List of Users" + signupUser);


            chromeDriver.close();


        }
    }


}
 



















































