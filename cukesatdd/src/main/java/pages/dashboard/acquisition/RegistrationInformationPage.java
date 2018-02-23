package pages.dashboard.acquisition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import atdd.framework.UhcDriver;

/**
 * @author akuma103
 * Registration page for redesign
 */
public class RegistrationInformationPage extends UhcDriver {

	/**
	 * Registration page objects
	 * 
	 */
	/** The Personal Information Text. */
	@FindBy(id = "step1Text")
	private WebElement personalInfoText;

	/** The Plan Information Text. */
	@FindBy(id = "step2Text")
	private WebElement planInfoText;

	/** The Create Account Text. */
	@FindBy(id = "step3Text")
	private WebElement createAccountText;

	/**
	 * Personal information Section
	 */

	/** The member id field. */
	@FindBy(id = "member-id")
	private WebElement memberid;

	/** The month field. */
	@FindBy(id = "month-dropdown")
	private WebElement monthToEnter;
	
	@FindBy(id = "date-mm-textfield")
	private WebElement monthToEnterText;
	
	/**@FindBy(id = "secb-result-fpyl-02")
	private WebElement monthresults;*/
	
	
	/** The date field. */
	@FindBy(id = "date-dropdown")
	private WebElement dayToEnter;
	
	@FindBy(id = "date-dd-textfield")
	private WebElement dateToEnterText;
		
	/**@FindBy(id = "select2-date-dd-results")
	private WebElement dateresults;*/

	/** The year field. */
	
	/** The date field. */
	@FindBy(id = "year-dropdown")
	private WebElement yearToEnter;
	
	@FindBy(id = "date-yyyy-textfield")
	private WebElement yearToEnterText;
	
	/*@FindBy(id = "select2-date-yyyy-results")
	private WebElement yearresults;*/

	/** The cancel button. */
	@FindBy(id= "cancelButton")
	private WebElement cancelButton;

	/** The next button. */
	@FindBy(id = "continue-btn")
	private WebElement nextButton;

	/** The direct URL for registration redesign page. */
	//private static String PAGE_URL = MRConstants.REDESIGN_REGISTRATION_URL;

	/**
	 * Step one error message
	 */
	
	/** Member Id field is left blank */
	@FindBy(id = "errorMemberIdBlank")
	private WebElement memberIdBlank;

	/** DOB field is left blank */
	@FindBy(id = "errorDobBlank")
	private WebElement dobBlank;

	/** Age is less then 13 year error message */
	@FindBy(id = "errorAgeLessThan13")
	private WebElement ageLessError;

	/** SNP plan not able to register error message */
	@FindBy(id = "errorSnpMember")
	private WebElement snpError;
	
	/**
	 * Additional personal Information section
	 */

	/** The Personal Info heading. */
	@FindBy(id = "additionalInfo")
	private WebElement personalInfoHeader;

	/** The Zip Code field. */
	@FindBy(id = "zip")
	private WebElement zipCode;

	/** The First Name field. */
	@FindBy(id = "firstname")
	private WebElement firstName;

	/** The Last Name field. */
	@FindBy(id = "lastname")
	private WebElement lastName;

	/** The medicare ID field. */
	@FindBy(id = "medicareID")
	private WebElement medicareID;

	/** The IncorrectINfo Error on Additional Info page */
	@FindBy(id = "invalidData-error")
	private WebElement incorrectinfoerror;

	/** The Completion Error on Additional Info page */
	@FindBy(id = "orGroup-error")
	private WebElement fieldcompletionerror;
	/**
	 * Error message section Values
	 */

	/** The already existing member account error message. */
	@FindBy(id = "existing_member_error")
	private WebElement existingMember;

	/** The inactive or terminated error message. */
	@FindBy(id = "inactive_terminated_Plan_error")
	private WebElement inactiveTerminatedMember;

