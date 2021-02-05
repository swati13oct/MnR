 Feature: 1.05.5. UAT Scripts Campaign External Links

  Scenario Outline: TID: <Scenario> -plan type: <plantype> - OLE End to end from external Links
 
  Given user is on campaign external Links page
    	|External Link| <externallink>|
		Then the user validate links and other options on aarp medicare plans11 external link page
				| TFN No | <TFNNo> |
        | TFN Xpath | <TFNxpath1> |
		Then the user validate aarp medicare plans11 page external link
       | Zip Code        | <zipcode>         | 	
	Then the user validates SAM icons on the page
	 			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
  	And the user views the plans of the below plan type
      | Plan Type | <MAplantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
   	Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
   	Then the user validates the right rail
    Then the user validates the Need Help Section in the right rail
    Then the user validates the TFN in the Need Help Section
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
   Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
    #And I select "<plantype>" plans to compare and click on compare plan link
    #----------------
    And the user clicks on compare plans button on plan details page and navigate to compare page
    Then verify plan compare page is loaded
    Then the user clicks on back on all plan link in Plan Compare page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    Then the user navigates to clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <MAplanName> |
    Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
     Then the user navigates to Personal Information Page
   	Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
		Then the user validates cancellation and Save Return Later modal for OLE Page
		Then the user navigate back to external link of aarp medicare plans11 page
	 #----------Repeat the steps for PDP Plan-----------------#
	 Then the user validate aarp medicare plans11 page external link
       | Zip Code        | <zipcode>         | 	
	Then the user validates SAM icons on the page
	 			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
  	And the user views the plans of the below plan type
      | Plan Type | <PDPplantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
   	Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
   	Then the user validates the right rail
    Then the user validates the Need Help Section in the right rail
    Then the user validates the TFN in the Need Help Section
    And the user views plan details of the above selected plan and validates
      | Plan Name | <PDPplanName> |
   Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
    #And I select "<plantype>" plans to compare and click on compare plan link
    #----------------
    And the user clicks on compare plans button on plan details page and navigate to compare page
    Then verify plan compare page is loaded
    Then the user clicks on back on all plan link in Plan Compare page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    Then the user navigates to clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <PDPplanName> |
    Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
     Then the user navigates to Personal Information Page
   	Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
		Then the user validates cancellation and Save Return Later modal for OLE Page
		Then the user navigate back to external link of aarp medicare plans11 page
   Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
    # #----------Repeat the steps for PDP Plan-----------------# 
     And the user clicks on compare plans button on plan details page and navigate to compare page
    Then verify plan compare page is loaded
    Then the user clicks on back on all plan link in Plan Compare page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    Then the user navigates to clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <SNPplanName> |
    Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
     Then the user navigates to Personal Information Page
   	Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
		Then the user validates cancellation and Save Return Later modal for OLE Page
		Then the user navigate back to external link of aarp medicare plans11 page
	 #----------Repeat the steps for SNP Plan-----------------#
	 Then the user validate aarp medicare plans11 page external link
       | Zip Code        | <zipcode>         | 	
	Then the user validates SAM icons on the page
	 			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
  	And the user views the plans of the below plan type
      | Plan Type | <SNPplantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
   	Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
   	Then the user validates the right rail
    Then the user validates the Need Help Section in the right rail
    Then the user validates the TFN in the Need Help Section
    And the user views plan details of the above selected plan and validates
      | Plan Name | <SNPplanName> |
   Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
    Then the user navigates to clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <SNPplanName> |
    Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
     Then the user navigates to Personal Information Page
   	Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
		Then the user validates cancellation and Save Return Later modal for OLE Page
		Then the user navigate back to external link of aarp medicare plans11 page|
	 #-------------------Repeat the steps for Medsupp Plan----------------------------------------------
	 Then the user validate aarp medicare plans11 page external link
       | Zip Code        | <zipcode>         | 	
	Then the user validates SAM icons on the page
	 			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
  	And the user views the plans of the below plan type
      | Plan Type | <MSplantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
   	Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
   	Then the user validates the right rail
    Then the user validates the Need Help Section in the right rail
    Then the user validates the TFN in the Need Help Section
   #---------------------Privacy link in Medicare plans 11 page--------------------
   Then the user navigate back to aarp medicare plans11 page privacy link
   Then the user validates SAM icons on the page
   			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
   
		@CampaignExternalLink_E2E_Scenario_6
    Examples: 
      | Scenario                               | site |PlanType   |externallink                                               |planyear|planYear|zipcode | isMultutiCounty | county            | MAplantype |planyear| MAplanName                                | cardtype |  TFNNo          |TFNxpath                                                                                    |TFNxpath1                                     |PDPplantype |SNPplantype |MSplantype |PDPplanName                     |SNPplanName                                         |
      | E2E Scenario 6_aarp-medicare-plans-11  | AARP |MAPD-MBI  | https://info.aarpmedicareplans.com/aarp-medicare-plans-11 |future  |future  |33111   | NO              | Miami-Dade County | MAPD        |future  |AARP Medicare Advantage Choice (PPO)       | MBI      | 1-855-264-3792 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')]  |//a[contains(@class,'js-tel js-track-event')] |PDP         |SNP         |MS         |AARP MedicareRx Walgreens (PDP) | UnitedHealthcare Dual Complete Choice (PPO D-SNP)  |
			
			
	Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links
			Given user is on campaign external Links page
    	|External Link| <externallink>|
    	Then user verify TFN on AARP external links page
    	| TFN No | <TFNNo> |
      | TFN Xpath | <TFNxpath1> |
      |	Working hrs | <workingHrs>|
    	When user clicks on Find Plans and Pricing to open a new tab
    	Then user should be navigated on Shop for a plan page
    	#Then verify SAM Icons
    	When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |

			
			@CampaignExternal_Scenario1_AARP
			Examples: 
      |Scenario                               |externallink|zipcode|isMultutiCounty|county|MAplantype|TFNNo						|	TFNxpath1																			|workingHrs|
      |Campaign External Links - E2E Scenario 1_AMP_English|https://ma.aarpmedicareplans.com/aarp-medicare-advantage|33111|No|Miami-Dade County|MAPD|1-855-264-3792	|	//a[contains(@class,'js-tel js-track-event')]	|Hours: 8 a.m. to 8 p.m., 7 days a week*|
      
  Scenario Outline: <Scenario>: Validate TFN and SAM Call popup in MA, Medsupp page, PRE, VPP Plan Summary from External link: <externallink>
  	Given user is on campaign external Links page
    	|External Link| <externallink>|
   	And the user validate links and other options on morganstanley external link page
   		| TFN No | <TFNNo> |
      | TFN Xpath | <TFNxpath1> |
    Then the user clicks on Learn About Medicare button on Morgan Stanley external link page
  	And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
  	#Then the user check Still have a question
  
  @Scenario5_AARP
  Examples: 
      | Scenario                   			|	externallink															|	TFNNo						|	TFNxpath1																			|	TFNxpath2	|
      | E2E Scenario 5_ morganstanley		|	https://www.myuhcplans.com/morganstanley	|	1-877-755-5345	|	//a[contains(@class,'js-tel js-track-event')]	|	//span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')]	|
