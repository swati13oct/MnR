@theSpartans
@ExplanationOfBenefits
Feature: Explanation Of Benefits Elements
 @EOB
  Scenario Outline: To verify Explanation of Benefit Preferences
    Given EOBspartans Login to the applicationEOB
      | memberNumber | <memberNumber> |
    When EOBspartans the user navigates to EOB page 
    Then EOBspartans validate the EOB Elements
    
    Examples: 
      | memberNumber   |
      | q1_aarp_eob105 |