@smokeTest
Feature: 1.05-VBF-MemRedesign-To test FnR functionality

 @smokeTest_FNR @rallyDashboard @testharness
  Scenario Outline: 
    Given I am a authenticated member on the member redesign site for Direct Login
      | Member Type | <memberType> |
    When the above plantype user logs in member redesign for Direct Login
      | friendname     | <friendname>  |
      | favouritecolor | <favcolor>    |
      | PhoneNumber    | <phonenumber> |
    Then member should navigate to Home page
    And the user navigates to Forms and Resources Page
    Then validate that the plan materials section is displayed
    And validate that english is default language in dropdown
    And the user verifies that the correct pdfs are coming in the plan material section
     | BENEFIT-HIGHLIGHT | <benefithighlight> |
     | SUMMARY-OF-BENEFIT |  <summaryofbenefits> |
     | EVIDENCE OF COVERAGE |  <evidenceofcoverage> |
     |  UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram>  |
     |  COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
     |  PRIOR AUTHORIZATION | <priorauth> |
     |   STEP THERAPY |  <steptherapy> |
     |  FORMULARY ADDITIONS| <formularyadd> |
     |   FORMULARY DELETIONS| <formularydel> |
   
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And validates the view temporary id card link
    Then validate that the anoc section is displayed
    Then validate that the annual directories section is displayed
    And both the Pharmacy locator and provider search links are displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And both the Drug and Medical EOB links are displayed
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
	| memberType | friendname | favcolor | phonenumber |benefithighlight | summaryofbenefits | evidenceofcoverage | unitedhealthpassportprogram | comprehensiveformulary| priorauth |  steptherapy  |  formularyadd |  formularydel |
	| AARPMapdInd |name1      | color1   | number1     | Benefit Highlights  |Summary of Benefits |Evidence of Coverage (EOC) |  UnitedHealth Passport Program  |  Comprehensive Formulary | Prior Authorization | Step Therapy  | Formulary Additions | Formulary Deletions |
      
#q1_aarp_apr194/Password@1