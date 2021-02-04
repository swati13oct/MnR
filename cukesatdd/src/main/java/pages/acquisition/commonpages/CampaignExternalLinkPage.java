package pages.acquisition.commonpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class CampaignExternalLinkPage extends GlobalWebElements {

	public CampaignExternalLinkPage(WebDriver driver, String site) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(site);
	}

	public void openAndValidate(String site) {
		startNew(site);
	}
}
