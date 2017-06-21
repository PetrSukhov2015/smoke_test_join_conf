package pages;


import java.util.Date;
import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PEnterConfFF {

	private String id;
	private String pass;
	private String name;
	private WebDriver driver;
	//private WritableSheet sheet;
	//private String e_name;

	public PEnterConfFF(WebDriver driver){
		//super(driver);
		this.driver=driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	public boolean enterConf(String id,String pass, String name){
		this.id = id;
		this.pass = pass;
		this.name = name;
    	try{ 
   
    		
    		
    		
    		
    		driver.findElement(By.cssSelector("a[href*=\"join\"]")).click();  
    		driver.findElement(By.cssSelector("input[name*=\"confid\"]")).clear();
    		driver.findElement(By.cssSelector("input[name*=\"confid\"]")).sendKeys(id);
    		driver.findElement(By.cssSelector("input[name*=\"confpass\"]")).clear();
    		driver.findElement(By.cssSelector("input[name*=\"confpass\"]")).sendKeys(pass);
    		driver.findElement(By.cssSelector("input[name*=\"name\"]")).clear();
    		driver.findElement(By.cssSelector("input[name*=\"name\"]")).sendKeys(name);
    		//add_error("Enter_conference: fields fill [ OK ]", e_name);
    	}catch (Exception e) {  
    		/*
    		shoter.shot(-1);
    		sheet = write(sheet, RESULT_F, 5, hor, 4);
    		comments = comments + "Fields fill failed. Please see .log file" + "\n";
    		sheet = write(sheet, "comments", 6, 1, 2);
    		sheet = write(sheet, comments, 6, hor, 2);
    		sheet = write(sheet, " ", 6, hor-1, 2);
    		if (debug)
    		*/
    		e.printStackTrace();
    		//add_error("Enter_conference: fields fill [FAIL]", e_name);
    		return false;
    	}
    	try{
    		driver.findElement(By.cssSelector("button[class*=\"enter-conf\"]")).click();
    		//driver.findElement(By.cssSelector(".btn1.enter-conf")).click();
    		//add_error("Enter_conference: Enter [ OK ]", e_name);
    	}catch (Exception e) {
    		/*
    		shoter.shot(-1);
    		sheet = write(sheet, RESULT_F, 5, hor, 4);
    		comments = comments + "Enter_conference failed. Please see .log file" + "\n";
    		sheet = write(sheet, "comments", 6, 1, 2);
    		sheet = write(sheet, comments, 6, hor, 2);
    		sheet = write(sheet, " ", 6, hor-1, 2);
    		if (debug)
    		*/
    		e.printStackTrace();
    		//add_error("Enter_conference: Enter [FAIL]", e_name);
    		return false;
    	}
    	try{
    		Thread.sleep(2000);
    		driver.findElement(By.cssSelector("div[id*=\"app\"]"));
    		int timeOut = 1;
    		
    		try
    		{
    			for (int i = 1; i < 20; i ++)
    			{
    				Thread.sleep(3000);
    				if (driver.findElement(By.cssSelector("div[class=\"popup_notice message\"]")).isDisplayed())
    					throw new IllegalStateException(driver.findElement(By.cssSelector("div[class=\"popup_notice message\"]")).getText());
    				//JavascriptExecutor js = (JavascriptExecutor) driver;
    				//String script = "document.getElementById('enter_notice').style.display = 'block';";
    				
    				
    				//String n = driver.findElement(By.id("enter_notice_bar")).getText(); // does not work (returns "" as expected)
    				//String myScript = "return arguments[0].innerText";
    				//n = (String) ((JavascriptExecutor) driver).executeScript(myScript, driver.findElement(By.id("enter_notice_bar")).getText());
    				
    				
    				//Object response = js.executeScript(script);		
    				//System.out.println(driver.findElement(By.id("enter_notice_bar")).getText());
    				if ("100%".equals(getText(driver,driver.findElement(By.id("enter_notice_bar"))))){
    					System.out.println("100% join");
    					break;
    				}
    				/*
    				if (!driver.findElement(By.cssSelector("span[id=\"enter_notice_bar\"]")).isDisplayed())
    					throw new NoSuchElementException("disappered");
    					else
    						add_error("Enter_conference: Entering conference..." +  i*3 + " sec", e_name);
    						*/
    				//Thread.sleep(10000);
    			}
    			
    		}
    		
    		catch (IllegalStateException ie)
    		{
    			/*
    			shoter.shot(-1);
        		sheet = write(sheet, RESULT_F, 5, hor, 4);
        		comments = comments + "Conference load failed: " + ie.getMessage() + ". Please see .log and .png file" + "\n";
        		sheet = write(sheet, "comments", 6, 1, 2);
        		sheet = write(sheet, comments, 6, hor, 2);
        		sheet = write(sheet, " ", 6, hor-1, 2);
        		if (debug)
        		ie.printStackTrace();
        		add_error("Enter_conference: Conference load [FAIL]: " + ie.getMessage(), e_name);
        		*/
        		return false;
    		}
    		catch  (NoSuchElementException e)

    		{	//вход состоялся
    			/*
    			sheet = write(sheet, RESULT_S, 5, hor, 5);
        		sheet = write(sheet, " ", 6, hor, 2);
        		sheet = write(sheet, " ", 6, hor-1, 2);
        		add_error("Enter_conference: Conference load [ OK ]", e_name);*/
    		}
    			   		
    	}
    	catch (Exception e)
    	{
    		/*
    		shoter.shot(-1);
    		sheet = write(sheet, RESULT_F, 5, hor, 4);
    		if (debug)
    			comments = comments + "Conference load failed: " + e.getMessage() + ". Please see .log and .png file" + "\n";
    		else
    			comments = comments + "Conference load failed: " + ". Please see .log and .png file" + "\n";
    		sheet = write(sheet, "comments", 6, 1, 2);
    		sheet = write(sheet, comments, 6, hor, 2);
    		sheet = write(sheet, " ", 6, hor-1, 2);
    		if (debug)
    		e.printStackTrace();
    		add_error("Enter_conference: Conference load [FAIL] ", e_name);
    		*/
    		return false;
    		
    	}
    	return true;
    	
	
	}

	public static String getText(WebDriver driver, WebElement element){
	    return (String) ((JavascriptExecutor) driver).executeScript(
	        "return jQuery(arguments[0]).text();", element);
	}

}
