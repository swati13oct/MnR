
@vppNextActionModalUlayer
Feature: 1.03-ACQ-Next Action Modal on vpp flow AARP

#**************************************************************MAPD*************************************************************************
  @vppNextActionModalRegression_1 @test1
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD Plan when no Drug cost/provider is added
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify Next Best Action Modal for Get Started
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MAPD     | 
    
    @vppNextActionModalRegressionMAPDAddDrug @test
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Provider search on VPP summary page for MAPD Plan when Drug cost exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started
    And I have added a drug to my drug list from VPP
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
   And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
    And user verifies annual drug cost in the Plan Cost tab of AARP site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in AARP site
    Then user validates Drug information is reflected on plan summary page in AARP site
      | PlanName | <planName> |
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
    
    Examples: 
      | drug    | dosage   | quantity | frequency     | branded | zipcode | plantype | planName                                            | radius   |
      | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |
      
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
    Then user Verify and click perform on Next Best Action Modal for Get Started
    And I have added a drug to my drug list from VPP
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
   And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
    And user verifies annual drug cost in the Plan Cost tab of AARP site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in AARP site
    Then user validates Drug information is reflected on plan summary page in AARP site
      | PlanName | <planName> |
 Then user verify and click on the NBA modal to add providers on the VPP summary page in AARP site
   # When user selects a provider and retuns to VPP plan details page in ulayer
   # Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer
      
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug    | dosage   | quantity | frequency     | branded |planName                                 |radius  |
      |  19019 | No               | Iowa County     | MAPD     | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan|15 miles|
      
      
        
     @vppNextActionModalAddDrugAndProviderEnrollPlan
    Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for MAPD plan when both Drug cost and  Provider are added
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started
    And I have added a drug to my drug list from VPP
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
   And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
    And user verifies annual drug cost in the Plan Cost tab of AARP site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in AARP site
    Then user validates Drug information is reflected on plan summary page in AARP site
      | PlanName | <planName> |
 # Then user verify the NBA modal to add providers on the VPP summary page in AARP site
   #Then the user Click on Find My Doctors button
    #When user selects a provider and retuns to VPP plan details page in ulayer
    #Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer
    #Then user click on Continue Enrollment to enroll in MAPD plan
      
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug    | dosage   | quantity | frequency     | branded |planName                                 |radius  |
      |  19019 | No               | Iowa County     | MAPD     | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan|15 miles|
      
   @vppNextActionModalRegressionMAPDToPDP 
   Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when user adds Drug cost from MAPD page
  Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started
    And I have added a drug to my drug list from VPP
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
   And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
    And user verifies annual drug cost in the Plan Cost tab of AARP site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in AARP site
    Then user validates Drug information is reflected on plan summary page in AARP site
      | PlanName | <planName> |
     #And the user views the plans of the below plan type in AARP site
     # | Plan Type | <plantype1> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug    | dosage   | quantity | frequency     | branded |planName|radius  |plantype1|
      |  19019 | No              | Iowa County     | MAPD     | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan|15 miles|PDP|
      
      
    @vppDCEFlowtoNextActionModal1
   Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Provider search on VPP summary page for MAPD Plan when drug added from DCE
   Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page
      | Zipcode | <zipcode> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify Next Best Action Modal for Get Started
    #Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    Then user validates drug cost in medical benefit section in the AARP site
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then user validates drug added on prescription drug benefits tab in AARP
      | Drug | <drug> |
    #Then user verify NBA to add provider in AARP site

    Examples: 
      | drug    | dosage   | quantity | frequency     | branded | zipcode | plantype | planName                                            | radius   |
      | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |

    @ProviderSearchFromhome
   Scenario Outline: Test to verify the Next action modal for DCE on VPP summary page for MAPD Plan when provider saved from Provider search
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the Home Page
    Then the user enters the zipcode and select a plan on the Rally tool
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
       | 	Year  | <year>	   |
    When user selects a provider and saves it

    Examples: 
      | zipcode | planname                                          | year		  |
      |   10001 | AARP Medicare Advantage Plan 2 (HMO)              |nextYear	  |
      
      @savedMAPDAndNBA1
      Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and multiple plans are saved
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user saves two plans as favorite on AARP site
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt on AARP site
    Then user click on continue as guest button on AARP site
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |  
    Then User clicks on Back to Plans link and navigate back to plan summary in AARP site  
     #And the user views the plans of the below plan type in AARP site
      #| Plan Type | <plantype>
    #Then user Verify and click perform on Next Best Action Modal for Get Started
    Examples: 
      | state   | UID       | zipcode | isMultiCounty | plantype | county           | testPlans   |                                                                                             
      | Alabama | US1770330 |   53503 | NO            | MAPD     | Jefferson County | UnitedHealthcare Medicare Advantage Open (PPO),UnitedHealthcare Medicare Advantage Open Essential (PPO) |
      
      
      
   #*****************************************************PDP**************************************************************************************
      
     
      
       @vppNextActionModalRegressionPDP
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for PDP Plan when no Drugs added
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
     Then user Verify Next Best Action Modal for Get Started
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | PDP      |      
      
      @vppNextActionModalRegressionPDPAddDrug
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when Drugs are added
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then user Verify and click perform on Next Best Action Modal for Get Started
    And I have added a drug to my drug list from VPP
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
     | Drug | <drug> |
   And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
    And user verifies annual drug cost in the Plan Cost tab of AARP site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in AARP site
    Then user validates Drug information is reflected on plan summary page in AARP site
      | PlanName | <planName> |
 # Then user verify the NBA modal to continue enrollment on the VPP summary page in AARP site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug    | dosage   | quantity | frequency     | branded |planName                                   |radius  |
      |  19019 | No               | Iowa County     | PDP     | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP MedicareRx Walgreens (PDP)|15 miles|
      
      
      @vppNextActionModalRegressionPDPAddDrugAndEnrollPlan
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for PDP Plan when Drug cost exists And Enroll Plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
       #Then user Verify Next Best Action Modal for PDP Plan and click on Get Started
     And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |

      And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
    #Then user return to vpp home page 
    Then user validates drug cost in medical benefit section in the AARP site
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then user validates drug added on prescription drug benefits tab in AARP
      | Drug | <drug> |
    #Then user click on Continue Enrollment to enroll in PDP plan
      
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug    | dosage   | quantity | frequency     | branded |planName                                   |radius  |
      |  19019 | No               | Iowa County     | PDP     | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP MedicareRx Walgreens (PDP)|15 miles|
      
      
       @vppDCEFlowtoNextActionModalPDP
   Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when drug added from DCE
    Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page
      | Zipcode | <zipcode> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user Verify Next Best Action Modal for PDP Plan
    #Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    Then user validates drug cost in medical benefit section in the AARP site
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then user validates drug added on prescription drug benefits tab in AARP
      | Drug | <drug> |

    Examples: 
      | drug    | dosage   | quantity | frequency     | branded | zipcode | plantype | planName                                            | radius   |
      | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |   90210 | PDP     | AARP MedicareRx Walgreens (PDP) | 15 miles |
      
    @providerSavedPDPfromProviderSearch
     Scenario Outline: Test to verify the Next action modal for DCE on VPP summary page for PDP Plan when provider saved from Provider search
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the Home Page
    Then the user enters the zipcode and select a plan on the Rally tool
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
       | 	Year  | <year>	   |
    When user selects a provider and saves it

    Examples: 
      | zipcode | planname                                          | year		  |
      |   10001 | AARP MedicareRx Walgreens (PDP) |nextYear	  |
      
      
      @savedPDPAndNBA
      Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and multiple plans are saved

    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user saves two plans as favorite on AARP site
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt on AARP site
    Then user click on continue as guest button on AARP site
    And user validates the added plans on visitor profile page of AARP site
      | Test Plans | <testPlans> |
    And user clicks on plan name in AARP
      | Test Plans | <testPlans> |    
    #Then user click on back to plans 
     #And the user views the plans of the below plan type in AARP site
      #| Plan Type | <plantype>
    #Then user Verify and click perform on Next Best Action Modal for Get Started
    
     Examples: 
      | state   | UID       | zipcode | isMultiCounty | plantype | county           | testPlans   |                                                                                             
      | Alabama | US1770330 |   53503 | NO            | PDP     | Jefferson County | AARP MedicareRx Walgreens (PDP),AARP MedicareRx Preferred (PDP) |
