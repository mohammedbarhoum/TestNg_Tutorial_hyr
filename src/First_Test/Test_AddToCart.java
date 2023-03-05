package First_Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.text.Collator;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.lang.model.util.Elements;
import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_AddToCart {

	public WebDriver driver;
	public SoftAssert Assert = new SoftAssert();
	public int NumberOfTry = 7;

	@BeforeTest
	public void Signin_Login() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void Add_To_Cart_Part1() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a")).click();
		String Text_mobile_Sony = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2")).getText();
		String Expection = "Sony xperia z5";
		String Actual = Text_mobile_Sony;
		AssertJUnit.assertEquals(Actual, Expection);

		for (int i = 0; i < NumberOfTry; i++) {

			driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
		}

	}

	@Test(priority = 2)
	public void Test_Add_To_Cart_Part2() throws Exception {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[8]/div/div/h4/a")).click();
		Thread.sleep(5000);
		String Text_LapTop_Sony = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).getText();
		String Expection = "Sony vaio i5";
		String Actual = Text_LapTop_Sony;
		AssertJUnit.assertEquals(Actual, Expection);

		for (int i = 0; i < NumberOfTry; i++) {

			driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
		}

	}

	@Test(priority = 3)
	public void The_Total() {

		List<WebElement> MyCart = driver.findElements(By.className("inventory_item_price"));
		List<String> newlist = new ArrayList<>();
		 Collections.sort(newlist);  // Sort cars
		    for ( String i : newlist) {
		      System.out.println(i);
		
		}
	}
}
