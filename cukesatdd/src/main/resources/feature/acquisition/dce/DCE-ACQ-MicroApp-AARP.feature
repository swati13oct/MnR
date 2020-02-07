@acq_DCE_MicroApp_AARP
Feature: ACQ-DCE-MicroApp - AARP

  @DCE_MicroApp_TestHarness_AARP
  Scenario Outline: To test the DCE flow on AARP Acquisition TestHarness: PlanName <planName>; ZipCode <zipcode>
    Given the user is on the Acquisition Site DCE TestHarness page
      | Site Name       | <siteName> |
      | TestHarnessPage | <THPage>   |
    When the user enters following information in the Acquisition Site DCE TestHarness page
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
      | Plan Name       | <planName>        |
    Then user adds drug to drug cost estimator flow for the given plan name in AARP site
      | PlanName   | <planName>  |
      | Drug Name1 | <drugName1> |
    And selects drug details in ums site
      | Drug Name1 | <drugName1> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the AMS site for TestHarness
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
    When user successfully adds drug in the AMS site for TestHarness
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
    Then the user validates Local Storage for Zip, added drugs and Pharmacy details
      | Zip Code      | <zipcode>       |
      | Drug Name1    | <genericName1>  |
      | Drug Name2    | <drugName2>     |
      | Drug Name3    | <genricName3>   |
      | Pharmacy Name | <pharmacyName> |

    Examples: 
      | THPage | siteName | zipcode | isMultutiCounty | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                     | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |  |
      | dce    | Ulayer   |   90002 | NO              | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | CVS PHARMACY                     | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |  |
      | dce    | Ulayer   |   80002 | YES             | Adams County       | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Preferred Retail | 15 miles | WALGREENS                        | PDP      | AARP MedicareRx Walgreens (PDP)                    |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |  |
      | dce    | Ulayer   |   80210 | NO              | Denver County      | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | CENTURA HEALTH PHARMACY AT PORTE | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)         |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |  |
