@agentAppointment @fixedTestCaseTest
Feature: 1.06-VBF-Acq-To test request an appointment with an agent flow in AARP site (GATED)

#@agentAppointmentUlayerSmoke @vbfGate
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
#| TEST -MR-Firstname     | TEST -MR-Lastname      | Test | 100 Test way | New Jersey |   08854 | 7324567890 |

@agentAppointmentByZipUlayerSmoke
Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow for zipcode in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user navigates to request more help and information in AARP site
When the user navigates to request appointment with an agent in AARP site and validates page is loaded
Then the user fills the form out and submits the agent appointment application
| Zipcode    | <zipcode>   |

Examples: 
| TCID    | zipcode    | 
| F266872 |  90002     |  

@agentAppointmentAgentUlayerSmoke
Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow for Agent name in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user navigates to request more help and information in AARP site
When the user navigates to request appointment with an agent in AARP site and validates page is loaded
Then the user fills the form out and submits the agent appointment application
| First Name | <firstName> |
| Last Name  | <lastName>  |
| State  	 | <state>  |

Examples: 
| TCID    | firstName 	   | lastName | state |
| F266872 | CHRISTINE      | LEE      | CA    | 
