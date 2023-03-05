package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvoTimmeout {

	public WebDriver driver;

	@Test(invocationCount = 3 ,threadPoolSize = 2 )
	public void OpenWebSite() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://randomuser.me/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"values_list\"]/li[1]")).click();
		System.out.println("User name:"+driver.findElement(By.id("user_value")).getText() );
		
		driver.findElement(By.xpath("//*[@id=\"values_list\"]/li[2]")).click();
		System.out.println("Email address:"+driver.findElement(By.id("user_value")).getText() );
		
		driver.quit();
		
	}

}
