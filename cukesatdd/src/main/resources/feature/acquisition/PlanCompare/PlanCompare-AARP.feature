@PlanCompare
Feature: Acq-To test PlanCompare Flows in AARP site

  @PlancompareProviderSearchAARPTest
  Scenario Outline: TID: <TID> - TC01_RallyTool_Through_Plan Compare_Page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select all 3 plans to compare and click on compare plan link in AARP
    And I Click on Look up your doctor link on Plan compare in AARP
    And I click on Get Started on and Add Provider from find care page in AARP
    Then Verify provider is count is updated on plan compare page in AARP

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             |
      | 15489 |   90210 | NO              | Los Angeles County |

  @PlancompareDCETest
  Scenario Outline: TID: TID: <TID> -plan type: <plantype> - DCE_Through_Plan_Compare_Page_MAPD_PDP
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    And I Click on DCE link on Plan compare for AARP
    Then user adds drug to drug cost estimator flow for the given plan name in AARP site
      | PlanName   | <planName>  |
      | Drug Name1 | <drugName1> |
    And selects drug details in ums site
      | Drug Name1 | <drugName1> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded>   |
      | Drug            | <drugName1> |
    Then user adds drug to drug cost estimator flow for the given plan name in AARP site
      | PlanName   | <planName>  |
      | Drug Name2 | <drugName2> |
    And selects drug details for other drugs in ums site
      | Drug Name2 | <drugName2> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    Then user adds drug to drug cost estimator flow for the given plan name in AARP site
      | PlanName   | <planName>  |
      | Drug Name3 | <drugName3> |
    And selects drug details in ums site
      | Drug Name3 | <drugName3> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded>   |
      | Drug            | <drugName3> |
    Then user adds drug to drug cost estimator flow for the given plan name in AARP site
      | PlanName   | <planName>  |
      | Drug Name4 | <drugName4> |
    And selects drug details for other drugs in ums site
      | Drug Name4 | <drugName4> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    Then user adds drug to drug cost estimator flow for the given plan name in AARP site
      | PlanName   | <planName>  |
      | Drug Name5 | <drugName5> |
    And selects drug details for other drugs in ums site
      | Drug Name5 | <drugName5> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    And I navigate to step2 page
    When the user selects the pharmacy type and distance in AARP site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in AARP site
      | Pharmacy Name | <pharmacyName> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <drugName1> |
      | Drug Name2 | <drugName2> |
      | Drug Name3 | <drugName3> |
      | Drug Name4 | <drugName4> |
      | Drug Name5 | <drugName5> |
    When the user clicks on Edit Drug List link in AARP site
    Then Enter your drugs page is displayed to the user in AARP site
    Then User click on Switch now to select the Generic of the Brand drug added in AARP site
    And I navigate to step2 page
    Then the user change the pharmacy type and select new pharmacy in AARP site
      | New Pharmacy Type | <newPharmacyType> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <genericName1> |
      | Drug Name2 | <drugName2>    |
      | Drug Name3 | <genricName3>  |
      | Drug Name4 | <drugName4>    |
      | Drug Name5 | <drugName5>    |
    And the user clicks on Back to Plans button in AARP site and Navigates to Plan Compare
    Then user validates Drug information is reflected on plan compare page in AARP

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | drugInitials1 | branded | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | drugInitials4 | drugName4 | drugInitials5 | drugName5             | pharmacyType     | distance | pharmacyName            | plantype | planName                                          | quantity | frequency     | newPharmacyType | genericName1 | genricName3 |
      | 15492 |   90210 | NO              | Los Angeles County | lipi          | yes     | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network | 15 miles | MEN'S HEALTH FOUNDATION | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |       30 | Every 1 month | Mail Service    | atorvastatin | fluticasone |
      | 15539 |   90210 | NO              | Los Angeles County | lipi          | yes     | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network | 15 miles | MEN'S HEALTH FOUNDATION | PDP      | AARP MedicareRx Walgreens (PDP)                   |       30 | Every 1 month | Mail Service    | atorvastatin | fluticasone |
