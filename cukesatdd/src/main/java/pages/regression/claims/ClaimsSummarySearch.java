package pages.regression.claims;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import acceptancetests.util.CommonUtility;

/**
 * Functionality : methods for Claims Summary search
 */
public class ClaimsSummarySearch extends ClaimsSummaryBase {


	public ClaimsSummarySearch(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}
	
	/**
	 * this method validates Claims by time period 
	 * @throws InterruptedException 
	 */
	public void searchClaimsbyCustomDate(String planType,String claimPeriod) throws InterruptedException {
		Assert.assertTrue("PROBLEM - unable to locate 'Custom search' option from dropdown",claimsValidate(custSrch));
		System.out.println("!!! Custom search is seen in the view Claims From drop down ===>"+(custSrch.getText()));
		custSrch.click();
		System.out.println("!!! Validating the drop down to select the claims !!!");
	}

	/**
	 * this method validates Claims by time period 'Last 24 months' 
	 * @throws InterruptedException 
	 */
	public void searchClaimsByTimePeriod(String planType,String claimPeriod,String claimSystem) 
			throws InterruptedException {
		if(planType.contains("SHIP")){
			System.out.println("For ship case, locate the drop down box and select 24 months option");
			Select dropdown=new Select (ship_claimsDropdown);	
			dropdown.selectByVisibleText("Last 24 months");
			System.out.println("Clicked 24 months option");
		} else if (planType.contains("PDP")) {
			System.out.println("!!!Claim type PDP is validated !!!");
			Select dropdown=new Select (fed_claimsDropdown);	
			dropdown.selectByVisibleText("Last 24 months");
			System.out.println("Clicked 24 months option");
			Assert.assertTrue("PROBLEM - unable to locate 'Prescription Drug' for claims type for '"+planType+"' user",
					claimsValidate(pdp_drug));
		} else if (planType.contains("MAPD") || planType.contains("MA")
				||planType.contains("PCP") || planType.contains("MEDICA") || planType.contains("SSUP")){
			System.out.println("!!! Validating the drop down to select the claims from last 24 months  !!!");
			last24months = driver.findElement(By.id("date24MAtdd"));
			last24months.click();
			System.out.println("!!! Month Selected from the view claims from drop down is ====>"
			+(last24months.getText()));
			if (!planType.contains("MA") && !planType.contains("SSUP")) { //note: MA doesn't have selection
				Assert.assertTrue("PROBLEM - unable to locate 'Medical' for claims type for '"+planType+"' user",
						claimsValidate(medical));
			}
			System.out.println("!!! Claim type Medical is validated!!! ");
			if (planType.contains("MAPD") || planType.contains("PCP")) {
				Assert.assertTrue("PROBLEM - unable to locate 'Prescription Drug' for claims type for '"+planType+"' user",
						claimsValidate(PrescriptionDrug));
				System.out.println("!!!Claim type PrescriptionDrug option is validated !!!");
				PrescriptionDrug.click();
				waitForClaimPageToLoad();
				System.out.println("!!! Validated PrescripitonDrug option can be selected !!!");
				//note: this validation will only work if user also has drug claims, 
				//note: comment out for now b/c hard to find a user with both type of claims
				//Assert.assertTrue("PROBLEM - unable to locate Prescription Drug claims table for claims type for '"+planType+"' user",
				//	claimsValidate(claimsTablePrescriptionDrug));
				//System.out.println("!!! Claims Table PDP is seen on the Claims Summary page!!!");
				//Assert.assertTrue("PROBLEM - unable to locate Rx Number in claims table for claims type for '"+planType+"' user",
				//	claimsValidate(RxNumberinthecalimstable));
				//System.out.println("Element on the Rx table is ===>"+ RxNumberinthecalimstable.getText());
				sleepBySec(5); //note: force it to slow down to avoid race condition
				medical.click();
				waitForClaimPageToLoad();
				System.out.println("!!! Validated Medical option can be selected !!!");
			}
			//note: by default if not specified, medical claims will be validated
			if (claimSystem.toUpperCase().contains("D_") || claimSystem.toUpperCase().contains("RX_")) {
				System.out.println("This test is specific for validating drug claims, select Prescription Drug option instead");
				PrescriptionDrug.click();
				waitForClaimPageToLoad();
			}
		} else {
			Assert.assertTrue("PROBLEM - unable to locate Custom Search option for '"+planType+"' user",
					claimsValidate(custSrch));
			System.out.println("!!! Custom search is seen in the view Claims From drop down ===>"
					+(custSrch.getText()));
			System.out.println("!!! Validating the drop down to select the claims !!!");
		}
	}
	
