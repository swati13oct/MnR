  @vppNextActionModalUlayer @F445017 @F473803
Feature: 1.03-ACQ-Next Action Modal on vpp flow AARP

#**************************************************************MAPD*************************************************************************
  @vppNextActionModalRegression_12
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD Plan when no Drug cost/provider is added
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to add drugs on the VPP summary page in AARP site
    Then user should be navigated to first step of DCE Page
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MAPD     | 
    
    @vppNBAAddDrugMAPD
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Provider search on VPP summary page for MAPD Plan when Drug cost exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
    When user clicks on Find My Doctor button in AARP Site
    And user should be redirected to Provider search Rally page in AARP site
    
    Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug1   |planName| 
      |  19019 | No              | Iowa County     | MAPD     | Lipitor |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 
      
    @vppNextActionModalAddDrugProvider
    Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal on VPP summary page for MAPD plan when Drug/Provider exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
    When user clicks on Find My Doctor button in AARP Site
    When user selects a provider and retuns to VPP page in ulayer
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
      
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug1    |planName                                   |
      |  19019 | No               | Iowa County     | MAPD     | Lipitor |AARP Medicare Advantage SecureHorizons Plan|
        
   @vppNBAMAPDToPDP
   Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when user adds Drug cost from MAPD page
   Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
      When user clicks on Find My Doctor button in AARP Site
    And user should be redirected to Provider search Rally page in AARP site
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
     And Click on Find my area button in AARP
     And wait for the VPP summary page to load
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype1> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
      
    Examples:
    | zipcode | isMultutiCounty | county         | plantype   |plantype1|drug1    |planName| radius   |
      |   19019 | No              | Iowa County    | MAPD     |PDP      |Lipitor  |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |
      
      
    @vppDCEFlowtoNextActionModalMAPD
   Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Provider search on VPP summary page for MAPD Plan when drug added from DCE
   Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
      Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Medicare Advantage plan by default
      When user clicks view drug cost button
   Then the user clicks VPP Plan Details button from Drug Details Page
		Then the user click on view plan summary button on vpp detail page
		Then user should be able to see the NBA modal to add providers on the VPP summary page
     And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page  
    
    Examples: 
      | drug1    | zipCode | plantype | planName                                            | 
      | Lipitor  |   19019 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

    @vppNBAAddproviderCoveredLink
   Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD plan when Provider exists
     Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #And the user views the plans of the below plan type in AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ulayer
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    
    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planname                                          |
      |   10001 | NO              | New York County    | MAPD        | AARP Medicare Advantage Plan 2 (HMO)           |
      
      @vppNBASavedMAPDPlan
      Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and multiple plans are saved
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
   Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user saves plan as favorite on AARP site
      | Plan Type  | <testPlans>  |
   Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
   Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
    When user clicks on Find My Doctor button in AARP Site
    When user selects a provider and retuns to VPP page in ulayer
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    Then user clicks on Continue Enrollment button in AARP Site
    Then user should be able to see the Select Plan for Enroll Modal with saved plans in AARP site
       | Test Plans   | <testPlans> |
     
     Examples: 
       | zipcode | isMultutiCounty | county         | plantype |drug1   |testPlans|
       |   19019 | No              | Iowa County    | MAPD     |Lipitor |AARP Medicare Advantage Choice Plan 1 (PPO)|
  
   @vppUnsavedEnrollMAPDPlan
      
    Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and no plans are saved
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site 
   Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
     And Click on Find my area button in AARP
    When user clicks on Find My Doctor button in AARP Site
    When user selects a provider and retuns to VPP page in ulayer
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    Then user clicks on Continue Enrollment button in AARP Site
    Then user should be able to see the Select Plan for Enroll Modal with all plans in AARP site
    | Test Plans   | <testPlans> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |drug1    | dosage   | quantity | frequency     | branded | radius   |
      |   19019 | No              | Iowa County    | MAPD     |Lipitor | TAB 10MG |       30 | Every 1 month | yes     |15 miles |
  
      
   #*****************************************************PDP**************************************************************************************
      
     
      
       @vppNBAPDPNoDrug
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for PDP Plan when no Drugs added
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
     Then user Verify Next Best Action Modal for Get Started
     Then user should be navigated to first step of DCE Page
     
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | PDP      |      
      
      @vppNBAPDPAddDrug
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when Drugs are added
   Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
   Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    
      Examples: 
      | drug1    | zipcode | plantype | planName                       |
      | Lipitor  |   90210 | PDP     | AARP MedicareRx Walgreens (PDP)  | 
      
       @vppDCEFlowtoNextActionModalPDP
   Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when drug added from DCE
    Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Medicare Advantage plan by default
    When user clicks view drug cost button
   Then the user clicks VPP Plan Details button from Drug Details Page
		Then the user click on view plan summary button on vpp detail page
		Then user should be able to see the NBA modal to add providers on the VPP summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    
    Examples: 
      | drug1     | zipCode | plantype | 
      | Lipitor  |   19019 | PDP      | 
      
     
      @vppSavedPDPEnrollNBA
      Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and multiple plans are saved
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
   Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user saves plan as favorite on AARP site
      | Plan Type  | <testPlans>  |
     Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
     Then user should be navigated to first step of DCE Page
     When the user clicks on Build Drug List to navigate to Build Drug List Page
     And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site 
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
   Then user clicks on Continue Enrollment button in AARP Site
   Then user should be able to see the Select Plan for Enroll Modal with saved plans in AARP site
      | Test Plans   | <testPlans>  |
    
    Examples: 
      | zipcode | isMultutiCounty | county         | plantype |drug1  |testPlans|
      |   19019 | No              | Iowa County    | PDP     |Lipitor |AARP MedicareRx Walgreens (PDP)|
   
  @vppunSavedPDPPlans
   Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for PDP Plan when Drug cost and Enroll for All Plans 
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    Then user clicks on Continue Enrollment button in AARP Site
    Then user should be able to see the Select Plan for Enroll Modal with all plans in AARP site
       | Test Plans   | <testPlans> |
      Examples:
       | zipcode | isMultutiCounty | county         | plantype |drug1    | 
       |   19019 | No              | Iowa County    | PDP     |Lipitor   | 
      
  
   @vppPDPToMAPD
   Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for MAPD Plan when user adds Drug cost from PDP page
   Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
   Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype1> |
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
      
    Examples:
      | zipcode | isMultutiCounty | county         | plantype   |plantype1|drug1    | dosage   | quantity | frequency     | branded | radius   |
      |   19019 | No              | Iowa County    | PDP        |MAPD      |Lipitor | TAB 10MG |       30 | Every 1 month | yes     | 15 miles   |
         
      
      
      
    