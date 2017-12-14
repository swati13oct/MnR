package pages.acquisition.uhcretiree;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author eb
 *
 */

public class PharmacyResultsPage extends UhcDriver {

	@Override
	public void openAndValidate() {

		validate(pharmacyLocatorHeading);
	}
	
	@FindBy(css="h1.titleLeft")
	private WebElement pharmacyLocatorHeading;
	
	@FindBy(css="div#medicareTitle>h1")
	private WebElement pharmacyResultsHeading;
	
	@FindBy(css="#medicareTitle>h4:nth-child(3)")
	private WebElement pharmaciesZipcodeHeader;
	
	@FindBy(css=".pub_mid>p")
	private WebElement standardNetworkPharmacy;
	
	@FindBy(css=".pub_mid>p")
	private WebElement pharmacySaver;
	
	@FindBy(css=".pub_mid>p>img")
	private WebElement blueballonImage;
	
	@FindAll(@FindBy(how = How.CSS, using = "div.Pharmacyresults table#currentRowObject tbody>tr"))
	List<WebElement> pharmacyResultsTable;
	
	@FindBy(css=".generate_pdf")
	private WebElement linkCreatePDF;
	
	public PharmacyResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public void validatePharmacyResults(String zipcode){
		driver.switchTo().frame(0);
		Assert.assertEquals("Pharmacies close to "+zipcode, pharmaciesZipcodeHeader.getText());
		Assert.assertTrue((pharmacyResultsTable.size() > 0));
		Assert.assertEquals(linkCreatePDF.getText().trim(), "Create PDF");
	}
	
	public void validateStandardNetworkPharmacyResults(){
		Assert.assertTrue((standardNetworkPharmacy.getText().contains("Standard Network Pharmacy")));
	}
	
	public void validatePharmacySaverPharmacyResults(){
		Assert.assertTrue((pharmacySaver.getText().contains("Pharmacy Saver")));
	}
	
}