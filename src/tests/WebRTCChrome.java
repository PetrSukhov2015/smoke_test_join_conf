package tests;


import java.io.File;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import pages.PEnterConfChrome;
import pages.PEnterConfFF;

public class WebRTCChrome {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
/*
	  System.setProperty("webdriver.chrome.driver", "C:\\git2\\smoke-test-WebRTC-join-conf\\rel_1.0.0\\source\\lib\\chromedriver.exe");
	  DesiredCapabilities caps = DesiredCapabilities.chrome(); 
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--use-fake-ui-for-media-stream");
	  caps.setCapability(ChromeOptions.CAPABILITY, options);
	  
	  driver = new ChromeDriver(caps);
	  BaseUrl = "https://deb-testlab.spiritcorp.com/service/";
	  driver.get(baseUrl);*/
	  baseUrl="https://altlinux7-64-51.spiritcorp.com/service/";
	  String NodeURL="http://localhost:4444/wd/hub";
	  //System.setProperty("webdriver.chrome.driver", "C:\\git2\\smoke-test-WebRTC-join-conf\\rel_1.0.0\\source\\lib\\chromedriver.exe");
		 
	    DesiredCapabilities capa =DesiredCapabilities.chrome();
	    capa.setBrowserName("chrome");
	    capa.setPlatform(Platform.ANY);
	    driver=new RemoteWebDriver(new URL(NodeURL),capa);
	    driver.get(baseUrl);
  }

  @Test
  public void testUntitled() throws Exception {
	  
	  
	  //FirefoxProfile  fp = new ProfilesIni().getProfile("default");
	  
	  PEnterConfChrome cr = new PEnterConfChrome(driver);
		//fp.setEnableNativeEvents(false);	  
	  
	  cr.joinConf("1001","1001","name");
	
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
