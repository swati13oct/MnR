/**
 * 
 */
package pages.regression.IDCardPage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;

/**
 * @author bnaveen4
 *
 */
public class IDCardPage extends UhcDriver{

	@FindBy(id="modal-header")
	private WebElement heading;

	@FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
    private WebElement iPerceptionPopUp;
	
	//@FindBy(css="ul.coverage-details li:first-child dl>dd") // this is the locator for id
	@FindBy(css=".long-plan-name .ng-binding")  
	private WebElement planName_grp;
	
	//@FindBy(xpath="//*[@id='details-00_950035171695_2018-12-31']/li[1]/dl/dd") 
	@FindBy(css=".ng-scope > dl > .ng-binding")
	private WebElement planName_Ind;
	
	@FindBy(xpath="(//dd[contains(@class,'ng-binding')])[1]") //--- this is for PDP
	private WebElement planName_PDP;
	
	@FindBy(css="ul.coverage-details li:first-child dl>dd")
	private WebElement id;
	
	//@FindBy(xpath="//*[@id='details-00_950035171695_2018-12-31']/li[2]/dl/dd")
	@FindBy(css="li:nth-child(2) > dl > dd")
	private WebElement id_ind;
	
	@FindBy(xpath="(//dd[contains(@class,'ng-binding')])[2]") //--- this is for PDP
	private WebElement id_PDP;
	
	@FindBy(css="li:nth-child(1) > dl > .ng-binding")
	private WebElement id_grp;
	
	@FindBy(css=".member-name.ng-binding")
	private WebElement name;
	
	@FindBy(css=".member-type-dob.ng-binding")
	private WebElement dateOfBirth;
	
	@FindBy(css=".coverage-value.ng-binding")
	private WebElement start;
	
	@FindBy(xpath="//div[@translate='COVERAGE_STATUS_ACTIVE']")
	private WebElement status;
	
	@FindBy(css="button.modal-close-btn")
	private WebElement closeIDcard;
	
	@FindBy(css=".card-actions>button")
	private WebElement printIDCard;
	
	@FindBy(css=".inline-buttons>button")
	private WebElement btnViewBack;
	
	@FindBy(css=".inline-buttons>a")
	private WebElement mailIDCard;
	
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	
	public IDCardPage(WebDriver driver) {
		super(driver);
		try {
			Thread.sleep(8000);
			if (validate(iPerceptionPopUp)) {
	            iPerceptionPopUp.click();
	            System.out.println("iPerception Pop Up displayed");
			}
			PageFactory.initElements(driver, this);
			CommonUtility.waitForPageLoad(driver, heading, CommonConstants.TIMEOUT_30);
			openAndValidate();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void openAndValidate() {
		validate(heading);
	}

	/**
	 * This method is used to validate the all the fields on ID card page
	 * @param givenAttributes
	 */
	
	@FindBy(xpath="//span[@class='hide-mobile ng-scope']")
	private WebElement viewRecomend;
	
	public void validateIDCardPage_Ind(DataTable givenAttributes){
		
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String medicalPlan = memberAttributesMap.get("Medical Plan");
		String memberId = memberAttributesMap.get("Member Id");
		String memberName = memberAttributesMap.get("Member Name");
		String dob = memberAttributesMap.get("Subscriber DOB");
		String covergaeStart = memberAttributesMap.get("Coverage Start");
		String coverageStatus = memberAttributesMap.get("Coverage Status");
		
		/**
		 * Validates the details of the member
		 */
		
			try{
			if(driver.findElement(By.xpath("(//*[contains(@class,'ng-scope ng-binding')])[1]")).getText().contains("PRESCRIPTION")){
				System.out.println("the Plan Name is: " + planName_PDP.getText());
				System.out.println("the ID is: " + id_PDP.getText());

			}
		} catch (Exception e){
			System.out.println("the Plan Name is: " + planName_Ind.getText());
			System.out.println("the ID is: " + id_ind.getText());
		}
		System.out.println("the name is: " + name.getText());
		System.out.println("the DOB is: " + dateOfBirth.getText());
		System.out.println("the start date is: " + start.getText());
		System.out.println("the covrg status is: " + status.getText());
		try{
			if(driver.findElement(By.xpath("(//*[contains(@class,'ng-scope ng-binding')])[1]")).getText().contains("PRESCRIPTION")){
				Assert.assertEquals(medicalPlan, planName_PDP.getText().trim());
				Assert.assertEquals(memberId, id_PDP.getText().trim());
			}
		} catch(Exception e){
			Assert.assertEquals(medicalPlan, planName_Ind.getText().trim());
			Assert.assertEquals(memberId, id_ind.getText().trim());
		}
		Assert.assertEquals(memberName, name.getText().trim());
		Assert.assertEquals(dob, dateOfBirth.getText().trim());
		Assert.assertEquals(covergaeStart, start.getText().trim());
		Assert.assertEquals(coverageStatus, status.getText().trim());
		
		/**
		 * Validate the links below the ID card. View back and Print options are not working in Stage but working in Prod
		 */
		Assert.assertEquals("MAIL ID CARD", mailIDCard.getText().trim());
		//Assert.assertEquals("VIEW BACK", btnViewBack.getText().trim());
		//Assert.assertEquals("PRINT ID CARD", printIDCard.getText().trim());
		
		closeIDcard.click();
	}
	



public void validateIDCardPage_grp(DataTable givenAttributes){
	
	/* Reading the given attribute from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	String medicalPlan = memberAttributesMap.get("Medical Plan");
	String memberId = memberAttributesMap.get("Member Id");
	String memberName = memberAttributesMap.get("Member Name");
	String dob = memberAttributesMap.get("Subscriber DOB");
	String covergaeStart = memberAttributesMap.get("Coverage Start");
	String coverageStatus = memberAttributesMap.get("Coverage Status");
	
	/**
	 * Validates the details of the member
	 */
	//System.out.println("the Plan Name is: " + planName_grp.getText());
	System.out.println("the ID is: " + id_grp.getText());
	System.out.println("the name is: " + name.getText());
	System.out.println("the DOB is: " + dateOfBirth.getText());
	System.out.println("the start date is: " + start.getText());
	System.out.println("the covrg status is: " + status.getText());
	//Assert.assertEquals(medicalPlan, planName_grp.getText().trim()); 
	Assert.assertEquals(memberId, id_grp.getText().trim());
	Assert.assertEquals(memberName, name.getText().trim());
	Assert.assertEquals(dob, dateOfBirth.getText().trim());
	Assert.assertEquals(covergaeStart, start.getText().trim());
	Assert.assertEquals(coverageStatus, status.getText().trim());
	
	/**
	 * Validate the links below the ID card
	 */
	//Assert.assertEquals("MAIL ID CARD", mailIDCard.getText().trim());
	//Assert.assertEquals("VIEW BACK", btnViewBack.getText().trim());
	//Assert.assertEquals("PRINT ID CARD", printIDCard.getText().trim());
	
	closeIDcard.click();
}
public void validateCoverageStatus(String coverageStatus){
	
	viewRecomend.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Assert.assertEquals(coverageStatus, status.getText().trim());
}


}
