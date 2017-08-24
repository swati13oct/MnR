package pages.acquisition.bluelayer;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.member.ulayer.Rallytool_Page;

public class ResponsivePlanDetailsUhc extends UhcDriver {

        @FindBy(xpath="html/body/div[6]/div[4]/div/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div[1]/table/tbody/tr[4]/td[2]/a")
        private WebElement providerLink;
        
        public ResponsivePlanDetailsUhc(WebDriver driver) {
                super(driver);
                PageFactory.initElements(driver, this);
                // TODO Auto-generated constructor stub
        }

        @Override
        public void openAndValidate() {
                // TODO Auto-generated method stub
                
        }
        
        public Rallytool_Page validateRallyPage(){
                providerLink.click();
                try {
                        Thread.sleep(3000);
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
         try {
                Thread.sleep(6000);
         } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
         }             
         driver.switchTo().window(tabs.get(1));
         System.out.println(driver.getTitle());
         if (driver.getTitle().equalsIgnoreCase("Welcome")) {
         return new Rallytool_Page(driver);
         }
         else{

         }
                return null;
        }

}