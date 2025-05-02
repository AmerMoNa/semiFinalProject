package semiFinalSecondTest.semiFinalSecondTest;

import java.nio.channels.Selector;
import java.security.AllPermission;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	WebDriver driver = new ChromeDriver();
	String theWebSide = "https://codenboxautomationlab.com/practice/";
	Random rand = new Random();
	
	
	@BeforeTest
	public void mySetup() {
		driver.get(theWebSide);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	
	
	@Test(priority = 1)
	public void radioButton () {
		
		WebElement theRadioButton = driver.findElement(By.id("radio-btn-example"));
		List<WebElement> anyRadioButton = theRadioButton.findElements(By.className("radioButton"));
		int randomButton = rand.nextInt(anyRadioButton.size());
		
		anyRadioButton.get(randomButton).click();
		
		
	}
	
	@Test(priority = 2)
	public void dynamicDropdown () throws InterruptedException {
		WebElement autoCompletField = driver.findElement(By.id("autocomplete"));
		String[] countries = {"jo","sy","le","su","ir","em"};
		int randomCountrie = rand.nextInt(countries.length);
		autoCompletField.sendKeys(countries[randomCountrie]);
		Thread.sleep(1000);
		autoCompletField.sendKeys(Keys.chord(Keys.ARROW_DOWN ,Keys.ENTER));
		
		
		
	}
	@Test (priority = 3)
	public void staticDropDown() {
		WebElement selectOne = driver.findElement(By.id("dropdown-class-example"));
		selectOne.click();
		Select selectAnyOne = new Select(selectOne);
		selectAnyOne.selectByVisibleText("Selenium");
		selectAnyOne.selectByIndex(2);
		selectAnyOne.selectByValue("option3");
		
	}
	
	@Test(priority = 4)
	public void checkBox () {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,550)");
				
		
		WebElement checkBoxButton = driver.findElement(By.id("checkbox-example"));
		List<WebElement> allCheckBoxes = checkBoxButton.findElements(By.tagName("input"));
		int randomBox = rand.nextInt(allCheckBoxes.size());
		
		allCheckBoxes.get(randomBox).click();
		
		
		
	}
	
	@Test (priority = 5)
	public void switchWindow () throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement openNewWindow = driver.findElement(By.id("openwindow"));
		openNewWindow.click();
		
		Set<String> handles = driver.getWindowHandles();
		List<String> windowHandles = new ArrayList<>(handles);
		driver.switchTo().window(windowHandles.get(1));
		Thread.sleep(1000);
		js.executeScript("window.scrollTo(0,500)");
		driver.manage().window().maximize();
		driver.close();
		driver.switchTo().window(windowHandles.get(0));
//		Thread.sleep(1000);
		
		
	}

	@Test (priority = 6)
	public void facebookButton () {
		WebElement goToFacebook = driver.findElement(By.className("the_champ_facebook"));
		goToFacebook.click();
		
		Set<String> handels = driver.getWindowHandles();
		List<String> switchWindow = new ArrayList<>(handels);
		driver.switchTo().window(switchWindow.get(0));
		
		
	}
	
	
	@Test(priority = 7)
	public void newTab () {
		
		WebElement openNewTab = driver.findElement(By.linkText("Open Tab"));
		openNewTab.click();
		
		Set<String> handles = driver.getWindowHandles();
		List<String> allTabs = new ArrayList<>(handles);
		driver.switchTo().window(allTabs.get(2));
		driver.switchTo().window(allTabs.get(0));
	}
	
	@Test (priority = 8)
	public void alert () throws InterruptedException {
		
		WebElement alretFeild = driver.findElement(By.id("name"));
		alretFeild.sendKeys("myName");
		
		WebElement alretButton =driver.findElement(By.id("alertbtn"));
		alretButton.click();
		driver.switchTo().alert().accept();
		
		alretFeild.sendKeys("myName");
		WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
		confirmButton.click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		alretFeild.sendKeys("myName");
		confirmButton.click();
		driver.switchTo().alert().dismiss();
	}
	
	@Test (priority = 9)
	public void theTable () {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,900)");
		
		WebElement table = driver.findElement(By.id("product"));
		List<WebElement> headRow = table.findElements(By.tagName("th"));
		
		List<WebElement> allRowsOfData = table.findElements(By.tagName("td"));
		
		System.out.println(headRow.getLast().getText());
		
		for(int i =2 ; i<allRowsOfData.size();i=i+3) {
			
			System.out.println(allRowsOfData.get(i).getText());
			
		}
		
		
	}
	
	@Test (priority = 10)
	public void hideShowTest() {
		WebElement hideShowField = driver.findElement(By.id("displayed-text"));
		hideShowField.sendKeys("student");
		
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		
		
		
	}
	
	@Test(priority = 11)
	public void enableDisableTest () {
		WebElement enableDisableField = driver.findElement(By.id("enabled-example-input"));
		enableDisableField.sendKeys("theTest");
		
		WebElement disableButton = driver.findElement(By.id("disabled-button"));
		disableButton.click();
		
		WebElement enabelButton = driver.findElement(By.id("enabled-button"));
		enabelButton.click();
		
		
	}
	
	@Test (priority = 12)
	public void mouseHoverTest () throws InterruptedException {
		
		
		WebElement mouseHover = driver.findElement(By.id("mousehover"));
		
		Actions action = new Actions(driver);
		action.moveToElement(mouseHover).click().perform();
		
		WebElement goToTop = driver.findElement(By.linkText("Top"));
		goToTop.click();
		
		action.moveToElement(mouseHover).click().perform();
		
		WebElement reloadButton = driver.findElement(By.linkText("Reload"));
		reloadButton.click();
		
		driver.navigate().refresh();
		
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1800)");
		
		
		
	}
	
	@Test(priority = 13)
	public void bookingCalendar () {
		
		WebElement calendarButton = driver.findElement(By.partialLinkText("Booking"));
		calendarButton.click();
		
		Set<String> handles = driver.getWindowHandles();
		List<String> switchWindow = new ArrayList<>(handles);
		driver.switchTo().window(switchWindow.get(0));
		
	}
	
	@Test (priority = 14)
	public void iFrameTest () throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2200)");
		
		driver.switchTo().frame(0);
		WebElement burgurMenu = driver.findElement(By.cssSelector(".ct-mobile-meta-item.btn-nav-mobile.open-menu"));
		burgurMenu.click();
		
		Set<String> handles = driver.getWindowHandles();
		List<String> switchWin = new ArrayList<>(handles);
		driver.switchTo().window(switchWin.get(0));
		
		WebElement calendarButton = driver.findElement(By.partialLinkText("Booking"));
		calendarButton.click();
		
		Set<String> handles2 = driver.getWindowHandles();
		List<String> switchWin2 = new ArrayList<>(handles2);
		driver.switchTo().window(switchWin2.get(1));
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(switchWin2.get(0));
		System.out.println(driver.getTitle());
		driver.switchTo().frame("iframe-name");
		WebElement exitButton = driver.findElement(By.id("ct-menu-mobile"));
		exitButton.click();
		
	}
	
}
