package Auto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream file=new FileInputStream("C:\\\\Users\\\\Sharad\\\\Desktop\\\\velocity notes\\\\New folder\\\\Book1.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet5");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String UN = sh.getRow(2).getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(UN);
		
		String PW = sh.getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PW);
		
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
		
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@class='bm-item menu-item']")).click();
		Thread.sleep(2000);
		
		driver.close();
		
		
	}
}
