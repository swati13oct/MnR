@vppPlanDetailsUHC
Feature: 2.01.2-Vpp to plan Details UHC Scenarios

  @vppPlanDetailsUHC08
  Scenario Outline: TCID - <TID> - plan Type: <plantype> - To Verify the drug cost estimator flow for <plantype> through plan details page's Plan Costs tab
    Given user is on blue layer landing page
    When user performs plan search using following information in the UMS site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user selects plan year for the UMS site
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type in UMS site
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then the user navigates to Presciption Drug Benefits tab in UMS site
    And I verify the plan name in UMS site
      | PlanName | <planName> |
    Then user adds drug to drug cost estimator flow for the given plan name in UMS site
      | PlanName   | <planName>  |
      | Drug Name1 | <drugName1> |
    And selects drug details in UMS site
      | Drug Name1 | <drugName1> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the UMS site
      | Drug Name1 | <drugName1> |
    Then user adds drug to drug cost estimator flow for the given plan name in UMS site
      | PlanName   | <planName>  |
      | Drug Name2 | <drugName2> |
    And selects drug details for other drugs in UMS site
      | Drug Name2 | <drugName2> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    Then user adds drug to drug cost estimator flow for the given plan name in UMS site
      | PlanName   | <planName>  |
      | Drug Name3 | <drugName3> |
    And selects drug details in UMS site
      | Drug Name3 | <drugName3> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the UMS site
      | Drug Name3 | <drugName3> |
    Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
    When the user selects the pharmacy type and distance in UMS site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in UMS site
      | Pharmacy Name | <pharmacyName> |
    Then the user validates the added drugs on See your Estimated Costs page in UMS site
      | Drug Name1 | <drugName1> |
      | Drug Name2 | <drugName2> |
      | Drug Name3 | <drugName3> |
    When the user clicks on Edit Drug List link in UMS site
    Then Enter your drugs page is displayed to the user in UMS site
    Then User click on Switch now to select the Generic of the Brand drug added in UMS site
    Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
    Then the user change the pharmacy type and select new pharmacy in UMS site
      | New Pharmacy Type | <newPharmacyType> |
    Then the user validates the added drugs on See your Estimated Costs page in UMS site
      | Drug Name1 | <genericName1> |
      | Drug Name2 | <drugName2>    |
      | Drug Name3 | <genricName3>  |
    And the user clicks on Back to Plans button on See Your Estimated Costs page in UMS site
    And user verifies annual drug cost in the prescription drug tab of UMS site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in UMS site
    Then user validates Drug information is reflected on plan summary page in UMS site
      | PlanName | <planName> |

    Examples: 
      | TID   | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear | planyear |
      | 00010 |   90002 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | CVS PHARMACY | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          | current  |
