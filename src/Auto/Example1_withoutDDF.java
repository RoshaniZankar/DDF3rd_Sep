package Auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1_withoutDDF 
{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		
		boolean result = driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		if(result==true)
		{
			System.out.println("TC pass");
		}
		else
		{
			System.out.println("TC fail");
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@class='bm-item menu-item']")).click();
		Thread.sleep(2000);
		
		driver.close();
		
		
	}
}
