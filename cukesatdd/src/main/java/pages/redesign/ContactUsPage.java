/**
 * 
 */
package pages.redesign;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class ContactUsPage extends UhcDriver{
	
	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;
	
	@FindBy(xpath = "//h1[contains(text(), 'Explanation of Benefits')]")
	private WebElement ContactUsPageHeader;

	@FindBy(xpath = "//a[contains(text(), '(Terminated)')]")
	private List<WebElement> TerminatedTabs;
	
	
	
	public JSONObject contactUsJson;
	
	public ContactUsPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		
		Thread.sleep(5000);
		CommonUtility.checkPageIsReady(driver);
		try{
			FeedbackModal.click();
			System.out.println("FeedBack Modal Present");
			if (validate(FeedbackModal)){
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			System.out.println("FeedBack Modal Closed");
			//Thread.sleep(3000);
			
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");

		}

		//openAndValidate();
		
	}
	
	public boolean Validate_Single_Tab_SHIP(){
		List<WebElement> PlanTabs = driver.findElements(By.xpath("//a[contains(text(),'Supplemental  Insurance Plans')]"));
		System.out.println("No of tabs: "+PlanTabs.size());
		if(PlanTabs.size()>1){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public void openAndValidate() {
		if(validate(ContactUsPageHeader)){
			System.out.println("Explanation of Benefits PAGE is LOADED");
		}
		else{
			System.out.println("Explanation of Benefits is NOT LOADED");
		}

	}
	
	public boolean Validate_Terminated_Tab(){
		
		if(!TerminatedTabs.isEmpty()){
			System.out.println("Terminated Tabs for the following Plans are Displayed");

			for(WebElement TerminatedPlan: TerminatedTabs){
				System.out.println(TerminatedPlan.getText());
			}
			return true;
		}
		return false;
	}
}