	/** The future date effective error message. */
	@FindBy(xpath = ".//*[@id='future_Effective_Plan_error']/div[1]/div/div/div[1]/h3")
	private WebElement futureEffectivePlanMember;

	/** The member not found error message. */
	@FindBy(id = "member_Info_Not_Found_error")
	private WebElement memberNotFound;

	/** The Start over link on existing member error page. */
	@FindBy(id = "startOver_existing_member_error")
	private WebElement existingStartOverLink;

	/** The Start over link on future Effective Plan error page. */
	@FindBy(id = "startOver_future_Effective_Plan_error")
	private WebElement futureStartOverLink;

	/** The Start over link on inactive terminated Plan error page. */
	@FindBy(id = "startOver_inactive_terminated_Plan_error")
	private WebElement inactiveStartOverLink;

	/** The Start over link on member Info Not Found error page. */
	@FindBy(id = "startOver_member_Info_Not_Found_error")
	private WebElement notFoundStartOverLink;

	/**
	 * existing member error page links
	 */

	/** The username and password help link on existing member page. */
	@FindBy(className = "lowercase")
	private WebElement usernameAndPasswordHelpLink;

	/** The sign in with your existing credentials link on existing member page. */
	@FindBy(linkText = "SIGN IN")
	private WebElement signInWithYourExistingCredentialsLink;

	/**
	 * Plan information Page
	 */

	/** The pre populated Plan Name. */
	@FindBy(id = "memberPlanName")
	private WebElement planName;

	/** The pre populated member ID. */
	@FindBy(id = "memberNumber")
	private WebElement mNumber;

	/** The pre populated member name. */
	@FindBy(id = "memberName")
	private WebElement mName;

	/** The pre populated member Date of Birth. */
	@FindBy(id = "memberDob")
	private WebElement mDOB;

	/** The previous button. */
	@FindBy(id = "step2-previous-btn")
	private WebElement previousButton;

	/** The Additional Plan Information Header. */
	@FindBy(id = "addPlanHeading")
	private WebElement additionalInfoHeader;

	/** The PFFS member Id error message */
	@FindBy(id = "errorPffsMember")
	private WebElement pffsErrorMessage;

	/** Multiple Plans **/

	/** The additional Plan member ID */
	@FindBy(id = "multiple-member-id")
	private WebElement additionalPlanMemberID;

	/** The add a plan button */
	@FindBy(id = "add-to-plan")
	private WebElement addPlanButton;

	/**
	 * Add a Plan pop up objects
	 * 
	 */

	/** The add a plan pop up header */
	@FindBy(id = "addPlanModalLabel")
	private WebElement addPlanPopUpHeader;

	/** The cancel link button on add a plan pop up */
	@FindBy(id = "modalCancelBtn")
	private WebElement cancelLinkPopup;

	/** The confirm button on add a plan pop up */
	@FindBy(id = "add-plan-confirm")
	private WebElement addPlanConfirmButton;

	/** The modal values to be validated **/
	@FindBy(id = "modalMemberIdValue")
	private WebElement modalMemberIdValue;

	@FindBy(id = "modalMemberNameValue")
	private WebElement modalMemberNameValue;

	@FindBy(id = "modalPlanNameValue")
	private WebElement modalPlanNameValue;

	@FindBy(id = "modalDateOfBirthValue")
	private WebElement modalDateOfBirthValue;

	/* checkbox status */

	@FindBy(id = "add-to-account2")
	private WebElement addtoaccount2;

	@FindBy(id = "add-to-account")
	private WebElement addtoaccount;

	/** The member id already registered error message */
	@FindBy(id = "planAlreadyRegisteredErrorMessage")
	private WebElement memberAlreadyRegisteredError;

	/** The future effective member Id error message */
	@FindBy(id = "planInFutureErrorMessage")
	private WebElement futureEffectiveError;

	/** The terminated member Id error message */
	@FindBy(id = "planTerminatedErrorMessage")
	private WebElement terminatedErrorMessage;

