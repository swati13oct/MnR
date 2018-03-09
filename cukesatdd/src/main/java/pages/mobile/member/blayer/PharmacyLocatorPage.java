package pages.mobile.member.blayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstantsMobile;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author Bhaji Shaik
 *
 */
public class PharmacyLocatorPage extends UhcDriver {
	
	@FindBy(id = "menuopen")
	private WebElement menuButton;

	@FindBy(id="siteback")
	private WebElement back;
	
	@FindBy(xpath = "//*[@id='sitemenu']/div[2]/a[5]")
	private WebElement logout;
	
	@FindBy(xpath = "//*[@id='wrapper']/div[1]/div[3]/div/div/div[1]/h1")
	private WebElement pharmacyLocatorText;
	
	@FindBy(css="div.pharmacy_standard_type")
	private WebElement txtStandardPharmacy;
	
	@FindBy(css="div.pharmacy_preferred_type")
	private WebElement colourPharmacySaver;
	
	@FindBy(css="div.pharmacy_preferred_type:nth-child(1)")
	private WebElement colourPreferredRetailPharmacy;
	
	@FindBy(css="div.pharmacy_preferred_type>span")
	private WebElement txtPharmacySaver;
	
	@FindBy(css="div.pharmacy_preferred_type:nth-child(1)>span")
	private WebElement txtPreferredRetailPharmacy;
	
	@FindBy(css="div.list_view_elements>div:first-child>div:nth-child(2)>span:first-child")
	private WebElement txtFirstPharmacyResult;
	
	@FindBy(css="div.list_view_elements>div:first-child")
	private WebElement firstPharmacyResult;
	
	@FindBy(css="div.pharmacy_details_page>div:nth-child(2)>div:first-child")
	private WebElement txtPharmacyResult;
	

	
	public static final String STANDARD_PHARMACY_COLOUR ="Blue";
	
	public static final String PHARMACY_SAVER_COLOUR ="Red";
	
	public static final String PREFERRED_PHARMACY_COLOUR ="Red";
	
	public static final String TEXT_STANDARD_PHARMACY ="Standard Network Pharmacy";
	
	public static final String TEXT_PHARMACY_SAVER ="Pharmacy Saver™ Program";
	
	public static final String TEXT_PREFERRED_PHARMACY ="Preferred Retail Pharmacy Network";

	private PageData browserCheckData;

	private JSONObject browserCheckJson;

	public PharmacyLocatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// start(PAGE_URL);
		validate(pharmacyLocatorText);

	}
	
	public void logout()
	{
		menuButton.click();
		if(validate(logout))
		{
			logout.click();
		}
		else
		{
			System.out.println("logout button not found on page");
		}
	}

	public JSONObject getBrowserCheck() {

		String fileName = CommonConstantsMobile.MOBILE_BROWSER_CHECK_DATA_BLUELAYER;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstantsMobile.PAGE_OBJECT_DIRECTORY_MOBILE_BLUELAYER_MEMBER);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
					.get(key));
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
		browserCheckJson = jsonObject;

		return browserCheckJson;

	}
	
	
	/**
	 * This method gives the colour based on the rgb colour coding
	 * @param colour
	 * @return
	 */
	public String getColour(String colour){
		
		if(colour.toLowerCase().equals("rgb(229, 115, 115)")){
			return "Red";
		}
		else if(colour.toLowerCase().equals("rgb(3, 169, 244)")){
			return "Blue";
		}else{
			return "";
		}
		/*switch (colour.toLowerCase()) {
		case "rgb(229, 115, 115)":
			return "Red";
		case "rgb(3, 169, 244)":
			return "Blue";
		default:
			break;
		}*/
	}
	
	/**
	 * This method validates the pharmacy saver text and colour
	 */
	public void validatePharmacySaverPharmacy(){
		
		String colorRGB = ((JavascriptExecutor)driver)
		        .executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');",colourPharmacySaver).toString();
		System.out.println("PHARMACY_SAVER_COLOUR = "+colorRGB);
		Assert.assertEquals(PHARMACY_SAVER_COLOUR, getColour(colorRGB));
		Assert.assertEquals(TEXT_PHARMACY_SAVER, txtPharmacySaver.getText());
	}
	/**
	 * This method validates the standard network pharmacy text and colour
	 */
	public void validateStandardNetworkPharmacy(){
		
		String colorRGB = ((JavascriptExecutor)driver)
		        .executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');",txtStandardPharmacy).toString();
		System.out.println("STANDARD_PHARMACY_COLOUR = "+colorRGB);
		Assert.assertEquals(STANDARD_PHARMACY_COLOUR, getColour(colorRGB));
		Assert.assertEquals(TEXT_STANDARD_PHARMACY, txtStandardPharmacy.getText());
	}
	
	/**
	 * This method validates the preferred pharmacy network text and colour
	 */
	public void validatePreferredPharmacyNetwork(){
		
		String colorRGB = ((JavascriptExecutor)driver)
		        .executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');",colourPreferredRetailPharmacy).toString();
		System.out.println("PREFERRED_PHARMACY_COLOUR = "+colorRGB);
		Assert.assertEquals(PREFERRED_PHARMACY_COLOUR, getColour(colorRGB));
		Assert.assertEquals(TEXT_PREFERRED_PHARMACY, txtPreferredRetailPharmacy.getText());
	}
	
	/**
	 * This method navigates to first pharmacy result and validates the pharmacy result and 
	 * gets back and also validates the Standard network pharmacy/Pharmacy Saver/Preferred Pharmacy Network 
	 */
	public void firstPharmacyResult(){
		String expectedFirstPharmacyResultText = txtFirstPharmacyResult.getText();
		firstPharmacyResult.click();
		String actualFirstPharmacyResultText = txtPharmacyResult.getText();
		Assert.assertEquals(expectedFirstPharmacyResultText, actualFirstPharmacyResultText);
		back.click();
		validateStandardNetworkPharmacy();
		//validatePharmacySaverPharmacy();
		validatePreferredPharmacyNetwork();
	}
	

}
