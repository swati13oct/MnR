@BAT_AgentAppointment @fixedTestCaseTest @agentAppointment
Feature: 1.05-VBF-Acq-To test request an appointment with an agent flow in UHC site (GATED)

  @agentAppointmentBlayerSmoke
  Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow in UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user navigates to request more help and information in UHC site
    When the user navigates to request appointment with an agent in UHC site and validates page loaded
    Then user validates error messages on submitting blank form on UHC site
    Then user validates the breadcrum on the request appointment with an agent in UHC site
    Then the user fills the form out and submits the uhc agent appointment application
      | First Name | <firstName> |
      | Last Name  | <lastName>  |
      | Address    | <address>   |
      | City       | <city>      |
      | State      | <state>     |
      | Zipcode    | <zipcode>   |
      | Phone      | <phone>     |

    Examples: 
      | TCID    | firstName | lastName | city | address      | state | zipcode | phone        |
      | F266872 | John      | Doe      | Test | 100 Test way | NJ    |   08854 | 732-456-7890 |
