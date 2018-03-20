/**
 * 
 */
package pages.redesign;
import java.util.List;

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
public class BenefitsAndCoveragePage extends UhcDriver {

	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;

	@FindBy(xpath = "//*[contains(text(), 'Plan Benefits Summary')]")
	private WebElement BnCPageHeader;

	@FindBy(xpath = "//*[contains(text(), 'Plan Benefits Summary')]")
	private List<WebElement> UpdatedLanguageElements;
	
	@FindBy(xpath = "(//*[contains(text(),'SHOW ON MAP')])")
	private List<WebElement> showonmap;

	
	public BenefitsAndCoveragePage(WebDriver driver) throws InterruptedException {
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

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		if(validate(BnCPageHeader)){
			System.out.println("Explanation of Benefits PAGE is LOADED");
		}
		else{
			System.out.println("Explanation of Benefits is NOT LOADED");
		}
	}

	/**
	 * @author sdwaraka
	 * To validate if Updated language is displayed or not. 
	 * @param updatedLanguage
	 * @param displayFlag
	 * @return
	 */
	public boolean Validate_Catastrophic_Stage_Language(String updatedLanguage, String displayFlag) {
		
		List <WebElement> UpdatedLanguageCount = driver.findElements(By.xpath("//*[contains(text(),'"+updatedLanguage+"')]"));
		boolean Expectedflag = (displayFlag.equalsIgnoreCase("true"))?true:false ;
		boolean ActualFlag = (UpdatedLanguageCount.size()>0)?true:false;
		if(Expectedflag ==ActualFlag  )
		{
			System.out.println("Updated Language is Displayed/Not DIsplayed as expected");
			return true;
		}
		else {
			System.out.println("Updated Language validation : Failed");
			return false;
		}
	}


}
