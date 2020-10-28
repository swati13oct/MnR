Feature: To test Refill Checkout Summary Page

  @Sanity
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> -To verify Complete Your Refill Page Functionality
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |

    Examples: 
      | FID     | username | password | MemUserName | planType | memberType     |
      | F481927 | ntalesha | pass@123 | DSOADY17    | MPDP     | Individual_PnP |
