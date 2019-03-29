/**
 * 
 */
package pages.vbfacquisition_deprecated.bluelayer;

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
import pages.vbfacquisition_deprecated.ulayer.PageTitleConstants;

/**
 * @author rkodumur
 *
 */
public class PrepareForInitialEnrollmentuhcPage extends GlobalWebElements{
	
	@FindBy(className = "bullet_list")
	private WebElement initalenrolluhclist;

	public  JSONObject initalenrolluhcJson;

	private PageData initalenrolluhcPage;


	public PrepareForInitialEnrollmentuhcPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(driver, this);
	String fileName = CommonConstants.INITIAL_ENROLL_PAGE_DATA;
	initalenrolluhcPage = CommonUtility.readPageData(fileName,
	CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
	openAndValidate();
	}

	@Override
	public void openAndValidate() {
	validate(exploreChangingPlansLink);
	validate(initalenrolluhclist);
	JSONObject jsonObject = new JSONObject();
	for (String key : initalenrolluhcPage.getExpectedData().keySet()) {
	WebElement element = findElement(initalenrolluhcPage.getExpectedData().get(key));
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
	initalenrolluhcJson = jsonObject;

	}

	public ExploreChangingPlansuhcPage exploreChangingPlansFooterClick() {
		validate(exploreChangingPlansLink);
		exploreChangingPlansLink.click();
		validate(exploreChangingPlansLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_CHANGE_MEDICARE_PLANS_UNITEDHEALTHCARE)){
			return new ExploreChangingPlansuhcPage(driver); 
		}
		return null;
		
		
	}

	public DiscoverMoreResourcesuhcPage discoverMoreResourcesClick() {
		validate(discoverMoreResourcesMedicareEducationLink);
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
        actions.moveToElement(navigationSectionMedicareEducationLink);
        actions.moveToElement(discoverMoreResourcesMedicareEducationLink);
        actions.click().build().perform();
        if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_DISCOVER_MORE_MEDICARE_RESOURCES_INFORMATION)) {
			return new DiscoverMoreResourcesuhcPage(driver);
		}else{
		
			return null;
			
		}
	}

}