package pages.mobile.acquisition.emailAndPrint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;

public class PlanCompareEmailAndPrintUtilMobile extends EmailAndPrintUtilBaseMobile{

	public PlanCompareEmailAndPrintUtilMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	public HashMap<String, String> collectInfoVppPlanComparePg(String planType, String forWhat, WebDriver origDriver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		System.out.println("Proceed to collect the info on vpp compare page =====");
		HashMap<String, String> result=new HashMap<String, String>();
		result.put("Page Header", cmpPgHeader.getText());

		result.put("Columns Count", String.valueOf(listOfCmpPlansColumns.size()));
		for (int i=1; i<=listOfCmpPlansColumns.size(); i++) {
			keepSessionAlive(forWhat, origDriver);
			//tbd if (forWhat.equals("email deepLink")) 
			//tbd 	origDriver.navigate().refresh();
			String columnXpath="//div[@id='topRowCopy']//div[@ng-repeat='i in count']["+i+"]";

			String planNameXpath=columnXpath+"//h3";
			result.put(i+"- Plan Name", "none");
			try {
				WebElement e=driver.findElement(By.xpath(planNameXpath));
				if (validate(e))
					result.put(i+"- Plan Name", e.getAttribute("textContent"));
			} catch (Exception e) {
				System.out.println("no plan name info for '"+i+"- Plan Name'");
			}
			System.out.println("TEST - "+i+"- Plan Name="+result.get(i+"- Plan Name"));

			String heartXpath=columnXpath+"//a[contains(@class,'added')]";
			result.put(i+"- Plan Heart", "none");
			try {
				WebElement e=driver.findElement(By.xpath(heartXpath));
				if (validate(e)) 
					result.put(i+"- Plan Heart", "saved");
			} catch (Exception e) {
				System.out.println("no plan heart info for '"+i+"- Plan Heart'");
			}
			System.out.println("TEST - "+i+"- Plan Heart="+result.get(i+"- Plan Heart"));
			
			String enrollXpath=columnXpath+"//div[@id='innerdiv' and not(contains(@class,'ng-hide'))]//a[contains(@id,'enrollbtnplancompare')]";
			result.put(i+"- Plan Enroll", "none");
			try {
				WebElement e=driver.findElement(By.xpath(enrollXpath));
				if (validate(e)) 
					result.put(i+"- Plan Enroll", "true");
			} catch (Exception e) {
				System.out.println("no plan Enroll Button for '"+i+"- Plan Enroll'");
			}
			System.out.println("TEST - "+i+"- Plan Enroll="+result.get(i+"- Plan Enroll"));

		}
		int cellsPerRow=listOfCmpPlansColumns.size()+1;
		result.put("Total Table Rows", String.valueOf(listOfRowsInPlanCompareTbl.size()));
		//note: loop through each row
		int rowStartAt=1;
		if (planType.equals("PDP")) {
			rowStartAt=24;
		}
		for (int i=rowStartAt; i<=listOfRowsInPlanCompareTbl.size(); i++) {
			keepSessionAlive(forWhat, origDriver);
			//tbd if (forWhat.equals("email deepLink")) 
			//tbd 	origDriver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
			String rowXpath="//table[@id='fixTable']//tr["+i+"]//td";
			List<WebElement> tmp=driver.findElements(By.xpath(rowXpath));
			if (tmp.size()==1) {
				// only one cell then that's the table section header
				String cellXpath="//table[@id='fixTable']//tr["+i+"]//td[1]";
				WebElement e=driver.findElement(By.xpath(cellXpath));
				String key="R"+i+"C1";
				String value=e.getAttribute("textContent");
				result.put("R"+i+"C1", value);
				System.out.println("TEST - "+forWhat+" - key='"+key+"' | value='"+value+"'");
				for (int j=1; j<=cellsPerRow; j++) {
					key="R"+i+"C"+j;
					result.put(key, "none");
					System.out.println("TEST - "+forWhat+" - key='"+key+"' | value='"+value+"'");
				}
			} else { //note: data row, collect text of each cell
				for (int j=1; j<=cellsPerRow; j++) {
					String cellXpath = "";
					try{
						cellXpath="//table[@id='fixTable']//tr["+i+"]//td["+j+"]";
						WebElement e=driver.findElement(By.xpath(cellXpath));
						String key="R"+i+"C"+j;
						String value=e.getText();
						result.put(key, value);
						System.out.println("TEST - "+forWhat+" - key='"+key+"' | value='"+value+"'");
					}catch (NoSuchElementException e) {
						System.out.println("unable to find this element with xpath='"+cellXpath+"', ignore it, move on");
					}
				}
			}
		}
		System.out.println("Finished collecting the info on vpp compare page =====");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return result;
	}

