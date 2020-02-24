@DCEVPP_Ulayer
Feature: 1.10.3 ACQ-DCE-VPP_2 AARP To test DCE to VPP Plan Details in AARP site


  @dceThroughPlanDetailsAARP @aarp @DCE_Regression_Ulayer_VPP3 @dce2 @aarpDce2
  Scenario Outline: 1.10.31 To Verify the drug cost estimator flow for <plantype> through plan details page's Prescription Drug Benefits tab: PlanName <planName>; ZipCode <zipcode>
    Given the user is on the AARP medicare site landing page
    When user performs plan search using following information in the AARP site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
    Then the user navigates to the plan details for the given plan type in AARP site
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then the user navigates to Presciption Drug Benefits tab in AARP site
    Then user adds drug to drug cost estimator flow for the given plan name in AARP site
      | PlanName   | <planName>  |
      | Drug Name1 | <drugName1> |
    And selects drug details in ums site
      | Drug Name1 | <drugName1> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the ums site
      | Drug Name1 | <drugName1> |
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
      | Drug Name1 | <drugName1> |
      | Drug Name2 | <drugName2> |
      | Drug Name3 | <drugName3> |
    When the user clicks on Edit Drug List link in AARP site
    Then Enter your drugs page is displayed to the user in AARP site
    Then User click on Switch now to select the Generic of the Brand drug added in AARP site
    Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
    Then the user change the pharmacy type and select new pharmacy in AARP site
      | New Pharmacy Type | <newPharmacyType> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <genericName1> |
      | Drug Name2 | <drugName2>    |
      | Drug Name3 | <genricName3>  |
    And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
    And user verifies annual drug cost in the prescription drug tab of AARP site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in AARP site
    Then user validates Drug information is reflected on plan summary page in AARP site
      | PlanName | <planName> |


@DCE_Regression_Ulayer_VPP3MAPD
    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   90002 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | CVS PHARMACY     | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |
@DCE_Regression_Ulayer_VPP3PDP
    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   90210 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Preferred Retail | 15 miles | COMMUNITY, A WALGREENS PHARMACY | PDP      | AARP MedicareRx Walgreens (PDP)                    |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |
@DCE_Regression_Ulayer_VPP3SNP
    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   80210 | Denver County      | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | CENTURA HEALTH PHARMACY AT PORTE | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)         |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |


  @dceThroughPlanDetailsAARP @aarp @DCE_Regression_Ulayer_VPP4 @dce3 @aarpDce
  Scenario Outline: 1.10.32 To Verify the drug cost estimator flow for <plantype> through plan details page's Plan Costs tab: PlanName <planName>; ZipCode <zipcode>
    Given the user is on the AARP medicare site landing page
    When user performs plan search using following information in the AARP site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
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
      | Drug Name1 | <drugName1> |
      | Drug Name2 | <drugName2> |
      | Drug Name3 | <drugName3> |
    When the user clicks on Edit Drug List link in AARP site
    Then Enter your drugs page is displayed to the user in AARP site
    Then User click on Switch now to select the Generic of the Brand drug added in AARP site
    Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
    Then the user change the pharmacy type and select new pharmacy in AARP site
      | New Pharmacy Type | <newPharmacyType> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <genericName1> |
      | Drug Name2 | <drugName2>    |
      | Drug Name3 | <genricName3>  |
    And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
    And user verifies annual drug cost in the Plan Cost tab of AARP site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in AARP site
    Then user validates Drug information is reflected on plan summary page in AARP site
      | PlanName | <planName> |

@DCE_Regression_Ulayer_VPP4MAPD
    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   90002 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | CVS PHARMACY     | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |
@DCE_Regression_Ulayer_VPP4PDP
    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   90210 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Preferred Retail | 15 miles | COMMUNITY, A WALGREENS PHARMACY | PDP      | AARP MedicareRx Walgreens (PDP)                    |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |
@DCE_Regression_Ulayer_VPP4SNP
    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   80210 | Denver County      | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | CENTURA HEALTH PHARMACY AT PORTE | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)         |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |
      