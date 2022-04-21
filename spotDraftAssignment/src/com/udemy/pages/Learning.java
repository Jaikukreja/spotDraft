package com.udemy.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Learning {
	
	WebDriver driver;
	
	@FindBy (id = "u152-search-form-autocomplete--3")
	WebElement txt_search;
	
	@FindBy (xpath = "//*[contains(text(),'Add to cart')]")
	WebElement btn_AddToCart;
	
	@FindBy (xpath = "//*[contains(text(),'Go to cart')]")
	WebElement btn_GoToCart;
	
	
	public Learning(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchCourse(String course) {
		txt_search.sendKeys(course);
		//The Complete JavaScript Course 2022: From Zero to Expert!
		Select select = new Select(txt_search);
		select.selectByVisibleText(course);
	}
	
	public void addCourseToCart() {
		if(btn_AddToCart.isDisplayed() && btn_AddToCart.isEnabled()) {
			btn_AddToCart.click();
		}
		else {
			System.out.println("Add to Cart button is not Displayed");
		}
		
		btn_GoToCart.click();
		
		TakesScreenshot screen =(TakesScreenshot)driver;
		  File src = screen.getScreenshotAs(OutputType.FILE);
		  try {
			FileHandler.copy(src, new File(".\\Course_In_Cart"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
