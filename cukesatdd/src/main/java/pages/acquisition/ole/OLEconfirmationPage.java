/**
 * 
 */
package pages.acquisition.ole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
/*
 * public ArrayList<String> validate_GPS_for_Plantype(String planName) {
 * 
 * String connectionUrl = "jdbc:sqlserver://120.130.10.2:1433;" +
 * "database=GPSST04SVC_TRN;" + "user=qaread;" + "password=testreadonly;" +
 * "encrypt=true;" + "trustServerCertificate=false;" + "loginTimeout=30;";
 * 
 * try (Connection connection = DriverManager.getConnection(connectionUrl);) {
 * 
 * System.out.println("Connection successful."); }
 * 
 * catch (SQLException e) { e.printStackTrace(); } // return OLEDataGPS; }
 * 
 * public void setMap(Map<String, ArrayList<String>> dataMap) {
 * 
 * this.dataMap = dataMap;
 * 
 * }
 * 
 * public Map<String, ArrayList<String>> getMap(){ return dataMap;
 * 
 * } }
 */ 
	public void validate_GPS_for_Plantype(String[] args) {
	 String connectionUrl =
             "jdbc:sqlserver://120.130.10.2:1433;"
                     + "database=GPSST04SVC_TRN;"
                     + "user=qaread;"
                     + "password=testreadonly;"
                     + "encrypt=true;"
                     + "trustServerCertificate=false;"
                     + "loginTimeout=30;";

     try (Connection connection = DriverManager.getConnection(connectionUrl);) {
         
     	System.out.println("Connection successful.");
     }
     
     catch (SQLException e) {
         e.printStackTrace();
     }
 }
}
	