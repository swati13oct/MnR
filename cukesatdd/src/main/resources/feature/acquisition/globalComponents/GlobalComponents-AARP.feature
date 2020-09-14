@GlobalComponentsAARP @F294024
Feature: 1.12 ACQ - Global Components AARP

  @globalfooterULayer
  Scenario Outline: To verify links displayed in the global footer of AARP site
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When user accesses global footer of the Medicare Plans All page
    And user vaidates the state drop down link on the home page
    And user clicks on View all disclaimer information link on the home page
    And user verifies visit aarp.org link on home page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And user clicks on contactus link on aboutus page
    And user clicks on sitemap link on contactus page
    And user clicks on privacypolicy link on sitemap page
    And user clicks on termsOfuse link on privacypolicy page
    And user clicks on disclaimers link on terms&conditions page
    And user clicks on agents&brokers link on disclaimers page
    And user verifies home link of agents&brokers page
    Then user clicks on back to top link of home page

	@globalfooter_AARP
  Examples: 
       |	site	|
       |	AARP	|
 
 @globalfooter_UHC
  Examples: 
       |	site	|
       |	UHC	|      
       

  @globalheaderULayer
  Scenario Outline: To verify links displayed in the global header of AARP site
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When user accesses global header of the Medicare Plans home page
    And user verifies the logo on home page
    And user clicks on Sign in link on home page
    And user clicks on register link on home page
    Then user validates visitor profile on home page
  
  @globalheader_AARP
  Examples: 
       |	site	|
       |	AARP	| 
       
  @globalheader_UHC
  Examples: 
       |	site	|
       |	UHC	| 

  @GlobalComponentsAARPPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the Medicare Plans home page
    When user accesses global footer of the Medicare Plans All page
    Then the User validates Shop for a Plan Navigation link
    Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on the page using ZipCode "90210"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
   # Then the user validates Pro-active Chat
    Then the user validates whether call icon is visible
   # Then the user validates SAM re-active Chat

    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      |	site	| path                                                     | pageName                                   | tfnXpath                                      | tfnFlag |
      |	AARP	| medicare-education.html                                  | MedEd: Landing                             | //*[@class='amp']//a[contains(@class, 'tel')] | true    |
      |	AARP	| medicare-education/medicare-eligibility.html             | MedEd: Eligibility                         | //*[@class='amp']//a[contains(@class, 'tel')] | true    |
      |	AARP	| medicare-education/medicare-parts-and-medigap-plans.html | MedEd: Coverage Choices                    | //*[@class='amp']//a[contains(@class, 'tel')] | true    |
      |	AARP	| medicare-education/medicare-benefits.html                | MedEd: Prescriptions, Providers & Benefits | //*[@class='amp']//a[contains(@class, 'tel')] | true    |

		@MedEdPages_1_GlobalCompsUHC
    Examples: 
      |	site	| path                                                     | pageName                                   | tfnXpath                                      | tfnFlag |
      |	UHC		| medicare-education.html                                  | MedEd: Landing                             | //*[@class='ums']//a[contains(@class, 'tel')] | true    |
      |	UHC		| medicare-education/medicare-eligibility.html             | MedEd: Eligibility                         | //*[@class='ums']//a[contains(@class, 'tel')] | true    |
      |	UHC		| medicare-education/medicare-parts-and-medigap-plans.html | MedEd: Coverage Choices                    | //*[@class='ums']//a[contains(@class, 'tel')] | true    |
      |	UHC		| medicare-education/medicare-benefits.html                | MedEd: Prescriptions, Providers & Benefits | //*[@class='ums']//a[contains(@class, 'tel')] | true    |
		
		
    @MedEdPages_2_GlobalCompsAARP
    Examples: 
      |	site	| path                                              | pageName              | tfnXpath                                      | tfnFlag |
      |	AARP	| medicare-education/medicare-advantage-plans.html  | MedEd: MA Plans       | //*[@class='amp']//a[contains(@class, 'tel')] | true    |
      |	AARP	| medicare-education/medicare-supplement-plans.html | MedEd: Med Supp plans | //a[contains(@class, 'tel')] | true   				|
      |	AARP	| medicare-education/medicare-part-d.html           | MedEd: PDP Plans      | //*[@class='amp']//a[contains(@class, 'tel')] | true    |

    @MedEdPages_2_GlobalCompsUHC
    Examples: 
      |	site	| path                                              | pageName              | tfnXpath                                      | tfnFlag |
      |	UHC		| medicare-education/medicare-advantage-plans.html  | MedEd: MA Plans       | //*[@class='ums']//a[contains(@class, 'tel')] | true    |
      |	UHC		| medicare-education/medicare-supplement-plans.html | MedEd: Med Supp plans | //*[@class='ums']//a[contains(@class, 'tel')] | true    |
      |	UHC		| medicare-education/medicare-part-d.html           | MedEd: PDP Plans      | //*[@class='ums']//a[contains(@class, 'tel')] | true    |
    
    @MedEdPages_3_GlobalCompsAARP
    Examples: 
      |	site	| path                                                  | pageName                    | tfnXpath                                      | tfnFlag |
      |	AARP	| medicare-education/medicare-costs.html                | MedEd: Medicare Cost Basics | //*[@class='amp']//a[contains(@class, 'tel')] | true    |
      |	AARP	| medicare-education/enrollment-and-changing-plans.html | MedEd: Enrollment           | //*[@class='amp']//a[contains(@class, 'tel')] | true    |
      |	AARP	| medicare-education/medicare-faq.html                  | MedEd: FAQ                  | //*[@class='amp']//a[contains(@class, 'tel')] | true    |
      
    @MedEdPages_3_GlobalCompsUHC
    Examples: 
      |	site	| path                                                  | pageName                    | tfnXpath                                      | tfnFlag |
      |	UHC		| medicare-education/medicare-costs.html                | MedEd: Medicare Cost Basics | //*[@class='ums']//a[contains(@class, 'tel')] | true    |
      |	UHC		| medicare-education/enrollment-and-changing-plans.html | MedEd: Enrollment           | //*[@class='ums']//a[contains(@class, 'tel')] | true    |
      |	UHC		| medicare-education/medicare-faq.html                  | MedEd: FAQ                  | //*[@class='ums']//a[contains(@class, 'tel')] | true    |  

    @ShopPlan_Shop1_GlobalCompsAARP
    Examples: 
      |	site	| path                            | pageName                    | tfnXpath                                                       			| tfnFlag |
      |	AARP	| shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] | true  	|
      |	AARP	| shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true   	| 
  	  |	AARP	| shop/connect                    | ShopPlan: Request more Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| true    |
      |	AARP	| shop/compare.html               | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| true    |
      |	AARP	| shop/estimate.html              | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| true    |
      |	AARP	| shop/switch.html                | ShopPlan: Switch            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| true    |
      |	AARP	| shop/compare/compare-ms.html    | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| false   |
      |	AARP	| shop/estimate/ms-costs.html     | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| false   | 
      |	AARP	| shop/compare/compare-ma-ms.html | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| false   | 
      |	AARP	| safe-shopping.html              | ShopPlan: Shop              | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| false   |  
   
   @ShopPlan_Shop1_GlobalCompsUHC
    Examples: 
      |	site	| path                            | pageName                    | tfnXpath                                                       			| tfnFlag |
      |	UHC		| shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] | true  	|
      |	UHC		| shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true   	| 
  	  |	UHC		| shop/connect                    | ShopPlan: Request more Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| true    |
      |	UHC		| shop/compare.html               | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| true    |
      |	UHC		| shop/estimate.html              | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| true    |
      |	UHC		| shop/switch.html                | ShopPlan: Switch            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| true    |
      |	UHC		| shop/compare/compare-ms.html    | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| false   |
      |	UHC		| shop/estimate/ms-costs.html     | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| false   | 
      |	UHC		| shop/compare/compare-ma-ms.html | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| false   | 
      |	UHC		| safe-shopping.html              | ShopPlan: Shop              | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 			| false   |
  
    @ShopPlan_Shop2_GlobalCompsAARP
    Examples: 
      |	site	| path                                             | pageName                     | tfnXpath                                                      						 | tfnFlag |
      |	AARP	| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1]				 | true    |
      |	AARP	| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[2]				 | true    |
      |	AARP	| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | (//*[contains(text(),'Find a Plan')]//following::a[2])										 | true    |
      |	AARP	| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] 			 | true    |
      |	AARP	| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] 	 		 | true    |
      |	AARP	| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] 		 	 | true    |
			|	AARP	| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] 			 | true    |
			
	@ShopPlan_Shop2_GlobalCompsUHC
    Examples: 
      |	site	| path                                             | pageName                     | tfnXpath                                                      						 | tfnFlag |
      |	UHC		| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1]				 | true    |
      |	UHC		| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[2]				 | true    |
      |	UHC		| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | (//*[contains(text(),'Find a Plan')]//following::a[2])										 | true    |
      |	UHC		| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] 			 | true    |
      |	UHC		| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] 	 		 | true    |
      |	UHC		| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] 		 	 | true    |
			|	UHC		| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] 			 | true    |		


    @ShopPlan_Shop3_GlobalCompsAARP
    Examples: 
      |	site	| path                                       | pageName                    | tfnXpath                                                       | tfnFlag |
      |	AARP	| shop/compare/compare-pdp.html              | ShopPlan: Compare PDP Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| shop/compare/compare-ma.html               | ShopPlan: Compare MA  Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| shop/estimate/ma-costs.html                | ShopPlan: Estimate MA Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| shop/estimate/pdp-costs.html               | ShopPlan: Estimate PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      
    @ShopPlan_Shop3_GlobalCompsUHC
    Examples: 
      |	site	| path                                       | pageName                    | tfnXpath                                                       | tfnFlag |
      |	UHC		| shop/compare/compare-pdp.html              | ShopPlan: Compare PDP Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| shop/compare/compare-ma.html               | ShopPlan: Compare MA  Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| shop/estimate/ma-costs.html                | ShopPlan: Estimate MA Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| shop/estimate/pdp-costs.html               | ShopPlan: Estimate PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  

    @ShopPlan_Shop4_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                   | pageName                        | tfnXpath                                                       | tfnFlag |
      |	AARP	| shop/medicare-advantage-plans/wellness-discounts.html                  | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| shop/medicare-advantage-plans/health-care-management.html              | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| shop/renew-active.html                                                 | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      
    @ShopPlan_Shop4_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                   | pageName                        | tfnXpath                                                       | tfnFlag |
      |	UHC		| shop/medicare-advantage-plans/wellness-discounts.html                  | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| shop/medicare-advantage-plans/health-care-management.html              | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| shop/renew-active.html                                                 | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  

    @ShopPlan_Enroll1_GlobalCompsAARP
    Examples: 
     |	site	| path                                    | pageName                   | tfnXpath                                                       | tfnFlag |
     |	AARP	| enroll.html                             | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
     |	AARP	| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
     |	AARP	| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
     |	AARP	| enroll/ms-apply.html                    | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
     
    @ShopPlan_Enroll1_GlobalCompsUHC
    Examples: 
     |	site	| path                                    | pageName                   | tfnXpath                                                       | tfnFlag |
     |	UHC		| enroll.html                             | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
     |	UHC		| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
     |	UHC		| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
     |	UHC		| enroll/ms-apply.html                    | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
   
    @ShopPlan_Resources1_GlobalCompsAARP
    Examples: 
      |	site	| path                                                              | pageName                             | tfnXpath                                                       | tfnFlag |
      |	AARP	| resources.html                                                    | ShopPlan: Resources                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| resources/medication-therapy-management-program.html              | ShopPlan: Resources Therapy          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/how-to-appoint-a-representative.html                    | ShopPlan: Resources Appoint Rep      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/prescription-drug-costs-help.html                       | ShopPlan: Resources Rx cost Help     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/healthcare-fraud.html                                   | ShopPlan: Resources Healthcare Fraud | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/how-to-pay-your-premium.html                            | ShopPlan: Resources Pay Premium      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      
    @ShopPlan_Resources1_GlobalCompsUHC
    Examples: 
      |	site	| path                                                              | pageName                             | tfnXpath                                                       | tfnFlag |
      |	UHC		| resources.html                                                    | ShopPlan: Resources                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	UHC		| resources/medication-therapy-management-program.html              | ShopPlan: Resources Therapy          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/how-to-appoint-a-representative.html                    | ShopPlan: Resources Appoint Rep      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/prescription-drug-costs-help.html                       | ShopPlan: Resources Rx cost Help     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/healthcare-fraud.html                                   | ShopPlan: Resources Healthcare Fraud | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/how-to-pay-your-premium.html                            | ShopPlan: Resources Pay Premium      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |   

    @ShopPlan_Resources2_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                                           | pageName                                         | tfnXpath                                                       | tfnFlag |
      |	AARP	| resources/pdp-resources-materials.html                                                         | ShopPlan: Resources PDP Plans                    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/pdp-resources-materials/pdp-information-forms.html                                   | ShopPlan: Resources PDP Plans Info               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html              | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    | true    |
      |	AARP	| resources/mail-order-pharmacy.html                                                             | ShopPlan: Resources Mail Order Pharmacy          | (//*[contains(@class,'tel')])[2]                               | true    |
      |	AARP	| resources/prescription-drug-appeals.html                                                       | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    | true    |
      |	AARP	| resources/prescription-drug-transition.html                                                    | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    | true    |

    @ShopPlan_Resources2_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                                           | pageName                                         | tfnXpath                                                       | tfnFlag |
      |	UHC		| resources/pdp-resources-materials.html                                                         | ShopPlan: Resources PDP Plans                    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/pdp-resources-materials/pdp-information-forms.html                                   | ShopPlan: Resources PDP Plans Info               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html              | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    | true    |
      |	UHC		| resources/mail-order-pharmacy.html                                                             | ShopPlan: Resources Mail Order Pharmacy          | (//*[contains(@class,'tel')])[2]                               | true    |
      |	UHC		| resources/prescription-drug-appeals.html                                                       | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    | true    |
      |	UHC		| resources/prescription-drug-transition.html                                                    | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    | true    |
    
    @ShopPlan_Resources3_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                                             | pageName                              | tfnXpath                                                       | tfnFlag |
      |	AARP	| resources/ma-resources-materials.html                                                            | ShopPlan: Resources MA Plans          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/ma-resources-materials/ma-information-forms.html                                       | ShopPlan: Resources MA Plans Info     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/ma-resources-materials/ma-information-forms/member-rights.html                         | ShopPlan: Resources MA Member Rights  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/ma-resources-materials/ma-information-forms/medicare-appeal.html                       | ShopPlan: Resources MA Appeals        | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/disenrollment-information.html																					               | ShopPlan: Resources PDP Disenrollment | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/disenrollment-information.html                                                         | ShopPlan: Resources Disenrollment Page| //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
   
    @ShopPlan_Resources3_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                                             | pageName                              | tfnXpath                                                       | tfnFlag |
      |	UHC		| resources/ma-resources-materials.html                                                            | ShopPlan: Resources MA Plans          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/ma-resources-materials/ma-information-forms.html                                       | ShopPlan: Resources MA Plans Info     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/ma-resources-materials/ma-information-forms/member-rights.html                         | ShopPlan: Resources MA Member Rights  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/ma-resources-materials/ma-information-forms/medicare-appeal.html                       | ShopPlan: Resources MA Appeals        | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/disenrollment-information.html																						             | ShopPlan: Resources PDP Disenrollment | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	UHC		| resources/disenrollment-information.html                                                         | ShopPlan: Resources Disenrollment Page| //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
   
    # Replace any "#" chars in the deeplink with "!"
    @VPP_Deeplinks_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                                                                                                                                                                                                                                                                          | pageName               | tfnXpath                                                    | tfnFlag |
      |	AARP	| health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | //a[contains(@class, 'tel')]                                | true    |
      |	AARP	| health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | //a[contains(@class, 'tel')]                                | true    |
      |	AARP	| health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  | //a[contains(@class, 'tel')]                                | true    |
      |	AARP	| health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   | //a[contains(@class, 'tel')]                                | true    |
      |	AARP	| health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      | //a[contains(@class, 'tel')]                                | false   |
      |	AARP	| health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | Connector Modal        | //a[contains(@href ,'tel') and contains(@class,'tel')] | true    |
		
		# Replace any "#" chars in the deeplink with "!"
		
		@VPP_Deeplinks_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                                                                                                                                                                                                                                                                          | pageName               | tfnXpath                                                    | tfnFlag |
      |	UHC		| health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | //a[contains(@class, 'tel')]                                | true    |
      |	UHC		| health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | //a[contains(@class, 'tel')]                                | true    |
      |	UHC		| health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  | //a[contains(@class, 'tel')]                                | true    |
      |	UHC		| health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   | //a[contains(@class, 'tel')]                                | true    |
      |	UHC		| health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      | //a[contains(@class, 'tel')]                                | false   |
      |	UHC		| health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | Connector Modal        | //a[contains(@href ,'tel') and contains(@class,'tel')] | true    |
				
    @MiscellaneousLinks_GlobalCompsAARP
    Examples: 
      |	site	| path                                                       | pageName                | tfnXpath                                                       | tfnFlag |
      |	AARP	| estimate-drug-costs.html!/drug-cost-estimator              | Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |
      |	AARP	| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   | Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |
      |	AARP	| medicare-plans.html                                        | ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| profile/guest                                              | Visitor Profile: Guest  | //*[contains(@class,'tel')]                                              | true    |
		
		@MiscellaneousLinks_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                      | pageName                | tfnXpath                                                       | tfnFlag |
      |	UHC		| estimate-drug-costs.html!/drug-cost-estimator               							| Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |
      |	UHC		| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English                  | Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |
      |	UHC		| medicare-plans.html                                                       | ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	UHC		| profile/guest                                                             | Visitor Profile: Guest  | //*[@class='tel']                                              | true    |
		
    @FooterLinks_GlobalCompsAARP
    Examples: 
      |	site	| path                          | pageName                   | tfnXpath                     | tfnFlag |
      |	AARP	| about-us.html                 | Footer: About Us           | //a[contains(@class, 'tel')] | false   |
      |	AARP	| sitemap.html                  | Footer: Site Map           | //a[contains(@href ,'tel')]  | false   |
      |	AARP	| terms-of-use.html             | Footer: Terms of Use       | //a[contains(@href ,'tel')]  | false   |
      |	AARP	| disclaimer.html               | Footer: Disclaimers        | //a[contains(@href ,'tel')]  | false   |
      |	AARP	| health-insurance-brokers.html | Footer: Agents and Brokers | //a[contains(@href ,'tel')]  | false   |
      |	AARP	| contact-us.html               | Footer: Contact Us         | //a[contains(@href ,'tel')]  | false   |
      |	AARP	| privacy-policy.html           | Footer: Privacy Policy     | //a[contains(@href ,'tel')]  | false   |

	@FooterLinks_GlobalCompsUHC
    Examples: 
      |	site	| path                          | pageName                   | tfnXpath                     | tfnFlag |
      |	UHC		| about-us.html                 | Footer: About Us           | //a[contains(@class, 'tel')] | false   |
      |	UHC		| sitemap.html                  | Footer: Site Map           | //a[contains(@href ,'tel')]  | false   |
      |	UHC		| terms-of-use.html             | Footer: Terms of Use       | //a[contains(@href ,'tel')]  | false   |
      |	UHC		| disclaimer.html               | Footer: Disclaimers        | //a[contains(@href ,'tel')]  | false   |
      |	UHC		| health-insurance-brokers.html | Footer: Agents and Brokers | //a[contains(@href ,'tel')]  | false   |
      |	UHC		| contact-us.html               | Footer: Contact Us         | //a[contains(@href ,'tel')]  | false   |
      |	UHC		| privacy-policy.html           | Footer: Privacy Policy     | //a[contains(@href ,'tel')]  | false   |

  @GlobalComponentsAARP_ISonlyPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the Medicare Plans home page
    When user accesses global footer of the Medicare Plans All page
    Then the User validates Shop for a Plan Navigation link
    Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on the page using ZipCode "90210"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible

    @MedSuppOnlyPages_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                      | pageName          | tfnXpath       | tfnFlag |
      |	AARP	| medicare-supplement-plans/medicare-information.html?vpp=true              | Decision Guide    | //*[@id='tfn'] | true    |
      |	AARP	|	medicare-supplement-plans/agent-appointment.html                          | Agent Appointment | //*[@id='tfn'] | true    |
      
    @MedSuppOnlyPages_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                      | pageName          | tfnXpath       | tfnFlag |
      |	UHC	| medicare-supplement-plans/medicare-information.html?vpp=true              | Decision Guide    | //*[@id='tfn'] | true    |
      |	UHC	|	medicare-supplement-plans/agent-appointment.html                          | Agent Appointment | //*[@id='tfn'] | true    |  
      
      
      @GlobalComponentsAARPNewShopPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on AARP medicare acquisition site landing page
    Given the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "90210"
    Then the user validates TFN on page
     | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
      
		 @GlobalComponentsAARPNewShopPages1
    Examples: 
      | path                          | pageName                   | tfnXpath                     | tfnFlag |
      | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
     
