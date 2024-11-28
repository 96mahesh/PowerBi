package com.utilits;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;

public class Browser {

	public static WindowsDriver<WebElement> driver;
	
	
	public static WindowsDriver<WebElement> launchPowerBi() throws IOException {
		Desktop desktop = Desktop.getDesktop();
		desktop.open(new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", "C:\\Program Files\\Microsoft Power BI Desktop\\bin\\PBIDesktop.exe");
		cap.setCapability("PlatformName", "Windows");
		cap.setCapability("DeviceName", "WindowsPc");
		
		try {
			driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"),cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void closePowerBi() {
		driver.quit();
	}

	public static String takeScreenShot() 
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		String srcfile = scrShot.getScreenshotAs(OutputType.BASE64);
		return srcfile;

	}

	public static String capcturingPicture(String filename) throws IOException 
	{
		File sourcefile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(System.getProperty("user.dir") + "//.ss//" + filename + ".png");
		FileUtils.copyFile(sourcefile, destinationFile);
		return destinationFile.getAbsolutePath();
	}
	
	public static void tackScreenShot(String imegename) throws Exception, Exception 
	{
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(".//screnshot//" + imegename + "ExtentReportManager.png"));
    }

}
