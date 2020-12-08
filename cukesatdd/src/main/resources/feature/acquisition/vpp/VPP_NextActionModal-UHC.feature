@vppNextActionModalBlayer @F445017
Feature: 1.03-ACQ-Next Action Modal on vpp flow UHC

  @vppNextActionModalRegression_1 @NBA_MAPD_UHC
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD Plan when no Drug cost/provider is added
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
     Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
     When user clicks on Get Started button in UMS site
     Then user should be navigated to first step of DCE Page
      Examples:
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MAPD     |
      
      
      @vppNextActionModalRegressionMAPDAddDrug @NBA_MAPD_UHC
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD Plan when Drug cost exists
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
     	When user clicks on Get Started button in UMS site
     	Then user should be navigated to first step of DCE Page
     	When the user clicks on Build Drug List to navigate to Build Drug List Page
     And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to add providers on the VPP summary page in UMS site
    When user clicks on Find My Doctor button in UMS Site
    Then user should be redirected to Provider search Rally page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug1    | dosage   | quantity | frequency     | branded |planName| radius   |
      |  19019 | No              | Iowa County     | MAPD     | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |
      
      @vppNextActionModalAddProvider @NBA_MAPD_UHC
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD plan when Provider exists
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
     Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
     When user Click on Is my Provider covered link ums
      | PlanName | <planname> |
     When user selects a provider and retuns to VPP page in ums
    Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
    When user clicks on Get Started button in UMS site
    Then user should be navigated to first step of DCE Page
      Examples: 
      |zipcode | isMultutiCounty | county         | plantype |planname                          |
      |  19019 | No              | Iowa County    | MAPD     |AARP Medicare Advantage Choice Plan 2 (PPO)|
      
      @vppNextActionModalAddDrugAndProviderEnrollPlan @NBA_MAPD_UHC
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD plan when both Drug cost and  Provider are added
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
    When user clicks on Get Started button in UMS site
    Then user should be navigated to first step of DCE Page
      	When the user clicks on Build Drug List to navigate to Build Drug List Page
     And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to add providers on the VPP summary page in UMS site
     When user clicks on Find My Doctor button in UMS Site
     When user selects a provider and retuns to VPP page in ums
     Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
      Examples: 
      |zipcode | isMultutiCounty | county         | plantype |drug1    | dosage   | quantity | frequency     | branded |radius   |
      |  19019 | No              | Iowa County    | MAPD     |Lipitor | TAB 10MG |       30 | Every 1 month | yes     |15 miles |
          
      
     @vppNextActionModalRegressionMAPD @NBA_MAPD_UHC
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Provider search on VPP summary page for MAPD Plan when drug added from DCE
    Given the user is on medicare acquisition site landing page
   		|Site| <site>|
     When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
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
     When user clicks on Find My Doctor button
     Then user should be redirected to Provider search Rally page
      Examples: 
      |site| zipCode | isMultutiCounty | county         | plantype |drug1    |
      |UHC|   19019 | No              | Iowa County    | MAPD      |Lipitor |
      
      @vppNextActionModalRegressionPDPAddDrug @NBA_PDP_UHC
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when drug added from DCE
    Given the user is on medicare acquisition site landing page
   		|Site| <site>|
     When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
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
      |site| zipCode | isMultutiCounty | county         | plantype |drug1    |
      |UHC|  19019 | No              | Iowa County    | PDP     |Lipitor |
      
      @vppNextActionModalRegressionPDPAddDrug @NBA_PDP_UHC
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for DCE on VPP summary page for PDP Plan when no Drugs added
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
     Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
     When user clicks on Get Started button in UMS site
    Then user should be navigated to first step of DCE Page
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |  19019 | No              | Iowa County    | PDP     |
      
       @vppNextActionModalRegressionPDPAddDrug @NBA_PDP_UHC
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when Drugs are added
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
     Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      When user clicks on Get Started button in UMS site
    Then user should be navigated to first step of DCE Page
     	When the user clicks on Build Drug List to navigate to Build Drug List Page
     And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
		When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug1    |
      |  19019 | No              | Iowa County     | PDP     | Lipitor |
      
      @vppNextActionModalRegressionMAAddProvider @NBA_PDP_UHC
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when user adds Drug cost from MAPD page
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      When user clicks on Get Started button in UMS site
    Then user should be navigated to first step of DCE Page
     	When the user clicks on Build Drug List to navigate to Build Drug List Page
     And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
  	When user clicks on Return to plan summary page link in DCE
    And wait for VPP summary page to load
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype1> |
      Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |plantype1|drug1    |
      |   19019 | No              | Iowa County    | MAPD     |PDP|Lipitor |
      
      
      @vppNextActionModalRegressionMAAddProvider @NBA_PDP_UHC
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Provider Search on VPP summary page for MAPD Plan when user adds Drug cost from PDP page
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      When user clicks on Get Started button in UMS site
    Then user should be navigated to first step of DCE Page
     	When the user clicks on Build Drug List to navigate to Build Drug List Page
     And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
  	When user clicks on Return to plan summary page link in DCE
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype1> |
     Then user should be able to see the NBA modal to add providers on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |plantype1|drug1    |
      |   19019 | No              | Iowa County    | PDP     |MAPD|Lipitor |
      
      
      
      @vppNextActionModalEnrollPlanPopupWithSavedPlanMAPD @NBA_MAPD_UHC
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and multiple plans are saved in MAPD
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And user saves plan as favorite on UMS site
      | Test Plans   | <testPlans>  |
      Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      When user clicks on Get Started button in UMS site
    Then user should be navigated to first step of DCE Page
     	When the user clicks on Build Drug List to navigate to Build Drug List Page
     And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to add providers on the VPP summary page in UMS site
     When user clicks on Find My Doctor button in UMS Site
     When user selects a provider and retuns to VPP page in ums
     Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
     When user clicks on Continue Enrollment button in UMS Site
     Then user should be able to see the Select Plan for Enroll Modal with saved plans in UMS site
     | Test Plans   | <testPlans>  |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |drug1    |testPlans|
      |   19019 | No              | Iowa County    | MAPD     |Lipitor |AARP Medicare Advantage Choice Plan 1 (PPO)|
  
  @vppNextActionModalEnrollPlanPopupWithAllPlansMAPD @NBA_MAPD_UHC
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and no plans are saved in MAPD
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      When user clicks on Get Started button in UMS site
    Then user should be navigated to first step of DCE Page
      When the user clicks on Build Drug List to navigate to Build Drug List Page
     And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to add providers on the VPP summary page in UMS site
     When user clicks on Find My Doctor button in UMS Site
     When user selects a provider and retuns to VPP page in ums
     Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
     When user clicks on Continue Enrollment button in UMS Site
     Then user should be able to see the Select Plan for Enroll Modal with all plans in UMS site
     When user clicks on Enroll in plan button on the select plan modal in UHC
     Then user should be navigated to OLE page in UHC
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |drug1    |
      |   19019 | No              | Iowa County    | MAPD     |Lipitor |
  
   @vppNextActionModalEnrollPlanPopupWithAllPlansPDP @NBA_PDP_UHC
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and no plans are saved in PDP
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      When user clicks on Get Started button in UMS site
    Then user should be navigated to first step of DCE Page
      When the user clicks on Build Drug List to navigate to Build Drug List Page
     And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
     Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
     When user clicks on Continue Enrollment button in UMS Site
     Then user should be able to see the Select Plan for Enroll Modal with all plans in UMS site
     When user clicks on Enroll in plan button on the select plan modal in UHC
     Then user should be navigated to OLE page in UHC
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |drug1    |
      |   19019 | No              | Iowa County    | PDP     |Lipitor |
      
      @vppNextActionModalEnrollPlanPopupWithSavedPlanPDP123 @NBA_PDP_UHC
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and multiple plans are saved in PDP
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And user saves plan as favorite on UMS site
      | Test Plans   | <testPlans>  |
      Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      When user clicks on Get Started button in UMS site
     Then user should be navigated to first step of DCE Page
      When the user clicks on Build Drug List to navigate to Build Drug List Page
     And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
     And clicks on Review drug cost button
		Then user should be able to see Medicare Advantage plan by default
      When user clicks on Return to plan summary page link in DCE
     Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
     When user clicks on Continue Enrollment button in UMS Site
     Then user should be able to see the Select Plan for Enroll Modal with saved plans in UMS site
     | Test Plans   | <testPlans>  |
     When user clicks on Enroll in plan button on the select plan modal in UHC
     Then user should be navigated to OLE page in UHC
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |drug1    |testPlans|
      |   19019 | No              | Iowa County    | PDP     |Lipitor |AARP MedicareRx Walgreens (PDP)|