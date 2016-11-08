package pages.mobile.member.ulayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class PharmacyLocatorFilterPage extends UhcDriver{
	
	@FindBy(css="div.pharmacy_location_modal>h1")
	private WebElement txtNarrowYourSearch;

	@FindBy(css="div.filter_content div.context-help.clickable")
	private WebElement toolTip_NarrowYourSearch;
	
	@FindBy(xpath="//div[@class='drawer js-pharmacy-filter-drawer drawer--open']//span[text()='Close']")
	private WebElement toolTip_NarrowYourSearch_Close;
	
	@FindBy(xpath="//span[text()='Standard Network Pharmacy']/preceding-sibling::input")
	private WebElement chkBox_StandardNetworkPharmacy;
	
	@FindBy(xpath="//span[text()='Pharmacy Saver™ Program']/preceding-sibling::input")
	private WebElement chkBox_PharmacySaver;
	
	@FindBy(xpath="//span[text()='Pharmacy Saver™ Program']/following-sibling::span")
	private WebElement toolTip_PharmacySaver;
	
	@FindBy(xpath="//span[text()='Preferred Retail Pharmacy Network']/following-sibling::span")
	private WebElement toolTip_PreferredPharmacy;
	
	@FindBy(xpath="//b[contains(text(),'Pharmacy Saver™ Program –')]")
	private WebElement txt_ToolTip_NarrowYourSearch_PharmacySaver;
	
	@FindBy(xpath="//b[contains(text(),'Standard Network Pharmacy')]")
	private WebElement txt_ToolTip_NarrowYourSearch_StandardNetwork;
	
	@FindBy(xpath="//b[contains(text(),'Preferred Retail Pharmacy Network –')]")
	private WebElement txt_ToolTip_NarrowYourSearch_PreferredNetwork;
	
	public enum ToolTip {
		PHARMACY_SAVER,
		STANDARD_NETWORK,
		PREFERRED_RETAIL
	}
		
	public PharmacyLocatorFilterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(txtNarrowYourSearch);
	}
	
	public void validateToolTip(ToolTip toolTip){
		waitforElement(toolTip_NarrowYourSearch);
		toolTip_NarrowYourSearch.click();
		switch (toolTip) {
		case PHARMACY_SAVER:
			validate(txt_ToolTip_NarrowYourSearch_PharmacySaver);
			waitforElement(toolTip_NarrowYourSearch_Close);
			toolTip_NarrowYourSearch_Close.click();
			validate(toolTip_PharmacySaver);
			break;
		case STANDARD_NETWORK:
			validate(txt_ToolTip_NarrowYourSearch_StandardNetwork);
			toolTip_NarrowYourSearch_Close.click();
		case PREFERRED_RETAIL:
			validate(txt_ToolTip_NarrowYourSearch_PharmacySaver);
			toolTip_NarrowYourSearch_Close.click();
			validate(toolTip_PreferredPharmacy);
			break;
		}
	}
}
