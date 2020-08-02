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
public class myDocumentsDeeplinkLoginPage extends UhcDriver {

	@FindBy(xpath="//*[contains(@id,'submitBtn')]")
	private static  WebElement signIn;
	
	@FindBy(xpath="//*[contains(@id,'EMAIL')]")
	private static  WebElement username;
	
	@FindBy(xpath="//*[contains(@id,'PASSWORD')]")
	private static  WebElement password;
	
	@FindBy(xpath = "//*[contains(@onclick,'HSIDSignIn')]")
	private WebElement mnrSignInButton;
	
	
	@FindBy(xpath = "(//*[contains(@class,'btn btn-outline-primary')])[1]")
	private WebElement homePageNotice;
	
	@FindBy(xpath = "//button/span[contains(text(),'Home Page')]")
	protected WebElement homePageNotice2;

	@FindBy(xpath = "//a[contains(text(),'Home Page')]")
	protected WebElement homePageNotice3;
	@FindBy(xpath = "//button[@class='btn btn-outline-primary text-transform-none home-btn']")
	protected WebElement homePageNotice4;

	public myDocumentsDeeplinkLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate()  {
				
	}
	//page from MR constants 	
			private static String STAGE_DEEPLINK_URL_my_Documents = MRConstants.STAGE_DEEPLINK_URL_my_Documents;
			
			 /*This method will open payments deep link page */
			public myDocumentsDeeplinkLoginPage navigateToLoginURL(){
				start(STAGE_DEEPLINK_URL_my_Documents);
				driver.manage().deleteAllCookies();

				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				return null;
				}
			
			// This method validated the elements on the DEEPLINK page 
			public void validatePageElements(){
				System.out.println(driver.getCurrentUrl());
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
						//note: do not remove wait, need to give it enough time for the dashboard or error page to load
						System.out.println("Start to wait for the dashboard (or some form of error page) to load...");
												
						try {
							CommonUtility.checkPageIsReadyNew(driver);
						} catch (NullPointerException  e) {
							System.out.println("Sometimes may get NPE due to timing issue, give it one more try before giving up");
							CommonUtility.checkPageIsReadyNew(driver);
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
						}}
				}
					
				
				@FindBy (xpath="//h1[@class='main-heading margin-none']")
                private WebElement textonpage;
				
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
				
				public boolean validateMyDocumentsPage() {
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					checkForIPerceptionModel(driver);
					CommonUtility.checkPageIsReadyNew(driver);	
					validateNew(textonpage);
					if (driver.getCurrentUrl().contains("documents/overview.html?deeplink=true")) {
						System.out.println("*** Page URL ***" + driver.getCurrentUrl());
						System.out.println("** User landed on My Documents deeplink Page **");
						System.out.println("*** PageTitle ***" + driver.getTitle());
						Assert.assertTrue(driver.getTitle().contains("Plan Documents & Resources"));
						return true;
						} else {
							Assert.fail("The element " + textonpage.getText() + "is not found");
						}
										
						return true;							
					
				}
				
				
}