	/**
	 * Perform claims search on claims summary page based on input arguments
	 * @param planType
	 * @param claimPeriod
	 * @param claimType
	 * @throws InterruptedException
	 */
	public void searchClaimsByTimePeriodClaimType(String planType,String claimPeriod, String claimType) 
			throws InterruptedException {
		CommonUtility.waitForPageLoad(driver, pgHeader, 5);
		//note: MA - Medical; MAPID | PCP - Medical & Prescription drug 
		//note: PDP - Prescription drug; SHIP - no Medical or Prescription drug
		//keep checkModelPopup(driver,1);  //note: enable it if have problem with iPerception popup
		if(planType.equals("SHIP")){
			System.out.println("For ship case, locate the drop down box and select '"+claimPeriod+"' option");
			moveMouseToElement(ship_reviewClaimsTxt);
			Select dropdown=new Select (ship_claimsDropdown);	
			dropdown.selectByVisibleText(claimPeriod);
			System.out.println("Clicked '"+claimPeriod+"' option");
		} else if (planType.contains("PDP")) {
			System.out.println("!!!Claim type PDP is validated !!!");
			Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the prescription drug option",
					claimsValidate(pdp_drugClaimsTypTxt));
			Select dropdown=new Select (fed_claimsDropdown);	
			dropdown.selectByVisibleText(claimPeriod);
			System.out.println("Clicked '"+claimPeriod+"' option");
		} else if (planType.equals("MAPD") || planType.equals("MA") || planType.equals("SSUP") 
				|| planType.equals("PCP") || planType.equals("MEDICA")){
			WebElement option=null;
			if (claimPeriod.equals("Last 30 days")) {
				option = driver.findElement(By.id("date30Atdd"));
			} else if (claimPeriod.equals("Last 90 days")) {
				option = driver.findElement(By.id("date90Atdd"));
			} else if (claimPeriod.equals("Last 6 months")) {
				option = driver.findElement(By.id("date6MAtdd"));
			} else if (claimPeriod.equals("Last 12 months")) {
				option = driver.findElement(By.id("date12MAtdd"));
			} else if (claimPeriod.equals("Last 24 months")) {
				option = driver.findElement(By.id("date24MAtdd"));
			} else if (claimPeriod.equals("Custom search")) {
				option = driver.findElement(By.id("dateCustomSearchAtdd"));
			}
			System.out.println("!!! Validating the drop down to select the claims from '"+claimPeriod+"'!!!");
			option.click();
			CommonUtility.checkPageIsReady(driver);
			System.out.println("!!! Option selected from the view claims from drop down is ====>"+(option.getText()));

			if (planType.equals("MA") || planType.equals("SSUP")) {
				Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the medical option",
						claimsValidate(ma_medicalClaimsTypTxt));
			}
			System.out.println("!! Claim type Medical is validated!!! ");
			if ((planType.equals("MAPD") || planType.equals("PCP") || planType.equals("MEDICA")) 
					&& claimType.equalsIgnoreCase("prescription drug")) {
				Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the prescription drug option",
						claimsValidate(PrescriptionDrug));
				System.out.println("!!!Claim type PrescriptionDrug is validated !!!");
				PrescriptionDrug.click();
				CommonUtility.checkPageIsReady(driver);
				System.out.println("!!! Claim Type PrescriptionDrug is clicked !!!");
			} else if ((planType.equals("MAPD") || planType.equals("PCP") || planType.equals("MEDICA")) 
					&& claimType.equalsIgnoreCase("medical")) {
				Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the medical option",
						claimsValidate(medical));
				// note: MAPD has both medical and prescription drug options
				// for MA case there will be just medical so there won't be a need for click
				medical.click();
				CommonUtility.checkPageIsReady(driver);
			}
		} else{
			Assert.assertTrue("PROBLEM: Unable to locate customSearch element",claimsValidate(custSrch));
			System.out.println("!!! Custom search is seen in the view Claims From drop down ===>"
			+(custSrch.getText()));
			System.out.println("!!! Validating the drop down to select the claims !!!");
		}
		System.out.println("Check to make sure the claimloadingimage disappeared");
		int sec=waitForClaimPageToLoad();
		Assert.assertTrue("PROBLEM - waited total of '"+sec+"' seconds and still seeing claimloadingimage at this point, something maybe wrong...", !claimsValidate(claimloadingimage));
	}

	/**
	 * Perform custom search with given input 'from' and 'to' date
	 * @param planType
	 * @param fromDate
	 * @param toDate
	 */
	public void customSearchClaimsByTimeInterval(String planType, String fromDate, String toDate) {
		System.out.println("Perform custom search with 'From' date='"+fromDate+"' and 'To' date='"+toDate+"' for planType="+planType);
		if(driver.getTitle().contains("Claims Summary")){
			if (planType.equalsIgnoreCase("SHIP")) {
				sendkeys(shipFrom,fromDate);//note: don't know why but need to do it twice for the value to get in, manually works fine
				sendkeys(shipFrom,fromDate);
				sendkeys(shipTo,toDate);
				sendkeys(shipTo,toDate);
				CommonUtility.waitForPageLoad(driver, ship_custSrchBtn,60);
				ship_custSrchBtn.click();
			} else {
				sendkeys(fedFrom,fromDate);
				sendkeys(fedTo,toDate);
				CommonUtility.waitForPageLoad(driver, srchBtn,60);
				handleHowIsYourVisit();
				srchBtn.click();
			}
			System.out.println("Clicked search button");
		}
	}
	
	public void customSearchCalendar(String planType, String fromDate, String toDate) {
		System.out.println("Perform custom search with 'From' date='"+fromDate+"' and 'To' date='"+toDate+"' for planType="+planType);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todayDate=dateFormat.format(date); 
		
		if(driver.getTitle().contains("Claims Summary")){
			WebElement fromCalendarIconBtn=fromCalendarIconBtn_fed;
			WebElement fromCalendarDatePicker_today=fromCalendarDatePicker_today_fed;
			WebElement toCalendarIconBtn=toCalendarIconBtn_fed;
			WebElement toCalendarDatePicker_today=toCalendarDatePicker_today_fed;
			WebElement fromTxtField=fedFrom;
			WebElement toTxtField=fedTo;
			if (planType.equalsIgnoreCase("SHIP")) {
				//note: ship has different xpath
				fromCalendarIconBtn=fromCalendarIconBtn_ship;
				fromCalendarDatePicker_today=fromCalendarDatePicker_today_ship;
				toCalendarIconBtn=toCalendarIconBtn_ship;
				toCalendarDatePicker_today=toCalendarDatePicker_today_ship;
				fromTxtField=shipFrom;
				toTxtField=shipTo;
			}

			Assert.assertTrue("PROBLEM - unable to locate calendar button for 'From' date", claimsValidate(fromCalendarIconBtn));
			Assert.assertTrue("PROBLEM - unable to locate calendar button for 'To' date", claimsValidate(toCalendarIconBtn));
			System.out.println("Proceed to validate 'From' date calendar will hide and show accordingly");
			fromCalendarIconBtn.click();
			CommonUtility.waitForPageLoad(driver, fromCalendarDatePicker_today, 5);
			Assert.assertTrue("PROBLEM - date picker for 'From' calendar button should have been shown today's date clicked", claimsValidate(fromCalendarDatePicker_today));
			fromCalendarDatePicker_today.click();

			System.out.println("Proceed to validate 'To' date calendar will hide and show accordingly");
			toCalendarIconBtn.click();
			CommonUtility.waitForPageLoad(driver, toCalendarDatePicker_today, 5);
			Assert.assertTrue("PROBLEM - date picker for 'To' calendar button should have been shown today's date clicked", claimsValidate(toCalendarDatePicker_today));
			toCalendarDatePicker_today.click();
			
			String actualFromTxt=fromTxtField.getAttribute("value");
			String actualToTxt=toTxtField.getAttribute("value");
			Assert.assertTrue("PROBLEM - 'From' text not as expected.  Should have been today's date.  "
					+ "Expected='"+todayDate+"' | Actual='"+actualFromTxt+"'", 
					actualFromTxt.equals(todayDate));
			Assert.assertTrue("PROBLEM - 'To' text not as expected.  Should have been today's date.  "
					+ "Expected='"+todayDate+"' | Actual='"+actualToTxt+"'", 
					actualToTxt.equals(todayDate));

		}
	}
}
