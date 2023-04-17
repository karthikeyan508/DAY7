package Day_7;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task3 {
	WebDriver driver;
	@BeforeSuite
	void init() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
	}
	@Test
	void Task3()throws InterruptedException
	{
	

		String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(url);
		Thread.sleep(3000);
		WebElement username=driver.findElement(By.name("username"));
		username.sendKeys("Admin"+Keys.ENTER);
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("admin123"+Keys.ENTER);
		WebElement login=driver.findElement(By.xpath("//*[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]"));
		login.click();
		
	}
@Test(dependsOnMethods="task3")
public void Test2() throws InterruptedException {  
String end="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
driver.get(end);
Thread.sleep(4000);
WebElement page=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span"));
page.click();
 List<WebElement> menu=driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul"));
	menu.get(3).click();

	  }
}

