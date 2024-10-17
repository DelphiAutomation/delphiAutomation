package com.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseUtilities;
import com.pojo.KafdLogin;
import com.pojo.Parcel;

public class CreateParcel extends BaseUtilities {

	String parcelNameToPass = parcelName;
	Parcel parcel;
	KafdLogin kafdLogin;

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

	@Test(description = "Verify New Parcel is created successfully")
	public void createParcel() throws IOException, InterruptedException {

		parcel = new Parcel();
		webWaitVisibility(parcel.getOnBoard());
		parcel.getOnBoard().click();
		selectByIndexDropdown(parcel.getType(), 1);
		parcel.getBasicInfo().click();
		sendText(parcel.getChooseFile(), System.getProperty("user.dir") + "\\TestData\\TestSample_Image.jpg");
		sendText(parcel.getTotalNoOfFloors(), "3");
		sendText(parcel.getTotalNoOfUnits(), "2");
		sendText(parcel.getLatitude(), "43.2");
		sendText(parcel.getLongitude(), "32.5");
		sendText(parcel.getParcel(), parcelName);
		sendText(parcel.getParcelId(), parcelName);
		selectByIndexDropdown(parcel.getZone(), 1);
		selectByIndexDropdown(parcel.getAreaType(), 1);
		parcel.getSaveParcel().click();
		sendText(parcel.getDescription(), "parcel created ");
		String webWaitElementGetText = webWaitElementGetText(parcel.getPopupParcelSuccess());
		System.out.println(webWaitElementGetText);
		Assert.assertEquals(webWaitElementGetText, "Parcel has been created successfully");
		webWaitInvisibility(parcel.getPopupParcelSuccess());

	}
	
	@Test(description = "Verify kafd document")
	public void uploadKafdDocuments() {

		parcel = new Parcel();
		webWaitVisibility(parcel.getAddDocumentCategory());
		parcel.getAddDocumentCategory().click();
		sendText(parcel.getCategoryName(), "KiranAutomationDocuments");
		parcel.getSaveCategoryName().click();

	}
	
	@Test(description = "Verify Update Parcel is created successfully")
	
	@AfterClass
	private void quitDriver() {
		driver.quit();
	}

}
