package pages.regression.prepareForNextYear;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;

public class PrepareForNextYearPage  extends PrepareForNextYearBase {

	public PrepareForNextYearPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
	}
	
	public boolean hasPrepareForNextYearTabDisplay(boolean expectTab) {
		if (noWaitValidate(prepareForNextYearTab))
			return true;
		else 
			return false;
	}
	
	public PrepareForNextYearPage fromBenefitsPgNavigateToPrepareForNextYearPage(String planType, String memberType, boolean expComboTab) {
		System.out.println("TEST - attempt to click the PrepareForNextYear tab to go to the PrepareForNextYear page...");
		if (noWaitValidate(prepareForNextYearTab)) {
			prepareForNextYearTab.click();
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, prepareForNextYearPgHeader, 10);
		checkModelPopup(driver,1);
		Assert.assertTrue("PROBLEM - unable to navigate to 'Prepare For Next Year' page via 'Prepare For Next Year' tab on Benefit sub menu", noWaitValidate(prepareForNextYearPgHeader));

		if (expComboTab) 
			handleComboTabIfComboUser(planType, memberType);
		return new PrepareForNextYearPage(driver);
	}
	
	public WebDriver navigateToBenefitsPage(String planType, String memberType, boolean expComboTab) {
		if (noWaitValidate(benefitsTopMenuLnk)) {
			benefitsTopMenuLnk.click();
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement benefitsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
				benefitsTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Benefits link on top menu", false);
			}
		}
		checkModelPopup(driver,1);
		if (expComboTab) 
				handleComboTabIfComboUser(planType, memberType);
	
		return driver;
	}
	
	public List<String>  validateTimeLineBoxContent(boolean expNoBlue_t1, boolean expNoBlue_t2, boolean expNoBlue_t3, boolean expNoBlue_t4, boolean expNoBlue_t5) {
		List<String> note=new ArrayList<String>();
		String targetItem="Time line section";
		WebElement targetElement=tl_section;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line box header";
		targetElement=tl_sectionHeader;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		//note: milestone1 - Sept 15 ----------------------------------
		String dateStr="September 15";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone1Line;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t1) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t1) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone1Dot_noBlue;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone1Dot_blue;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);
		
		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone1Date;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);
		

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone1Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		String targetActText=targetElement.getText();
		String targetExpText="Your Annual Notice of Changes and plan documents for next year will start to be available.";
		Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
				+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\t  PASSED - validation for "+targetItem);

		//note: milestone2 - Oct 1 ----------------------------------
		dateStr="October 1";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone2Line;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t2) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\t  PASSED - validation for "+targetItem);
		
		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t2) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone2Dot_noBlue;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone2Dot_blue;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);
		
		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone2Date;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone2Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="You'll be able to compare next year's plan with your current plan to find out how your coverage may change.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\t  PASSED - validation for "+targetItem);
		
		
		//note: milestone3 - Oct 15 ----------------------------------
		dateStr="October 15";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone3Line;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t3) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t3) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone3Dot_noBlue;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone3Dot_blue;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);
		
		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone3Date;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone3Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="If your needs have changed and you want a different plan for next year, you can switch to a new plan.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\t  PASSED - validation for "+targetItem);
		
		
		//note: milestone4 - Dec 7 ----------------------------------
		dateStr="December 7";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone4Line;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t4) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t4) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone4Dot_noBlue;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone4Dot_blue;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);
		
		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone4Date;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone4Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="This is the last day you can join a new plan for next year.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\t  PASSED - validation for "+targetItem);
	
		
		//note: milestone5 - Jan 1 ----------------------------------
		dateStr="January 1";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone5Line;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t5) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t5) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone5Dot_noBlue;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone5Dot_blue;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);
		
		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone5Date;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone5Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="Your 2021 plan coverage starts today.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\t  PASSED - validation for "+targetItem);
		return note;
	}
	
	public List<String> validateGetReadySectionContent(boolean expChkMrGreen_g1, boolean expChkMrGreen_g2, boolean expChkMrGreen_g3, boolean expChkMrGreen_g4) {
		List<String> note=new ArrayList<String>();
		String targetItem="Get Ready for next year's plan section";
		WebElement targetElement=getReadySection;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Get Ready for next year's plan section header";
		targetElement=getReadySection_header;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Get Ready for next year's plan section text";
		targetElement=getReadySection_text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		//---------------------------------------------
		String section="Review plan changes";
		targetItem=section+" - section";
		targetElement=reviewPlanChanges;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - Circle";
		targetElement=reviewPlanChanges_circle;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - header";
		targetElement=reviewPlanChanges_header;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - text";
		targetElement=reviewPlanChanges_text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		//---------------------------------------------
		section="Review plan materials";
		targetItem=section+" - section";
		targetElement=reviewPlanMaterials;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - Circle";
		targetElement=reviewPlanMaterials_circle;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - header";
		targetElement=reviewPlanMaterials_header;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - text";
		targetElement=reviewPlanMaterials_text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);
		   
		//---------------------------------------------
		section="Compare plans online";
		targetItem=section+" - section";
		targetElement=comparePlanOnline;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - Circle";
		targetElement=comparePlanOnline_circle;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - header";
		targetElement=comparePlanOnline_header;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - text";
		targetElement=comparePlanOnline_text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);
		   
		//---------------------------------------------
		section="Enroll in the plan that works for you";
		targetItem=section+" - section";
		targetElement=enrollInPlan;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - Circle";
		targetElement=enrollInPlan_circle;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - header";
		targetElement=enrollInPlan_header;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - text";
		targetElement=enrollInPlan_text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);
		return note;
	}

	public List<String> validateBeforeM1Content() {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=true;
		boolean expNoBlue_t2=true;
		boolean expNoBlue_t3=true;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);
		
		//TODO
		boolean g1=false;
		boolean g2=false;
		boolean g3=false;
		boolean g4=false;
		List<String> s2=validateGetReadySectionContent(g1, g2, g3, g4);
		sectionNote1.addAll(s2);
		
		return sectionNote1;
	}

	public List<String>  validateAfterOrEqualM1BeforeM2Content() {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=true;
		boolean expNoBlue_t3=true;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);
		
		//Assert.assertTrue("TO-DO", false);
		boolean g1=false;
		boolean g2=false;
		boolean g3=false;
		boolean g4=false;
		List<String> s2=validateGetReadySectionContent(g1, g2, g3, g4);
		sectionNote1.addAll(s2);
		
		return sectionNote1;
	}
	public List<String>  validateAfterOrEqalM2BeforeM3Content() {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=true;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);
		
		//TODO
		boolean g1=false;
		boolean g2=false;
		boolean g3=false;
		boolean g4=false;
		List<String> s2=validateGetReadySectionContent(g1, g2, g3, g4);
		sectionNote1.addAll(s2);
		
		return sectionNote1;
	}
	public List<String>  validateAfterOrEqalM3BeforeM4Content() {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=false;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);
		
		//TODO
		boolean g1=false;
		boolean g2=false;
		boolean g3=false;
		boolean g4=false;
		List<String> s2=validateGetReadySectionContent(g1, g2, g3, g4);
		sectionNote1.addAll(s2);
		
		return sectionNote1;
	}
	public List<String>  validateAfterOrEqalM4BeforeM5Content() {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=false;
		boolean expNoBlue_t4=false;
		boolean expNoBlue_t5=true;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);
		
		//TODO
		boolean g1=false;
		boolean g2=false;
		boolean g3=false;
		boolean g4=false;
		List<String> s2=validateGetReadySectionContent(g1, g2, g3, g4);
		sectionNote1.addAll(s2);
		
		return sectionNote1;
	}
	public List<String>  validateAfterOrEqalM5Content() {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=false;
		boolean expNoBlue_t4=false;
		boolean expNoBlue_t5=false;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);
		
		//TODO
		boolean g1=false;
		boolean g2=false;
		boolean g3=false;
		boolean g4=false;
		List<String> s2=validateGetReadySectionContent(g1, g2, g3, g4);
		sectionNote1.addAll(s2);
		
		return sectionNote1;
	}
	
	public void validateBookmarkError() {
		String tmpUrl=driver.getCurrentUrl();
		String tmp[]=tmpUrl.split("/benefits");
		String bookmark=tmp[0]+"/planfornextyear/overview.html";
		driver.get(bookmark);
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,1);
		Assert.assertTrue("PROBLEM - unable to locate error message when attempting to access bookmark when tab hasn't met conditions to be displayed", noWaitValidate(bookmarkErrMsg));
		String actMsg=bookmarkErrMsg.getText();;
		String expMsg="Your requested cannot be processed .Please try later";
		Assert.assertTrue("PROBLEM - error message is not as expected.  Expect='"+expMsg+"' | Actual='"+actMsg+"'", actMsg.contains(expMsg));
		Assert.assertTrue("PROBLEM - unable to locate the link that would allow user to go back to home page", noWaitValidate(bookmarkErrPgGoBackHome));
		
	}
}