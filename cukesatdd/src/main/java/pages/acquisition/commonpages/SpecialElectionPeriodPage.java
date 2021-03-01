package pages.acquisition.commonpages;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class SpecialElectionPeriodPage extends UhcDriver {
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-1']/div[1]/div/div[2]/fieldset/span[1]/label")
	private WebElement yes;

	@FindBy(xpath = "//*[@id='enrollment-step-1-part-1']/div[1]/div/div[2]/fieldset/span[2]/label")
	private WebElement no;

	@FindBy(xpath = "//*[@id='partSave']")
	private WebElement saveAndContinue;
	
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
	private WebElement checkBoxThree; //checkBoxFour;

	//@FindBy(id="notEligibleforExtrahelplabel")
	@FindBy(xpath = "//*[@id='notEligibleforExtrahelplabel']")
	private WebElement checkBoxFour; //checkBoxFive;

	//@FindBy(id="movingIntoLongTermCarelabel")
	@FindBy(xpath = "//*[@id='movingIntoLongTermCarelabel']")
	private WebElement checkBoxFive; //checkBoxSixA;
	
	//@FindBy(id="movingOutOfLongTermCarelabel")
	@FindBy(xpath = "//*[@id='movingOutOfLongTermCarelabel']")
	private WebElement checkBoxSix; //checkBoxSixB;

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
	@FindBy(xpath = ".//*[@id='sepDate-field-1']")
	private WebElement enterDateTwo;

	//@FindBy(id="sepDate-field-3")
	@FindBy(xpath = ".//*[@id='sepDate-field-3']")
	private WebElement enterDateThree;

	//@FindBy(id="sepDate-field-4")
	@FindBy(xpath = ".//*[@id='sepDate-field-4']")
	private WebElement enterDateFour;

	//@FindBy(id="sepDate-field-5")
	@FindBy(xpath = ".//*[@id='sepDate-field-5']")
	private WebElement enterDateFive;

	//@FindBy(id="se-11-other-9")
	@FindBy(xpath = ".//*[@id='se-11-other-6']")//*[@id='sepDate-field-9']")
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
		validate(checkBoxThree);
		validate(checkBoxFour);
		//validate(checkBoxSixA);
		//validate(checkBoxSixB);
		validate(checkBoxSeven);
		validate(checkBoxEight);
		validate(checkBoxNine);
		validate(enterDateOne);
		validate(enterDateTwo);
		validate(enterDateFive);
		//validate(enterDateSixA);
		//validate(enterDateSixB);
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
		
		for(int i = 0; i<7; i++){
			List<String> l = new ArrayList<String>(SEPAttributesMap.keySet());
			if (SEPAttributesMap.get(l.get(i)).equalsIgnoreCase("yes"))
				selectQuestions(l.get(i),SEPAttributesMap);
		}
		/*if (SEPAttributesMap.get("SEP1").equalsIgnoreCase("yes"))
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
			selectOther(SEPAttributesMap.get("SEPOtherReason"));*/

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
		//checkBoxSixA.click();
		//checkBoxSixB.click();
	

		//enterDateSixA.sendKeys(startDate);
		//enterDateSixB.sendKeys(endDate);
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
	public void clicksOnSaveAndContinue(){
		saveAndContinue.click();
	}
	
	public ESRDPage navigatesToNextStepMAorMAPD() {
		saveAndContinue.click();
		
			return new ESRDPage(driver);
		
	}
	
	public PrescriptionDrugCoveragePage navigatesToNextStepPDP() {
		saveAndContinue.click();
	
			return new PrescriptionDrugCoveragePage(driver);
	}
	@FindBy(xpath = ".//*[@id='enrollment-step-1-part-1']/div[1]/div/div[1]/h2")
	private WebElement sepHeader;
	
	public boolean validateSEPPage(){
		boolean flag = false;
		if(validate(sepHeader)&&validate(yes)&&validate(no)&&validate(saveAndContinue))
			flag = true;
		return flag;
	}
	public void selectQuestions(String s,Map<String, String> SEPAttributesMap){
		WebElement tempElement = null, textBoxElement = null ;
		String text = "";
		if (s .equalsIgnoreCase("SEP1")){
			tempElement = checkBoxOne;
			textBoxElement = enterDateOne;
			text = SEPAttributesMap.get("SEPDate1");
		}else if (s.equalsIgnoreCase("SEP2")){
			tempElement = checkBoxTwo;
			textBoxElement = enterDateTwo;
			text = SEPAttributesMap.get("SEPDate2");
		}else if (s .equalsIgnoreCase("SEP3")){
			tempElement = checkBoxThree;
			selectFourthQuestion();
		}else if (s .equalsIgnoreCase("SEP4")){
			tempElement = checkBoxFour;
			textBoxElement = enterDateThree;
			text = SEPAttributesMap.get("SEPDate4");
		}else if (s .equalsIgnoreCase("SEP5")){
			tempElement = checkBoxFive;
			textBoxElement = enterDateFour;
			text = SEPAttributesMap.get("SEPDate5");
		}else if (s .equalsIgnoreCase("SEP6")){
			tempElement = checkBoxSix;
			textBoxElement = enterDateFive;
			text = SEPAttributesMap.get("SEPDate6");
		}else if (s .equalsIgnoreCase("SEPOther")){
			tempElement = checkBoxOther;
			textBoxElement = enterReason ;
			text = SEPAttributesMap.get("SEPOtherReason");
		}else
			System.out.println("Invalid key entry");
		
		tempElement.click();
		if(textBoxElement!=null){
			textBoxElement.clear();
			textBoxElement.sendKeys(text);
		}
	}
}
