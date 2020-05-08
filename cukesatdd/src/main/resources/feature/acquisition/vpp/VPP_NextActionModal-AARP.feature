
@vppNextActionModalUlayer
Feature: 1.03-ACQ-Next Action Modal on vpp flow AARP

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
    Then user Verify Next Best Action Modal for MAPD Plan
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
    Then user Verify Next Best Action Modal for MAPD Plan and click on Get Started 
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
      
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug    | dosage   | quantity | frequency     | branded |planName|radius  |
      |  19019 | No              | Iowa County     | MAPD     | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan|15 miles|
      
    @vppNextActionModalAddDrugProvider
    Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal on VPP summary page for MAPD plan when Drug/Provider exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    #And the user views the plans of the below plan type in AARP site
    Then the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
     #Then user Verify Next Best Action Modal for MAPD Plan and click on Get Started 
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
    Then the user navigates to the plan Details page
      | Plan Name | <planName> |
    Then the user Click on Find My Doctors button
    When user selects a provider and retuns to VPP plan details page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer
      
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
    #And the user views the plans of the below plan type in AARP site
    Then the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
      
     #Then user Verify Next Best Action Modal for MAPD Plan and click on Get Started 
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
    Then the user navigates to the plan Details page
      | Plan Name | <planName> |
    Then the user Click on Find My Doctors button
    When user selects a provider and retuns to VPP plan details page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer
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
    #And the user views the plans of the below plan type in AARP site
    Then the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
     #Then user Verify Next Best Action Modal for MAPD Plan and click on Get Started 
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
      
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug    | dosage   | quantity | frequency     | branded |planName|radius  |
      |  19019 | No              | Iowa County     | MAPD     | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan|15 miles|
      
      
    @vppDCEFlowtoNextActionModal
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
    Then user Verify Next Best Action Modal for MAPD Plan
    #Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    Then user validates drug cost in medical benefit section in the AARP site
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then user validates drug added on prescription drug benefits tab in AARP
      | Drug | <drug> |

    Examples: 
      | drug    | dosage   | quantity | frequency     | branded | zipcode | plantype | planName                                            | radius   |
      | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |

    
    @vppNextActionModalRegressionMAPlan
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Provider search on VPP summary page for MA Plan when no provider is added
     Given the user is on AARP medicare acquisition site landing page
     When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
     And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
      #Then user Verify Next Best Action Modal for MA Plan
     Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA       | 
     
       
       
       @vppNextActionModalRegressionMAAddProvider
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll plan on VPP summary page for MA plan when Provider is added from VPP summary page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then the user navigates to the plan Details page
      | Plan Name | <planName> |
    Then the user Click on Find My Doctors button
    When user selects a provider and retuns to VPP plan details page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer
      Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          |
      |   10001 | NO              | New York County | MA          |AARP Medicare Advantage Essential (HMO)| 
      
    @vppNextActionModalRegressionMAAddProviderEnrollPlan
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for MP Plan when Provider and Enroll Plan exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then the user navigates to the plan Details page
      | Plan Name | <planName> |
    Then the user Click on Find My Doctors button
    When user selects a provider and retuns to VPP plan details page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer
      Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          |
      |   10001 | NO              | New York County    | MA       |AARP Medicare Advantage Essential (HMO)            |
     
      #Then user click on Continue Enrollment to enroll in MA plan
      
      
       @vppDCEFlowtoNextActionModalMA
   Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Provider search on VPP summary page for MA Plan when drug added from DCE
     Given the user is on AARP medicare acquisition site landing page
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
    And I select the first pharmacy
    Then I navigate back to plan details page and verify Next Action Modal for Provider search
    
    Examples: 
      | zipcode | drug    | dosage   | quantity | frequency     | branded |
      |   33021 | Lipitor | TAB 10MG |    30    | Every 1 month | yes     |
      
       @vppNextActionModalRegressionPDP
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for DCE on VPP summary page for PDP Plan when no Drugs added
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
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

      