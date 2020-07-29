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
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class OLEconfirmationPage extends UhcDriver{
	
	@FindBy(xpath = "//*[contains(@class,'confirmation-number')]")
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
	
	@FindBy(xpath = "//*[contains(@class,'confirmation-number')]")
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
	private ArrayList<String> stringList;
	private Map<String, ArrayList<String>> dataMap;

	public boolean validate_plan_details(Map<String, String> planDetailsMap) {
		
		String Expected_PlanName = planDetailsMap.get("Plan Name");
		String Expected_PlanYear = planDetailsMap.get("Plan Year");
		String Expected_ZipCode = planDetailsMap.get("Zip Code");
		String Expected_County = planDetailsMap.get("County");
		String Expected_PlanPremium = planDetailsMap.get("Plan Premium");
		String Expected_ConfirmationNumber = planDetailsMap.get("Confirmation Number");
		boolean flag = false;
		String PlanYear_PlanName_Text = PlanYear_PlanName.getText();
		String Zip_County_Text = ZipCode_County.getText();
		String Premium = PremiumDisplay.getText();
		System.out.println("Plan Year and Plan Name Displayed on OLE : "+PlanYear_PlanName_Text);
		System.out.println("Zip Code and County Displayed on OLE : "+Zip_County_Text);
		System.out.println("Monthly Premium for Plan Displayed on OLE : "+Premium);
		System.out.println("Confirmation Number is Displayed on OLE : "+Expected_ConfirmationNumber);

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

  public Map<String, String> retrieve_GPS_data(String confirmationNumber) {
	  	   Connection connection = createDataBaseConnection();
		   ResultSet rs = null;
		   Statement stmt = null;
		   Map<String, String> gpsData = new HashMap<String, String>();
		   try {
			   stmt = connection.createStatement();
			  rs = stmt.executeQuery(CommonConstants.GPS_QUERY_1 + confirmationNumber );
			   while(rs.next()) {
				   String firstName = rs.getString("FIRST_NAME");
				   gpsData.put("First Name", firstName);
				   //String middleInitial = rs.getString("MIDDLE_INITIAL");---Prashant
				   //gpsData.put("MiddleInitial", middleInitial);---Prashant
				   String lastName = rs.getString("LAST_NAME");
				   gpsData.put("Last Name", lastName);
				   //add for all the gps columns
				   //String confirmationNumber = rs.getString("XEROX_STAGE_ID");--Prashant
				   //gpsData.put("Confirmation No", confirmationNumber);----Prashant
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
		//map.put("Confirmation No", confirmation_no);---Prashant
		Map<String,String> gpsdatamap = retrieve_GPS_data(confirmation_no);
		if(map.equals(gpsdatamap)) {
			flag = true;
		}
		return flag;
	}
 }
	
	
	

	