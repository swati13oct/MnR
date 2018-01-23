@theSpartans
@ExplanationOfBenefits
Feature: Save profile preferences
 @EOB
  Scenario Outline: To verify Explanation of Benefits
    Given EOBspartans Login to the applicationEOB
      | memberNumber | <memberNumber> |
    When EOBspartans the user navigates to EOB page 
    Then EOBspartans validate the EOB Elements
    
    Examples: 
      | memberNumber   |
      | q1_jan_mapd_nice_01 |