	/** The invalid member Id error message */
	@FindBy(id = "invalidMemberErrorMessage")
	private WebElement invalidMemberError;

	/** The same member Id error message */
	@FindBy(id = "addingSamePlanErrorMessage")
	private WebElement samePlanError;

	/** create Account User Name */
	@FindBy(id = "username")
	private WebElement createAccountUserName;

	/** create Account Password */
	@FindBy(id = "password")
	private WebElement createAccountPassword;

	/** create Account Confirm Password */
	@FindBy(id = "password-confirm")
	private WebElement createAccountConfirmPassword;

	/** create Account Email */
	@FindBy(id = "email")
	private WebElement createAccountEmail;

	/** create Account Confirm Email */
	@FindBy(id = "email-confirm")
	private WebElement createAccountConfirmEmail;

	/** create Account Confirm Registration */
	@FindBy(id = "continue-btn")
	private WebElement createAccountConfirmRegistration;
	
	/** create Account Confirm Registration 
	@FindBy(id = "accountConfirmation")
	private WebElement accountConfirmation;*/
	
	/*create account error messages*/
        @FindBy(id = "errorBlankUsername")
        private WebElement blankusernamemessage;
	@FindBy(id = "errorInvalidUsername")
	private WebElement incorrectusernamemessage;
	
	@FindBy(id = "errorBlankPassword")
	private WebElement blankpasswordmessage;
	@FindBy(id = "errorInvalidPassword")
	private WebElement incorrectpasswordmessage;
	
	@FindBy(id = "errorMismatchPassword")
	private WebElement confirmpasswordmessage;
	
	@FindBy(id = "errorInvalidEmail")
	private WebElement incorrectemailmessage;
	
	@FindBy(id = "errorMismatchEmail")
	private WebElement incorrectconfirmemailmessage;
	
	/**
	 * Account Confirmation Page Objects
	 * 
	 */
	
	/** The account Confirmation Heading Text. */
	@FindBy(id = "accountConfirmation")
	private WebElement accountConfirmationHeading;
	
	/** The account Confirmation  Text. */
	@FindBy(id = "account-confirmation-text")
	private WebElement accountConfirmationText;
		
	/** First Name  from backend. */
	@FindBy(id = "firstNameText")
	private WebElement accConfFirstName;
	
	/** Last Name  from backend. */
	@FindBy(id = "lastNameText")
	private WebElement accConfLastName;	
	
	/** Date of birth. */
	@FindBy(id = "DateOfBirthText")
	private WebElement dateOfBirthText;
	
	/** userName field. */
	@FindBy(id = "userNameText")
	private WebElement userNameText;
	
	/** email address field. */
	@FindBy(id = "emailText")
	private WebElement emailIdText;	
	
	
	/** edit your profile link. */
	@FindBy(id = "editYourProfileLink")
	private WebElement editYourProfileLink;
	
	/** print link. */
	@FindBy(id = "printLink")
	private WebElement printLink;
	
	/** go to my account home button */
	@FindBy(id = "goToHomeId")
	private WebElement goToMyAccountHomeButton;
	

	public RegistrationInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	/**
	 * Functions to verify the page headings
	 */

	/**
	 *@toDo : the Personal Info text
	 */
	public WebElement getStepOneText() {
		return personalInfoText;
	}

	/**
	 *@toDo : the Plan Info text
	 */
	public WebElement getStepTwoText() {
		return planInfoText;
	}

	/**
	 *@toDo : the Create Account Text
	 */
	public WebElement getStepThreeText() {
		return createAccountText;
	}

	/**
	 * Personal Information page functions.
	 */

	/**
	 *@toDo : Enter member ID.
	 */
	public void enterMemberID(String memberID) {
		sendkeys(memberid, memberID);
	}

	/**
	 *@toDo : member ID
	 */
	public WebElement getMemberID() {
		return memberid;
	}
     
