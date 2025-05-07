package semiFinalSecondTest.semiFinalSecondTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestData {
	
	WebDriver driver = new ChromeDriver();
	String theWebSide = "https://codenboxautomationlab.com/practice/";
	Random rand = new Random();
	String[] countries = {"jo","sy","le","su","ir","em"};
	int randomCountrie = rand.nextInt(countries.length);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	Actions action = new Actions(driver);

	
	
	
	public void Setup() {
		
		driver.get(theWebSide);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		
	}

}
