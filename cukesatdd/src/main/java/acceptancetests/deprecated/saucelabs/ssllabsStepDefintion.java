package acceptancetests.deprecated.saucelabs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.deprecated.atdd.data.CommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality: Checking for sauce labs
 */
public class ssllabsStepDefintion {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on the ssllabs site home page$")
	public void the_user_is_on_the_ssllabs_site_home_page()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
		wd.get("https://www.ssllabs.com/ssltest/");
		wd.findElement(By.xpath("//div[@class='submitBox']/center/form/table/tbody/tr[1]/td[2]/input")).sendKeys("www.aarpmedicareplans.com");
	}
	
	@When("^the user enters AARP site URL into text box$")
	public void the_user_enters_AARP_site_URL_into_text_box()
	{
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.findElement(By.xpath("//div[@class='submitBox']/center/form/table/tbody/tr[1]/td[3]/input")).click();	
		try {
			Thread.sleep(45000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@Then("^the user sees response for AARP site$")
	public void the_user_sees_response_for_AARP_site(DataTable arg1)
	{
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		if (wd.findElement(By.xpath("//*[@id='rating']/div[1]")).isDisplayed()) {
		Assert.assertTrue(true);
		} else {
		Assert.fail("500- Page Loading Error");
		}
	}
	
	@Given("^the user is on the ssllabs site home page for UHC$")
	public void the_user_is_on_the_ssllabs_site_home_page_for_UHC()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
		wd.get("https://www.ssllabs.com/ssltest/");
		wd.findElement(By.xpath("//div[@class='submitBox']/center/form/table/tbody/tr[1]/td[2]/input")).sendKeys("www.uhcmedicaresolutions.com");
		
	
	}
	
	@When("^the user enters UHC site URL into text box$")
	public void the_user_enters_UHC_site_URL_into_text_box()
	{
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.findElement(By.xpath("//div[@class='submitBox']/center/form/table/tbody/tr[1]/td[3]/input")).click();
		try {
			Thread.sleep(45000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	@Then("^the user sees response for UHC site$")
	public void the_user_sees_response_for_UHC_site(DataTable arg1)
	{
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		if (wd.findElement(By.xpath("//*[@id='rating']/div[1]")).isDisplayed()) {
		Assert.assertTrue(true);
	} else {
		Assert.fail("500-Page Loading Error");
		
	}
	}
}