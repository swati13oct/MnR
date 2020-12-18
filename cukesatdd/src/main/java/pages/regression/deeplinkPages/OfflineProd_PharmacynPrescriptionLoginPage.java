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
public class OfflineProd_PharmacynPrescriptionLoginPage extends UhcDriver {

	@FindBy(xpath="//*[contains(@id,'submitBtn')]")
	private static  WebElement signIn;
	
	@FindBy(xpath="//*[contains(@id,'EMAIL')]")
	private static  WebElement username;
	
	@FindBy(xpath="//*[contains(@id,'PASSWORD')]")
	private static  WebElement password;
	
	@FindBy(xpath = "//*[contains(@onclick,'HSIDSignIn')]")
	private WebElement mnrSignInButton;
	
	//@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	@FindBy(xpath="//button[contains(@class,'btn btn-primary btn-block')]")
	private static WebElement offlineSignin;
	
	
	
	@FindBy(xpath = "//h3[contains(text(),'Support for UnitedHealthcare members')]")
	private WebElement textonpage1;
	
	@FindBy(xpath = "(//*[contains(@class,'btn btn-outline-primary')])[1]")
	private WebElement homePageNotice;
	
	@FindBy(xpath = "//button/span[contains(text(),'Home Page')]")
	protected WebElement homePageNotice2;

	@FindBy(xpath = "//a[contains(text(),'Home Page')]")
	protected WebElement homePageNotice3;
	@FindBy(xpath = "//button[@class='btn btn-outline-primary text-transform-none home-btn']")
	protected WebElement homePageNotice4;

	public OfflineProd_PharmacynPrescriptionLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate()  {
				
	}
	//page from MR constants 	
	 public static final String Offline_PROD_UHC_DEEPLINK_URL_HWP ="https://offline.myuhcmedicare.com/hwp";
	  public static final String Offline_PROD_AARP_DEEPLINK_URL_HWP ="https://offline.myaarpmedicare.com/hwp";
	  public static final String Offline_PROD_PCP_DEEPLINK_URL_HWP ="https://offline.mypcpmedicare.com/hwp";
	  public static final String Offline_PROD_Medica_DEEPLINK_URL_HWP ="https://offline.mymedicamedicare.com/hwp";
			
			 /*This method will open deep link page */
			public OfflineProd_PharmacynPrescriptionLoginPage navigateToLoginURL(String brand){
				
				switch (brand) {
				case "UHC":
					start(Offline_PROD_UHC_DEEPLINK_URL_HWP);
					break;
				case "AARP":
					start(Offline_PROD_AARP_DEEPLINK_URL_HWP);
					break;
				case "PCP":
					start(Offline_PROD_PCP_DEEPLINK_URL_HWP);
					break;
				case "Medica":
					start(Offline_PROD_Medica_DEEPLINK_URL_HWP);
					break;
				}
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
				validateNew(offlineSignin);			
			}
			
					
				
				@FindBy (xpath="//span[@class='hw-title__text']")
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
				
				public boolean validateOfflineProdHWPPage() {
					checkForIPerceptionModel(driver);
					CommonUtility.checkPageIsReadyNew(driver);	
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					validateNew(textonpage1);
					System.out.println("*** Page URL ***" + driver.getCurrentUrl());
					System.out.println("*** PageTitle ***" + driver.getTitle());
					if (driver.getCurrentUrl().contains("SMSR/sso/outbound%3foutboundTo=solutran")) {
						System.out.println("*** Page URL ***" + driver.getCurrentUrl());
						System.out.println("** User landed on solutran deeplink **");
						System.out.println("*** PageTitle ***" + driver.getTitle());
						Assert.assertTrue(driver.getTitle().contains("UnitedHealthcare Medicare Member Sign In"));
						return true;
						} else {
							Assert.fail("The element " + textonpage1.getText() + "is not found");
						}
										
						return true;	
					}
				
				
}

