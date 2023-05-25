import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowAlerts 
{

	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(opt);
		
		driver.get("https://www.monster.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		driver.findElement(By.id("email")).sendKeys("hemanth.katakam@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Aaryan4304");
		driver.findElement(By.cssSelector("div[class='AuthButton_buttonRow__BrDyj']")).click();
		driver.findElement(By.xpath("//div[text()='Upload My Resume or drop files here']")).click();
		
		//Below is the Robot class for handling the window Alert
		
		Thread.sleep(2000);
		Robot r= new Robot(); //Class(Robot) have methods to perform keyboard and mouse operations
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("C:\\Users\\venka\\Downloads\\PERM Employee Worksheet.doc"), null);
		/*r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);*/
		
		
		
		
		

	}

}
