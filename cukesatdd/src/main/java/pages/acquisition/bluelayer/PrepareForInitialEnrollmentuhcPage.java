/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.GlobalWebElements;
import pages.acquisition.ulayer.DiscoverMoreResourcesPage;

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
		if(driver.getTitle().equalsIgnoreCase("Change Medicare Plans | UnitedHealthcare®")){
			return new ExploreChangingPlansuhcPage(driver); 
		}
		return null;
		
		
	}

	public DiscoverMoreResourcesuhcPage discoverMoreResourcesClick() {
		validate(discoverMoreResourcesMedicareEducationLink);
		Actions actions = new Actions(driver);
        actions.moveToElement(navigationSectionMedicareEducationLink);
        actions.moveToElement(discoverMoreResourcesMedicareEducationLink);
        actions.click().build().perform();
        if (driver.getTitle().equalsIgnoreCase("Discover More Medicare Resources & Information | UnitedHealthcare®")) {
			return new DiscoverMoreResourcesuhcPage(driver);
		}else{
		
			return null;
			
		}
	}

}
