package pages.acquisition.ulayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;

public class PrepareforInitialEnrollmentPage extends GlobalFooterWebElements {
	@FindBy(className = "bullet_list")
	private WebElement initalenrolllist;
	
	public  JSONObject initalenrollJson;
	
	private PageData initalenrollPage;
	
	public PrepareforInitialEnrollmentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.INITIAL_ENROLL_PAGE_DATA;
		initalenrollPage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(exploreChangingPlansLink);
			validate(initalenrolllist);
		JSONObject jsonObject = new JSONObject();
		for (String key : initalenrollPage.getExpectedData().keySet()) {
			WebElement element = findElement(initalenrollPage.getExpectedData().get(key));
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
		initalenrollJson = jsonObject;
		
	}
	
	public ExploreChangingPlansPage exploreChangingPlansFooterClick() {
		validate(medicareSupplementInsurancePlansLink);
		exploreChangingPlansLink.click();
		validate(medicareSupplementInsurancePlansLink);
		if (driver.getTitle().equalsIgnoreCase("Change Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new ExploreChangingPlansPage(driver);
		}else{
		
			return null;
			
		}
		
	}

	public DiscoverMoreResourcesPage discoverMoreResourcesClick() {
		validate(discoverMoreResourcesMedicareEducationLink);
		Actions actions = new Actions(driver);
        actions.moveToElement(navigationSectionMedicareEducationLink);
        actions.moveToElement(discoverMoreResourcesMedicareEducationLink);
        actions.click().build().perform();
        if (driver.getTitle().equalsIgnoreCase("More Medicare Resources | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new DiscoverMoreResourcesPage(driver);
		}else{
		
			return null;
			
		}
	}

	
}
