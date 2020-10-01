Feature: 1.06-VBF-Acq-To test request an appointment with an agent flow in AARP site (GATED)

Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow for zipcode in AARP site
Given the user is on medicare acquisition site landing page
    	|Site| <site>|
Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
When the user navigates to EBRC links

   @agentFlowEBRCUlayer
    Examples: 
      |	site	| path                                                                                                                                                                                                                                                                                                                          | pageName               | 
      |	AARP	| health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD |                             
      |	AARP	| health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP |                             
      |	AARP	| health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  |                             
      |	AARP	| health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   |                             
      |	AARP	| health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      |                       
      |	AARP	| health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | Connector Modal        | 
		@agentFlowEBRCBlayer
			 Examples: 
      |	site	| path                                                                                                                                                                                                                                                                                                                          | pageName               | 
      |	UHC		| health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD |                             
     	|	UHC		| health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP |                             
      |	UHC		| health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  |                             
     	|	UHC		| health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   |                             
      |	UHC		| health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      |                       
     	|	UHC		| health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | Connector Modal        | 
		
			@agentFlowEBRCUlayer
    Examples: 
      |	site	| path                            | pageName                    |
      |	AARP	| shop.html                       | ShopPlan: Shop              | 
      |	AARP	| shop.html                       | ShopPlan: Shop              | 
  	  |	AARP	| shop/connect                    | ShopPlan: Request more Info |														
      |	AARP	| shop/compare.html               | ShopPlan: Compare           |												
      |	AARP	| shop/estimate.html              | ShopPlan: Estimate          |													
      |	AARP	| shop/switch.html                | ShopPlan: Switch            |												
      |	AARP	| shop/compare/compare-ms.html    | ShopPlan: Compare           | 
      |	AARP	| shop/estimate/ms-costs.html     | ShopPlan: Estimate          |
      |	AARP	| shop/compare/compare-ma-ms.html | ShopPlan: Compare           | 
      |	AARP	| safe-shopping.html              | ShopPlan: Shop              | 
   
     @agentFlowEBRCBlayer
    Examples: 
      |	site	| path                            | pageName                    | 
      |	UHC		| shop.html                       | ShopPlan: Shop              | 
      |	UHC		| shop.html                       | ShopPlan: Shop              |
  	  |	UHC		| shop/connect                    | ShopPlan: Request more Info |														
      |	UHC		| shop/compare.html               | ShopPlan: Compare           |												
      |	UHC		| shop/estimate.html              | ShopPlan: Estimate          |														
      |	UHC		| shop/switch.html                | ShopPlan: Switch            |											
      |	UHC		| shop/compare/compare-ms.html    | ShopPlan: Compare           | 
      |	UHC		| shop/estimate/ms-costs.html     | ShopPlan: Estimate          | 
      |	UHC		| shop/compare/compare-ma-ms.html | ShopPlan: Compare           | 
      |	UHC		| safe-shopping.html              | ShopPlan: Shop              | 
      
            
    @agentFlowEBRCUlayer
    Examples: 
      |	site	| path                                             | pageName                     |
      |	AARP	| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       | 
      |	AARP	| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan |
      |	AARP	| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan |			
      |	AARP	| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | 		 
      |	AARP	| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | 
      |	AARP	| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | 	 	 
			|	AARP	| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     |
			
		@agentFlowEBRCBlayer
    Examples: 
      |	site	| path                                             | pageName                     | 
      |	UHC		| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       |
      |	UHC		| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | 
      |	UHC		| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | 
      |	UHC		| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      |
      |	UHC		| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | 
      |	UHC		| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     |     
			|	UHC		| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     |   		

      
@agentAppointmentAgentUlayerSmoke
Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow for Agent name in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user navigates to request more help and information in AARP site
When the user navigates to request appointment with an agent in AARP site and validates page is loaded
Then the user fills the form out and submits the agent appointment application
| First Name | <firstName> |
| Last Name  | <lastName>  |
| State  	 | <state>  |


@agentAppointmentAARP
Examples: 
| TCID    | firstName 	   | lastName | state |
| F266872 | CHRISTINE      | LEE      | CA    | 
