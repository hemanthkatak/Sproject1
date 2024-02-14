import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightBooking 
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(opt);
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
		from.sendKeys("Hyderabad");
		Thread.sleep(3000);
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		WebElement To = driver.findElement(By.xpath("//input[@placeholder='To']"));
	    To.sendKeys("Delhi");
	    Thread.sleep(3000);
		To.sendKeys(Keys.ARROW_DOWN);
		To.sendKeys(Keys.ENTER);
		
		while(driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText().matches("May 2023")==false)
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
		driver.findElement(By.xpath("//p[text()='20']")).click();
		driver.findElement(By.xpath("//label[@for='travellers']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-5']")).click();
		driver.findElement(By.xpath("//li[@data-cy='children-4']")).click();
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();

	}

}
