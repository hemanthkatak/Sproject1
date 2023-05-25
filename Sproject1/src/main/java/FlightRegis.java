

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightRegis
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\venka\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(opt);
		
	    driver.get("https://demo.guru99.com/test/newtours/index.php");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	    driver.findElement(By.linkText("Flights")).click();
	    new Select(driver.findElement(By.xpath("//select[@name='passCount']"))).selectByValue("3");
	    new Select(driver.findElement(By.xpath("//select[@name='fromPort']"))).selectByIndex(4);
	    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("New York");
	    new Select(driver.findElement(By.name("fromMonth"))).selectByVisibleText("March");
	    //new Select(driver.findElement(By.xpath("//select[text()='fromMonth']"))).selectByVisibleText("April");  //we have locator name, Can we right Xpath??
	    new Select(driver.findElement(By.xpath("//select[contains(@name,'fromDay')]"))).selectByValue("6");
	    new Select(driver.findElement(By.name("toPort"))).selectByIndex(5);
	    new Select(driver.findElement(By.xpath("//select[@name='toMonth']"))).selectByValue("10");
	    new Select(driver.findElement(By.name("toDay"))).selectByIndex(20);
	    driver.findElement(By.xpath("//input[@value='Business']")).click();
	    new Select(driver.findElement(By.xpath("//select[@name='airline']"))).selectByVisibleText("Unified Airlines");
	    driver.findElement(By.xpath("//input[@name='findFlights']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//img[@src='images/home.gif']")).click();
	    driver.findElement(By.xpath("//span[text()='Close']")).click();
	    
	    
	}

}
