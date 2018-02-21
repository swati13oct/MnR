package pages.member.ulayer;

/**
 * @author pagarwa5
 *
 */

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class DrugDosagePage extends UhcDriver {

	@FindBys(value = { @FindBy(xpath = "//div[@id='dce.member']/div/div[3]/div/div/div/div[5]/div") })
	private List<WebElement> drugDosages;

	@FindBys(value = { @FindBy(xpath = "//div[@id='dce.member']/div/div[3]/div/div/div/div[5]/div[4]/div") })
	private List<WebElement> packagesList;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[3]/div/div/div/div[5]/div")
	WebElement DosagesBox;

	@FindBy(id = "dce.member")
	WebElement genericPageText;

	@FindBy(className = "qtyBox")
	WebElement quantityField;

	@FindBy(xpath = "//div[@id='dce.member']/div/div[3]/div/div/div/div[5]")
	WebElement frequencyField;

	@FindBy(linkText = "continue")
	WebElement continueButton;
	
	@FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[1]/h3[1]")
    private WebElement manageDrugTab;
    
    @FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[1]/h3[2]")
    private WebElement selectPharmacyTab;
    
    @FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[1]/h3[3]")
    private WebElement viewDrugCostsTab;
    
    @FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/span[1]/a")
    private WebElement addADiffDrugLink;
    
    @FindBy(xpath = ".//*[@id='dceMemberUlayer']/div/div[1]/div[5]/p")
    private WebElement selectDosage; 
    
    @FindBy(xpath = ".//*[@id='dce.member']/div/div[3]/div/div/div[1]/div[9]/div/a")
    private WebElement cancelAndGoBackLink;
    
    @FindBy(xpath = ".//*[@id='dce.member']/div/div[4]/div/div/div[1]/p[1]/span/a")
    private WebElement lowCostEditBtn;

	private PageData drugDosage;

	public JSONObject drugDosageJson;

	public DrugDosagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.DRUG_DOSAGE_PAGE_DATA;
		drugDosage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public Object selectDosage(Map<String, String> dosageAttributesMap) {
		String drugDosage = dosageAttributesMap.get("Drug Dosage");
		String drugQuantity = dosageAttributesMap.get("Drug Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		String packageName = dosageAttributesMap.get("Packages");
		//*
		for (WebElement dosage : drugDosages) {
			if (dosage.getText().equalsIgnoreCase(drugDosage)) {
				dosage.findElement(By.name("drug")).click();
			}
		}

		if((packageName !=null) && (!(packageName.equalsIgnoreCase("null")))){
			for (WebElement packageElement : packagesList) {
				if (packageElement.getText().equalsIgnoreCase(packageName)) {
					packageElement.findElement(By.tagName("input")).click();
				}
			}
		}
		sendkeys(quantityField, drugQuantity);
		select(frequencyField, drugFrequency);

		continueButton.click();
		CommonUtility.waitForPageLoad(driver, lowCostEditBtn,CommonConstants.TIMEOUT_30);
		if (genericPageText.getText().contains("switching to a generic drug")) {
			return new LowCostOptPage(driver);
		} else {
			return new ManageDrugPage(driver);
		}
	}

	@Override
	public void openAndValidate() {

		validate(continueButton);
		validate(quantityField);
		validate(frequencyField);

		JSONObject jsonObject = new JSONObject();
		for (String key : drugDosage.getExpectedData().keySet()) {
			WebElement element = findElement(drugDosage.getExpectedData().get(
					key));
			if (element != null) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		drugDosageJson = jsonObject;
		
		System.out.println("drugDosageJson----->"+drugDosageJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String drugName) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject drugDosageExpectedJson = null;
		try {
			drugDosageExpectedJson = (JSONObject) expectedDataMap.get(
					CommonConstants.DRUG_DOSAGE).get(drugName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drugDosageExpectedJson = CommonUtility.mergeJson(
				drugDosageExpectedJson, globalExpectedJson);
		return drugDosageExpectedJson;

	}
    
    public boolean validateDrugDosagePage(){
    	if(selectDosage.getText().contains("Select dosage")&&validate(continueButton)&&validate(addADiffDrugLink))
    		return true;
    	else
    		return false;
    }
}
