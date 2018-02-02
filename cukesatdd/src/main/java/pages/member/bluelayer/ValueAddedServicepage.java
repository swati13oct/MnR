/**
 * 
 */
package pages.member.bluelayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(className= "atdd-vas-nurselineimage")
	private WebElement nurseHealthLine;
	
	@FindBy(id = "silverSneaker")
	private WebElement silverSneaker;
	
	@FindBy(id = "mycarePath")
	private WebElement mycarepath;
	
	@FindBy(id = "visionDiscount")
	private WebElement visionDiscount;
	
	@FindBy(className = "atdd-vas-title")
	private WebElement vasheader; 
	
	@FindBy(className = "atdd-vas-subtitle")
	private WebElement vastext;
	
	@FindBy(className = "atdd-vas-descrptiontext")
	private WebElement vastext2;
	
	@FindBy(className = "atdd-vas-viewmorlnk")
	private WebElement viewmore;
	
	@FindBy(className = "atdd-vas-maincta-button")
	private WebElement maincta;
	
	@FindBy(id="collapseLargeCard1")
	private WebElement viewlinkexpand;
	
	@FindBy(xpath=".//*[@id='collapseLargeCard1']/div/div[1]/div/div/div/a")
	private WebElement disclaimers;
	
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
	
	public void validatevasheadertext() {
		// TODO Auto-generated method stub
		validate(vasheader);
		validate(vastext);
		validate(vastext2);
	}
	
	public void validateviewmorelink() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)", "");
		validate(viewmore);
		
		
	}
	
	public void validatemainctabutton() {
		// TODO Auto-generated method stub
		validate(maincta);
	}
	
	public void validateviewmorelinkexpand() {
		// TODO Auto-generated method stub
		viewmore.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(viewlinkexpand);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(disclaimers);
		disclaimers.click();
	}
	
	
	public void openAndValidate(){
		
	}
}







