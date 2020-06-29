package pages.regression.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;

public class SaveProfilePrefrencePage extends UhcDriver {
	
	@FindBy(xpath = ".//*[@id='paperlessDelivery']")
	private  WebElement Chooseonline;
	
	@FindBy(xpath=".//*[@id='mailDelivery']")
	private WebElement choosemaildelivery;
	
	@FindBy(xpath = ".//*[@id='save-prefs-btn']")
	private WebElement saveprefbutton;
	
	@FindBy (xpath=".//*[@id='review']")
	private WebElement reviewradiobutton;
	
	@FindBy (xpath =".//*[@id='preferences-form']/div/div[1]/div[2]/p[1]/button")
	//@FindBy(xpath="//[contains(text(), 'goToHomePage')]")
	private WebElement gotohomepage;
	
	@FindBy(id = "hsid-username")
	private WebElement userNameField;

	@FindBy(id = "hsid-password")
	private WebElement passwordField;

	@FindBy(id = "hsid-submit")
	private static WebElement signInButton;
	
	
	public SaveProfilePrefrencePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	
	 /**
     * Open and validate screen is shown.
     *
     * @return 
     * @see atdd.framework.UHCDriver#openAndValidate()
     */
    @Override
    public void openAndValidate() {
	
	WebDriverWait wait = new WebDriverWait(driver,40);	
    }
    //This method validates the page title 
    public void verifyTitleOfPage() {
    	 try {
 			Thread.sleep(50000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
   		System.out.println("%%% Now checking the title of Prefrence Page %%%");
   		String title = driver.getTitle();
   		System.out.println("The title of the page is ==> " +title);
   	 if (getTitle().equalsIgnoreCase("member-registration-gogreen-splash")) {
    	 
  	   System.out.println("On the go green splash page "); 
   	 }
   		
   	}
    
    // This method validates the online delivery prefrences page's elements 
    public  void validateonlinedelivery(){
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  driver.getCurrentUrl();
	  System.out.println(driver.getCurrentUrl());
	  try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		if(currentUrl().contains("member-registration-gogreen-splash.html#/individual-federal") || currentUrl().contains("/dashboard"))
		{			    
				System.out.println(driver.getCurrentUrl());
				System.out.println(" %%% On Save Pref page %%% ");
				 try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		}
		validate (Chooseonline);
		  System.out.println("*** Choose online Delivery ***" + Chooseonline.isDisplayed());
		validate (choosemaildelivery);
		  System.out.println("*** choose mail delivery Delivery ***" + choosemaildelivery.isDisplayed());
		  validate (saveprefbutton);
		  System.out.println("*** save pref button ***" + saveprefbutton.isDisplayed());
		  validate (reviewradiobutton);
		  System.out.println("*** review check button ***" + reviewradiobutton.isDisplayed());
		  Chooseonline.click();
		  reviewradiobutton.click();
		  saveprefbutton.click();
		  try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  validate(gotohomepage);
		  gotohomepage.click();
		   
   }
	public AccountHomePage NavigateToAccHomePage() { 
		
		  return new AccountHomePage(driver);
	}}
