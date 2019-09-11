@vppUlayer @emailAndPrint @emailAndPrint_AARP
Feature: Acq-To test print and email on VPP page on AARP site


  @emailAndPrint_AARP1 @emailAndPrintplancompare @predators @RegressionPredators
  Scenario Outline:TID: <TID> - Verify print and email for <plantype> plan compare page in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
    And I select multiple plans to compare in MA and click on compare plan link
      | plan type       | <plantype> |
    When the user validate the print and email link option in plan compare
    Then the user validating email and print option in plan compare
    Then the user validate thank you message in plan compare in AARP site
    Then I click back to all plans button and verify that all plans are still selected
    
    Examples: 
     | TID   | zipcode | plantype          | isMultiCounty | planName                                             |
     | 15523 | 90210   | MedicareAdvantage | NO            | AARP MedicareComplete SecureHorizons Essential (HMO) |


  @emailAndPrint_AARP2 @emailAndPrintplanDetails @predators @decRelease2018 @RegressionPredators
  Scenario Outline:TID: <TID> -  Verify email and Print plan functionalities on Plan Details page in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site
      | Plan Type       | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user view plan details of the first plan in the given plan type in AARP site and validates
    Then the user validate the print and email links on the plan Details Page
    Then the user validates the functionality of email and print buttons on the plan Details Page

    Examples: 
    |  TID  | zipcode | plantype | isMultutiCounty |
    | 15531 |   90210 | MA       | No              |


  @emailAndPrint_AARP3 @feature-F265872 @us1598166 @vppEmailRegression @vppFavoritePlanEmailAarp @predators @Apr_release_2019 
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can invoke the email button on view plan preview page on AARP site
	# NOTE: Uncommment the step to save plans when there is a way to validate the received email content
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site 
    #Then user validates selected plans can be saved as favorite on AARP site
    #  | MA Test Plans   | <MA_testPlans>  |
    #  | PDP Test Plans  | <PDP_testPlans> |
    #  | SNP Test Plans  | <SNP_testPlans> |
    Then user validates email option on AARP site
	Then user validates email functionality with invalid and valid email address on AARP site
    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                           | PDP_testPlans                                                    | SNP_testPlans                                                                               |
      | 1598166 | 80001   | NO            | Jefferson County | AARP MedicareComplete SecureHorizons Plan 2 (HMO),AARP MedicareComplete SecureHorizons Essential (HMO) | AARP MedicareRx Walgreens (PDP),AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO SNP),UnitedHealthcare Nursing Home Plan (PPO SNP) |


  @emailAndPrint_AARP4 @feature-F265872 @us1603378 @vppFavoritePlanPrintAarp @predators @Apr_release_2019 @RegressionPredators
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can invoke the print button on view plan preview page on AARP site
	# NOTE: Uncommment the step to save plans when there is a way to validate the print preview screen content
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site 
    #Then user validates selected plans can be saved as favorite on AARP site
    #  | MA Test Plans   | <MA_testPlans>  |
    #  | PDP Test Plans  | <PDP_testPlans> |
    #  | SNP Test Plans  | <SNP_testPlans> |
    Then user validates print option on AARP site
	Then user validates print functionality on AARP site

    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                          | PDP_testPlans                                                    | SNP_testPlans                                                                               |
      | 1598166 | 80001   | NO            | Jefferson County | AARP MedicareComplete SecureHorizons Plan 2 (HMO),AARP MedicareComplete SecureHorizons Essential (HMO) | AARP MedicareRx Walgreens (PDP),AARP MedicareRx Preferred (PDP) | UnitedHealthcare Dual Complete (HMO SNP),UnitedHealthcare Nursing Home Plan (PPO SNP) |


