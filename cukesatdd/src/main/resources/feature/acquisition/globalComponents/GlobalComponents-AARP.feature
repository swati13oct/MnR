
@GlobalComponentsAARP 
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

	@globalfooter
  Examples: 
       |	site	|
       |	AARP	|
 
 @globalfooter
  Examples: 
       |	site	|
       |	UHC	|      
       

  @globalheaderULayer
  Scenario Outline: To verify links displayed in the global header of AARP site
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When user accesses global header of the Medicare Plans home page
    And user verifies the logo on home page
    And user clicks on Sign in link in the header
    And user clicks on register link in the header
    Then user clicks on the heart icon in the header
  
  @globalheader   @globalheaderULayer
  Examples: 
       |	site	|
       |	AARP	| 
       
  @globalheader
  Examples: 
       |	site	|
       |	UHC	| 

  @GlobalComponentsAARPPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the Medicare Plans home page
    When user accesses global footer of the Medicare Plans All page
    Then the User validates Shop for a Plan Navigation link
    Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on the page using ZipCode "10001"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
   # Then the user validates Pro-active Chat
    Then the user validates whether call icon is visible
   # Then the user validates SAM re-active Chat

    @MedEdPages_1_GlobalCompsAARP
    Examples: 
      |	site	| path                                                     | pageName                                   										| tfnXpath                                      													 | tfnFlag |
      |	AARP	| medicare-education.html                                  | Understanding Medicare | AARP Medicare Plans   								| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		 | true    |
      |	AARP	| medicare-education/medicare-eligibility.html             | Medicare Eligibility | AARP Medicare Plans     								| //*[@class='amp']//a[contains(@class, 'tel')] 													 | true    |
#      |	AARP	| medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Options | AARP Medicare Plans    | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		 | true    |
      |	AARP	| medicare-education/medicare-benefits.html                | Prescriptions, Providers & Benefits | AARP Medicare Plans			| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		 | true    |

		@MedEdPages_1_GlobalCompsUHC
    Examples: 
      |	site	| path                                                     | pageName                                   											| tfnXpath                                      														| tfnFlag |
      |	UHC		| medicare-education.html                                  | Understanding Medicare | UnitedHealthcare  											| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]			| true    |
      |	UHC		| medicare-education/medicare-eligibility.html             | Medicare Eligibility | UnitedHealthcare    											| //*[@class='ums']//a[contains(@class, 'tel')] 														| true    |
#      |	UHC		| medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Choices | UnitedHealthcare					| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		 	| true    |
      |	UHC		| medicare-education/medicare-benefits.html                | Medicare Prescriptions, Providers & Benefits | UnitedHealthcare 	| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 			| true    |
		
		
    @MedEdPages_2_GlobalCompsAARP
    Examples: 
      |	site	| path                                              | pageName              																					| tfnXpath                                      													| tfnFlag |
#      |	AARP	| medicare-education/medicare-advantage-plans.html  | Learn about Medicare Advantage Plans | AARP Medicare Plans      | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true    |
      |	AARP	| medicare-education/medicare-supplement-plans.html | Learn about Medicare Supplement Plans | AARP Medicare Plans 		| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true   	|
      |	AARP	| medicare-education/medicare-part-d.html           | Medicare Prescription Drug Plans | AARP Medicare Plans      		| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true    |

    @MedEdPages_2_GlobalCompsUHC
    Examples: 
      |	site	| path                                              | pageName              																			| tfnXpath                                      													| tfnFlag |
#      |	UHC		| medicare-education/medicare-advantage-plans.html  | Medicare Advantage (Part C) Plans | UnitedHealthcare       	| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true    |
      |	UHC		| medicare-education/medicare-supplement-plans.html | Medicare Supplement Insurance Plans | UnitedHealthcare 			| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		| true    |
      |	UHC		| medicare-education/medicare-part-d.html           | Medicare Prescription Drug Plans | UnitedHealthcare		      | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		| true    |
    
    @MedEdPages_3_GlobalCompsAARP
    Examples: 
      |	site	| path                                                  | pageName                    													| tfnXpath                                      													| tfnFlag |
#      |	AARP	| medicare-education/medicare-costs.html                | Medicare Cost Basics | AARP Medicare Plans 						| //span[contains(@style,'inline')]//a[contains(@class, 'tel')] 					| true    |
#      |	AARP	| medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics | AARP Medicare Plans      | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		| true    |
      |	AARP	| medicare-education/medicare-faq.html                  | Medicare FAQ | AARP Medicare Plans	                  | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true    |
      
    @MedEdPages_3_GlobalCompsUHC
    Examples: 
      |	site	| path                                                  | pageName                    											| tfnXpath                                      													| tfnFlag |
