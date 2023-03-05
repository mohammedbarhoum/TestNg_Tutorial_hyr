package DepandcesTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest2 {

	public WebDriver driver;
	public SoftAssert Assert = new SoftAssert();

	@Test()
	public void OpenWebSite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "loginTestData",dataProviderClass =ExcelDataSupllier.class)
	public void Signin(String userName, String password) throws Exception {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys(userName);
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
		driver.quit();
		
	}

//	@DataProvider(name= "loginTestData")
//	public Object[][] loginTest() {
		
//		Object[][] data = new Object[2][2];
		
//		data[0][0] = "mohammedbarhoum123";
//		data[0][1] = "mohammedbarhoum123";
				

	//	data[1][0] = "Admin";
		//data[1][1] = "Test1";

		//return data;

	}

	
	


