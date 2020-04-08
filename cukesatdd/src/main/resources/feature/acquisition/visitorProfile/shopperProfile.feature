#Author: Naveen BK
#created Date:04/06/2020
@ShopperProfile
Feature: 1.08. ACQ- Visitor profile AARP

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
      | username  | password  | email                   | planName                                            |
      | qavgogine | qavgogine | NEENA_OVALLES@optum.com | Sharp SecureHorizons Plan by UnitedHealthcare (HMO) |

  @searchProfileName
  Scenario Outline: Telesales agent searching for the profile using Email
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
      | username  | password  | fname | lname   | planName                                            |
      | qavgogine | qavgogine | NEENA | OVALLES | Sharp SecureHorizons Plan by UnitedHealthcare (HMO) |
