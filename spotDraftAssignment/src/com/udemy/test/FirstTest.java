package com.udemy.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.udemy.pages.Learning;
import com.udemy.pages.LoginPage;
import com.udemy.pages.ShoppingCart;

import util.Base;

public class FirstTest extends Base {
	
	
	
	@BeforeTest
	public void setup() {
		Base.browserStart("chrome","http://udemy.com");
	}
	
	
	
	@Test(priority=1)
	public void searchCourse_AddToCart_MoveToWishList() {
		
		LoginPage loginPage = new LoginPage(Base.driver);
		Learning learning = new Learning(Base.driver);
		ShoppingCart shoppingCart = new ShoppingCart(Base.driver);
		
		loginPage.login("jaikukreja1996@gmail.com", "Temp@123");
		learning.searchCourse("The Complete JavaScript Course 2022: From Zero to Expert!");
		learning.addCourseToCart();
		shoppingCart.moveCourseToWishlist();
		shoppingCart.goToWishList();
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
