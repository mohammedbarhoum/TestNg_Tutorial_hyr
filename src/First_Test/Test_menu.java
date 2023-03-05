package First_Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_menu {

	public WebDriver driver;

	@BeforeTest
	public void Test() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		driver.manage().window().maximize();
	}

	@Test
	public void Menu_Mobile_Test() {

		driver.findElement(By.xpath("//*[@id=\"itemc\"]")).click();

	}

	@Test
	public void Menu_Laptop_Test() {

		driver.findElement(By.xpath("//*[@id=\"itemc\"]")).click();

	}

	@Test
	public void Menu_Monitors_Test() {

		driver.findElement(By.xpath("//*[@id=\"itemc\"]")).click();

	}
}
