package tests;


import java.io.File;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import pages.PEnterConfFF;

public class Lite {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\VideoMost\\VideoMost lite\\VideoMost-lite.exe");
	  ProfilesIni profile = new ProfilesIni();
	  FirefoxProfile liteProfile = profile.getProfile("C:\\Users\\sukhov\\AppData\\Roaming\\VideoMost\\VideoMost-lite\\Profiles\\o4q93m2v.default");
	  driver = new FirefoxDriver(liteProfile);
	  driver.get("chrome://browser/content/homepage/index.html");
	  //driver.navigate().back();
	  
	  //baseUrl = "http://deb8-testlab.spiritcorp.com/service";
	  //driver.get(baseUrl);

  }

  @Test
  public void testUntitled() throws Exception {
	  
	  
	  //FirefoxProfile  fp = new ProfilesIni().getProfile("default");
	  
	  PEnterConfFF ff = new PEnterConfFF(driver);
		//fp.setEnableNativeEvents(false);	  
	  ff.enterConf("111","111","name");
	
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
