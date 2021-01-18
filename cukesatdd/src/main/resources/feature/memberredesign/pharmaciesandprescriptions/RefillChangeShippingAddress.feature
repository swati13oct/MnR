@F482462
Feature: Refill - Change Shipping Address
  I am a user of the M&R Portal with Rx benefits I must have access to Change Shipping Address functionality for refillable medications

  @F482462 @US2770458
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Change Shipping Address link 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770458
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Select address functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user selects an address using the radio buttons
    And user select the Use this Address button
    Then user will see "Complete Your Refill" Page
    And user will the Shipping Address match the one user selected

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770458 @Regression
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Change Shipping Address Functionality
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user selects an address using the radio buttons
    And user select the Use this Address button
    Then user will see "Complete Your Refill" Page
    And user will the Shipping Address match the one user selected

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  ###########################################################
  @F482462 @US2770459
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Edit Link functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Edit link for editable address
    Then user will view "Edit Shipping Address" in a full page modal

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770459
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Edit address functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Edit link for editable address
    Then user will view "Edit Shipping Address" in a full page modal
    When user type in any of the address lines
    Then user will see the changes reflected on the page

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770459
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Add additional line functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Edit link for editable address
    Then user will view "Edit Shipping Address" in a full page modal
    When user select the link to add an additional address line
    Then user will see a second address line box appear on the page
    And user will be able to enter text into it
    And user wont view the add an additional address line link

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770459
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Cancel - X functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Edit link for editable address
    Then user will view "Edit Shipping Address" in a full page modal
    When user select the X in the corner of the page
    Then user will return to the "Change Shipping Address" page
    And user will see the address user was editing is unchanged

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770459
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Cancel button functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Edit link for editable address
    Then user will view "Edit Shipping Address" in a full page modal
    When user select the Cancel button
    Then user will return to the "Change Shipping Address" page
    And user will see the address user was editing is unchanged

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770459
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Save and continue functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Edit link for editable address
    Then user will view "Edit Shipping Address" in a full page modal
    When user select Save and continue
    Then user will return to the "Change Shipping Address" page
    And user will see the address user was editing reflect the changes user made

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770459
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Edit Shipping functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Edit link for editable address
    Then user will view "Edit Shipping Address" in a full page modal
    When user type in any of the address lines
      | AddressLine1 | 300 Meridian Centre |
    Then user will see the changes reflected on the page
    When user select the link to add an additional address line
    Then user will see a second address line box appear on the page
    And user will be able to enter text into it
      | AddressLine2 | Test |
    And user wont view the add an additional address line link
    When user select the X in the corner of the page
    Then user will return to the "Change Shipping Address" page
    And user will see the address user was editing is unchanged
    When user clicks on Edit link for editable address
    And user will be able to enter text into it
      | AddressLine2 | Test |
    And user select the Cancel button
    Then user will return to the "Change Shipping Address" page
    And user will see the address user was editing is unchanged
    When user clicks on Edit link for editable address
    And user select the link to add an additional address line
    And user will be able to enter text into it
      | AddressLine2 | Test |
    When user select Save and continue
    Then user will return to the "Change Shipping Address" page
    And user will see the address user was editing reflect the changes user made

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  ##############################################
  @F482462 @US2770460
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Add New Address functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Add Address Btn
    Then user will view "Add Address" in a full page modal

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770460
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Enter New address functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Add Address Btn
    Then user will view "Add Address" in a full page modal
    When user type in any of the address lines
    Then user will see the changes reflected on the page

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770460
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Add additional line functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Add Address Btn
    Then user will view "Add Address" in a full page modal
    When user select the link to add an additional address line
    Then user will see a second address line box appear on the page
    And user will be able to enter text into it
    And user wont view the add an additional address line link

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770460
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Cancel - X functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Add Address Btn
    Then user will view "Add Address" in a full page modal
    When user select the X in the corner of the page
    Then user will return to the "Change Shipping Address" page
    And user will not see the address user was adding

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770460
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Cancel button functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Add Address Btn
    Then user will view "Add Address" in a full page modal
    When user select the Cancel button
    Then user will return to the "Change Shipping Address" page
    And user will not see the address user was adding

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  ############################################################
  @F482462 @US2770460
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Save and continue functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Add Address Btn
    Then user will view "Add Address" in a full page modal
    When user select Save and continue
    Then user will return to the "Change Shipping Address" page
    And user will see the address user added in the list of shipping addresses

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770460 @Regression
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Add and Edit Shipping Address functionality
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Add Address Btn
    Then user will view "Add Address" in a full page modal
    When user type in any of the address lines
      | AddressLine1        |
      | 300 Meridian Centre |
    Then user will see the changes reflected on the page
    When user select the link to add an additional address line
    Then user will see a second address line box appear on the page
    And user will be able to enter text into it
      | AddressLine2 |
      | Test         |
    And user wont view the add an additional address line link
    When user select the X in the corner of the page
    Then user will return to the "Change Shipping Address" page
    And user will not see the address user was adding
    When user clicks on Add Address Btn
    And user select the Cancel button
    Then user will return to the "Change Shipping Address" page
    And user will not see the address user was adding
    And user clicks on Add Address Btn
    When user type in any of the address lines
      | AddressLine1        |
      | 300 Meridian Centre |
    And user enters value in city field
      | City      |
      | Rochester |
    And user select value from state dropdown
      | State |
      | NY    |
    And user enters value in zipcode field
      | ZipCode |
      |   14618 |
    And user select Save and continue
    Then user will return to the "Change Shipping Address" page
    And user will see the address user added in the list of shipping addresses
    When user clicks on Edit link for editable address after user added
    Then user will view "Edit Shipping Address" in a full page modal
    When user type in any of the address lines
      | AddressLine1 |
      | Testing      |
    Then user will see the changes reflected on the page
    When user select the link to add an additional address line
    Then user will see a second address line box appear on the page
    And user will be able to enter text into it
      | AddressLine2 |
      | Test         |
    And user wont view the add an additional address line link
    When user select the X in the corner of the page
    Then user will return to the "Change Shipping Address" page
    And user will see the address user was editing is unchanged
    When user clicks on Edit link for editable address after user added
    And user select the link to add an additional address line
    And user will be able to enter text into it
      | AddressLine2 |
      | Test         |
    And user select the Cancel button
    Then user will return to the "Change Shipping Address" page
    And user will see the address user was editing is unchanged
    When user clicks on Edit link for editable address after user added
    And user select the link to add an additional address line
    And user will be able to enter text into it
      | AddressLine2 |
      | Test         |
    When user select Save and continue
    Then user will return to the "Change Shipping Address" page
    And user will see the address user was editing reflect the changes user made
    When user clicks on Edit link for editable address after user added
    Then user will view "Edit Shipping Address" in a full page modal
    When user clicks on Delete this Address CTA
    Then user will see Delete Confirmation Modal
    When user clicks on Yes CTA on Delete Confirmation Modal
    Then user will see address is deleted
     
    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  ##############################################################################
  @F482462 @US2770462
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Preferred address checkbox functionality 
    Given login with following details logins in the member portal and validate element
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user select an address that is not a preferred address
    Then user will see the "Make this my preferred address" checkbox appear

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770462
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Select new preferred address functionality 
    Given login with following details logins in the member portal and validate element
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user select an address that is not a preferred address
    And user select the preferred address checkbox
    And user select the Use this Address button
    Then user will see "Complete Your Refill" Page
    And user will see that address displayed as the preferred address

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |

  @F482462 @US2770462 @Regression
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Preferred address functionality 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user select an address that is not a preferred address
    Then user will see the "Make this my preferred address" checkbox appear
    When user select the preferred address checkbox
    And user select the Use this Address button
    Then user will see "Complete Your Refill" Page
    And user will see that address displayed as the preferred address

    Examples: 
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |


  @F482462 @US2777912 @Regression
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify deleting a shipping address
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    And user select the Refill All Medications CTA
    Then user will see "Complete Your Refill" Page
    When user select the Change Shipping Address link
    Then user will view the "Change Shipping Address" page
    When user clicks on Edit link for editable address
    Then user will view "Edit Shipping Address" in a full page modal
    When user clicks on Delete this Address CTA
    Then user will see Delete Confirmation Modal
    When user clicks on the Cancel button on the modal
    Then user will view "Edit Shipping Address" in a full page modal
    When user clicks on Delete this Address CTA
    Then user will see Delete Confirmation Modal
    When user clicks on Yes CTA on Delete Confirmation Modal
    Then user will see success message that the address is deleted

    Examples:
      | FID     | planType | memberType                  |
      | F481927 | PDP      | Rx_Individual_PnP_rx_refill |