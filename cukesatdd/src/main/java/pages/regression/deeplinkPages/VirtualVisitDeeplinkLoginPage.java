/**
 * 
 */
package pages.regression.deeplinkPages;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.login.ConfirmSecurityQuestion;

/**
 * @author pminhas
 *
 */
public class VirtualVisitDeeplinkLoginPage extends UhcDriver {

	@FindBy(xpath="//*[contains(@id,'submitBtn')]")
	private static  WebElement signIn;
	
	@FindBy(xpath="//*[contains(@id,'EMAIL')]")
	private static  WebElement username;
	
	@FindBy(xpath="//*[contains(@id,'PASSWORD')]")
	private static  WebElement password;
	
	@FindBy(xpath = "//*[contains(@onclick,'HSIDSignIn')]")
	private WebElement mnrSignInButton;
	
	@FindBy (xpath="//div[@class='col']//a[@class='btn btn-outline-primary'][contains(text(),'Continue')]")
	private static  WebElement conti;
	
	@FindBy(xpath = "(//*[contains(@class,'btn btn-outline-primary')])[1]")
	private WebElement homePageNotice;
	
	@FindBy(xpath = "//button/span[contains(text(),'Home Page')]")
	protected WebElement homePageNotice2;

	@FindBy(xpath = "//a[contains(text(),'Home Page')]")
	protected WebElement homePageNotice3;
	
	@FindBy(xpath = "//button[@class='btn btn-outline-primary text-transform-none home-btn']")
	protected WebElement homePageNotice4;

	@FindBy(id = "details-button")
	protected WebElement proxyPageAdvancedButton;
	
	@FindBy(id = "proceed-link")
	protected WebElement proxyPageProceedLink;
	
	@FindBy (xpath="//h1[@class='heading']")
    private WebElement textonpage;
	
	public VirtualVisitDeeplinkLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate()  {
				
	}
	//page from MR constants 	
			private static String UHC_DEEPLINK_URL_VirtualVisit = MRConstants.UHC_DEEPLINK_URL_VirtualVisit;
			private static String AARP_DEEPLINK_URL_VirtualVisit = MRConstants.AARP_DEEPLINK_URL_VirtualVisit;
			private static String PCP_DEEPLINK_URL_VirtualVisit = MRConstants.PCP_DEEPLINK_URL_VirtualVisit;
			private static String Medica_DEEPLINK_URL_VirtualVisit = MRConstants.Medica_DEEPLINK_URL_VirtualVisit;
			
			 /*This method will open virtualVisit deep link pages */
			public VirtualVisitDeeplinkLoginPage navigateToLoginURL(String brand){
				switch(brand) {
					case "UHC" :
						start(UHC_DEEPLINK_URL_VirtualVisit);
						break;
					case "AARP" :
						start(AARP_DEEPLINK_URL_VirtualVisit);
						break;
					case "PCP" :
						start(PCP_DEEPLINK_URL_VirtualVisit);
						break;
					case "Medica" :
						start(Medica_DEEPLINK_URL_VirtualVisit);
						break;
				}
				driver.manage().deleteAllCookies();

				try {
					Thread.sleep(10000);
					if(proxyPageAdvancedButton.isDisplayed()) {
						proxyPageAdvancedButton.click();
						CommonUtility.waitForPageLoadNewForClick(driver, proxyPageProceedLink, 30);
						proxyPageProceedLink.click();
					}
				} catch (Exception e) {
					System.out.println("proxy page not displayed");
				}
				return null;
				}
			
			// This method validated the elements on the DEEPLINK page 
			public void validatePageElements(){
				System.out.println(driver.getCurrentUrl());
				CommonUtility.waitForPageLoadNewForClick(driver, mnrSignInButton, 30);
				mnrSignInButton.click();
				validateNew(username);
				validateNew(password);
				validateNew(signIn);						
				username.clear();
				password.clear();				
			}
			/*This method will enter user name & password */
			   public void enterusername(String uname) {
							    	sendkeys(username, uname);
							        }
						   
			  public void enterpassword(String Password) {
						    	sendkeys(password, Password);
						        }
			  