	/**
	 *@toDo : Enter month.
	 */
	public void enterMonth(String month) {
		sendkeys(monthToEnterText, month);
	}
	/**
	 *@toDo : the month to enter
	 */
	public WebElement getEnterMonth() {
		return monthToEnter;
	}
  
	/**
	 *@toDo : the month to enter
	 */
/*	public WebElement getEnterMonthText() {
		return monthToEnterText;
	}*/
	
	/**
	 *@toDo : select month
	 */
	public void pressEnterMonth()
	{
		monthToEnterText.sendKeys(Keys.ENTER);
		
	}

	 /* Enter day.*/
	
	/**
	 *@toDo : the day to enter
	 */
	public WebElement getEnterDay() {
		return dayToEnter;
	}
	 
	/**
	 *@toDo : Enter day
	 */
	public void enterDay(String day) {
		sendkeys(dateToEnterText, day);
	} 
	
	/**
	 *@toDo : select day
	 */
	public void pressEnterDay()
	{
		dateToEnterText.sendKeys(Keys.ENTER);
		
	}
  
	/*
	 * enter year
	 */
	
	/**
	 *@toDo : the year to enter
	 */
	public WebElement getEnterYear() {
		return yearToEnter;
	}
	
	/**
	 *@toDo : Enter year
	 */
	public void enterYear(String year) {
		sendkeys(yearToEnterText, year);
	} 

	/**
	 *@toDo : select year
	 */
	public void pressEnterYear()
	{
		yearToEnterText.sendKeys(Keys.ENTER);
		System.out.println(driver.getCurrentUrl());
	}
	/**
	 *@toDo : Click the continue button
	 */
	public void clickNext() {
		nextButton.click();
	}

	/**
	 *@toDo : Click the previous button
	 */
	public void clickPreviousButtuon() {
		previousButton.click();
	}

	/**
	 *@toDo : Click the cancel button
	 */
	public void clickCancel() {
		cancelButton.click();
	}

	/**
	 *@toDo : the medicare id to enter
	 */
	public WebElement getMedicareId() {
		return medicareID;
	}

	/**
	 *@toDo : the zipcode field to enter
	 */
	public WebElement getZipcode() {
		return zipCode;
	}

	/**
	 *@toDo : the first name field to enter
	 */
	public WebElement getFirstName() {
		return firstName;
	}

	/**
	 *@toDo : the last name field to enter
	 */
	public WebElement getLastName() {
		return lastName;
	}

	/**
	 *@toDo : the get Personal info header for additional info is displayed
	 */
	public WebElement getAdditionalInfoHeader() {
		return personalInfoHeader;
	}

	/**
	 *@toDo : Enter Zip Code additional Information.
	 */
	public void enterZip(String Zip) {
		sendkeys(zipCode, Zip);
	}

	/**
	 *@toDo : Enter first name additional Information.
	 */
	public void enterFirstName(String fName) {
		sendkeys(firstName, fName);
	}

	/**
	 *@toDo : Enter last name additional Information.
	 */
	public void enterLastName(String lNmae) {
		sendkeys(lastName, lNmae);
	}

	/**
	 * @toDo : Enter medicareID.
	 */
	public void enterMedicareID(String medicare_id) {
		sendkeys(medicareID, medicare_id);
	}

	/**
	 * Functions to verify step one error message
	 */
	
	/**
	 *@toDo : the member id blank error message
	 */
	public WebElement getMemberIdBlankError() {
		return memberIdBlank;
	}
	
	
	/**
	 *@toDo : the date of birth blank error message
	 */
	public WebElement getDobBlankError() {
		return dobBlank;
	}
	
	
	/**
	 *@toDo : the age is less than 13 years error message
	 */
	public WebElement getAgeLessError() {
		return ageLessError;
	}
	
	/**
	 *@toDo : the SNP member not allowed to register error message
	 */
	public WebElement getSnpMemberError() {
		return snpError;
	}
	
