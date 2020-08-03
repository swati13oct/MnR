Feature: Need Help Phone Numbers
  I am a user of the M&R Portal with Rx benefits I must have access to Need Help Phone Numbers

  @NeedHelp @F479448 @US2752100 @Scenario1 @Scenario2
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Need Help section
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to the Pharmacies and Prescriptions page
    Then user validates Need Help section content for pharmacies and prescriptions page

    Examples: 
      | TID   | planType | memberType        |
      | 15347 | MAPD     | IndMAPDUHC_footer |
      | 15347 | MEDICA   | Ind_footer        |
      | 15347 | PCP      | In                |
