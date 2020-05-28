@F448402
Feature: MVP - My Medications
  I am a user of the M&R Portal with Rx benefits, I must have access to My Medications on P&P Page

  @MyMedications @F448402 @US2568667
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on payment method hold
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    And one of user active medications has a payment method hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @MyMedications @F448402 @US2568667
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on verify address hold
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When one of user active medications has an address hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @MyMedications @F448402 @US2568667
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on Price Adjustment hold
    Given I am an M&R member viewing Current Medications the Medicine Cabinet
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When one of user active medications has a price adjustment hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType             |
      | F436319 | MAPD     | AARP_Individual_PnP_rx |

  @MyMedications @F448402 @US2568667
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on CALL hold
    Given I am an M&R member viewing Current Medications the Medicine Cabinet
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When one of user active medications has a Call hold on it
    Then user will see a "Red" "On Hold" indicator
    And user will see a "Green" "Resolve hold" button on that medication row
    And the button will include the external link icon

    Examples: 
      | FID     | planType | memberType             |
      | F448402 | MAPD     | AARP_Individual_PnP_rx |

  @MyMedications @F448402 @US2568667
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify OptumRx Home Delivery medication on informational hold
    Given I am an M&R member viewing Current Medications the Medicine Cabinet
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active medications
    When one of user active medications has an informational hold on it
    Then user will NOT see a "Red" "On Hold" indicator
    And user will NOT see a "Green" "Resolve hold" button on that medication row

    Examples: 
      | FID     | planType | memberType             |
      | F448402 | MAPD     | AARP_Individual_PnP_rx |

  @MyMedications @F448402 @US2568665
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Shipped
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user views the Medicine Cabinet on the My Medications page
    When user views a home delivery drug order
    And user views a order having status of Shipped
    Then user views a 3/4 Harvey Ball on that medication row

    Examples: 
      | FID     | planType | memberType             |
      | F392596 | MAPD     | AARP_Individual_PnP_rx |

  @MyMedications @F448402 @US2568665
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Harvey ball: Delivered
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user views the Medicine Cabinet on the My Medications page
    When user views a home delivery drug order
    And user views a order having status of  Delivered
    Then user views a full Harvey Ball with a checkmark on that medication row

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2618939
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Contact Pharmacy Call To Action For Retail Medications
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active retail medications
    And user will view active retail medications
    And user will see a "Green" "Contact Pharmacy" button

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2618939
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Contact Pharmacy Call To Action For Retail Medications
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link
    Then user have active retail medications
    When user select the green "Contact Pharmacy" button
    Then user will view a popup with the phone number available to call

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |

  @MyMedications @F448402 @US2568656
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Member selects the next page
    Given login with following details logins in the uhc rx portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user views the Medicine Cabinet on the My Medications page
    When user select the next page arrow
    Then user will see remaining prescriptions on the My Medications page

    Examples: 
      | FID     | planType | memberType           |
      | F392596 | MAPD     | Rx_Individual_PnP_rx |
