@agentAppointment @fixedTestCaseTest
Feature: 1.06 - To test request an appointment with an agent flow

	Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow for zipcode in <site> site
		Given the user is on medicare acquisition site landing page
    	|Site| <site>|
		When the user navigates to request more help and information
		When the user navigates to request appointment with an agent and validates page is loaded
		Then the user fills the form out and submits the agent appointment
			| Zipcode    | <zipcode>   |

		@agentAppointmentByZipSanity_AARP
		Examples: 
			| TCID    | zipcode    | site	|
			| F266872 |  90002     | AARP	|

		@agentAppointmentByZipSanity_UHC
		Examples:
			| TCID    | zipcode    | site	|
			| F266872 |  90002     | UHC	|
			
	Scenario Outline: Verify request an appointment with an agent flow for <pageName> in <site> site
		Given the user is on medicare acquisition site landing page
    	|Site| <site>|
		And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
 		And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
		When the user clicks on Agent link and validates the correct URL is loaded
      |UHC Agent URL|  <UHCUrl>          |

   @agentAppointmentByZipSanity_AARP
    Examples: 
      |	site	| path                                                                                                                                                                                                                        | pageName               | UHCUrl											|	plantype |	planyear	|
	  	|	AARP	| health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary	| VPP: Plan Summary      | https://www.myuhcagent.com/| MA       |	future		|                      
    
	@agentAppointmentByZipSanity_UHC
    Examples: 
      |	site	| path                                                                                                                                                                                                                        | pageName               | UHCUrl											|	plantype |	planyear	|
	  	|	UHC 	| health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary  | VPP: Plan Summary      | https://www.myuhcagent.com/| MA       |	future		|

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

#@vbfGate
#Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow for Agent name in <site> site
#Given the user is on medicare acquisition site landing page
#    	|Site| <site>|
#When the user navigates to request more help and information
#When the user navigates to request appointment with an agent and validates page is loaded


#	Examples: 
#		| TCID     | site|
#		| F266872   | AARP |
		
#	Examples:
#		| TCID	| site|
#		|	F266872			| UHC |

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
