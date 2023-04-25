import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class NewTest {
	
	WebDriver driver;
	String url = "https://www.nytimes.com/games/wordle/index.html";
	String dicUrl = "https://eslforums.com/5-letter-words/";
	
	@BeforeTest
	public void launch() {
//		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
//		driver.get(dicUrl);
		driver.manage().window().maximize();
	}
	
	/*
	 * @AfterTest public void tearDown() { driver.quit(); }
	 */
	
	@Test
	public void t1() throws InterruptedException {
		BaseClass baseClass = new BaseClass(driver);
		String title = driver.getTitle();
		System.out.println(title);
		baseClass.clickCross();
		baseClass.wordleUp();
	}
	
//	@Test
	public void t2() throws IOException {
		BaseClass baseClass = new BaseClass(driver);
		baseClass.fillWordList();
	}
}
