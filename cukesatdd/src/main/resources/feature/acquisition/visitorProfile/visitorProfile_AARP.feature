#Author: Danthoori shiva
#created Date:2/12/2019
@Test @visitorprofile
Feature: Visitor profile

  @AARPvisitorprofile
  Scenario Outline: Verify user is able to add drug and pharmacy information to the unauthenticated visitor profile
    Given the user is on AARP medicare acquisition site landing page
    And the user selects the state drop down value in AARP home page
      | State | <state> |
    And the user clicks on the shopping cart icon in AARP site
    And the user clicks on the add drugs button in the guest profile in AARP site
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
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
    And the user returns to the visitor profile page
    Then the user should be able to see the Drug and pharmacy information in the guest profile page
      | Drugname | <Drugname> |

    Examples: 
      | state   | Drugname         | quantity | frequency     | zipcode | radius   | drug             | quantity | frequency     | branded |
      | Alabama | Lipitor TAB 10MG |       30 | Every 1 month |   90210 | 15 miles | Lipitor TAB 10MG |       30 | Every 1 month | yes     |

  @planinformation
  Scenario Outline: Verify user is able to plan information to the unauthenticated visitor profile
    Given the user is on AARP medicare acquisition site landing page
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon which is available on the top right corner
    And the user is navigated to the visitor profile signin page
    And the user clicks on the add plans button in the guest profile
    When the user performs plan search using following information in the AARP site
      | Zip Code | <zipcode> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    When the user clicks on the save plan
    And the user selects the second plan
    Then user receives a popup to create the profile
    When user selects the third plan
    Then user should not be able to see the popup
    When user clicks on the close button
    Then the popup should be closed
    And the user clicks on the shopping cart icon which is available on the top right corner
    Then the user should be able to see the plan information in the guest profile page which are saved.

    Examples: 
      | state   | zipcode | plantype |
      | Alabama |   90210 |       30 |

  @signin
  Scenario Outline: Verify user is able to navigate to the sign in profile page
    Given the user is on AARP medicare acquisition site landing page
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon which is available on the top right corner
    And the user is navigated to the visitor profile signin page
    When the user clicks on the sign in button in the visitor profile page
    Then the user should be navigated to the optum id sign in page
    When the user navigates back to the visitor profile sign in page
    And the user hovers over the shopping cart icon and clicks on the signin link
    Then the user should be navigated to the optum id sign in page

    Examples: 
      | state   |
      | Alabama |

  @creatprofile
  Scenario Outline: Verify user is able to navigate to the sign in profile page
    Given the user is on AARP medicare acquisition site landing page
    And the user selects the state drop down value in home page
      | State | <state> |
    And the user clicks on the shopping cart icon which is available on the top right corner
    And the user is navigated to the visitor profile signin page
    When the user clicks on the Create a profile in the visitor profile page
    Then the user should be navigated to the optum id sign in page
    When the user navigates back to the visitor profile sign in page
    And the user hovers over the shopping cart icon and clicks on the Create a profile button
    Then the user should be navigated to the optum id sign in page

    Examples: 
      | state   |
      | Alabama |
