/**
* 
 */
package pages.acquisition.planRecommendationEngine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.acquisition.planRecommendationEngine.PlanRecommendationEngineStepDefinition;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDoctorsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineDrugsPage;
import pages.mobile.acquisition.planrecommendationengine.DoctorsMobilePage;
import pages.mobile.acquisition.planrecommendationengine.DrugMobilePage;

public class PlanRecommendationEngineEditResponsePage extends UhcDriver {

	public PlanRecommendationEngineEditResponsePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		clickIfElementPresentInTime(driver, AcquisitionHomePage.proactiveChatExitBtn, 30);
		waitTillFrameAvailabeAndSwitch(iframePst, 45);
	}
	
	String flow;
	ArrayList<String> DrugsInPRE;
	ArrayList<String> DrugsInDCE;
	ArrayList<String> DrugsList = new ArrayList<String>();
	ArrayList<String> ModelDrugsList = new ArrayList<String>();
	static ArrayList<String> werallyResults = new ArrayList<String>();
	static ArrayList<String> vppResults = new ArrayList<String>();		
	static ArrayList<String> vppProviderResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults = new ArrayList<String>();
	static ArrayList<String> confirmationResults1 = new ArrayList<String>();
	static ArrayList<String> confirmationProviderResults = new ArrayList<String>();
	public WebElement drugCoveredeVPP;
	PlanRecommendationEngineDrugsPage drug = new PlanRecommendationEngineDrugsPage(driver);

	PlanRecommendationEngineCommonutility desktopCommonUtils = new PlanRecommendationEngineCommonutility(driver);

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst;

	@FindBy(css = "div.progress-bar-info")
	private WebElement progressInfo;
	
	@FindBy(css = "button[class*='button-secondary']")
	private WebElement cancelButton;
	
	@FindBy(css = "button[class*='button-primary']")
	private WebElement saveButton;
	
	@FindBy(css = "#plan-list-1 button#editMyAnswers")
	private WebElement mapdEditResponseButton;

	@FindBy(css = "#plan-list-3 button#editMyAnswers")
	private WebElement pdpEditResponseButton;
	
	@FindBy(css = "#plan-list-4 button#editMyAnswers")
	private WebElement snpEditResponseButton;
	
	// Edit Responses page Elements

	@FindBy(css = "#prefrencesTitle")
	private WebElement editResponseTitle;

	@FindBy(css = "#backToPlanRecommendation")
	private WebElement returnToPlanLink;

	@FindBy(css = "uhc-list-item.list-item")
	private List<WebElement> allQuestionSection;
	
	@FindBy(css = "div.viewUpdateSection:nth-of-type(1)>button")
	private WebElement viewUpdateButton;
		
	@FindBy(css = "div.viewUpdateSection:nth-of-type(1)>button")
	private WebElement viewUpdateButtonBottom;
	
	// Variables
	
	public HashMap<String, String> inputValues;
	
	public HashMap<Integer, String> flowNumValue,mapd,ma,pdp,idk;
	
	public int previousVal = -1;
	
	public void editResponsepage(HashMap<String, String> userInput) {
		System.out.println("Validating Edit Response Page: ");
		inputValues = userInput;
		String currentPageUrl = driver.getCurrentUrl();
		currentPageUrl.contains("/plan-recommendation-engine.html/");
		pageloadcomplete();
		navigateEditResponsePage();
		checkContent("location");
		checkContent("coverage");
		checkContent("special");
		checkContent("travel");
		checkContent("doctor");
		checkContent("drug");
		checkContent("additional");
		checkContent("cost");
		verifyClickEditButton("location",false);
		verifyClickEditButton("coverage",false);
		verifyClickEditButton("special",false);
		verifyClickEditButton("travel",false);
		verifyClickEditButton("doctor",false);
		verifyClickEditButton("drug",false);
		verifyClickEditButton("additional",false);
		verifyClickEditButton("cost",false);
		checkDrugDocInfo("drug",false);
		checkDrugDocInfo("doctor",false);
		editCancel(inputValues.get("Plan Type").toLowerCase());
		System.out.println("******  Edit Response Validation Completed ******");
	}
	
	
	public void navigateEditResponsePage() {
		if(inputValues.get("Plan Type").equalsIgnoreCase("pdp")) {
			pdpEditResponseButton.click();
		}
		else {
			if(validate(mapdEditResponseButton,10))
				mapdEditResponseButton.click();
			else
				snpEditResponseButton.click();
		}
		validate(editResponseTitle);
		validate(returnToPlanLink, 30);
	}
	
	
	public void checkContent(String section) {
		//boolean sectionStaus = false;
		section = section.toLowerCase();
		String formatedUIText =  changetoUIdata(section);
		//System.out.println("Formated UI Text : "+formatedUIText);
		String actualExtractedUIText = getUISectionValue(section);
		//System.out.println("actualExtractedUIText : "+actualExtractedUIText);
			for(String val:formatedUIText.split(",")) {
				Assert.assertTrue(actualExtractedUIText.contains(val), val+" is not available in "+actualExtractedUIText);
			}
		}

	
	public String changetoUIdata(String section) {
		
		//flow = PlanRecommendationEngineStepDefinition.PREflow;
		String UIValue = null;
		
		if(section.equalsIgnoreCase("location")) {
			UIValue = inputValues.get("Zip Code")+","+inputValues.get("CountyDropDown"); 
		}
		else if(section.equalsIgnoreCase("coverage")) {
			UIValue = inputValues.get("Plan Type");
			if(UIValue.equalsIgnoreCase("mapd"))
				UIValue = "Medical and prescription drug".toLowerCase();
			if(UIValue.equalsIgnoreCase("MA"))
				UIValue = "Medical only".toLowerCase();
			if(UIValue.equalsIgnoreCase("pdp"))
				UIValue = "Prescription drug only".toLowerCase();
			if(UIValue.equalsIgnoreCase("none"))
				UIValue = "not sure".toLowerCase();
		}
		else if(section.equalsIgnoreCase("special")) {
			UIValue = inputValues.get("SNP Options");
		}
		else if(section.equalsIgnoreCase("travel")) {
			
			UIValue = inputValues.get("Travel Options");
			UIValue = UIValue.replace("withinUS", "within").replace("OutsideUS", "another part").replace("regular", "routine");
		}
		else if(section.equalsIgnoreCase("doctor")) {
			UIValue = inputValues.get("Doctors");
			UIValue = UIValue.replace("UHGNetwork", "UnitedHealthcare").replace("AcceptsMedicare", "any doctor").replace("Lookup", "Look up");
			
		}
		else if(section.equalsIgnoreCase("drug")) {
			UIValue = inputValues.get("Drug Selection");
		}
		else if(section.equalsIgnoreCase("additional")) {
			UIValue = inputValues.get("Additional Option");
			//Works for all Yes or all No
		}
		else if(section.equalsIgnoreCase("cost")) {
			UIValue = inputValues.get("Preference Option");
		}
		
		return UIValue.toLowerCase();
	}
	
	
	public String getUISectionValue(String section) {
		String actualExtractedUIText = null;
		for(WebElement elm:allQuestionSection) {
			actualExtractedUIText = elm.getText().toLowerCase();
			if(actualExtractedUIText.contains(section)){
				break;
			}
		}
		return actualExtractedUIText;
	}
	

	public void verifyClickEditButton(String section,boolean click) {
		boolean editButton = false;
		for(WebElement elem:allQuestionSection) {
			String tempTxt = elem.findElement(By.cssSelector("button")).getText().toLowerCase();
			System.out.println("tempTxt : "+tempTxt);
			if(tempTxt.contains(section)) {
				editButton = true;
				if(click)// Edit button Click
					elem.findElement(By.cssSelector("button")).click();
				break;
			}
		}
		Assert.assertTrue(editButton,"Edit button is not available for "+section);
	}


	public void returnVPP(String button) {
		if(button.toLowerCase().contains("update"))
			viewUpdateButton.click();
		else
			returnToPlanLink.click();
	}
	
	
	public void checkDrugDocInfo(String section,boolean modifiedValue) {
		String UIInfo = getUISectionValue(section);
		String givenInfo = null;
		if(section.contains("drug")) {
			if(modifiedValue)
				givenInfo = inputValues.get("Drug Details").split(",")[2].toLowerCase();
			else
				givenInfo = inputValues.get("Drug Details").split(",")[2].toLowerCase();
		}
		else {
			if(modifiedValue)
				givenInfo = inputValues.get("Doctors Search Text").toLowerCase();
			else
				givenInfo = inputValues.get("Doctors Search Text").toLowerCase();
		}
		Assert.assertTrue(UIInfo.contains(givenInfo),givenInfo+" is not available in "+UIInfo);
	}


	public void setKeyQuestions() {
		
		mapd = new HashMap<Integer, String>();
		mapd.put(0, "location");
		mapd.put(1, "coverage");
		mapd.put(2, "special");
		mapd.put(3, "travel");
		mapd.put(4, "doctor");
		mapd.put(5, "drug");
		mapd.put(6, "additional");
		mapd.put(7, "cost");
		
		ma = new HashMap<Integer, String>();
		ma.put(0, "location");
		ma.put(1, "coverage");
		ma.put(2, "special");
		ma.put(3, "travel");
		ma.put(4, "doctor");
		ma.put(5, "additional");
		ma.put(6, "cost");
		
		pdp = new HashMap<Integer, String>();
		pdp.put(0, "location");
		pdp.put(1, "coverage");
		pdp.put(2, "drug");
		
		idk = new HashMap<Integer, String>(mapd);
		
	}
	
	
	public Integer chooseRandomQuesNum(String flow) {
		setKeyQuestions();
		Random rand = new Random();
		//System.out.println(ma.size());
		int rval = 1; // Exclude Coverage
		if(flow.equalsIgnoreCase("pdp"))
			rval = rand.nextInt(pdp.size()-1);
		else if (flow.equalsIgnoreCase("ma"))
			rval = rand.nextInt(pdp.size()-1);
		else
			rval = rand.nextInt(mapd.size()-1);
		
		while(rval==previousVal || rval==1)
			chooseRandomQuesNum(flow);
		
		previousVal = rval;
		return rval;
		
	}

	
	public String getSection(String flow,Integer num) {
		String section = null;
		if(flow.equalsIgnoreCase("pdp"))
			section = pdp.get(num);
		else if (flow.equalsIgnoreCase("ma"))
			section = ma.get(num);
		else
			section = mapd.get(num);
		
		return section;
		
	}
	
	public void editCancel(String flow) {
		System.out.println("Flow : "+flow);
		int randomEdit = chooseRandomQuesNum(flow);
		System.out.println("Random Number : "+randomEdit);
		String randomSection = getSection(flow,randomEdit);
		System.out.println("Performing Random Cancel action for : "+randomSection);
		verifyClickEditButton(randomSection,true);
		validate(progressInfo,10);
		String progressText = progressInfo.getText().toLowerCase();
		Assert.assertTrue(progressText.contains(randomSection) && progressText.contains("100%"),"Progres Bar does not have required Info" );
		cancelButton.click();
		Assert.assertTrue(validate(returnToPlanLink,10),"Invalid cancel action");
	}
	
}
