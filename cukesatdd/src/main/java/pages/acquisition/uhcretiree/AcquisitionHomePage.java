package pages.acquisition.uhcretiree;



import org.openqa.selenium.By;

import java.util.ArrayList;



import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;


/**
 * @author eb
 *
 */

public class AcquisitionHomePage extends UhcDriver { 

	@Override
	public void openAndValidate() {

		start(UHCRETIREE_ACQISITION_PAGE_URL);
		
		

		validate(prescriptionsLink);
	}

	@FindBy(linkText = "Look up prescription drugs")

	private WebElement prescriptionsLink;
	
	@FindBy(id = "new_form_GroupSelector")
	private WebElement dropDownMenu;

	private WebElement prescriptionsLink;	
	


	@FindBy(xpath= ".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[2]/div/div/div/p[2]/a")
	private WebElement lookupproviderLink;


	public JSONObject browserCheckJson;
	private PageData browserCheckData;


	private static String UHCRETIREE_ACQISITION_PAGE_URL = MRConstants.UHCRETIREE_URL;
	
	private static String UHCRETIREE_SITE_MAP_URL =  MRConstants.UHCRETIREE_SITE_MAP_URL;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public SelectFormularyPage prescriptionsDrugLink() {
		validate(prescriptionsLink);
		prescriptionsLink.click();
		if (getTitle().equalsIgnoreCase(
						"UnitedHealthcare Group Retiree – Search for a Drug")) {
			return new SelectFormularyPage(driver);
		}
		return null;
	}


	public RetireesOfSelectedPlans openDropDown(String groupName) {
		 validate(dropDownMenu);
		 Select dropdown = new Select(driver.findElement(By.id("new_form_GroupSelector")));
		 dropdown.selectByVisibleText(groupName);
		 System.out.println(getTitle());
		 return new RetireesOfSelectedPlans(driver);
//		return null;

	public Rallytool_Page lookupproviderclick() {
		validate(lookupproviderLink);
		lookupproviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase(
						"Find Care")) {
			return new Rallytool_Page(driver);
		}
		
		// TODO Auto-generated method stub
		return null;

	} 
	
	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.GR_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.RETIREE_PAGE_OBJECT_DIRECTORY);
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

	public GroupHomePage selectGroupFromList(String groupName) {
	
		ElementData groupTypeElement = new ElementData("select:className",
				"form_field");
		List<WebElement> pharmacyTypeOptions = findElements(groupTypeElement);
	
		for (WebElement pharmacyTypeOption : pharmacyTypeOptions) {
			if (pharmacyTypeOption.getText().equalsIgnoreCase(groupName)) {
				pharmacyTypeOption.click();
				break;
			}
		}
		
		String url = groupName.toLowerCase()+"/home.html";
		if (currentUrl().contains(url)) {
			return new GroupHomePage(driver);
		} else {
			return null;
		}
	}
}