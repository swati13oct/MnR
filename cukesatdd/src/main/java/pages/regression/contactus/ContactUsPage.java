/**
 * 
 */
package pages.regression.contactus;

import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;

/**
 * @author bnaveen4
 *
 */
public class ContactUsPage extends UhcDriver{

		
	//DIANE
	//@FindBy(xpath = "//a[contains@href,'1-800-721-0627')]")
	//private WebElement staticTFN;
	//@FindBy(xpath = "//a[contains@href, 'tel:1-800-721-0627']")
	
	@FindBy(xpath = "//a[@href = 'tel:1-800-721-0627']")
	private WebElement staticTFN; 
	
	@FindBy(xpath = "/html/body/div[2]/footer/div/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/ul/li[1]/a")
	private WebElement contactUsLink2; 
	
	@FindBy(xpath = "//*[@id='coveragebenefits_2']")
	private WebElement benefitAndCovergae;
	
	@FindBy(xpath=  "//a[contains(@ng-href,'tel:')]") 
	private WebElement preEffectiveTechSupportNumber;
		
	@FindBy(xpath=  ".//*[@id='cardslideID']//*[contains(@class,'btn btn--primary message-btn') and contains(@ng-click,'true')]")
	private WebElement getStartedButton;
	
	@FindBy(id = "message-cancel")
	private WebElement cancelLink;
	
	@FindBy(xpath = "//*[@id='fillContactFormsShow']/form/fieldset/a")
	private WebElement cancelLink1;
	
	@FindBy(xpath = "//a[contains(text(),'EMAIL FORM')]")
	private WebElement EmailForm;
	
	@FindBy(xpath="//*[@id='message-form']/fieldset/div[2]/div")
	private WebElement useDifferentEmailRadioButton;
	
	@FindBy(id = "message-emails")
	private WebElement newemailId;
	
	@FindBy(id = "message-email-confirms") 
	private WebElement confirmemailId;
	
	@FindBy(css = "a.goToInbox.btn.btn--primary.message-btn")
	private WebElement goToInboxButton;
	
	@FindBy(id = "IPerceptionsEmbed")
	public WebElement iPerceptionframe;
	
	@FindBy(id = "closeButton")
	public WebElement iPerceptionclosebtn;
	
	@FindBy(xpath = "//*[contains(@class,'click-to-call col-md-4')]/div[not (contains(@class,'ng-hide'))][1]//a[@class='btn btn--primary call-btn']")
	private WebElement requestACall;
	
	@FindBy(id = "call-submit")
	private WebElement requestCall;
	
	@FindBy(xpath = "//*[@id='message-submit']//*[contains(text(),'CONTINUE')]")
	private WebElement emailUsContinueBtn;
	
	
	@FindBy(xpath = "//div[@id='messageModal']//span[contains(@class,'btn--primary')][text()='CONTINUE']")
	private WebElement goToInboxCtnBtn;
	
	
	@FindBy(id = "message-send")
	private WebElement sendMessageBtn;
	
	@FindBy(id = "//*[contains(@class,'modal-content')]")
	private WebElement modalPopup;
	
	@FindBy(id=  "confirmationWidget")
	private WebElement emailConfirmationWidget;
	
	@FindBy(id = "call-cancel")
	private WebElement requestCall_Cancel;
	
	@FindBy(id="call-question-about")
	private WebElement callQuestionAbout;
	
	@FindBy(xpath="//*[@id='call-number']")
	private WebElement requestACallPhoneNumber;
	
	@FindBy(xpath="//div[contains(@class,'click-to-call')]/div[not (contains(@class,'ng-hide'))][1]//div[@class='message-block-body']//p[4]")
	private WebElement reqACallPhoneNumber;
	
	@FindBy(xpath = "//*[contains(@class,'click-to-call col-md-4')]/div[not (contains(@class,'ng-hide'))][1]//div[@class='message-block--full-width success margin-none']")
	private WebElement reqConfirmation;
	
	@FindBy(xpath="//h1[contains(text(),'Contact Us')]")
	private WebElement heading;
	
	@FindBy(xpath = "//html//body//div//div//div[1]//div[2]//div//div//header//div//div[1]//nav")
	private WebElement headingContactUs;

	@FindBy(xpath="//div[@class='deskHeaderContainer']")
	private WebElement topHeaderContactUs;

