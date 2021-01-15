Feature: Refill All Medications CTA - My Medications
  To validate Refill All Medications CTA

  @Regression
  Scenario Outline: To verify Refill All Medications CTA displayed on My Medications page if user is eligible for refill
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    And user will view an explanation of the Refill All Medications CTA
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication

    Examples: 
      | username | password | memUserName                          | planType | memberType |
      | yaihemai | Yusufu7$ | b2dc8f2f-56d5-43e5-bef3-bb36ad49d6f9 | HMO      | Individual |

  @Regression
  Scenario Outline: To verify Refill All Medications CTA is not displayed on My Medications page if user is not eligible for refill
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When now user navigates to the pharmacies and prescriptions page from dashboard or testharness page
      | PlanType    | <planType>   |
      | Member Type | <memberType> |
    Then user views the Current Medications
    And user clicks View all medications link to view the My Medications page
    And user DO NOT have home delivery medications currently eligible for refill
    Then user will NOT view the Refill All Medications CTA on MY Medications Page
    And user will not see an explanation of the Refill All Medications CTA

    Examples: 
      | username | password | memUserName | planType | memberType |
      | yaihemai | Yusufu7$ | TCZUNIGA52  | Medica   | Individual |