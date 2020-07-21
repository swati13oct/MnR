@drugCostEstimator @regressionMember
Feature: 1.07.1 Member DCE Page - Member Auth

  @drugCostEstimator1 @Member_dce_not @NegativeScenario  @Dce_memAuth 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -I1.2 To Verify MR portal members DCE should not come for AARP federal members
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username     | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
   Then I should not see drug look up on home page

    Examples: 
      | TID   | username  | password  | MemUserName        | planType | memberType   |
      | 15326 | qavgogine | qavgogine | q1_feb_ship_20_001 | SHIP     | SHIP_DCE     |
      | 15337 | qavgogine | qavgogine | q2_may_rally017    | MA       | MA_DCE       |
      | 15327 | qavgogine | qavgogine | q2_may_combo006    | SSUP     | SSUP_DCE     |
   
   @drugCostEstimator2  @Dce_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -I1.1 To Verify MR portal members using DCE on a desktop device Pharmacy search tab validation
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    When I navigate to drug look up page
    When I delete all added drugs
    When I add branded drug
      | Drug      | <drug1>      |
      | Dosage    | <dosage1>    |
      | Quantity  | <quantity1>  |
      | Frequency | <frequency1> |
    And I navigate to step2 page
    Then I should be able to move forward or backward in the tool flow

    Examples: 
      | TID   | username  | password  | MemUserName         | planType | memberType |drug1   | dosage1          | quantity1 | frequency1  |
      | 15325 | qavgogine | qavgogine | q3_sep_UAT4_UHC092 | MAPD     |MAPD_DCE    |Lipitor | Lipitor TAB 10MG |        31 | Every 1 month |
  
   @drugCostEstimator3 @Dce_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Pharmacy saver results
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
        | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When I navigate to drug look up page
    When I delete all added drugs
    When I add branded drug
      | Drug      | <drug1>      |
      | Dosage    | <dosage1>    |
      | Quantity  | <quantity1>  |
      | Frequency | <frequency1> |
    And I navigate to step2 page
    And we search the pharmacy within miles zipcode and pharmacy type
      | Zipcode       | <zipcode>      |
      | Radius        | <radius>       |
      | Pharmacy Type | <pharmacytype> |
    Then I should see pharmacy results as per the filter
    And I should see pharmacy saver pharmacies in results

    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType | zipcode | radius   | pharmacytype   |drug1   | dosage1          | quantity1 | frequency1  |
      | 15325 | qavgogine | qavgogine | q3_sep_UAT4_UHC092 | MAPD     | MAPD_DCE   | 06450   | 25 miles | Pharmacy Saver |Lipitor | Lipitor TAB 10MG |        31 | Every 1 month |

   @drugCostEstimator4 @Dce_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -I1.1 To Verify MR portal DCE flow covering step1 step 2 and step3 .
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
        | Plan Type   | <planType>   |
      | Member Type | <memberType> |
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
      | TID   | username  | password  | MemUserName     | planType |memberType | drug1  | dosage1          | quantity1 | frequency1    | dosage2          | brandeddrug      | genericdosage                 | zipcode | radius   |quantity2 | frequency2     |
      | 15325 | qavgogine | qavgogine | q3_sep_UAT4_UHC092 | MAPD     | MAPD_DCE  | Lipitor| Lipitor TAB 10MG |        31 | Every 1 month | Lipitor TAB 20MG | Lipitor TAB 20MG | atorvastatin calcium TAB 20MG |   00820 | 25 miles |    100 | Every 3 months |

  @drugCostEstimator6  @Dce_memAuth @Member_DCE_sso 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -I1.3 To Verify MR portal group members DCE should redirect to optum rx sso landing page.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
        | Plan Type   | <planType>   |
        | Member Type | <memberType> |
    When I navigate to drug look up page
    Then  I click on drug lookup tile which takes me to optum rx sso landing page

    Examples: 
      | TID   | username  | password  | MemUserName   | planType | memberType |
      | 15338 | qavgogine | qavgogine | q2_jun_grp0022| PDP      | PDP_GROUP_DCE | 
      
  @drugCostEstimator7 @switch_to_generic_case_1 @Dce_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To Verify MR portal members using DCE on a desktop device, I want to be able to switch from branded to generic drug, given that  pharmacy is selected and it suggests the user with an appropriate save money message.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
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
      | TID   |username  | password  | MemUserName   | planType  |memberType | drug    | dosage | quantity | frequency |
      | 15325 |qavgogine|qavgogine| q3_sep_UAT4_UHC092|MAPD|MAPD_DCE | Lipitor | Lipitor TAB 10MG |   31 | Every 1 month |  
      
  @drugCostEstimator8 @switch_to_generic_case_2 @Dce_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -To Verify MR portal members using DCE on a desktop device, I want to be able to switch from branded to generic drug, given that a pharmacy is not selected and it suggests the user with an appropriate save money message and cost savings are also updated
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
        | Plan Type   | <planType>   |
      | Member Type | <memberType> |
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
      | TID   |username  | password  | MemUserName | planType | memberType |drug    | dosage  | quantity | frequency |
      | 15325 |qavgogine|qavgogine|q3_sep_UAT4_UHC092| MAPD|MAPD_DCE| Lipitor | Lipitor TAB 10MG |  31 | Every 1 month |  
      
   @vbfGate @MemberVBF @Dce_memAuth
  Scenario Outline: plan: <planType> -memberType: <memberType> - To Verify MR portal members end to end DCE flow for vbf
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
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
     |username | password| MemUserName | planType | memberType | drug    | dosage | quantity | frequency     |
     |qavgogine|qavgogine| q2_june_VBF_005| MAPD | UhcMapdInd | Lipitor | Lipitor TAB 10MG | 31 | Every 1 month |
      
  @formualrypdflink @Dce_memAuth
  Scenario Outline:  DCE Tool to search a plan for a drug that requires Prior Authorization or Step Therapy on the 2020 formulary
  Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
        | Plan Type   | <planType>   |
        | Member Type | <memberType> |
  When I navigate to drug look up page
  Then I will verify the Formulary pdf link
  When I delete all added drugs
  And I am using the DCE Tool to search a drug that requires Prior Authorization on the 2020 formulary
  	  | Drug      | <drug>       |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
  And I am using the DCE Tool to search a drug that requires Step Therapy on the 2020 formulary
  	  | Med     | <Medicine>   |
      | Dose    | <dose>       |
      | Amount  | <quantity2>  |
      | Limit   | <frequency2> |
  And I navigate to step2 page
  Then I will verify the Formulary pdf link
  When I navigate to costs tab
  Then I will verify the Formulary pdf link
  Examples: 
      | username  | password  | MemUserName        | planType | memberType | drug   | dosage         | quantity | frequency     | Medicine | dose                 |quantity2 | frequency2    |
      | qavgogine | qavgogine | q3_sep_UAT4_UHC092 | MAPD     |MAPD_DCE    | FANAPT | FANAPT TAB 1MG |       60 | Every 1 month | AIMOVIG  | AIMOVIG INJ 70MG/ML  |  1       | Every 1 month |

