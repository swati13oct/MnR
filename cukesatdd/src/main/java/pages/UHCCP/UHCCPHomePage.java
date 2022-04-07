package pages.UHCCP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UHCCPHomePage extends GlobalElements_Page {

	@FindBy(xpath = "(//*[contains(@id,'zipSearch') and (@type='text')])[2]")
	private WebElement zipCodeField;

	@FindBy(xpath = "(//*[contains(@class,'zip-search__submit')])[2]")
	private WebElement findPlansButton;

	@FindBy(xpath = "//h2[contains(@id,'multi-county-modal')]")
	private WebElement countyModal;

	public UHCCPHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public PlanSummaryPage searchPlansWithOutCounty(String zipcode) throws InterruptedException {

		pageloadcomplete();
		validateNew(zipCodeField);
		sendkeysNew(zipCodeField, zipcode);
		validateNew(findPlansButton);
		jsClickNew(findPlansButton);
		pageloadcomplete();
		validateNew(PageHeader, 30);
		if (driver.getTitle().contains("UnitedHealthcare Community Plan")) {
			return new PlanSummaryPage(driver);
		} else
			return null;
	}

	public PlanSummaryPage searchPlansWithCounty(String zipcode, String planname, String county)
			throws InterruptedException {
		pageloadcomplete();
		validateNew(zipCodeField);
		sendkeysNew(zipCodeField, zipcode);
		validateNew(findPlansButton);
		jsClickNew(findPlansButton);
		if (validate(countyModal, 5)) {
			WebElement countyLoc = driver.findElement(By.xpath(
					"//*[contains(@id,'zip-search__multi-county__radio')]//label[contains(text(),'" + county + "')]"));
			jsClickNew(countyLoc);
		}
		pageloadcomplete();
		validateNew(PageHeader, 30);
		if (driver.getTitle().contains("UnitedHealthcare Community Plan")) {
			System.out.println("Plan Summary page is displayed");

			return new PlanSummaryPage(driver);
		} else
			return null;
	}

	public void selectLang(String lang) {
		if (lang.equalsIgnoreCase("Es")) {
			validateNew(langSelect);
			langSelect.click();
			jsClickNew(driver.findElement(
					By.xpath("//*[@id='js-language-select__content']//span[contains(text(),'" + lang + "')]")));
			checkModelPopup(driver,30);
		} else
			System.out.println("English is selected by default");
	}
}
