Feature: 1.06-VBF-Acq-To test request an appointment with an agent flow in AARP site (GATED)

Scenario Outline: TID:<TCID> Verify request an appointment with an agent flow for zipcode in AARP site
Given the user is on medicare acquisition site landing page
    	|Site| <site>|
Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
When the user navigates to EBRC links
Examples: 

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
      
    @ShopPlan_Shop2_GlobalCompsAARP
    Examples: 
      |	site	| path                                             | pageName                     |
      |	AARP	| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       | 
      |	AARP	| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan |
      |	AARP	| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan |			
      |	AARP	| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | 		 
      |	AARP	| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | 
      |	AARP	| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | 	 	 
			|	AARP	| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     |
			
	@ShopPlan_Shop2_GlobalCompsUHC
    Examples: 
      |	site	| path                                             | pageName                     | 
      |	UHC		| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       |
      |	UHC		| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | 
      |	UHC		| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | 
      |	UHC		| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      |
      |	UHC		| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | 
      |	UHC		| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     |     
			|	UHC		| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     |   		


    @ShopPlan_Shop3_GlobalCompsAARP
    Examples: 
      |	site	| path                                       | pageName                    | 
      |	AARP	| shop/compare/compare-pdp.html              | ShopPlan: Compare PDP Plan  |
      |	AARP	| shop/compare/compare-ma.html               | ShopPlan: Compare MA  Plan  |
      |	AARP	| shop/estimate/ma-costs.html                | ShopPlan: Estimate MA Plan  |
      |	AARP	| shop/estimate/pdp-costs.html               | ShopPlan: Estimate PDP Plan |
      
    @ShopPlan_Shop3_GlobalCompsUHC
    Examples: 
      |	site	| path                                       | pageName                    | 
      |	UHC		| shop/compare/compare-pdp.html              | ShopPlan: Compare PDP Plan  |
      |	UHC		| shop/compare/compare-ma.html               | ShopPlan: Compare MA  Plan  |
      |	UHC		| shop/estimate/ma-costs.html                | ShopPlan: Estimate MA Plan  |
      |	UHC		| shop/estimate/pdp-costs.html               | ShopPlan: Estimate PDP Plan |  

    @ShopPlan_Shop4_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                   | pageName                        | 
      |	AARP	| shop/medicare-advantage-plans/wellness-discounts.html                  | ShopPlan: Welness Discount      |
      |	AARP	| shop/medicare-advantage-plans/health-care-management.html              | ShopPlan: Healthcare management |
      |	AARP	| shop/renew-active.html                                                 | ShopPlan: Renew-Active          |
      
    @ShopPlan_Shop4_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                   | pageName                        | 
      |	UHC		| shop/medicare-advantage-plans/wellness-discounts.html                  | ShopPlan: Welness Discount      |
      |	UHC		| shop/medicare-advantage-plans/health-care-management.html              | ShopPlan: Healthcare management |
      |	UHC		| shop/renew-active.html                                                 | ShopPlan: Renew-Active          |  

    @ShopPlan_Enroll1_GlobalCompsAARP
    Examples: 
     |	site	| path                                    | pageName                   | 
     |	AARP	| enroll.html                             | ShopPlan: Enroll           | 
     |	AARP	| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  | 
     |	AARP	| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | 
     |	AARP	| enroll/ms-apply.html                    | ShopPlan: Enroll           |
     
    @ShopPlan_Enroll1_GlobalCompsUHC
    Examples: 
     |	site	| path                                    | pageName                   | 
     |	UHC		| enroll.html                             | ShopPlan: Enroll           |
     |	UHC		| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  |
     |	UHC		| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans |
     |	UHC		| enroll/ms-apply.html                    | ShopPlan: Enroll           |
   
    @ShopPlan_Resources1_GlobalCompsAARP
    Examples: 
      |	site	| path                                                              | pageName                             | 
      |	AARP	| resources.html                                                    | ShopPlan: Resources                  |
      |	AARP	| resources/medication-therapy-management-program.html              | ShopPlan: Resources Therapy          |
      |	AARP	| resources/how-to-appoint-a-representative.html                    | ShopPlan: Resources Appoint Rep      |
      |	AARP	| resources/prescription-drug-costs-help.html                       | ShopPlan: Resources Rx cost Help     |
      |	AARP	| resources/healthcare-fraud.html                                   | ShopPlan: Resources Healthcare Fraud |
      |	AARP	| resources/how-to-pay-your-premium.html                            | ShopPlan: Resources Pay Premium      |
      
    @ShopPlan_Resources1_GlobalCompsUHC
    Examples: 
      |	site	| path                                                              | pageName                             | 
      |	UHC		| resources.html                                                    | ShopPlan: Resources                  |
      |	UHC		| resources/medication-therapy-management-program.html              | ShopPlan: Resources Therapy          |
      |	UHC		| resources/how-to-appoint-a-representative.html                    | ShopPlan: Resources Appoint Rep      |
      |	UHC		| resources/prescription-drug-costs-help.html                       | ShopPlan: Resources Rx cost Help     |
      |	UHC		| resources/healthcare-fraud.html                                   | ShopPlan: Resources Healthcare Fraud |
      |	UHC		| resources/how-to-pay-your-premium.html                            | ShopPlan: Resources Pay Premium      |   

    @ShopPlan_Resources2_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                                           | pageName                                         | 
      |	AARP	| resources/pdp-resources-materials.html                                                         | ShopPlan: Resources PDP Plans                    |
      |	AARP	| resources/pdp-resources-materials/pdp-information-forms.html                                   | ShopPlan: Resources PDP Plans Info               |
      |	AARP	| resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html              | ShopPlan: Resources PDP EOB                      | 
      |	AARP	| resources/mail-order-pharmacy.html                                                             | ShopPlan: Resources Mail Order Pharmacy          | 
      |	AARP	| resources/prescription-drug-appeals.html                                                       | ShopPlan: Resources Prescription Drug Appeal     |                                  
      |	AARP	| resources/prescription-drug-transition.html                                                    | ShopPlan: Resources Prescription Drug Transition |                                    

    @ShopPlan_Resources2_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                                           | pageName                                         | 
      |	UHC		| resources/pdp-resources-materials.html                                                         | ShopPlan: Resources PDP Plans                    |
      |	UHC		| resources/pdp-resources-materials/pdp-information-forms.html                                   | ShopPlan: Resources PDP Plans Info               |
      |	UHC		| resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html              | ShopPlan: Resources PDP EOB                      |                               
      |	UHC		| resources/mail-order-pharmacy.html                                                             | ShopPlan: Resources Mail Order Pharmacy          |                             
      |	UHC		| resources/prescription-drug-appeals.html                                                       | ShopPlan: Resources Prescription Drug Appeal     |                                   
      |	UHC		| resources/prescription-drug-transition.html                                                    | ShopPlan: Resources Prescription Drug Transition |                                  
    
    @ShopPlan_Resources3_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                                             | pageName                              | 
      |	AARP	| resources/ma-resources-materials.html                                                            | ShopPlan: Resources MA Plans          |
      |	AARP	| resources/ma-resources-materials/ma-information-forms.html                                       | ShopPlan: Resources MA Plans Info     |
      |	AARP	| resources/ma-resources-materials/ma-information-forms/member-rights.html                         | ShopPlan: Resources MA Member Rights  |
      |	AARP	| resources/ma-resources-materials/ma-information-forms/medicare-appeal.html                       | ShopPlan: Resources MA Appeals        |
      |	AARP	| resources/disenrollment-information.html																					               | ShopPlan: Resources PDP Disenrollment |
      |	AARP	| resources/disenrollment-information.html                                                         | ShopPlan: Resources Disenrollment Page|
   
    @ShopPlan_Resources3_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                                             | pageName                              | 
      |	UHC		| resources/ma-resources-materials.html                                                            | ShopPlan: Resources MA Plans          |
      |	UHC		| resources/ma-resources-materials/ma-information-forms.html                                       | ShopPlan: Resources MA Plans Info     |
      |	UHC		| resources/ma-resources-materials/ma-information-forms/member-rights.html                         | ShopPlan: Resources MA Member Rights  |
      |	UHC		| resources/ma-resources-materials/ma-information-forms/medicare-appeal.html                       | ShopPlan: Resources MA Appeals        |
      |	UHC		| resources/disenrollment-information.html																						             | ShopPlan: Resources PDP Disenrollment |
      |	UHC		| resources/disenrollment-information.html                                                         | ShopPlan: Resources Disenrollment Page|
   
    # Replace any "#" chars in the deeplink with "!"
    @VPP_Deeplinks_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                                                                                                                                                                                                                                                                          | pageName               | 
      |	AARP	| health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD |                             
      |	AARP	| health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP |                             
      |	AARP	| health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  |                             
      |	AARP	| health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   |                             
      |	AARP	| health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      |                       
      |	AARP	| health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | Connector Modal        | 
		

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
