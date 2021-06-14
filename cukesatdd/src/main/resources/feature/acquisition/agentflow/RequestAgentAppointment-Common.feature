#@agentAppointment @fixedTestCaseTest
Feature: 1.06 - To test request an appointment with an agent flow

  Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow for zipcode in <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigates to request more help and information
    When the user navigates to request appointment with an agent and validates page is loaded
    Then the user fills the form out and submits the agent appointment
      | Zipcode | <zipcode> |

   # @agentAppointmentByZipSanity_AARP @prodRegression @regressionAARP @sanity
    Examples: 
      | TCID    | zipcode | site |
      | F266872 |   90002 | AARP |

   # @agentAppointmentByZipSanity_UHC @regressionUHC
    Examples: 
      | TCID    | zipcode | site |
      | F266872 |   90002 | UHC  |

  Scenario Outline: Verify request an appointment with an agent flow for <pageName> in <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    When the user clicks on Agent link and validates the correct URL is loaded
      | UHC Agent URL | <UHCUrl> |

   # @agentAppointmentByZipSanity_AARP @regressionAARP
    Examples: 
      | site | path                                                                                                                                                                                                                       | pageName          | UHCUrl                      | plantype | planyear |
      | AARP | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary | VPP: Plan Summary | https://www.myuhcagent.com/ | MA       | future   |

   # @agentAppointmentByZipSanity_UHC @prodRegression @regressionUHC @sanity
    Examples: 
      | site | path                                                                                                                                                                                                                       | pageName          | UHCUrl                      | plantype | planyear |
      | UHC  | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary | VPP: Plan Summary | https://www.myuhcagent.com/ | MA       | future   |

 # @Request_Agent_Appointment_Right_Rail_AARP
  Scenario Outline: UID: <UID> - To Test Request Agent Appointment E2E on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code | <zipcode> |
    And the user view below plans on vpp page and matches plan count for all plans
      | Medicare Advantage (Part C) plans         |
      | Medicare Supplement Insurance plans       |
      | Medicare Prescription Drug (Part D) plans |
      | Medicare Special Needs plans              |
    Then the user clicks on View plan details link for each plan type and validate find agent link for all plans
      | Medicare Advantage (Part C) Plans         |
      | Medicare Prescription Drug (Part D) Plans |
      | Medicare Special Needs Plans              |


    Examples: 
      | UID     | zipcode |
      | [blank] |   88009 |
