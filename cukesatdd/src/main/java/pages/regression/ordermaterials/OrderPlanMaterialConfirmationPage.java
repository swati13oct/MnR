/**
 * 
 */
package pages.regression.ordermaterials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class OrderPlanMaterialConfirmationPage extends UhcDriver {
	
	@FindBy(xpath = "//*[contains(text() 'We value your feedback')]")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//*[@id = 'closeButton']")
	private WebElement iPerceptionClose;
	
	@FindBy(id ="disclosure_link")
	private WebElement logOut;
	
	@FindBy(id="additionalMaterialsText")
	private WebElement addordermaterialLink;

	
	public OrderPlanMaterialConfirmationPage(WebDriver driver){
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

	public OrderMaterialsPage navigateToValidateOrderConfirmationInRedesignPage() throws InterruptedException {
		Thread.sleep(5000);
		try{
			if(validate(iPerceptionPopUp)){
				System.out.println("FeedBack Modal Present");

				iPerceptionClose.click();
				if (validate(iPerceptionPopUp)){
					System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
				}
				else
					System.out.println("FeedBack Modal Closed");
			}
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");

		}

		addordermaterialLink.click();
		Thread.sleep(3000);
		if(driver.getTitle().equalsIgnoreCase("Order Plan Materials")){
			return new OrderMaterialsPage(driver);
		}
	
		return null;
	}


	@Override
	public void openAndValidate() {
		
		validate(addordermaterialLink);
	}

	public boolean ValidateCSRErrorMessage(String cSR_Error) {
		WebElement CSR_OrderConfirm_Error = driver.findElement(By.xpath("//*[contains(text(), '"+cSR_Error+"')]"));
		if(validate(CSR_OrderConfirm_Error)){
			System.out.println("CSR error message is Displayed for Order Submission in Member Auth");
			return true;
		}
		else
			System.out.println("CSR error message is NOT Displayed for Order Submission in Member Auth");

		return false;
	}

}
