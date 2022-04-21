package util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {
	
		public static WebDriver driver;
		
		public static WebDriver browserStart(String name) 
		{
			
			if(name.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "/Users/jaikukreja/Drivers/chromedriver");
				driver=new ChromeDriver();
			}
			else if(name.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","/Users/jaikukreja/Drivers/geckodriver");
				driver=new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			return driver;
		}
		
		public static WebDriver browserStart(String name, String url) 
		{
			WebDriver driver=browserStart(name);
			driver.get(url);
			driver.manage().window().maximize();
			return driver;
		}
		
		public static void getScreenShot(String Name)
		{
			Date d = new Date();
		String date = d.toString().replaceAll(" ","_").replaceAll(":","_");	
			TakesScreenshot screen=(TakesScreenshot)driver;
			File src=screen.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(src, new File(".\\"+Name+date+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
}
