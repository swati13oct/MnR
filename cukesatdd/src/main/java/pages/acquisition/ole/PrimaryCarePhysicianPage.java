/**
 * 
 */
package pages.acquisition.ole;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class PrimaryCarePhysicianPage extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-prelim')]")
	private WebElement PCPPageHeader;

	//Right Rail Elements

	@FindBy(xpath = "//*[@id='learn-more-ole']/a")
	private WebElement RightRail_LearnMoreLink;
	
	@FindBy(id = "tty-number")
	private WebElement RightRailTFN;
	
	@FindBy(xpath = "//*[@id='ole-plan-name']")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[@id='ole-zip']")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[@id='ole-premium']")
	private WebElement PremiumDisplay;
	
	
	// Look up Provider - MA, MAPD and DSNP - NonPFFS
	
	@FindBy(xpath = "//button[contains(text(), 'Look up your provider')]")
	private WebElement LookUpProviderBtn;
	
	//Rally - ProviderLookup
	
	@FindBy(xpath = "//*[contains(text(),'All Primary Care')]")
	private WebElement SelectPCPLink;

	@FindBy(xpath = "//span[@class='pcp']//button")
	private List <WebElement> AssinPCPLinks;

	@FindBy(xpath = ".//*[@id='label_selectedLocation0_acceptingExistingPatientsOnly' or @id = 'label_selectedLocation0_accepting']")
	private WebElement SelectPCPAddress;
	
	@FindBy(xpath = "//span[contains(text(), 'Continue')]//..")
	private WebElement SelectPCPContinueBtn;
	
	@FindBy(xpath = "//*[@id='label_selectedMedicalGroup0']")
	private WebElement SelectMedicalGrp;

	@FindBy(xpath = "//*[contains(text(), 'Continue')]")
	private WebElement MedicalGrpContinueBtn;

	@FindBy(xpath = "//*[contains(@class,'assign-pcp-btn')]")
	private WebElement AddProvider;

	@FindBy(xpath = "//*[@class='provider-name pcp']")
	private WebElement ProviderName;
	
	//PCP Page - PCP information display
	@FindBy(xpath = "//*[@id = 'pcpFullName']//preceding-sibling::*[contains(@class, 'provider-info__data')]")
	private WebElement ProviderNameDisplay_PCPpage;

	@FindBy(xpath = "//*[contains(text(), 'Are you now seeing or have you recently seen this doctor?')]")
	private WebElement CurrentPCP_Question;
	
	@FindBy(id = "hasCurrentPatientOfPcpYes")
	private WebElement CurrentPCP_Question_Yes;

	@FindBy(id = "hasCurrentPatientOfPcpNo")
	private WebElement CurrentPCP_Question_No;

	//Provider Contact Information Section - PFFS plans Only
	@FindBy(xpath = "//*[contains(text(), 'Provider Contact Information')]")
	private WebElement ProviderINfoHeader;

	//Doctor INfo section 1

	@FindBy(id = "doctorsFullName1")
	private WebElement Doctor1_Name;
	
	@FindBy(id = "phoneNo1")
	private WebElement Doctor1_Ph;
	
	@FindBy(id = "city1")
	private WebElement Doctor1_City;
	
	@FindBy(id = "state1")
	private WebElement Doctor1_State;
	
	@FindBy(id = "zip1")
	private WebElement Doctor1_Zip;

	//Doctor INfo section 2

	@FindBy(id = "doctorsFullName2")
	private WebElement Doctor2_Name;
	
	@FindBy(id = "phoneNo2")
	private WebElement Doctor2_Ph;
	
	@FindBy(id = "city2")
	private WebElement Doctor2_City;
	
	@FindBy(id = "state2")
	private WebElement Doctor2_State;
	
	@FindBy(id = "zip2")
	private WebElement Doctor2_Zip;
	
	//Hospital INfo section 2

	@FindBy(id = "hsptlname")
	private WebElement Hospital_Name;
	
	@FindBy(id = "hsptlPhno")
	private WebElement Hospital_Ph;
	
	@FindBy(id = "hsptlCity")
	private WebElement Hospital_City;
	
	@FindBy(id = "state")
	private WebElement Hospital_State;
	
	@FindBy(id = "hsptlZip")
	private WebElement Hospital_Zip;
	
	@FindBy(xpath = "//*[contains(@name,'primary-search')]")
	private WebElement filterBtn;

	public PrimaryCarePhysicianPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		validateNew(PCPPageHeader);
		System.out.println("Page header is Displayed"+PCPPageHeader.getText());	
	}

	public boolean validate_provider_contact_info_in_PCP() {
		boolean validation_Flag;
		if(validate(ProviderINfoHeader) && validate(Doctor1_Name) && validate(Doctor1_Ph) && validate(Doctor1_City) && validate(Doctor1_State) && validate(Doctor1_Zip)
				 && validate(Doctor2_Name) && validate(Doctor2_Ph) && validate(Doctor2_City) && validate(Doctor2_State) && validate(Doctor2_Zip)
				 && validate(Hospital_Name) && validate(Hospital_Ph) && validate(Hospital_City) && validate(Hospital_State) && validate(Hospital_Zip)){
			System.out.println("Provider Contact Information Section - Displayed for PFFS plans");
			 validation_Flag = true;
		}
		else
			validation_Flag = false;
		return validation_Flag;
	}
	public boolean validate_provider_Lookup(String planType) {
		boolean validation_Flag = true;
		if(validate(LookUpProviderBtn)){
			String PCPWindow = driver.getWindowHandle();
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", LookUpProviderBtn);
			//LookUpProviderBtn.click();
			//driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			
			String CurrentURL = driver.getCurrentUrl();
			System.out.println("Currnt URL - "+CurrentURL);
			if(CurrentURL.contains("post-error")){
				System.out.println("Provider look Up Button CLicked - Rally Provider Look up Error Page is displayed for Plan Type : "+planType);
				if(planType.contains("SNP")){
					driver.close();
					driver.switchTo().window(PCPWindow);
					CurrentURL = driver.getCurrentUrl();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Currnt URL - "+CurrentURL);
					if(CurrentURL.contains("provider-search")){
						validation_Flag = true;
						System.out.println("DSNP plan : Returned to PCP page");
					}
					else{
						validation_Flag = false;
						System.out.println("DSNP plan : Returned to PCP page : FAILED");
					}
				}
			}
			else if(CurrentURL.contains("find-pcp")){
				
				//if(!planType.contains("SNP")){
					if(validate(SelectPCPLink)){
						System.out.println("PCP selection is Displayed in Rally Page : Selecting PCP");
						SelectPCPLink.click();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						validateNew(filterBtn);
			
						if (AssinPCPLinks.size()>0){
						System.out.println("No of PCPs are Displayed : "+AssinPCPLinks.size());
						}
						WebElement firstPCP = AssinPCPLinks.get(0);
						scrollToView(firstPCP);
						jsClickNew(firstPCP);
						CommonUtility.waitForPageLoadNew(driver,SelectPCPAddress, 30);
						//firstPCP.click();
						SelectPCPAddress.click();
						executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", SelectPCPContinueBtn);

						//SelectPCPContinueBtn.click();
						try {
							Thread.sleep(2000);
							if(validate(SelectMedicalGrp)){
								SelectMedicalGrp.click();
								executor = (JavascriptExecutor)driver;
								executor.executeScript("arguments[0].click();", MedicalGrpContinueBtn);

							}

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String PCPname = ProviderName.getText();
						executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", AddProvider);

						//AddProvider.click();
						System.out.println("PCP selected : "+PCPname);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						driver.switchTo().window(PCPWindow);
						if(driver.getCurrentUrl().contains("provider-search")){
							System.out.println("OLE PCP Page is displayed : Provider Look up is Complete");
							waitforElement(ProviderNameDisplay_PCPpage);
							String ProviderNameDisplay = ProviderNameDisplay_PCPpage.getText();
							if(PCPname.contains(ProviderNameDisplay)
									&& validate(CurrentPCP_Question_Yes) && validate(CurrentPCP_Question_No)){
								System.out.println("PCP Name is Displayed"+ProviderNameDisplay);
								System.out.println("PCP Question and OPtions are Displayed");
								validation_Flag = true;
							}
						}
					}
					else{
						System.out.println("Rally Provider Lookup page is not displayed");
						validation_Flag = false; 
					}
			}
			}
			else{
				System.out.println("Rally Provider Lookup page is not displayed");
				validation_Flag = false; 
			}
	/*
		else{
			System.out.println("Provider Look Up button is not displaye");
			validation_Flag = false;
		}*/
		return validation_Flag;
	
	}

	public PlanPremiumPage navigate_to_Plan_Premium_Page() {

		validateNew(NextBtn);
		jsClickNew(NextBtn);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);
		*/
		if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Plan Premium')]")))){
			System.out.println("OLE Monthly Plan Premium Page is Displayed");
			return new PlanPremiumPage(driver);
		}
		else{
			System.out.println("OLE Monthly Plan Premium Page is Not Displayed");
			return null;
		}
	}

}