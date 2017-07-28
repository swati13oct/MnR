package pages.dashboard.acquisition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

/**
* @author akuma103
*/
public class RegistrationInformationPage extends UhcDriver {

       /**
       *Registration page objects 
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
       *Personal information Section
       */
       
       /** The member id field. */
       @FindBy(id = "member-id")
       private WebElement memberid;
       
       /** The month field. */
       @FindBy(id = "date-mm")
       private WebElement monthToEnter;

       /** The date field. */
       @FindBy(id = "date-dd")
       private WebElement dayToEnter;

       /** The year field. */
       @FindBy(id = "date-yyyy")
       private WebElement yearToEnter;
       
       /** The cancel button. */
       @FindBy(className = "btn btn--secondary")
       private WebElement cancelButton;
       
       /** The next button. */
       @FindBy(id = "continue-btn")
       private WebElement nextButton;
       

       /** The direct URL for registration redesign page. */
       private static String PAGE_URL = MRConstants.REDESIGN_REGISTRATION_URL;
       
       /**
       *Additional personal Information section
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
       
       /** The IncorrectINfo Error on Additional Info page*/
       @FindBy(id = "invalidData-error")
       private WebElement incorrectinfoerror;
       
       /** The Completion Error on Additional Info page*/
       @FindBy(id = "orGroup-error")
       private WebElement fieldcompletionerror ;
       /**
       *Error message section Values
       */
              
       /** The already existing member account error message. */
       @FindBy(id = "existing_member_error")
       private WebElement existingMember;
       
       /** The inactive or terminated error message. */
       @FindBy(id = "inactive_terminated_Plan_error")
       private WebElement inactiveTerminatedMember;
       
       /** The future date effective error message. */
       @FindBy(id = "future_Effective_Plan_error")
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
       *existing member error page links
       */
       
       /** The username and password help link on existing member page. */
       @FindBy(linkText = "username and password help")
       private WebElement usernameAndPasswordHelpLink;

       /** The sign in with your existing credentials link on existing member page. */
       @FindBy(linkText = "SIGN IN WITH YOUR EXISTING CREDENTIALS")
       private WebElement signInWithYourExistingCredentialsLink;
       
       /**
       *Plan information Page
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
       @FindBy(id = "pffsMemberErrorMsg")
       private WebElement pffsErrorMessage;
       
       /** Multiple Plans**/
      
  
       /** The additional Plan member ID */
       @FindBy(id = "multiple-member-id")
       private WebElement additionalPlanMemberID;

       /** The add a plan button */
      @FindBy(id = "add-to-plan")
       private WebElement addPlanButton;


       /**
        *Add a Plan pop up objects
        *
        */


       /** The add a plan pop up header*/
       @FindBy(id = "addPlanModalLabel")
       private WebElement addPlanPopUpHeader;
       
       /** The cancel link button on add a plan pop up*/
       @FindBy(id = "modalCancelBtn")
       private WebElement cancelLinkPopup;
       

       /** The confirm button on add a plan pop up*/
       @FindBy(id = "add-plan-confirm")
       private WebElement addPlanConfirmButton;
       
       /** The modal values to be validated**/
       @FindBy(id = "modalMemberIdValue")
       private WebElement modalMemberIdValue;
       
       @FindBy(id = "modalMemberNameValue")
       private WebElement modalMemberNameValue;
       
       @FindBy(id = "modalPlanNameValue")
       private WebElement modalPlanNameValue;
      
       @FindBy(id = "modalDateOfBirthValue")
       private WebElement modalDateOfBirthValue;
       
       /*checkbox status*/
       
       @FindBy(id="add-to-account2")
       private WebElement addtoaccount2;
       
       @FindBy(id="add-to-account")
       private WebElement addtoaccount;
       
       /** The member id already registered error message */
       @FindBy(id="planAlreadyRegisteredErrorMessage")
       private WebElement memberAlreadyRegisteredError;

/** The future effective member Id error message */
       @FindBy(id="planInFutureErrorMessage")
       private WebElement futureEffectiveError;

/** The terminated member Id error message */
       @FindBy(id="planTerminatedErrorMessage")
       private WebElement terminatedErrorMessage;

/** The invalid member Id error message */
       @FindBy(id="invalidMemberErrorMessage")
       private WebElement invalidMemberError;

/** The same member Id error message */
       @FindBy(id="addingSamePlanErrorMessage")
       private WebElement samePlanError;
       
       
       public RegistrationInformationPage(WebDriver driver) {
              super(driver);
              PageFactory.initElements(driver, this);
              openAndValidate();
       }

