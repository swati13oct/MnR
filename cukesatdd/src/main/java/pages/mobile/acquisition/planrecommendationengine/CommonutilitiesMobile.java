/**
 * Desc: Common methods to be accessed throughout the project
 * Author : Murali
 */
package pages.mobile.acquisition.planrecommendationengine;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.mobile.acquisition.planrecommendationengine.PlanRecommendationStepDefinitionMobile;
import atdd.framework.UhcDriver;
import io.appium.java_client.AppiumDriver;

public class CommonutilitiesMobile extends UhcDriver {

	public CommonutilitiesMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	public static final String locationPageName = "Location";
	public static final String coverageOptionsPageName = "Coverage";
	public static final String specialNeedsPageName = "Special";
	public static final String travelPageName = "Travel";
	public static final String doctorsPageName = "Doctor";
	public static final String drugPageName = "Drug";
	public static final String pharmacyPageName = "Pharmacy"; //Removed From PRE
	public static final String additionalServicesPageName = "Additional Services";
	public static final String costPreferencesPageName = "Cost Preferences";
	public static final String prioritiesPageName = "Priorities";
	public static final String resultsPageName = "Plan Recommendation Summary";
	
	String flow;

	// --- From here Common for all page starts ---
	@FindBy(css = ".progress-bar-title>h1")
	private WebElement planSelectorPageTilte;

	@FindBy(css = ".progress-bar-info>h2")
	private WebElement pageStepsNumberName;

	@FindBy(css = "div.progress-bar-value-background")
	private WebElement progressbar;

	@FindBy(css = "div.progress-bar-info>p")
	private WebElement pageProgressPercentage;

	@FindBy(css = "div>.all-fields-marked-wi")
	private WebElement pageRequiredInfo;

	@FindBy(css = ".all-fields-marked-wi>sup")
	private WebElement pageRequiredInfoAsteriskMark;

	@FindBy(css = "div.sam")
	public WebElement footerCallbannerSection;

	@FindBy(css = "body header")
	public WebElement headerSection;

	@FindBy(css = ".container div>button[class*='primary button']")
	private WebElement continueBtn;

	@FindBy(css = ".container div>button[class*='secondary']")
	private WebElement previousBtn;

	@FindBy(css = "#errorMessage")
	private WebElement errorMessage;

	// --- Common elements Ends above ---

	public String currentPageName, currrentPagePercentage, previousPageName, previousPagePercentage, nextPageName,
			nextPagePercentage;