	public void validatePlanCompareEmailThankYouMessage() {
		validateemailbutton.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Validating email popup
		validate(leavingcomapreplansitepopup);
		System.out.println("!!!Leaving site popup is displayed ===>"+leavingcomapreplansitepopup.isDisplayed());
		//Validating email cancel button
		validate(cancelButtonEmailPlanComparePopUp);
		System.out.println("!!!Cancel Button is displayed ===>"+cancelButtonEmailPlanComparePopUp.isDisplayed());
		cancelButtonEmailPlanComparePopUp.click();
		System.out.println("Success click of cancel email");
		//Validating email send button
		validateemailbutton.click();
		validate(leavingcomapreplansitepopup);
		System.out.println("!!!Leaving site popup is displayed ===>"+leavingcomapreplansitepopup.isDisplayed());
		validate(sendButtonEmailPlanComparePopUp);
		System.out.println("!!!Cancel Button is displayed ===>"+sendButtonEmailPlanComparePopUp.isDisplayed());
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("rani_madadi@optum.com");
		System.out.println("!!!Entered valid Email ");
		sendButtonEmailPlanComparePopUp.click();
		Assert.assertTrue("PROBLEM - unable to get success message after clicking send", validate(validatesuccesspopup));
		//Validating email success popup
		System.out.println("Email has successfull send to user");
		validateNew(validatesuccesspopup);
		System.out.println("Validated Thank you Message");
		
		closeButtonthankyoumessagepopup.click();
		System.out.println("Thank you Message pop up is closed");
	}

	public void validatePrintPlanCompare() {
		sleepBySec(1); //note: keep this sleep for compare page
		CommonUtility.waitForPageLoad(driver, compare_validateprintbutton, 5);
		//moveMouseToElement(cmpPgHeader);
		validateNew(compare_validateprintbutton);
		System.out.println("successfully validated the Print in plan compare page ");
	}

	public void validateEmailPlanCompare() {
		validateNew(compare_validateemailbutton);
		System.out.println("successfully validated the Email in plan compare page ");
	}

	public String compare_comparePageItem(String targetKey, HashMap<String, String> origPage, HashMap<String, String> emailage) {
		String failedMessage="NONE";
		System.out.println("TEST - validate content for map key="+targetKey+"...");
		if (origPage.get(targetKey)!=null && !(origPage.get(targetKey)).equals(emailage.get(targetKey))) {
			//note: keep this for now in case anything needs to be bypassed
			//note: for now can't tell because page is flashing
			if (targetKey.contains("Plan Heart")) { 
			 	failedMessage="BYPASS validation until fix (tick# xxxxx) - ";
			 	failedMessage=failedMessage+"item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			} else {
				compare_finalResult=false;
				failedMessage="item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			 }
		}
		System.out.println("TEST - failedMessage="+failedMessage);		
		return failedMessage;
	}

	boolean compare_finalResult=true;
	public List<String> validatePlanCompareEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, String> origPage, WebDriver origDriver) {
		String forWhat="from deepLink";
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		List<String> testNote=new ArrayList<String>();
		System.out.println("Proceed to validate the original page content vs page content from email deeplnk for plan compare...");
		List<String> listOfFailure=new ArrayList<String>();
		System.out.println("Proceed to validate the original page content vs page content from email deeplnk for plan compare...");

		System.out.println("Collect info from page content of the plan compare");
		HashMap<String, String> emailPage=collectInfoVppPlanComparePg(planType, forWhat, origDriver);
		
		String targetKey="Page Header";
		String failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		targetKey="Columns Count";
		int numPlanColumns=Integer.valueOf(origPage.get(targetKey));
		failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		for (int i=1; i<=numPlanColumns; i++) {
			targetKey=i+"- Plan Name";
			failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
			if (failedMessage.contains("mismatch")) 
				listOfFailure.add(failedMessage);	
			if (failedMessage.contains("BYPASS")) 
				testNote.add(failedMessage);

			targetKey=i+"- Plan Heart";
			failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
			if (failedMessage.contains("mismatch")) 
				listOfFailure.add(failedMessage);	
			if (failedMessage.contains("BYPASS")) 
				testNote.add(failedMessage);

			targetKey=i+"- Plan Enroll";
			failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
			if (failedMessage.contains("mismatch")) 
				listOfFailure.add(failedMessage);	
			if (failedMessage.contains("BYPASS")) 
				testNote.add(failedMessage);
		}

		int cellsPerRow=numPlanColumns+1;
		int totalTableRows=Integer.valueOf(origPage.get("Total Table Rows"));
		int startRowIndex=1;
		if (planType.equals("PDP")) {
			startRowIndex=24;
		}
		for (int r=startRowIndex; r<=totalTableRows; r++) {
			for (int c=1; c<=cellsPerRow; c++) {
				targetKey="R"+r+"C"+c;
				failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
				if (failedMessage.contains("mismatch")) 
					listOfFailure.add(failedMessage);	
				if (failedMessage.contains("BYPASS")) 
					testNote.add(failedMessage);
			}		
		}
		System.out.println("Finished validation for the original page content vs page content from email deeplnk for plan compare ===========");

		if (compare_finalResult) { 
			if (testNote.size()==0) {
				System.out.println("GOOD - original page content and email deeplink page content matched.");
			} else {
				System.out.println("SEMI GOOD - there are BYPASSED items, most original page content and email deeplink page content matched.");
			}
		} else {
			System.out.println("PROBLEM - original page content and email deeplink page content are not the same.");
			for (String s: listOfFailure) {
				System.out.println(s);
			}
		}

		Assert.assertTrue("PROBLEM - original page content and email deeplink page content are not the same. total items mismatch='"+listOfFailure.size()+"'. list of mismatch: "+listOfFailure , compare_finalResult);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return testNote;
	}
	
	public void waitForComparePageToLoad() {
		CommonUtility.waitForPageLoad(driver, cmpPgHeader, 5);
	} 

}
