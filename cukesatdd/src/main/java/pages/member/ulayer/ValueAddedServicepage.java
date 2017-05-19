/**
 * 
 */
package pages.member.ulayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.dashboard.member.ulayer.ClaimSummarypage;

/**
 * @author pjaising
 */

public class ValueAddedServicepage extends UhcDriver {

	
	@FindBy(id= "Nursehealth")
	private WebElement nurseHealthLine;
	
	@FindBy(id = "silverSneaker")
	private WebElement silverSneaker;
	
	@FindBy(id = "mycarePath")
	private WebElement mycarepath;
	
	@FindBy(id = "visionDiscount")
	private WebElement visionDiscount;
	//private PageData valueAddedservicePage; 

	public ValueAddedServicepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();	
		}
	
	public void validatenurseHealthLine() {
		// TODO Auto-generated method stub
		validate(nurseHealthLine);
	}
	public void validatesilverSneaker() {
		// TODO Auto-generated method stub
		validate(silverSneaker);
	}
	public void validatemyCarePath() {
		// TODO Auto-generated method stub
		validate(mycarepath);
	}
	public void validatevisionDiscount() {
		// TODO Auto-generated method stub
		validate(visionDiscount);
	}
	public void openAndValidate(){
		
	}
}