	public boolean mobileFindElementBeforeCallBanner(WebElement element, String percentage, int swipeCount, boolean swipeUp) {
		boolean swipeScusses = true;
		try {
			validate(footerCallbannerSection, 30);
			validate(element, 30);
			int locationDifference = 100;
			/*
			System.out.println("Footer Size :"+footerCallbannerSection.getSize());
			System.out.println("Footer Location :"+footerCallbannerSection.getLocation());
			System.out.println("Footer X : "+footerCallbannerSection.getLocation().getX());
			System.out.println("Footer Y : "+footerCallbannerSection.getLocation().getY());
			System.out.println("Element Size :"+element.getSize());
			System.out.println("Element Location :"+element.getLocation());
			System.out.println("Element X : "+element.getLocation().getX());
			System.out.println("Element Y : "+element.getLocation().getY());
			*/		
			if (footerCallbannerSection.getLocation().getY() - element.getLocation().getY() < locationDifference
					&& swipeCount > 0) {
				swipeScusses = mobileswipe(percentage, swipeUp);
				if (swipeScusses) {
					swipeCount--;
				} else {
					mobileswipe(percentage, swipeUp);
					swipeCount--;
				}
				mobileFindElementBeforeCallBanner(element, percentage, swipeCount, swipeUp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element not visible footer banner");
		}
		return swipeScusses;
	}

	public boolean mobileFindElementAfterHeader(WebElement element, String percentage, int swipeCount, boolean swipeUp) {
		boolean swipeScusses = true;
		try {
			validate(headerSection, 30);
			validate(element, 30);
			int locationDifference = 150;
			/*
			System.out.println("Header X : "+headerSection.getLocation().getX());
			System.out.println("Header Y : "+headerSection.getLocation().getY());
			System.out.println("Element X : "+element.getLocation().getX());
			System.out.println("Element Y : "+element.getLocation().getY());
			*/
			if (element.getLocation().getY() - headerSection.getLocation().getY() < locationDifference
					&& swipeCount > 0) {
				swipeScusses = mobileswipe(percentage, swipeUp);
				if (swipeScusses) {
					swipeCount--;
				} else {
					mobileswipe(percentage, swipeUp);
					swipeCount--;
				}
				mobileFindElementAfterHeader(element, percentage, swipeCount, swipeUp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element not visible");
		}
		return swipeScusses;
	}

	String swipeDownPercentage = "60%";
	// if swipe using longPress then 50% else 75% for swipe towards up
	String swipeUpPercentage = "75%";
	public void mobileLocateElementClick(WebElement element) {
		mobileFindElementBeforeCallBanner(element, swipeUpPercentage, 8, true);
		mobileFindElementAfterHeader(element, swipeDownPercentage, 8, false);
		element.click();
	}

	public boolean mobileLocateElement(WebElement element) {
		boolean locateStatus = false;
		boolean locateB = mobileFindElementBeforeCallBanner(element, swipeUpPercentage, 8, true);
		boolean locateA = mobileFindElementAfterHeader(element, swipeDownPercentage, 8, false);
		if (locateB && locateA)
			locateStatus = true;
		return locateStatus;
	}
	
	public void mobileLocateElement(WebElement element,String swipepercentage) {
		mobileFindElementBeforeCallBanner(element, swipepercentage, 8, true);
		mobileFindElementAfterHeader(element, swipepercentage, 8, false);
	}

	public void mobileLocateElementClick(WebElement element, int swipeup, int swipedown) {
		mobileFindElementBeforeCallBanner(element, swipeUpPercentage, swipeup, true);
		mobileFindElementAfterHeader(element, swipeDownPercentage, swipedown, false);
		element.click();
	}

	public void mobileLocateElementSendkeys(WebElement element, String keys) {
		mobileLocateElement(element);
		mobileactionsendkeys(element, keys);
	}

	public void fixPrivateConnectionMobile() {
		try {
			// String URL = "https://self-signed.badssl.com/";
			threadsleep(1000);
			if (driver.findElement(By.cssSelector("body.ssl h1")).getText()
					.contains("Your connection is not private")) {
				driver.navigate().refresh();
				pageloadcomplete();
				jsClickNew(driver.findElement(By.cssSelector("button#details-button")));
				//driver.findElement(By.cssSelector("button#details-button")).click();
				threadsleep(1000);
				//driver.findElement(By.cssSelector("a#proceed-link")).click();
				jsClickNew(driver.findElement(By.cssSelector("a#proceed-link")));
				threadsleep(1000);
				pageloadcomplete();
			}
		} catch (Exception e) {
			System.out.println("No SSL error / Exception");
		}
	}

	public boolean fixLeavingProceedMobile() {
		boolean status = false;
		try {
			threadsleep(500);
			WebElement element = driver.findElement(By.cssSelector("a#proceed"));
			jsClickNew(element);
			threadsleep(1000);
			pageloadcomplete();
			status = true;
		} catch (Exception e) {
			System.out.println("No Leaving Proceed Error");
		}
		return status;
	}

	public void threadsleep(int sec) {
		try {
			Thread.sleep(sec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Current page percentage validation Mobile
	public void currentPageValidation(String pageName) {
		System.out.println("Current page Validation Mobile");
		findPagedetails(pageName);
		try {
			//pageloadcomplete();
			threadsleep(3000);
			Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(pageName.toUpperCase()),
					"Current page name validation failed");
			Assert.assertTrue(pageProgressPercentage.getText().toUpperCase().contains(currrentPagePercentage),
					"Current page % validation failed");
		} catch (Exception e) {
			System.out.println("Unable to validate Current page functionality or not Visible");
		}
	}

	// Previous Button Functionality Mobile
	public void previousPageValidation(String pageName) {
		System.out.println("Previous page Validation Mobile");
		findPagedetails(pageName);
		try {
			pageloadcomplete();
			threadsleep(3000);
			Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(previousPageName.toUpperCase()),
					"Previous page name validation failed");
			Assert.assertTrue(pageProgressPercentage.getText().toUpperCase().contains(previousPagePercentage),
					"Previous page % validation failed");
		} catch (Exception e) {
			System.out.println("Unable to validate previous button functionality or not Visible");
		}
	}

	// Continue Button Functionality Mobile
	public void nextPageValidation(String pageName) {
		System.out.println("Next page Validation Mobile");
		findPagedetails(pageName);
		if (nextPageName.contains("NULL") == false) {
			try {
				pageloadcomplete();
				threadsleep(1000);
				try {
					waitTextPresent(pageStepsNumberName,nextPageName,20);
					} catch (Exception e) {
					Assert.assertTrue(false, "Next page name validation failed");
				}
				Assert.assertTrue(pageProgressPercentage.getText().toUpperCase().contains(nextPagePercentage),
						"Next page % validation failed");
			} catch (Exception e) {
				System.out.println("Unable to validate Continue button functionality on Next page");
			}
		}
	}

	public void findPagedetails(String pageName) {
		flow = PlanRecommendationStepDefinitionMobile.PREflow;
		currentPageName = pageName.toUpperCase().trim();
		previousPageName = new String();
		previousPagePercentage = new String();
		nextPageName = new String();
		nextPagePercentage = new String();
		currrentPagePercentage = new String();
		if (currentPageName.contains("LOCATION")) {
			nextPageName = "Coverage";
			nextPagePercentage = "10%";
			currrentPagePercentage = "0%";
		}
		// Update the else and else if for each page
		if (flow.equalsIgnoreCase("PDP")) {
			if (currentPageName.contains("COVERAGE")) {
				previousPageName = "Location";
				previousPagePercentage = "10%";
				nextPageName = "Drug";
				nextPagePercentage = "50%";
				currrentPagePercentage = "10%";
			}
			if (currentPageName.contains("DRUG")) {
				previousPageName = "Coverage";
				previousPagePercentage = "50%";
				nextPageName = "NULL";
				nextPagePercentage = "NULL";
				currrentPagePercentage = "50%";
//				if (currentPageName.contains("SKIP")) {
//					nextPageName = "NULL";
//					nextPagePercentage = "NULL";
//					return;
//				}
			}
//			if (currentPageName.contains("PHARMACY")) {
//				previousPageName = "Drug";
//				previousPagePercentage = "53%";
//				nextPageName = "NULL";
//				nextPagePercentage = "NULL";
//				currrentPagePercentage = "53%";
//				return;
//			}
		} else {
			if (currentPageName.contains("COVERAGE")) {
				previousPageName = "Location";
				previousPagePercentage = "10%";
				nextPageName = "Special";
				nextPagePercentage = "20%";
				currrentPagePercentage = "10%";
				if (flow.equalsIgnoreCase("MA")) {
					nextPagePercentage = "22%";
				}
				if (flow.equalsIgnoreCase("PDPTOMAPD")) {
					nextPagePercentage = "30%";
				}
			} else if (currentPageName.contains("SPECIAL")) {
				previousPageName = "Coverage";
				previousPagePercentage = "20%";
				nextPageName = "Travel";
				nextPagePercentage = "30%";
				currrentPagePercentage = "20%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPagePercentage = "22%";
					currrentPagePercentage = "22%";
					nextPagePercentage = "33%";
				}
				if (flow.equalsIgnoreCase("PDPTOMAPD")) {
					nextPagePercentage = "40%";
				}
			} else if (currentPageName.contains("TRAVEL") || currentPageName.contains("CARE AWAY")) {
				previousPageName = "Special";
				previousPagePercentage = "30%";
				nextPageName = "Doctor";
				nextPagePercentage = "40%";
				currrentPagePercentage = "30%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPagePercentage = "33%";
					currrentPagePercentage = "33%";
					nextPagePercentage = "44%";
				}
				if (flow.equalsIgnoreCase("PDPTOMAPD")) {
					nextPagePercentage = "50%";
				}
			} else if (currentPageName.contains("DOCTOR")) {
				previousPageName = "Travel";
				previousPagePercentage = "40%";
				nextPageName = "Drug";
				nextPagePercentage = "50%";
				currrentPagePercentage = "40%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPagePercentage = "44%";
					currrentPagePercentage = "44%";
					nextPageName = "Additional";
					nextPagePercentage = "56%";
				}
				if (flow.equalsIgnoreCase("PDPTOMAPD")) {
					nextPagePercentage = "60%";
				}
			} else if (currentPageName.contains("DRUG")) {
				previousPageName = "Doctor";
				previousPagePercentage = "50%";
				//nextPageName = "Pharmacy";
				//nextPagePercentage = "60%";
				currrentPagePercentage = "50%";
				//if (currentPageName.contains("SKIP"))
//					if ((flow.equalsIgnoreCase("MAPD") || flow.equalsIgnoreCase("NONE"))) {
						nextPageName = "Additional";
						nextPagePercentage = "60%";
//					}
			}
//			else if (currentPageName.contains("PHARMACY")) {
//				previousPageName = "Drug";
//				previousPagePercentage = "60%";
//				nextPageName = "Additional";
//				nextPagePercentage = "70%";
//				currrentPagePercentage = "60%";
//			} 
		else if (currentPageName.contains("ADDITIONAL")) {
				previousPageName = "Drug";
				previousPagePercentage = "60%";
				nextPageName = "Cost";
				nextPagePercentage = "70%";
				currrentPagePercentage = "60%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPageName = "Doctor";
					previousPagePercentage = "56%";
					currrentPagePercentage = "56%";
					nextPagePercentage = "67%";
				}
//				if (currentPageName.contains("SKIP")) {
//					previousPageName = "Drug";
//					previousPagePercentage = "60%";
//				}
			} else if (currentPageName.contains("COST")) {
				previousPageName = "Additional";
				previousPagePercentage = "70%";
				nextPageName = "Priorities";
				nextPagePercentage = "80%";
				currrentPagePercentage = "70%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPagePercentage = "67%";
					currrentPagePercentage = "67%";
					nextPagePercentage = "78%";
				}
			}else if (currentPageName.contains("PRIORITIES")) {
				previousPageName = "Cost";
				previousPagePercentage = "80%";
				nextPageName = "NULL";
				nextPagePercentage = "NULL";
				currrentPagePercentage = "80%";
				if (flow.equalsIgnoreCase("MA")) {
					previousPagePercentage = "78%";
					currrentPagePercentage = "78%";
				}
			} else {
				previousPageName = "";
				previousPagePercentage = "";
				nextPageName = "";
				nextPagePercentage = "";
			}
		}
		previousPagePercentage = previousPagePercentage + " COMPLETE";
		nextPagePercentage = nextPagePercentage + " COMPLETE";
		currrentPagePercentage = currrentPagePercentage + " COMPLETE";
	}

