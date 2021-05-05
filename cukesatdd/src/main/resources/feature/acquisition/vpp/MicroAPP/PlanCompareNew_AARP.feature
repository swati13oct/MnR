@vppPlanCompareAARPNew
Feature: 1.01.3-Vpp to plan Compare AARP Scenarios

  @vppPlanCompareAARP03 @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - Verify for zipcode with 2 plans when 1 is selected then the other plan is auto-selected and De-selection
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user select and unselect one plan for plan compare and verify second plan checkbox autoselected and click on plan compare for AARP

    Examples: 
      | TID   | zipcode | isMultiCounty | county         | plantype | planyear |
      | 00006 |   35616 | NO            | Colbert County | MAPD     | current  |

  @vppPlanCompareAARP12 @vppPlanCompareAARPRegression
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - valiadation of Add drug from plan compare and Edit drug from plan compare page for AARP
    Given the user is on the medicare site landing page
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I access the DCE tool on aarp site
      | Plan Type | <plantype> |
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
    Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
    When the user selects the pharmacy type and distance in AARP site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in AARP site
      | Pharmacy Name | <pharmacyName> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <drugName1> |
    And the user clicks on return link to navigate to plan summary
    And I select "<plantype>" plans to compare and click on compare plan link in AARP
    Then verify plan compare page is loaded on AARP
    Then verify Edit your Drugs is loaded with Drugs summary on Plan Compare page AARP
    And click on Edit Drug link on plan compare for AARP site
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
    When user successfully adds drug in the ums site
      | Drug Name3 | <drugName3> |
    Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
    When the user selects the pharmacy type and distance in AARP site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in AARP site
      | Pharmacy Name | <pharmacyName> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name2 | <drugName2> |
      | Drug Name3 | <drugName3> |
    And the user clicks on Back to Plans button in AARP site and Navigates to new Plan Compare
    Then verify plan compare page is loaded on AARP
    Then verify Edit your Drugs is loaded with Drugs summary on Plan Compare page AARP

    Examples: 
      | TID   | zipcode | drugName1 | dosage   | plantype | county             | isMultiCounty | quantity | frequency     | branded | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName   | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear | planyear |
      | 00015 |   90002 | Lipitor   | TAB 10MG | MAPD     | Los Angeles County | no            |       30 | Every 1 month | yes     | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | BRAVO PHARMACY | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          | current  |
