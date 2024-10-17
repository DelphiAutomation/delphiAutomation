package com.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseUtilities;
import com.pojo.KafdLogin;
import com.pojo.KafdSignon;

public class Login extends BaseUtilities {
	BaseUtilities baseUtilities;
	KafdLogin login;
	KafdSignon signon;

	
	@Test(description = "Verify loggedIn successfully ")
	public void signInKafd() throws IOException, InterruptedException {

		launchBrowser();
		login = new KafdLogin();
		getUrl("https://kafd.uaenorth.cloudapp.azure.com//adfs/ls/IdpInitiatedSignOn");
		signon = new KafdSignon();

		// Sign on process
		if (BrowserName.equalsIgnoreCase("chrome")) {
			signon.getAdvancedPermssion().click();
			signon.getProceedPermssion().click();
		}
		signon.getIdpOtherRpRadioButton().click();
		signon.getSignInSubmit().click();
		signon.getUserNameInput().sendKeys("kafdadmin1@delphi-kafd.local");
		signon.getPasswordInput().sendKeys("Delphi@1234");
		signon.getSubmitButton().click();

		// signin process
		getUrl("http://fitout.uaenorth.cloudapp.azure.com:8451/login");
		login.getLoginInternalUser().click();
		Thread.sleep(2000);
	
	}

}