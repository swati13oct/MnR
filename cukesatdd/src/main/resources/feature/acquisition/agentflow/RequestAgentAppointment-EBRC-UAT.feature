Feature: 1.06-UAT Scripts to test Federal Agent Link and request an appointment with an agent flow on Shop Pages

Scenario Outline: <scenario> Verify request an appointment through <pageName>
Given the user is on medicare acquisition site landing page
    	|Site| <site>|
Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
When the user clicks on Agent link and validates the correct URL is loaded
      |UHC Agent URL|  <UHCUrl>  |
   @agentFlowEBRCBlayer
    Examples: 
      |scenario               |	site	| path                                                        | pageName                     | UHCUrl                     |
      |E2E Scenario 1_UMS			|	UHC	  | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | https://www.myuhcagent.com/|                            
      |	E2E Scenario 1_UMS		| UHC	  | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | https://www.myuhcagent.com/|                               
      |	E2E Scenario 1_UMS		| UHC	  | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  |  https://www.myuhcagent.com/|                              
      |	E2E Scenario 1_UMS		| UHC	  | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   |   https://www.myuhcagent.com/| 
      |E2E Scenario 2_UMS     |	UHC		| shop/medicare-advantage-plans.html                          | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/| 
   
   @agentFlowEBRCUlayer
    Examples: 
      |scenario               |	site	| path                                                        | pageName                     | UHCUrl                     | 
      |E2E Scenario 1_AMP			|	AARP	| health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | https://www.myuhcagent.com/|                            
      |E2E Scenario 1_AMP			|	AARP	| health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | https://www.myuhcagent.com/|                               
      |E2E Scenario 1_AMP			|	AARP	| health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  |  https://www.myuhcagent.com/|                              
      |E2E Scenario 1_AMP			|	AARP	| health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   |   https://www.myuhcagent.com/|
      |E2E Scenario 2_AMP     |	AARP  | shop/medicare-advantage-plans.html                          | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/| 
      
      


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



Scenario Outline: <scenario> Verify request an appointment for Medsupp flows
Given the user is on medicare acquisition site landing page
   		|Site| <site>|
		When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
		When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the site user fills all the details in MedsuppPage
   		| DOB           | <DOB>         |  		
   		When the user clicks on Agent link and validates the correct URL is loaded for Medsupp page
      |UHC Agent URL|  <UHCUrl>  |

@agentFlowEBRCBlayer   		
  Examples: 
    |scenario            | zipcode | isMultutiCounty |  county             | plantype | DOB      | Firstname | Lastname|  site|UHCUrl                     |
    |E2E Scenario 4_AMP  |   90002 | NO              | Los Angeles County | MS       | 11/13/1940 | John      | Carry   |  AARP  |https://www.myuhcagent.com/|   
	
@agentFlowEBRCUlayer
   Examples: 
   |scenario            | zipcode | isMultutiCounty |  county             | plantype | DOB      | Firstname | Lastname|  site|UHCUrl                     |
    |E2E Scenario 4_AMP  |   90002 | NO              | Los Angeles County | MS       | 11/13/1940 | John      | Carry   |  AARP  |https://www.myuhcagent.com/|   
			


