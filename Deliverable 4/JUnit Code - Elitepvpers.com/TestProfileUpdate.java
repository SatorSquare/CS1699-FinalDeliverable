package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestProfileUpdate {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.elitepvpers.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testProfileUpdate() throws Exception {
    driver.get(baseUrl + "/forum/login.php?do=logout&logouthash=1417208810-0934a7467f018ebae3e3c17b456bce7311d8a7b6");
    driver.findElement(By.id("navbar_username")).clear();
    driver.findElement(By.id("navbar_username")).sendKeys("SatorSquare");
    driver.findElement(By.id("navbar_password")).clear();
    driver.findElement(By.id("navbar_password")).sendKeys("q12w3e4r");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    driver.findElement(By.linkText("Click here if your browser does not automatically redirect you.")).click();
    driver.findElement(By.linkText("SatorSquare")).click();
    driver.findElement(By.id("aboutme_tab")).click();
    driver.findElement(By.cssSelector("img[alt=\"Edit Value\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [isEditable | id=ctb_field1 | ]]
    driver.findElement(By.id("ctb_field1")).clear();
    driver.findElement(By.id("ctb_field1")).sendKeys("This is a Test");
    driver.findElement(By.id("submitbutton")).click();
    driver.findElement(By.cssSelector("#profilefield_title_2 > a > img[alt=\"Edit Value\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [isEditable | id=ctb_field2 | ]]
    driver.findElement(By.id("ctb_field2")).clear();
    driver.findElement(By.id("ctb_field2")).sendKeys("This is a Test");
    driver.findElement(By.id("submitbutton")).click();
    driver.findElement(By.cssSelector("#profilefield_title_3 > a > img[alt=\"Edit Value\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [isEditable | id=ctb_field3 | ]]
    driver.findElement(By.id("ctb_field3")).clear();
    driver.findElement(By.id("ctb_field3")).sendKeys("This is a Test");
    driver.findElement(By.id("submitbutton")).click();
    driver.findElement(By.cssSelector("#profilefield_title_4 > a > img[alt=\"Edit Value\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [isEditable | id=ctb_field4 | ]]
    driver.findElement(By.id("ctb_field4")).clear();
    driver.findElement(By.id("ctb_field4")).sendKeys("This is a Test");
    driver.findElement(By.id("submitbutton")).click();
    assertEquals("This is a Test", driver.findElement(By.id("profilefield_value_1")).getText());
    assertEquals("This is a Test", driver.findElement(By.id("profilefield_value_2")).getText());
    assertEquals("This is a Test", driver.findElement(By.id("profilefield_value_3")).getText());
    assertEquals("This is a Test", driver.findElement(By.id("profilefield_value_4")).getText());
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
