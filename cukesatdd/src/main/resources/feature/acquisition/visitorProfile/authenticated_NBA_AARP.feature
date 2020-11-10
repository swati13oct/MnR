@Test @AARPAuthenticatedvisitorprofile
Feature: 1.08. ACQ- Viitor Profile Authenticated NBA AARP

  @getStartedNBA
  Scenario Outline: Verify get started for  authenticated Visitor Profile page
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to Visitor profile page
    And the user signs in with optum Id credentials in AARP site
      | User Name | <userName> |
      | Password  | <password> |
    And user clears the existing drugs
    And user clears the provider
    And user removed existing saved plans
    Then user clicks on home on VP authenticated AARP site
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then user should see the Get started NBA
    When user clicks on Saved items
    Then user should be navigated to visitor profile

    Examples: 
      | userName      | password    | isMultutiCounty | zipcode | county          | plantype | drug    | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded |
      | chargersqa@23 | Password@23 | NO              |   10001 | New York County | MAPD     | Lipitor | TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     |

  @drugAlreadyAdded
  Scenario Outline: Verify NBA for Find a provider for authenticated Visitor Profile VPP summary page when drug is already added
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to Visitor profile page
    And the user signs in with optum Id credentials in AARP site
      | User Name | <userName> |
      | Password  | <password> |
    And user clears the existing drugs
    And user clears the provider
    Then user clicks on home on VP authenticated AARP site
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then user should see the Get started NBA
    Then user click on get started on AARP site
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
      | DrugName | <drugName> |
    And clicks on Review drug cost button
    And the user click on return to plan summary on DCE summary page
    Then user validate Find a Provider NBA
    When user clicks on Find a Provider button in AARP Site
    When user selects a provider and retuns to VPP page in ulayer
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    When user clicks on Select a plan button in AARP Site
    Then user should be able to see the Select Plan for Enroll Modal with all plans in AARP site
    When user saves plan as favorite on AARP site
      | Plan Type | <testPlans> |
    When user clicks on Select a plan button in AARP Site
    Then user should be able to see the Select Plan for Enroll Modal with saved plans in AARP site
      | Test Plans | <testPlans> |
    When user clicks on Saved items
    Then user should be navigated to visitor profile

    Examples: 
      | userName      | password    | isMultutiCounty | zipcode | county          | plantype | drugName | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded | testPlans                            |
      | chargersqa@23 | Password@23 | NO              |   10001 | New York County | MAPD     | Lipitor  | TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     | AARP Medicare Advantage Plan 1 (HMO) |

      
  @continueEnrollmentNBA
  Scenario Outline: Verify NBA for Continue Enrollment for authenticated Visitor Profile VPP summary page
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to Visitor profile page
    #And user clicks sign in link
    And the user login with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    #And user clears the existing drugs
    #And user clears the provider
    Then user clicks on home on VP authenticated AARP site
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
    Then user should be able to see the continue enrollment modal
    When user clicks on continue enrollment button
    Then user should navigated to enrollment page

    Examples: 
      | userName      | password    | isMultutiCounty | zipcode | county          | plantype | drugName | dosage   | quantity | frequency     | zipcode | radius   | quantity | frequency     | branded | testPlans                            |
      | jarvisstage23111 | Password@9 | NO              |   55344 | Hennepin County | PDP     | Lipitor  | TAB 10MG |       30 | Every 1 month |   90210 | 15 miles |       30 | Every 1 month | yes     | AARP Medicare Advantage Plan 1 (HMO) |
      