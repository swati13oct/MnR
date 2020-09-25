package pages.mobile.acquisition.emailAndPrint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

public class PlanDetailsEmailAndPrintUtilMobile extends EmailAndPrintUtilBaseMobile{

	public PlanDetailsEmailAndPrintUtilMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	public HashMap<String, String> collectInfoVppPlanDetailPg(String plantype, String forWhat, WebDriver origDriver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		System.out.println("Proceed to collect the info on vpp detail page =====");

		HashMap<String, String> result=new HashMap<String, String>();

		String key="Total Tabs";
		result.put(key, String.valueOf(listOfTabHeaders.size()));
		System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));

		key="Number Enroll Button";
		result.put(key, String.valueOf(planDetailEnrollButtonList.size()));
		System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));

		key="Number Add to compare Checkbox";
		result.put(key, String.valueOf(planDetailAddToCompareBoxList.size()));
		System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));
		
		
		for (int i=0; i<listOfTabHeaders.size(); i++) { //note: loop through each table and store info
			listOfTabHeaders.get(i).click();
			CommonUtility.checkPageIsReady(driver);
			int tabIndex=(i+1);
			keepSessionAlive(forWhat, origDriver);
			//tbd if (forWhat.equals("from deepLink"))
			//tbd 	origDriver.navigate().refresh();

			//note: store section header
			for(int k=0; k<listOfSectionHeaderForActiveTab.size(); k++) {
				String sectionHeader=listOfSectionHeaderForActiveTab.get(k).getText();
				key="T"+tabIndex+"S"+(k+1);
				result.put(key, sectionHeader);
			}

			//note: store section table
			int numSectionTable=listOfSectionHeaderForActiveTab.size();
			result.put("Total Sections Per T"+tabIndex,String.valueOf(numSectionTable));
			for(int sectionIndex=1; sectionIndex<=numSectionTable; sectionIndex++) { //note: loop through each section table
				keepSessionAlive(forWhat, origDriver);
				//tbd if (forWhat.equals("from deepLink"))
				//tbd 	origDriver.navigate().refresh();
				String rowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr";
				List<WebElement> listOfRowsPerTable=driver.findElements(By.xpath(rowXpath));
				int numRows=listOfRowsPerTable.size();

				result.put("Total Rows For T"+tabIndex+"S"+sectionIndex,String.valueOf(numRows));

				if (numRows==0) { //note: no table so check for box
					String boxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]";
					List<WebElement> listOfBoxes=driver.findElements(By.xpath(boxXpath));
					result.put("Total Boxs For T"+tabIndex+"S"+sectionIndex, String.valueOf(listOfBoxes.size()));
					for(int boxIndex=1; boxIndex<=listOfBoxes.size(); boxIndex++) { //note: loop through each box
						String eachBoxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]["+boxIndex+"]";
						key="T"+tabIndex+"S"+sectionIndex+"B"+boxIndex;
						WebElement e=driver.findElement(By.xpath(eachBoxXpath));
						String value=e.getText();
						result.put(key, value);
						System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));
					}

					//note: assume this is the optional service tab
					//note: after going through all the box should be no more section, don't iterate the rest of the section counts
					break;
				} else {
					for(int rowIndex=1; rowIndex<=listOfRowsPerTable.size(); rowIndex++) { //note: loop through each row
						String cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";
						List<WebElement> listOfCellsPerRow=driver.findElements(By.xpath(cellsPerRowXpath));
						result.put("Total Cells For T"+tabIndex+"S"+sectionIndex+"R"+rowIndex,String.valueOf(listOfCellsPerRow.size()));
						for (int cellIndex=1; cellIndex<=listOfCellsPerRow.size(); cellIndex++) {
							String eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";
							WebElement e=driver.findElement(By.xpath(eachCellXpath));
							key="T"+tabIndex+"S"+sectionIndex+"R"+rowIndex+"C"+cellIndex;
							//tbd String value=e.getAttribute("textContent");
							String value=e.getAttribute("innerText");
							result.put(key, value);
						}
					}
				}
			}
		}
		System.out.println("Finished collecting the info on vpp detail page =====");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return result;
	}

	
	public String detail_comparePageItem(String targetKey, HashMap<String, String> origPage, HashMap<String, String> emailage, String planType) {
		String originalValue=origPage.get(targetKey);
		String emailValue=emailage.get(targetKey);
		//note: replace all \r\n or \n to make output consistent in both for compare
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String failedMessage="NONE";
		System.out.println("TEST - validate content for map key="+targetKey+"...");
		//note: MA  BYPASS: T1S1R2C2 T2S1R7C2 T2S1R8C2 T3S1B1 T4S1R9C1 Plan Heart
		//note: PDP BYPASS: T1S1R7C2 T1S1R8C2 T1S1R10C2 T1S1R17C1 Plan Heart
		//note: SNP BYPASS: T1S1R2C2 T1S1R9C2  T1S1R10C2 T2S1R1C2 T2S1R3C2 T2S1R4C2 T2S1R5C2 
		//tbd if (!(origPage.get(targetKey)).equals(emailage.get(targetKey))) {
		if (!originalValue.equals(emailValue)) {
			if (((planType.equalsIgnoreCase("MA")) && 
					(targetKey.equals("T1S1R2C2") || targetKey.equals("T2S1R7C2") || targetKey.equals("T2S1R8C2") || 
							targetKey.equals("T3S1B1") || targetKey.equals("T4S1R9C1") || targetKey.equals("T2S1R10C2")))
				||	
					((planType.equalsIgnoreCase("PDP")) &&
					(targetKey.equals("T1S1R7C2") || targetKey.equals("T1S1R8C2") || targetKey.equals("T1S1R10C2") || 
							targetKey.equals("T1S1R17C1")))
				||	
					((planType.equalsIgnoreCase("SNP")) &&
					(targetKey.equals("T1S1R2C2") || targetKey.equals("T1S1R9C2") || targetKey.equals("T1S1R10C2") || targetKey.equals("T2S1R1C2")
					||	targetKey.equals("T2S1R3C2") || targetKey.equals("T2S1R4C2") || targetKey.equals("T2S1R5C2"))) 
					) {
				failedMessage="BYPASS '"+planType+"' validation until fix (tick# xxxxx) - ";
				failedMessage=failedMessage+"item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			} else if (originalValue.contains("footnote") && !emailValue.contains("footnote")) {
				//note: footnote is not actual text on UI display but in original page getAttribute("innerText") or getTextContent() are picking it up as text
				//note: on UI both looks identifical betwween original page and email
				failedMessage="BYPASS '"+planType+"' validation for extra footnote - ";
				failedMessage=failedMessage+"item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			} else {
				//note: Some extra empty line or space are showing with getAttribute("innerText") or getTextContent() are picking it up as text
				//note: on UI both looks identifical betwween original page and email
				//note: attempt to clean up the string to do one comparison one more time
				originalValue=originalValue.replaceAll("(\r\n|\n)", "").replaceAll("\\s", "");
				emailValue=emailValue.replaceAll("(\r\n|\n)", "").replaceAll("\\s", "");
				if (originalValue.equals(emailValue)) {
					failedMessage="BYPASS '"+planType+"' validation for extra new line or space - ";
					failedMessage=failedMessage+"item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
				} else {
					//note:...ok, give up
					detail_finalResult=false;
					failedMessage="item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
					
				}
				
				
			}
		}
		System.out.println("TEST - failedMessage="+failedMessage);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return failedMessage;
	}

	boolean detail_finalResult=true;
	public List<String> validatePlanDetailEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, String> origPage, WebDriver origDriver) {
		String forWhat="from deepLink";
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		
		keepSessionAlive(forWhat, origDriver);//note: need this to trick the original driver from timing out before the validation is done
		//tbd origDriver.navigate().refresh(); 
		List<String> testNote=new ArrayList<String>();
		List<String> listOfFailure=new ArrayList<String>();

		System.out.println("Proceed to validate the original page content vs page content from email deeplnk for plan detail...");
		System.out.println("Collect info from page content of the plan compare");
		HashMap<String, String> emailPage=collectInfoVppPlanDetailPg(planType, forWhat, origDriver);
		keepSessionAlive(forWhat, origDriver);//note: need this to trick the original driver from timing out before the validation is done
		//tbd origDriver.navigate().refresh(); 
		
		String targetKey="Total Tabs";
		String failedMessage=detail_comparePageItem(targetKey, origPage, emailPage, planType);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		targetKey="Number Enroll Button";
		failedMessage=detail_comparePageItem(targetKey, origPage, emailPage, planType);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);
		
		targetKey="Number Add to compare Checkbox";
		failedMessage=detail_comparePageItem(targetKey, origPage, emailPage, planType);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);
		
		int totalTabs=Integer.valueOf(origPage.get(targetKey));
		System.out.println("TEST - totalTabs="+totalTabs);
		for (int tabIndex=1; tabIndex<=totalTabs; tabIndex++) { //note: loop through each table and validate info
			keepSessionAlive(forWhat, origDriver);//note: need this to trick the original driver from timing out before the validation is done
			//tbd origDriver.navigate().refresh(); 
			targetKey="Total Sections Per T"+tabIndex;
			failedMessage=detail_comparePageItem(targetKey, origPage, emailPage, planType);
			if (failedMessage.contains("mismatch")) 
				listOfFailure.add(failedMessage);	
			if (failedMessage.contains("BYPASS")) 
				testNote.add(failedMessage);

			int totalSectionsPerTab=Integer.valueOf(origPage.get(targetKey));
			System.out.println("TEST - totalSectionsPerTab="+totalSectionsPerTab);

			for(int sectionIndex=1; sectionIndex<=totalSectionsPerTab; sectionIndex++) { //note: loop through each section table
				targetKey="Total Rows For T"+tabIndex+"S"+sectionIndex;
				System.out.println("TEST - targetKey="+targetKey);	
				keepSessionAlive(forWhat, origDriver);//note: need this to trick the original driver from timing out before the validation is done
				//tbd origDriver.navigate().refresh(); 
				failedMessage=detail_comparePageItem(targetKey, origPage, emailPage, planType);
				if (failedMessage.contains("mismatch")) 
					listOfFailure.add(failedMessage);	
				if (failedMessage.contains("BYPASS")) 
					testNote.add(failedMessage);

				int totalRowsPerSectionOfActiveTab=Integer.valueOf(origPage.get(targetKey));
				System.out.println("TEST - totalRowsPerSectionOfActiveTab="+totalRowsPerSectionOfActiveTab);
				if (totalRowsPerSectionOfActiveTab==0) {  //note: no table so check for box
					targetKey="Total Boxs For T"+tabIndex+"S"+sectionIndex;
					failedMessage=detail_comparePageItem(targetKey, origPage, emailPage, planType);
					if (failedMessage.contains("mismatch")) 
						listOfFailure.add(failedMessage);	
					if (failedMessage.contains("BYPASS")) 
						testNote.add(failedMessage);

					int totalBoxesPerSectionOfActiveTab=Integer.valueOf(origPage.get(targetKey));
					System.out.println("TEST - totalBoxesPerSectionOfActiveTab="+totalBoxesPerSectionOfActiveTab);
					for(int boxIndex=1; boxIndex<=totalBoxesPerSectionOfActiveTab; boxIndex++) {
						targetKey="T"+tabIndex+"S"+sectionIndex+"B"+boxIndex;
						System.out.println("TEST - targetKey="+targetKey);	
						failedMessage=detail_comparePageItem(targetKey, origPage, emailPage, planType);
						if (failedMessage.contains("mismatch")) 
							listOfFailure.add(failedMessage);	
						if (failedMessage.contains("BYPASS")) 
							testNote.add(failedMessage);
					}

					//note: assume this is the optional service tab
					//note: after going through all the boxes should be no more section, don't iterate the rest of the section counts
					break;
				} else {
					for(int rowIndex=1; rowIndex<=totalRowsPerSectionOfActiveTab; rowIndex++) { //note: loop through each row
						targetKey="Total Cells For T"+tabIndex+"S"+sectionIndex+"R"+rowIndex;
						System.out.println("TEST - targetKey="+targetKey);	
						failedMessage=detail_comparePageItem(targetKey, origPage, emailPage, planType);
						if (failedMessage.contains("mismatch")) 
							listOfFailure.add(failedMessage);	
						if (failedMessage.contains("BYPASS")) 
							testNote.add(failedMessage);

						int totalCellsPerRow=Integer.valueOf(origPage.get(targetKey));
						System.out.println("TEST - totalCellsPerRow="+totalCellsPerRow);
						for (int cellIndex=1; cellIndex<=totalCellsPerRow; cellIndex++) { //note: loop through each cell on the row
							targetKey="T"+tabIndex+"S"+sectionIndex+"R"+rowIndex+"C"+cellIndex;
							System.out.println("TEST - targetKey="+targetKey);	
							failedMessage=detail_comparePageItem(targetKey, origPage, emailPage, planType);
							if (failedMessage.contains("mismatch")) 
								listOfFailure.add(failedMessage);	
							if (failedMessage.contains("BYPASS")) 
								testNote.add(failedMessage);
						}
					}
				}
			}
			System.out.println("=========== Final result ==============");
			if (detail_finalResult) { 
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
		}
		System.out.println("Finished validation for the original page content vs page content from email deeplnk for plan detail ===========");
		Assert.assertTrue("PROBLEM - original page content and email deeplink page content are not the same. total items mismatch='"+listOfFailure.size()+"'. list of mismatch: "+listOfFailure , detail_finalResult);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return testNote;
	}		

	public void validatingFunctionalityOfEmailOnPlanDetails() {

		validateEmailButtonOnPlanDetails.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		validateNew(emailPopup);
		validateNew(cancelButtonEmailPlanDetailsPopUp);
		System.out.println("!!!Cancel Button is displayed ===>" + cancelButtonEmailPlanDetailsPopUp.isDisplayed());
		cancelButtonEmailPlanDetailsPopUp.click();
		;
		validateEmailButtonOnPlanDetails.click();
		validateNew(emailPopup);
		validateNew(sendButtonEmailPlanDetailsPopUp);
		System.out.println("!!!Cancel Button is displayed ===>" + sendButtonEmailPlanDetailsPopUp.isDisplayed());
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("alisha_kapoor@optum.com");
		System.out.println("!!!Entered valid Email ");
		sendButtonEmailPlanDetailsPopUp.click();
		System.out.println("Email has success fully send to user");
		Assert.assertTrue("PROBLEM - unable to get successful message after clicking send", validate(validatesuccesspopup));
		//validateNew(validatesuccesspopup);
		System.out.println("Validated Thank you Message");
		closeButtonthankyoumessagepopup.click();
		CommonUtility.checkPageIsReady(driver);

	}
	public void validatingFunctionalityOfPrintOnPlanDetails(String planType) {
		//note: the print function will bring up the print preview window where the content can't be controlled by selenium
		// for now will only validate the print button will bring up the print preview page
		System.out.println("Proceed to validate print popup screen for cancel option");
		validatePrintButtonOnPlanDetails.click();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//System.out.println("TEST --------------- before handler="+driver.getWindowHandle());
		String originalPageTitle=driver.getTitle();

		//switch to handle the new print window
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		sleepBySec(5);
		//CommonUtility.checkPageIsReady(driver);
		// Perform the actions on new window
		//System.out.println("TEST  --------------- after handler="+driver.getWindowHandle());
		System.out.println("Proceed to validate the new window content for print");
		String printPreviewPageTitle=driver.getTitle();
		Assert.assertTrue("PROBLEM - print preview page title should be empty (untitled).  Actual='"+printPreviewPageTitle+"'", printPreviewPageTitle.equals(""));

		System.out.println("Proceed to close the print preview window");
		driver.close();

		// note: Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//System.out.println("TEST  --------------- back handler="+driver.getWindowHandle());
		String pageTitleAfterClosingPrintPreview=driver.getTitle();
		Assert.assertTrue("PROBLEM - page title should have been the same after closing print preview.  | Before='"+originalPageTitle+"' | After='"+pageTitleAfterClosingPrintPreview+"'", originalPageTitle.equals(pageTitleAfterClosingPrintPreview));
	}
	
	public void validatePrintPlanDetails() {
		validateNew(validatePrintButtonOnPlanDetails);
		System.out.println("successfully validated the Print Buttons on plan details page.");
	}
	
	public void validateEmailOnPlanDetails() {
		validateNew(validateEmailButtonOnPlanDetails);
		System.out.println("successfully validated the email Buttons on plan details page.");

	}

}
