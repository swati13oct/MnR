/**
 * 
 */
package pages.acquisition.ole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class OLEconfirmationPage extends UhcDriver{
	
	//@FindBy(xpath = "//*[contains(@class,'confirmation-number')]")
	@FindBy(xpath = "//*[contains(@class,'confirmation-number')]//p[@class='confirmation-number']")
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

	//@FindBy(xpath = "//*[contains(@class,'confirmation-number')]")
	@FindBy(xpath = "//*[contains(@class,'confirmation-number')]//p[@class='confirmation-number']")
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
				   String firstName = rs.getString("FIRST_NAME");
				   gpsData.put("First Name", firstName);
				   String lastName = rs.getString("LAST_NAME");
				   gpsData.put("Last Name", lastName);
				   String gender = rs.getString("GENDER");
				   gpsData.put("Gender", gender);
				   String medicareNumber = rs.getString("MEDICARE_NUMBER");
				   gpsData.put("Medicare Number", medicareNumber); 
				   String partAEffectiveDate = rs.getString("MEDICARE_PART_A_EFFECTIVE_DATE");
				   	partAEffectiveDate = partAEffectiveDate.substring(0, 10);
					gpsData.put("PartA Date", partAEffectiveDate); 
					String partBEffectiveDate = rs.getString("MEDICARE_PART_B_EFFECTIVE_DATE");
					partBEffectiveDate = partBEffectiveDate.substring(0, 10);
					gpsData.put("PartB Date", partBEffectiveDate);
					String doB = rs.getString("DATE_OF_BIRTH");
					doB = doB.substring(0, 10);
					gpsData.put("DOB", doB);
					String zipCode = rs.getString("ZIP_CD");
					gpsData.put("Zip Code", zipCode );

					String healthInsuranceName = rs.getString("OTHER_HEALTH_INSURANCE_NAME");
					 gpsData.put("Health Insurance Name", healthInsuranceName); 
					   String healthInsuranceGroupName = rs.getString("OTHER_HEALTH_INSURANCE_GRP_NUM");
					 gpsData.put("Group Number", healthInsuranceGroupName); 
					    String healthInsuranceID  = rs.getString("OTHER_HEALTH_INSURANCE_ID");
					   gpsData.put("Member Number", healthInsuranceID); 
					    String secondaryCoverageName = rs.getString("SECONDARY_RX_COVERAGE_NAME");
					   gpsData.put("Prescription Name", secondaryCoverageName); 
					    String otherCoverageName = rs.getString("OTHER_RX_COVERAGE_NAME");
					   gpsData.put("Prescription Name", otherCoverageName); 
					     String secondaryGroup = rs.getString("SECONDARY_RX_GROUP");
					   gpsData.put("PD Group Number", secondaryGroup); 
					   String secondaryMemberNumber = rs.getString("SECONDARY_RX_ID");
					   gpsData.put("PD Member Number", secondaryMemberNumber); 
					
					   //   PD Member Number
						   
				   //add for all the gps columns
				   /* String confirmationNumber = rs.getString("XEROX_STAGE_ID");
				   gpsData.put("Confirmation No", confirmationNumber);
				   String middleInitial = rs.getString("MIDDLE_INITIAL");
				   gpsData.put("MiddleInitial", middleInitial);
				    String medicareNumber = rs.getString("MEDICAID_NUMBER");
				   gpsData.put("First Name", firstName);
				   String mailingZipcode = rs.getString("MAILING_ZIP_CD");
				   gpsData.put("First Name", firstName);
				   String mailingState = rs.getString("MAILING_STATE_CD");
				   gpsData.put("First Name", mailingState);
				   String mailingCity = rs.getString("MAILING_CITY");
				   gpsData.put("First Name", mailingCity);
				   String mailingAddress2 = rs.getString("MAILING_ADDRESS_LINE_2");
				   gpsData.put("First Name", mailingAddress2);
				   String mailingAddress1 = rs.getString("MAILING_ADDRESS_LINE_1");
				   gpsData.put("First Name", mailingAddress1);
				   String doB = rs.getString("DATE_OF_BIRTH");
				   gpsData.put("First Name", doB);
				   String gender = rs.getString("GENDER");
				   gpsData.put("First Name", gender);
				   String address1 = rs.getString("ADDRESS_LINE_1");
				   gpsData.put("First Name", address1);
				   String address2 = rs.getString("ADDRESS_LINE_2");
				   gpsData.put("First Name", address2);
				    String zipCode = rs.getString("ZIP_CD");
				   gpsData.put("First Name", zipCode );
				   String state = rs.getString("STATE_CD");
				   gpsData.put("First Name", state);
				   String city = rs.getString("CITY");
				   gpsData.put("First Name", city);
					String dayTimePhoneNumber = rs.getString("DAYTIME_PHONE_NUM");
				   gpsData.put("First Name", dayTimePhoneNumber);
				  String eveningTimePhoneNumber = rs.getString("EVENING_PHONE_NUM");
				   gpsData.put("First Name", eveningTimePhoneNumber); 	
			 	String medicareNumber = rs.getString("MEDICARE_NUMBER");
				   gpsData.put("First Name", medicareNumber); 
				    String partAEffectiveDate = rs.getString("MEDICARE_PART_A_EFFECTIVE_DATE");
				   gpsData.put("First Name", partAEffectiveDate); 
				    String partBEffectiveDate = rs.getString("MEDICARE_PART_B_EFFECTIVE_DATE");
				   gpsData.put("First Name", partBEffectiveDate); 
				    String healthInsurance= rs.getString("DO_YOU_HAVE_OTHER_HEALTH_INS");
				   gpsData.put("First Name", healthInsurance); 
				    String healthInsuranceName = rs.getString("OTHER_HEALTH_INSURANCE_NAME");
				   gpsData.put("First Name", healthInsuranceName); 
				    String healthInsuranceGroupName = rs.getString("OTHER_HEALTH_INSURANCE_GRP_NUM");
				   gpsData.put("First Name", healthInsuranceGroupName); 
				    String healthInsuranceID  = rs.getString("OTHER_HEALTH_INSURANCE_ID");
				   gpsData.put("First Name", healthInsuranceID); 
				    String secondaryCoverageName = rs.getString("SECONDARY_RX_COVERAGE_NAME");
				   gpsData.put("First Name", secondaryCoverageName); 
				    String otherCoverageName = rs.getString("OTHER_RX_COVERAGE_NAME");
				   gpsData.put("First Name", otherCoverageName); 
				     String secondaryGroup = rs.getString("SECONDARY_RX_GROUP");
				   gpsData.put("First Name", secondaryGroup); 
				    String secondaryId = rs.getString("SECONDARY_RX_ID");
				   gpsData.put("First Name", secondaryId); 
				     String note = rs.getString("NOTE");
				   gpsData.put("First Name", note); 
				    String effectiveDate = rs.getString("REQUESTED_EFFECTIVE_DATE");
				   gpsData.put("First Name", effectiveDate); 
				   String pcpNumber = rs.getString("PRIMARY_CARE_PHYSICIAN_NUMBER");
				   gpsData.put("First Name", pcpNumber); 
				     String pcpName = rs.getString("PRIMARY_CARE_PHYSICIAN");
				   gpsData.put("First Name", pcpName); 
				    String dentalPlatinum = rs.getString("DENTAL_PLATINUM");
				   gpsData.put("First Name", dentalPlatinum);    

				     * *///----prashant
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
			 connection = DriverManager.getConnection(CommonConstants.CONNECTION_URL);
			 if(connection!=null) {
				 System.out.println("Connection successful.");
			 }
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return connection;
		}	
	
	public boolean validate_GPS_for_Plantype(Map<String,String> map) {
		boolean flag = false;
		String confirmation_no = confirmationNumber.getText();
		 System.out.println("OLE confirmation number is  " +confirmation_no);
		//map.put("Confirmation No", confirmation_no);---Prashant
		Map<String,String> gpsdatamap = retrieve_GPS_data(confirmation_no);
		if(map.equals(gpsdatamap)) {
			flag = true;
		} else {
			Map <String, String> matched = new HashMap<>();
			Map <String, String> mismatched = new HashMap<>();
			for (String keySource : map.keySet()) {
				String strSource = map.get(keySource);
			    if (gpsdatamap.containsKey(keySource)) { // keys match
			    	String strTarget = gpsdatamap.get(keySource);
			        if (strSource.equals(strTarget)) { // values match
			            matched.put(keySource, strSource);
			        } else { // values don't match
			            mismatched.put(keySource, strSource);
			        }
			}
			}

			// print out matched
			System.out.println("Matched values in OLE GPS");
			System.out.println("============");  
			System.out.println("Key\tValue");
			System.out.println("============");
			for (String key : matched.keySet()) {
				String matchedValue = key + "\t" + matched.get(key).toString();
			    System.out.println(matchedValue);
			  Assert.assertTrue(matchedValue, flag);
			}

			// print out mismatched
			System.out.println();
			System.out.println("Mismatched values in OLE GPS");
			System.out.println("============");
			System.out.println("Key\tValue");
			System.out.println("============");
			for (String key : mismatched.keySet()) {
				String mismatchedValue = key + "\t" + mismatched.get(key).toString();
			    System.out.println(mismatchedValue);
			  Assert.assertTrue(mismatchedValue, flag);
			}
		}
		return flag;
	}
	
	
	public String converttogpsDate(String intputDate) {
		String date = intputDate.substring(2, 4);
		String month = intputDate.substring(0, 2);;
		String year = intputDate.substring(4,8);
		String outputDate= year+"-"+month+"-"+date; 
		System.out.println("Output Date====================== "+outputDate);
		return outputDate;	
	}
}
	