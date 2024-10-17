package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseUtilities;

public class KafdSignon extends BaseUtilities {
	public KafdSignon() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "details-button")
	private WebElement advancedPermssion;
	@FindBy(id = "proceed-link")
	private WebElement proceedPermssion;
	@FindBy(id = "idp_OtherRpRadioButton")
	private WebElement idpOtherRpRadioButton;
	@FindBy(name = "SignInSubmit")
	private WebElement signInSubmit;
	@FindBy(id = "userNameInput")
	private WebElement userNameInput;
	@FindBy(id = "passwordInput")
	private WebElement passwordInput;
	@FindBy(id = "submitButton")
	private WebElement submitButton;

	public WebElement getIdpOtherRpRadioButton() {
		return idpOtherRpRadioButton;
	}

	public WebElement getSignInSubmit() {
		return signInSubmit;
	}

	public WebElement getUserNameInput() {
		return userNameInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getAdvancedPermssion() {
		return advancedPermssion;
	}

	public WebElement getProceedPermssion() {
		return proceedPermssion;
	}

}
