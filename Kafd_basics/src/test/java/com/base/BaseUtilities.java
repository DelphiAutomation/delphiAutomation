package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.test.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtilities {
	
	public static WebDriver driver;
	public static Properties properties;
	public static FileInputStream fileInputStream;
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports reports;
	public static Date date = new Date();
	public static Alert alert;
	public static WebDriverWait wait;
	public static ChromeOptions options;
	public static FirefoxOptions firefoxOptions;
	public static EdgeOptions edgeOptions;
	public static String BrowserName;
	public String parcelName = "KiranAutomationTest" + dateReference();

	
	public void launchBrowser() throws IOException, InterruptedException {

		properties();
		BrowserName = properties.getProperty("Browser").trim();
		System.out.println(BrowserName);
		if (BrowserName.equalsIgnoreCase("chrome")) {
			options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().driverVersion("129.0.6668.70").setup();
			driver = new ChromeDriver(options);
		} else if (BrowserName.equalsIgnoreCase("firefox")) {

			firefoxOptions = new FirefoxOptions();
//			firefoxOptions.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOptions);
		} else {
			System.out.println(BrowserName + "Please enter valid browser name ");
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		

	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void getTitle(String title) {
		driver.get(title);
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void closeTab() {
		driver.close();
	}

	public void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public String screenShot(String testCaseName) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/Screenshots/" + testCaseName + date.getTime()
				+ ".png";
		FileUtils.copyFile(screenshotAs, new File(destinationFile));
		return destinationFile;
	}

	public void properties() throws IOException {

		properties = new Properties();
		fileInputStream = new FileInputStream(
				"C:\\Users\\KiranRaj\\eclipse-workspace\\Kafd_basics\\src\\test\\resources\\configuration\\config.properties");
		properties.load(fileInputStream);
		System.out.println(properties);

	}

	public String webWaitAccept() {

		wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		Alert until = wait.until(ExpectedConditions.alertIsPresent());
		String text = until.getText();
		System.out.println(text);
		until.accept();

		return text;
	}

	public String webWaitElementGetText(WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement until = wait.until(ExpectedConditions.visibilityOf(ele));
		String text = until.getText();
		return text;
	}

	public void webWaitInvisibility(WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void webWaitVisibility(WebElement ele) {
		wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void extentReport() {

		String path = System.getProperty("user.dir") + "./report/index.html";
		extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("KAFD Automation Test Results");
		extentSparkReporter.config().setDocumentTitle("KAFD Test Automation Results ");

		reports = new ExtentReports();
		reports.attachReporter(extentSparkReporter);
		reports.setSystemInfo("FirstRun", "Kiranraj");

	}

	public void alertSendKeys(String keysToSend) {

		alert.sendKeys(keysToSend);

	}

	public String alertGetText() {
		return alert.getText();
	}

	public void alertDismiss() {
		alert.dismiss();
	}

	public void alertIntialization() {
		alert = driver.switchTo().alert();
	}

	public void alertAccept() {

		alert.accept();

	}

	public void selectByIndexDropdown(WebElement dropdownLocator, int index) {

		Select dropdown = new Select(dropdownLocator);
		dropdown.selectByIndex(index);
	}

	public String dateReference() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String currentTime = now.format(formatter);
		return currentTime;
	}

	
}
