@drugCostEstimator @regressionMember
Feature: I1.3DCE for Member Site Redesign

  @drugCostEstimator1 @Member_dce_not
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -I1.2 To Verify MR portal members DCE should not come for AARP federal members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then I should not see drug look up on home page

    Examples: 
      | TID   | planType | memberType              |
      | 15326 | Medsup   | EFT_MedSelectPlan_order |
      | 15327 |          | SSUP_ProfilePref        |
      | 15337 | MA       | q1_uhc_feb0021          |

  @drugCostEstimator2
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -I1.1 To Verify MR portal members using DCE on a desktop device Pharmacy search tab validation
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When I navigate to drug look up page
    Then I should see the Pharmacy search tab as a clickable element within the DCE tool
    And I should be able to move forward or backward in the tool flow

    Examples: 
      | TID   |  memberType                    |
      | 15325 |  MAPD_AARP_GOGreen_Profilepref |

  @drugCostEstimator3
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Pharmacy saver results
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When I navigate to drug look up page
    And I navigate to step2 page
    And we search the pharmacy within miles zipcode and pharmacy type
      | Zipcode       | <zipcode>      |
      | Radius        | <radius>       |
      | Pharmacy Type | <pharmacytype> |
    Then I should see pharmacy results as per the filter
    And I should see pharmacy saver pharmacies in results

    Examples: 
      | TID   |  memberType                    | zipcode | radius   | pharmacytype   |
      | 15325 |  MAPD_AARP_GOGreen_Profilepref |   06450 | 25 miles | Pharmacy Saver |

  @drugCostEstimator4
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -I1.1 To Verify MR portal DCE flow covering step1 step 2 and step3 .
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When I navigate to drug look up page
    When I delete all added drugs
    When I add branded drug
      | Drug      | <drug1>      |
      | Dosage    | <dosage1>    |
      | Quantity  | <quantity1>  |
      | Frequency | <frequency1> |
    When I add branded drug
      | Drug      | <drug1>      |
      | Dosage    | <dosage2>    |
      | Quantity  | <quantity2>  |
      | Frequency | <frequency2> |
    When I switch to its generic durg
      | BrandedDrug   | <dosage2>       |
      | GenericDosage | <genericdosage> |
      | Quantity      | <quantity2>     |
      | Frequency     | <frequency2>    |
    When I delete the drug
      | Dosage | <genericdosage> |
    When I navigate to Pharmacy tab
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    When I select the pharmacy from the list
    When I navigate to costs tab
    Then I should see cost of the drug
    Then I should see learn more about the drug tiers and learn more about the drug payment stages link

    Examples: 
      | TID   | memberType                    | drug1   | dosage1          | quantity1 | frequency1    | dosage2          | brandeddrug      | genericdosage                 | zipcode | radius   | quantity2 | frequency2     |
      | 15325 | MAPD_AARP_GOGreen_Profilepref | Lipitor | Lipitor TAB 10MG |        31 | Every 1 month | Lipitor TAB 20MG | Lipitor TAB 20MG | atorvastatin calcium TAB 20MG |   00820 | 25 miles |       100 | Every 3 months |

  # | 15331   | PDP      |NonLISSplittier  |Lipitor|Lipitor TAB 10MG|31|Every 1 month|Lipitor TAB 20MG|Lipitor TAB 20MG|atorvastatin calcium TAB 20MG|90210|25 miles|100|Every 3 months|
  #| 15333   | COMBO    |ComboDCEmember  |Lipitor|Lipitor TAB 10MG|31|Every 1 month|Lipitor TAB 20MG|Lipitor TAB 20MG|atorvastatin calcium TAB 20MG|90210|25 miles|100|Every 3 months|
  #@drugCostEstimator5 @drugToolNotDisplayed #This is already covered above
  #Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -To verify DCE drug tile is not displayed for certain members
  #Given login with following details logins in the member portal and validate elements
  #| Plan Type | <planType> |
  #Then I should not see drug look up on home page
  #
  #Examples:
  #| TID   | planType                |
  #| 15337 | IndividualDCEmember_DCE |
  @drugCostEstimator6 @Member_DCE_sso
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -I1.3 To Verify MR portal group members DCE should redirect to optum rx sso landing page.
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    Then I click on drug lookup tile which takes me to optum rx sso landing page

    Examples: 
      | TID   | planType      |
      # | 15329   | MAPD_GROUP_DCE  |
      | 15338 | PDP_GROUP_DCE |

  @drugCostEstimator7 @switch_to_generic_case_1
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To Verify MR portal members using DCE on a desktop device, I want to be able to switch from branded to generic drug, given that  pharmacy is selected and it suggests the user with an appropriate save money message.
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When I navigate to drug look up page
    When I delete all added drugs
    When I add branded drug
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    And I have selected pharmacy
    Then I should be presented the option to switch to the generic option
    And I will see a SWITCH NOW link in the drug tile with a pharmacy savings cost value
    And I will see a modal appear upon clicking on SWITCH NOW
    And when I click on the button to accept the generic
    Then the drug name will automatically update within the Drug List
    And any cost savings will be applied to my total cost savings in Step3

    Examples: 
      | TID   | memberType                    | drug    | dosage           | quantity | frequency     |
      | 15325 | MAPD_AARP_GOGreen_Profilepref | Lipitor | Lipitor TAB 10MG |       31 | Every 1 month |

  @drugCostEstimator8 @switch_to_generic_case_2
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -To Verify MR portal members using DCE on a desktop device, I want to be able to switch from branded to generic drug, given that a pharmacy is not selected and it suggests the user with an appropriate save money message and cost savings are also updated
    Given login with following details logins in the member portal and validate elements
      | Plan Type | <planType> |
    When I navigate to drug look up page
    When I delete all added drugs
    When I add branded drug
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    And I have not yet selected pharmacy
    Then I should be presented the option to switch to the generic option
    And I will see a SWITCH NOW link in the drug tile with appropriate save message
    And I will see a modal appear upon clicking on SWITCH NOW
    And when I click on the button to accept the generic
    Then the drug name will automatically update within the Drug List

    Examples: 
      | TID   | memberType                    | drug    | dosage           | quantity | frequency     |
      | 15325 | MAPD_AARP_GOGreen_Profilepref | Lipitor | Lipitor TAB 10MG |       31 | Every 1 month |

  @vbfGate @MemberVBF
  Scenario Outline: plan: <planType> -memberType: <memberType> - To Verify MR portal members end to end DCE flow for vbf
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When I navigate to drug look up page
    When I delete all added drugs
    When I add branded drug
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    And I have selected pharmacy
    Then I should be presented the option to switch to the generic option
    And I will see a SWITCH NOW link in the drug tile with a pharmacy savings cost value
    And I will see a modal appear upon clicking on SWITCH NOW
    And when I click on the button to accept the generic
    Then the drug name will automatically update within the Drug List
    And any cost savings will be applied to my total cost savings in Step3

    Examples: 
      | planType | memberType                 | drug    | dosage           | quantity | frequency     |
      | MAPD     | IndMAPDUHC_Pharmacylocator | Lipitor | Lipitor TAB 10MG |       31 | Every 1 month |
