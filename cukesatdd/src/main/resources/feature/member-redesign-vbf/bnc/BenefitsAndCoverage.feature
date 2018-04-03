@smokeTest
Feature: 1.01-VBF-MemRedesign-To test plan benefits and Coverage functionality

  @smokeTest_BenefitsAndCoverageInd @rallyDashboard @testharness
  Scenario Outline: Verify multiple sections on Benefits and Coverage page for non-LIS federal members
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates to Rally Dashboard Page for bnc
    And the user validates plan overview section
    And the user validates headers on Bnc page for indi members
    And the user validates the Out of Pocket Max section
    And the user validates the Primarycare Provider section
    And the user view the Drug Copays & Discounts header
    And user validates the Learn More section link for stage and tier
    And the user validates dropdown selection functionality
    And the user validates Drug coverage header and text under the section
    And the user validates Look Up Drugs button should be visible
    And the user validates Locate a Pharmacy button should be visible
    #And the user should see drug copay and discount table(no code)
    And the user validates Needhelp header and disclaimer link
    And the user clicks on Disclaimers link
    And the user validates view and document label

    Examples: 
      | memberType              | friendname | favcolor | phonenumber |
      # |  BncnonlisUHCIndividual   | name1      | color1   | number1     |
      | BncnonlisAARPIndividual | name1      | color1   | number1     |

  @smokeTest_BenefitsAndCoverageGrp @rallyDashboard @testharness
  Scenario Outline: Verify multiple sections on Benefits and Coverage page for non-LIS group member
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates to Rally Dashboard Page for bnc
    And the user validates plan overview section
    And the user validates headers on Bnc page for indi members
    And the user validates the Out of Pocket Max section
    And user validates the Primarycare Provider section for Group
    And the user view the Drug Copays & Discounts header
    And user validates the Learn More section link for stage and tier
    And the user validates dropdown selection functionality
    And the user validates Look Up Drugs button should be visible
    And the user validates Locate a Pharmacy button should be visible
    #And the user should see drug copay and discount table(no code)
    And the user validates Needhelp header and disclaimer link
    And the user clicks on Disclaimers link
    And the user validates view and document label

    Examples: 
      | memberType            | friendname | favcolor | phonenumber |
      | BncnonlisGroupRetiree | name1      | color1   | number1     |
