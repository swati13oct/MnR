@vppNextActionModalBlayer
Feature: 1.03-ACQ-Next Action Modal on vpp flow UHC

  @vppNextActionModalRegression_1 @prodRegression
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for MAPD Plan when no Drug cost/provider exists
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    # When user views plans of the below plan type in UMS site
    Then user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
      Examples:
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MAPD     |
      
      
      @vppNextActionModalRegressionMAPDAddDrug
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for MAPD Plan when Drug cost exists
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    # When user views plans of the below plan type in UMS site
    Then user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |  19019 | No              | Iowa County     | MAPD     |
      
      @vppNextActionModalAddProvider
    Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for MAPD plan when Provider exists
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
     Then user validates plan count for all plan types on plan summary page in the UMS site
    # When user views plans of the below plan type in UMS site
    Then user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
      Examples: 
      |zipcode | isMultutiCounty | county         | plantype |
      |  19019 | No              | Iowa County    | MAPD     |
      
      @vppNextActionModalAddDrugAndProviderEnrollPlan
    Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for MAPD plan when Provider and Drug cost exists
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    # When user views plans of the below plan type in UMS site
    Then user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
      Examples: 
      |zipcode | isMultutiCounty | county         | plantype |
      |  19019 | No              | Iowa County    | MAPD     |
      
      
      @vppNextActionModalRegressionMA
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for MA Plan when no Drug cost exists
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA     |
      
      
      @vppNextActionModalRegressionMAAddDrug
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for MA Plan when Drug cost exists
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA     |
      
      
      @vppNextActionModalRegressionMAAddProvider
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for MA Plan when Provider exists
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA     |
      
      @vppNextActionModalRegressionMAAddDrugAndProviderEnrollPlan
    Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for MA Plan when both Drug cost and Provider exists
   Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA     |
      
      @vppNextActionModalRegressionPDP
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for PDP Plan when no Drug cost exists
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | PDP      |      
      
      @vppNextActionModalRegressionPDPAddDrug
     Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for PDP Plan when Drug cost exists
    Given the user is on uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> ||
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |  19019 | No              | Iowa County    | PDP     |