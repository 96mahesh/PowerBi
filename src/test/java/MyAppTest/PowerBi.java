package MyAppTest;


import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utilits.Browser;

import io.appium.java_client.windows.WindowsDriver;


public class PowerBi{
	WindowsDriver<WebElement> driver;
	@BeforeMethod
	public void setUp() throws IOException {
		
		driver = Browser.launchPowerBi();
		
	}
	@AfterMethod
	public void tearDown() throws Exception {
		Browser.tackScreenShot("imegename");
		Browser.closePowerBi();
	}

	@Test
	public void checkEditFunctionality() throws Exception{
		driver.manage().window().maximize();
		driver.findElementByName("Blank report").click();
		//driver.findElement(By.xpath("//*[@Name='Blank report']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//Button[@ClassName='splitPrimaryButton root-269'][@Name='Get data']")).click();
		driver.findElement(By.xpath("//Button[@Name='Connect']//Text[@Name='Connect']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ListItem[@ClassName='UIItem'][@Name='FSI-2023-DOWNLOAD']")).click();
		driver.findElement(By.xpath("//SplitButton[@ClassName='Button'][@Name='Open']")).click();
		Thread.sleep(5);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))   // Maximum wait time
                .pollingEvery(Duration.ofSeconds(5))   // Polling interval
                .ignoring(NoSuchElementException.class);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Level 2, Sheet1")));
		Actions action = new Actions(driver);
		action.doubleClick(ele).build().perform();
		driver.findElement(By.xpath("//Button[@Name='Load']")).click();
		Thread.sleep(15000);
		//WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
		WebElement e = driver.findElement(By.name("Sheet1"));
		action.click(e).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//Group[@ClassName='pbi-tree-node-checkbox ng-star-inserted']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//Group[@ClassName='pbi-tree-node-checkbox ng-star-inserted'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//Group[@ClassName='pbi-tree-node-checkbox ng-star-inserted'])[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//Group[@ClassName='pbi-tree-node-checkbox ng-star-inserted'])[4]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ListItem[starts-with(@ClassName,'visual-icon-container interactive pbi-menu-trigger ng-star-inser')][@Name='Pie chart']/Image")).click();
		WebElement zoom = driver.findElement(By.xpath("//Image[@ClassName='clearCatcher']"));
		action.moveToElement(zoom).build().perform();
//		action.clickAndHold(zoom).moveByOffset(0, 100).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//Button[@ClassName='vcPopOutBtn'][@Name='Focus mode']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//Button[@Name='Save']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//Edit[@Name='Report Name'][@AutomationId='textInputDialogInputField']")).sendKeys("Mahesh");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//Button[@Name='Save']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//Button[@Name='Yes']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ListItem[@ClassName='visual-icon-container more pbi-menu-trigger ng-star-inserted'][@Name='Get more visuals']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//MenuItem[@ClassName='pbi-menu-item ng-star-inserted'][@Name='Get more visuals']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//Button[@Name='Cancel']")).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//Button[@Name='Don&apos;t save']")).click();
		
}
}
