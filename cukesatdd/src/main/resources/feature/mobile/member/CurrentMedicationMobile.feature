 Feature: MVP - Current Medications
  I am a user of the M&R Portal with Rx benefits, I must have access to Current Medications on P&P Page
 
 @CurrentMedications @F392596 @US2618672
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Contact Pharmacy Call To Action For Retail Medications On Mobile
    Given login with following details logins in the uhc rx portal On Mobile
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from dashboard or testharness page on Mobile
    And user have active retail medications
    Then user will see a "Green" "Contact Pharmacy" button
    And user will see
 