	@FindBy(xpath=".//*[@id='IPEinvL']/map/area[2]")
    private WebElement iPerceptionPopUp;

	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//a[@class='btn btn--primary question-btn']")
	private WebElement fillOutFormButton;	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//a[@id='question-btn']")
	private WebElement memberAuth_fillOutFormButton;
	
	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//textarea[@id='question-message']")
	private WebElement questionMessage;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//button[@name='question-submit']")
	private WebElement questionSubmit;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//button[@id='question-submit']")
	private WebElement memberauth_questionSubmit;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//a[@id='add-alt-email']")
	private WebElement addAlternativeEmail;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']")
	private WebElement alternativeEmailAddress;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email-confirm']")
	private WebElement confirmEmailAddress;
	
	@FindBy(xpath="//*[@id='add-alt-phone']")
	private WebElement addAlternativePhneNumberLink;
	
	@FindBy(xpath="//*[@id='question-alt-phone']")	
	private WebElement alternativePhneNumber;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-phone-confirm']")	
	private WebElement confirmAlternativePhneNumber;

	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//select[@id='question-about']")
	private WebElement questionAboutDropDown;

	

	@FindBy(xpath="//input[@id='question-alt-email']/following-sibling::span[not (contains(@class,'hide'))]")
	private WebElement alternativemessageEmailError;
	
	
	@FindBy(xpath="//input[@id='question-alt-email-confirm']/following-sibling::span[not (contains(@class,'hide'))]")
	private WebElement confirmMsgEmailError;
	
	@FindBy(xpath="//*[@id='alt-phone-wrapper']/div[1]/div/span[2]")
	private WebElement invalidPhneErrorMsg;
	
	@FindBy(xpath="//*[@id='alt-phone-wrapper']/div[1]/div/span[1]")
	private WebElement invalidPhneErrorMsg1;
	
	@FindBy(xpath="//input[@id='question-alt-phone-confirm']/following-sibling::span[not (contains(@class,'hide'))]")
	private WebElement confirmPhneErrorMsg;
	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//div[contains(@class,'success') and (not (contains(@class,'ng-hide')))]/div[@class='message-block-header']//p")
	private WebElement requestReceivedMessageHeader;
	
	@FindBy(xpath="//div[contains(@class,'click-to-call')]/div[not (contains(@class,'ng-hide'))][1]//div[@class='message-block--full-width success margin-none']/div[1]//b")
	private WebElement requestACallSuccessMessageHeader;
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//div[contains(@class,'success') and (not (contains(@class,'ng-hide')))]/div[@class='message-block-body']//p[2]")
	private WebElement thankYouMessage;
	
	@FindBy(css="h2.plan.margin-large>span")
	private WebElement pdpHeader;
	
	@FindBy(css="div>div.alert-message")
	private WebElement memberAuthMessage;	
	
	@FindBy(xpath="//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))]//div[contains(@class,'message-block-body')][1]//h3")
	private WebElement memberAuthNotAuthorizedToSendUsQuestionMessage;
	
	@FindBy(css="div#confrmmatchheightonce a.btn.btn--primary.question-btn")
	private WebElement btn_EmailForm;
	
	@FindBy(id="question-about-ship")
	private WebElement questionAboutDropdown_EmailForm;
	
	@FindBy(id="question-message-ship")
	private WebElement questionMessage_EmailForm;
	
	@FindBy(id="question-member-number")
	private WebElement aarpMemberShipNumber;
	
	@FindBy(id="question-first-name")
	private WebElement firstName_EmailForm;
	
	@FindBy(id="question-last-name")
	private WebElement lastName_EmailForm;
	
	@FindBy(id="question-email")
	private WebElement email_EmailForm;
	
	@FindBy(xpath="(//a[@ng-href='tel:1-800-721-0627']")
	private WebElement connectorModelTFN;
	
	@FindBy(id="question-email-confirm")
	private WebElement confirmEmail_EmailForm;
	
	@FindBy(id="date-mm")
	private WebElement dateMM_EmailForm;
	
	@FindBy(id="date-dd")
	private WebElement dateDD_EmailForm;
	
	@FindBy(id="date-yyyy")
	private WebElement dateyyyy_EmailForm;
	
	@FindBy(css=".question-submit>span")
	private WebElement btnSubmit_EmailForm;
	
	@FindBy(css="div#confrmmatchheightonce div.message-block-body p:nth-child(2)")
	private WebElement successMessage_EmailForm;
	