    /**
     * Functions to verify the page headings
     */       
    
    /**
     * @return the Personal Info text
     */
    public WebElement getStepOneText() {
       return personalInfoText;
    }

    /**
     * @return the Plan Info text
     */
    public WebElement getStepTwoText() {
       return planInfoText;
    }

    /**
     * @return the Create Account Text
     */
    public WebElement getStepThreeText() {
       return createAccountText;
    }
       
    /**
     * Personal Information page functions.
     */
       
    /**
     * Enter member ID.
     */
    public void enterMemberID(String memberID) {
       sendkeys(memberid, memberID);
    }
    
    
    /**
     * @return the member ID
     */
    public WebElement getMemberID() {
       return memberid;
    }
    
    
    /**
     * Enter month.
     */
    public void enterMonth(String month) {
      sendkeys(monthToEnter, month);
    }
    
    /**
     * @return the month to enter
     */
    public WebElement getEnterMonth() {
       return monthToEnter;
    }
    
    /**
     * Enter day.
     */
    public void enterDay(String day) {
       sendkeys(dayToEnter, day);
    }
    
    /**
     * @return the day to enter
     */
    public WebElement getEnterDay() {
       return dayToEnter;
    }
    
    /**
     * Enter year.
     */
    public void enterYear(String year) {
       sendkeys(yearToEnter, year);
    }
    
    /**
     * @return the year to enter
     */
    public WebElement getEnterYear() {
       return yearToEnter;
    }
    
    
    /**
     * Click the continue button
     */
    public void clickNext() {
       nextButton.click();
    }
    
    /**
     * Click the previous button
     */
    public void clickPreviousButtuon() {
       previousButton.click();
    }
    
    
    /**
     * Click the cancel button
     */
    public void clickCancel() {
       cancelButton.click();
    }
      
    /**
     * @return the medicare id to enter
     */
    public WebElement getMedicareId(){
        return medicareID;
        }
    
    /**
     * @return the zipcode field to enter
     */
    public WebElement getZipcode(){
        return zipCode;
        }
        
    /**
     * @return the first name field to enter
     */
    public WebElement getFirstName(){
        return firstName;
        }
    
    
    /**
     * @return the last name field to enter
     */
    public WebElement getLastName(){
        return lastName;
        }
    
    /**
     * @return the get Personal info header for additional info is displayed
     */
    public WebElement getAdditionalInfoHeader(){
    return personalInfoHeader;
    }
    
    /**
     * Enter Zip Code additional Information.
     */
    public void enterZip(String Zip) {
       sendkeys(zipCode, Zip);
    }
    /**
     * Enter first name additional Information.
     */
    public void enterFirstName(String fName) {
       sendkeys(firstName, fName);
    }
    /**
     * Enter last name additional Information.
     */
    public void enterLastName(String lNmae) {
       sendkeys(lastName, lNmae);
    }
    /**
     * Enter medicareID.
     */
    public void enterMedicareID(String medicare_id) {
       sendkeys(medicareID, medicare_id);
    }
   
    /**
     * Functions to verify the Error message pages
     */       
    
    /**
     * @return the member not found error message
     */
    public WebElement getExistingMemberError(){
    return existingMember;
    }
    
    /**
     * @return the inactive or terminated member error message
     */
    public WebElement getInactiveTerminatedError(){
    return inactiveTerminatedMember;
    }
    
    /**
     * @return the inactive or terminated member error message
     */
    public WebElement getFutureEffectiveError(){
    return futureEffectivePlanMember;
    }
    
    /**
     * @return the member not found error message
     */
    public WebElement getmemberNotFoundError(){
    return memberNotFound;
    }
    
    /**
     * Functions to click link on Error message pages
     */  
  
       /**
     * Click the  existing Start Over link
     */
    public void clickExistingStartOver() {
       existingStartOverLink.click();
     }

    /**
    * Click the  future Start Over link
    */
   public void clickFutureStartOver() {
       futureStartOverLink.click();
    }

    /**
    *Click the inactive Start Over link
    */
   public void clickInactiveStartOver() {
       inactiveStartOverLink.click();
    }

    /**
    *Click the not found Start Over link
    */
   public void clickNotFoundStartOver() {
       notFoundStartOverLink.click();
    }
   

   /**
   *Click the username and password link
   */
  public void clickUserNameAndPasswordLink() {
       usernameAndPasswordHelpLink.click();
   }

