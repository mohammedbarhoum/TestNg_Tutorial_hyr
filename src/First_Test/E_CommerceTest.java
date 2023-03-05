package First_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E_CommerceTest {

	public WebDriver driver;
	public SoftAssert Assert = new SoftAssert();

	@Parameters({"browserName","url"})
	@Test
	public void OpenWebSite(String browserName,String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Parameters({"username","password"})
	@Test(priority = 1   )
	public void Signin(String username, String password) throws Exception {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(3000);

		String AcualText = driver.switchTo().alert().getText();
		String ExpectionText = "This user already exist.";
		AssertJUnit.assertEquals(AcualText, ExpectionText);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[1]/button/span")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void Login() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("mohammedbarhoum123");
		driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("mohammedbarhoum123");
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		Assert.assertTrue(driver.findElement(By.id("welcome")).isDisplayed());
	}

	
	@Test (priority = 3)
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
	@Test(priority =4 )
	public void About_Us() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[3]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"example-video\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"example-video\"]/div[4]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button")).click();
		
	}
	@Test(priority = 5)
	public void Testmobile() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[3]/div")).click();
		Thread.sleep(5000);
		String ActualNameMobile = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2")).getText();
		String ExpectNameMobile = "Nexus 6";
		Assert.assertEquals(ActualNameMobile, ExpectNameMobile);
	
		Thread.sleep(5000);
		String TestPrice = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h3")).getText();
		System.out.print(TestPrice);
		
		String[] Test = TestPrice.split("$");

		System.out.println(Test);

		String ActualDescription = driver.findElement(By.xpath("//*[@id=\"more-information\"]/p")).getText();
		String ExpectDescription = "The Motorola Google Nexus 6 is powered by 2.7GHz quad-core Qualcomm Snapdragon 805 processor and it comes with 3GB of RAM.";
		AssertJUnit.assertEquals(ActualDescription, ExpectDescription);
		
		Assert.assertAll();
		driver.navigate().back();
	}
	
	@Test(priority = 6)
	public void Mobile_Nokia1520() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/div/h4/a")).click();
		Thread.sleep(3000);
		String TextMobile= driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2")).getText();
		System.out.println(TextMobile);
		driver.navigate().back();
	}

}
