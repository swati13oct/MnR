/**
 * 
 */
package pages.redesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class PlanMaterialConfirmationPage extends UhcDriver {
	
	@FindBy(id ="disclosure_link")
	private WebElement logOut;
	
	@FindBy(id="additionalMaterialsText")
	private WebElement addordermaterialLink;

	
	public PlanMaterialConfirmationPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		//String fileName = CommonConstants.ORDER_PLAN_MATERIALS_PAGE_DATA;
//		planMaterials = CommonUtility.readPageData(fileName,
//				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	   }
	
	public void logOut() {
		logOut.click();
		
	}

	public OrderplanmaterialsPage navigateToValidateOrderConfirmationInRedesignPage() throws InterruptedException {
		Thread.sleep(5000);
		addordermaterialLink.click();
		Thread.sleep(3000);
		if(driver.getTitle().equalsIgnoreCase("Order Plan Materials")){
			return new OrderplanmaterialsPage(driver);
		}
	
		return null;
	}


	@Override
	public void openAndValidate() {
		
		validate(addordermaterialLink);
	}

}
