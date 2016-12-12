/**
 * 
 */

package pages.mobile.member.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.mobile.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class LoginPage extends UhcDriver{
	
	private static String PAGE_URL = MRConstants.AARPM_MOBILE_URL;
	
	@FindBy(id="loginSTANDuser")
	private WebElement userNameField;

	@FindBy(id = "loginSTANDpass")
	private WebElement passwordField;

	@FindBy(xpath = ".//a[@dtmname='View ID Card']")
	private static WebElement viewIDCard;
	
	@FindBy(xpath = ".//*[contains(@class,'card__plan-name')]")
	private static WebElement aarpMedicareRxWalgreen;
	
	@FindBy(xpath = ".//*[contains(@class,'card__plan-name')]")
	private static WebElement aarpMedicareRxSaverPlus;

	@FindBy(id = "accessURAccountBTN")
	private WebElement signInButton;

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		start(PAGE_URL);
		validate(userNameField);
		validate(passwordField);
		validate(signInButton);
		
	}

	public BenefitsSummaryPage loginWith(String userName, String pwd) {
		sendkeys(userNameField, userName);
		sendkeys(passwordField, pwd);
		signInButton.click();
		
		if (MRScenario.environment.equals("dev-a")) {
			
			Alert alert = driver.switchTo().alert();
	        alert.accept();
	        Alert alert1 = driver.switchTo().alert();
	        alert1.accept();
	        Alert alert2 = driver.switchTo().alert();
	        alert2.accept();
	        }
		
		if(currentUrl().contains("mobile/home/my-benefit-summary.html"))
		{
			return new BenefitsSummaryPage(driver);
		}
		return null;
	}

	public static void clickOnViewIDCard() {
		viewIDCard.isDisplayed();
		viewIDCard.click();
		/*boolean present;
		try {
		prescriptiondrugcost.isDisplayed();
		prescriptiondrugcostandsummary.isDisplayed();
		present = true;
		} catch (NoSuchElementException e) {
		present = false;
		}

		if(present)
		System.out.println("@@@@@@@@@ Able to find My 2017 Prescription Drug Cost and Benefit Summary @@@@@@@@@");
		else
		System.out.println("@@@@@@@@@ No Optional Riders widget and deductible 3,4,5 @@@@@@@@@");
		*/

		
	}
	
	public static void verifyMedicareRxWalgreen(){
		aarpMedicareRxWalgreen.isDisplayed();
		
	}
	
	public static void verifyMedicareRxSaverPlus(){
		aarpMedicareRxSaverPlus.isDisplayed();
		
	}

	


	public JSONObject getBrowserCheck() {
			String fileName = CommonConstants.MOBILE_BROWSER_CHECK_DATA;
			browserCheckData = CommonUtility.readPageData(fileName,
					CommonConstants.PAGE_OBJECT_DIRECTORY_MOBILE_ULAYER_MEMBER);

			JSONObject jsonObject = new JSONObject();
			for (String key : browserCheckData.getExpectedData().keySet()) {
				WebElement element = findElement(browserCheckData.getExpectedData()
						.get(key));
				if (element != null) {
					if (validate(element)) {
						try {
							jsonObject.put(key, element.getText());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			browserCheckJson = jsonObject;

			return browserCheckJson;

		
	}

}
