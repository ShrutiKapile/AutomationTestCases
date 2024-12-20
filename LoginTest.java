package com.jbk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest 
{
  @Test
  public void testtitle() //1
  {
	  WebDriver driver = new ChromeDriver();	
	  
	  driver.get("https://javabykiran.com/selenium/login.html");
	  String ActualTitle= driver.getTitle();
      System.out.println(ActualTitle);
      
      String ExpectedResult = "Login - TKA";
      driver.close();
      
      Assert.assertEquals(ActualTitle, ExpectedResult);
  }
  @Test
  public void testlogin()//2
  {
	  WebDriver driver = new ChromeDriver();
      driver.get("https://javabykiran.com/selenium/login.html");
      
      // Verify the title of the Login page
      String actualTitle = driver.getTitle();
      System.out.println("Actual Title: " + actualTitle);
      
      String expectedTitle = "Login - Kiran Academy";
      Assert.assertEquals(expectedTitle, actualTitle);
  }
//verify login with valid credential
  @Test
  public void AdminPanelTest()//3
  {
	  WebDriver driver = new ChromeDriver();
      driver.get("https://javabykiran.com/selenium/login.html");
      
      // Login step
      driver.findElement(By.id("username")).sendKeys("admin");
      driver.findElement(By.id("password")).sendKeys("password123");
      driver.findElement(By.xpath("//button[text()='Login']")).click();
      
      // Navigate to Categories Page
      driver.get("https://javabykiran.com/admin/categories");

      // Add a category
      driver.findElement(By.id("addCategory")).click();
      driver.findElement(By.name("categoryName")).sendKeys("New Category");
      driver.findElement(By.id("submitCategory")).click();
  }
  @Test
  public void verifyURL()//4
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://javabykiran.com/selenium/login.html");

	  String currentURL = driver.getCurrentUrl();
	  String expectedURL = "https://javabykiran.com/selenium/login.html";
	  Assert.assertEquals(currentURL, expectedURL);
  }
  @Test
  public void Loginbutton()//5
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://javabykiran.com/selenium/login.html");

	  boolean isLoginButtonDisplayed = driver.findElement(By.xpath("//button[text()='Login']")).isDisplayed();
	  Assert.assertTrue(isLoginButtonDisplayed);
  }
  @Test
  public void verifyLoginRedirect()//6
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://javabykiran.com/selenium/login.html");

	  driver.findElement(By.id("username")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("password123");
	  driver.findElement(By.xpath("//button[text()='Login']")).click();

	  String redirectedURL = driver.getCurrentUrl();
	  Assert.assertTrue(redirectedURL.contains("/dashboard"));
  }
  //login with invalid credential
  @Test
  public void verifyLogininvalidCredential()//7
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://javabykiran.com/selenium/login.html");

	  driver.findElement(By.id("username")).sendKeys("wronguser");
	  driver.findElement(By.id("password")).sendKeys("wrongpassword");
	  driver.findElement(By.xpath("//button[text()='Login']")).click();
	  WebElement errorMessage = driver.findElement(By.id("error"));
	  Assert.assertTrue(errorMessage.isDisplayed());
	  driver.close();
  }
  @Test
  public void verifyLoginFormPresence()//8
  {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://javabykiran.com/selenium/login.html");
	  boolean isFormPresent = driver.findElement(By.id("loginForm")).isDisplayed();
	  driver.close();
	  Assert.assertTrue(isFormPresent);
  }
  @Test
  public void verifyUsernameInputField()//9
  {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://javabykiran.com/selenium/login.html");
	  boolean isUserNameFieldPresent = driver.findElement(By.id("Username")).isDisplayed();
	  driver.close();
	  Assert.assertTrue(isUserNameFieldPresent);
  }
  @Test
  public void verifyPasswordInputField()//10
  {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://javabykiran.com/selenium/login.html");
	  boolean isPasswordFieldPresent = driver.findElement(By.id("password")).isDisplayed();
	  driver.close();
	  Assert.assertTrue(isPasswordFieldPresent);
  }
  @Test
  public void placeHolderinUsernameField()//11
  {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://javabykiran.com/selenium/login.html");
	  String actualPlaceHolder = driver.findElement(By.id("username")).getAttribute("placeholder");
	  String expectedPlaceHolder = "Enter your username";
	  driver.close();
	  Assert.assertEquals(actualPlaceHolder,expectedPlaceHolder);
  }
  //verify placeholder in password field
  @Test
  public void placeHolderinPasswordeField()//12
  {
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://javabykiran.com/selenium/login.html");
	  String actualPlaceHolder = driver.findElement(By.id("password")).getAttribute("placeholder");
	  String expectedPlaceHolder = "Enter your password";
	  driver.close();
	  Assert.assertEquals(actualPlaceHolder,expectedPlaceHolder);
  }
  @Test
  public void check()
  {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://javabykiran.com/selenium/login.html");
	// Test Case 13:
	  Assert.assertTrue(driver.findElement(By.linkText("Categories")).isDisplayed(), "Categories tab not found");

      // Test Case 14: Validate Subcategories Tab Presence
      Assert.assertTrue(driver.findElement(By.linkText("Subcategories")).isDisplayed(), "Subcategories tab not found");

      // Test Case 15: Validate Logout Button Presence
      Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed(), "Logout button not found");
      
      // Test Case 16: Validate Categories List Display
      driver.findElement(By.linkText("Categories")).click();
      Assert.assertTrue(driver.findElement(By.id("categoryTable")).isDisplayed(), "Categories table not displayed");

      // Test Case 17: Validate Add Category Button Functionality
       driver.findElement(By.id("addCategory")).click();
       Assert.assertTrue(driver.findElement(By.id("categoryNameInput")).isDisplayed(), "Add Category form not displayed");
       
       //Test Case 18:Verify the table contains "Mathematics"
       String category1 = driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
       Assert.assertEquals(category1, "Mathematics");
       
       //Test Case 19:Verify the table contains "Science"
       String category2 = driver.findElement(By.xpath("//tr[2]/td[2]")).getText();
       Assert.assertEquals(category2, "Science");
       
       //Test Case 20:Verify "Edit" button for Mathematics is displayed
       boolean isEditButtonMathematicsDisplayed = driver.findElement(By.xpath("//tr[1]//button[contains(@class,'edit')]")).isDisplayed();
       Assert.assertTrue(isEditButtonMathematicsDisplayed);
       
       //Test Case 21:Verify "Delete" button for Mathematics is displayed
       boolean isDeleteButtonMathematicsDisplayed = driver.findElement(By.xpath("//tr[1]//button[contains(@class,'delete')]")).isDisplayed();
       Assert.assertTrue(isDeleteButtonMathematicsDisplayed);
       
       //Test Case 22 :Verify "Edit" button for Science is displayed
       boolean isEditButtonScienceDisplayed = driver.findElement(By.xpath("//tr[2]//button[contains(@class,'edit')]")).isDisplayed();
       Assert.assertTrue(isEditButtonScienceDisplayed);
       
       //Test Case 23:Verify "Delete" button for Science is displayed
       boolean isDeleteButtonScienceDisplayed = driver.findElement(By.xpath("//tr[2]//button[contains(@class,'delete')]")).isDisplayed();
       Assert.assertTrue(isDeleteButtonScienceDisplayed);
       
       //Test Case 24:Verify Created At date for Mathematics
       String createdDateMath = driver.findElement(By.xpath("//tr[1]/td[3]")).getText();
       Assert.assertEquals(createdDateMath, "2024-11-07");
       
       //Test Case 25:Verify Modified At date for Mathematics
       String modifiedDateMath = driver.findElement(By.xpath("//tr[1]/td[4]")).getText();
       Assert.assertEquals(modifiedDateMath, "2024-11-08");
       
       //Test Case 26:Verify Created At date for Science
       String createdDateScience = driver.findElement(By.xpath("//tr[2]/td[3]")).getText();
       Assert.assertEquals(createdDateScience, "2024-11-07");
       
       //Test Case 27:Verify Modified At date for Science
       String modifiedDateScience = driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
       Assert.assertEquals(modifiedDateScience, "2024-11-08");
       
       //Test Case 28:Verify clicking "Edit" for Mathematics opens edit form
       driver.findElement(By.xpath("//tr[1]//button[contains(@class,'edit')]")).click();
       boolean isEditFormDisplayed = driver.findElement(By.id("edit-form")).isDisplayed(); // Assuming "edit-form" is the ID of the edit form
       Assert.assertTrue(isEditFormDisplayed);
       driver.navigate().back();
       
       //Test Case 29:Verify clicking "Delete" for Mathematics displays confirmation
       driver.findElement(By.xpath("//tr[1]//button[contains(@class,'delete')]")).click();
       String deleteConfirmationText = driver.switchTo().alert().getText();
       Assert.assertEquals(deleteConfirmationText, "Are you sure you want to delete this category?");
       driver.switchTo().alert().dismiss();
       
       //Test Case 30:Verify clicking "Edit" for Science opens edit form
       driver.findElement(By.xpath("//tr[2]//button[contains(@class,'edit')]")).click();
       isEditFormDisplayed = driver.findElement(By.id("edit-form")).isDisplayed();
       Assert.assertTrue(isEditFormDisplayed);
       driver.navigate().back();
       
       //Test Case 31:Verify clicking "Delete" for Science displays confirmation
       driver.findElement(By.xpath("//tr[2]//button[contains(@class,'delete')]")).click();
       deleteConfirmationText = driver.switchTo().alert().getText();
       Assert.assertEquals(deleteConfirmationText, "Are you sure you want to delete this category?");
       driver.switchTo().alert().dismiss();
       
       //Test Case 32: Verify the navigation menu contains "Logout"
       boolean isLogoutMenuDisplayed = driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed();
       Assert.assertTrue(isLogoutMenuDisplayed);
       
       //Test Case 33:Verify clicking "Logout" redirects to login page
       driver.findElement(By.xpath("//a[text()='Logout']")).click();
       String loginPageTitle = driver.getTitle();
       Assert.assertEquals(loginPageTitle, "Login - TKA");
       driver.navigate().back();
       
       //Test Case 34:Verify the "Add Category" button is displayed
       boolean isAddCategoryButtonDisplayed = driver.findElement(By.xpath("//button[text()='Add Category']")).isDisplayed();
       Assert.assertTrue(isAddCategoryButtonDisplayed);

      // Test Case 35: Validate Edit Category Functionality
        driver.findElement(By.xpath("//tr[td[text()='Mathematics']]//button[text()='Edit']")).click();
        Assert.assertTrue(driver.findElement(By.id("categoryNameInput")).isDisplayed(), "Edit Category form not displayed");

      // Test Case 36: Validate Delete Category Button
      driver.findElement(By.xpath("//tr[td[text()='Mathematics']]//button[text()='Delete']")).click();
      Assert.assertTrue(driver.switchTo().alert().getText().contains("Are you sure"), "Delete confirmation missing");
      driver.switchTo().alert().dismiss();

      
      // Test Case 37: Validate Logout Functionality
      driver.findElement(By.linkText("Logout")).click();
      Assert.assertEquals(driver.getTitle(), "Login - TKA", "Failed to logout");
      
      //Test Case 38:Verify the footer contains copyright text
      String footerText = driver.findElement(By.xpath("//footer")).getText();
      Assert.assertTrue(footerText.contains("© 2024 Kiran Academy"));

      driver.close();

  }
}
