package com.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseUtilities;
import com.pojo.KafdLogin;
import com.pojo.Parcel;

public class Parcelss extends BaseUtilities {

	Parcel parcel;
	KafdLogin kafdLogin;
	public static JavascriptExecutor js;

	@BeforeClass
	public void loginIntialization() throws IOException, InterruptedException {

		kafdLogin = new KafdLogin();
		try {
			kafdLogin.getHeader().isDisplayed();
			System.out.println("Continue testing ");
		} catch (NullPointerException e) {
			Login login = new Login();
			login.signInKafd();
		}

	}

	@Test
	public void getHeader() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='row row-cols-1 row-cols-md-4 g-0 ng-tns-c246-0 ng-star-inserted']"))
				.click();
		WebElement scrollElement = driver.findElement(By.xpath("//b[contains(text(),'Slow Progress')]"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollElement);
		Thread.sleep(3000);

		
		int size = driver.findElements(By.xpath("//p[@class='title-text-overflow ng-tns-c246-0']")).size();
		System.out.println(size);
		
		for (int i = 0; i < size; i++) {
			String text = driver.findElements(By.xpath("//p[@class='title-text-overflow ng-tns-c246-0']")).get(i).getText();
			System.out.println(text);
			if (text.equalsIgnoreCase("Slow Progress")) {

				driver.findElements(By.xpath("//button[contains(text(),'Add Tenancy')]")).get(i).click();
				System.out.println(text+ "Final progress");

				break;
			} else {

			}
		
		}
		System.out.println("Parcel clicked ...... goood........");
	}
}