/**
 * 
 */
package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PharmacySearchPage extends UhcDriver{

	@FindBy(id = "zipCode")
	private WebElement zipcodeField;

	@FindBy(id = "showresults")
	private WebElement distanceField;

	@FindBy(id = "continue")
	private WebElement continueField;

	@FindBy(id = "selectcounty_box")
	private WebElement countyPopOut;

	@FindBy(id = "selectcountytable")
	private WebElement selectcountytable;

	@FindBy(id = "plan")
	private WebElement planNameDropDown;
	
	@FindBy(xpath ="//select[@id='plan']/option")
	private List<WebElement> planNameDropDownList;

	@FindBy(id = "find_searchbtn")
	private WebElement searchPharmaciesButton;

	@FindBy(id = "pharm_services")
	private WebElement pharmacyTypes;

	@FindBy(id = "services")
	private WebElement pharmacyTypeSelectionRadioButton;

	@FindBy(id = "planyear")
	private WebElement planYearDropDown;

	@FindBy(xpath = "//*[@id='pharm_services']/li[1]")
	private WebElement pharmacyTypeActual;

	@FindBy(xpath = "//ul[@id='pharm_services']/li/span")
	private WebElement toolTip;

	public PharmacySearchPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PharmacySearchPage enterDistanceDetails(String distance) {

		distanceField.click();
		distanceField.sendKeys(distance);

		continueField.click();
		CommonUtility.checkPageIsReady(driver);
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | Pharmacy Directory"))
		{
			return new PharmacySearchPage(driver);
		}
		return null;

		/*	if(countyPopOut.isDisplayed())
		{
			String county  = zipAttributesMap.get("County");
			List<WebElement> countyList =  selectcountytable.findElements(By.tagName("tr"));

		    for (WebElement webElement : countyList) {
		    	if(webElement.getText().contains(county))
		    	{
		    		webElement.click();
		    		break;
		    	}
			}
		}*/

	}

	public PharmacySearchPage selectsPlanName(String planName) {

	/*	planNameDropDown.click();
		planNameDropDown.sendKeys(planName);
		planNameDropDown.click();
		*/
		selectFromDropDown(planNameDropDownList, planName);
		
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | Pharmacy Directory"))
		{
			return new PharmacySearchPage(driver);
		}
		return null;

	}

	public PharmacySearchPage selectTheReqPlan(String planName){
		Select planDropDown = new Select(planNameDropDown);		
		planDropDown.selectByValue(planName);
		return new PharmacySearchPage(driver);
	}

	public PharmacyResultPage searchesPharmacy() {

		searchPharmaciesButton.click();
		CommonUtility.checkPageIsReady(driver);
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | Pharmacy Directory"))
		{
			return new PharmacyResultPage(driver);
		}
		return null;

	}

	public PharmacySearchPage selectsPharmacy(
			String givenPharmacyTypes) {


		String[] pharmacyTypeArray = givenPharmacyTypes.split(",");
		CommonUtility.checkPageIsReady(driver);
		pharmacyTypeSelectionRadioButton.click();

		List<WebElement> pharmacyTypesCheckboxes = pharmacyTypes.findElements(By.tagName("li"));
		for(String pharmacyType : pharmacyTypeArray )
		{
			for(WebElement checkBox : pharmacyTypesCheckboxes)
			{
				checkBox.getText();
				System.out.println(""+checkBox.getText());
				if(checkBox.getText().equalsIgnoreCase(pharmacyType))
				{
					checkBox.findElement(By.id("pharmacyTypesCheckboxes")).click();
				}
			}
		}
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | Pharmacy Directory"))
		{
			return new PharmacySearchPage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		validate(zipcodeField);
		validate(distanceField);
		validate(continueField);
		validate(planNameDropDown);
		validate(searchPharmaciesButton);	
	}

	public PharmacySearchPage enterZipDistanceDetails(
			Map<String, String> zipAttributesMap) {

		String zipcode = zipAttributesMap.get("Zip Code");
		String distance = zipAttributesMap.get("Distance");

		sendkeys(zipcodeField,zipcode);

		distanceField.click();
		distanceField.sendKeys(distance);

		continueField.click();
		CommonUtility.checkPageIsReady(driver);

		if(countyPopOut.isDisplayed())
		{
			String county  = zipAttributesMap.get("County");
			List<WebElement> countyList =  selectcountytable.findElements(By.tagName("tr"));

			for (WebElement webElement : countyList) {
				if(webElement.getText().contains(county))
				{
					webElement.click();
					break;
				}
			}
		}
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | Pharmacy Directory")) // TODO
		{
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public PharmacySearchPage selectYear(String year) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select dropDown = new Select(planYearDropDown);		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dropDown.selectByValue(year);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		continueField.click();
		return new PharmacySearchPage(driver);

	}

	public PharmacySearchPage hoverOverToolTip(String pharmacyType) {
		String pharmacyTypeText = pharmacyTypeActual.getText().trim();
		//if(pharmacyTypeActual.equals(pharmacyType)){
			toolTip.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			System.out.println("Hovered over the tooltip");
		//}
		//else{
			//System.out.println("Pharmacy type mismatch. Expected----->"+pharmacyType+"----But got----->"+pharmacyTypeText);
		//}
		return new PharmacySearchPage(driver);
	}

}
