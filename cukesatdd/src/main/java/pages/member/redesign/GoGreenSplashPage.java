/**
 * 
 */
package pages.member.redesign;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class GoGreenSplashPage extends UhcDriver{

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(id="save-prefs-btn")
	private WebElement btnSavePreferences;
	
	@FindBy(xpath="//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope']")
	private WebElement paperlessPreferences;
	
	@FindBy(xpath="//label[contains(@for,'goPaperless')]")
	private WebElement chkBox;
	
	@FindBy(xpath="//div[@class='message-block--full-width success margin-large']/div[1]/span")
	private WebElement successMessageHeading;
	
	@FindBy(xpath="//div[@class='message-block--full-width success margin-large']/div[2]/p[2]")
	private WebElement confirmationMessageText;
	
	@FindBy(id="goPaperless")
	private WebElement mustAgreeTerms;
	
	@FindBy(xpath="//form[@id='preferences-form']//p[@class='bold']")
	private WebElement paperlessPreferencesHeading;
	
	@FindBy(xpath="//div[@class='card-header']/p")
	private WebElement planNameHeading;
	
	@FindBy(xpath="//a[@title='Edit Preferences']")
	private WebElement editPreferencesLink;
	
	@FindBy(xpath="//a[@title='Back to My Profile']/p")
	private WebElement btnGoToMyAccount;
	
	@FindBy(xpath="//h2[@class='h3 medium margin-small']/p")
	private WebElement goGreenHeading;
	
	public GoGreenSplashPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, addPlan, CommonConstants.TIMEOUT_30);
		openAndValidate();
		
	}

	@Override
	public void openAndValidate() {
		start(MRConstants.GO_GREEN_SPLASH_URL);
		waitforElement(paperlessPreferences);
		validate(btnSavePreferences);
		if(driver.findElements(By.xpath("//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope']"))!=null){
			if(driver.findElements(By.xpath("//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope']")).size()>0){
				System.out.println("Paperless Preferences Radio buttons are loaded");
			}
		}
		validate(planNameHeading);
		Assert.assertEquals("Paperless Preferences", paperlessPreferencesHeading.getText().trim());
		Assert.assertEquals("Go Green: Paperless Document Delivery", goGreenHeading.getText().trim());
	}
	
	public void selectpaperlessprefereneces(){
		chkBox.click();
	}
	
	public void savePreferences(){
		btnSavePreferences = driver.findElement(By.id("save-prefs-btn"));
		btnSavePreferences.click();
	}
	
	public void validatePlanName(String planName){
		Assert.assertEquals(planName.toLowerCase(),planNameHeading.getText().trim().toLowerCase());
	}
	
	public void validateConfirmationMessage(){
		waitforElement(successMessageHeading);
		Assert.assertEquals("Your preferences have been updated",successMessageHeading.getText().trim());
		Assert.assertEquals("Thank you for choosing to Go Green! It may take up to two mail cycles for your updated delivery preferences to take effect."
				+ " Your mailing cycle-the length of time between documents-varies by document. When the paper mailings stop, you will receive an email "
				+ "notification alerting you that a new document has been posted to your online account.",confirmationMessageText.getText().trim());
		Assert.assertTrue(validate(editPreferencesLink));
		Assert.assertEquals("GO TO MY ACCOUNT HOME",btnGoToMyAccount.getText().trim());
	}
	
	public void validateErrorMessage(){
		waitforElement(mustAgreeTerms);
		Assert.assertEquals("You must agree to the terms and conditions",mustAgreeTerms.getText().trim());
	}

}
