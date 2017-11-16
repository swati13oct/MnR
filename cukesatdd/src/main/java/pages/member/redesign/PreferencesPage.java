/**
 * 
 */
package pages.member.redesign;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**@author bnaveen4
 * 
 *
 */
public class PreferencesPage extends UhcDriver{

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath="//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//button[@id='save-prefs-btn']")
	private WebElement btnSavePreferences;
	
	@FindBy(xpath="//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//div[contains(@class,'benefits-coverage')]//a[contains(@class,'prefernce')]")
	private WebElement lnkProfilePreferences;
	
	@FindBy(xpath="//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope']")
	private WebElement paperlessPreferences;
	
	@FindBy(xpath="//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='goPaperless0']")
	private WebElement chkBox;
	
	@FindBy(xpath="//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//div[@class='message-block--full-width success margin-large']/div[1]/span")
	private WebElement successMessageHeading;
	
	@FindBy(xpath="//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//div[@class='message-block--full-width success margin-large']/div[2]/p")
	private WebElement confirmationMessageText;
	
	@FindBy(xpath="//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//label[@id='goPaperless0-error']")
	private WebElement mustAgreeTerms;
	
	@FindBy(xpath="//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//form[@id='preferences-form0']//p[contains(@class,'bold')]")
	private WebElement paperlessPreferencesHeading;
	
	@FindBy(xpath="//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//div[contains(@class,'card-header')]/span/p")
	private WebElement planNameHeading;
	
	@FindBy(xpath="//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//a[@title='Edit Preferences']")
	private WebElement editPreferencesLink;
	
	@FindBy(xpath="//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//a[@title='Back to My Profile']")
	private WebElement btnGoToMyAccount;
	
	@FindBy(xpath="//h2[@class='h3 medium margin-small']/p")
	private WebElement goGreenHeading;
	
	public PreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, addPlan, CommonConstants.TIMEOUT_30);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoad(driver, lnkProfilePreferences, 10);
		waitforElement(lnkProfilePreferences);
		validate(btnSavePreferences);
		if(driver.findElements(By.xpath("//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope']"))!=null){
			if(driver.findElements(By.xpath("//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//div[contains(@class,'preferences-wrapper')]/div[@class='ng-scope']")).size()>0){
				System.out.println("Paperless Preferences Radio buttons are loaded");
			}
		}
		validate(planNameHeading);
		Assert.assertTrue(validate(paperlessPreferencesHeading));
		//Assert.assertEquals("Go Green: Paperless Document Delivery", goGreenHeading.getText().trim());
	}
	
	public void selectpaperlessprefereneces(){
		chkBox = driver.findElement(By.xpath("//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='goPaperless0']"));
		chkBox.click();
	}
	
	public void savePreferences(){
		btnSavePreferences = driver.findElement(By.xpath("//div[contains(@class,'parsys overview')]/div[not (contains(@class,'ng-hide'))][1]//button[@id='save-prefs-btn']"));
		btnSavePreferences.click();
	}
	
	public void validatePlanName(String planName){
		Assert.assertEquals(planName.toLowerCase(),planNameHeading.getText().trim().toLowerCase());
	}
	
	public void validateConfirmationMessage(){
		waitforElement(successMessageHeading);
		Assert.assertEquals("Your delivery preferences have been updated.",successMessageHeading.getText().trim());
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
