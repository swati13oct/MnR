/**
 * 
 */
package pages.acquisition.ole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.VisitorProfilePage;

/**
 *@author sdwaraka
 *
 */
public class OLEconfirmationPage extends UhcDriver{
	
	//@FindBy(xpath = "//*[contains(@class,'confirmation-number')]")
	@FindBy(xpath = "//*[contains(@class,'confirmation-number')]//span[@class='confirmation-number']")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[contains(text(), 'ZIP:')]/..")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[contains(text(), 'Premium:')]/..")
	private WebElement PremiumDisplay;

	@FindBy(xpath = "//*[@id='msptextbtn']")
	private WebElement NextSteps_MedSuppBtn;
	
	@FindBy(xpath = "//*[@id='mAdvtextbtn']")
	private WebElement NextSteps_MedicareAdvBtn;
	
	@FindBy(xpath = "//*[@id='pdptextbtn']")
	private WebElement NextSteps_PDPBtn;
	
	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(css = "a#visitor-profile-header")
	private WebElement lnkProfile;

	//@FindBy(xpath = "//*[contains(@class,'confirmation-number')]")
	@FindBy(xpath = "//*[contains(@class,'confirmation-number')]//span[@class='confirmation-number']")
	private WebElement confirmationNumber;
	
	public OLEconfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(PlanYear_PlanName);
	}

	public boolean validate_plan_details(Map<String, String> planDetailsMap) {
		
		String Expected_PlanName = planDetailsMap.get("Plan Name");
		String Expected_PlanYear = planDetailsMap.get("Plan Year");
		String Expected_ZipCode = planDetailsMap.get("Zip Code");
		String Expected_County = planDetailsMap.get("County");
		String Expected_PlanPremium = planDetailsMap.get("Plan Premium");
		boolean flag = false;
		String PlanYear_PlanName_Text = PlanYear_PlanName.getText();
		String Zip_County_Text = ZipCode_County.getText();
		String Premium = PremiumDisplay.getText();
		System.out.println("Plan Year and Plan Name Displayed on OLE : "+PlanYear_PlanName_Text);
		System.out.println("Zip Code and County Displayed on OLE : "+Zip_County_Text);
		System.out.println("Monthly Premium for Plan Displayed on OLE : "+Premium);

		if(PlanYear_PlanName_Text.contains(Expected_PlanName)){
			flag = true;
			System.out.println("Plan Name is Validated : "+flag);
		}else flag =false;
		if(PlanYear_PlanName_Text.contains(Expected_PlanYear)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Year is Validated : "+flag);
		}else flag =false;
		if(Zip_County_Text.contains(Expected_County)){
			flag = (flag==false)?false:true;
			System.out.println("Plan County is Validated : "+flag);
		}else flag =false;
		if(Zip_County_Text.contains(Expected_ZipCode)){
			flag = (flag==false)?false:true;
			System.out.println("Plan ZIP CODE is Validated : "+flag);
		}else flag =false;
		/*if(Premium.contains(Expected_PlanPremium)){
			flag = (flag==false)?false:true;
			System.out.println("Plan Premium is Validated : "+flag);
		}else flag =false;*/
		System.out.println("Plan Details are Validated : "+flag);
		return flag;	}

	public boolean validate_nextSteps_for_Plantype(String planType) {
		if(planType.contentEquals("PDP")){
			if(validate(NextSteps_MedicareAdvBtn) && validate(NextSteps_MedSuppBtn)){
				System.out.println("Med Supp Plans Button and Medicare Advantage Plans Button are DIsplayed for PDP plan Type");
				return true;
			}
			else{
				System.out.println("Med Supp Plans Button and Medicare Advantage Plans Button are NOT DIsplayed for PDP plan Type");
				return false;

			}
		}
		if(planType.contentEquals("MA")){
			if(validate(NextSteps_PDPBtn)){
				System.out.println("Prescription Drug Plans Button is Displayed for MA only plan Type");
				return true;
			}
			else{
				System.out.println("Prescription Drug Plans Button is NOT Displayed for MA only plan Type");
				return false;

			}
		}
		if(validateNonPresenceOfElement(NextSteps_MedicareAdvBtn) && validateNonPresenceOfElement(NextSteps_MedSuppBtn) && validateNonPresenceOfElement(NextSteps_PDPBtn)){
			System.out.println("Next Steps are Not Displayed for planType : "+planType);
			return true;
		}
		System.out.println("Next Steps are Displayed for planType : "+planType);
		return false;
	}

	
	public Map<String, String> retrieve_GPS_data(String confirmation_no) {
	  	   Connection connection = createDataBaseConnection();
		   ResultSet rs = null;
		   Statement stmt = null;
		   Map<String, String> gpsData = new HashMap<String, String>();
		   try {
			   stmt = connection.createStatement();
			  rs = stmt.executeQuery(CommonConstants.GPS_QUERY + confirmation_no );
			   while(rs.next()) {

				   //Personal Information
				   String firstName = rs.getString("FIRST_NAME");
				   gpsData.put("First Name", firstName);
				   
				   String middleInitial = rs.getString("MIDDLE_INITIAL");
				   gpsData.put("MiddleInitial", middleInitial);
				   
				   String lastName = rs.getString("LAST_NAME");
				   gpsData.put("Last Name", lastName);
				   String doB = rs.getString("DATE_OF_BIRTH");
				   doB = doB.substring(0, 10);
				   gpsData.put("DOB", doB);

				   //Gender
				   String gender = rs.getString("GENDER");
				   gpsData.put("Gender", gender);

				   //Primary Address
				   String address1 = rs.getString("ADDRESS_LINE_1");
				   gpsData.put("Perm_Street", address1);
				   String address2 = rs.getString("ADDRESS_LINE_2");
				   
				   gpsData.put("Perm_Apartment", address2);
				   String city = rs.getString("CITY");
				   gpsData.put("Perm_city", city);
				   //String state = rs.getString("STATE_CD"); 29/12 ++
				   //gpsData.put("State", state);
				   String zipCode = rs.getString("ZIP_CD");
				   gpsData.put("Zip Code", zipCode );

				   //Mailing Address
				   String mailingAddress1 = rs.getString("MAILING_ADDRESS_LINE_1");
				   gpsData.put("Mailing_Street", mailingAddress1);
				   
				   String mailingAddress2 = rs.getString("MAILING_ADDRESS_LINE_2");
				   gpsData.put("Mailing Apartment Number", mailingAddress2);
				   String mailingCity = rs.getString("MAILING_CITY");
				   gpsData.put("Mailing_City", mailingCity);
				
				   String mailingState = rs.getString("MAILING_STATE_CD");
				   gpsData.put("Mailing_State", mailingState);
				   
				   String mailingZipcode = rs.getString("MAILING_ZIP_CD");
				   gpsData.put("Mailing_Zip", mailingZipcode);

				   //Phone Number
				   String dayTimePhoneNumber = rs.getString("DAYTIME_PHONE_NUM");
				   gpsData.put("Home Number", dayTimePhoneNumber);
				   String eveningTimePhoneNumber = rs.getString("EVENING_PHONE_NUM");
				   gpsData.put("Mobile Number", eveningTimePhoneNumber); 
				   
				   //Email
				   String email = rs.getString("EMAIL");
				   gpsData.put("Email", email);
				   String paperless = rs.getString("PAPERLESS_PREFERENCE_IND");
				   gpsData.put("Paperless Delivery", paperless);
				   String language = rs.getString("LANGUAGE_PREFERENCE");
				   gpsData.put("Language", language);
				   				   
				   //Medicare Information Page

				   //Medicare and Medicaid Number
				   String medicareNumber = rs.getString("MEDICARE_NUMBER");
				   gpsData.put("Medicare Number", medicareNumber); 
				   
				   String medicaidNumber = rs.getString("MEDICAID_NUMBER");
				   gpsData.put("Medicaid Number", medicaidNumber);
				   String SSN = rs.getString("SSN");
				   gpsData.put("SSN Number", SSN);

				   
				   //Other Health Insurance
				   String healthInsurance= rs.getString("DO_YOU_HAVE_OTHER_HEALTH_INS");
				   gpsData.put("Health Insurance", healthInsurance); 
				   String healthInsuranceName = rs.getString("OTHER_HEALTH_INSURANCE_NAME");
				   gpsData.put("Health Insurance Name", healthInsuranceName); 
				   String healthInsuranceGroupName = rs.getString("OTHER_HEALTH_INSURANCE_GRP_NUM");
				   gpsData.put("Group Number", healthInsuranceGroupName); 
				   String healthInsuranceID  = rs.getString("OTHER_HEALTH_INSURANCE_ID");
				   gpsData.put("Member Number", healthInsuranceID); 

				   //Prescription Drug Coverage
				   String secondaryCoverage = rs.getString("DO_YOU_HAVE_OTHER_RX_COVERAGE");
				   gpsData.put("Prescription Drug", secondaryCoverage); 
				   String otherCoverageName = rs.getString("SECONDARY_RX_COVERAGE_NAME");
				   gpsData.put("Prescription Name", otherCoverageName); 
				   String secondaryGroup = rs.getString("SECONDARY_RX_GROUP");
				   gpsData.put("PD Group Number", secondaryGroup); 
				   String secondaryMemberNumber = rs.getString("SECONDARY_RX_ID");
				   gpsData.put("PD Member Number", secondaryMemberNumber); 
				   String secondaryRXBINNumber =rs.getString("SECONDARY_RX_BIN");
				   gpsData.put("RX BIN Number", secondaryRXBINNumber); 

				   //Eligibility Page
				   String partAEffectiveDate = rs.getString("MEDICARE_PART_A_EFFECTIVE_DATE");
				   partAEffectiveDate = partAEffectiveDate.substring(0, 10);
				   gpsData.put("PartA Date", partAEffectiveDate); 
				   String partBEffectiveDate = rs.getString("MEDICARE_PART_B_EFFECTIVE_DATE");
				   partBEffectiveDate = partBEffectiveDate.substring(0, 10);
				   gpsData.put("PartB Date", partBEffectiveDate);

				   //Proposed Effective Date
				   String proposedeffectiveDate = rs.getString("REQUESTED_EFFECTIVE_DATE");
				   proposedeffectiveDate = proposedeffectiveDate.substring(0, 10);
				   gpsData.put("Proposed Effective date", proposedeffectiveDate);  					   
					System.out.println("--------------------Storing Data for Eligibility Page Started----------------------"+proposedeffectiveDate);
					
				   //Credit Card Details
				   String creditCardNumber = rs.getString("CREDIT_CARD_NUMBER");
				   gpsData.put("Credit Card Number", creditCardNumber);
				   String creditCardNameOnCard = rs.getString("CREDIT_CARD_NAME_ON_CARD");
				   gpsData.put("Credit Card Name On Card", creditCardNameOnCard);
				   String creditCardExpirationDate = rs.getString("CREDIT_CARD_EXPIRATION_DATE");
				   gpsData.put("Credit Card Expiration Date", creditCardExpirationDate);
				   
				   //PCP Page
				   String pcpName = rs.getString("PRIMARY_CARE_PHYSICIAN");
				   pcpName = pcpName.replaceAll("-", "");
				   gpsData.put("PCP Name", pcpName); 
				   String pcpNumber = rs.getString("PRIMARY_CARE_PHYSICIAN_NUMBER");
				   gpsData.put("PCP Number", pcpNumber); 
				   String pCPRecentlyVisited = rs.getString("CURRENTLY_A_PATIENT_OF_THE_PCP");
				   gpsData.put("PCP Recently Visited", pCPRecentlyVisited);  
				   String confirmationNumber = rs.getString("XEROX_STAGE_ID");
				   gpsData.put("Confirmation No", confirmationNumber);
				   
				   //SEP Page 
				   //String note = rs.getString("NOTE");
				   //gpsData.put("Note", note); 
				  
				   //String dentalPlatinum = rs.getString("DENTAL_PLATINUM"); TODO:1/6-Check and update for which plan types ths value comes as Y and put logic to validate it
				   //gpsData.put("Dental Platinum", dentalPlatinum);
				   
				   String paymentMethod = rs.getString("PAYMENT_METHOD");
				   gpsData.put("Payment Method", paymentMethod);

				   
				   //Authorization Page
				   String authorizationFirstName = rs.getString("AUTHORIZED_REP_FIRST_NAME");
				   gpsData.put("Authorization First Name", authorizationFirstName);
				   
				   String authorizationLastName = rs.getString("AUTHORIZED_REP_LAST_NAME");
				   gpsData.put("Authorization last Name", authorizationLastName);
				   
				   String authRel = rs.getString("AUTHORIZED_REP_MAILING_ZIP_CD");
				   gpsData.put("Authorization Relationship", authRel);
				
				   String authAddr1 = rs.getString("AUTHORIZED_REP_MAILING_ADDR_1");
				   gpsData.put("Authorization Address", authAddr1);
				   
				   String authAddr2 = rs.getString("AUTHORIZED_REP_MAILING_ADDR_2");
				   gpsData.put("Authorization Apartment Suite", authAddr2);
				   
				   String authCity = rs.getString("AUTHORIZED_REP_MAILING_CITY");
				   gpsData.put("Authorization City", authCity);
				   
				   String authPhone = rs.getString("AUTHORIZED_REP_DAYTIME_PHONE");
				   gpsData.put("Authorization Phone No", authPhone);
				   
				   String authState = rs.getString("AUTHORIZED_REP_MAILING_STATE");
				   gpsData.put("Authorization State", authState);
				   
				   String authZip = rs.getString("AUTHORIZED_REP_MAILING_ZIP_CD");
				   gpsData.put("Auth Zip Display", authZip);
				   
				   String authRepInd = rs.getString("AUTHORIZED_REPRESENTATIVE_IND");
				   gpsData.put("Auth Representative Indicator", authRepInd);
				
				   String authRepRelationship = rs.getString("AUTHORIZED_REP_RELATIONSHIP");
				   gpsData.put("Authorization Relationship", authRepRelationship);
				   
				   String authSignature = rs.getString("SIGNATURE_PRESENCE");
				   gpsData.put("Authorization Agree", authSignature);
				
				
				 //-----------Adding for CSNP----------------//
				   String diabetes1 = rs.getString("ASMENT_DIAB1_DOC_INFORMED_DIAB");
				   gpsData.put("Diabetes Question 1", diabetes1); 
				   String diabetes2 = rs.getString("ASMENT_DIAB2_PRESCRIBED_INSULN");
				   gpsData.put("Diabetes Question 2", diabetes2); 
				   String chronic1 = rs.getString("CHRONIC_AUTH_HEART_FAILURE");
				   gpsData.put("Chronic Heart Failure Question 1", chronic1); 
				   String chronic2 = rs.getString("ASMENT_LUNG1_BRONC_EMPH_ASTHMA");
				   gpsData.put("Chronic Heart Failure Question 2", chronic2); 
				   String chronic3 = rs.getString("ASMENT_HEART2_CARDC_BYPASS");
				   gpsData.put("Chronic Heart Failure Question 3", chronic3); 
				   String Cardiovascular1 = rs.getString("CHRONIC_AUTH_VASCULAR_DISEASE");
				   gpsData.put("Cardio Vascular Disorder Question 1", Cardiovascular1); 
				   String Cardiovascular2 = rs.getString("ASMENT_HEART1_HEART_ATTACK");
				   gpsData.put("Cardio Vascular Disorder Question 2", Cardiovascular2); 
				   String Cardiovascular3 = rs.getString("ASMENT_HEART10_ANGINA");
				   gpsData.put("Cardio Vascular Disorder Question 3", Cardiovascular3); 
				   String Cardiovascular4 = rs.getString("ASMENT_HBP2_MEDICATION_FOR_HBP");
				   gpsData.put("Cardio Vascular Disorder Question 4", Cardiovascular4); 
				   String Cardiovascular5 = rs.getString("ASMENT_HEART7_PACEMKR_R_DEFIB");
				   gpsData.put("Cardio Vascular Disorder Question 5", Cardiovascular5); 
				   String Cardiovascular6 = rs.getString("ASMENT_HEART3_ANGIOPLASTY");
				   gpsData.put("Cardio Vascular Disorder Question 6", Cardiovascular6); 
				   String chronicEnrollmentcheckbox = rs.getString("ASMENT_SIGN_PRESENCE_ENROLLEE");
				   gpsData.put("Disclosure Checkbox", chronicEnrollmentcheckbox); 
				   
				   /*	
				   String chronicillness = rs.getString("DO_YOU_HAVE_A_CHRONIC_ILLNESS");
				   gpsData.put("Disclosure Checkbox", chronicillness); */
				   String chronicphysician = rs.getString("CHRONIC_PHYSICIAN_NAME");
				  
				   gpsData.put("Disclosure Provider Name", chronicphysician); 
				   String chronicphysicianPhoneNumber = rs.getString("CHRONIC_PHYSICIAN_PHONE_NUM");
				   
				   gpsData.put("Disclosure Provider PhoneNumber", chronicphysicianPhoneNumber); 
				   
				   String chronicphysicianAddress = rs.getString("ASMENT_FULL_ADDR_FOR_PHYSICIAN");
				   
				   gpsData.put("Disclosure Provider Address", chronicphysicianAddress); 


				   
				   //------------------------------------------//
				
			
			   }
		  } catch (Exception e) {
			   e.printStackTrace();
		}
		   finally {
			   try {
			   if(stmt!=null) {
				   stmt.close();
				} 
			   if(rs!=null) {
				   rs.close();
				} 
			   if(connection!=null) {
				   connection.close();
				}
			   
			   }catch (SQLException e) {
					e.printStackTrace();
				}
			  }
	return gpsData;
	  
	}
	
	public Connection createDataBaseConnection() {
		Connection connection = null;
		try {
			 Class.forName(CommonConstants.DB_ORACLE_DRIVER).newInstance();
			 if(MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.equalsIgnoreCase("team-acme")) 
			 {
			 connection = DriverManager.getConnection(CommonConstants.CONNECTION_URL_UAT20);
			 }
			if(MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.equalsIgnoreCase("team-acme")){
				 connection = DriverManager.getConnection(CommonConstants.CONNECTION_URL_UAT19);
			 }
			if(MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.equalsIgnoreCase("team-acme")){
				 connection = DriverManager.getConnection(CommonConstants.CONNECTION_URL_UAT18); 
			 }
			if(MRScenario.environment.equalsIgnoreCase("stage") || MRScenario.environment.equalsIgnoreCase("team-acme")){
		     connection = DriverManager.getConnection(CommonConstants.CONNECTION_URL_STAGE);
				 } 
			 if(connection!=null) {
				 
				 System.out.println("Connection successful");

			 }
		}
			 catch (Exception e) {
			 e.printStackTrace();
		}
		
		return connection;
			
}
	
	public boolean validate_GPS_for_Plantype(Map<String,String> map,Map<String,String> matched,Map<String,String> mismatched) throws SQLException {
		boolean flag = false;
		//try {
			String confirmation_no = confirmationNumber.getText();
			System.out.println("OLE confirmation number is  " +confirmation_no);
			map.put("Confirmation No", confirmation_no);
			Map<String,String> gpsdatamap = retrieve_GPS_data(confirmation_no);
			Map <String, String> gpsmap = new HashMap<>();
			Map<String,String> validateGPS = new HashMap<String, String>();
			String defaultValue = "";
			gpsmap = null_vals(gpsdatamap, defaultValue);
		//	Map <String, String> matched = new HashMap<>();
		//	Map <String, String> mismatched = new HashMap<>();
			for (String keySource : map.keySet()) {
				String strSource = map.get(keySource);
				if (gpsmap.containsKey(keySource)) {
					String strTarget = gpsmap.get(keySource);
					if(strSource.equalsIgnoreCase(strTarget)) {
						flag = true;
						matched.put(keySource, strSource);
						// print out matched
						System.out.println("Matched values in OLE GPS");
						System.out.println(Arrays.asList(matched));
						
						/*System.out.println("============");  
						System.out.println("Key\tValue");
						System.out.println("============");
						for (String key : matched.keySet()) {
							String matchedValue = key + "\t" + matched.get(key);
							System.out.println(key+"========================"+matchedValue);
						}
*/				}
					else {
						flag = false;
						mismatched.put(keySource, strSource);
						// print out matched
						System.out.println("Mismatched values in OLE GPS");
						System.out.println(Arrays.asList(mismatched));
						/*System.out.println("============");  
						System.out.println("Key\tValue");
						System.out.println("============");
						for (String key : mismatched.keySet()) {
							String mismatchedValue = key + "\t" + mismatched.get(key);
							System.out.println(key+"========================"+mismatchedValue);
						}*/
					}
					//System.out.println(keySource +" #  "+ strTarget+ " # "+strSource);

					

					
				}


			}
			
/*		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    return flag;
	//return Validation_Status;
	}
	

	
	public String converttogpsDate(String intputDate) {
		String date = intputDate.substring(2, 4);
		String month = intputDate.substring(0, 2);;
		String year = intputDate.substring(4,8);
		String outputDate= year+"/"+month+"/"+date; 
		System.out.println("Output Date====================== "+outputDate);
		return outputDate;	
	}
	
	public String converttogpsDate1(String intputDate) {
		String date = intputDate.substring(3,5);
        String month = intputDate.substring(0,2);
        String year = intputDate.substring(6,10);
		String outputDate= year+"/"+month+"/"+date; 
		System.out.println("Output Date====================== "+outputDate);
		return outputDate;	
	}
	
	public <T, K> Map<K, T> null_vals(Map<K, T> my_map, T def_val){
	      my_map = my_map.entrySet().stream().map(entry -> {
	         if (entry.getValue() == null)
	         entry.setValue(def_val);
	         return entry;
	      })
	      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	      return my_map;
	   }
	
	public VisitorProfilePage clickOnShoppingCart() {
		jsClickNew(shoppingCartIcon);
		jsClickNew(lnkProfile);
		threadsleep(2000);
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}
}
	