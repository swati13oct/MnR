/**
 * 
 */
package pages.acquisition.agentRecommendationEngine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import atdd.framework.UhcDriver;

public class AREPlanRanking extends UhcDriver {

	public AREPlanRanking(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	ARECommonutility commonUtils = new ARECommonutility(driver);

	@FindBy(css = "div#multiSelect>label")
	private WebElement planRankingTxt;

	@FindBy(css = "div#multiSelect>#plan-ranking")
	private WebElement planRankingDropdown;

	@FindBy(css = "div#multiSelect label[for='as_dental']")
	private WebElement dentalCheckLabel;
	
	@FindBy(css = "div#multiSelect label[for='as_dental']>input")
	private WebElement dentalCheck;
	
	@FindBy(css = "div#multiSelect label[for='as_vision']")
	private WebElement visionCheckLabel;
	
	@FindBy(css = "div#multiSelect label[for='as_vision']>input")
	private WebElement visionCheck;
	
	@FindBy(css = "div#multiSelect label[for='as_hearing']")
	private WebElement hearingCheckLabel;
	
	@FindBy(css = "div#multiSelect label[for='as_hearing']>input")
	private WebElement hearingCheck;
	
	@FindBy(css = "div#multiSelect label[for='as_fitness']")
	private WebElement fitnessCheckLabel;
	
	@FindBy(css = "div#multiSelect label[for='as_fitness']>input")
	private WebElement fitnessCheck;
	
	@FindBy(css = "div#multiSelect label[for='cs_low']")
	private WebElement lowPremiumCheckLabel;
	
	@FindBy(css = "div#multiSelect label[for='cs_low']>input")
	private WebElement lowPremiumCheck;

	@FindBy(css = "div#multiSelect label[for='travel_regular']")
	private WebElement travelCheckLabel;
	
	@FindBy(css = "div#multiSelect label[for='travel_regular']>input")
	private WebElement travelCheck;
	
	@FindBy(css = "div#multiSelect label[for='drug']")
	private WebElement drugCheckLabel;
	
	@FindBy(css = "div#multiSelect label[for='drug']>input")
	private WebElement drugCheck;
	
	@FindBy(css = "div#multiSelect label[for='doctor_lookup']")
	private WebElement doctorCheckLabel;
	
	@FindBy(css = "div#multiSelect label[for='doctor_lookup']>input")
	private WebElement doctorCheck;

	@FindBy(css = "div#multiSelect button[class*='uhc-button']")
	private WebElement applyBtn;

	public void validateUIElements() {
		System.out.println("Validate ARE UI Elements : ");
		String currentPageUrl = driver.getCurrentUrl();
		System.out.println("Current URL : " + currentPageUrl);
		Assert.assertTrue(validate(planRankingTxt),"Ranking text is missing");
		Assert.assertTrue(validate(planRankingDropdown),"Ranking Dropdown is missing");
		planRankingDropdown.click();
		Assert.assertTrue(validate(dentalCheckLabel),"Dental Checkbox is missing");
		Assert.assertTrue(validate(visionCheckLabel),"Vision Checkbox is missing");
		Assert.assertTrue(validate(hearingCheckLabel),"Hearing Checkbox is missing");
		Assert.assertTrue(validate(fitnessCheckLabel),"Fitness Checkbox is missing");
		Assert.assertTrue(validate(lowPremiumCheckLabel),"Low Premium Checkbox is missing");
		Assert.assertTrue(validate(travelCheckLabel),"Travel Checkbox is missing");
		Assert.assertTrue(validate(drugCheckLabel),"Drug Checkbox is missing");
		Assert.assertTrue(validate(doctorCheckLabel),"Doctor Checkbox is missing");
		Assert.assertTrue(validate(applyBtn),"Apply button is missing");
		
		Assert.assertTrue(drugCheck.isSelected(), "Drug is not selected by default");
		Assert.assertTrue(doctorCheck.isSelected(), "Doctor is not selected by default");
		
		//Deselect All
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,travel,drug,doctor", false);
		applyBtn.click();
		threadsleep(3000);
		alertAccept();
		boolean dropClose = validate(applyBtn, 10);
		System.out.println("Drop close : " + dropClose);
		Assert.assertFalse(dropClose);
		
		//Select All
		planRankingDropdown.click();
		validate(applyBtn);
		optionSelection("dental,vision,hearing,fitness,lowpremium,travel,drug,doctor", true);
		applyBtn.click();
		threadsleep(3000);
		alertAccept();
		dropClose = validate(applyBtn, 10);
		System.out.println("Drop close : " + dropClose);
		Assert.assertFalse(dropClose);
	}

	public void alertAccept() {
		driver.switchTo().alert().accept();
		threadsleep(3000);
	}

	public void optionSelection(String option, boolean select) {
		String options[] = option.split(",");
		for (int i = 0; i < options.length; i++) {
			checkUncheck(options[i], select);
			threadsleep(1000);
		}
	}

	public void checkUncheck(String checkOption, boolean select) {
		System.out.println("Selecting Option " + checkOption + " : " + select);
		WebElement elemCheck = null, elemClick = null;
		if (checkOption.equalsIgnoreCase("dental")) {
			elemCheck = dentalCheck;
			elemClick = dentalCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("vision")) {
			elemCheck = visionCheck;
			elemClick = visionCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("hearing")) {
			elemCheck = hearingCheck;
			elemClick = hearingCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("fitness")) {
			elemCheck = fitnessCheck;
			elemClick = fitnessCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("lowpremium")) {
			elemCheck = lowPremiumCheck;
			elemClick = lowPremiumCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("travel")) {
			elemCheck = travelCheck;
			elemClick = travelCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("drug")) {
			elemCheck = drugCheck;
			elemClick = drugCheckLabel;
		}
		if (checkOption.equalsIgnoreCase("doctor")) {
			elemCheck = doctorCheck;
			elemClick = doctorCheckLabel;
		}

		if (select && !elemCheck.isSelected()) {
			elemClick.click();
		}
		if (!select && elemCheck.isSelected()) {
			elemClick.click();
		}

		if (select)
			Assert.assertTrue(elemCheck.isSelected(), "Unable to Select "+elemCheck);
		else
			Assert.assertFalse(elemCheck.isSelected(), "Unable to Deselect "+elemCheck);
	}
	
}