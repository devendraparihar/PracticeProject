package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Untitled {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.40.83/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/doc/page/login.asp");
    driver.findElement(By.id("UserName")).clear();
    driver.findElement(By.id("UserName")).sendKeys("admin");
    driver.findElement(By.id("Password1")).clear();
    driver.findElement(By.id("Password1")).sendKeys("admin1`23");
    driver.findElement(By.id("UserName")).clear();
    driver.findElement(By.id("UserName")).sendKeys("admin");
    driver.findElement(By.id("Password1")).clear();
    driver.findElement(By.id("Password1")).sendKeys("admin123");
    driver.findElement(By.cssSelector("label[name=\"laConfig\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | ContentFrame | ]]
    driver.findElement(By.id("mz_8_link_9")).click();
    driver.findElement(By.id("recordScheduleEditBtn")).click();
    driver.findElement(By.id("alldaylist")).click();
    driver.findElement(By.id("CopyTo")).click();
    driver.findElement(By.cssSelector("td > input[name=\"ConfirmTips\"]")).click();
    driver.findElement(By.id("SelectAllBox")).click();
    driver.findElement(By.id("SaveConfigBtn")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.cssSelector("label[name=\"laPlayback\"]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | ContentFrame | ]]
    driver.findElement(By.id("CameraImg5")).click();
    driver.findElement(By.id("play")).click();
    driver.findElement(By.id("capture")).click();
    driver.findElement(By.id("StopAll")).click();
    driver.findElement(By.id("play")).click();
    driver.findElement(By.id("capture")).click();
  }

  @AfterClass(alwaysRun = true)
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
