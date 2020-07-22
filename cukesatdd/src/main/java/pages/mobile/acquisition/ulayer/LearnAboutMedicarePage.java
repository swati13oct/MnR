package pages.mobile.acquisition.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;



public class LearnAboutMedicarePage extends GlobalWebElements {
	@FindBy(className = "bullet_list")
	private WebElement learnaboutMedicare;

	public  JSONObject learnaboutMedicareJson;

	private PageData learnaboutMedicarePage;

	public LearnAboutMedicarePage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	String fileName = CommonConstants.LEARN_ABOUT_PLAN_PAGE_DATA;
	learnaboutMedicarePage = CommonUtility.readPageData(fileName,
	CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
	openAndValidate();
	}

	@Override
	public void openAndValidate() {
	validate(prepareForInitialEnrollment);
	validate(learnaboutMedicare);
	JSONObject jsonObject = new JSONObject();
	for (String key : learnaboutMedicarePage.getExpectedData().keySet()) {
	WebElement element = findElement(learnaboutMedicarePage.getExpectedData().get(key));
	if (null != element) {
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
	learnaboutMedicareJson = jsonObject;

	}


public PrepareforInitialEnrollmentPage prepareforInitialEnrollmentFooterClick() {
		validate(medicareSupplementInsurancePlansLink);
		prepareForInitialEnrollment.click();
		validate(medicareSupplementInsurancePlansLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_MEDICARE_INITIAL_ENROLLMENT_PERIOD)) {
			return new PrepareforInitialEnrollmentPage(driver);
		}else{
		
			return null;
			
		}
		
	}

}
