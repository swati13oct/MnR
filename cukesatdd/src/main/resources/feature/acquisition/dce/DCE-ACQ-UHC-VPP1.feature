@acq_DCE_VPP1_UHC
Feature: 2.10.2 ACQ-DCE-VPP_1 UHC - To test DCE to VPP Plan Summary in AARP site


  @switchNowStep3Blayer @dceVBF @DCE_Regression_Blayer_VPP1 @prodRegression
  Scenario Outline: 2.10.2.1 To test the dce vpp flow with switch now option
    Given user is on blue layer landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    And I access the DCE tool
      | Plan Type | <plantype> |
    And I have added a drug to my drug list on ums site
      | Drug | <drug> |
    And user selects drug details in ums site
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug in ums site
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page on ums site
    And I select the first pharmacy on there
    And I navigate to step3 page and validate the drug info
      | Drug | <drug> |
    Then I switch to generic drug and validate on ums site
    And the user clicks on return link to navigate to plan summary in UHC

    Examples: 
      | zipcode | plantype | drug    | dosage   | county | isMultutiCounty | quantity | frequency     | branded |
      |   90210 | MA       | Lipitor | TAB 10MG | none   | no              |       30 | Every 1 month | yes     |

  @dceThroughPlanSummaryNonAepUHC @uhc @DCE_Regression_Blayer @dce1 @uhcDce1
  Scenario Outline: 2.10.2.2 To Verify the drug cost estimator flow for <plantype> for non AEP periodthrough plan summary: PlanName <planName>; ZipCode <zipcode>
    Given user is on blue layer landing page
    When user performs plan search using following information in the UMS site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
    And user access DCE tool on UMS site
      | Plan Type | <plantype> |
      | PlanName  | <planName> |
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
    And the user clicks on Back to Plans button in UMS site
    Then user validates Drug information is reflected on plan summary page in UMS site
      | PlanName | <planName> |

    #Test ID: 15487,15490,15494
@DCE_Regression_Blayer_VPP2MAPD
    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   90002 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | CVS PHARMACY                    | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |
@DCE_Regression_Blayer_VPP2PDP
    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   90210 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Preferred Retail | 15 miles | COMMUNITY, A WALGREENS PHARMACY | PDP      | AARP MedicareRx Walgreens (PDP)                    |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |
 @DCE_Regression_Blayer_VPP2SNP
    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   80210 | Denver County      | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | CENTURA HEALTH PHARMACY AT PORTE | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)         |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |


      