package MyAppTest;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.windows.WindowsDriver;

public class OpenNotepad {

	WindowsDriver driver;
	@BeforeMethod
	public void setUp() throws IOException {
		
		Desktop desktop = Desktop.getDesktop();
		desktop.open(new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("PlatformName", "Windows");
		cap.setCapability("DeviceName", "WindowsPc");
		
		try {
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void launchNotepadClickOnHelpDesk() {
		driver.findElementByName("Help").click();
		driver.findElementByName("About Notepad").click();
		driver.findElementByName("OK").click();
		
	}
	
	@Test
	public void checkEditFunctionality() throws Exception{
		driver.manage().window().maximize();
		driver.findElementByName("Edit").click();
		String name = driver.findElementByName("Edit").getText();
		System.out.println(name);
		//driver.findElementByName("Time/Date").click();
//		WebElement ele = driver.findElement(By.xpath("/Window/Menu[1]/MenuItem[13]"));
//		ele.click();
//		ele.clear();
//		
		String data = "Time/Date";
		List<WebElement> ele = driver.findElements(By.xpath("/Window/Menu[1]/MenuItem"));
		for (WebElement e : ele) {
			try {
			String eledata = e.getText();
			//System.out.println(eledata);
			if(eledata.contains(data))
				e.click();
			
			}catch(Exception e1) {
				System.out.println(e1);
			}
		}
		
//		String parrent_window = driver.getWindowHandle();
//		System.out.println(parrent_window);
//		Set<String> win = driver.getWindowHandles();
//		for (String c : win) {
//			if(!c.equals(parrent_window)) {
//				driver.switchTo().window(c);
//			}
//		}
	   driver.findElementByName("Close").click();
       driver.findElement(By.xpath("//Button[@Name='Save'][starts-with(@AutomationId,'CommandButton_')]")).click();
       
		
		//driver.findElementByName("Text Editor").sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE);
		
	}
}
