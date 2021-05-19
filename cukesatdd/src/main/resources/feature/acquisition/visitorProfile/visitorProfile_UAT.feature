@UATRegression @visitorProfile
Feature: 1.08. UAT- Visitor profile

  #@addPlans @addPlansULayerSmoke @visitorProfileRegressionAARP
  Scenario Outline: Verify user is able to add plans to the unauthenticated visitor profile - zip -<zipcode>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon
    And the user clicks on the add plans button in the profile
    When the user enters zipcode on health plans page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
    Then user saves two plans as favorite
      | Test Plans | <testPlans> |
      | Plan Type  | <plantype>  |
    Then user gets a create profile prompt
    Then user click on continue as guest button
    And user validates the added plans on visitor profile page
      | Test Plans | <testPlans> |
    Then the user validates whether call icon is visible
    And user delets the added plans on visitor profile page
      | Test Plans | <testPlans> |

    @visitorProfile_AARP_UAT @regressionAARP @sanity
    Examples: 
      | site | state   | UID       | planyear | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                              |
      | AARP | Alabama | US1770330 | future   |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

    #| Alabama | US1770330 |   53503 | NO            | Jefferson County | SNP      | UnitedHealthcare Dual Complete LP1 (HMO D-SNP),UnitedHealthcare Medicare Advantage Assist (PPO C-SNP)  |
    @visitorProfile_UHC_UAT @prodRegression @regressionUHC
    Examples: 
      | site | state   | UID       | planyear | zipcode | isMultiCounty | county           | plantype | testPlans                                                                                              |
      | UHC  | Alabama | US1770330 | future   |   90210 | NO            | Jefferson County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
