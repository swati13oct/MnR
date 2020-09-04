Feature: Refill - Auto Refill Selection
  Select/deselect auto refill during the refill checkout process.

  @AutoRefillSelection @US2781896
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Auto refill display for eligible prescription
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication information eligible for auto refill and clicks on Refill Medication CTA button
    Then user will see "Complete Your Refill" Page
    When user views the Medications section
    Then user will see the auto refill field populate for any eligible medication

  @AutoRefillSelection @US2781896
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify auto refill not displayed for not eligible prescription
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication information not eligible for auto refill and clicks on Refill Medication CTA button
    Then user will see "Complete Your Refill" Page
    When user views the Medications section
    Then user will not view the Auto Refill display

  @AutoRefillSelection @US2781896
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication information for prescription eligible and enrolled for auto refill and clicks on Refill Medication CTA button
    Then user will see "Complete Your Refill" Page
    When user views the Medications section
    Then user will see the checkbox checked for Auto Refill On

  @AutoRefillSelection @US2781896
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication information for prescription eligible and not enrolled for auto refill and clicks on Refill Medication CTA button
    Then user will see "Complete Your Refill" Page
    When user views the Medications section
    Then user will see the checkbox checked for Auto Refill Off
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication information for prescription eligible and enrolled for auto refill and clicks on Refill Medication CTA button
    Then user will see "Complete Your Refill" Page
    When user views the Medications section
    Then user will see the checkbox checked for Auto Refill On
    When user deselect the auto refill checkbox
    Then user will view a page asking if user want to STOP AUTO REFILL
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication information for prescription eligible and enrolled for auto refill and clicks on Refill Medication CTA button
    Then user will see "Complete Your Refill" Page
    When user views the Medications section
    Then user will see the checkbox checked for Auto Refill On
    When user deselect the auto refill checkbox
    Then user will view a page asking if user want to STOP AUTO REFILL

  @AutoRefillSelection @US2781896
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user able to stop autorefill for eligible prescription.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user fetches medication information eligible for auto refill and clicks on Refill Medication CTA button
    Then user will see "Complete Your Refill" Page
    When user views the Medications section
    Then user will see the checkbox checked for Auto Refill
    When user deselect the auto refill checkbox
    Then user will view a page asking if user want to STOP AUTO REFILL
    When user click CONTINUE AUTO REFILL
    Then user will be redirected to the Complete Your Refill page
    Then user will see the checkbox checked for Auto Refill
    When user deselect the auto refill checkbox
    Then user will view a page asking if user want to STOP AUTO REFILL
    When user select stop auto refill
    Then user will view the auto refill stopped page
    When user click Back TO MY MEDICATION
    Then user will be redirected to My Medication page
    And user would be disenrolled in auto refill for that prescription

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |
