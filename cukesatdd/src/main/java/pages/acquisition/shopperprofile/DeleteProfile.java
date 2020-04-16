package pages.acquisition.shopperprofile;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.base.Strings;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class DeleteProfile extends UhcDriver {
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "mbi")
	private WebElement mbi;
	
	@FindBy(id = "dob")
	private WebElement dob;
	
	@FindBy(xpath="//button")
	private WebElement btnDelete;

	@FindBy(xpath="//button/preceding-sibling::p")
	private WebElement deletedMessage;
	
	public static final String DELETE_PROFILE_URL = "https://www.team-e-aarpmedicareplans.ocp-elr-core-nonprod.optum.com/admin/shopper-profile.html/delete-profile";
	
	
	public DeleteProfile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		start(DELETE_PROFILE_URL);
		CommonUtility.waitForPageLoadNew(driver, email, 15);
		CommonUtility.waitForPageLoadNew(driver, mbi, 15);
		CommonUtility.waitForPageLoadNew(driver, btnDelete, 15);
	}
	
	/**
	 * Delete a profile using email,dob and MBI
	 * @param emailID
	 * @param dateOfBirth
	 * @param MBI
	 */
	public void deleteAProfile(String emailID, String dateOfBirth, String MBI) {
		try {
			sendkeys(email, emailID);
			sendkeys(mbi, MBI);
			sendkeys(dob, dateOfBirth);
			btnDelete.click();
			CommonUtility.waitForPageLoadNew(driver, deletedMessage, 15);
			System.out.println("##################"+deletedMessage.getText().trim()+"##################");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
