@GlobalComponentsAARP @F448210
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
 
 #@globalfooter_UHC
  #Examples: 
       #|	site	|
       #|	UHC	|      
       
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
       
  #@globalheader_UHC
  #Examples: 
       #|	site	|
       #|	UHC	| 

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
      |	AARP	| medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Options | AARP Medicare Plans    | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		 | true    |
      |	AARP	| medicare-education/medicare-benefits.html                | Prescriptions, Providers & Benefits | AARP Medicare Plans			| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		 | true    |

#		@MedEdPages_1_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                                     | pageName                                   											| tfnXpath                                      														| tfnFlag |
      #|	UHC		| medicare-education.html                                  | Understanding Medicare | UnitedHealthcare  											| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]			| true    |
      #|	UHC		| medicare-education/medicare-eligibility.html             | Medicare Eligibility | UnitedHealthcare    											| //*[@class='ums']//a[contains(@class, 'tel')] 														| true    |
      #|	UHC		| medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Choices | UnitedHealthcare					| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		 	| true    |
      #|	UHC		| medicare-education/medicare-benefits.html                | Medicare Prescriptions, Providers & Benefits | UnitedHealthcare 	| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 			| true    |
	
    @MedEdPages_2_GlobalCompsAARP
    Examples: 
      |	site	| path                                              | pageName              																					| tfnXpath                                      													| tfnFlag |
      |	AARP	| medicare-education/medicare-advantage-plans.html  | Learn about Medicare Advantage Plans | AARP Medicare Plans      | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true    |
      |	AARP	| medicare-education/medicare-supplement-plans.html | Learn about Medicare Supplement Plans | AARP Medicare Plans 		| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true   	|
      |	AARP	| medicare-education/medicare-part-d.html           | Medicare Prescription Drug Plans | AARP Medicare Plans      		| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true    |

    #@MedEdPages_2_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                              | pageName              																			| tfnXpath                                      													| tfnFlag |
      #|	UHC		| medicare-education/medicare-advantage-plans.html  | Medicare Advantage (Part C) Plans | UnitedHealthcare       	| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true    |
      #|	UHC		| medicare-education/medicare-supplement-plans.html | Medicare Supplement Insurance Plans | UnitedHealthcare 			| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		| true    |
      #|	UHC		| medicare-education/medicare-part-d.html           | Medicare Prescription Drug Plans | UnitedHealthcare		      | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		| true    |
    
    @MedEdPages_3_GlobalCompsAARP
    Examples: 
      |	site	| path                                                  | pageName                    													| tfnXpath                                      													| tfnFlag |
      |	AARP	| medicare-education/medicare-costs.html                | Medicare Cost Basics | AARP Medicare Plans 						| //span[contains(@style,'inline')]//a[contains(@class, 'tel')] 					| true    |
      |	AARP	| medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics | AARP Medicare Plans      | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		| true    |
      |	AARP	| medicare-education/medicare-faq.html                  | Medicare FAQ | AARP Medicare Plans	                  | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true    |
      
    #@MedEdPages_3_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                                  | pageName                    											| tfnXpath                                      													| tfnFlag |
      #|	UHC		| medicare-education/medicare-costs.html                | Medicare Cost Basics | UnitedHealthcare						| //span[contains(@style,'inline')]//a[contains(@class, 'tel')] 					| true    |
      #|	UHC		| medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics | UnitedHealthcare    	| //div[contains(@style,'display: block')]//a[contains(@class, 'tel')]		| true    |
      #|	UHC		| medicare-education/medicare-faq.html                  | Medicare FAQ | UnitedHealthcare	                  | //div[contains(@style,'display: block')]//a[contains(@class, 'tel')] 		| true    |  

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
   
   #@ShopPlan_Shop1_GlobalCompsUHC
    #Examples: 
      #|	site	| path                            | pageName                    | tfnXpath                                                       														| tfnFlag |
      #|	UHC		| shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] 											| true  	|
      #|	UHC		| shop.html                       | ShopPlan: Shop              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] 											| true   	| 
  #	  |	UHC		| shop/connect                    | ShopPlan: Request more Info | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| true    |
      #|	UHC		| shop/compare.html               | ShopPlan: Compare           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| false   |
      #|	UHC		| shop/estimate.html              | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| false   |
      #|	UHC		| shop/switch.html                | ShopPlan: Switch            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] 														| false   |
      #|	UHC		| shop/compare/compare-ms.html    | ShopPlan: Compare           | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true  	|
      #|	UHC		| shop/estimate/ms-costs.html     | ShopPlan: Estimate          | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')]	| true	  | 
      #|	UHC		| shop/compare/compare-ma-ms.html | ShopPlan: Compare           | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')]		| true	  | 
      #|	UHC		| safe-shopping.html              | ShopPlan: Shop              | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')]		| true   |
  
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
			
