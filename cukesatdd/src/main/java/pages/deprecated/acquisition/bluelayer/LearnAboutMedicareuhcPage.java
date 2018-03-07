/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

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
import pages.deprecated.acquisition.bluelayer.GlobalWebElements;

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
	validateNew(prepareForInitialEnrollmentLink);
	validateNew(learnaboutMedicareuhc);
	JSONObject jsonObject = new JSONObject();
	for (String key : learnaboutMedicareuhcPage.getExpectedData().keySet()) {
	WebElement element = findElement(learnaboutMedicareuhcPage.getExpectedData().get(key));
	if (null != element) {
	if (validateNew(element)) {
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
		validateNew(prepareForInitialEnrollmentLink);
		prepareForInitialEnrollmentLink.click();
		validateNew(prepareForInitialEnrollmentLink);
		if(driver.getTitle().equalsIgnoreCase("Prepare for Your Medicare Initial Enrollment Period | UnitedHealthcare®")){
			return new PrepareForInitialEnrollmentuhcPage(driver);
		}
		return null;
	}

	public ExploreChangingPlansuhcPage exploreChangingPlansClick() {
		validateNew(exploreChangingPlansMedicareEducationLink);
		Actions actions = new Actions(driver);
	    actions.moveToElement(navigationSectionMedicareEducationLink);
	    actions.moveToElement(exploreChangingPlansMedicareEducationLink);
	    actions.click().build().perform();
	    validateNew(navigationSectionMedicareEducationLink);
		if (driver.getTitle().equalsIgnoreCase("Change Medicare Plans | UnitedHealthcare®")) {
			return new ExploreChangingPlansuhcPage(driver);
		}else{
		
			return null;
			
		}
	}

}
