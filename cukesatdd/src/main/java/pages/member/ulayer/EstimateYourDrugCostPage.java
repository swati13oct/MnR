package pages.member.ulayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class EstimateYourDrugCostPage extends UhcDriver {
	@FindBy(className = "y2015")
	private WebElement planYear2017;
	
	@FindBy(xpath = "/html/body/div[7]/div/div/table/tbody/tr[5]/td/div[4]/div/div[6]/div[1]/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div[2]/span/strong/span[1]")
	private WebElement planYear2016;
	
	@FindBy(xpath = "/html/body/div[7]/div/div/table/tbody/tr[5]/td/div[4]/div/div[6]/div[1]/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div[4]/a")
	private WebElement continueToManageDrugList;
	
	@FindBy(className = "getstartedselectplan")
	private WebElement selectPlanDropDown;
	
	public EstimateYourDrugCostPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}

	public ManageDrugPage continueToSearchDrug(String planYear, String planName) {
		validate(continueToManageDrugList);
		
		if (validate(planYear2017)){		
			if (planYear.equals("2017")){
				planYear2017.click();
			}
			try {
				Thread.sleep(5000);

				CommonUtility.waitForPageLoad(driver, continueToManageDrugList, CommonConstants.TIMEOUT_30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Select select = new Select(driver.findElement(By.className("getstartedselectplan")));
			List<WebElement> allDropDownPlans = select.getOptions();
			for (WebElement we : allDropDownPlans){
				if (we.getText().equals(planName)){
					select.selectByVisibleText(planName);
				}
			}
			
			continueToManageDrugList.click();
		} else {
			System.out.println("Did not find 2017 button");}
			if (driver.getTitle().equalsIgnoreCase("Drug Lookup")) {
				return new ManageDrugPage(driver);
			} else {
			return null;
		}
		
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}
}
