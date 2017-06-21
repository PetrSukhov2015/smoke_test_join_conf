package pages;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;





import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * webRTC join Page
 *@author sukhov
 */

public class PEnterConfWebRTCFF  {
	/*
	 * locators
	 */
	public static final String idLocalVideo = "jingle-localView";
	@FindBy(id = "jingle-localView")
	private WebElement jingleLocalView;
	
	public static final String cssJoinTab = "a[href*='/service/join']";
	@FindBy(css = "a[href*='/service/join']")
	private WebElement joinSpan;
	
	public static final String idCogwheelButton = "chconf_type_choose";
	
	public static final String idWrtcButton = "btn_wrtc";
	@FindBy(id = "btn_wrtc")
	private WebElement btnWrtc;
	
	public static final String cssConfIdField = "input[name*=\"confid\"]";
	@FindBy(css = "input[name*=\"confid\"]")
	private WebElement confIdField;
	
	public static final String cssConfPassField = "input[name*=\"confpass\"]";
	@FindBy(css = "input[name*=\"confpass\"]")
	private WebElement confPassField;
	
	public static final String cssConfUserNameField = "input[name*=\"name\"]";
	@FindBy(css = "input[name*=\"name\"]")
	private WebElement confNameField;
	
	public static final String cssBigBlueeButton = "button[class*=\"big-button enter-conf\"]";
	@FindBy(css = "button[class*=\"big-button enter-conf\"]")
	private WebElement BigBlueButton;

	@FindBy(css = "div.join-error")
	private WebElement joinError;

	private WebDriver driver;

	/*public PEnterConfChrome(WebDriver driver) {
		this.driver=driver;
		
		// TODO Auto-generated constructor stub
	}*/
	public PEnterConfWebRTCFF(WebDriver driver)
	{	 
       PageFactory.initElements(driver, this);
       this.driver = driver;	
    }

	public boolean joinConf(String id,String pass,String name){

    	try{     		
    	
    		
    		joinSpan.click();    		
    		btnWrtc.click();
    		confIdField.clear();
    		confIdField.sendKeys(id);
    		confPassField.clear();    		
    		confPassField.sendKeys(pass);
    		confNameField.clear();
    		confNameField.sendKeys(name);
    		
    		/*driver.findElement(By.cssSelector(cssJoinTab)).click();
    		driver.findElement(By.id(idWrtcButton)).click();
    		driver.findElement(By.cssSelector(cssConfIdField)).clear();
    		driver.findElement(By.cssSelector(cssConfIdField)).sendKeys(id);
    		driver.findElement(By.cssSelector(cssConfPassField)).clear();
    		driver.findElement(By.cssSelector(cssConfPassField)).sendKeys(pass);
    		driver.findElement(By.cssSelector(cssConfUserNameField)).clear();
    		driver.findElement(By.cssSelector(cssConfUserNameField)).sendKeys(name);
    		*/
    		
    	}catch (Exception e) {      	
    		e.printStackTrace();
    		return false;
    	}
    	try{
    		//driver.findElement(By.cssSelector(cssBigBlueeButton)).click();
    		BigBlueButton.click();

    	}catch (Exception e) {
    		System.out.println("no blue button");
    		e.printStackTrace();
    		return false;
    	}
    	try{
    		Thread.sleep(2000);
    		if (isElementPresent(By.cssSelector("div.join-error"))){//<div class="join-error">Invalid conference ID or password</div>){
    		//if (isElementPresent(joinError)){
    			System.out.println("Invalid conference ID or password");
    			throw new Exception("join error");
    		}
    		//driver.findElement(By.cssSelector("div[id*=\"app\"]"));
    		int timeOut = 1;
    		
    		try
    		{
    			for (int i = 1; i < 20; i ++)
    			{
    				Thread.sleep(3000);     			    

    				if (driver.findElements(By.id(idLocalVideo)).size() > 0){
    				//if (null != jingleLocalView){
    					System.out.println("success");
    					break;
    				}
    		
    			}
    			
    		}
    		
    		catch (IllegalStateException ie)
    		{
    			
        		return false;
    		}
    		catch  (NoSuchElementException e)

    		{	
    		}
    			   		
    	}
    	catch (Exception e)
    	{
    		
    		return false;
    		
    	}
    	return true;
    	
	
	}
	private boolean isElementPresent(WebElement joinError2) {
		// TODO Auto-generated method stub
		return false;
	}

	private void changeHttps() {
		String url=driver.getCurrentUrl();	    
		url=url.replace("http", "https");		
		driver.get(url);	
	}
	private void changeFlags() {
		
		
	}
	  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }


}

