@vppBlayer @emailAndPrint @emailAndPrint_UHC
Feature: Acq-To test print and email on VPP page on UHC site

  @emailAndPrint_UHC1 @emailAndPrintplancompare @predatorsdecrelease2018 @RegressionPredators
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


  @emailAndPrint_UHC2 @emailAndPrintplanDetails @predatorsdecrelease2018 @RegressionPredators
  Scenario Outline:TID: <TID>- TO click Back to all plans from Top and bottom of the page and verify redirection back to the VPP-Summary page UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user view plan details of the first plan in the given plan type in UMS site vpp
    Then the user validate the print and email links on the plan Details Page on uhc site
    Then the user validates the functionality of email and print buttons on the plan Details Page on uhc site
@abc
    Examples: 
   |  TID    | zipcode | plantype |
   | 15533   |   33012 | MAPD     |


  @emailAndPrint_UHC3 @feature-F265872 @us1598166 @vppEmailRegression @vppFavoritePlanEmailUhc @predators @Apr_release_2019 
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
    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                         | PDP_testPlans                                                   | SNP_testPlans                                                                               |
      | 1598166 | 80001   | NO            | Jefferson County | Medica HealthCare Plans MedicareMax (HMO),Preferred Choice Dade (HMO)| AARP MedicareRx Walgreens (PDP),AARP MedicareRx Preferred (PDP) | Preferred Special Care Miami-Dade (HMO C-SNP),UnitedHealthcare Nursing Home Plan (PPO I-SNP)|


  @emailAndPrint_UHC4 @feature-F265872 @us1603378 @vppPrintRegressionBlayer @vppFavoritePlanPrintUhc @predators @Apr_release_2019  @RegressionPredators
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
      | 1598166 | 80001   | NO            | Jefferson County | Medica HealthCare Plans MedicareMax (HMO),Preferred Choice Dade (HMO)| AARP MedicareRx Walgreens (PDP),AARP MedicareRx Preferred (PDP) | Preferred Special Care Miami-Dade (HMO C-SNP),UnitedHealthcare Nursing Home Plan (PPO I-SNP)|