#      |	UHC		| medicare-education/medicare-costs.html                | Medicare Cost Basics | UnitedHealthcare						| //span[contains(@style,'inline')]//a[contains(@class, 'tel')] 					| true    |
#      |	UHC		| medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics | UnitedHealthcare    	| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		| true    |
      |	UHC		| medicare-education/medicare-faq.html                  | Medicare FAQ | UnitedHealthcare	                  | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true    |  

    @ShopPlan_Shop1_GlobalCompsAARP
    Examples: 
      |	site	| path                            | pageName                    | tfnXpath                                                       														| tfnFlag |
      |	AARP	| shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] 											| true  	|
      |	AARP	| shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] 											| true   	| 
  	  |	AARP	| shop/connect                    | ShopPlan: Request more Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| true    |
      |	AARP	| shop/compare.html               | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| false   |
      |	AARP	| shop/estimate.html              | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| false   |
      |	AARP	| shop/switch.html                | ShopPlan: Switch            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| false   |
      |	AARP	| shop/compare/compare-ms.html    | ShopPlan: Compare           | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true	  |
      |	AARP	| shop/estimate/ms-costs.html     | ShopPlan: Estimate          | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true	  | 
      |	AARP	| shop/compare/compare-ma-ms.html | ShopPlan: Compare           | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')] 		| true	  | 
      |	AARP	| safe-shopping.html              | ShopPlan: Shop              | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')] 		| true	  |  
   
   @ShopPlan_Shop1_GlobalCompsUHC
    Examples: 
      |	site	| path                            | pageName                    | tfnXpath                                                       														| tfnFlag |
      |	UHC		| shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] 											| true  	|
      |	UHC		| shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] 											| true   	| 
  	  |	UHC		| shop/connect                    | ShopPlan: Request more Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| true    |
      |	UHC		| shop/compare.html               | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| false   |
      |	UHC		| shop/estimate.html              | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| false   |
      |	UHC		| shop/switch.html                | ShopPlan: Switch            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| false   |
      |	UHC		| shop/compare/compare-ms.html    | ShopPlan: Compare           | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true  	|
      |	UHC		| shop/estimate/ms-costs.html     | ShopPlan: Estimate          | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')]	| true	  | 
      |	UHC		| shop/compare/compare-ma-ms.html | ShopPlan: Compare           | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')]		| true	  | 
      |	UHC		| safe-shopping.html              | ShopPlan: Shop              | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')]		| true   |
  
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
      |	AARP	| resources/pdp-resources-materials.html                                                         | ShopPlan: Resources PDP Plans                    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| resources/pdp-resources-materials/pdp-information-forms.html                                   | ShopPlan: Resources PDP Plans Info               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html              | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    | true    |
      |	AARP	| resources/mail-order-pharmacy.html                                                             | ShopPlan: Resources Mail Order Pharmacy          | (//*[contains(@class,'tel')])[2]                               | false   |
      |	AARP	| resources/prescription-drug-appeals.html                                                       | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    | true    |
      |	AARP	| resources/prescription-drug-transition.html                                                    | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    | true    |

    @ShopPlan_Resources2_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                                           | pageName                                         | tfnXpath                                                       | tfnFlag |
      |	UHC		| resources/pdp-resources-materials.html                                                         | ShopPlan: Resources PDP Plans                    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	UHC		| resources/pdp-resources-materials/pdp-information-forms.html                                   | ShopPlan: Resources PDP Plans Info               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false    |
      |	UHC		| resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html              | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    | true    |
      |	UHC		| resources/mail-order-pharmacy.html                                                             | ShopPlan: Resources Mail Order Pharmacy          | (//*[contains(@class,'tel')])[2]                               | false   |
      |	UHC		| resources/prescription-drug-appeals.html                                                       | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    | true    |
      |	UHC		| resources/prescription-drug-transition.html                                                    | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    | true    |
    
    @ShopPlan_Resources3_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                                             | pageName                              | tfnXpath                                                       | tfnFlag |
      |	AARP	| resources/ma-resources-materials.html                                                            | ShopPlan: Resources MA Plans          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| resources/ma-resources-materials/ma-information-forms.html                                       | ShopPlan: Resources MA Plans Info     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| resources/ma-resources-materials/ma-information-forms/member-rights.html                         | ShopPlan: Resources MA Member Rights  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/ma-resources-materials/ma-information-forms/medicare-appeal.html                       | ShopPlan: Resources MA Appeals        | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/disenrollment-information.html																					               | ShopPlan: Resources PDP Disenrollment | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/disenrollment-information.html                                                         | ShopPlan: Resources Disenrollment Page| //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
   
    @ShopPlan_Resources3_GlobalCompsUHC
    Examples: 
      |	site	| path                                                                                             | pageName                              | tfnXpath                                                       | tfnFlag |
      |	UHC		| resources/ma-resources-materials.html                                                            | ShopPlan: Resources MA Plans          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	UHC		| resources/ma-resources-materials/ma-information-forms.html                                       | ShopPlan: Resources MA Plans Info     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
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
      |	site	| path                                                       		| pageName                | tfnXpath                                                       | tfnFlag |
      |	AARP	| health-plans/estimate-drug-costs.html!/drug-cost-estimator    | Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |
      |	AARP	| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   		| Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |
      |	AARP	| medicare-plans.html                                        		| ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| profile/guest                                              		| Visitor Profile: Guest  | //*[contains(@class,'tel')]                                              | true    |
		
		@MiscellaneousLinks_GlobalCompsUHC
    Examples: 
      |	site	| path                                                          | pageName                | tfnXpath                                                       | tfnFlag |
      |	UHC		| health-plans/estimate-drug-costs.html!/drug-cost-estimator		| Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |
      |	UHC		| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English      | Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |
      |	UHC		| medicare-plans.html                                           | ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	UHC		| profile/guest                                                 | Visitor Profile: Guest  | //*[contains(@class,'tel')]                                              | true    |
		
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

#	@FooterLinks_GlobalCompsUHC
    #Examples: 
      #|	site	| path                          | pageName                   | tfnXpath                     | tfnFlag |
      #|	UHC		| about-us.html                 | Footer: About Us           | //a[contains(@class, 'tel')] | false   |
      #|	UHC		| sitemap.html                  | Footer: Site Map           | //a[contains(@href ,'tel')]  | false   |
      #|	UHC		| terms-of-use.html             | Footer: Terms of Use       | //a[contains(@href ,'tel')]  | false   |
      #|	UHC		| disclaimer.html               | Footer: Disclaimers        | //a[contains(@href ,'tel')]  | false   |
      #|	UHC		| health-insurance-brokers.html | Footer: Agents and Brokers | //a[contains(@href ,'tel')]  | false   |
      #|	UHC		| contact-us.html               | Footer: Contact Us         | //a[contains(@href ,'tel')]  | false   |
      #|	UHC		| privacy-policy.html           | Footer: Privacy Policy     | //a[contains(@href ,'tel')]  | false   |

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
     
   
     
    @GlobalComponentsAARPShopPages 
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55410"
    
    
    @ShopPages_Shop_GlobalCompsAARP
     Examples: 
    |site   | path                                                                      | pageName      | 
    |AARP   | contact-us.html                                                           | Contact us  | 
    |AARP   | shop/estimate/ma-costs.html                                               | Estimate  MA  | 
    |AARP   | shop/estimate/pdp-costs.html                                              | Estimate PDP  |
    |AARP   | shop/switch.html                                                          | Switch        |
    |AARP   | shop/renew-active.html                                                    | Renew Active  |
    |AARP   | shop/medicare-advantage-plans/ma-plan-benefits.html                       | MA Plan benefits|
    |AARP   | shop/compare/compare-ma.html                                              | Compare MA    |
    |AARP   | shop/compare/compare-pdp.html                                             | Compare PDP   |
    |AARP   | shop/medicare-advantage-veteran-plan.html                                 | MA Veteran Plan|
    |AARP   | enroll/ma-enrollment.html                                                 | MA Enrollment |
    |AARP   | enroll/pdp-enrollment.html                                                | PDP Enrollment|
    |AARP   |medicare-articles/eligibility-and-enrollment.html                          | Sample Category Page   |
            
    @ShopPages_Shop_GlobalCompsUHC
     Examples: 
    |site  | path                                                                      | pageName      | 
    |UHC   | contact-us.html                                                           | Contact us    |
    |UHC   | shop/estimate/ma-costs.html                                               | Estimate  MA  | 
    |UHC   | shop/estimate/pdp-costs.html                                              | Estimate PDP  |
    |UHC   | shop/switch.html                                                          | Switch        |
    |UHC   | shop/renew-active.html                                                    | Renew Active  |
    |UHC   | shop/medicare-advantage-plans/ma-plan-benefits.html                       | MA Plan benefits|
    |UHC   | shop/compare/compare-ma.html                                              | Compare MA    |
    |UHC   | shop/compare/compare-pdp.html                                             | Compare PDP   |
    |UHC   | shop/medicare-advantage-veteran-plan.html                                 | MA Veteran Plan|
    |UHC   | enroll/ma-enrollment.html                                                 | MA Enrollment |
    |UHC   | enroll/pdp-enrollment.html                                                | PDP Enrollment|
    |UHC   |medicare-articles/eligibility-and-enrollment.html                          | Sample Category Page   |
    
   @GlobalComponentsAARPBlogPages   
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
  		| Site | <site>	|
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user enters and validate the fields and clicks on submit 
    Then the user validate ZipCode Components on page using ZipCode "55410"
    
    

  @BlogPages_Blog1_GlobalCompsAARP
     Examples: 
   |site   |path                                                                                     | pageName               |
   |AARP   |medicare-articles.html                                                                   | Medicare Articles Home |
   |AARP   |medicare-articles/medicare-made-clear.html                                               | About MMC              |
   |AARP   |medicare-articles/what-is-retiree-health-coverage.html                                   | Sample Article Page 2  |
   |AARP   |medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html  | Sample Article Page 1  |
   |AARP   |medicare-articles/medicare-benefits-and-coverage.html                                    | Category page          |
   |AARP   |medicare-articles/medicare-costs.html                                                    | Category page          |
   |AARP   |medicare-articles/shopping-for-medicare.html                                             | Category page          |
   |AARP   |medicare-articles/medicare-when-working-past-65.html                                     | Category page          |
   |AARP   |medicare-articles/medicare-tips-and-faqs.html                                            | Category page          |
   |AARP   |medicare-articles/how-to-avoid-the-medicare-part-b-late-penalty                          | Article page           |


  @BlogPages_Blog1_GlobalCompsUHC
     Examples: 
   |site   |path                                                                                     | pageName               |
   |UHC   |medicare-articles.html                                                                   | Medicare Articles Home |
   |UHC   |medicare-articles/medicare-made-clear.html                                               | About MMC              |
   |UHC   |medicare-articles/what-is-retiree-health-coverage.html                                   | Sample Article Page 2  |
   |UHC   |medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html  | Sample Article Page 1  |
   |UHC   |medicare-articles/medicare-benefits-and-coverage.html                                    | Category page          |
   |UHC   |medicare-articles/medicare-costs.html                                                    | Category page          |
   |UHC   |medicare-articles/shopping-for-medicare.html                                             | Category page          |
   |UHC   |medicare-articles/medicare-when-working-past-65.html                                     | Category page          |
   |UHC   |medicare-articles/medicare-tips-and-faqs.html                                            | Category page          |
   |UHC   |medicare-articles/how-to-avoid-the-medicare-part-b-late-penalty                          | Article page           |
   
 @BlogPages_Blog2_GlobalCompsAARP
     Examples: 
   |site |path                                                                                                        | pageName   |
   |AARP |medicare-articles/9-good-reasons-why-a-medicare-advantage-plan-might-be-right-for-you                       |Article page|
   |AARP |medicare-articles/caregiver-corner-helping-your-loved-one-prepare-for-the-medicare-annual-enrollment-period |Article page|
   |AARP |medicare-articles/your-5-point-checklist-choosing-medicare-part-d-plan                                      |Article page|
   |AARP |medicare-articles/6-tips-to-protect-yourself-from-medicare-fraud                                            |Article page|
   |AARP |medicare-articles/what-will-medicare-cost-in-2020                                                           |Article page|
   |AARP |medicare-articles/medicare-plan-annual-notice-of-change-what-to-look-for                                    |Article page|
   |AARP |medicare-articles/need-eyeglasses-or-eye-care-coverage-check-your-medicare-options                          |Article page|
   |AARP |medicare-articles/medicare-doesnt-cover-everything-what-you-need-know                                       |Article page|
   |AARP |medicare-articles/6-timely-medicare-tips-for-turning-65                                                     |Article page|
   |AARP |medicare-articles/should-i-get-part-b-if-im-working-past-65                                                 |Article page|
   
    @BlogPages_Blog2_GlobalCompsUHC
     Examples: 
   |site |path                                                                                                        | pageName   |
   |UHC |medicare-articles/9-good-reasons-why-a-medicare-advantage-plan-might-be-right-for-you                       |Article page|
   |UHC |medicare-articles/caregiver-corner-helping-your-loved-one-prepare-for-the-medicare-annual-enrollment-period |Article page|
   |UHC |medicare-articles/your-5-point-checklist-choosing-medicare-part-d-plan                                      |Article page|
   |UHC |medicare-articles/6-tips-to-protect-yourself-from-medicare-fraud                                            |Article page|
   |UHC |medicare-articles/what-will-medicare-cost-in-2020                                                           |Article page|
   |UHC |medicare-articles/medicare-plan-annual-notice-of-change-what-to-look-for                                    |Article page|
   |UHC |medicare-articles/need-eyeglasses-or-eye-care-coverage-check-your-medicare-options                          |Article page|
   |UHC |medicare-articles/medicare-doesnt-cover-everything-what-you-need-know                                       |Article page|
   |UHC |medicare-articles/6-timely-medicare-tips-for-turning-65                                                     |Article page|
   |UHC |medicare-articles/should-i-get-part-b-if-im-working-past-65                                                 |Article page|

 @BlogPages_Blog3_GlobalCompsAARP
     Examples: 
   |site |path                                                                                                        | pageName   |
   |AARP|medicare-articles/try-to-avoid-medicare-late-enrollment-premium-penalties                                    |Article page|
   |AARP|medicare-articles/what-is-the-difference-between-original-medicare-and-medicare-advantage                    |Article page|
   |AARP|medicare-articles/do-i-need-medicare-with-spouses-employer-plan                                              |Article page|
   |AARP|medicare-articles/5-ways-to-pay-your-medicare-part-b-premium                                                 |Article page|
   |AARP|medicare-articles/5-medicare-myths-set-straight                                                              |Article page|
   |AARP|medicare-articles/when-can-you-start-getting-medicare                                                        |Article page|
   |AARP|medicare-articles/is-medicare-mandatory                                                                      |Article page|
   |AARP|medicare-articles/can-i-change-my-medicare-plan                                                              |Article page|
   |AARP|medicare-articles/medicare-coverage-for-non-working-spouses                                                  |Article page|
   |AARP|medicare-articles/5-tips-for-enrolling-in-medicare-for-the-first-time                                        |Article page|
   
   
    @BlogPages_Blog3_GlobalCompsUHC
     Examples: 
   |site |path                                                                                                        | pageName   |
   |UHC|medicare-articles/try-to-avoid-medicare-late-enrollment-premium-penalties                                    |Article page|
   |UHC|medicare-articles/what-is-the-difference-between-original-medicare-and-medicare-advantage                    |Article page|
   |UHC|medicare-articles/do-i-need-medicare-with-spouses-employer-plan                                              |Article page|
   |UHC|medicare-articles/5-ways-to-pay-your-medicare-part-b-premium                                                 |Article page|
   |UHC|medicare-articles/5-medicare-myths-set-straight                                                              |Article page|
   |UHC|medicare-articles/when-can-you-start-getting-medicare                                                        |Article page|
   |UHC|medicare-articles/is-medicare-mandatory                                                                      |Article page|
   |UHC|medicare-articles/can-i-change-my-medicare-plan                                                              |Article page|
   |UHC|medicare-articles/medicare-coverage-for-non-working-spouses                                                  |Article page|
   |UHC|medicare-articles/5-tips-for-enrolling-in-medicare-for-the-first-time                                        |Article page|
   
   
    @BlogPages_Blog4_GlobalCompsAARP
     Examples: 
   |site |path                                                                                                          | pageName   |
   |AARP|medicare-articles/decide-change-plan                                                                           |Article page|
   |AARP|medicare-articles/medicare-coverage-for-mammograms                                                             |Article page|
   |AARP|medicare-articles/have-diabetes-medicare-parts-b-and-d-have-you-covered                                        |Article page|
   |AARP|medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period                                   |Article page|
   |AARP|medicare-articles/what-does-original-medicare-include                                                          |Article page|
   |AARP|medicare-articles/what-is-creditable-drug-coverage                                                             |Article page|
   |AARP|medicare-articles/safe-medicare-enrollment-during-COVID                                                        |Article page|
   |AARP|medicare-articles/what-is-the-medicare-annual-enrollment-period                                                 |Article page|
   |AARP|medicare-articles/aep-change-or-renew                                                                             |Article page|
   |AARP|medicare-articles/can-you-switch-between-original-medicare-and-medicare-advantage-during-the-annual-enrollment-period |Article page|
   
   
      
    @BlogPages_Blog4_GlobalCompsUHC
     Examples: 
   |site |path                                                                                                          | pageName   |
   |UHC|medicare-articles/decide-change-plan                                                                           |Article page|
   |UHC|medicare-articles/medicare-coverage-for-mammograms                                                             |Article page|
   |UHC|medicare-articles/have-diabetes-medicare-parts-b-and-d-have-you-covered                                        |Article page|
   |UHC|medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period                                   |Article page|
   |UHC|medicare-articles/what-does-original-medicare-include                                                          |Article page|
   |UHC|medicare-articles/what-is-creditable-drug-coverage                                                             |Article page|
   |UHC|medicare-articles/safe-medicare-enrollment-during-COVID                                                        |Article page|
   |UHC|medicare-articles/what-is-the-medicare-annual-enrollment-period                                                 |Article page|
   |UHC|medicare-articles/aep-change-or-renew                                                                             |Article page|
   |UHC|medicare-articles/can-you-switch-between-original-medicare-and-medicare-advantage-during-the-annual-enrollment-period |Article page|

   @BlogPages_Blog5_GlobalCompsAARP
     Examples: 
 |site |path                                                                                                | pageName   |
|AARP|medicare-articles/2-ways-to-prescription-drug-coverage                                                  | Article page|
|AARP|medicare-articles/good-reasons-to-shop-for-a-new-medicare-plan                                          | Article page|
|AARP|medicare-articles/the-difference-between-medicare-hmo-and-ppo-plans                                     | Article page|
|AARP|medicare-articles/medicare-mistakes-that-could-be-costly                                                | Article page|
|AARP|medicare-articles/5-savvy-shopper-tips-help-get-medicare                                                | Article page|
|AARP|medicare-articles/which-vaccines-does-medicare-cover                                                    | Article page|
|AARP|medicare-articles/what-if-i-missed-my-initial-enrollment-period                                         | Article page|
|AARP|medicare-articles/4-basic-questions-to-ask-about-medicare-part-d-coverage                               | Article page|
|AARP|medicare-articles/turn-65-retire-sign-up-for-medicare-or-not                                            | Article page|
|AARP|medicare-articles/7-inside-tips-to-help-you-make-a-smooth-move-to-medicare                              | Article page|


 @BlogPages_Blog5_GlobalCompsUHC
     Examples: 
|site|path                                                                                                   | pageName   |
|UHC|medicare-articles/2-ways-to-prescription-drug-coverage                                                  | Article page|
|UHC|medicare-articles/good-reasons-to-shop-for-a-new-medicare-plan                                          | Article page|
|UHC|medicare-articles/the-difference-between-medicare-hmo-and-ppo-plans                                     | Article page|
|UHC|medicare-articles/medicare-mistakes-that-could-be-costly                                                | Article page|
|UHC|medicare-articles/5-savvy-shopper-tips-help-get-medicare                                                | Article page|
|UHC|medicare-articles/which-vaccines-does-medicare-cover                                                    | Article page|
|UHC|medicare-articles/what-if-i-missed-my-initial-enrollment-period                                         | Article page|
|UHC|medicare-articles/4-basic-questions-to-ask-about-medicare-part-d-coverage                               | Article page|
|UHC|medicare-articles/turn-65-retire-sign-up-for-medicare-or-not                                            | Article page|
|UHC|medicare-articles/7-inside-tips-to-help-you-make-a-smooth-move-to-medicare                              | Article page|


  @BlogPages_Blog6_GlobalCompsAARP
     Examples: 
   |site |path                                                                                                | pageName   |
|AARP|medicare-articles/medicare-individuals-who-divorced-widowed                                             | Article page|
|AARP|medicare-articles/medicare-and-durable-medical-equipment-dme                                            | Article page|
|AARP|medicare-articles/3-simple-ways-to-change-medicare-plans                                                |Article page|
|AARP|medicare-articles/prescription-discount-cards-other-money-saving-medicare-tips                          |Article page|
|AARP|medicare-articles/does-medicare-coverage-change-if-you-return-to-work                                   |Article page|
|AARP|medicare-articles/medicare-enrollment-for-veterans                                                      |Article page|
|AARP|medicare-articles/retiring-in-2020-what-to-know-about-medicare                                          |Article page|
|AARP|medicare-articles/like-to-travel-it-may-affect-which-medicare-plan-you-choose                           |Article page|
|AARP|medicare-articles/how-do-tricare-and-medicare-work-together                                             |Article page|
|AARP|medicare-articles/youre-65-working-medicare                                                             |Article page|

 @BlogPages_Blog6_GlobalCompsUHC
     Examples: 
   |site |path                                                                                                | pageName   |
|UHC|medicare-articles/medicare-individuals-who-divorced-widowed                                             | Article page|
|UHC|medicare-articles/medicare-and-durable-medical-equipment-dme                                            | Article page|
|UHC|medicare-articles/3-simple-ways-to-change-medicare-plans                                                |Article page|
|UHC|medicare-articles/prescription-discount-cards-other-money-saving-medicare-tips                          |Article page|
|UHC|medicare-articles/does-medicare-coverage-change-if-you-return-to-work                                   |Article page|
|UHC|medicare-articles/medicare-enrollment-for-veterans                                                      |Article page|
|UHC|medicare-articles/retiring-in-2020-what-to-know-about-medicare                                          |Article page|
|UHC|medicare-articles/like-to-travel-it-may-affect-which-medicare-plan-you-choose                           |Article page|
|UHC|medicare-articles/how-do-tricare-and-medicare-work-together                                             |Article page|
|UHC|medicare-articles/youre-65-working-medicare                                                             |Article page|


  @BlogPages_Blog7_GlobalCompsAARP
     Examples: 
   |site |path                                                                                                | pageName   |
|AARP|medicare-articles/how-to-get-dental-and-vision-care-coverage-when-you-have-medicare                     |Article page|
|AARP|medicare-articles/pharmacists-answering-your-medicare-prescription-drug-questions                       |Article page|
|AARP|medicare-articles/why-you-and-your-spouse-might-need-different-medicare-plans                           |Article page|
|AARP|medicare-articles/born-in-1955-or-later-you-may-have-to-work-until-youre-67                             |Article page|
|AARP|medicare-articles/renew-medicare-plan-open-enrollment                                                   |Article page|
|AARP|medicare-articles/medicare-enrollment-checklist-helping-you-prepare-for-an-important-decision           |Article page|
|AARP|medicare-articles/should-you-change-your-medicare-plan                                                  |Article page|
|AARP|medicare-articles/what-happens-to-your-medicare-plan-if-you-move                                        |Article page|
|AARP|medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare                             |Article page|
|AARP|medicare-articles/what-is-the-medicare-special-enrollment-period                                        |Article page|


 @BlogPages_Blog7_GlobalCompsUHC
     Examples: 
|site|path                                                                                                   | pageName   |
|UHC|medicare-articles/how-to-get-dental-and-vision-care-coverage-when-you-have-medicare                     |Article page|
|UHC|medicare-articles/pharmacists-answering-your-medicare-prescription-drug-questions                       |Article page|
|UHC|medicare-articles/why-you-and-your-spouse-might-need-different-medicare-plans                           |Article page|
|UHC|medicare-articles/born-in-1955-or-later-you-may-have-to-work-until-youre-67                             |Article page|
|UHC|medicare-articles/renew-medicare-plan-open-enrollment                                                   |Article page|
|UHC|medicare-articles/medicare-enrollment-checklist-helping-you-prepare-for-an-important-decision           |Article page|
|UHC|medicare-articles/should-you-change-your-medicare-plan                                                  |Article page|
|UHC|medicare-articles/what-happens-to-your-medicare-plan-if-you-move                                        |Article page|
|UHC|medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare                             |Article page|
|UHC|medicare-articles/what-is-the-medicare-special-enrollment-period                                        |Article page|

@BlogPages_Blog8_GlobalCompsAARP
     Examples: 
   |site |path                                                                                                | pageName   |
|AARP|medicare-articles/wheres-my-original-medicare-card                                                      |Article page|
|AARP|medicare-articles/the-truth-your-medicare-part-b-premium                                                |Article page|
|AARP|medicare-articles/dos-and-donts-cancelling-a-marketplace-health-plan                                    |Article page|
|AARP|medicare-articles/outpatient-mental-health-care-services                                                |Article page|
|AARP|medicare-articles/medicare-increases-coverage-mental-health-care                                        |Article page|
|AARP|medicare-articles/how-to-transition-from-the-health-marketplace-to-medicare                             |Article page|
|AARP|medicare-articles/what-should-i-look-for-in-a-medicare-prescription-drug-plan                           |Article page|
|AARP|medicare-articles/saving-on-medicare-when-self-employed                                                 |Article page|
|AARP|medicare-articles/concrete-answers-10-common-medicare-questions                                         |Article page|
|AARP|medicare-articles/is-your-medicare-plan-the-best-one-for-you-this-checklist-can-help-you-decide         |Article page|


@BlogPages_Blog8_GlobalCompsUHC
     Examples: 
 |site |path                                                                                                | pageName   |
|UHC|medicare-articles/wheres-my-original-medicare-card                                                      |Article page|
|UHC|medicare-articles/the-truth-your-medicare-part-b-premium                                                |Article page|
|UHC|medicare-articles/dos-and-donts-cancelling-a-marketplace-health-plan                                    |Article page|
|UHC|medicare-articles/outpatient-mental-health-care-services                                                |Article page|
|UHC|medicare-articles/medicare-increases-coverage-mental-health-care                                        |Article page|
|UHC|medicare-articles/how-to-transition-from-the-health-marketplace-to-medicare                             |Article page|
|UHC|medicare-articles/what-should-i-look-for-in-a-medicare-prescription-drug-plan                           |Article page|
|UHC|medicare-articles/saving-on-medicare-when-self-employed                                                 |Article page|
|UHC|medicare-articles/concrete-answers-10-common-medicare-questions                                         |Article page|
|UHC|medicare-articles/is-your-medicare-plan-the-best-one-for-you-this-checklist-can-help-you-decide         |Article page|

@BlogPages_Blog9_GlobalCompsAARP
     Examples: 
|site|path                                                                                                    | pageName   |
|AARP|medicare-articles/what-telehealth-services-does-medicare-offer                                          |Article page|
|AARP|medicare-articles/7-popular-medicare-questions-asked-during-national-medicare-education-week            |Article page|
|AARP|medicare-articles/whats-the-difference-between-a-skilled-nursing-facility-and-a-nursing-home            |Article page|
|AARP|medicare-articles/what-s-the-difference-between-medicare-and-medicaid                                   |Article page|
|AARP|medicare-articles/how-to-appeal-a-medicare-decision                                                     |Article page|
|AARP|medicare-articles/how-avoid-paying-more-prescription-drug-coverage                                      |Article page|
|AARP|medicare-articles/3-ways-to-dispose-of-your-old-unused-medications-safely                               | Article page|
|AARP|medicare-articles/what-is-a-tiered-formulary-and-what-does-it-mean-for-me                               | Article page|
|AARP|medicare-articles/good-news-medicare-part-b-covers-cataract-surgery                                     | Article page|
|AARP|medicare-articles/heart-healthy-help-medicare                                                           | Article page|


@BlogPages_Blog9_GlobalCompsUHC
     Examples: 
|site|path                                                                                                    | pageName   |
|UHC|medicare-articles/what-telehealth-services-does-medicare-offer                                          |Article page|
|UHC|medicare-articles/7-popular-medicare-questions-asked-during-national-medicare-education-week            |Article page|
|UHC|medicare-articles/whats-the-difference-between-a-skilled-nursing-facility-and-a-nursing-home            |Article page|
|UHC|medicare-articles/what-s-the-difference-between-medicare-and-medicaid                                   |Article page|
|UHC|medicare-articles/how-to-appeal-a-medicare-decision                                                     |Article page|
|UHC|medicare-articles/how-avoid-paying-more-prescription-drug-coverage                                      |Article page|
|UHC|medicare-articles/3-ways-to-dispose-of-your-old-unused-medications-safely                               | Article page|
|UHC|medicare-articles/what-is-a-tiered-formulary-and-what-does-it-mean-for-me                               | Article page|
|UHC|medicare-articles/good-news-medicare-part-b-covers-cataract-surgery                                     | Article page|
|UHC|medicare-articles/heart-healthy-help-medicare                                                           | Article page|

@BlogPages_Blog10_GlobalCompsAARP
     Examples: 
 |site |path                                                                                                    | pageName   |
|AARP|medicare-articles/what-can-i-do-during-the-medicare-advantage-open-enrollment-period                      |Article page|
|AARP|medicare-articles/medicare-coverage-for-same-sex-couples                                                  |Article page|
|AARP|medicare-articles/how-to-evaluate-medicare-plan-costs                                                     |Article page|
|AARP|medicare-articles/6-point-checklist-to-rate-your-new-medicare-advantage-plan                              |Article page|
|AARP|medicare-articles/replacing-your-medicare-card-just-got-a-whole-lot-easier                                |Article page|
|AARP|medicare-articles/understanding-your-medicare-plan                                                        |Article page|
|AARP|medicare-articles/how-to-save-on-prescription-drugs-with-medicare                                         |Article page|
|AARP|medicare-articles/10-tips-choosing-primary-care-doctor                                                    |Article page|
|AARP|medicare-articles/avoid-sticker-shock-medicare-billing                                                    |Article page|
|AARP|medicare-articles/does-medicare-part-a-cost-anything                                                      |Article page|


@BlogPages_Blog10_GlobalCompsUHC
     Examples: 
 |site |path                                                                                                    | pageName   |
|UHC|medicare-articles/what-can-i-do-during-the-medicare-advantage-open-enrollment-period                      |Article page|
|UHC|medicare-articles/medicare-coverage-for-same-sex-couples                                                  |Article page|
|UHC|medicare-articles/how-to-evaluate-medicare-plan-costs                                                     |Article page|
|UHC|medicare-articles/6-point-checklist-to-rate-your-new-medicare-advantage-plan                              |Article page|
|UHC|medicare-articles/replacing-your-medicare-card-just-got-a-whole-lot-easier                                |Article page|
|UHC|medicare-articles/understanding-your-medicare-plan                                                        |Article page|
|UHC|medicare-articles/how-to-save-on-prescription-drugs-with-medicare                                         |Article page|
|UHC|medicare-articles/10-tips-choosing-primary-care-doctor                                                    |Article page|
|UHC|medicare-articles/avoid-sticker-shock-medicare-billing                                                    |Article page|
|UHC|medicare-articles/does-medicare-part-a-cost-anything                                                      |Article page|

@BlogPages_Blog11_GlobalCompsAARP
     Examples: 
 |site |path                                                                                                    | pageName   |
|AARP|medicare-articles/how-much-does-medicare-part-b-cost                                                      |Article page|
|AARP|medicare-articles/what-is-co-insurance                                                                    |Article page|
|AARP|medicare-articles/what-is-the-medicare-advantage-open-enrollment-period                                   |Article page|
|AARP|medicare-articles/whats-the-difference-between-a-physical-exam-and-a-medicare-wellness-visit              |Article page|
|AARP|medicare-articles/what-medicare-medical-savings-account-plan                                              |Article page|
|AARP|medicare-articles/copd-medicare                                                                           |Article page|
|AARP|medicare-articles/decoding-medicare                                                                       |Article page|
|AARP|medicare-articles/does-medicare-cover-a-colonoscopy                                                       |Article page|
|AARP|medicare-articles/does-medicare-cover-blood-tests-for-cholesterol                                         |Article page|
|AARP|medicare-articles/does-medicare-cover-diabetes-prevention-program                                         |Article page|


@BlogPages_Blog11_GlobalCompsUHC
     Examples: 
 |site |path                                                                                                    | pageName   |
|UHC|medicare-articles/how-much-does-medicare-part-b-cost                                                      |Article page|
|UHC|medicare-articles/what-is-co-insurance                                                                    |Article page|
|UHC|medicare-articles/what-is-the-medicare-advantage-open-enrollment-period                                   |Article page|
|UHC|medicare-articles/whats-the-difference-between-a-physical-exam-and-a-medicare-wellness-visit              |Article page|
|UHC|medicare-articles/what-medicare-medical-savings-account-plan                                              |Article page|
|UHC|medicare-articles/copd-medicare                                                                           |Article page|
|UHC|medicare-articles/decoding-medicare                                                                       |Article page|
|UHC|medicare-articles/does-medicare-cover-a-colonoscopy                                                       |Article page|
|UHC|medicare-articles/does-medicare-cover-blood-tests-for-cholesterol                                         |Article page|
|UHC|medicare-articles/does-medicare-cover-diabetes-prevention-program                                         |Article page|


@BlogPages_Blog12_GlobalCompsAARP
     Examples: 
 |site |path                                                                                                    | pageName   |
|AARP|medicare-articles/does-medicare-cover-emergency-room-visits                                               |Article page|
|AARP|medicare-articles/does-medicare-cover-home-blood-pressure-monitors                                        |Article page|
|AARP|medicare-articles/does-medicare-cover-melanoma-screenings                                                 |Article page|
|AARP|medicare-articles/home-health-care-those-medicare-who-cant-leave-home                                     |Article page|
|AARP|medicare-articles/how-often-should-a-woman-over-65-have-a-pap-smear                                       |Article page|
|AARP|medicare-articles/medicare-transportation-services                                                        |Article page|
|AARP|medicare-articles/are-you-living-with-chronic-heart-failure                                               |Article page|
|AARP|medicare-articles/how-prepare-your-medicare-wellness-visit                                                |Article page|
|AARP|medicare-articles/will-medicare-cover-a-cpap-machine                                                      |Article page|
|AARP|medicare-articles/new-to-medicare-schedule-your-welcome-to-medicare-visit                                 |Article page|


@BlogPages_Blog12_GlobalCompsUHC
     Examples: 
 |site |path                                                                                                    | pageName   |
|UHC|medicare-articles/does-medicare-cover-emergency-room-visits                                               |Article page|
|UHC|medicare-articles/does-medicare-cover-home-blood-pressure-monitors                                        |Article page|
|UHC|medicare-articles/does-medicare-cover-melanoma-screenings                                                 |Article page|
|UHC|medicare-articles/home-health-care-those-medicare-who-cant-leave-home                                     |Article page|
|UHC|medicare-articles/how-often-should-a-woman-over-65-have-a-pap-smear                                       |Article page|
|UHC|medicare-articles/medicare-transportation-services                                                        |Article page|
|UHC|medicare-articles/are-you-living-with-chronic-heart-failure                                               |Article page|
|UHC|medicare-articles/how-prepare-your-medicare-wellness-visit                                                |Article page|
|UHC|medicare-articles/will-medicare-cover-a-cpap-machine                                                      |Article page|
|UHC|medicare-articles/new-to-medicare-schedule-your-welcome-to-medicare-visit                                 |Article page|

@BlogPages_Blog13_GlobalCompsAARP
     Examples: 
|site|path                                                                                                      | pageName   |
|AARP|medicare-articles/how-to-become-a-medicare-authorized-representative                                      |Article page|
|AARP|medicare-articles/what-is-a-transition-refill                                                             |Article page|
|AARP|medicare-articles/got-coverage-for-the-new-year                                                           |Article page|
|AARP|medicare-articles/medicare-and-your-private-medical-information                                           |Article page|
|AARP|medicare-articles/medicare-memo-what-are-advance-directives                                               |Article page|
|AARP|medicare-articles/getting-a-knee-replaced-with-Medicare                                                   |Article page|
|AARP|medicare-articles/2-ways-save-on-blood-sugar-test-strips                                                  |Article page|
|AARP|medicare-articles/are-glaucoma-screenings-covered-by-medicare                                             |Article page|
|AARP|medicare-articles/colon-cancer-screening-tests-without-the-ouch                                           |Article page|
|AARP|medicare-articles/medicare-beneficiaries-needing-hospice-care-may-be-covered                              |Article page|



@BlogPages_Blog13_GlobalCompsUHC
     Examples: 
|site|path                                                                                                      | pageName   |
|UHC|medicare-articles/how-to-become-a-medicare-authorized-representative                                      |Article page|
|UHC|medicare-articles/what-is-a-transition-refill                                                             |Article page|
|UHC|medicare-articles/got-coverage-for-the-new-year                                                           |Article page|
|UHC|medicare-articles/medicare-and-your-private-medical-information                                           |Article page|
|UHC|medicare-articles/medicare-memo-what-are-advance-directives                                               |Article page|
|UHC|medicare-articles/getting-a-knee-replaced-with-Medicare                                                   |Article page|
|UHC|medicare-articles/2-ways-save-on-blood-sugar-test-strips                                                  |Article page|
|UHC|medicare-articles/are-glaucoma-screenings-covered-by-medicare                                             |Article page|
|UHC|medicare-articles/colon-cancer-screening-tests-without-the-ouch                                           |Article page|
|UHC|medicare-articles/medicare-beneficiaries-needing-hospice-care-may-be-covered                              |Article page|


@BlogPages_Blog14_GlobalCompsAARP
     Examples: 
|site|path                                                                                                    | pageName   |
|AARP|medicare-articles/medicare-coverage-for-inpatient-rehabilitation                                        |Article page|
|AARP|medicare-articles/medicare-coverage-for-outpatient-rehabilitation-therapy                               |Article page|
|AARP|medicare-articles/medicare-coverage-for-prostate-cancer-screening                                       |Article page|
|AARP|medicare-articles/medicare-part-benefit-periods-deductibles                                             |Article page|
|AARP|medicare-articles/reasons-you-should-schedule-an-annual-medicare-wellness-visit                         |Article page|
|AARP|medicare-articles/does-medicare-cover-allergy-testing                                                   |Article page|
|AARP|medicare-articles/medicare-part-b-may-not-cover-hearing-aid-part-c-might                                |Article page|
|AARP|medicare-articles/medicare-part-b-basics                                                                |Article page|
|AARP|medicare-articles/medicare-part-d-basics                                                                |Article page|
|AARP|medicare-articles/medicare-part-a-the-basics                                                            |Article page|


@BlogPages_Blog14_GlobalCompsUHC
     Examples: 
|site|path                                                                                                    | pageName   |
|UHC|medicare-articles/medicare-coverage-for-inpatient-rehabilitation                                        |Article page|
|UHC|medicare-articles/medicare-coverage-for-outpatient-rehabilitation-therapy                               |Article page|
|UHC|medicare-articles/medicare-coverage-for-prostate-cancer-screening                                       |Article page|
|UHC|medicare-articles/medicare-part-benefit-periods-deductibles                                             |Article page|
|UHC|medicare-articles/reasons-you-should-schedule-an-annual-medicare-wellness-visit                         |Article page|
|UHC|medicare-articles/does-medicare-cover-allergy-testing                                                   |Article page|
|UHC|medicare-articles/medicare-part-b-may-not-cover-hearing-aid-part-c-might                                |Article page|
|UHC|medicare-articles/medicare-part-b-basics                                                                |Article page|
|UHC|medicare-articles/medicare-part-d-basics                                                                |Article page|
|UHC|medicare-articles/medicare-part-a-the-basics                                                            |Article page|

@BlogPages_Blog15_GlobalCompsAARP
     Examples: 
|site|path                                                                                                    | pageName   |
|AARP|medicare-articles/medicare-part-c-basics                                                                |Article page|
|AARP|medicare-articles/does-medicare-cover-a-chiropractor                                                    |Article page|
|AARP|medicare-articles/what-does-medicare-cover-after-a-stroke                                               |Article page|
|AARP|medicare-articles/dual-special-needs-plans                                                              |Article page|
|AARP|medicare-articles/cual-es-la-diferencia-entre-medicare-y-medicaid                                       |Article page|
|AARP|medicare-articles/cuatro-programas-de-asistencia-para-pagar-sus-costos-de-medicare                      |Article page|
|AARP|medicare-articles/guia-paso-paso-para-inscribirse-en-medicare-los-65-anos                               |Article page|
|AARP|medicare-articles/medicare-parte-c-conceptos-basicos                                                    |Article page|
|AARP|medicare-articles/parte-a-de-medicare-conceptos-basicos                                                 |Article page|
|AARP|medicare-articles/parte-b-de-medicare-conceptos-basicos                                                 |Article page|

@BlogPages_Blog15_GlobalCompsUHC
     Examples: 
|site|path                                                                                                    | pageName   |
|UHC|medicare-articles/medicare-part-c-basics                                                                |Article page|
|UHC|medicare-articles/does-medicare-cover-a-chiropractor                                                    |Article page|
|UHC|medicare-articles/what-does-medicare-cover-after-a-stroke                                               |Article page|
|UHC|medicare-articles/dual-special-needs-plans                                                              |Article page|
|UHC|medicare-articles/cual-es-la-diferencia-entre-medicare-y-medicaid                                       |Article page|
|UHC|medicare-articles/cuatro-programas-de-asistencia-para-pagar-sus-costos-de-medicare                      |Article page|
|UHC|medicare-articles/guia-paso-paso-para-inscribirse-en-medicare-los-65-anos                               |Article page|
|UHC|medicare-articles/medicare-parte-c-conceptos-basicos                                                    |Article page|
|UHC|medicare-articles/parte-a-de-medicare-conceptos-basicos                                                 |Article page|
|UHC|medicare-articles/parte-b-de-medicare-conceptos-basicos                                                 |Article page|


@BlogPages_Blog16_GlobalCompsAARP
     Examples: 
|site|path                                                                                                    | pageName   |
|AARP|medicare-articles/parte-d-de-medicare-conceptos-basicos                                                 |Article page|
|AARP|medicare-articles/what-is-a-pdp-prescription-drug-plan                                                  |Article page|
|AARP|medicare-articles/4-assistance-programs-could-help-pay-your-medicare-costs                              |Article page|
|AARP|medicare-articles/4-types-of-medicare-savings-programs-and-what-they-cover                              |Article page|
|AARP|medicare-articles/what-is-the-medicare-part-d-coverage-gap                                              |Article page|
|AARP|medicare-articles/4surefire-tips-for-picking-a-medicare-plan-that-fits-your-health-needs-and-budget     |Article page|
|AARP|medicare-articles/medicare-part-d-costs-you-may-not-know-about                                          |Article page|
|AARP|medicare-articles/new-medicare-follow-checklist-successful-start                                        |Article page|
|AARP|medicare-articles/medicare-coverage-for-cancer-screenings-chemo-and-radiation                           |Article page|
|AARP|medicare-articles/how-to-compare-medicare-advantage-plan-costs                                          |Article page|



@BlogPages_Blog16_GlobalCompsUHC
     Examples: 
|site|path                                                                                                    | pageName   |
|UHC|medicare-articles/parte-d-de-medicare-conceptos-basicos                                                 |Article page|
|UHC|medicare-articles/what-is-a-pdp-prescription-drug-plan                                                  |Article page|
|UHC|medicare-articles/4-assistance-programs-could-help-pay-your-medicare-costs                              |Article page|
|UHC|medicare-articles/4-types-of-medicare-savings-programs-and-what-they-cover                              |Article page|
|UHC|medicare-articles/what-is-the-medicare-part-d-coverage-gap                                              |Article page|
|UHC|medicare-articles/4surefire-tips-for-picking-a-medicare-plan-that-fits-your-health-needs-and-budget     |Article page|
|UHC|medicare-articles/medicare-part-d-costs-you-may-not-know-about                                          |Article page|
|UHC|medicare-articles/new-medicare-follow-checklist-successful-start                                        |Article page|
|UHC|medicare-articles/medicare-coverage-for-cancer-screenings-chemo-and-radiation                           |Article page|
|UHC|medicare-articles/how-to-compare-medicare-advantage-plan-costs                                          |Article page|
      
