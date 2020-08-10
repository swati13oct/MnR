Feature: MVP - Call to Action
  I am a user of the M&R Portal with Rx benefits I must have access to PnP notifications and call to action cards

  @CallToAction @F436319 @US2498888 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify PnP notifications displayed only on PnP page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When a PnP notification is activated
    Then user must see that message at the top of the PnP page
    When user navigate to Pharmacy Locator page
    Then PnP notification will not be displayed on Pharmacy Locator page
    When user navigates back to PnP page
    Then PnP notification will only appear on the main PnP page

    Examples: 
      | FID     | planType | memberType                 |
      | F436319 | MAPD     | AARP_Individual_PnP_CTA_rx |

  @CallToAction @F436319 @US2498888 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify persist of PnP notifications until user log out
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When a PnP notification is activated
    Then user must see that message at the top of the PnP page
    When user click the cross icon to close the notification
    Then the PnP notification will be removed from the PnP page
    And that removal will persist until member logs out

    Examples: 
      | FID     | planType | memberType                 |
      | F436319 | MAPD     | AARP_Individual_PnP_CTA_rx |

  @CallToAction @F436319 @US2498888 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify image, title and description for each call to action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Find and Price a Medication Call To Action
    Then user validates an image for Find and Price a Medication Call To Action
    Then user validates a title for Find and Price Call To Action
    Then user validates a description for Find and Price Call To Action
    Then user view Pharmacy Locator Call To Action
    Then user validates an image for Pharmacy Locator Call To Action
    Then user validates a title for Pharmacy Locator Call To Action
    Then user validates a description for Pharmacy Locator Call To Action
    Then user view Order Prescription Call To Action
    Then user validates an image for Order Prescription Call To Action
    Then user validates a title for Order Prescription Call To Action
    Then user validates a description for Order Prescription Call To Action
    Then user view ANOC Call To Action
    Then user validates an image for ANOC Call To Action
    Then user validates a title for ANOC Call To Action
    Then user validates a description for ANOC Call To Action

    Examples: 
      | FID     | planType | memberType                 |
      | F436319 | MAPD     | AARP_Individual_PnP_CTA_rx |

  @CallToAction @F436319 @US2498888 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify position of each call to action tile on P&P page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user validates the Find and Price text content displayed first within that section
    Then user validates the Pharmacy Locator text content displayed second within that section
    Then user validates the Order Prescription text content displayed third within that section
    Then user validates the ANOC text content displayed fourth within that section

    Examples: 
      | FID     | planType | memberType                 |
      | F436319 | MAPD     | AARP_Individual_PnP_CTA_rx |

  @CallToAction @F436319 @US2498888 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify position of each call to action tile on P&P page for SEIB User
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user validates the Find and Price text content displayed first within that section
    Then user validates the Pharmacy Locator text content displayed second within that section
    Then user validates the Order Prescription text content DID NOT display third within that section
    Then user validates the ANOC text content displayed third within that section

    Examples: 
      | FID     | planType | memberType       |
      | F436319 | MAPD     | AARP_SEIB_PnP_rx |

  #@CallToAction @F479445 @US2752085
  #Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify indidiviual user redirected to DET Rally page when click Drug Lookup Call to Action.
  # Given login with following details logins in the member portal and validate elements
  #  | Plan Type   | <planType>   |
  # | Member Type | <memberType> |
  # When user navigates to the pharmacies and prescriptions page from testharness page
  #When user clicks on Drug Lookup Call To Action
  #then user will be directed to the Drug Estimator tool developed by Rally
  # Examples:
  #  | FID     | planType | memberType             |
  # | F436319 | MAPD     | AARP_Individual_PnP_CTA_rx |
  @CallToAction @F479445 @US2752085 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify group user redirected to DET Rally page when click Drug Lookup Call to Action.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Find and Price a Medication Call To Action
    Then user will not see a leaving this site icon for Find and Price a Medication CTA
    When user clicks on Find and Price a Medication Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window

    Examples: 
      | FID     | planType | memberType              |
      | F479445 | MAPD     | Rally_Individual_Pnp_rx |

  @CallToAction @F479445 @US2752083 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user redirected to Choose a plan year page when click on Pharmacy Locator call to action
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the Choose a plan year page

    Examples: 
      | FID     | planType | memberType              |
      | F479445 | MAPD     | Rally_Individual_Pnp_rx |

  @CallToAction @F479445 @US2752088 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify user ability to select a plan year in order to reach the correct pharmacy locator tool.
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the Choose a plan year page
    Then user will be see a back button on Choose a plan year page
    Then user will see the page header on Choose a plan year page
    Then user will see descriptive content on Choose a plan year page
    Then user will see a twenty twenty call to action on Choose a plan year page
    Then user will see a twenty twentyone call to action on Choose a plan year page
    Then user will see the FAQ section on Choose a plan year page
    Then user will see the Need Help section on Choose a plan year page
    Then user will see the More Info section on Choose a plan year page
    Then user will see the global footer on Choose a plan year page

    Examples: 
      | FID     | planType | memberType              |
      | F479445 | MAPD     | Rally_Individual_Pnp_rx |

  @CallToAction @F479445 @US2752088 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify user directed to the new pharmacy search tool being developed by Rally for 2020 plan year
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the Choose a plan year page
    Then user will see a twenty twenty call to action on Choose a plan year page
    Then user will NOT see the External link icon for twenty twenty call to action on Choose a plan year page
    When user click on the twenty twenty call to action on Choose a plan year page
    Then user will be directed to the new Pharmacy Locator tool built by Rally in the same browser window

    #When user click on the back button on Pharmacy Locator tool built by Rally
    #Then user will be directed to the Choose a plan year page
    Examples: 
      | FID     | planType | memberType              |
      | F479445 | MAPD     | Rally_Individual_Pnp_rx |

  @CallToAction @F479445 @US2752088 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify user directed to the new pharmacy search tool being developed by Rally for 2020 plan year
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the Choose a plan year page
    Then user will see a twenty twentyone call to action on Choose a plan year page
    When user click on the twenty twentyone call to action on Choose a plan year page
    Then user will be directed to the legacy Pharmacy Locator tool in the same browser window

    #When user click on the back button on the legacy Pharmacy Locator tool page
    #Then user will be directed to the Choose a plan year page
    Examples: 
      | FID     | planType | memberType              |
      | F479445 | MAPD     | Rally_Individual_Pnp_rx |

  @CallToAction @F436319 @US2498945 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user redirected to OptumRx manage prescriptions page on new tab when click on Refill Home Delivery Call to Action
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    When user click on the Order Prescription call to action
    Then user will SSO to OptumRx manage prescriptions page on new tab

    Examples: 
      | FID     | planType | memberType              |
      | F436319 | MAPD     | Rally_Individual_Pnp_rx |

  @CallToAction @F479445 @US2752084 @MemberVBF
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify user have access to the ANOC page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view ANOC Call To Action
    When user clicks on ANOC Call To Action
    Then user will be redirected to the ANOC page in a new tab

    Examples: 
      | FID     | planType | memberType       |
      | F479445 | MAPD     | AARP_LIS0_PnP_rx |
