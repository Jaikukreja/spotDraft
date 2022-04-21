package com.udemy.pages;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(),'Move to Wishlist')]")
	WebElement lnk_MoveToWishList;
	
	@FindBy(id="u71-popper-trigger--18")
	WebElement lnk_Wishlist;
	
	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void moveCourseToWishlist() {
		lnk_MoveToWishList.click();
	}
	
	public void goToWishList() {
		lnk_Wishlist.click();
		
		TakesScreenshot screen =(TakesScreenshot)driver;
		  File src = screen.getScreenshotAs(OutputType.FILE);
		  try {
			FileHandler.copy(src, new File(".\\Course_In_Wishlist"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
