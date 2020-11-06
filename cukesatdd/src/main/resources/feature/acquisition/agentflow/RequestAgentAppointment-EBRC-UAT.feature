Feature: UAT Scripts to test Federal Agent Link and request an appointment with an agent flow on Shop Pages(GATED)

Scenario Outline: <scenario> Verify request an appointment through shop pages MA Plans
Given the user is on medicare acquisition site landing page
    	|Site| <site>|
Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
When the user navigates to EBRC links
      |UHC Agent URL|  <UHCUrl>  |
 @agentFlowEBRCBlayer
    Examples: 
      |scenario               |	site	| path                                                        | pageName                     | UHCUrl                     | 
      |E2E Scenario 2_UMS     |	UHC		| shop/medicare-advantage-plans.html                          | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/| 
   
  @agentFlowEBRCUlayer
    Examples: 
      |scenario               |	site	| path                                                        | pageName                     | UHCUrl                     | 
      
      |E2E Scenario 2_AMP     |	AARP    | shop/medicare-advantage-plans.html                          | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/| 
      
      


Scenario Outline: <scenario> Verify request an appointment with an agent flow for zipcode UHC SIte
Given the user is on UHC medicare acquisition site page
When the user navigates to request more help and information in AARP site
When the user navigates to request appointment with an agent in AARP site and validates page is loaded
Then the user fills the form out and submits the agent appointment application
| Zipcode    | <zipcode>   |

@agentFlowEBRCBlayer
Examples: 
| scenario           | zipcode    | site|
| E2E Scenario 3_UMS |  90002     |  UHC|


Scenario Outline: <scenario> Verify request an appointment with an agent flow for zipcode AARP SIte
Given the user is on AARP medicare acquisition site landing page
When the user navigates to request more help and information in AARP site
When the user navigates to request appointment with an agent in AARP site and validates page is loaded
Then the user fills the form out and submits the agent appointment application
| Zipcode    | <zipcode>   |

@agentFlowEBRCUlayer
Examples: 
| scenario           | zipcode    | site|
| E2E Scenario 3_AMP |  90002     |  AARP|




