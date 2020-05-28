package pages.regression.ordermaterials;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;

/**
 * @author rkodumur
 */
public class OrderMaterialsPage extends OrderMaterialsBase  {
	public OrderMaterialsPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReadyNew(driver);
		//takeCareiPerceptionPopUp();
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		Assert.assertTrue("PROBLEM - unable to locate the header element",orderValidate(common_header_orderPlanMaterialsPage));
	}

	/**
	 * Determine if there is combo tabs on screen
	 * @return
	 */
	public boolean hasComboTabs() {
		if (comboTabs.size()>1) {
			return true;
		}
		return false;
	}

	/**
	 * Validate header section content
	 */
	public void validateHeaderSection() {
		String expectedHeaderText="Order Plan Materials";
		Assert.assertTrue("PROBLEM - unable to locate the header text element on Order Plan Materials",orderValidate(common_header_orderPlanMaterialsPage));
		Assert.assertTrue("PROBLEM - header text on Order Plan Materials is not as expected. Expected='"+expectedHeaderText+"' | Actual='"+common_header_orderPlanMaterialsPage.getText()+"'",expectedHeaderText.equals(common_header_orderPlanMaterialsPage.getText()));

		String expectedSubSectionHeader="Get plan documents and materials by mail.";
		Assert.assertTrue("PROBLEM - unable to locate the sub section header element on Order Plan Materials",orderValidate(common_subSectionHeader));
		Assert.assertTrue("PROBLEM - sub section header content on Order Plan Materials is not as expected. Expected='"+expectedSubSectionHeader+"' | Actual='"+common_subSectionHeader.getText()+"'",expectedSubSectionHeader.equals(common_subSectionHeader.getText()));
	}

	/**
	 * Validate sub header section content
	 * @param planType
	 */
	public void validateSubHeaderSection(String planType) {
		//takeCareiPerceptionPopUp();
		if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
			Assert.assertTrue("PROBLEM - unable to locate the sub section text element on Order Plan Materials",orderValidate(subSectionText_ship));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate the sub section text element on Order Plan Materials",orderValidate(subSectionText_fed));
		}
	}

	/**
	 * Validate selection section content based on planType, memberType
	 * Will validate click to open ID view if applicable
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException
	 */
	public void validateSelectionSection(String planType, String memberType) throws InterruptedException {
		Assert.assertTrue("PROBLEM - unable to locate the selection section on Order Plan Materials",orderValidate(common_selectionSection));
		if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
			CommonUtility.waitForPageLoad(driver, selectionInstruction_ship, 5);
			Assert.assertTrue("PROBLEM - unable to locate the selection instruction element on Order Plan Materials",orderValidate(selectionInstruction_ship));

			Assert.assertTrue("PROBLEM - unable to locate 'Member ID Card (Health Insurance Card)' selection option on Order Plan Materials",orderValidate(option_ship_memberIDcardField));
			Assert.assertTrue("PROBLEM - unable to locate 'VIEW HEALTH INSURANCE CARD' link on Order Plan Materials",orderValidate(link_ship_memberIDcardLink));
			Assert.assertTrue("PROBLEM - unable to locate 'Electronic Funds Transfer(EFT) Brochure' selection option on Order Plan Materials",orderValidate(option_ship_brochureField_EFT));
			Assert.assertTrue("PROBLEM - unable to locate 'Coupon Book' selection option on Order Plan Materials",orderValidate(option_ship_couponBook));
			Assert.assertTrue("PROBLEM - unable to locate 'Medicare Select Hospital Directory' selection option on Order Plan Materials",orderValidate(option_ship_medicareHospital));
			Assert.assertTrue("PROBLEM - unable to locate 'Claims Envelope' selection option on Order Plan Materials",orderValidate(option_ship_medicareHospital));
			Assert.assertTrue("PROBLEM - unable to locate 'Certificate of Insurance' selection option on Order Plan Materials",orderValidate(option_ship_certificateInsurance));
		} else {
			CommonUtility.waitForPageLoad(driver, selectionInstruction_fed, 5);
			Assert.assertTrue("PROBLEM - unable to locate the selection instruction on Order Plan Materials",orderValidate(selectionInstruction_fed));

			//tbd Assert.assertTrue("PROBLEM - unable to locate 'Welcome Guide' selection option on Order Plan Materials",orderValidate(option_fed_memberMaterialsfield));
			Assert.assertTrue("PROBLEM - unable to locate 'Replacement ID card' selection option on Order Plan Materials",orderValidate(option_fed_replacementIdField));
			Assert.assertTrue("PROBLEM - unable to locate 'VIEW MEMBER ID CARD' link on Order Plan Materials",orderValidate(link_fed_memberIDcardLink));
		}

		if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP"))
			validateIDCard("orderPage",planType,link_ship_memberIDcardLink);
		else
			validateIDCard("orderPage",planType,link_fed_memberIDcardLink);
	}

	/**
	 * Validate the shipping address section content
	 */
	public void validateShippingAddressSection() {
		Assert.assertTrue("PROBLEM - unable to locate the 'Shipping Address' section header element on Order Plan Materials",orderValidate(common_sectionShipAddress));
		Assert.assertTrue("PROBLEM - unable to locate the 'Shipping Address' section content element on Order Plan Materials",orderValidate(common_sectionShipAddressContent));
		Assert.assertTrue("PROBLEM - unable to locate the 'Shipping Address' contact Customer Service link element on Order Plan Materials",orderValidate(common_sectionShipAddressContent_needHelpLink));

		common_sectionShipAddressContent_needHelpLink.click();
		CommonUtility.checkPageIsReady(driver);
		Assert.assertTrue("PROBLEM - unable to locate the 'Shipping Address' contact Customer Service link element on Order Plan Materials",orderValidate(common_sectionShipAddressContent_needHelpLink));
		Assert.assertTrue("PROBLEM - unable to locate the 'Need Help' section header after clicking contact Customer Service link on Order Plan Materials",needHelp_SectionHeader.isDisplayed());
	}

	/**
	 * Validate submit button is located
	 */
	public void validateSubmitButton() {
		Assert.assertTrue("PROBLEM - unable to locate the 'Submit' button element on Order Plan Materials",orderValidate(submitButton));
	}

	/**
	 * Validate Printable Documents section content
	 * Will validate clicking of the link
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException 
	 */
	public void validatePrintableDocSection(String planType, String memberType) throws InterruptedException {
		Assert.assertTrue("PROBLEM - unable to locate the 'Printable Documents' section header element on Order Plan Materials",orderValidate(printableDocSection));
		Assert.assertTrue("PROBLEM - unable to locate the 'Printable Documents' link element on Order Plan Materials",orderValidate(printableDocLink));
		String expectedUrl="member/documents/overview.html";
		String actualUrl=printableDocLink.getAttribute("href");
		Assert.assertTrue("PROBOEM - not getting expected URL after clicking '' link.  "
				+ "Expected URL to contain '"+expectedUrl+"' | Actual URL='"+actualUrl+"'", 
				actualUrl.contains(expectedUrl));
		//note: keep the below steps, if 'plan documents & resources" page load faster in reality then below steps would work
		//String originalUrl=driver.getCurrentUrl();
		//printableDocLink.click();
		//CommonUtility.checkPageIsReady(driver);
		//String expectedUrl="member/documents/overview.html";
		//Assert.assertTrue("PROBOEM - not getting expected URL after clicking '' link.  Expected URL to contain '"+expectedUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", driver.getCurrentUrl().contains(expectedUrl));
		//goBackToPriorPageViaPlanMaterialsOrderPlanMaterials(planType, memberType, originalUrl, "formsAndResourcesPage");
	}

	/**
	 * Validate error message related element and text for case when no selection was made when submit button was clicked
	 * @throws InterruptedException
	 */
	public void validateErrorMessage() throws InterruptedException{
		CommonUtility.waitForPageLoad(driver, errorMsg_OrderMaterials, 5);
		Assert.assertTrue("PROBLEM - unable to locate error message after submitting without selection", orderValidate(errorMsg_OrderMaterials));
		Assert.assertTrue("PROBLEM - unable to locate error message text after submitting without selection", orderValidate(errorMsg_OrderMaterials));
		String expectedErrorText="Please select one of the items above.";
		Assert.assertTrue("PROBLEM - not getting expected error text. Expected='"+expectedErrorText+"' | Actual='"+errorMsg_OrderMaterials.getText()+"'", expectedErrorText.equals(errorMsg_OrderMaterials.getText()));
		System.out.println("*************Error Message Displayed: "+errorMsg_OrderMaterials.getText()+" ***************");
	}

	/**
	 * Validate the error message element and text for the SHIP error cases
	 * @throws InterruptedException
	 */
	public void validateShipErrorMessage() throws InterruptedException{
		CommonUtility.waitForPageLoad(driver, errorMsg_serviceFail, 10);
		Assert.assertTrue("PROBLEM - unable to locate error message after submitting without selection", orderValidate(errorMsg_serviceFail));
		System.out.println("*************Error Message displayed for SHIP invalid Selection in Order materials Page***************");
		String expectedErrorText="request cannot be processed at this time";
		Assert.assertTrue("PROBLEM - error text is not as expected.  Expected to contain '"+expectedErrorText+"' | Actual error msg='"+errorMsg_serviceFail.getText()+"'", errorMsg_serviceFail.getText().contains(expectedErrorText));
	}

	/**
	 * Select the material option based on input and submit the request
	 * Will return the selected order item for further validation
	 * @param option
	 * @return
	 * @throws InterruptedException
	 */
	public String selectOption(String option) throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", common_subSectionHeader);
		String itemType="";
		WebElement itemToOrderElement=null;
		if (option.contains("Member Materials") || option.contains("Welcome Guide") || option.contains("Welcome kit")) {
			itemType="Member materials / Welcome Guide / Welcome kit";
			itemToOrderElement=option_fed_memberMaterialsfield;
		} 
		
		else if (option.contains("Replacement ID card")) {
			itemType="Replacement ID card";
			itemToOrderElement=option_fed_replacementIdField;
		}
		
		else if (option.contains("Member ID Card")) {
			itemType="Member ID Card";
			itemToOrderElement=option_ship_memberIDcardField;			
		} else if (option.contains("Electronic Funds Transfer (EFT) Brochure")) {
			itemType="Electronic Funds Transfer (EFT) Brochure";
			itemToOrderElement=option_ship_brochureField_EFT;			
		} else if (option.contains("Premium Payment Envelopes")) {
			itemType="Premium Payment Envelopes";
			itemToOrderElement=option_premiumPayment;			
		} else if (option.contains("Medicare Select Hospital Directory")) {
			itemType="Medicare Select Hospital Directory";
			itemToOrderElement=option_ship_hospitalDirectory;			
		} else if (option.contains("Coupon Book")) {
			itemType="Coupon Book";
			itemToOrderElement=option_ship_couponBook;			
		} else if (option.contains("Claims Envelope")) {
			itemType="Claims Envelope";
			itemToOrderElement=option_ship_claimsEnvelope;			
		} else if (option.contains("Certificate of Insurance")) {
			itemType="Certificate of Insurance";
			itemToOrderElement=option_ship_certificateInsurance;			
		} else if (option.contains("None")){
			System.out.println("validate error case where no option is selected followed by clicking submit button");
		} //else {
			//Assert.assertTrue("PROBLEM - option '"+option+"' is not an expected available option", false);
		//}

		String result="";
		if (option.contains("None")) {
			System.out.println("No option for order material selected");
		} 
		
		else {
			System.out.println("************* Selecting "+itemType+" Radio***************");
			CommonUtility.checkPageIsReady(driver);
			itemToOrderElement.click();
			CommonUtility.checkPageIsReady(driver);
			if (!itemToOrderElement.isEnabled()) {
				System.out.println("************* NOT ABLE to SELECT "+itemType+" Radio***************");
			}
			if (option.contains("Medicare Select Hospital Directory")) {
				//note: extra checking for this option
				Assert.assertTrue("PROBLEM - unable to locate the state dropdown element", orderValidate(option_ship_hospitalDirectory_stateDropdown));
				Select ship_hopspitalStateDropdown = new Select(option_ship_hospitalDirectory_stateDropdown);
				Assert.assertTrue("PROBLEM - there should be total of 58 options from dropdown.  Actual="+ship_hopspitalStateDropdown.getOptions().size(), ship_hopspitalStateDropdown.getOptions().size()==58);
			}
			result=itemToOrderElement.getText();
		}

		CommonUtility.waitForPageLoad(driver, submitButton, 5);
		if(orderValidate(submitButton)){
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", submitButton); 
			System.out.println("****** Submit Button Clicked ********");
		}

		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, addOrderMaterialLink_OrderConfirmation, 10);
		if (orderValidate(header_OrderConfirmation) || orderValidate(addOrderMaterialLink_OrderConfirmation)) {
			System.out.println("@@@@ Opder Plan Material COnfirmation Page is Displayed @@@@");
			if (result.contains("VIEW")) {
				String[] tmp=result.split("VIEW");
				result=tmp[0].trim();
			}
			return result;
		}
		return null;
	}

	/**
	 * Validate Need Help section content
	 * @param planType
	 * @param memberType
	 * @return
	 * @throws InterruptedException 
	 */
	public String validateNeedHelpSection(String planType, String memberType) throws InterruptedException {
		handleComboTabIfComboUser(planType, memberType);
		if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",orderValidate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,needHelp_TechicalSupport_wkEndHrs);

			validateSection="Need Help - General Questions";
			validateNeedHelpSectionContent(validateSection, needHelp_GeneralQuestionsSection, needHelp_GeneralQuestions_img, needHelp_GeneralQuestions_phone, needHelp_GeneralQuestions_tty, needHelp_GeneralQuestions_wkDayHrs,needHelp_GeneralQuestions_wkEndHrs);

			validateSection="Need Help - Claims Support";
			validateNeedHelpSectionContent(validateSection, needHelp_ClaimsSupportSection, needHelp_ClaimsSupport_img, needHelp_ClaimsSupport_phone, needHelp_ClaimsSupport_tty, needHelp_ClaimsSupport_wkDayHrs,needHelp_ClaimsSupport_wkEndHrs);

			System.out.println("Proceed to validate the Need Help - See More Ways section content");
			Assert.assertTrue("PROBLEM - unable to locate the 'See more ways to' text in Need Help section",orderValidate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",orderValidate(needHelp_contactUsLink));
			String originalUrl=driver.getCurrentUrl();
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReady(driver);
			handleComboTabIfComboUser(planType, memberType);
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="content/medicare/member/contact-us/overview.html#/contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl()+"| New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", driver.getTitle().contains(expContactUsTitle));
			goBackToPriorPageViaBack(planType, memberType, originalUrl);
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",orderValidate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,null);

			validateSection="Need Help - Plan Support";
			validateNeedHelpSectionContent(validateSection, needHelp_PlanSupportSection, needHelp_PlanSupport_img, needHelp_PlanSupport_phone, needHelp_PlanSupport_tty, needHelp_PlanSupport_wkDayHrs, null);
		}
		System.out.println("Main window = "+driver.getTitle());
		return driver.getCurrentUrl();
	}

	/**
	 * Validate order material functionality
	 * Will order each available item one at a time, will click on order additional material to order next item
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException
	 */
	public void validateOrderAllItemsIndvidually(String planType, String memberType, boolean skipIdCheck) throws InterruptedException {
		List<String> listOfItems=new ArrayList<String>();
		if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
			listOfItems.add("Member ID Card");
			listOfItems.add("Electronic Funds Transfer (EFT) Brochure");
			listOfItems.add("Coupon Book");
			listOfItems.add("Medicare Select Hospital Directory");
			listOfItems.add("Claims Envelope");
			listOfItems.add("Certificate of Insurance");
		} else {
			//tbd listOfItems.add("Member Materials");
			listOfItems.add("Replacement ID card");
		}
		boolean result=true;
		for (String item: listOfItems) {
			System.out.println("Proceed to order item="+item+"...");
			handleComboTabIfComboUser(planType, memberType);
			validateOrderOneItem(planType, memberType, item, skipIdCheck);
		}
		Assert.assertTrue("PROBLEM - unable to order all available materials individually", result);
	}

	/**
	 * Validate the success message element and content
	 * If applicable, will validate the view ID link that shows up in success message box
	 * note: to simplify matter, if testing from testharness will validate element contains the right URL only.
	 * note: UHC user's ID card link will redirect to 'systest3.myhc.com' instead on testharness access
	 * @param planType
	 * @param memberType
	 * @param expectedOrderedItem
	 * @throws InterruptedException
	 */
	public void validateSuccessmessage(String planType, String memberType, String expectedOrderedItem, boolean skipIdCheck) throws InterruptedException {
		Assert.assertTrue("PROBLEM - unable to locate the successful message box element for confirmation",orderValidate(SuccessMsgbox));
		Assert.assertTrue("PROBLEM - unable to locate the successful message text element for confirmation",orderValidate(SuccessMsgText));
		//note: jenkins run doesn't like the dash '-' in the string so use regex pattern matches instead
		String expectedSuccessPattern="Your order has been submitted. You should be receiving the following plan materials by mail in about 7 (.*) 10 business days.";
		String actualSuccessMsg=SuccessMsgText.getText();
		Assert.assertTrue("PROBLEM - sucess message is not as expected.  \nExpected to match '"+expectedSuccessPattern+"' pattern \nActual msg='"+actualSuccessMsg+"'",actualSuccessMsg.matches(expectedSuccessPattern));
		if (orderValidate(orderedItem_idCard)) {
			Assert.assertTrue("PROBLEM - unable to locate the ordered item element for confirmation",orderValidate(orderedItem_idCard));
			Assert.assertTrue("PROBLEM - ordered item is not as expected in success message.  \nExpected='"+expectedOrderedItem+"' | Actual='"+orderedItem_idCard.getText()+"'",expectedOrderedItem.equals(orderedItem_idCard.getText()));
			Assert.assertTrue("PROBLEM - unable to locate the VIEW MEMEBR ID CARD element for confirmation",orderValidate(viewIdCard));

			if (skipIdCheck) {
				System.out.println("This test will skip ID validation");
			} else {
				validateIDCard("confirmPage",planType,viewIdCard);
			}
		} else {
			if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
				Assert.assertTrue("PROBLEM - unable to locate the ordered item element for confirmation",orderValidate(orderedItem_ship));
				Assert.assertTrue("PROBLEM - ordered item is not as expected in success message.  \nExpected='"+expectedOrderedItem+"' | Actual='"+orderedItem_ship.getText()+"'",expectedOrderedItem.equals(orderedItem_ship.getText()));
			} else {
				Assert.assertTrue("PROBLEM - unable to locate the ordered item element for confirmation",orderValidate(orderedItem));
				Assert.assertTrue("PROBLEM - ordered item is not as expected in success message.  \nExpected='"+expectedOrderedItem+"' | Actual='"+orderedItem.getText()+"'",expectedOrderedItem.equals(orderedItem.getText()));
			}
		}
	}

	public String validateOrderOneItem(String planType, String memberType, String option, boolean skipIdCheck) throws InterruptedException {
		String orderedItem = selectOption(option);
		if (orderedItem==null) {
			if ((planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP"))) {
				if (memberType.toUpperCase().contains("EFT")) {
					Assert.assertTrue("PROBLEM - for SHIP user with 'EFT' setup should have gotten error message when attempting to order 'coupon book'",
							orderValidate(errorMsg_serviceFail));
					System.out.println("Expected - NOT able to order item="+option);
				} else if (!memberType.toUpperCase().contains("MEDSELECTPLAN")) {
					Assert.assertTrue("PROBLEM - for SHIP user without 'MEDICARE_SELECT_PLAN' setup should have gotten error message when attempting to order 'Medicare Select Hospital Directory'",
							orderValidate(errorMsg_serviceFail));
					System.out.println("Expected - NOT able to order item="+option);
				}
				//note: no need to click order additional material link because would still be on order page
			} else if (!planType.equalsIgnoreCase("PDP") && orderValidate(option_fed_memberMaterialsfield_WelcomeKit)) { //note: only PDP can order Welcome Guide
				Assert.assertTrue("PROBLEM - for non-PDP user should have gotten error message when attempting to order 'Welcome kit'",
						orderValidate(errorMsg_serviceFail));
				System.out.println("Expected - NOT able to order item="+option);
			} else if (planType.equalsIgnoreCase("MEDICA") && option.equalsIgnoreCase("Member Materials")) { //note: only PDP can order Welcome Guide
				Assert.assertTrue("PROBLEM - for MEDICA user should have gotten error message when attempting to order 'Membership Materials'",
						orderValidate(errorMsg_serviceFail));
			} else {
				Assert.assertTrue("PROBLEM - unable to order this material: "+option, false);
			}
		} else {
			System.out.println("Expected - ABLE to order item="+option);
			validateSuccessmessage(planType, memberType, orderedItem, skipIdCheck);
			if (orderedItem.contains("Replacement ID card") || orderedItem.contains("Member ID Card")) {
				System.out.println("After validating success result for Replacement ID card, would be landing back on the order page instead, so no need to look for order additional item link in this case");
			} else {
				navigateToOrderMore();
			}
		}
		return orderedItem;
	}
	
	public void validateSegmentId(String planType, String memberType, String expectedSegmentId) {
		String lookForPlanCategory="";
		boolean isComboUser=false;
		if (memberType.toUpperCase().contains("COMBO"))
			isComboUser=true;
		if (planType.equalsIgnoreCase("SHIP") || planType.equalsIgnoreCase("MEDSUPP"))
			lookForPlanCategory="MEDICARE SUPPLEMENT";
		else if (planType.equalsIgnoreCase("SSUP")) 
			lookForPlanCategory="SSP";
		else if (planType.equalsIgnoreCase("PCP") || planType.equalsIgnoreCase("MEDICA")) 
			lookForPlanCategory="MAPD";
		else 
			lookForPlanCategory=planType;

		String consumerDetails=getConsumerDetailsFromlocalStorage();
		String actualSegmentId=getSegmentIdInConsumerDetails(isComboUser, lookForPlanCategory, consumerDetails);
		Assert.assertTrue("PROBLEM - not getting expected SegmentId for plan '"+planType+"'. "
				+ "Expected='"+expectedSegmentId+"' | Actual='"+actualSegmentId+"'", 
				expectedSegmentId.equals(actualSegmentId));
	}
	
	public String getConsumerDetailsFromlocalStorage() {
		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver) ;
		LocalStorage localStorage = webStorage.getLocalStorage();
		String consumerDetails=localStorage.getItem("consumerDetails");
		return consumerDetails;
	}
	
	public String getSegmentIdInConsumerDetails(boolean isComboUser, String lookForPlanCategory, String consumerDetails) {
		String actualSegmentId=null;
		try {
			JSONObject jsonObj = new JSONObject(consumerDetails);
			JSONArray arr =jsonObj.getJSONArray("planProfiles");
			if (isComboUser) 
				Assert.assertTrue("PROBLEM - test data expect this user to be a combo user "
						+ "but the localStorage.consumerDetails has only one planProfiles.  "
						+ "Please double check and correct test data", arr.length()>1);
			for (int i = 0; i < arr.length(); i++) {
				String actualPlanCategory = arr.getJSONObject(i).getString("planCategory");
				//note: need to locate the right plan for segmentId validation
				if (lookForPlanCategory.equals(actualPlanCategory)) {
					actualSegmentId = arr.getJSONObject(i).getString("segmentId");
				}
			}
			Assert.assertTrue("PROBLEM - unable to locate segmentId from localStorage.consumerDetails, "
					+ "please double check input data planType matches user's actual planType", 
					actualSegmentId!=null);
		} catch (JSONException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - encounted problem reading the json result from localStorage.consumerDetails", false);
		}
		return actualSegmentId;
	}
}