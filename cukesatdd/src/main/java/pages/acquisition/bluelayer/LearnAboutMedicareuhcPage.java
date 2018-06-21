/**
 * 
 */
package pages.acquisition.bluelayer;

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
import pages.acquisition.ulayer.PageTitleConstants;

/**
 * @author rkodumur
 *
 */
public class LearnAboutMedicareuhcPage extends GlobalWebElements{
	@FindBy(className = "bullet_list")
	private WebElement learnaboutMedicareuhc;

	public  JSONObject learnaboutMedicareuhcJson;

	private PageData learnaboutMedicareuhcPage;

	public LearnAboutMedicareuhcPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	String fileName = CommonConstants.LEARN_ABOUT_PLAN_PAGE_DATA;
	learnaboutMedicareuhcPage = CommonUtility.readPageData(fileName,
	CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
	openAndValidate();
	}

	@Override
	public void openAndValidate() {
	validate(prepareForInitialEnrollmentLink);
	validate(learnaboutMedicareuhc);
	JSONObject jsonObject = new JSONObject();
	for (String key : learnaboutMedicareuhcPage.getExpectedData().keySet()) {
	WebElement element = findElement(learnaboutMedicareuhcPage.getExpectedData().get(key));
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
	learnaboutMedicareuhcJson = jsonObject;

	}

	public PrepareForInitialEnrollmentuhcPage prepareForInitialEnrollmentFooterClick() {
		validate(prepareForInitialEnrollmentLink);
		prepareForInitialEnrollmentLink.click();
		validate(prepareForInitialEnrollmentLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_PREPARE_FOR_YOUR_MEDICARE_INITIAL_ENROLLMENT_PERIOD)){
			return new PrepareForInitialEnrollmentuhcPage(driver);
		}
		return null;
	}

	public ExploreChangingPlansuhcPage exploreChangingPlansClick() {
		validate(exploreChangingPlansMedicareEducationLink);
		Actions actions = new Actions(driver);
	    actions.moveToElement(navigationSectionMedicareEducationLink);
	    actions.moveToElement(exploreChangingPlansMedicareEducationLink);
	    actions.click().build().perform();
	    validate(navigationSectionMedicareEducationLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_CHANGE_MEDICARE_PLANS_UNITEDHEALTHCARE)) {
			return new ExploreChangingPlansuhcPage(driver);
		}else{
		
			return null;
			
		}
	}

}