	@FindBy(css="div#confrmmatchheightonce div.message-block-header p>b")
	private WebElement successHeader_EmailForm;
	
	@FindBy(xpath="//div[contains(@class,'contactuscomponent')]/section[not(contains(@class,'ng-hide'))][2]//a[contains(text(),'View Questions')]")
	private WebElement commonQuestionViewQuestionsBtn;
	
	public JSONObject contactUsJson;
	
	private JSONObject secureemailwidgetDataJson;
	
	private PageData secureemailwidgetData;
	
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		try {
			PageFactory.initElements(driver, this);
			checkModelPopup(driver);
			
			if ((MRScenario.environment).toLowerCase().contains("offline"))
				CommonUtility.waitForPageLoadNew(driver, topHeaderContactUs, CommonConstants.TIMEOUT_30);
			
			openAndValidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ContactUsPage(WebDriver driver, String memberType) {
		super(driver);
		try {
			PageFactory.initElements(driver, this);
			checkModelPopup(driver);
			
			if ((MRScenario.environment).toLowerCase().contains("offline"))
				CommonUtility.waitForPageLoadNew(driver, topHeaderContactUs, CommonConstants.TIMEOUT_30);
			
			openAndValidate(memberType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void openAndValidate() {
		validateNew(heading);
	}

	public void openAndValidate(String memberType) {
		if (!memberType.contains("PreEff")) 
		validateNew(heading);
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject contactUsExpectedJson = expectedDataMap
				.get(CommonConstants.CONTACT_US);
		contactUsExpectedJson = CommonUtility.mergeJson(
				contactUsExpectedJson, globalExpectedJson);
		return contactUsExpectedJson;
	}

	/**
	 * Validate Texas ERS plan name
	 */
	public void validatePlanName(){
    	String planName = LoginCommonConstants.PLAN_NAME;
    	System.out.println(planName);
    	List<WebElement> planWebElement = driver.findElements(By.xpath("//*[text()='"+LoginCommonConstants.PLAN_NAME+"']"));
    	for(int i=0; i<planWebElement.size();i++){
    		if(planWebElement.get(i).getText().contains("HealthSelect Medicare Rx ")){
    			System.out.println("----------Failed due to presence of HealthSelect Medicare Rx ------------");
    			Assert.fail();
    		}
    		else if(planWebElement.get(i).getText().equalsIgnoreCase(LoginCommonConstants.PLAN_NAME)){
    			System.out.println("----------Plan name displayed as expected="+planName);
    		} else{
	    			System.out.println("----------Failed because Plan NAme not present");
	    			Assert.fail();
	    		} 	  		 
    	}
 }
	/**
	 * Validate the success message 
	 */
	public void validateThankYouMessage(String expectedMessage){
		
		Assert.assertEquals("Request Confirmed", requestReceivedMessageHeader.getText().trim());
		Assert.assertEquals(expectedMessage, thankYouMessage.getText().trim());
		
	}
	
	/**
	 * DIANE
	 * Validate the static TFN
	 *
	 **/
	public void validateTFN(String expectedTFN){
		
		//ORIG
		//Assert.assertEquals(expectedTFN, staticTFN.getText().trim());
				
		//object
		//Assert.assertEquals(expectedTFN, staticTFN.getText().trim());
		
		//object[]
		//Assert.assertEquals(expectedTFN, staticTFN.getText().trim());
			    	
			
    	if (staticTFN.getText().contains(expectedTFN))
    	{
    		System.out.println("Expected Static TFN is displayed" + staticTFN.getText());}
    	
    	else 
    		Assert.fail("Expected TFN is not displayed");
    		
    	      					
	}
	
	/**
	 * Validate the success message of Email Form
	 */
	public void validateEmailUsSuccessMessage(String expectedMessage){
		
		Assert.assertEquals("Thank you. We received your request.", successHeader_EmailForm.getText().trim());
		Assert.assertEquals(expectedMessage, successMessage_EmailForm.getText().trim());
		
	}
	
	/**
	 * Validate the success message of Request a call widget
	 */
	public void validateRequestACallSuccessMessage(String expectedMessage,String phoneNumber){
		
		Assert.assertEquals("Your request has been received", requestACallSuccessMessageHeader.getText().trim());
		//Assert.assertEquals(expectedMessage, reqConfirmationMessage.getText().trim());
		Assert.assertEquals(phoneNumber,reqACallPhoneNumber.getText().trim());
		
	}
	
	/**
	 * Validate the Filed validation error messages in Email a question
	 */
	public void validateFiledValidationErrorMessages(DataTable givenAttributes){
		
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
//		String inavlidPhoneErrorMessage = memberAttributesMap.get("inavlidPhoneErrorMessage");
//		String inavlidAConfirmPhoneErrorMessage = memberAttributesMap.get("inavlidAConfirmPhoneErrorMessage");
//		String inavlidEmailErrorMessage = memberAttributesMap.get("inavlidEmailErrorMessage");
//		String inavlidAConfirmEmailErrorMessage = memberAttributesMap.get("inavlidAConfirmEmailErrorMessage ");
		String inavlidPhoneErrorMessage = "Enter phone number like this: 111-111-1111.";
		String inavlidAConfirmPhoneErrorMessage = "Your confirmation alternative phone number and alternative phone number do not match.";
		String inavlidEmailErrorMessage = "Enter your email address like this: yourname@emailprovider.com.";
		String inavlidAConfirmEmailErrorMessage = "Your email confirmation and email address do not match.";
		String errorphonemessage = invalidPhneErrorMsg.getText().trim();
		String errorphonemessage1 = invalidPhneErrorMsg1.getText().trim();
		
		// error massage switches xpath according to data or emptyness in phone number input box
		if(errorphonemessage.isEmpty()){
			System.out.println("error massage didnt show 1st xpath as all required fiel is empty");
			Assert.assertEquals(inavlidPhoneErrorMessage, errorphonemessage1);
		} else{
		Assert.assertEquals(inavlidPhoneErrorMessage, errorphonemessage);
		}
		Assert.assertEquals(inavlidAConfirmPhoneErrorMessage, confirmPhneErrorMsg.getText().trim());
		Assert.assertEquals(inavlidEmailErrorMessage, alternativemessageEmailError.getText().trim());
		Assert.assertEquals(inavlidAConfirmEmailErrorMessage, confirmMsgEmailError.getText().trim());
	}
	
	/**
	 * this method is used to validate the request to call widget
	 */
	public void validates_clickToCall_widget()
	{
		Assert.assertTrue("Request a call widget is displayed", requestACall.isDisplayed());
	}
	
	
	/**
	 * this method is used to click on Request to call widget and validate for the confirmation message
	 */
	public void reqACall(DataTable givenAttributes)
	{	
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String phoneNumber = memberAttributesMap.get("Phone Number");
		try {
			requestACall.click();
			
			new Select(callQuestionAbout);
			requestACallPhoneNumber.sendKeys(phoneNumber);
			requestCall.click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonUtility.waitForPageLoadNew(driver, reqConfirmation, 40);
		
	}
	
	/**
	 * this method is used to click on Request to call widget and validate the cancel link
	 */
	public void reqACall_Cancel(DataTable givenAttributes)
	{	
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String phoneNumber = memberAttributesMap.get("Phone Number");
		try {
			requestACall.click();
			Thread.sleep(5000);
			new Select(callQuestionAbout);
			Thread.sleep(5000);
			requestACallPhoneNumber.sendKeys(phoneNumber);
			requestCall_Cancel.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		waitforElement(requestACall);
	}

	public JSONObject getsecurewidget() {
		String fileName = CommonConstants.AARPM_SECURE_EMAIL_DATA;
		secureemailwidgetData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : secureemailwidgetData.getExpectedData().keySet()) {
			WebElement element = findElement(secureemailwidgetData.getExpectedData()
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
		secureemailwidgetDataJson = jsonObject;

		return secureemailwidgetDataJson;
	}
	
	/**
	 * this method is used to validate PDP header text
	 */
	public void PdpPageDisplay(){
		if(pdpHeader.isDisplayed()){
			System.out.println("PDP page displayed");
		}
	}
	/**
	 * this method is used to get discalimer text of member auth
	 */
	public String getDisclaimerTextForMemberAuth(){
		return memberAuthMessage.getText().trim();
	}

	/**
	 * this method is used to get the error message for member auth send us question functionality
	 */
	public String getMemberAuthNotAuthorizedToSendUsQuestionMessage(){
		try {
			Thread.sleep(35000);
			memberAuth_fillOutFormButton.click();
			Thread.sleep(3000);
			memberauth_questionSubmit.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return memberAuthNotAuthorizedToSendUsQuestionMessage.getText().trim();
	}
	
	/**
	 * this method is used to get the error message for member auth request call functionality
	 */
	public String getMemberAuthNotAuthorizedToRequestACallMessage(){
		try {
			Thread.sleep(15000);
			memberAuth_fillOutFormButton.click();
			Thread.sleep(3000);
			memberauth_questionSubmit.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return memberAuthNotAuthorizedToSendUsQuestionMessage.getText().trim();
	}
	
	
	/**
	 * This method validates the Email a Question widget for Group (CALPERS\GEORGIA-SHBP\TEXAS ERS) members 
	 * 
	 * @param givenAttributes
	 */
	public void validateEmailAQuestionWidget(DataTable givenAttributes){
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String enquiryType = memberAttributesMap.get("Enquiry Type");
		String alternativeEmailId = memberAttributesMap.get("Alternative Email");
		String confirmAlternativeEmailId = memberAttributesMap.get("ConfirmAlternative Email");
		String alternativePhoneNumber = memberAttributesMap.get("AlternativePhone Number");
		String confirmAlternativePhoneNumber = memberAttributesMap.get("ConfirmAlternativePhone Number");
		try {
			fillOutFormButton.click();
			System.out.println("fill out form clicked");
			Thread.sleep(5000);
			Select dropdown = new Select(questionAboutDropDown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByValue("Pharmacy (Rx) Benefits");
			questionMessage.sendKeys(enquiryType);
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys(alternativeEmailId);
			confirmEmailAddress.sendKeys(confirmAlternativeEmailId);
			addAlternativePhneNumberLink.click();
			alternativePhneNumber.sendKeys(alternativePhoneNumber);
			confirmAlternativePhneNumber.sendKeys(confirmAlternativePhoneNumber);
			System.out.println("up to confirmed phone added");
			questionSubmit.click();
			Thread.sleep(5000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * This method fills invalid details in the Email a Question widget for Group (CALPERS\GEORGIA-SHBP\TEXAS ERS) members and validates error messages 
	 * 
	 * @param givenAttributes
	 */
	public void fillInvalidDetailsInEmailAQuestionWidget(DataTable givenAttributes){
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String enquiryType = memberAttributesMap.get("Enquiry Type");
		String alternativeEmailId = memberAttributesMap.get("Alternative Email");
		String confirmAlternativeEmailId = memberAttributesMap.get("ConfirmAlternative Email");
		String alternativePhoneNumber = memberAttributesMap.get("AlternativePhone Number");
		String confirmAlternativePhoneNumber = memberAttributesMap.get("ConfirmAlternativePhone Number");
		try {
			CommonUtility.waitForPageLoad(driver, fillOutFormButton, 30);
			fillOutFormButton.click();
			Thread.sleep(5000);
			Select dropdown = new Select(questionAboutDropDown);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByValue("Pharmacy (Rx) Benefits");
			questionMessage.sendKeys(enquiryType);
			addAlternativeEmail.click();
			alternativeEmailAddress.sendKeys(alternativeEmailId);
			confirmEmailAddress.sendKeys(confirmAlternativeEmailId);
			System.out.println("confirmed email address were typed!!!!!");
			Thread.sleep(5000);
			confirmEmailAddress.click();
			//jsClick(driver.findElement(By.xpath("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/preceding::p[1]")));
			//driver.findElement(By.xpath("//div[contains(@class,'request-email')]/div[not (contains(@class,'ng-hide'))][1]//input[@id='question-alt-email']/preceding::p[1]")).click();
			addAlternativePhneNumberLink.click();
			addAlternativePhneNumberLink.click();
			//jsClick(addAlternativePhneNumberLink);
			Thread.sleep(5000);
			//alternativePhneNumber.sendKeys("361361");
			alternativePhneNumber.sendKeys(alternativePhoneNumber);
			System.out.println("alt phone number typed!!!!!!");
			//confirmAlternativePhneNumber.sendKeys("362222");
			confirmAlternativePhneNumber.sendKeys(confirmAlternativePhoneNumber);
			Thread.sleep(3000);
			questionSubmit.click();
			Thread.sleep(10000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * This method is used to validate secure email us widget section
	 */
	public void validateSecureEmailUsWidgetSection(DataTable givenAttributes) {
		
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String newEmailId = memberAttributesMap.get("New Email");
		String newConfirmEmailId = memberAttributesMap.get("NewConfirm Email");
		// the following 3 lines are added as a go around the contact us link from home page, as it was not working.
		
		
		
		try {
			Thread.sleep(8000);
			
		if(validate(EmailForm)){
			System.out.println("Get Started Button not visible, So using email Form Link!!!");
			EmailForm.click();
			Thread.sleep(2000);
			waitforElement(cancelLink);
			cancelLink1.click();
			Thread.sleep(2000);}
		else if(validate(goToInboxButton)){	
			validateGoToInbox();
			}
		else{		
			getStartedButton.click();
			waitforElement(useDifferentEmailRadioButton);
			useDifferentEmailRadioButton.click();
			newemailId.sendKeys(newEmailId);
			confirmemailId.sendKeys(newConfirmEmailId);
			System.out.println(cancelLink);
			System.out.println("found cancel link");
			emailUsContinueBtn.click();
			validateNew(emailConfirmationWidget);
			validateNew(sendMessageBtn);
			
				
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * This method validates the Email Form widget for SHIP members 
	 * 
	 * @param givenAttributes
	 */
	public void validateEmailFormWidget(DataTable givenAttributes){
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String enquiryType = memberAttributesMap.get("Enquiry Type");
		
		String message = memberAttributesMap.get("Message");
		String aarpMembershipNumber = memberAttributesMap.get("AARPMembership Number");
		String firstName = memberAttributesMap.get("First Name");
		String lastName = memberAttributesMap.get("Last Name");
		String emailAddress = memberAttributesMap.get("Email Address");
		String confirmEmailAddress = memberAttributesMap.get("ConfirmEmail Address");
		String date = memberAttributesMap.get("Date");
		String month = memberAttributesMap.get("Month");
		String year = memberAttributesMap.get("Year");
		
		try {
			btn_EmailForm.click();
			Thread.sleep(5000);
			Select dropdown = new Select(questionAboutDropdown_EmailForm);
			dropdown.getFirstSelectedOption().click();
			dropdown.selectByVisibleText(enquiryType);
			questionMessage_EmailForm.sendKeys(message);
			aarpMemberShipNumber.sendKeys(aarpMembershipNumber);
			firstName_EmailForm.sendKeys(firstName);
			lastName_EmailForm.sendKeys(lastName);
			email_EmailForm.sendKeys(emailAddress);
			confirmEmail_EmailForm.sendKeys(confirmEmailAddress);
			dateDD_EmailForm.sendKeys(date);
			dateMM_EmailForm.sendKeys(month);
			dateyyyy_EmailForm.sendKeys(year);
			confirmEmail_EmailForm.click();
			Thread.sleep(2000);
			btnSubmit_EmailForm.click();
			Thread.sleep(8000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * Validate the go to inbox button for a member who has already opted out for secure email
	 */
	public void validateGoToInbox(){
		try {
			waitforElement(goToInboxButton);
			Assert.assertTrue(validate(goToInboxButton));
			goToInboxButton.click();
			Assert.assertTrue(validateNew(goToInboxCtnBtn));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Validate the widgets which should not present for the terminated members
	 */
	public void validateWidgetsForTerminatedMembers(){
		/*
		System.out.println("ready to assert check");
		getStartedButton.click();
		driver.navigate().back();
		System.out.println("get started button recognized");
		Assert.assertTrue(!validate(getStartedButton));
		//Assert.assertTrue(!validate(fillOutFormButton)); // doesn't exist for these kind of users
		Assert.assertTrue(!validate(requestCall));
		//Assert.assertTrue(!validate(email_EmailForm)); // doesn't exist for these kind of users
		 */
		Assert.assertFalse(validate(getStartedButton));
		Assert.assertFalse(validate(fillOutFormButton));
		Assert.assertFalse(validate(requestCall));
		Assert.assertFalse(validate(getStartedButton));
		Assert.assertFalse(validate(email_EmailForm));
	}
	
	public void feebackpopupClose() throws InterruptedException
	{ //waitForloader(driver,overlay, 20);
		Thread.sleep(20000);
		if (validate(iPerceptionframe)) {

			switchToNewIframe(iPerceptionframe);
			iPerceptionclosebtn.click();
			driver.switchTo().defaultContent();
			//iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
	}

	public void validateConnectroModelTFNNumber() {
		
		String tfnNumber = connectorModelTFN.getText();
		if(tfnNumber.contains("1-800-721-0627"))
		{
			System.out.println("Connector Model TFN dsiplayed    >" +connectorModelTFN.isDisplayed() );
		}else
		{
			System.err.println("Connector Model TFN dsiplayed    >" +connectorModelTFN.isDisplayed() );
			
		}
	}

	public void verifyCorrectTechSupportNumberForPreEffectiveMembers(String technicalPhNo) {
		
	    System.out.println("Now checking for Tech Support Number for Pre-effective members on claims page");
	    System.out.println("The Tech Support phone number displayed on screen is "+preEffectiveTechSupportNumber.getText());
	    boolean TFNvalidation = true;
	    if(preEffectiveTechSupportNumber.getText().contains(technicalPhNo)){
	    	TFNvalidation = true;
	    }
	    else
	    	TFNvalidation=false;
	    Assert.assertTrue("Extected TFN is not dispalyed", TFNvalidation);
		System.out.println("Assert for correct Tech Suppport Phone Number on claims page was passed");
		
	}

    /**
	 * @author sdwaraka
	 * Added for May2 2019 Release
	 * Added to validate Secure email, send a message and Secure Message page as part of validation for F282564
    */
	
	//Secure Message access
	@FindBy(xpath = "//a[contains(@class, 'goToInbox ')]")
	private WebElement sendAmessageButton;
	
	//Email Us modal
	@FindBy(xpath = "//div[@id='messageModal']//div[contains(@class, 'modal-content')]")
	private WebElement EmailUsModal;
	
/*	@FindBy(xpath = "//*[contains(@class, 'btn') and contains(text(), 'CONTINUE')]")
	private WebElement EmailUsModal_ContinueBtn;*/
	
	@FindBy(xpath = "//div[@id='messageModal']//button/span[text()='CONTINUE']")
	private WebElement EmailUsModalbtnContinue;
	
	@FindBy(xpath = "//a[@id='btn-compose']")
	private WebElement messengerComposeBtn;
	
	@FindBy(id = "signed-in")
	private WebElement messengerSignIn;
	
	@FindBy(xpath = "//div[@id='list-folders']//a[contains(text(),'Inbox')]")
	private WebElement messengerInbox;
    
	
	//Click on Send a Message button on Secure Message widget on Contact Us Page
    public void clickOnSendMessage_SecureEmail() {
   	 if(validate(sendAmessageButton)){
   		 sendAmessageButton.click();
   		 System.out.println("Send A Message button is clicked");  		 
   	 }
   	 else{
   		 Assert.assertTrue("Send A message Button not displayed", false);
   	 }
		/*try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
   	 	waitforElementVisibilityInTime(EmailUsModalbtnContinue, 30);
		if(validate(EmailUsModal) && validate(EmailUsModalbtnContinue)){
	   		 System.out.println("Email Us Moal and COntinue Button are displayed");  		 
	   	 }
	   	 else{
	   		 Assert.assertTrue("Email Us Moal and COntinue Button are not displayed", false);
	   	 }
	}
    
    
	/**
     * Validate the go to inbox button for a member who has already opted out for secure email and navigate to SSO inbox
     */
     public void validateSSOInbox(){
            try {
                   validateNew(EmailUsModalbtnContinue);
                   if (!((MRScenario.environment).toLowerCase().contains("team"))) {
                   switchToNewTabNew(EmailUsModalbtnContinue);
                   CommonUtility.checkPageIsReadyNew(driver);
                   CommonUtility.waitForPageLoadNew(driver, messengerComposeBtn, 60);
                   Assert.assertTrue(driver.getTitle().contains("Messenger"));                  
                   validateNew(messengerInbox);
                   }
                   else{
                	   System.out.println("Skipping Go To Inbox functionslity in Team environment");
                   }
            } catch (Exception e) {
                   e.printStackTrace();
            }
     }
     
     public void navigateToCommonQuestionsPg() {
    	 Assert.assertTrue("PROBLEM - unable to locate the 'View Questions' button on the Contact Us page", validate(commonQuestionViewQuestionsBtn));
    	 commonQuestionViewQuestionsBtn.click();
    	 CommonUtility.checkPageIsReady(driver);
     }


     
}
