
	package acceptancetests.memberredesign.registration;

                import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import junit.framework.Assert;
import pages.dashboard.acquisition.RegistrationInformationPage;

                /**
                * @author 
                 *
                */

                public class RegistrationAddPlanPopupFunctionalityStepDefinition {

                                
                                @Autowired
                                MRScenario loginScenario;

                                public MRScenario getLoginScenario() {
                                                return loginScenario;
                                }

                @When("^member enters memberid for second plan into member id text field$")
                public void enterMedicareID(DataTable givenAttributes) {
                                // get test variables
                                                List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                                                Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                                for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
                                                }
                                                // get member ID
                                                String secMemberId = memberAttributesMap.get("Second Plan Member ID");

                                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);      
                                                //registrationInformationPage.enterMedicareID(secmemberId);
                                                registrationInformationPage.enterSecMemberID(secMemberId);
                                                try {
                                                                Thread.sleep(2000);
                                                } catch (InterruptedException e) {
                                                                // TODO Auto-generated catch block
                                                                e.printStackTrace();
                                                }

                }

                @And("^clicks on Add a Plan button$")
                public void clickAddPlanButtononPage() throws InterruptedException {

                                // navigate to registration page
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.clickAddplanButton();
                                Thread.sleep(1000);
                                
                }


                @Then("^Confirm Plan Details pop up is displayed with correct header$")
                public void PlanPopupisdisplayed() throws InterruptedException {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                Thread.sleep(1000);
                                registrationInformationPage.getPlanPopupHeader().isDisplayed();
                                
                                
                                }

      
                @And("^Cancel button in top right hand corner is displayed$")
                public void CancelButtononPopup() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.getCancelLinkonPopup().isDisplayed(); 
                                
                                }
                @And("^correct second plans member ID value is displayed$")
                public void correctsecMemberIDValueisdisplayed(DataTable givenAttributes) {
        // get test variables
                        List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                        Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                        for (int i = 0; i < memberAttributesRow.size(); i++) {
                            memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
                        }

        // get expected member ID
        String expectedmemberId = memberAttributesMap.get("Second Plan Member ID");

        // get actual member id from portal
        RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
        getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
        String actualmemberId = registrationInformationPage.getModalMemberIdValue().getText();
        Assert.assertEquals(expectedmemberId, actualmemberId);
                                }
                
                @And("^correct second plans Member name value is displayed$")
                                public void correctMemberNameValueisdisplayed(DataTable givenAttributes) {
            // get test variables
                                            List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                                            Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                                            for (int i = 0; i < memberAttributesRow.size(); i++) {
                                                memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
                                            }

                            // get expected member name
                            String expectedmembername = memberAttributesMap.get("Second Member name");
                            // get actual member name from portal
                            RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                            getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                            String actualmembername = registrationInformationPage.getModalMemberNameValue().getText();
                            Assert.assertEquals(expectedmembername, actualmembername); 
                                }
                
                
                @And("^correct second plans name value is displayed$")
                public void correctPlanNameisdisplayed(DataTable givenAttributes) {
                	// get test variables
                            List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                            Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                            for (int i = 0; i < memberAttributesRow.size(); i++) {
                                memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
                            }

            // get expected member name
            String expectedplanname = memberAttributesMap.get("Second Plan name");
            // get actual member name from portal
            RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
            getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
            String actualplanname = registrationInformationPage.getModalPlanNameValue().getText();
            Assert.assertEquals(expectedplanname, actualplanname); 
                }

                @And("^correct second plans Member date of birth value is displayed$")
                public void correctMemberDatePfBirthValueisdisplayed(DataTable givenAttributes) {
                	// get test variables
                        List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
                        Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
                        for (int i = 0; i < memberAttributesRow.size(); i++) {
                            memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
                        }

                        // get date of birth
                        String dateOfBirth = memberAttributesMap.get("Second Date of birth");
                        String[] splitDate = dateOfBirth.split("-");
                        String month = splitDate[0];
                        String day= splitDate[1];
                        String year = splitDate[2];
                        String expectedformattedDateOfBirth = month+"/"+day+"/"+year;
                        //System.out.println("expected member dob is" +expectedformattedDateOfBirth);
                        
                        RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                        getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                        
                        String actualDateOfBirth = registrationInformationPage.getModalDateOfBirthValue().getText();
                        //System.out.println("actual member dob is" +actualDateOfBirth);
                        Assert.assertEquals(expectedformattedDateOfBirth, actualDateOfBirth);
                }
                        
                @And("^verify continue button and cancel link is displayed$")
                public void buttonspresent() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.getCancelLinkonPopup().isDisplayed(); 
                                registrationInformationPage.getConfirmonPopup().isDisplayed(); 
                                
                                }
     
                @And("^member clicks continue button$")
                public void clickbuttonspresent() {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                registrationInformationPage.clickContinuebuttononPopup(); 
                                
                                
                                }

                @Then("^the user is navigated to  Multiple Plan Variation View and the checkbox is checked for both the plans$")
                public void navigatetoMultiPlanView() throws InterruptedException
                {
                                RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
                                                                getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
                                 
                                Thread.sleep(10000);
                               Assert.assertTrue(registrationInformationPage.getcheckbox1().isSelected());
                               Assert.assertTrue(registrationInformationPage.getcheckbox2().isSelected());
                               
                
                }
             

                @Then("^error message of invalid member id is displayed$")
                public void planNotFoundErrorMessage() {
            		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
            				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
            		registrationInformationPage.getinvalidmemidError().isDisplayed();
            		Assert.assertTrue(registrationInformationPage.getinvalidmemidError().getText().contains("Invalid "));
            		
            		}
                
                @Then("^error message of same member id registered is displayed$")
                public void sameMemIdErrorMessage() {
            		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
            				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
            		registrationInformationPage.getsameMemIdError().isDisplayed();
            		Assert.assertTrue(registrationInformationPage.getsameMemIdError().getText().contains("same plan"));
            		
            		}
                @Then("^error message of plan has a future effective date is displayed$")
                public void FuturePlanErrorMessage() {
            		RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
            				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
            		registrationInformationPage.getFuturePlanError().isDisplayed();
            		Assert.assertTrue(registrationInformationPage.getFuturePlanError().getText().contains("future"));
            		
            		}
                
                @Then("^error message of plan being terminated is displayed$")
                public void planTerminatedErrormessage()
                {
                	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
            				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
            		registrationInformationPage.getplanterminatedError().isDisplayed();
            		Assert.assertTrue(registrationInformationPage.getplanterminatedError().getText().contains("Teminated "));
                
                }
                
                @Then("^error message of member id already registered is displayed$")
                public void alreadyregisteredmemErrormessage()
                {
                	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
            				getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
            		registrationInformationPage.getmemberidalreadyregisteredError().isDisplayed();
            		Assert.assertTrue(registrationInformationPage.getmemberidalreadyregisteredError().getText().contains("AlreadyRegistered"));
                
                }
  
                
}


