@vppNextActionModalBlayer @F445017
Feature: 1.03-ACQ-Next Action Modal on vpp flow UHC

  @vppNextActionModalRegression_1 @prodRegression
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
     When user clicks on Get Started button
     Then user should be navigated to DCE page
      Examples:
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MAPD     |
      
      
      @vppNextActionModalRegressionMAPDAddDrug @testUHC
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
     	When user clicks on Get Started button
     	Then user should be navigated to DCE page
      When I have added a drug to my drug list on ums site
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
    And the user selects the pharmacy tab information
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy on there
    And I navigate to step3 page and validate drug info for DCE homepage flow uhc
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page in uhc
      | Zip | <zipcode> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to add providers on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug    | dosage   | quantity | frequency     | branded |planName| radius   |
      |  19019 | No              | Iowa County     | MAPD     | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |
      
      @vppNextActionModalAddProvider
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
      Examples: 
      |zipcode | isMultutiCounty | county         | plantype |planname                          |
      |  19019 | No              | Iowa County    | MAPD     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
      
      @vppNextActionModalAddDrugAndProviderEnrollPlan
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD plan when both Drug cost and  Provider are added
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user views plans of the below plan type in UMS site
      | PlanName | <planname> |
    Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
    When user clicks on Get Started button
    Then user should be navigated to DCE page
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
    And the user selects the pharmacy tab information
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy on there
    And I navigate to step3 page and validate drug info for DCE homepage flow uhc
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page in uhc
      | Zip | <zipcode> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      When user Click on Is my Provider covered link ums
      | PlanName | <planname> |
     When user selects a provider and retuns to VPP page in ums
     Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
      Examples: 
      |zipcode | isMultutiCounty | county         | plantype |drug    | dosage   | quantity | frequency     | branded |planName| radius   |
      |  19019 | No              | Iowa County    | MAPD     |Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |
      
      
      @vppNextActionModalRegressionMA
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MA Plan when no provider is added
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      #Then user should be able to see the NBA modal to add providers on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA     |
      
      
      @vppNextActionModalRegressionMAAddDrug
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MA plan when Provider is added from VPP summary page
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      #Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA     |
      
      
      @vppNextActionModalRegressionMAAddProvider
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Provider search on VPP summary page for MA Plan when user adds Drug cost from PDP page
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      #Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      #When user clicks on Get Started button
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
    And the user selects the pharmacy tab information
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy on there
    And I navigate to step3 page and validate drug info for DCE homepage flow uhc
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page in uhc
      | Zip | <zipcode> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype1> |
      #Then user should be able to see the NBA modal to add providers on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |plantype1|drug    | dosage   | quantity | frequency     | branded |planName| radius   |
      |   19019 | No              | Iowa County    | PDP     |MA|Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |
      
      @vppNextActionModalRegressionMAAddDrugAndProviderEnrollPlan
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Provider search on VPP summary page for MA Plan when drug added from DCE
   Given the user is on uhcmedicaresolutions site landing page
   When I access the acquisition DCE tool from home page on ums site
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
    And the user selects the pharmacy tab information
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy on there
    And I navigate to step3 page and validate drug info for DCE homepage flow uhc
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page in uhc
      | Zip | <zipcode> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      #Then user should be able to see the NBA modal to add providers on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |drug    | dosage   | quantity | frequency     | branded |planName| radius   |
      |   19019 | No              | Iowa County    | MA     |Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |
      
      @vppNextActionModalRegressionPDP
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Provider search on VPP summary page for MAPD Plan when drug added from DCE
    Given the user is on uhcmedicaresolutions site landing page
     When I access the acquisition DCE tool from home page on ums site
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
    And the user selects the pharmacy tab information
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy on there
    And I navigate to step3 page and validate drug info for DCE homepage flow uhc
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page in uhc
      | Zip | <zipcode> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
		#Then user should be able to see the NBA modal to add providers on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |drug    | dosage   | quantity | frequency     | branded |planName| radius   |
      |   19019 | No              | Iowa County    | MAPD      |Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles | 
      
      @vppNextActionModalRegressionPDPAddDrug
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when drug added from DCE
    Given the user is on uhcmedicaresolutions site landing page
    When I access the acquisition DCE tool from home page on ums site
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
    And the user selects the pharmacy tab information
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy on there
    And I navigate to step3 page and validate drug info for DCE homepage flow uhc
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page in uhc
      | Zip | <zipcode> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      #Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |drug    | dosage   | quantity | frequency     | branded |planName| radius   |
      |  19019 | No              | Iowa County    | PDP     |Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles | 
      
      @vppNextActionModalRegressionPDPAddDrug
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for DCE on VPP summary page for PDP Plan when no Drugs added
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    # When user views plans of the below plan type in UMS site
    Then user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
     #Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |  19019 | No              | Iowa County    | PDP     |
      
       @vppNextActionModalRegressionPDPAddDrug
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when Drugs are added
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    # When user views plans of the below plan type in UMS site
    Then user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
     #Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      #When user clicks on Get Started button
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
    And the user selects the pharmacy tab information
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy on there
    And I navigate to step3 page and validate drug info for DCE homepage flow uhc
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page in uhc
      | Zip | <zipcode> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    #Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype | drug    | dosage   | quantity | frequency     | branded |planName| radius   |
      |  19019 | No              | Iowa County     | PDP     | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |
      
      @vppNextActionModalRegressionMAAddProvider
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when user adds Drug cost from MAPD page
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
      #Then user should be able to see the NBA modal to add drugs on the VPP summary page in UMS site
      #When user clicks on Get Started button
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
    And the user selects the pharmacy tab information
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy on there
    And I navigate to step3 page and validate drug info for DCE homepage flow uhc
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page in uhc
      | Zip | <zipcode> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype1> |
      #Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in UMS site
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |plantype1|drug    | dosage   | quantity | frequency     | branded |planName| radius   |
      |   19019 | No              | Iowa County    | MAPD     |PDP|Lipitor | TAB 10MG |       30 | Every 1 month | yes     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |
      
    