	public void mobleErrorValidation(String pagename) {
		System.out.println("Error Validation");
		validate(errorMessage, 30);
		Assert.assertTrue(errorMessage.getText().toUpperCase().contains("PLEASE")
				|| (errorMessage.getText().toUpperCase().contains("NO"))
				|| (errorMessage.getText().toUpperCase().contains("ZIP"))
				);
		Assert.assertTrue(pageStepsNumberName.getText().toUpperCase().contains(pagename.toUpperCase()));
	}

	public void browserBack() {
		driver.navigate().back();
	}
	
	public void continueNextpage(String page,boolean percentageValidation) {
		System.out.println("Clicking continue from page : "+page);
		threadsleep(1000);
		validate(continueBtn);
		mobileLocateElement(continueBtn);
		jsClickMobile(continueBtn);
		System.out.println("Validating " + page + " page Continue button functionality");
		if(percentageValidation)
			nextPageValidation(page.toUpperCase());
		else
			nextPageNameValidation(page.toUpperCase());
	}

	public void nextPageNameValidation(String pageName) {
		System.out.println("Next page Validation Mobile");
		findPagedetails(pageName);
		if (nextPageName.contains("NULL") == false) {
			try {
				pageloadcomplete();
				threadsleep(1000);
				try {
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.textToBePresentInElement(pageStepsNumberName, nextPageName));
				} catch (Exception e) {
					Assert.assertTrue(false, "Next page name validation failed");
				}
			} catch (Exception e) {
				System.out.println("Unable to validate Continue button functionality on Next page");
			}
		}
	}
	
	public void waitTextPresent(WebElement element,String text,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public boolean mobileFindElementHorizontal(WebElement element, String percentage, int swipeCount, boolean swipeRight) {
		boolean swipeScusses = true;
		try {
			if (validate(element, 5)==false &&swipeCount > 0) {
				swipeScusses = mobileswipeHorizantal(percentage, swipeRight);
				if (swipeScusses) {
					swipeCount--;
				} else {
					mobileswipeHorizantal(percentage, swipeRight);
					swipeCount--;
				}
				mobileFindElementHorizontal(element, percentage, swipeCount, swipeRight);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element not visible");
		}
		return swipeScusses;
	}

	// if swipe using longPress then 50% else 75% for swipe towards right
	String swipeRightPercentage = "75%";
	public void mobileFindElementHorizontal(WebElement element) {
		mobileFindElementHorizontal(element, swipeRightPercentage, 8, false);
	}
	
	public void mobileFindElementHorizontal(WebElement element,String swipeRightPercentage) {
		mobileFindElementHorizontal(element, swipeRightPercentage, 8, false);
	}
	
	public boolean mobileCheckElementBeforeCallBanner(WebElement element) {
		boolean status = true;
		try {
			validate(footerCallbannerSection, 30);
			validate(element, 30);
			int locationDifference = 30;
			int footerY = footerCallbannerSection.getLocation().getY();
			int elementY =element.getLocation().getY();
			//System.out.println("Footer Y: "+footerY+"Element Y :"+elementY);
			if (footerY - elementY < locationDifference) {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element/Footer banner not visible");
		}
		return status;
	}
	
	public void checkPlansForCompare(String counter, String planType) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Integer> selectPlanIndexes = new ArrayList<Integer>();
		int count = counter.contains(",") ? 0 : Integer.parseInt(counter);
		if (count == 0)
			for (String index : counter.split(",")) {
				selectPlanIndexes.add(Integer.parseInt(index));
			}
		else
			for (int i = 0; i < count; i++) {
				selectPlanIndexes.add(i);
			}

		List<WebElement> allPlans;

		if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("MA")) {
			allPlans = driver
					.findElements(By.xpath(".//*[@id='plan-list-1']//div[contains(@class,'compare-box')]//label"));
		} else {
			allPlans = driver.findElements(By.xpath("//label[contains(text(),'Add to compare')]"));
		}
		if (allPlans != null) {
			for (int i : selectPlanIndexes) {
				jsClickNew(allPlans.get(i));
			}
		}
	}

}
