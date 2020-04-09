#Author: Naveen BK
#created Date:04/06/2020
@ShopperProfile
Feature: 1.08. ACQ- Shopper Profile

  @searchProfileEmail
  Scenario Outline: Telesales agent searching for the profile using Email
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan summary page of VPP
      | Plan Name | <planName> |

    Examples: 
      | username  | password  | email                  | planName                                             |
      | qavgogine | qavgogine | UXEBLA_6547@MASKED.COM | AARP Medicare Advantage SecureHorizons Premier (HMO) |

  @searchProfileName
  Scenario Outline: Telesales agent searching for the profile using first name and last name
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Name and Search
      | First Name | <fname> |
      | Last Name  | <lname> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan summary page of VPP
      | Plan Name | <planName> |

    Examples: 
      | username  | password  | fname  | lname   | planName                                             |
      | qavgogine | qavgogine | AURORA | SHEPLEY | AARP Medicare Advantage SecureHorizons Premier (HMO) |

  @searchProfileAndAddPlans
  Scenario Outline: Telesales agent searching for the profile using Email and Adding the plans for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan summary page of VPP
      | Plan Name | <planName> |
    Then user saves two plans as favorite on AARP site
      | MA Test Plans | <MA_testPlans> |
    Then Navigate to Visitor Profile page on AARP site
    And user validates the added plans on visitor profile page of AARP site
      | MA Test Plans | <MA_testPlans> |
    And user delets the added plans on visitor profile page of AARP site
      | MA Test Plans | <MA_testPlans> |

    Examples: 
      | username  | password  | email                  | planName                                             | MA_testPlans                                                                                            |
      | qavgogine | qavgogine | UXEBLA_6547@MASKED.COM | AARP Medicare Advantage SecureHorizons Premier (HMO) | Sharp SecureHorizons Plan by UnitedHealthcare (HMO),AARP Medicare Advantage SecureHorizons Plan 4 (HMO) |

  @searchProfileAndAddDrugs
  Scenario Outline: Telesales agent searching for the profile using Email and Adding drugs for user
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    And user access DCE tool on aarp site
      | Plan Type | <plantype> |
      | PlanName  | <plan>     |
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
    And I navigate to step3 page and validate
      | Drug | <drug> |
    And the user clicks on the shopping cart icon on DCE page in AARP
    Then the user should be able to see the Drug and pharmacy information in the guest profile page
      | Drug | <drug> |
    And user delets all the added drugs on visitor profile page of AARP site

    Examples: 
      | username  | password  | email                  | planName                                             | plan                                                | plantype | drug    | dosage   | quantity | frequency     | branded |
      | qavgogine | qavgogine | UXEBLA_6547@MASKED.COM | AARP Medicare Advantage SecureHorizons Premier (HMO) | Sharp SecureHorizons Plan by UnitedHealthcare (HMO) | MA       | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |
