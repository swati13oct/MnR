package pages.acquisition.uhcretiree;

/*@author eb*/

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class EnterDrugPage extends UhcDriver {

	@FindBy(id = "drugNameFilter")
	private WebElement drugInputField;

	@FindBy(xpath="/html/body/div[1]/div/div[1]/div/div[3]/div/div[8]/div/div/div/div[2]/div/div/div")
	public static WebElement findDrugBtn;
	
	@FindBy(name = "drugInitials")
	CharSequence[] drugInitials;
	
	@FindBy(id = "detailsPage")
	private WebElement detailsPage;
	
	private PageData formularyList;
	public JSONObject formularyListJson;
	
	public EnterDrugPage(WebDriver driver, boolean skipClick, String drugName) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.ENTER_DRUG_PAGE_DATA;
		formularyList = CommonUtility.readPageData(fileName,
				CommonConstants.RETIREE_PAGE_OBJECT_DIRECTORY);
		if (skipClick != true){
			openAndValidate();
		} else {
			//If it is already on the drug details page (skipClick == true) then send page a json object that contains "key":"skip"
			validate(drugInputField);
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("DrugName", drugName);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			formularyListJson = jsonObject;
		}
	}


	public EnterDrugPage(WebDriver driver) {
		super(driver);
	}


	@Override
	public void openAndValidate() {
		validate(drugInputField);

		JSONObject jsonObject = new JSONObject();
		for (String key : formularyList.getExpectedData().keySet()) {
			WebElement element = findElement(formularyList.getExpectedData()
					.get(key));
			if (element != null) {
				if(validate(element)){
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		formularyListJson = jsonObject;
	}

	public EnterDrugPage enterDrugName(String drugName) {
		
		driver.findElement(By.id("drugNameFilter")).sendKeys(drugName);
		driver.findElement(By.id("findDrugsButton")).click();
		
		/*Wait for the page to load. For some drugs, it finds it right away and goes directly to the drug details page. 
		* If this happens and the page is already on the Drug Details page, send true*/
		CommonUtility.waitForPageLoad(driver, detailsPage, 5);
		
		boolean skipClick;
		String bodyText = driver.findElement(By.tagName("body")).getText().toUpperCase();
		if (bodyText.contains("DRUG DETAILS")){
			skipClick = true;
		} else {
			skipClick = false;
		}
		String title = getTitle().toLowerCase();
		if (title.contains(
				"search")){
			return new EnterDrugPage(driver, skipClick, drugName);
		}
		return null;

	}


	public SelectDosagePage clickDrugName(String drugName, boolean skipClick) {
		if (skipClick != true){
			driver.findElement(By.className(drugName.toLowerCase())).click();
		}
		return new SelectDosagePage(driver);
	}

}