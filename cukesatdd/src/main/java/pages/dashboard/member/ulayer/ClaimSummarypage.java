package pages.dashboard.member.ulayer;
import java.util.List;
import java.util.Map;

/**
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

public class ClaimSummarypage extends UhcDriver{
	
	private PageData newClaimsSummarypage;
	
	
	@FindBy(xpath=".//*[@class='claimsearch section']/div[1]//h1")
	private WebElement myCaimsText;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr")
	private WebElement ClaimsSummaryPage;
	
	@FindBy(xpath=".//h2[contains(.,'Plan Name Lorem Ipsum')]")
	private WebElement  planName;
	
	@FindBy(xpath="//div[contains(.,'Medical')]")
	private WebElement claimTypeMA;
	
	@FindBy(id="claim-type")
	private WebElement claimTypeMAPD;
	
	
	@FindBy(xpath="//div[normalize-space()='Prescription Drug']")
	private WebElement claimTypePDP;
	
	@FindBy(xpath=".//*[@id='document-date']")
	private WebElement viewClaimsFrom;
	
	@FindBy (xpath="(.//*[@id='summaryview']//section/div/div/div/p)[1]")                    
     private WebElement claimsCopyText;
	
	
	@FindBy (xpath="(.//*[@id='summaryview']//section/div/div/div/p)[2]")                    
    private WebElement claimsCopyText2;
	
	@FindBy (xpath=".//*[@id='table-medical']//div/h2 ")
	private WebElement dynamicNumberOfClaimsText;
	
	@FindBy (xpath=".//*[@id='table-medical']/div[3]/div/div")
	private WebElement claimsTable;
	
	@FindBy (xpath=".//*[@id='summaryview']/div/div/main/div/div[2]/section/div/div/div[2]/div/div/ul")
	private WebElement claimsTablePagination;
	
	@FindBy (xpath="//h2[contains(.,'Medical EOB')]")
	private WebElement medicalEobText;
	
	@FindBy (xpath="//h2[contains(.,'Prescription Drug EOB')]")
	private WebElement PrescriptionEobText;
	
		
	
	

	public ClaimSummarypage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage, 60);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
		
		
	}


@SuppressWarnings("deprecation")
public void validateHeader() {
	// TODO Auto-generated method stub
	if(myCaimsText.getText().equals("My Claims")){
		Assert.assertTrue(true);
	}
	else{
		Assert.fail("Claims Page Header Not found");
	}
}


public  boolean validateClaimType(String abc){	
	
if(abc.equals("MA")){	
	return claimTypeMA.isDisplayed();		
	}
	else if(abc.equals("PDP")){	
		System.out.println(claimTypePDP.isDisplayed());
		return claimTypePDP.isDisplayed();		
	}
	else{
		System.out.println(claimTypeMAPD.isDisplayed());
		return claimTypeMAPD.isDisplayed();	
		/*Select select = new Select(claimTypeMAPD);
		int size = select.getOptions().size();
		//select.getFirstSelectedOption()
		if(size!=2){
			return false;		
		}
		else{
			List<WebElement> values = select.getOptions();
			System.out.println(values.get(0));
			System.out.println(values.get(1));
			
			return values.get(0).equals("medical")&&values.get(1).equals("prescription drug");
		}*/
	}	
}	
public String validateViewClaimsFromDropDown(){		
		Select select = new Select(viewClaimsFrom);
		return select.getFirstSelectedOption().getText(); 		
}

public boolean verifyCopyText(){
	return claimsCopyText.isDisplayed();
}


public boolean verifyCopyText2(){
	return claimsCopyText2.isDisplayed();
}


public boolean verifyDynamicText(){
	return dynamicNumberOfClaimsText.isDisplayed();
	
}

public boolean verifyClaimsTableAndPagination(){
	
	return claimsTable.isDisplayed()&& claimsTablePagination.isDisplayed();
	
}
	
	public boolean validteEobfordifferentDomainType(String domain, String plantype){
		
		if (domain.equals("COSMOS")&& plantype.equals("MAPD"))
		{
			System.out.println("for MAPD COSMOS  medical and precription drug EOB's are displayed===> "+ (medicalEobText.isDisplayed() && PrescriptionEobText.isDisplayed()));
			 return medicalEobText.isDisplayed() && PrescriptionEobText.isDisplayed();
			 
					}
		else if (domain.equals("NICE")&&plantype.equals("MAPD"))
		{
			System.out.println("for MAPD NICE prescription drug EOB's are displayed ===>"+ (PrescriptionEobText.isDisplayed()));
			return PrescriptionEobText.isDisplayed();
		}
		else if (plantype.equals("MA"))
				{
			System.out.println("for MA medical Eob is diplayed ====>"+ (medicalEobText.isDisplayed()));
			return medicalEobText.isDisplayed();
		}
		else {
			System.out.println("for PDP prescription drug EOB's are diaplayed ====> "+ (PrescriptionEobText.isDisplayed()));
			return PrescriptionEobText.isDisplayed();
		
		}
		
		
		
	}
	




	
}
	
	


