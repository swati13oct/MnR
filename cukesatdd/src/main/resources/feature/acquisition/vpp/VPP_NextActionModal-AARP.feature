
@vppNextActionModalUlayer
Feature: 1.03-ACQ-Next Action Modal on vpp flow AARP

  @vppNextActionModalRegression_1 @prodRegression
  Scenario Outline: UserStory: <TID> -plan type: <plantype> -Test to verify the Next action modal for MAPD Plan when no Drug cost/provider exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    #And the user views the plans of the below plan type in AARP site
    Then the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MAPD     | 
      
    @vppNextActionModalRegressionMAPDAddDrug
    Scenario Outline: UserStory: <TID> -plan type: <plantype> -Test to verify the Next action modal for MAPD Plan when Drug cost exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    #And the user views the plans of the below plan type in AARP site
    Then the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |  19019 | No              | Iowa County     | MAPD     | 
    @vppNextActionModalAddProvider
    Scenario Outline: UserStory: <TID> -plan type: <plantype> Test to verify the Next action modal for MAPD plan when Provider exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    #And the user views the plans of the below plan type in AARP site
    Then the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
      Examples: 
      |zipcode | isMultutiCounty | county         | plantype |
      |  19019 | No              | Iowa County    | MAPD     |
        
     @vppNextActionModalAddDrugAndProviderEnrollPlan
    Scenario Outline: UserStory: <TID> -plan type: <plantype> Test to verify the Next action modal for MAPD plan when Provider exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    #And the user views the plans of the below plan type in AARP site
    Then the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
      Examples: 
      |zipcode | isMultutiCounty | county         | plantype |
      |  19019 | No              | Iowa County    | MAPD     | 
    
    @vppNextActionModalRegressionMA
     Scenario Outline: UserStory: <TID> -plan type: <plantype> -Test to verify the Next action modal for MA Plan when no Drug cost exists
   Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA     | 
     @vppNextActionModalRegressionMAAddDrug
     Scenario Outline: UserStory: <TID> -plan type: <plantype> -Test to verify the Next action modal for MA Plan when Drug cost exists
   Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA       | 
      
       @vppNextActionModalRegressionMAAddProvider
     Scenario Outline: UserStory: <TID> -plan type: <plantype> -Test to verify the Next action modal for MA Plan when Drug cost/Provider exists
   Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA       | 
      
      @vppNextActionModalRegressionMAAddDrugAndProviderEnrollPlan
    Scenario Outline: UserStory: <TID> -plan type: <plantype> -Test to verify the Next action modal for MP Plan when Drug cost/Provider exists
   Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | MA    | 
           
      @vppNextActionModalRegressionPDP
     Scenario Outline: UserStory: <TID> -plan type: <plantype> -Test to verify the Next action modal for PDP Plan when no Drug cost exists
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
     Scenario Outline: UserStory: <TID> -plan type: <plantype> -Test to verify the Next action modal for PDP Plan when Drug cost exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> ||
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |  19019 | No              | Iowa County    | PDP     | 
      
      @vppNextActionModalRegressionPDPAddDrugAndEnrollPlan
    Scenario Outline: UserStory: <TID> -plan type: <plantype> -Test to verify the Next action modal for PDP Plan when Drug cost exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
      Examples: 
      | zipcode | isMultutiCounty | county         | plantype |
      |   19019 | No              | Iowa County    | PDP    | 
           