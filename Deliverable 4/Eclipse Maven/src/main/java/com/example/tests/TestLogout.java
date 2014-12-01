package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestLogout {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.elitepvpers.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(baseUrl + "/forum/login.php?do=logout&logouthash=1417209388-e96723e9c1625144d605e9783326e21d4560c4c6");
    driver.findElement(By.id("navbar_username")).clear();
    driver.findElement(By.id("navbar_username")).sendKeys("SatorSquare");
    driver.findElement(By.id("navbar_password")).clear();
    driver.findElement(By.id("navbar_password")).sendKeys("q12w3e4r");
  }

  @Test
  public void testLogout() throws Exception {
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Click here if your browser does not automatically redirect you.")).click();
    driver.get(baseUrl + "/forum/");
    driver.findElement(By.linkText("Log Out")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to log out[\\s\\S]$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
