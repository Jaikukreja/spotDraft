package com.udemy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[contains(text(),'Log in')]")
	WebElement btn_LandingLogin;
	
	@FindBy (id = "email--1")
	WebElement txt_EmailId;
	
	@FindBy (id = "id_password")
	WebElement txt_Password;
	
	@FindBy (id = "submit-id-submit")
	WebElement btn_Login;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String userid ,String password) {
		
		if(btn_LandingLogin.isDisplayed()) {
			btn_LandingLogin.click();
		}
		else {
			System.out.println("Login Button on Landing page is not displayed");
		}
		
		txt_EmailId.sendKeys(userid);
		txt_Password.sendKeys(password);
		btn_Login.click();
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}

}
