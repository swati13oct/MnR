#Author: Rathulya Ravindran
#created Date:05/06/2020
@ShopperProfile
Feature: 1.08. ACQ- Next Best Action for Shopper Profile

@shopperProfileNBA
Scenario Outline: Test to verify the color of "Is my doctor/provider covered?" button when no Drug cost/provider exists
    Given I am an agent logged into the cloak in tool
      | User Name | <username> |
      | Password  | <password> |
    Then I ask the shopper calling in to provide me with the Email Address and Search
      | Email | <email> |
    And the profile is found and i click on the CLOAK IN button
    Then I land on the plan summary page of VPP
      | Plan Name | <planName> |
    Then user saves two plans as favorite on AARP site
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then Navigate to Visitor Profile page on AARP site

    Examples: 
      | username  | password  | email                  | plantype | planName                                             | testPlans                                                                                               |
      | qavgogine | qavgogine | UXEBLA_6547@MASKED.COM | MAPD     | AARP Medicare Advantage SecureHorizons Premier (HMO) | Sharp SecureHorizons Plan by UnitedHealthcare (HMO),AARP Medicare Advantage SecureHorizons Plan 4 (HMO) |