			  /*Click continue & answer security question & covid page */
				public void clickSubmit() {			
					signIn.click();
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (driver.getCurrentUrl().contains("=securityQuestion")) {
						System.out.println("Landed on security question page...");

						ConfirmSecurityQuestion cs = new ConfirmSecurityQuestion(driver);
						try {
							cs.enterValidSecurityAnswer();
							System.out.println(driver.getCurrentUrl());
							System.out.println("Check to see if document.readyState is ready...");
							CommonUtility.checkPageIsReadyNew(driver);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//note: do not remove wait, need to give it enough time for the dashboard or error page to load
						System.out.println("Start to wait for the dashboard (or some form of error page) to load...");
												
						try {
							CommonUtility.checkPageIsReadyNew(driver);
						} catch (NullPointerException  e) {
							System.out.println("Sometimes may get NPE due to timing issue, give it one more try before giving up");
							CommonUtility.checkPageIsReadyNew(driver);
						}
						CommonUtility.checkPageIsReadyNew(driver);
						if (MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.equalsIgnoreCase("offline")
								|| MRScenario.environment.equalsIgnoreCase("prod")
								|| MRScenario.environment.equalsIgnoreCase("team-h")) {
							CommonUtility.checkPageIsReadyNew(driver);
							try
							{
								System.out.println("Waiting for continue button of banner page as banner doesn't appear everytime");
								CommonUtility.waitForPageLoad(driver, homePageNotice, 10);
							}
							catch (Exception e)
							{
								System.out.println("Catch block with no significance");
							}
							if (driver.getCurrentUrl().contains("bannerpopup.html")) {
								System.out.println("COVID 19 Banner page has appeared");
								try {
									CommonUtility.waitForPageLoad(driver, homePageNotice, 20);
									if (validate(homePageNotice, 0)) {
										homePageNotice.click();
										CommonUtility.checkPageIsReady(driver);
									} else if (validate(homePageNotice2, 0)) {
										homePageNotice2.click();
										CommonUtility.checkPageIsReady(driver);
									} else if (validate(homePageNotice3, 0)) {
										homePageNotice3.click();
										CommonUtility.checkPageIsReady(driver);
									}
									
									Thread.sleep(3000);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									System.out.println("Catch block");
								}
							} else {
								System.out.println("COVID 19 Banner page did not appear");
								System.out.println(driver.getCurrentUrl());	
							}
							if (driver.getCurrentUrl().contains("/no-email.html")) {
								System.out.println("No email page has appeared");
								try {
									CommonUtility.waitForPageLoad(driver, homePageNotice4, 20);
									if (validate(homePageNotice4, 0)) {
										homePageNotice4.click();
										CommonUtility.checkPageIsReady(driver);
									} 									
									Thread.sleep(3000);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									System.out.println("Catch block");
								}
							} else {
								System.out.println("NO emmail page did not appear");
							}
											
					return;
						}}}
					
				
				/**
				 * For iPerception Model
				 * @param driver
				 */
				public static void checkForIPerceptionModel(WebDriver driver) {
					int counter = 0;
					do {
						System.out.println("current value of counter: " + counter);
						List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

						if (IPerceptionsFrame.isEmpty()) {
							try {
								Thread.sleep(1500);
							} catch (InterruptedException e) {
								System.out.println(e.getMessage());
							}
						} else {
							driver.switchTo().frame(IPerceptionsFrame.get(0));
							driver.findElement(By.className("btn-no")).click();
							driver.switchTo().defaultContent();
						}
						counter++;
					} while (counter < 2);
				}				
								
				public boolean validateVirtualVisitPage() {
					checkForIPerceptionModel(driver);
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					CommonUtility.checkPageIsReadyNew(driver);	
					validateNew(textonpage);
					System.out.println("*** Page URL ***" + driver.getCurrentUrl());
					System.out.println("*** Page title ***" + driver.getTitle());
					if (driver.getCurrentUrl().contains("virtualcare.int.werally.in")) {
						Assert.assertTrue(driver.getTitle().contains("Virtual Care"));
					} else {
							Assert.fail("VirtualVisit page is not loaded through deeplink");
					}
					return true;
				}
				
}

