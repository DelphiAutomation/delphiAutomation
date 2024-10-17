package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseUtilities;

public class KafdLogin extends BaseUtilities {

	public KafdLogin() {
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath ="//a[contains(text(),'Login as KAFD Internal User')]")
	private WebElement loginInternalUser;

	
	@FindBy(xpath ="//div[@class='container-fluid bg-primary']")
	private WebElement Header;
	
	
	public WebElement getHeader() {
		return Header;
	}
	
	
	public WebElement getLoginInternalUser() {
		return loginInternalUser;
	}

	

	
	
}
