package pages.acquisition.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ResourcesPage extends UhcDriver {

	@FindBy(xpath = "//a[contains(text(),'Search Now')]")
	private WebElement searchNowLink;

	@FindBy(xpath = "//a[contains(text(),'Find Information')]")
	private WebElement findInfoLink;

	@FindBy(xpath = "//a[contains(@href,'plan-benefits')]")
	private WebElement planBenefitLink;

	@FindBy(xpath = "//a[contains(@href,'wellness-discount')]")
	private WebElement wellnessResourcesLink;

	@FindBy(xpath = "//a[contains(@href,'health-care-management')]")
	private WebElement clinicalProgramLink;
	
	@FindBy(xpath = "//a[contains(@href,'mail-order-pharmacy')]")
	private WebElement learnmoreLink;

	@FindBy(xpath = "//a[contains(@href,'healthcare-fraud')]")
	private WebElement GetInformedLink;

	@FindBy(xpath = "//h1//span[text()='Member Resources']")
	private WebElement pageHeading;

	public ResourcesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(pageHeading);
		if (!driver.getCurrentUrl().contains("resources.html") && pageHeading.equals("Member Resources")) {
			Assert.fail("Resource page did not load properly");
		}
	}

	public void clickOnSearchNowPlanDoc() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement searchPlanDocAccordion=driver.findElement(By.xpath("//span[@class='uhc-accordion__title-wrapper']//span[contains(text(),'Plan Document')]"));
		scrollToView(searchPlanDocAccordion);
		jsClickNew(searchPlanDocAccordion);
		scrollToView(searchNowLink);
		jsClickNew(searchNowLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("/plan-documents.html")) {
			System.out.println("Plan Document Search Page is opened Successfully");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Plan Document Search Page is not opened Successfully " + driver.getCurrentUrl());
		}

	}

	public void clickOnFindInfoButton() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement additionInfoAccordion=driver.findElement(By.xpath("//span[@class='uhc-accordion__title-wrapper']//span[contains(text(),'Information and Forms')]"));
		scrollToView(additionInfoAccordion);
		jsClickNew(additionInfoAccordion);
		scrollToView(findInfoLink);
		jsClickNew(findInfoLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("/resources/ma-pdp-information-forms")) {
			System.out.println("Plan Information and Forms Page is opened Successfully");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Plan Information and Forms Page is not opened Successfully " + driver.getCurrentUrl());
		}
	}

	public void clickOnPlanBenefitLink() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(planBenefitLink);
		jsClickNew(planBenefitLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("shop/medicare-advantage-plans/ma-plan-benefits")) {
			System.out.println("Plan Benefits Page is opened Successfully");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Plan Benefits Page is not opened Successfully " + driver.getCurrentUrl());
		}
	}

	public void clickOnWellnessResourcesLink() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(wellnessResourcesLink);
		jsClickNew(wellnessResourcesLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("shop/medicare-advantage-plans/wellness-discounts")) {
			System.out.println("Wellness Resources Page is opened Successfully");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Wellness Resources Page is not opened Successfully " + driver.getCurrentUrl());
		}
	}

	public void clickOnClinicalProgramLink() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(clinicalProgramLink);
		jsClickNew(clinicalProgramLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("shop/medicare-advantage-plans/health-care-management")) {
			System.out.println("Clinical Program Page is opened Successfully");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Clinical Program Page is not opened Successfully " + driver.getCurrentUrl());
		}
	}

	public void clickOnLearnmoreLinkForMailOrderPharmacy() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(learnmoreLink);
		jsClickNew(learnmoreLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("/resources/mail-order-pharmacy")) {
			System.out.println("Mail Order Pharmacy Page is opened Successfully");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Mail Order Pharmacy Page is not opened Successfully " + driver.getCurrentUrl());
		}
	}

	public void clickOnGetInformedMedicalFraudLink() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(GetInformedLink);
		jsClickNew(GetInformedLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("resources/healthcare-fraud")) {
			System.out.println("Preventing Medicare Fraud Page is opened Successfully");
			Assert.assertTrue(true);
		} else {
			Assert.fail("Preventing Medicare Fraud Page is not opened Successfully " + driver.getCurrentUrl());
		}
	}

}
