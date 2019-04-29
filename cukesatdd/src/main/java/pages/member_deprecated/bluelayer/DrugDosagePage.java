package pages.member_deprecated.bluelayer;

/*@author pperugu*/

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
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

	@FindBys(value = { @FindBy(xpath = "//div[@id='dce.member']/div/div[2]/div/div/div/div[5]/div") })
	private List<WebElement> drugDosages;

	@FindBys(value = { @FindBy(xpath = "//div[@id='dce.member']/div/div[2]/div/div/div/div[5]/div[4]/div") })
	private List<WebElement> packagesList;
	
	@FindBy(xpath = ".//*[@id='dce.member']/div/div[2]/div/div/div[1]/div[8]/p/select")
	WebElement frequencyBox;

	@FindBy(id = "dce.member")
	WebElement genericPageText;

	@FindBy(xpath = ".//*[@id='dce.member']/div/div[2]/div/div/div[1]/div[7]/input")
	WebElement quantityField;

	@FindBy(className = "freqBox")
	WebElement frequencyField;

	@FindBy(linkText = "continue")
	WebElement continueButton;
		
	@FindBy(linkText="select pharmacy")
	WebElement selectPharmacy;
		 	 	
	@FindBy(xpath="//div[2]/div[5]/div/input")
	WebElement preferredMailServiceRadioButton;
	
	@FindBy(xpath="//div[2]/div[5]/div/p[contains(text(),'Preferred Mail Service Pharmacy')]")
	WebElement preferredMailServiceText;
	
	@FindBy(xpath="//div[3]/div/div/div/div[3]/div/div/div[1]/div[2]/a/span")
	WebElement clickContinue;
	
	@FindBy(xpath=("//div/div/div[1]/div[2]/div[2]/div[4]/input"))
	WebElement standardRatioButton;
	private PageData drugDosage;

	public JSONObject drugDosageJson;

	public DrugDosagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.DRUG_DOSAGE_INDIVIDUAL_BLUE_LAYER_PAGE_DATA;
		drugDosage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);

		openAndValidate();
	}

	public DrugDosagePage(WebDriver driver, String category) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.DRUG_DOSAGE_BLUE_LAYER_PAGE_DATA;
		drugDosage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);

		openAndValidate();
	}

	public Object selectDosage(Map<String, String> dosageAttributesMap, String category) {
		
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
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (category.equalsIgnoreCase(CommonConstants.GROUP)) {
			if (genericPageText.getText().contains(
					"switching to a generic drug")) {
				return new LowCostOptPage(driver,category);
			} else {
				return new ManageDrugPage(driver,category);
			}
		} else {
			if (genericPageText.getText().contains(
					"switching to a generic drug")) {
				return new LowCostOptPage(driver);
			} else {
				return new ManageDrugPage(driver);
			}
		}
	}
	public void selectDrugAndValidate(){
		waitforElement(clickContinue);
		clickContinue.click();
	}
	public void navigateAndValidate(){
		selectPharmacy.click();
		System.out.println("select pharmay clicked");
		if(preferredMailServiceRadioButton.isDisplayed()){
			System.out.println("================Failed due to presence of preferred mail service radio button======================");
			Assert.fail();
		}
		System.out.println("Radio button passed");
		if(preferredMailServiceText.isDisplayed()){
			System.out.println("================Failed due to presence of preferred mail service radio text======================");
			Assert.fail();
		}		
}

	public SelectPharmacyPage navigateToWaysToSave(){
		waitforElement(selectPharmacy);
		selectPharmacy.click();
		standardRatioButton.click();
		if (standardRatioButton.isDisplayed()) {
			return new SelectPharmacyPage(driver);
		} 
			return null;			
	}
	@Override
	public void openAndValidate() {
		
		validate(continueButton);
		validate(quantityField);
		validate(frequencyField);

		JSONObject jsonObject = new JSONObject();
		for (String key : drugDosage.getExpectedData().keySet()) {
			WebElement element = findElement(drugDosage.getExpectedData()
					.get(key));
			if (null != element) {
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
		drugDosageExpectedJson = CommonUtility.mergeJson(drugDosageExpectedJson,
				globalExpectedJson);
		return drugDosageExpectedJson;
	}
	@FindBy(xpath = ".//*[@id='dce.member']/div/div[2]/div/div/div[1]/span[1]/a")
	private WebElement addADrugLink;
	
	@FindBy(xpath = ".//*[@id='dce.member']/div/div[2]/div/div/div[1]/div[9]/div/a")
	private WebElement cancelAndGoBackLink;
	
	public boolean validateDrugDosageSection(){
		boolean flag = false;
		if(validate(addADrugLink)&&validate(cancelAndGoBackLink)&&validate(quantityField)&&validate(frequencyBox)&&validate(continueButton))
			flag = true;
		return flag;
	}
}