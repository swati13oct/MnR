/**
 * 
 */
package pages.acquisition.ulayer;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PharmacyResultPage extends UhcDriver{
	
	@FindBy(id = "currentRowObject")
	private WebElement pharmacyResults;
	
	@FindBy(id ="disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath = "//h1")
    private WebElement pharmacySearchResultsHeading;

    @FindBy(xpath = "//h4")
    private WebElement pharmacyForPlanHeading;

    @FindBy(css = "h2.h4.color-blue.medium.pharmacy-count")
    private WebElement pharmacySearchResultsText;
    
    @FindBy(xpath="//ul[@class='pharmacy-list']//p[contains(text(),'Saver')][1]")
    private WebElement pharmacySaverService;
    
    @FindBy(xpath="//ul[@class='pharmacy-list']//li[1]//p[contains(text(),'Standard')][1]")
    private WebElement standardNetworkService;
    
    @FindBy(css = "table#searchResultsTable tbody div#pharmacyservices li:first-child")
    private WebElement firstPharmacyService;

    @FindBy(css = "//table[@id='searchResultsTable']//tbody//td[1]/div/div")
    private WebElement firstPharmacyServiceBalloonColour;
	
	public JSONObject pharmacyResultJson;
	
	private PageData pharmacyResult;
	
	public PharmacyResultPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PHARMACY_RESULT_PAGE_DATA;
		pharmacyResult = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	   }

	@Override
	public void openAndValidate() {

		Assert.assertTrue(pharmacySearchResultsHeading.isDisplayed());
	}
	
	 public void validatePharmacySearchResults() {
		waitforElement(pharmacySearchResultsText);
		Assert.assertTrue("Pharmacies found", pharmacySearchResultsText.getText().contains("Pharmacies Found"));
	    }
	    
	    public void validatePharmacySaverInResults() {
	    	waitforElement(pharmacySaverService);
	    	Assert.assertTrue("Pharmacies Saver validation", pharmacySaverService.getText().contains("Pharmacy Saver"));
	        }
	
	    public void validateStandardNetworkInResults() {
	    	waitforElement(standardNetworkService);
	    	Assert.assertTrue("Standard Network validation", standardNetworkService.getText().contains("Standard Network Pharmacy"));
	        }
	    
	    public void validatePharmacyServiceAndBalloonColour(String serviceName, String balloonColour) {
		Assert.assertEquals(serviceName, firstPharmacyService.getText());
		Assert.assertEquals(balloonColour, firstPharmacyServiceBalloonColour.getAttribute("class"));
	
	    }
}
