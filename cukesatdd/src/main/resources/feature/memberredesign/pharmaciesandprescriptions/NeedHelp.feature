Feature: Need Help Phone Numbers
  I am a user of the M&R Portal with Rx benefits I must have access to Need Help Phone Numbers

  @NeedHelp @F479448 @US2752100 @Scenario1 @Scenario2
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Need Help section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user validates Need Help section phone numbers
    Then user validates Need Help section hours of operations

    Examples:
      | FID     | planType | memberType           |
      | F479448 | MAPD     | Rx_Individual_PnP_needhelp |

#    Examples:
#      | TID   | planType | memberType                 |
#      | 15347 | MAPD     | IndMAPDUHC_footer          |
#      | 15347 | MEDICA   | Ind_footer                 |
#      | 15347 | PCP      | Ind_footer                 |
