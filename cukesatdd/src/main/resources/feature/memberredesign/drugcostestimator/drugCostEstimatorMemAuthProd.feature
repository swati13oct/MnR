@drugCostEstimator
Feature: 1.07.1 Member DCE Page - Member Auth - PROD

  @drugCostEstimator1 @Member_dce_not @NegativeScenario  @prod @prod_dce_p1
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> -I1.2 To Verify MR portal members DCE should not come for AARP federal members
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
      | index | TID   | username | password | MemUserName       | planType | memberType   |
      | 01    | 15327 | kkumard  | tnps459# |  DKELLY27	        | SSUP     | SSUP_DCE     | 

	@prod_sanity_01 
    Examples: 
      | index | TID   | username | password | MemUserName       | planType | memberType   |
      | 02    | 15326 | kkumard  | tnps459# | tntparents82	    | SHIP     | SHIP_DCE     |
      | 03    | 15337 | kkumard  | tnps459# | ssmhi1     	    | MA       | MA_DCE       |
      
   
  @drugCostEstimator2 @prod @prod_dce_p2
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> -I1.1 To Verify MR portal members using DCE on a desktop device Pharmacy search tab validation
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
    When I navigate to drug look up page
    And I navigate to step2 page
    Then I should be able to move forward or backward in the tool flow

    Examples: 
      | index | TID   | username | password | MemUserName    | planType | memberType |drug1   | dosage1          | quantity1 | frequency1  |
      | 04    | 15325 | kkumard  | tnps459# | LMHOCHSCHILD11 | MAPD     | MAPD_DCE   |Lipitor | Lipitor TAB 10MG |        31 | Every 1 month |
  
   @drugCostEstimator3 @prod @prod_dce_p2
   Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Pharmacy saver results
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
    And I navigate to step2 page
    And we search the pharmacy within miles zipcode and pharmacy type
      | Zipcode       | <zipcode>      |
      | Radius        | <radius>       |
      | Pharmacy Type | <pharmacytype> |
    Then I should see pharmacy results as per the filter
    When I navigate to costs tab
    Then I should see cost of the drug
    Then I should see learn more about the drug tiers and learn more about the drug payment stages link
    
    Examples: 
      | index | TID   | username | password | MemUserName        | planType| memberType| zipcode| radius  | pharmacytype |
      | 05    | 15325 | kkumard  | tnps459# | LMHOCHSCHILD11     | MAPD    | MAPD_DCE  | 60081  | 25 miles| Pharmacy Saver|
  #   | 06    | 15325 | kkumard  | tnps459# | BATLLOT@AOL.COM    | PCP     | PCP_DCE   | 06450  | 25 miles| Pharmacy Saver|
      | 07    | 15325 | kkumard  | tnps459# | SOFYABAKMAN@MSN.COM| PCP     | PCP_DCE   | 33009  | 15 miles| Pharmacy Saver|
      
   @prod_sanity_02
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Pharmacy saver results
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
    And I navigate to step2 page
    And we search the pharmacy within miles zipcode and pharmacy type
      | Zipcode       | <zipcode>      |
      | Radius        | <radius>       |
      | Pharmacy Type | <pharmacytype> |
    Then I should see pharmacy results as per the filter
    When I navigate to costs tab
    Then I should see cost of the drug     
    
     Examples: 
      | index | TID   | username | password | MemUserName | planType| memberType| zipcode| radius  | pharmacytype  |
      | 08    | 15325 | kkumard  | tnps459# | LMHOCHSCHILD11| MAPD  | MAPD_DCE  | 60081  | 25 miles| Pharmacy Saver|
      | 09    | 15325 | kkumard  | tnps459# | SOFYABAKMAN@MSN.COM| PCP| PCP_DCE | 33009  | 15 miles| Pharmacy Saver|

  @drugCostEstimator6  @Member_DCE_sso
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> -I1.3 To Verify MR portal group members DCE should redirect to optum rx sso landing page.
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
    Then  I click on drug lookup tile which takes me to optum rx sso landing page

    Examples: 
      | index | TID   | username | password | MemUserName   | planType | memberType    |
      | 10    | 15338 | kkumard  | tnps459# | q2_jun_grp0022| PDP      | PDP_GROUP_DCE |      
      
  @formualrypdflink  @prod @prod_dce_p2
  Scenario Outline:  Index: <index> - DCE Tool to search a plan for a drug that requires Prior Authorization or Step Therapy on the 2020 formulary
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
  And I navigate to step2 page
  Then I will verify the Formulary pdf link
  When I navigate to costs tab
  Then I will verify the Formulary pdf link

  Examples: 
      | index | username | password | MemUserName        | planType | memberType | drug   | dosage         | quantity | frequency     | Medicine | dose                 |quantity2 | frequency2    |
      | 11    | kkumard  | tnps459# | LMHOCHSCHILD11     | MAPD     |MAPD_DCE    | FANAPT | FANAPT TAB 1MG |       60 | Every 1 month | AIMOVIG  | AIMOVIG INJ 70MG/ML  |  1       | Every 1 month |
