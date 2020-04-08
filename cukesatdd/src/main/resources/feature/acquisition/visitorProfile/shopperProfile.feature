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

  #@searchProfileAndAddDrugs
  #Scenario Outline: Telesales agent searching for the profile using Email and Adding drugs for user
    #Given I am an agent logged into the cloak in tool
      #| User Name | <username> |
      #| Password  | <password> |
    #Then I ask the shopper calling in to provide me with the Email Address and Search
      #| Email | <email> |
    #And the profile is found and i click on the CLOAK IN button
    #Then I land on the plan summary page of VPP
      #| Plan Name | <planName> |
#
    #Examples: 
      #| username  | password  | email                  | planName                                             |
      #| qavgogine | qavgogine | UXEBLA_6547@MASKED.COM | AARP Medicare Advantage SecureHorizons Premier (HMO) |
