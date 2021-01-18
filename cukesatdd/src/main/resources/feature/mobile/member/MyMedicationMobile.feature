@F448402_Mobile
Feature: MVP - My Medications
  I am a user of the M&R Portal with Rx benefits, I must have access to My Medications on P&P Page

 @MyMedications @F448402_Mobile @US2618939
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Contact Pharmacy Call To Action For Retail Medications On Mobile
    Given login with following details logins in the uhc rx portal On Mobile
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page on Mobile
    And user clicks View all medications link
    Then user have active retail medications
    And user will see a "Green" "Contact Pharmacy" button
    
    
    
    
    