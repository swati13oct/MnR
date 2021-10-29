package pages.acquisition.pharmacyLocator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class PharmacySearchWebElementsNew extends UhcDriver {
	
	public PharmacySearchWebElementsNew(WebDriver driver) {
		   super(driver);
		   PageFactory.initElements(driver, this);
		}
	@Override
	public void openAndValidate() {
	}
    
	@FindBy(xpath="//input[@id='zip-code']")
	protected WebElement zipcodeField;
	
	@FindBy(xpath = "//h1[contains(text(), 'Pharmacy Search')]")
	protected WebElement pharmacysearchpageheader;
	
	@FindBy(xpath="//h1[contains(text(), 'Pharmacy Search')]/span")
	protected WebElement inputInstruction;
	
	@FindBy(xpath="//select[@id='miles']//option")
	protected List<WebElement> distanceOptions;
	
	@FindBy(id = "miles")
	protected WebElement distanceDropDownField;
	
	@FindBy(xpath="//*[@id='miles']/option[1]")
	protected WebElement distanceOption_1mile;
	
	@FindBy(xpath="//*[@id='miles']/option[2]")
	protected WebElement distanceOption_2miles;

	@FindBy(xpath="//*[@id='miles']/option[3]")
	protected WebElement distanceOption_5miles;

	@FindBy(xpath="//*[@id='miles']/option[4]")
	protected WebElement distanceOption_10miles;

	@FindBy(xpath="//*[@id='miles']/option[5]")
	protected WebElement distanceOption_15miles;

	@FindBy(xpath="//*[@id='miles']/option[6]")
	protected WebElement distanceOption_25miles;
	
	@FindBy(xpath="//div[contains(@class, 'uhc-toggle__inner')]//button[1]")
	protected WebElement CurrentYearLink;
	
	@FindBy(xpath="//div[contains(@class, 'uhc-toggle__inner')]//button[2]")
	protected WebElement NextYearLink;
	
	@FindBy(xpath="//div[@id='zipError']//p[contains(text(),'Error: ZIP Code')]")
	protected WebElement noZipcode;
	
	@FindBy(xpath = "//div[@id='zipError']//p[contains(text(),'Error: Please enter your ZIP')]")
	protected WebElement invalidZip;
	
	@FindBy(xpath="//div[contains(@id,'modifyYourSearchId')]//li")
	protected WebElement modifyZipErr;

	@FindBy(xpath="")
	protected WebElement yearDropdownLabel;

	@FindBy(xpath = "//select[@id='plans']")
	protected WebElement seletPlandropdown;

	@FindBy(xpath="//button[@class='uhc-button uhc-button--secondary p-20']")
	protected WebElement searchbtn;
	
}