	/**
	 * Functions to verify the Error message pages
	 */

	/**
	 *@toDo : the member not found error message
	 */
	public WebElement getExistingMemberError() {
		return existingMember;
	}

	/**
	 *@toDo : the inactive or terminated member error message
	 */
	public WebElement getInactiveTerminatedError() {
		return inactiveTerminatedMember;
	}

	/**
	 *@toDo : the inactive or terminated member error message
	 */
	public WebElement getFutureEffectiveError() {
		return futureEffectivePlanMember;
	}

	/**
	 *@toDo : the member not found error message
	 */
	public WebElement getmemberNotFoundError() {
		return memberNotFound;
	}

	/**
	 * Functions to click link on Error message pages
	 */

	/**
	 * @toDo : Click the existing Start Over link
	 */
	public void clickExistingStartOver() {
		existingStartOverLink.click();
	}

	/**
	 * @toDo : Click the future Start Over link
	 * @throws InterruptedException 
	 */
	public void clickFutureStartOver()  {
		futureStartOverLink.click();
		
	}

	/**
	 * @toDo : Click the inactive Start Over link
	 */
	public void clickInactiveStartOver() {
		inactiveStartOverLink.click();
	}

	/**
	 * @toDo : Click the not found Start Over link
	 */
	public void clickNotFoundStartOver() {
		notFoundStartOverLink.click();
	}

	/**
	 * @toDo : Click the username and password link
	 */
	public void clickUserNameAndPasswordLink() {
		usernameAndPasswordHelpLink.click();
	}

	/**
	 * @toDo : Click the Sign in with existing link
	 */
	public void clickSignInWithExistingLink() {
		signInWithYourExistingCredentialsLink.click();
	}

	/**
	 * Functions for Plan information page validation
	 */

	/**
	 *@toDo : the plan name on plan info page
	 */
	public WebElement getPlanName() {
		return planName;
	}

	/**
	 *@toDo : the member id on plan info page
	 */
	public WebElement getMemberNumber() {
		return mNumber;
	}

	/**
	 *@toDo : the Member name on plan info page
	 */
	public WebElement getMemberName() {
		return mName;
	}

	/**
	 *@toDo : the DOB on plan info page
	 */
	public WebElement getPMemberDob() {
		return mDOB;
	}

	/**
	 *@toDo : the previous button on plan info page
	 */
	public WebElement getPreviousButton() {
		return previousButton;
	}

	/**
	 *@toDo : the next button on plan info page
	 */
	public WebElement getNextButton() {
		return nextButton;
	}

	/**
	 * Functions for Additional Info Error messages
	 */
	public WebElement getIncorrectInfoError() {
		return incorrectinfoerror;

	}

	public WebElement getfieldCompletionError() {
		return fieldcompletionerror;

	}

	/**
	 *@toDo : the additional plan information header plan info page
	 */
	public WebElement getAdditionalPlanInfoHeader() {
		return additionalInfoHeader;
	}

	@Override
	public void openAndValidate() {
		//start(PAGE_URL);
		validate(memberid);
/*		validate(monthToEnter);
		validate(dayToEnter);
		validate(yearToEnter);*/
		{
			validate(nextButton);

		}
	}
	/**
	 *@toDo : pffs error message
	 */
	public WebElement getpffsError() {
		return pffsErrorMessage;

	}

	/* Multiple Plan */

	/**
	 * Enter Secondary plan member ID.
	 */
	public void enterSecMemberID(String memberID) {
		sendkeys(additionalPlanMemberID, memberID);
	}

	/**
	 * click on add a plan button.
	 */
	public void clickAddplanButton() {
		addPlanButton.click();
	}

	/**
	 *@toDo : the Add Plan header
	 */
	public WebElement getPlanPopupHeader() {
		return addPlanPopUpHeader;
	}

