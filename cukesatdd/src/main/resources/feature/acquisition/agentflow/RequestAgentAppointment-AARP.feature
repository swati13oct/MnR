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

@vbfGate
Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow for Agent name in <site> site
Given the user is on medicare acquisition site landing page
    	|Site| <site>|
When the user navigates to request more help and information
When the user navigates to request appointment with an agent and validates page is loaded


	Examples: 
		| TCID     | site|
		| F266872   | AARP |
		
	Examples:
		| TCID	| site|
		|	F266872			| UHC |

@Request_Agent_Appointment_Right_Rail_AARP
  Scenario Outline: UID: <UID> - To Test Request Agent Appointment E2E on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
    And the user view below plans on vpp page and matches plan count for all plans
    |Medicare Advantage (Part C) plans|
	|Medicare Supplement Insurance plans| 
	|Medicare Prescription Drug (Part D) plans|
	|Medicare Special Needs plans|
    Then the user clicks on View plan details link for each plan type and validate find agent link for all plans 
    |Medicare Advantage (Part C) Plans|
	|Medicare Prescription Drug (Part D) Plans|
	|Medicare Special Needs Plans|
    ##
    Examples: 
      | UID | zipcode |
      |     |   88009 |
