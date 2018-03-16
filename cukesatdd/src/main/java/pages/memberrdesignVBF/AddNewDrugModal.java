package pages.memberrdesignVBF;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
public class AddNewDrugModal extends UhcDriver {

	private PageData addnewdrug;

	public JSONObject addnewdrugJson;

	@FindBy(id = "drug-search-button")
	public WebElement searchButton;


	@FindBy(xpath = "//header[@class='add-drug-slide-header']/span[contains(text(),'Add') and contains(text(),'Drug')]")
	public WebElement addNewDrugHeading;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	public WebElement cancelButton;
	
	@FindBy(id = "drug-search-input")
	public WebElement drugsearchinput;
	
	@FindBy(id="radio-0")
	public WebElement firstdrug; //its liptor
	
	@FindBy(xpath = "//span[contains(text(),'Please enter at least 4 characters to continue search')]")
	public WebElement errorMessage;

	@FindBy(id = "drug-alt-search-button")
	public WebElement continueButton;
	
	@FindBy(xpath = "//span[contains(text(),'Your Drug List can contain a maximum of 25 drugs.')]")
	public WebElement exceededError;

	@FindBy(xpath = "//span[@class='color-red']")
	public WebElement atleast_4_mesg;
	
	
	public AddNewDrugModal(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoadNew(driver, addNewDrugHeading, 10);
	}
	@Override
	public void openAndValidate() {

		
		JSONObject jsonObject = new JSONObject();
		for (String key : addnewdrug.getExpectedData().keySet()) {
			WebElement element = findElement(addnewdrug.getExpectedData()
					.get(key));
			if (null != element) {
				validateNew(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		addnewdrugJson = jsonObject;
		System.out.println("addDrugJson----->"+addnewdrugJson);
	
		
	}

	/***
	 * 
	 * @param DrugName
	 */
	public void typeDrugName(String DrugName) {
		validateNew(drugsearchinput);
		System.out.println("Drug to enter:"+DrugName);
		drugsearchinput.sendKeys(DrugName);
	}

	/***
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public AddDrugDetails submit() throws InterruptedException{
		searchButton.click();
		validateNew(continueButton);
		continueButton.click();
		return new AddDrugDetails(driver);
	}
	
}

