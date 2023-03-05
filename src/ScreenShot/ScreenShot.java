package ScreenShot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot extends BassTest {
	public WebDriver driver;
	public SoftAssert Assert = new SoftAssert();

	@Test(priority = 1, testName ="Signin" )
	public void Signin() throws Exception {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	
		driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys("mohammedbarhoum123");
		driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys("mohammedbarhoum123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(3000);

		// String AcualText = driver.switchTo().alert().getText();
		// String ExpectionText = "This user already exist.";
		// AssertJUnit.assertEquals(AcualText, ExpectionText);
		// driver.switchTo().alert().accept();
		// driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[1]/button/span")).click();
		// Thread.sleep(3000);
		// driver.quit();

	}

	@Test(priority = 2,testName = "Login")
	public void Login() throws Exception {
		
		driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("mohammedbarhoum123");
		driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("mohammedbarhoum123");
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
	}

	@Test(priority = 3,testName = "Contact_Us")
	public void Contact_Us() throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).sendKeys("mohammedbarhoum@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"recipient-name\"]")).sendKeys("mohammedbrhoum");
		driver.findElement(By.xpath("//*[@id=\"message-text\"]")).sendKeys("thankyou");
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")).click();

		Thread.sleep(5000);
		String AcualTextContact = driver.switchTo().alert().getText();
		String ExpectionTextContact = "Thanks for the message!!";
		Assert.assertEquals(AcualTextContact, ExpectionTextContact);
		driver.switchTo().alert().accept();

	}
}
