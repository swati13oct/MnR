package pages.acquisition.ulayer;


import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;















import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class SpecialElectionPeriodPage extends UhcDriver {
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-1']/div[1]/div/div[2]/fieldset/span[1]/label")
	private WebElement yes;

	@FindBy(xpath = "//*[@id='enrollment-step-1-part-1']/div[1]/div/div[2]/fieldset/span[2]/label")
	private WebElement no;

	@FindBy(xpath = "//*[@id='partSave']")
	private WebElement saveAndContinue;

	@FindBy(id = "esrdinfo")
	private WebElement pageHeadingESRD;
	
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-1']/div[2]/a[2]")
	private WebElement previous;

	//@FindBy(id="losingCoveragelabel")
	@FindBy(xpath = "//*[@id='losingCoveragelabel']")
	private WebElement checkBoxOne;

	//@FindBy(id="changeOFAddresslabel")
	@FindBy(xpath = "//*[@id='changeOFAddresslabel']")
	private WebElement checkBoxTwo;

	//@FindBy(id="extraHelpPayinglabel")
	@FindBy(xpath = "//*[@id='extraHelpPayinglabel']")
	private WebElement checkBoxFour;

	//@FindBy(id="notEligibleforExtrahelplabel")
	@FindBy(xpath = "//*[@id='notEligibleforExtrahelplabel']")
	private WebElement checkBoxFive;

	//@FindBy(id="movingIntoLongTermCarelabel")
	@FindBy(xpath = "//*[@id='movingIntoLongTermCarelabel']")
	private WebElement checkBoxSixA;
	
	//@FindBy(id="movingOutOfLongTermCarelabel")
	@FindBy(xpath = "//*[@id='movingOutOfLongTermCarelabel']")
	private WebElement checkBoxSixB;

	//@FindBy(id="medicareMEdicaidOrStateHelplabel")
	@FindBy(xpath = "//*[@id='medicareMEdicaidOrStateHelplabel']")
	private WebElement checkBoxSeven;

	//@FindBy(id="fiveStarPlanlabel")
	@FindBy(xpath = "//*[@id='fiveStarPlanlabel']")
	private WebElement checkBoxEight;

	//@FindBy(id="turned65Disenrollinglabel")
	@FindBy(xpath = "//*[@id='turned65Disenrollinglabel']")
	private WebElement checkBoxNine;

	//@FindBy(id="otherlabel")
	@FindBy(xpath = "//*[@id='otherlabel']")
	private WebElement checkBoxOther;

	//@FindBy(id="sepDate-field-0")
	@FindBy(xpath = "//*[@id='sepDate-field-0']")
	private WebElement enterDateOne;

	//@FindBy(id="sepDate-field-1")
	@FindBy(xpath = "//*[@id='sepDate-field-1']")
	private WebElement enterDateTwo;

	//@FindBy(id="sepDate-field-3")
	@FindBy(xpath = "//*[@id='sepDate-field-3']")
	private WebElement enterDateFive;

	//@FindBy(id="sepDate-field-4")
	@FindBy(xpath = "//*[@id='sepDate-field-4']")
	private WebElement enterDateSixA;

	//@FindBy(id="sepDate-field-5")
	@FindBy(xpath = "//*[@id='sepDate-field-5']")
	private WebElement enterDateSixB;

	//@FindBy(id="se-11-other-9")
	@FindBy(xpath = "//*[@id='sepDate-field-9']")
	private WebElement enterReason;


	private PageData sepInformation;

	public JSONObject sepInformationJson;

	public SpecialElectionPeriodPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.SEP_INFORMATION_PAGE_DATA;
		sepInformation = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		//PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(yes);
		validate(no);
		validate(saveAndContinue);
		validate(previous);
		validate(checkBoxOne);
		validate(checkBoxTwo);
		validate(checkBoxFour);
		validate(checkBoxFive);
		validate(checkBoxSixA);
		validate(checkBoxSixB);
		validate(checkBoxSeven);
		validate(checkBoxEight);
		validate(checkBoxNine);
		validate(enterDateOne);
		validate(enterDateTwo);
		validate(enterDateFive);
		validate(enterDateSixA);
		validate(enterDateSixB);
		validate(enterReason);	
		
		JSONObject jsonObject = new JSONObject();
		for (String key : sepInformation.getExpectedData().keySet()) {
			WebElement element = findElement(sepInformation.getExpectedData()
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
		sepInformationJson = jsonObject;

		
	}

	

	public void noForSEPQuestion() {
		no.click();		
	}

	public void yesForSEPQuestion(Map<String, String> SEPAttributesMap) {
		yes.click();
		String a = SEPAttributesMap.get("SEP1");
		if (SEPAttributesMap.get("SEP1").equalsIgnoreCase("yes"))
			selectFirstQuestion(SEPAttributesMap.get("SEPDate1"));
		else if (SEPAttributesMap.get("SEP2").equalsIgnoreCase("yes"))
			selectSecondQuestion(SEPAttributesMap.get("SEPDate2"));
		else if (SEPAttributesMap.get("SEP4").equalsIgnoreCase("yes"))
			selectFourthQuestion();
		else if (SEPAttributesMap.get("SEP5").equalsIgnoreCase("yes"))
			selectFifthQuestion(SEPAttributesMap.get("SEPDate5"));
		else if (SEPAttributesMap.get("SEP6").equalsIgnoreCase("yes"))
			selectSixthQuestion(SEPAttributesMap.get("SEPDate6"));
		else if (SEPAttributesMap.get("SEP7").equalsIgnoreCase("yes"))
			selectSeventhQuestion();
		else if (SEPAttributesMap.get("SEP8").equalsIgnoreCase("yes"))
			selectEighthQuestion();
		else if (SEPAttributesMap.get("SEP9").equalsIgnoreCase("yes"))
			selectNinthQuestion();
		else if (SEPAttributesMap.get("SEPOther").equalsIgnoreCase("yes"))
			selectOther(SEPAttributesMap.get("SEPOtherReason"));

		//clickOnSaveAndContinue();
	}

	/*public void sep1(){

	}
*/
	public void selectFirstQuestion(String date) {
		checkBoxOne.click();
		enterDateOne.clear();
		enterDateOne.sendKeys(date);
	}

	public void selectSecondQuestion(String date) {
		checkBoxTwo.click();
		enterDateTwo.clear();
		enterDateTwo.sendKeys(date);

	}

	public void selectFourthQuestion() {
		checkBoxFour.click();

	}

	public void selectFifthQuestion(String date) {
		checkBoxFive.click();
		enterDateFive.clear();
		enterDateFive.sendKeys(date);
	}

	public void selectSixthQuestion(String date) {
		checkBoxSixA.click();
		checkBoxSixB.click();
		String[] Date = date.split(",");
		String startDate = Date[0];
		String endDate = Date[1];
		enterDateSixA.sendKeys(startDate);
		enterDateSixB.sendKeys(endDate);
	}

	public void selectSeventhQuestion() {
		checkBoxSeven.click();

	}

	public void selectEighthQuestion() {
		checkBoxEight.click();

	}

	public void selectNinthQuestion() {
		checkBoxNine.click();

	}

	public void selectOther(String reason) {
		checkBoxOther.click();
		enterReason.clear();
		enterReason.sendKeys(reason);
	}

	
	

	public void clickOnPrevious() {
		previous.click();
	}
	public ESRDPage navigatesToNextStep() {
		saveAndContinue.click();
		if (pageHeadingESRD.getText().equalsIgnoreCase("End Stage Renal Disease")) {
		return new ESRDPage(driver);
		}
		return null;
		}

}
