@agentAppointment @fixedTestCaseTest
Feature: 1.06-VBF-Acq-To test request an appointment with an agent flow in AARP site (GATED)

  #@agentAppointmentUlayerSmoke
  #Scenario Outline: Verify request an appointment with an agent flow in AARP site
    #Given the user is on AARP medicare acquisition site landing page
    #When the user navigates to request more help and information in AARP site
    #When the user navigates to request appointment with an agent in AARP site and validates page is loaded
    #Then user validates error messages on submitting blank form on aarp site
    #Then the user fills the form out and submits the agent appointment application
      #| First Name | <firstName> |
      #| Last Name  | <lastName>  |
      #| Address    | <address>   |
      #| City       | <city>      |
      #| State      | <state>     |
      #| Zipcode    | <zipcode>   |
      #| Phone      | <phone>     |
#
    #Examples: 
      #| firstName | lastName | city | address      | state      | zipcode | phone      |
      #| John      | Doe      | Test | 100 Test way | New Jersey |   08854 | 7324567890 |

  @agentAppointmentUlayerSmoke
  Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to request more help and information in AARP site
    When the user navigates to request appointment with an agent in AARP site and validates page is loaded
    Then user validates the breadcrumb title on the request appointment page
    Then user validates error messages on submitting blank form on aarp site
    Then the user fills the form out and submits the agent appointment application
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
