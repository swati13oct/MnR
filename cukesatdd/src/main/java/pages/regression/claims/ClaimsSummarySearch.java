package pages.regression.claims;
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
		Assert.assertTrue("PROBLEM - unable to locate 'Custom search' option from dropdown",validate(custSrch));
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
					validate(pdp_drug));
		} else if (planType.contains("MAPD") || planType.contains("MA")
				||planType.contains("PCP") || planType.contains("MEDICA")){
			System.out.println("!!! Validating the drop down to select the claims from last 24 months  !!!");
			last24months = driver.findElement(By.id("date24MAtdd"));
			last24months.click();
			System.out.println("!!! Month Selected from the view claims from drop down is ====>"
			+(last24months.getText()));
			if (!planType.contains("MA")) { //note: MA doesn't have selection
				Assert.assertTrue("PROBLEM - unable to locate 'Medical' for claims type for '"+planType+"' user",
						validate(medical));
			}
			System.out.println("!!! Claim type Medical is validated!!! ");
			if (planType.contains("MAPD") || planType.contains("PCP")) {
				Assert.assertTrue("PROBLEM - unable to locate 'Prescription Drug' for claims type for '"+planType+"' user",
						validate(PrescriptionDrug));
				System.out.println("!!!Claim type PDP is validated !!!");
				PrescriptionDrug.click();
				System.out.println("!!! Claim Type PDP is clicked !!!");
				//note: this validation will only work if user also has drug claims, 
				//note: comment out for now b/c hard to find a user with both type of claims
				//Assert.assertTrue("PROBLEM - unable to locate Prescription Drug claims table for claims type for '"+planType+"' user",
				//	validate(claimsTablePrescriptionDrug));
				//System.out.println("!!! Claims Table PDP is seen on the Claims Summary page!!!");
				//Assert.assertTrue("PROBLEM - unable to locate Rx Number in claims table for claims type for '"+planType+"' user",
				//	validate(RxNumberinthecalimstable));
				//System.out.println("Element on the Rx table is ===>"+ RxNumberinthecalimstable.getText());
				System.out.println("!!! Claim Type Prescription Drug is Selected !!!");
				medical.click();
				System.out.println("!!! Proceed to switch back to claims type Medical !!!");
			}
			//note: by default if not specified, medical claims will be validated
			if (claimSystem.toUpperCase().contains("D_")) {
				System.out.println("This test is specific for validating drug claims, select Prescription Drug option instead");
				PrescriptionDrug.click();
			}
		} else {
			Assert.assertTrue("PROBLEM - unable to locate Custom Search option for '"+planType+"' user",
					validate(custSrch));
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
		//note: MA - Medical; MAPID | PCP - Medical & Prescription drug 
		//note: PDP - Prescription drug; SHIP - no Medical or Prescription drug
		if(planType.equals("SHIP")){
			System.out.println("For ship case, locate the drop down box and select '"+claimPeriod+"' option");
			Select dropdown=new Select (ship_claimsDropdown);	
			dropdown.selectByVisibleText(claimPeriod);
			System.out.println("Clicked '"+claimPeriod+"' option");
		} else if (planType.contains("PDP")) {
			System.out.println("!!!Claim type PDP is validated !!!");
			Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the prescription drug option",
					validate(pdp_drugClaimsTypTxt));
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
			System.out.println("!!! Option selected from the view claims from drop down is ====>"
			+(option.getText()));

			if (planType.equals("MA") || planType.equals("SSUP")) {
				Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the medical option",
						validate(ma_medicalClaimsTypTxt));
			}

			System.out.println("!! Claim type Medical is validated!!! ");
			if ((planType.equals("MAPD") || planType.equals("PCP") || planType.equals("MEDICA")) 
					&& claimType.equalsIgnoreCase("prescription drug")) {
				Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the prescription drug option",
						validate(PrescriptionDrug));
				System.out.println("!!!Claim type PrescriptionDrug is validated !!!");
				PrescriptionDrug.click();
				System.out.println("!!! Claim Type PrescriptionDrug is clicked !!!");
			} else if ((planType.equals("MAPD") || planType.equals("PCP") || planType.equals("MEDICA")) 
					&& claimType.equalsIgnoreCase("medical")) {
				Assert.assertTrue("PROBLEM - planType='"+planType+"' - unable to locate the medical option",
						validate(medical));
				// note: MAPD has both medical and prescription drug options
				// for MA case there will be just medical so there won't be a need for click
				medical.click();
			}
		} else{
			Assert.assertTrue("PROBLEM: Unable to locate customSearch element",validate(custSrch));
			System.out.println("!!! Custom search is seen in the view Claims From drop down ===>"
			+(custSrch.getText()));
			System.out.println("!!! Validating the drop down to select the claims !!!");
		}
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
				srchBtn.click();
			}
			System.out.println("Clicked search button");
		}
	}
}
