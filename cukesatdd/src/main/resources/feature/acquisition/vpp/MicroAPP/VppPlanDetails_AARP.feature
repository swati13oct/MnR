@vppPlanDetailsAARP
Feature: 1.01.2-Vpp to plan Details AARP Scenarios

  @vppPlanDetailsAARP08
  Scenario Outline: UserStory: <TCID> -plan type: <plantype> -  To Verify the drug cost estimator flow for <plantype> through plan details page's Plan Costs tab
    Given the user is on the AARP medicare site landing page
    When user performs plan search using following information in the AARP site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type in AARP site
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then the user navigates to Plan Costs tab in AARP site
    Then user adds drug to drug cost estimator flow for the given plan name in AARP site
      | PlanName   | <planName>  |
      | Drug Name1 | <drugName1> |
    And selects drug details in ums site
      | Drug Name1 | <drugName1> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the ums site
      | Drug Name1 | <drugName1> |
    Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
    When the user selects the pharmacy type and distance in AARP site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in AARP site
      | Pharmacy Name | <pharmacyName> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <drugName1> |
    When the user clicks on Edit Drug List link in AARP site
    Then Enter your drugs page is displayed to the user in AARP site
    Then User click on Switch now to select the Generic of the Brand drug added in AARP site
    Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
    Then the user change the pharmacy type and select new pharmacy in AARP site
      | New Pharmacy Type | <newPharmacyType> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <genericName1> |
    And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
    And user verifies annual drug cost in the Plan Cost tab of AARP site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in AARP site
    Then user validates Drug information is reflected on plan summary page in AARP site
      | PlanName | <planName> |

    Examples: 
      | TCID  | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                        | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear | planyear |
      | 00011 |   90210 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Preferred Retail | 15 miles | COMMUNITY, A WALGREENS PHARMACY | PDP      | AARP MedicareRx Walgreens (PDP) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          | current  |
