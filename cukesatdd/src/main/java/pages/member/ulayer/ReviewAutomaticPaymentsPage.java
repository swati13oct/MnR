package pages.member.ulayer;


	import org.json.JSONException;
	import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import acceptancetests.atdd.data.CommonConstants;
	import acceptancetests.atdd.data.PageData;
	import acceptancetests.atdd.util.CommonUtility;
	import atdd.framework.UhcDriver;

	/**
	 * @author tpravee2
	 *
	 */
	public class ReviewAutomaticPaymentsPage extends UhcDriver{
		
	
			
		@FindBy(xpath="//div[@id='atdd_reviewonetime_label']/div[4]/div[2]/span")
		private WebElement routingNumber;
		
		/*@FindBy(xpath="html/body/div[2]/div/div/div/div/div/div/div[2]/div[3]/div/div/div/button[1]") 
		private WebElement AutomaticPaymentReviewSubmitbtn; */
		
		@FindBy(xpath="html/body/div[3]/div/div/div/div/div[2]/div[3]/div/div/div/button[1]") 
		private WebElement AutomaticPaymentReviewSubmitbtn;
		
		@FindBy(id ="termError")
		private WebElement AutomaticPaymentelectronicSignatureCheck;
		
		@FindBy(xpath="html/body/div[2]/div/div/div[2]/div[3]/div/div/div/button[1]") 
		private WebElement BacktoPaymentHistoryButton; 
		
		@FindBy(xpath ="html/body/div[2]/div/div/div/div/div/div/div[2]/div[3]/div/div/div/button[2]")
		private WebElement ViewPDFLink;
		
		private PageData reviewAutomatic;
		
		public JSONObject reviewAutomaticJson;
		
		
		public ReviewAutomaticPaymentsPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
		}
		
		/*public AutomaticPaymentSuccessPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
			openAndValidate();
		}*/
		
		public AutomaticPaymentSubmittedPage navigatetoPaymentSubmittedPage() throws InterruptedException{
			Thread.sleep(5000);
			AutomaticPaymentelectronicSignatureCheck.click();
			System.out.println("Legal checkbox checked");
			Thread.sleep(2000);
			AutomaticPaymentReviewSubmitbtn.click();
			System.out.println("Submit button clicked");			
			System.out.println("Navigated to Automatic Payment submitted page");
			Thread.sleep(2000);
			if(driver.getTitle().equalsIgnoreCase("Member Claims") || driver.getTitle().equalsIgnoreCase("eftpayments")){
				return new AutomaticPaymentSubmittedPage(driver);
			}
			return null;		
		}
		
		public ReviewAutomaticPaymentsPage navigatetoPaymentHistoryDashboard(){
			BacktoPaymentHistoryButton.click();			
			System.out.println("Navigated to Payment History page from Payment submitted page");
			if(driver.findElement(By.xpath("//*[@id='paymentHistoryApp']/div/div/div/div/h1")).getText().contains("Payment History")){
				return new ReviewAutomaticPaymentsPage(driver);
			}
			return null;		
		}
		
		public AutomaticPaymentSubmittedPage ValidatePDFLink()
		{
			if(ViewPDFLink.isEnabled()){
				ViewPDFLink.click();
				return new AutomaticPaymentSubmittedPage(driver);
			}
			return null;
		}


		@Override
		public void openAndValidate() {
			validate(routingNumber);
		}

		
		public JSONObject reviewAutomaticValues() {
			String fileName = CommonConstants.REVIEW_AUTOMATIC_PAGE_DATA;
			reviewAutomatic = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);

			JSONObject jsonObject = new JSONObject();
			for (String key : reviewAutomatic.getExpectedData().keySet()) {
				WebElement element = findElement(reviewAutomatic.getExpectedData().get(key));
				if (element != null) {
					if (validate(element)) {
						try {
							jsonObject.put(key, element.getText());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			reviewAutomaticJson = jsonObject;

			return reviewAutomaticJson;
		}

	}