	/**
	 *@toDo : the Confirm on Add Plan Popup
	 */
	public WebElement getConfirmonPopup() {
		return addPlanConfirmButton;
	}

	/**
	 *@toDo : the Cancel link on Add Plan Popup
	 */
	public WebElement getCancelLinkonPopup() {
		return cancelLinkPopup;
	}

	/** clicks on Continue on Popup **/
	public void clickContinuebuttononPopup() {
		addPlanConfirmButton.click();
	}

	/** correct modal values are displayed **/
	public WebElement getModalMemberIdValue() {
		return modalMemberIdValue;
	}

	public WebElement getModalMemberNameValue() {
		return modalMemberNameValue;
	}

	public WebElement getModalPlanNameValue() {
		return modalPlanNameValue;
	}

	public WebElement getModalDateOfBirthValue() {
		return modalDateOfBirthValue;
	}

	/**
	 *@toDo : the invalid mem id error message on Adding a Plan
	 */
	public WebElement getinvalidmemidError() {
		return invalidMemberError;
	}

	/**
	 *@toDo : return the checkbox status
	 */
	public WebElement getcheckbox1() {
		return addtoaccount2;
	}

	/**
	 *@toDo : return the another checkbox status
	 */
	public WebElement getcheckbox2() {
		return addtoaccount;
	}

	/**
	 *@toDo : the same mem plan error message on Adding a Plan
	 */
	public WebElement getsameMemIdError() {
		return samePlanError;
	}

	/**
	 *@toDo : the future effective plan error message on Adding a Plan
	 */
	public WebElement getFuturePlanError() {
		return futureEffectiveError;
	}

	/**
	 *@toDo : the plan being terminated error message on Adding a Plan
	 */
	public WebElement getplanterminatedError() {
		return terminatedErrorMessage;
	}

	/* member id already registered */
	public WebElement getmemberidalreadyregisteredError() {
		return memberAlreadyRegisteredError;
	}

	public void enterUserNameToCreateAccount(String userName) {
		sendkeys(createAccountUserName, userName);
	}
	
	/**
	 *@toDo : password to enter on step 3 of registration
	 */
	public void enterPasswordToCreateAccount(String password) {
		sendkeys(createAccountPassword, password);
	}
	
	/**
	 *@toDo : confirm password to enter on step 3 of registration
	 */
	public void enterConfirmPasswordToCreateAccount(String confirmPassword) {
		sendkeys(createAccountConfirmPassword, confirmPassword);
	}
	
	/**
	 *@toDo : email to enter on step 3 of registration
	 */
	public void enterEmailToCreateAccount(String email) {
		sendkeys(createAccountEmail, email);
	}
	
	/**
	 *@toDo : confirm email to enter on step 3 of registration
	 */
	public void enterConfirmEmailToCreateAccount(String confirmEmail) {
		sendkeys(createAccountConfirmEmail, confirmEmail);
	}
	
	/**
	 *@toDo : the create account on confirm registration page
	 */
	public WebElement getAccountConfirmation() {
		return createAccountConfirmRegistration;
	}
	
	/**
	 *@toDo : the blank user name error
	 */
	public WebElement getblankusernameError()
	{	
	return blankusernamemessage;  
	}
	
	/**
	 *@toDo : the incorrect user name error
	 */
	public WebElement getincorrectusernameError()
	{
	return incorrectusernamemessage;	
	}
	
	/**
	 *@toDo : the blank password error
	 */
	public WebElement getblankpasswordError()
	{	
	return blankpasswordmessage;
	}
	
	/**
	 *@toDo : the incorrect password error
	 */
	public WebElement getincorrectpasswordError()
	{
		return incorrectpasswordmessage;
		
	}
	/**
	 *@toDo : the confirm password field error
	 */
	public WebElement getconfirmpassworderrormessage()
	{
		return confirmpasswordmessage;
			
	}
	/**
	 *@toDo : the email error
	 */
	public WebElement getemailerrormessage()
	{
		return incorrectemailmessage;
		
	}
	/**
	 *@toDo : the confirm email error
	 */
	public WebElement getconfirmEmailError()
	{
		return incorrectconfirmemailmessage;
		
	}
	
