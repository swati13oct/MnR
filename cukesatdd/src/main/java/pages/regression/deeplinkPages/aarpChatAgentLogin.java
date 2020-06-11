/**
 * 
 */
package pages.regression.deeplinkPages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author pminhas
 *
 */
public class aarpChatAgentLogin extends UhcDriver {

	@FindBy(xpath=" //button[@id='wweLoginSignInButton']")
	private static  WebElement signIn;
	
	@FindBy(xpath="//input[@id='wweLoginUserNameField']")
	private static  WebElement username;
	
	@FindBy(xpath="//input[@id='wweLoginPasswordField']")
	private static  WebElement password;
	
	@FindBy (xpath="//div[@class='col']//a[@class='btn btn-outline-primary'][contains(text(),'Continue')]")
	private static  WebElement conti;

	public aarpChatAgentLogin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate()  {
				
	}
	//page from MR constants 	
			private static String AARP_CHAT_AGENT = MRConstants.AARP_CHAT_AGENT;
			
			 /*This method will open deep link page */
			public aarpChatAgentLogin navigateToLoginURL(){
				start(AARP_CHAT_AGENT);
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
				
				validateNew(username);
			//	username.sendKeys("AARPStage2");
				validateNew(password);
				validateNew(signIn);						
				username.clear();
				password.clear();				
			}
			/*This method will enter user name & password */
			   public static void enterusername(String uname) {
							    	sendkeys(username, uname);
							        }
						   
			  public static void enterpassword(String Password) {
						    	sendkeys(password, Password);
						        }
			  
			  /*Click continue & answer security question & covid page */
				public static void clickSubmit() {			
					signIn.click();
					/*try {
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
						System.out.println(driver.getCurrentUrl());	
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						validateNew(conti);
						if (validate(conti))

							Assert.assertTrue(true);
						
						else
							Assert.fail("** The element is not visible**" + conti);

					}
						try {
							Thread.sleep(20000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						conti.click();*/
						
					return;
						}
					
				
				//@FindBy (xpath="/div[@class='title'][contains(text(),'Workspace')]")
				@FindBy(xpath="//button[@id='wweAgentSwitchStateButton']")
                private WebElement agent;
				
				@FindBy(xpath="//a[@id='wweAgentSetReadyItem_AgentStateView']")
                private WebElement agentstatusReady;				
								
				@FindBy(xpath="//a[@id='wweAgentSetLogOffItem_AgentStateView']")
                private WebElement agentstatusLogoff;
				
				public boolean aarpchatagentreadystate() {
					try {
						Thread.sleep(10000);
						//addexplicit wait
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//validateNew(agent);
					try {
						agent.click(); 					
						System.out.println("*** agent clicked ***");
						agentstatusReady.click();
						System.out.println("*** agent status clicked ***");
						// if status is ready then login as member 
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println("*** agent not 1 clicked ***");
						e1.printStackTrace();
						System.out.println("*** agent not 2 clicked ***");
					}
					if (driver.getCurrentUrl().contains("ui/ad/v1/index.html")) {
						System.out.println("*** Page URL ***" + driver.getCurrentUrl());
					//	System.out.println("** User landed on Account Setting deeplink Page **");
						System.out.println("*** PageTitle ***" + driver.getTitle());
						Assert.assertTrue(driver.getTitle().contains("Workspace"));
					 try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						//validateNew(agent);
						return true;
						} else {
							Assert.fail("The element " +agent.getText() + "is not found");
						}
										
						return true;	
					}
				
				
}

