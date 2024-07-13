package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;

public class LoginToOragehrm {
	WebDriver driver;
	@Given("launch the browser")
	public void launch_the_browser() {
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	}

	@Given("enter credentials")
	public void enter_credentials() throws InterruptedException 
	{
	driver.manage().window().maximize();
	driver.get("https://services.gst.gov.in/services/login");
	
        driver.manage().deleteAllCookies();

        // Wait for 40 seconds
        Thread.sleep(40000);

        // Click submit button
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']")); // Replace with actual locator
        loginButton.click();
     // Get text from profile
        
//        WebElement profileNameElement = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[1]")); // Replace with actual locator
//        String profileName = profileNameElement.getText().trim();
//        System.out.println("PROFILENAME: " + profileName);

        
        Thread.sleep(3000);
        // Click on profile dropdown
        WebElement profileDropdown = driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[1]")); // Replace with actual locator
        profileDropdown.click();

        // Wait for 1 second
        Thread.sleep(1000);

//        // Click on My Profile
        WebElement myProfile = driver.findElement(By.xpath("//a[normalize-space()='My Profile']")); // Replace with actual locator
        myProfile.click();

        // Wait for 1 second
        Thread.sleep(1000);

//         Click on Manage API Access Link
        WebElement manageAPIaccessLink = driver.findElement(By.xpath("(//a[text()='Manage API Access'])[1]")); // Replace with actual locator
        manageAPIaccessLink.click();

        // Wait for 1 second
        Thread.sleep(1000);

        // Click on Yes
//        WebElement accessYES = driver.findElement(By.xpath("//label[normalize-space()='Yes']")); // Replace with actual locator
//        accessYES.click();

        // Wait for 1 second
        Thread.sleep(1000);

        // Click on Duration Dropdown
        WebElement durationDropdown = driver.findElement(By.xpath("//select[@id='districts']")); // Replace with actual locator
        durationDropdown.click();

        // Wait for 1 second
        Thread.sleep(1000);

        // Select 30 days from dropdown
        WebElement selectThirtyDays = driver.findElement(By.xpath("//select/option[normalize-space()='30 days']")); // Replace with actual locator
        selectThirtyDays.click();

        // Wait for 1 second
        Thread.sleep(1000);

        // Click on Continue Button
        WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit']")); // Replace with actual locator
        continueButton.click();

        // Wait for 1 second
        Thread.sleep(1000);

        // Read text of access success message
        WebElement accessSuccessMsgElement = driver.findElement(By.xpath("//p[@class='alert alert-success']")); // Replace with actual locator
        String accessSuccessMsg = accessSuccessMsgElement.getText();
        System.out.println("ACCESS SUCCESS MESSAGE: " + accessSuccessMsg);

        // Click on profile for logout
        WebElement profileDropdownForLogout = driver.findElement(By.xpath("//a[contains(@class,'lang-dpwn')]")); // Replace with actual locator
        profileDropdownForLogout.click();

        // Wait for 1 second
        Thread.sleep(1000);

        // Click on logout button
        WebElement logoutButton = driver.findElement(By.xpath("//ul[@id='myPrflDis']//a[contains(@target,'_self')][normalize-space()='Logout']")); // Replace with actual locator
        logoutButton.click();

        // Wait for 1 second
        Thread.sleep(1000);

        // Read logout message
        WebElement logoutMsgElement = driver.findElement(By.xpath("//div[@class='ui-card-text']")); // Replace with actual locator
        String logoutMsg = logoutMsgElement.getText();
        System.out.println("LOGOUT MESSAGE: " + logoutMsg);

        // Wait for 2 seconds
        Thread.sleep(2000);
/*

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        boolean loginSuccess = false;
        try {
            WebElement welcomeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='GST Law ']"))); // Replace with actual locator
            loginSuccess = welcomeElement.isDisplayed();
        } catch (Exception e) {
            loginSuccess = false;
        }
        
        int maxAttempts = 2;
        int attempts = 0;

        while (!loginSuccess && attempts < maxAttempts) 
        {
            System.out.println("Attempt " + (attempts + 1) + " failed, retrying...");

            // Refresh URL
            driver.navigate().refresh();

            // Wait for 40 seconds
            Thread.sleep(40000);

            // Click submit button again
            loginButton.click();
            Thread.sleep(5000);

            try {
                WebElement welcomeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dash-content']/div[@class='row']/div/h4"))); // Replace with actual locator
                loginSuccess = welcomeElement.isDisplayed();
            } catch (Exception e) {
                loginSuccess = false;
            }
            attempts++;
            
        }

        if (loginSuccess) 
        {
            // Get text from profile
            WebElement profileNameElement = driver.findElement(By.xpath("(//div/div[@class='dp-widgt']/p)[1]")); // Replace with actual locator
            String profileName = profileNameElement.getText().trim();
            System.out.println("PROFILENAME: " + profileName);

            // Click on profile dropdown
            WebElement profileDropdown = driver.findElement(By.xpath("(//div/div[@class='dp-widgt']/p)[1]")); // Replace with actual locator
            profileDropdown.click();

            // Wait for 1 second
            Thread.sleep(1000);

            // Click on My Profile
            WebElement myProfile = driver.findElement(By.xpath("//a[normalize-space()='My Profile']")); // Replace with actual locator
            myProfile.click();

            // Wait for 1 second
            Thread.sleep(1000);

            // Click on Manage API Access Link
//            WebElement manageAPIaccessLink = driver.findElement(By.xpath("//li[@class='list-group-item']//a[@data-ng-class="{'disabled': isGstpUser}"][normalize-space()='Manage API Access']")); // Replace with actual locator
//            manageAPIaccessLink.click();

            // Wait for 1 second
            Thread.sleep(1000);

            // Click on Yes
            WebElement accessYES = driver.findElement(By.xpath("//label[normalize-space()='Yes']")); // Replace with actual locator
            accessYES.click();

            // Wait for 1 second
            Thread.sleep(1000);

            // Click on Duration Dropdown
            WebElement durationDropdown = driver.findElement(By.xpath("//select[@id='districts']")); // Replace with actual locator
            durationDropdown.click();

            // Wait for 1 second
            Thread.sleep(1000);

            // Select 30 days from dropdown
            WebElement selectThirtyDays = driver.findElement(By.xpath("//select/option[normalize-space()='30 days']")); // Replace with actual locator
            selectThirtyDays.click();

            // Wait for 1 second
            Thread.sleep(1000);

            // Click on Continue Button
            WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit']")); // Replace with actual locator
            continueButton.click();

            // Wait for 1 second
            Thread.sleep(1000);

            // Read text of access success message
            WebElement accessSuccessMsgElement = driver.findElement(By.xpath("//p[@class='alert alert-success']")); // Replace with actual locator
            String accessSuccessMsg = accessSuccessMsgElement.getText();
            System.out.println("ACCESS SUCCESS MESSAGE: " + accessSuccessMsg);

            // Click on profile for logout
            WebElement profileDropdownForLogout = driver.findElement(By.xpath("//a[contains(@class,'lang-dpwn')]")); // Replace with actual locator
            profileDropdownForLogout.click();

            // Wait for 1 second
            Thread.sleep(1000);

            // Click on logout button
            WebElement logoutButton = driver.findElement(By.xpath("//ul[@id='myPrflDis']//a[contains(@target,'_self')][normalize-space()='Logout']")); // Replace with actual locator
            logoutButton.click();

            // Wait for 1 second
            Thread.sleep(1000);

            // Read logout message
            WebElement logoutMsgElement = driver.findElement(By.xpath("//div[@class='ui-card-text']")); // Replace with actual locator
            String logoutMsg = logoutMsgElement.getText();
            System.out.println("LOGOUT MESSAGE: " + logoutMsg);

            // Wait for 2 seconds
            Thread.sleep(2000);
        } 
        else {
            System.out.println("Login failed after 3 attempts");
        }
        
	}
	catch (Exception e) 
	{
        e.printStackTrace();
    } 
	finally 
	{
        // Close browser
        driver.quit();
    }
      
	}
	*/
}
	}