	/**
	 * Functions for account confirmation page
	 */
	
	/**
	 *@toDo : the first name on account confirmation page
	 */
	public WebElement getMemberFirstName() {
		return accConfFirstName;
	}
	
	/**
	 *@toDo : the last name on account confirmation page
	 */
	public WebElement getMemberLastName() {
		return accConfLastName;
	}
	
	/**
	 *@toDo : the date of birthirth on account confirmation page
	 */
	public WebElement getMemberDoB() {
		return dateOfBirthText;
	}
	
	/**
	 *@toDo : the user Name on account confirmation page
	 */
	public WebElement getUserName() {
		return userNameText;
	}
	
	/**
	 *@toDo : the email address on account confirmation page
	 */
	public WebElement getEmailAddress() {
		return emailIdText;
	}
	
	/**
	 *@toDo : the Account Confirmation heading on account confirmation page
	 */
	public WebElement getAccConfirmationHeading() {
		return accountConfirmationHeading;
	}
	
	/**
	 *@toDo : the account confirmation text on account confirmation page
	 */
	public WebElement getAccConfirmationText() {
		return accountConfirmationText;
	}
	
	/**
	 *@toDo : the print link on account confirmation page
	 */
	public WebElement getPrintLink() {
		return printLink;
	}
	
	/**
	 *@toDo : the go to my account haome button on account confirmation page
	 */
	public WebElement getGoToMyAccountButton() {
		return goToMyAccountHomeButton;
	}   
	
	  /**
     * Wait for page to load
     */
    public void waitForRegistrationInformationPage() {
    	WebDriverWait wait = new WebDriverWait(this.driver, 10);
    	wait.until(new ExpectedCondition<Boolean>() {
    	    public Boolean apply(WebDriver driver) {
    		if (memberid.isDisplayed())
    		    return true;
    		else
    		    return false;
    	    }
    	});
    }
	
	   /**
     * Wait for page to load
     */
    public void waitForPlanInformationPage() {
    	WebDriverWait wait = new WebDriverWait(this.driver, 70);
    	wait.until(new ExpectedCondition<Boolean>() {
    	    public Boolean apply(WebDriver driver) {
    		if (nextButton.isDisplayed())
    		    return true;
    		else
    		    return false;
    	    }
    	});
    }
	
	
    /**
	 *@toDo : wait to load create account page
	 */
    /**
     * Wait for page to load
     */
    public void waitForCreatePageAccountPage() {
    	WebDriverWait wait = new WebDriverWait(this.driver, 60);
    	wait.until(new ExpectedCondition<Boolean>() {
    	    public Boolean apply(WebDriver driver) {
    		if (createAccountConfirmRegistration.isDisplayed())
    		    return true;
    		else
    		    return false;
    	    }
    	});
    }
    
    /**
	 *@toDo : wait to load account confirmation page
	 */
    /**
     * Wait for page to load
     */
    public void waitForAccountConfirmationPage() {
    	WebDriverWait wait = new WebDriverWait(this.driver, 50);
    	wait.until(new ExpectedCondition<Boolean>() {
    	    public Boolean apply(WebDriver driver) {
    	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	    	jse.executeScript("window.scrollBy(0,350)", "");
    		if (goToMyAccountHomeButton.isDisplayed())
    		    return true;
    		else
    		    return false;
    	    }
    	});
    }
    
	/**
     *@toDo : to scroll page
	 *@throws InterruptedException 
     */
    public void scroll() {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,150)", "");
    	
    }
	
	/**
     *@toDo : to scroll page
	 *@throws InterruptedException 
     */
    public void scrollUp() {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,100)", "");
    	
    }
}