   /**
   *Click the Sign in with existing link
   */
  public void clickSignInWithExistingLink() {
       signInWithYourExistingCredentialsLink.click();
   }
  
  
  /**
   * Functions for Plan information page validation
   */
  
  /**
   * @return the plan name on plan info page
   */
  
       public WebElement getPlanName(){
       return planName;
       }
       

    /**
     * @return the member id on plan info page
     */
       public WebElement getMemberNumber(){
       return mNumber;
       }


    /**
     * @return the Member name on plan info page
     */
       public WebElement getMemberName(){
       return mName;
       }


    /**
     * @return the DOB on plan info page
     */
       public WebElement getPMemberDob(){
       return mDOB;
       }
       
       
    /**
     * @return the previous button on plan info page
     */
       public WebElement getPreviousButton(){
       return previousButton;
       }
          
          
             
    /**
     * @return the next button on plan info page
     */
      public WebElement getNextButton(){
      return nextButton;
      }

             /**
              * Functions for Additional Info Error messages
              */        
             public WebElement getIncorrectInfoError(){
             	return incorrectinfoerror;
             	
             }
             public WebElement getfieldCompletionError(){
             	return fieldcompletionerror;
             	
             }
          

    /**
     * @return the additional plan information header plan info page
     */
      public WebElement getAdditionalPlanInfoHeader(){
      return additionalInfoHeader;
      }
                 
       @Override
       public void openAndValidate() {
              start(PAGE_URL);
              validate(memberid);
              validate(monthToEnter);
              validate(dayToEnter);
              validate(yearToEnter); {
              validate(nextButton);

       }
                 }
       
       public void validatePffsMemberErrorMessage(){
    	   if (!pffsErrorMessage.isDisplayed()){
    		   Assert.assertTrue("pffs Error Message is not displayed", false);
    		   
    	   }else{
    		   
    		   Assert.assertTrue("pffs Error Message is displayed", true); }
    	   
       }
       
       /*Multiple Plan*/
       
       public void clickAddplanButton()
       {
    	   addPlanButton.click();
       }
       
       /**
        * @return the Add Plan header
        */
       public WebElement getPlanPopupHeader() {
          return addPlanPopUpHeader;
       }
     
       /**
        * @return the Confirm on Add Plan Popup
        */
       public WebElement getConfirmonPopup() {
          return addPlanConfirmButton;
       }
       /**
        * @return the Cancel link on Add Plan Popup
        */
       public WebElement getCancelLinkonPopup() {
          return cancelLinkPopup;
       }
       
      
        
       /** clicks on Continue on Popup**/
       
       
       public void clickContinuebuttononPopup()
       {
    	   addPlanConfirmButton.click();
       }
       /** correct modal values are displayed**/
       
       public WebElement getModalMemberIdValue()
       {
    	  return modalMemberIdValue;
       }
       
       public WebElement getModalMemberNameValue()
       {
    	  return modalMemberNameValue;
       }
       
       public WebElement getModalPlanNameValue()
       {
    	  return modalPlanNameValue;
       }
       
       public WebElement getModalDateOfBirthValue()
       {
    	  return modalDateOfBirthValue;
       }
       /**
        * @return the invalid mem id error message on Adding a Plan 
        */
       public WebElement getinvalidmemidError() {
          return invalidMemberError;
       }
       
       
       /** 
        * return the checkbox status
        */
       public WebElement getcheckbox1() {
           return addtoaccount2;
        }
       
       /** 
        * return the another checkbox status
        */
       public WebElement getcheckbox2() {
           return addtoaccount;
        }
       
       
       public boolean isChecked2()
       {
    	   if(addtoaccount2.getAttribute("checked")!=null)
    	   return true; 
    			   
    	   else return false;
       }
      
        
         public boolean isChecked1()
       {
    	   if(addtoaccount.getAttribute("checked")!=null)
    	   return true; 
    			   
    	   else return false;
       }
       /*
        * @return the same mem plan error message on Adding a Plan 
        */
       public WebElement getsameMemIdError() {
          return samePlanError;
       }
       
       /**
        * @return the future effective plan error message on Adding a Plan 
        */
       public WebElement getFuturePlanError() {
          return futureEffectiveError;
       }
       
       /**
        * @return the plan being terminated error message on Adding a Plan 
        */
       public WebElement getplanterminatedError() {
          return terminatedErrorMessage;
       }
       
       
       /*member id already registered*/
       public WebElement getmemberidalreadyregisteredError() {
           return memberAlreadyRegisteredError;
        }
       
       }
