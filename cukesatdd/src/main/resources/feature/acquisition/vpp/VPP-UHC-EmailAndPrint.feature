@vppBlayer @emailAndPrint @emailAndPrint_UHC
Feature: 2.04.ACQ-Print and email on VPP page on UMS

  #@emailAndPrint_UHC1 @emailAndPrintplancompare @predatorsdecrelease2018 @RegressionPredators @prodRegression
  Scenario Outline:TID: <TID>- Verify email plan compare plan details in UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    And I select all 3 plans to compare in MA and click on compare plan link in UHS site
    When the user validate the print and email link option in plan compare in UHS site
    Then the user validating email and print option in plan compare in UHS site
    Then the user validate thank you message in plan compare in UHS site
    Then the user clicks on back to all plans link and validates all three plans are selected

    Examples: 
    |  TID   | zipcode |
    | 15519  |   90210 |


  #@emailAndPrint_UHC2 @emailAndPrintplanDetails @predatorsdecrelease2018 @RegressionPredators @prodRegression
  Scenario Outline:TID: <TID>- TO click Back to all plans from Top and bottom of the page and verify redirection back to the VPP-Summary page UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user view plan details of the first plan in the given plan type in UMS site vpp
    Then the user validate the print and email links on the plan Details Page on uhc site
    Then the user validates the functionality of email and print buttons on the plan Details Page on uhc site

    Examples: 
   |  TID    | zipcode | plantype |
   | 15533   |   33012 | MAPD     |


  #@emailAndPrint_UHC3 @feature-F265872 @us1598166 @vppEmailRegression @vppFavoritePlanEmailUhc @predators @Apr_release_2019 @prodRegression
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can invoke the email button on view plan preview page on UHC site
	# NOTE: Uncommment the step to save plans when there is a way to validate the received email content
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site 
    #Then user validates selected plans can be saved as favorite on UHC site
    #  | MA Test Plans   | <MA_testPlans>  |
    #  | PDP Test Plans  | <PDP_testPlans> |
    #  | SNP Test Plans  | <SNP_testPlans> |
    Then user validates email option on UHC site
	Then user validates email functionality with invalid and valid email address on UHC site
	Then user validates print option on UHC site
	Then user validates print functionality on UHC site
	
    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                         | PDP_testPlans                                                   | SNP_testPlans                                                                               |
      | 1598166 | 80001   | NO            | Jefferson County | Medica HealthCare Plans MedicareMax (HMO),Preferred Choice Dade (HMO)| AARP MedicareRx Walgreens (PDP),AARP MedicareRx Preferred (PDP) | Preferred Special Care Miami-Dade (HMO C-SNP),UnitedHealthcare Nursing Home Plan (PPO I-SNP)|


  #@emailAndPrint_UHC4 @feature-F265872 @us1603378 @vppPrintRegressionBlayer @vppFavoritePlanPrintUhc @predators @Apr_release_2019  @RegressionPredators
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can invoke the print button on view plan preview page on UHC site
	# NOTE: Uncommment the step to save plans when there is a way to validate the print preview screen content
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site 
    #Then user validates selected plans can be saved as favorite on UHC site
    #  | MA Test Plans   | <MA_testPlans>  |
    #  | PDP Test Plans  | <PDP_testPlans> |
    #  | SNP Test Plans  | <SNP_testPlans> |
    Then user validates print option on UHC site
	Then user validates print functionality on UHC site

    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                          | PDP_testPlans                                                    | SNP_testPlans                                                                               |
#      | 1598166 | 80001   | NO            | Jefferson County | Medica HealthCare Plans MedicareMax (HMO),Preferred Choice Dade (HMO)| AARP MedicareRx Walgreens (PDP),AARP MedicareRx Preferred (PDP) | Preferred Special Care Miami-Dade (HMO C-SNP),UnitedHealthcare Nursing Home Plan (PPO I-SNP)|

#--------------------------------

  @emailAndPrint_UHC1 @emailAndPrintplancompare @predatorsdecrelease2018 @RegressionPredators
  Scenario Outline:TID: <TID> -plantype: <plantype> - Verify print and email for plan compare page in UHC site
     Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And the user views the plans of the below plan type on test site
      | Plan Type       | <plantype> |
      | Site            | <site>     |
    Then user saves first plan on plan summary page on test site
    Then I select multiple plans to compare for selected plan and click on compare plan link in the test site
      | plan type       | <plantype> |
    Then the user validate the print link option in plan compare on test site
    Then the user validates the functionality of print button on the plan compare Page in test site
    Then the user validate the email link option in plan compare on test site
    Then the user validate thank you message in plan compare for selected plan in test site
    Then I click back to all plans button and verify that all plans are still selected on summary page on test site
    Then user loads page using email deeplink and validate vpp compare page content on test site
 
    Examples: 
     | TID   | site   |zipcode | plantype          | isMultiCounty | 
     | 15523 | Blayer |90210   | MA                | NO            | 
     
		@prodRegression
     Examples:
     | TID   | site   |zipcode | plantype          | isMultiCounty | 
     | 15523 | Blayer |90210   | PDP               | NO            | 

   @emailAndPrint_UHC2 @emailAndPrintplanDetails @predatorsdecrelease2018 @RegressionPredators
  Scenario Outline:TID: <TID> -plantype: <plantype> - Verify email and Print plan functionalities on Plan Details page in UHC site
     Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type on test site
      | Plan Type       | <plantype> |
      | Site            | <site>     |
    Then the user view plan details of the first plan in the given plan type and perform validation in test site
    Then the user validate the print link on the plan Details Page on test site
    Then the user validates the functionality of print button on the plan Details Page in test site
    Then the user validate the email link on the plan Details Page on test site
    Then the user validates the functionality of email button on the plan Details Page in test site
    Then user loads page using email deeplink and validate vpp detail page content on test site

    Examples: 
      |  TID  | site   |zipcode | plantype | isMultutiCounty | 
      | 15531 | Blayer |  80001 | MA       | No              | 
      | 15531 | Blayer |  80001 | PDP      | No              |
    
     @prodRegression
     Examples:
      | TID   | site   |zipcode | plantype          | isMultiCounty | 
      | 15531 | Ulayer |  80001 | SNP      | No              |


  @emailAndPrint_UHC3 @emailAndPrintplanSummary @feature-F265872 @us1598166 @vppEmailRegression @vppFavoritePlanEmailUhc @predators @Apr_release_2019
  Scenario Outline: UID: <UID> -plantype: <plantype> - Verify user can invoke the email button and the print button on view plan preview page on UHC site
     Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type on test site
      | Plan Type       | <plantype> |
      | Site            | <site>     |
    Then user saves first plan on plan summary page on test site
    Then user validates print option for selected plan on plan summary page on test site
	Then user validates print functionality for selected plan on plan summary page on test site
    Then user validates email option for selected plan on plan summary page on test site
	Then user validates email functionality with invalid and valid email address for selected plan on plan summary page on test site
	Then user loads page using email deeplink for plan and validate vpp summary page content on test site

    Examples: 
      | UID     | site   |plantype | zipcode | isMultiCounty | county           | 
      | 1598166 | Blayer |PDP      | 80001   | NO            | Jefferson County | 
      | 1598166 | Blayer |SNP      | 80001   | NO            | Jefferson County | 
      
    @prodRegression 
    Examples: 
      | UID     | site   |plantype | zipcode | isMultiCounty | county           | 
      | 1598166 | Ulayer |MA       | 80001   | NO            | Jefferson County |

