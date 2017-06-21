

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

public class Main3 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  /*
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\sukhov\\Desktop\\geckodriver-v0.15.0-win64\\geckodriver.exe");
		
	  DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	  capabilities.setCapability("marionette", false);
	  capabilities.setCapability("firefox_binary",
			  new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
	  WebDriver driver = new FirefoxDriver(capabilities);
	  */
	  ProfilesIni profile = new ProfilesIni();
	  FirefoxProfile ffprofile = profile.getProfile("C:\\Users\\sukhov\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\1zc3kphw.test");
	  driver = new FirefoxDriver(ffprofile);
	  
	  
	  /*
	  FirefoxProfile profile = new FirefoxProfile();
	  File extension = new File("C:\\Users\\sukhov\\Desktop\\ffwmplugin_5.5.0.309.xpi");
	  profile.addExtension(extension);
	  WebDriver driver = new FirefoxDriver(profile);
	  */
	  baseUrl = "http://deb8-testlab.spiritcorp.com/service";
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //driver.get(baseUrl);
  }

  @Test
  public void testUntitled() throws Exception {
	  
	  driver.get(baseUrl);
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
