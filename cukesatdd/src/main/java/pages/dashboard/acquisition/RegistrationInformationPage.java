package pages.dashboard.acquisition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.UhcDriver;

/**
 * @author akuma103
 *
 */
public class RegistrationInformationPage extends UhcDriver {

	
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

	public RegistrationInformationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	
    /**
     * Enter member ID.
     */
    public void enterMemberID(String memberID) {
	sendkeys(memberid, memberID);
    }
    
    /**
     * Enter month.
     */
    public void enterMonth(String month) {
	sendkeys(monthToEnter, month);
    }
    
    /**
     * Enter day.
     */
    public void enterDay(String day) {
	sendkeys(dayToEnter, day);
    }
    
    /**
     * Enter year.
     */
    public void enterYear(String year) {
	sendkeys(yearToEnter, year);
    }
    
    
    /**
     * Click the continue button
     */
    public void clickNext() {
    	nextButton.click();
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
     * @return the get Personal info header for additional info is displayed
     */
    public WebElement getAdditionalInfoHeader(){
    return personalInfoHeader;
    }
    
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
     * Plan information page validation
     */
    
	public WebElement getPlanName(){
	return planName;
	}
	
	public WebElement getmemberId(){
	return mNumber;
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
	}