#	@ShopPlan_Shop2_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                             | pageName                     | tfnXpath                                                      						 | tfnFlag |
      #|	UHC		| shop/medicare-advantage-plans.html               | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1]				 | true    |
      #|	UHC		| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[2]				 | true    |
      #|	UHC		| shop/medicare-supplement-plans.html              | ShopPlan: Shop Med Supp Plan | (//*[contains(text(),'Find a Plan')]//following::a[2])										 | true    |
      #|	UHC		| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] 			 | true    |
      #|	UHC		| shop/prescription-drug-plans.html                | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] 	 		 | true    |
      #|	UHC		| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] 		 	 | true    |
#			|	UHC		| shop/dual-special-needs-plans.html               | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] 			 | true    |		


    @ShopPlan_Shop3_GlobalCompsAARP
    Examples: 
      |	site	| path                                       | pageName                    | tfnXpath                                                       | tfnFlag |
      |	AARP	| shop/compare/compare-pdp.html              | ShopPlan: Compare PDP Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| shop/compare/compare-ma.html               | ShopPlan: Compare MA  Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| shop/estimate/ma-costs.html                | ShopPlan: Estimate MA Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| shop/estimate/pdp-costs.html               | ShopPlan: Estimate PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #
    #@ShopPlan_Shop3_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                       | pageName                    | tfnXpath                                                       | tfnFlag |
      #|	UHC		| shop/compare/compare-pdp.html              | ShopPlan: Compare PDP Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| shop/compare/compare-ma.html               | ShopPlan: Compare MA  Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| shop/estimate/ma-costs.html                | ShopPlan: Estimate MA Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| shop/estimate/pdp-costs.html               | ShopPlan: Estimate PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  

    @ShopPlan_Shop4_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                   | pageName                        | tfnXpath                                                       | tfnFlag |
      |	AARP	| shop/medicare-advantage-plans/wellness-discounts.html                  | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| shop/medicare-advantage-plans/health-care-management.html              | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| shop/renew-active.html                                                 | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      
    #@ShopPlan_Shop4_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                                                   | pageName                        | tfnXpath                                                       | tfnFlag |
      #|	UHC		| shop/medicare-advantage-plans/wellness-discounts.html                  | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| shop/medicare-advantage-plans/health-care-management.html              | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| shop/renew-active.html                                                 | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  

    @ShopPlan_Enroll1_GlobalCompsAARP
    Examples: 
     |	site	| path                                    | pageName                   | tfnXpath                                                       | tfnFlag |
     |	AARP	| enroll.html                             | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
     |	AARP	| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
     |	AARP	| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
     |	AARP	| enroll/ms-apply.html                    | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
     
    #@ShopPlan_Enroll1_GlobalCompsUHC
    #Examples: 
     #|	site	| path                                    | pageName                   | tfnXpath                                                       | tfnFlag |
     #|	UHC		| enroll.html                             | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
     #|	UHC		| enroll/ma-enrollment.html               | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
     #|	UHC		| enroll/pdp-enrollment.html              | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
     #|	UHC		| enroll/ms-apply.html                    | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
   
    @ShopPlan_Resources1_GlobalCompsAARP
    Examples: 
      |	site	| path                                                              | pageName                             | tfnXpath                                                       | tfnFlag |
      |	AARP	| resources.html                                                    | ShopPlan: Resources                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| resources/medication-therapy-management-program.html              | ShopPlan: Resources Therapy          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/how-to-appoint-a-representative.html                    | ShopPlan: Resources Appoint Rep      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/prescription-drug-costs-help.html                       | ShopPlan: Resources Rx cost Help     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/healthcare-fraud.html                                   | ShopPlan: Resources Healthcare Fraud | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/how-to-pay-your-premium.html                            | ShopPlan: Resources Pay Premium      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      
    #@ShopPlan_Resources1_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                                              | pageName                             | tfnXpath                                                       | tfnFlag |
      #|	UHC		| resources.html                                                    | ShopPlan: Resources                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      #|	UHC		| resources/medication-therapy-management-program.html              | ShopPlan: Resources Therapy          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| resources/how-to-appoint-a-representative.html                    | ShopPlan: Resources Appoint Rep      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| resources/prescription-drug-costs-help.html                       | ShopPlan: Resources Rx cost Help     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| resources/healthcare-fraud.html                                   | ShopPlan: Resources Healthcare Fraud | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| resources/how-to-pay-your-premium.html                            | ShopPlan: Resources Pay Premium      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |   

    @ShopPlan_Resources2_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                                           | pageName                                         | tfnXpath                                                       | tfnFlag |
      |	AARP	| resources/pdp-resources-materials.html                                                         | ShopPlan: Resources PDP Plans                    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| resources/pdp-resources-materials/pdp-information-forms.html                                   | ShopPlan: Resources PDP Plans Info               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html              | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    | true    |
      |	AARP	| resources/mail-order-pharmacy.html                                                             | ShopPlan: Resources Mail Order Pharmacy          | (//*[contains(@class,'tel')])[2]                               | false   |
      |	AARP	| resources/prescription-drug-appeals.html                                                       | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    | true    |
      |	AARP	| resources/prescription-drug-transition.html                                                    | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    | true    |

    #@ShopPlan_Resources2_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                                                                           | pageName                                         | tfnXpath                                                       | tfnFlag |
      #|	UHC		| resources/pdp-resources-materials.html                                                         | ShopPlan: Resources PDP Plans                    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      #|	UHC		| resources/pdp-resources-materials/pdp-information-forms.html                                   | ShopPlan: Resources PDP Plans Info               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false    |
      #|	UHC		| resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html              | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    | true    |
      #|	UHC		| resources/mail-order-pharmacy.html                                                             | ShopPlan: Resources Mail Order Pharmacy          | (//*[contains(@class,'tel')])[2]                               | false   |
      #|	UHC		| resources/prescription-drug-appeals.html                                                       | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    | true    |
      #|	UHC		| resources/prescription-drug-transition.html                                                    | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    | true    |
    #
    @ShopPlan_Resources3_GlobalCompsAARP
    Examples: 
      |	site	| path                                                                                             | pageName                              | tfnXpath                                                       | tfnFlag |
      |	AARP	| resources/ma-resources-materials.html                                                            | ShopPlan: Resources MA Plans          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| resources/ma-resources-materials/ma-information-forms.html                                       | ShopPlan: Resources MA Plans Info     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| resources/ma-resources-materials/ma-information-forms/member-rights.html                         | ShopPlan: Resources MA Member Rights  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/ma-resources-materials/ma-information-forms/medicare-appeal.html                       | ShopPlan: Resources MA Appeals        | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/disenrollment-information.html																					               | ShopPlan: Resources PDP Disenrollment | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      |	AARP	| resources/disenrollment-information.html                                                         | ShopPlan: Resources Disenrollment Page| //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
   
    #@ShopPlan_Resources3_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                                                                             | pageName                              | tfnXpath                                                       | tfnFlag |
      #|	UHC		| resources/ma-resources-materials.html                                                            | ShopPlan: Resources MA Plans          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      #|	UHC		| resources/ma-resources-materials/ma-information-forms.html                                       | ShopPlan: Resources MA Plans Info     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      #|	UHC		| resources/ma-resources-materials/ma-information-forms/member-rights.html                         | ShopPlan: Resources MA Member Rights  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| resources/ma-resources-materials/ma-information-forms/medicare-appeal.html                       | ShopPlan: Resources MA Appeals        | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| resources/disenrollment-information.html																						             | ShopPlan: Resources PDP Disenrollment | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
      #|	UHC		| resources/disenrollment-information.html                                                         | ShopPlan: Resources Disenrollment Page| //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |
   
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
		
#		@VPP_Deeplinks_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                                                                                                                                                                                                                                                                                                          | pageName               | tfnXpath                                                    | tfnFlag |
      #|	UHC		| health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | //a[contains(@class, 'tel')]                                | true    |
      #|	UHC		| health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | //a[contains(@class, 'tel')]                                | true    |
      #|	UHC		| health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  | //a[contains(@class, 'tel')]                                | true    |
      #|	UHC		| health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   | //a[contains(@class, 'tel')]                                | true    |
      #|	UHC		| health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      | //a[contains(@class, 'tel')]                                | false   |
      #|	UHC		| health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | Connector Modal        | //a[contains(@href ,'tel') and contains(@class,'tel')] | true    |
#				
    @MiscellaneousLinks_GlobalCompsAARP
    Examples: 
      |	site	| path                                                       		| pageName                | tfnXpath                                                       | tfnFlag |
      |	AARP	| health-plans/estimate-drug-costs.html!/drug-cost-estimator    | Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |
      |	AARP	| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   		| Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |
      |	AARP	| medicare-plans.html                                        		| ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      |	AARP	| profile/guest                                              		| Visitor Profile: Guest  | //*[contains(@class,'tel')]                                              | true    |
		
#		@MiscellaneousLinks_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                                          | pageName                | tfnXpath                                                       | tfnFlag |
      #|	UHC		| health-plans/estimate-drug-costs.html!/drug-cost-estimator		| Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |
      #|	UHC		| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English      | Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |
      #|	UHC		| medicare-plans.html                                           | ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |
      #|	UHC		| profile/guest                                                 | Visitor Profile: Guest  | //*[contains(@class,'tel')]                                              | true    |
		
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

  #@GlobalComponentsAARP_ISonlyPages
  #Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    #Given the user is on medicare acquisition site landing page
  #		| Site | <site>	|
    #Given the user navigates to following medicare acquisition site page
      #| PageName | <pageName> |
      #| PagePath | <path>     |
    #When user accesses global header of the Medicare Plans home page
    #When user accesses global footer of the Medicare Plans All page
    #Then the User validates Shop for a Plan Navigation link
    #Then the user validates Medicare Education Navigation link
    #Then the user validate ZipCode Components on the page using ZipCode "90210"
    #Then the user validates TFN on the page
      #| TFNxpath | <tfnXpath> |
      #| TFNflag  | <tfnFlag>  |
    #Then the user validates whether call icon is visible
#
    #@MedSuppOnlyPages_GlobalCompsAARP
    #Examples: 
      #|	site	| path                                                                      | pageName          | tfnXpath       | tfnFlag |
      #|	AARP	| medicare-supplement-plans/medicare-information.html?vpp=true              | Decision Guide    | //*[@id='tfn'] | true    |
      #|	AARP	|	medicare-supplement-plans/agent-appointment.html                          | Agent Appointment | //*[@id='tfn'] | true    |
      #
    #@MedSuppOnlyPages_GlobalCompsUHC
    #Examples: 
      #|	site	| path                                                                      | pageName          | tfnXpath       | tfnFlag |
      #|	UHC	| medicare-supplement-plans/medicare-information.html?vpp=true              | Decision Guide    | //*[@id='tfn'] | true    |
      #|	UHC	|	medicare-supplement-plans/agent-appointment.html                          | Agent Appointment | //*[@id='tfn'] | true    |  
      
      
      #@GlobalComponentsAARPNewShopPages
  #Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    #Given the user is on AARP medicare acquisition site landing page
    #Given the user navigates to following AARP medicare acquisition site page
      #| PageName | <pageName> |
      #| PagePath | <path>     |
    #Then the user validate ZipCode Components on page using ZipCode "90210"
    #Then the user validates TFN on page
     #| TFNxpath | <tfnXpath> |
      #| TFNflag  | <tfnFlag>  |
      #
#		 @GlobalComponentsAARPNewShopPages1
    #Examples: 
      #| path                          | pageName                   | tfnXpath                     | tfnFlag |
      #| shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true   |
     #
     
    @GlobalComponentsAARP_NewShopPages  @NewpagesSepAARP
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on AARP medicare acquisition site landing page
    Given the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55410"
    
    
     @GlobalComponentsAARP_NewShopPages  @NewpagesSepAARP
     Examples: 
      | path                                                                      | pageName      | 
      | contact-us.html                                                           | Contact us    |
      | shop/estimate/ma-costs.html                                               | Estimate  MA  | 
      | shop/estimate/pdp-costs.html                                              | Estimate PDP  |
      | shop/switch.html                                                          | Switch        |
      | shop/renew-active.html                                                    | Renew Active  |
      | shop/medicare-advantage-plans/ma-plan-benefits.html                       | MA Plan benefits|
      | shop/compare/compare-ma.html                                              | Compare MA    |
      | shop/compare/compare-pdp.html                                             | Compare PDP   |
      | shop/medicare-advantage-veteran-plan.html                                 | MA Veteran Plan|
      | enroll/ma-enrollment.html                                                 | MA Enrollment |
      | enroll/pdp-enrollment.html                                                | PDP Enrollment|
      |medicare-articles/eligibility-and-enrollment.html                          | Sample Category Page   |
            
    
   @GlobalComponentsAARP_BlogPages    @NewpagesSepAARP
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on AARP medicare acquisition site landing page
    Given the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user enters and validate the fields and clicks on submit 
    Then the user validate ZipCode Components on page using ZipCode "55410"
    
    
   @GlobalComponentsAARP_BlogPages   @NewpagesSepAARP
     Examples: 
      |path                                                                                          | pageName               |
      |medicare-articles.html                                                                        | Medicare Articles Home |
      |medicare-articles/medicare-made-clear.html                                                    | About MMC              |
      |medicare-articles/what-is-retiree-health-coverage.html                                        | Sample Article Page 2  |
      |medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html       | Sample Article Page 1  |
      |medicare-articles/medicare-benefits-and-coverage.html                                                   |Category page|
      |medicare-articles/medicare-costs.html                                                                   |Category page|
      |medicare-articles/shopping-for-medicare.html                                                            |Category page|
      |medicare-articles/medicare-when-working-past-65.html                                                    |Category page|
      |medicare-articles/medicare-tips-and-faqs.html                                                           |Category page|
      |medicare-articles/how-to-avoid-the-medicare-part-b-late-penalty                                         |Category page|
      |medicare-articles/9-good-reasons-why-a-medicare-advantage-plan-might-be-right-for-you                    |Article page|
      |medicare-articles/caregiver-corner-helping-your-loved-one-prepare-for-the-medicare-annual-enrollment-period |Article page|
      |medicare-articles/your-5-point-checklist-choosing-medicare-part-d-plan  |Article page|
      |medicare-articles/6-tips-to-protect-yourself-from-medicare-fraud
      |medicare-articles/what-will-medicare-cost-in-2020
|medicare-articles/medicare-plan-annual-notice-of-change-what-to-look-for
|medicare-articles/need-eyeglasses-or-eye-care-coverage-check-your-medicare-options
|medicare-articles/medicare-doesnt-cover-everything-what-you-need-know
|medicare-articles/6-timely-medicare-tips-for-turning-65
|medicare-articles/should-i-get-part-b-if-im-working-past-65
|medicare-articles/try-to-avoid-medicare-late-enrollment-premium-penalties
|medicare-articles/what-is-the-difference-between-original-medicare-and-medicare-advantage
|medicare-articles/do-i-need-medicare-with-spouses-employer-plan
|medicare-articles/5-ways-to-pay-your-medicare-part-b-premium
|medicare-articles/5-medicare-myths-set-straight
|medicare-articles/when-can-you-start-getting-medicare
|medicare-articles/is-medicare-mandatory
|medicare-articles/can-i-change-my-medicare-plan
|medicare-articles/medicare-coverage-for-non-working-spouses
|medicare-articles/5-tips-for-enrolling-in-medicare-for-the-first-time
|medicare-articles/decide-change-plan
|medicare-articles/medicare-coverage-for-mammograms
|medicare-articles/have-diabetes-medicare-parts-b-and-d-have-you-covered
|medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period
|medicare-articles/what-does-original-medicare-include
|medicare-articles/what-is-creditable-drug-coverage
medicare-articles/safe-medicare-enrollment-during-COVID
medicare-articles/what-is-the-medicare-annual-enrollment-period
medicare-articles/aep-change-or-renew
medicare-articles/can-you-switch-between-original-medicare-and-medicare-advantage-during-the-annual-enrollment-period
medicare-articles/2-ways-to-prescription-drug-coverage
medicare-articles/good-reasons-to-shop-for-a-new-medicare-plan
medicare-articles/the-difference-between-medicare-hmo-and-ppo-plans
medicare-articles/medicare-mistakes-that-could-be-costly
medicare-articles/5-savvy-shopper-tips-help-get-medicare
medicare-articles/which-vaccines-does-medicare-cover
medicare-articles/what-if-i-missed-my-initial-enrollment-period
medicare-articles/4-basic-questions-to-ask-about-medicare-part-d-coverage
medicare-articles/turn-65-retire-sign-up-for-medicare-or-not
medicare-articles/7-inside-tips-to-help-you-make-a-smooth-move-to-medicare
medicare-articles/medicare-individuals-who-divorced-widowed
medicare-articles/medicare-and-durable-medical-equipment-dme
medicare-articles/3-simple-ways-to-change-medicare-plans
medicare-articles/prescription-discount-cards-other-money-saving-medicare-tips
medicare-articles/does-medicare-coverage-change-if-you-return-to-work
medicare-articles/medicare-enrollment-for-veterans
medicare-articles/retiring-in-2020-what-to-know-about-medicare
medicare-articles/like-to-travel-it-may-affect-which-medicare-plan-you-choose
medicare-articles/how-do-tricare-and-medicare-work-together
medicare-articles/youre-65-working-medicare
medicare-articles/how-to-get-dental-and-vision-care-coverage-when-you-have-medicare
medicare-articles/pharmacists-answering-your-medicare-prescription-drug-questions
medicare-articles/why-you-and-your-spouse-might-need-different-medicare-plans
medicare-articles/born-in-1955-or-later-you-may-have-to-work-until-youre-67
medicare-articles/renew-medicare-plan-open-enrollment
medicare-articles/medicare-enrollment-checklist-helping-you-prepare-for-an-important-decision
medicare-articles/should-you-change-your-medicare-plan
medicare-articles/what-happens-to-your-medicare-plan-if-you-move
medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare
medicare-articles/what-is-the-medicare-special-enrollment-period
medicare-articles/wheres-my-original-medicare-card
medicare-articles/the-truth-your-medicare-part-b-premium
medicare-articles/dos-and-donts-cancelling-a-marketplace-health-plan
medicare-articles/outpatient-mental-health-care-services
medicare-articles/medicare-increases-coverage-mental-health-care
medicare-articles/how-to-transition-from-the-health-marketplace-to-medicare
medicare-articles/what-should-i-look-for-in-a-medicare-prescription-drug-plan
medicare-articles/saving-on-medicare-when-self-employed
medicare-articles/concrete-answers-10-common-medicare-questions
medicare-articles/is-your-medicare-plan-the-best-one-for-you-this-checklist-can-help-you-decide
medicare-articles/what-telehealth-services-does-medicare-offer
medicare-articles/7-popular-medicare-questions-asked-during-national-medicare-education-week
medicare-articles/whats-the-difference-between-a-skilled-nursing-facility-and-a-nursing-home
medicare-articles/what-s-the-difference-between-medicare-and-medicaid
medicare-articles/how-to-appeal-a-medicare-decision
medicare-articles/how-avoid-paying-more-prescription-drug-coverage
medicare-articles/3-ways-to-dispose-of-your-old-unused-medications-safely
medicare-articles/what-is-a-tiered-formulary-and-what-does-it-mean-for-me
medicare-articles/good-news-medicare-part-b-covers-cataract-surgery
medicare-articles/heart-healthy-help-medicare
medicare-articles/what-can-i-do-during-the-medicare-advantage-open-enrollment-period
medicare-articles/medicare-coverage-for-same-sex-couples
medicare-articles/how-to-evaluate-medicare-plan-costs
medicare-articles/6-point-checklist-to-rate-your-new-medicare-advantage-plan
medicare-articles/replacing-your-medicare-card-just-got-a-whole-lot-easier
medicare-articles/understanding-your-medicare-plan
medicare-articles/how-to-save-on-prescription-drugs-with-medicare
medicare-articles/10-tips-choosing-primary-care-doctor
medicare-articles/avoid-sticker-shock-medicare-billing
medicare-articles/does-medicare-part-a-cost-anything
medicare-articles/how-much-does-medicare-part-b-cost
medicare-articles/what-is-co-insurance
medicare-articles/what-is-the-medicare-advantage-open-enrollment-period
medicare-articles/whats-the-difference-between-a-physical-exam-and-a-medicare-wellness-visit
medicare-articles/what-medicare-medical-savings-account-plan
medicare-articles/copd-medicare
medicare-articles/decoding-medicare
medicare-articles/does-medicare-cover-a-colonoscopy
medicare-articles/does-medicare-cover-blood-tests-for-cholesterol
medicare-articles/does-medicare-cover-diabetes-prevention-program
medicare-articles/does-medicare-cover-emergency-room-visits
medicare-articles/does-medicare-cover-home-blood-pressure-monitors
medicare-articles/does-medicare-cover-melanoma-screenings
medicare-articles/home-health-care-those-medicare-who-cant-leave-home
medicare-articles/how-often-should-a-woman-over-65-have-a-pap-smear
medicare-articles/medicare-transportation-services
medicare-articles/are-you-living-with-chronic-heart-failure
medicare-articles/how-prepare-your-medicare-wellness-visit
medicare-articles/will-medicare-cover-a-cpap-machine
medicare-articles/new-to-medicare-schedule-your-welcome-to-medicare-visit
medicare-articles/how-to-become-a-medicare-authorized-representative
medicare-articles/what-is-a-transition-refill
medicare-articles/got-coverage-for-the-new-year
medicare-articles/medicare-and-your-private-medical-information
medicare-articles/medicare-memo-what-are-advance-directives
medicare-articles/getting-a-knee-replaced-with-Medicare
medicare-articles/2-ways-save-on-blood-sugar-test-strips
medicare-articles/are-glaucoma-screenings-covered-by-medicare
medicare-articles/colon-cancer-screening-tests-without-the-ouch
medicare-articles/medicare-beneficiaries-needing-hospice-care-may-be-covered
medicare-articles/medicare-coverage-for-inpatient-rehabilitation
medicare-articles/medicare-coverage-for-outpatient-rehabilitation-therapy
medicare-articles/medicare-coverage-for-prostate-cancer-screening
medicare-articles/medicare-part-benefit-periods-deductibles
medicare-articles/reasons-you-should-schedule-an-annual-medicare-wellness-visit
medicare-articles/does-medicare-cover-allergy-testing
medicare-articles/medicare-part-b-may-not-cover-hearing-aid-part-c-might
medicare-articles/medicare-part-b-basics
medicare-articles/medicare-part-d-basics
medicare-articles/medicare-part-a-the-basics
medicare-articles/medicare-part-c-basics
medicare-articles/does-medicare-cover-a-chiropractor
medicare-articles/what-does-medicare-cover-after-a-stroke
medicare-articles/dual-special-needs-plans
medicare-articles/cual-es-la-diferencia-entre-medicare-y-medicaid
medicare-articles/cuatro-programas-de-asistencia-para-pagar-sus-costos-de-medicare
medicare-articles/guia-paso-paso-para-inscribirse-en-medicare-los-65-anos
medicare-articles/medicare-parte-c-conceptos-basicos
medicare-articles/parte-a-de-medicare-conceptos-basicos
medicare-articles/parte-b-de-medicare-conceptos-basicos
medicare-articles/parte-d-de-medicare-conceptos-basicos
medicare-articles/what-is-a-pdp-prescription-drug-plan
medicare-articles/4-assistance-programs-could-help-pay-your-medicare-costs
medicare-articles/4-types-of-medicare-savings-programs-and-what-they-cover
medicare-articles/what-is-the-medicare-part-d-coverage-gap
medicare-articles/4surefire-tips-for-picking-a-medicare-plan-that-fits-your-health-needs-and-budget
medicare-articles/medicare-part-d-costs-you-may-not-know-about
medicare-articles/new-medicare-follow-checklist-successful-start
medicare-articles/medicare-coverage-for-cancer-screenings-chemo-and-radiation
medicare-articles/how-to-compare-medicare-advantage-plan-costs
      
   
        
	
     
     
