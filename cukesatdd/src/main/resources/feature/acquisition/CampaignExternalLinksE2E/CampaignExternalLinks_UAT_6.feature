Feature: 1.05.5. UAT Scripts Campaign External Links scenario 6 related to  medicare-plans-11 

  Scenario Outline: TID: <Scenario> -plan type: <plantype> - OLE End to end from external Links
    Given user is on campaign external Links page
      | External Link | <externallink> |
    Then the user validate links and other options on aarp medicare plans11 external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    Then the user validate aarp medicare plans11 page external link
      | Zip Code | <zipcode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Zipcode component
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    And the user views the plans of the below plan type
      | Plan Type | <MAplantype> |
    # And the user selects plan year
    #	|Plan Year	| <planyear>|
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <MAplanName> |
      | Plan Type | <MAplantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
      Then the user validates TFN Number on Right Rail Plan Details page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     #Then the user validates TFN Number on Right Rail
      #| TFN No    | <TFNNo>     |
      #| TFN Xpath | <TFNxpath3> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    #Then the user validates cancellation and Save Return Later modal for OLE Page
    #Then the user cancels enrollment and navigates to homepage
    Then user closes current tab and navigate to previous tab
    #----------Repeat the steps for PDP Plan-----------------#
    Then the user validate aarp medicare plans11 page external link
      | Zip Code | <zipcode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     Then the user validates TFN Number on Zipcode component
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user views the plans of the below plan type
      | Plan Type | <PDPplantype> |
    # And the user selects plan year
    #	|Plan Year	| <planyear>|
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <PDPplanName> |
      | Plan Type | <PDPplantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
      Then the user validates TFN Number on Right Rail Plan Details page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
      # Then the user validates TFN Number on Right Rail
    #  | TFN No    | <TFNNo>     |
    #  | TFN Xpath | <TFNxpath3> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
      Then the user validates TFN Number on Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    Then user closes current tab and navigate to previous tab
    #----------Repeat the steps for SNP Plan-----------------#
    Then the user validate aarp medicare plans11 page external link
      | Zip Code | <zipcode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     Then the user validates TFN Number on Zipcode component
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user views the plans of the below plan type
      | Plan Type | <SNPplantype> |
    # And the user selects plan year
    #	|Plan Year	| <planyear>|
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <SNPplanName> |
      | Plan Type | <SNPplantype> |
    Then the user validates TFN Number on Right Rail Plan Details page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to clicks on Enroll Now from Plan details page to start the OLE flow
      | Plan Type | <SNPplantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on SNP Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |  
      Then the user validates TFN Number on SNP Right Rail OLE page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath4> |   
    # Then the user validates cancellation and Save Return Later modal for OLE Page
    Then user closes current tab and navigate to previous tab
    #-------------------Repeat the steps for Medsupp Plan----------------------------------------------
    Then the user validate aarp medicare plans11 page external link
      | Zip Code | <zipcode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     Then the user validates TFN Number on Zipcode component
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user views the plans of the below plan type
      | Plan Type | <MSplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user validates SAM icons on Medsupp page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail for Medsupp page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |
    Then user closes current tab and navigate to previous tab
    #---------------------Privacy link in Medicare plans 11 page--------------------
    Then the user navigate back to aarp medicare plans11 page privacy link
    Then the user validates SAM icons on privacy page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then user closes current tab and navigate to previous tab
		
    @CampaignExternalLink_E2E_Scenario_6
    Examples: 
      | Scenario                              | site | PlanType | externallink                                              | planyear | planYear | zipcode | isMultutiCounty | county            | MAplantype | planyear | MAplanName                           | cardtype | TFNNo          | TFNxpath                                                                                   | TFNxpath1                                          | PDPplantype | SNPplantype | MSplantype | PDPplanName                     | SNPplanName                                       | TFNxpath2                         | TFNxpath3                         | planIndex | planIndex1 |TFNxpath4                          |pscCode|
      | E2E Scenario 6_aarp-medicare-plans-11 | AARP | MAPD-MBI | https://info.aarpmedicareplans.com/aarp-medicare-plans-11 | future   | future   |   33111 | NO              | Miami-Dade County | MAPD       | future   | AARP Medicare Advantage Choice (PPO) | MBI      | 1-844-850-6592 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | (//a[contains(@class,'js-tel js-track-event')])[1] | PDP         | SNP         | MS         | AARP MedicareRx Walgreens (PDP) | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[1] |         1 |          2 | (//a[contains(@class, 'tel')])[3] |8000158|

	Scenario Outline: TID: <Scenario> -plan type: <plantype> - OLE End to end from external Links
	Given the user is on medicare acquisition site landing page fro campaign Traffic
    	|Site| <site>|
		Given the user navigates to following Campaign acquisition site page
      | PagePath | <path>     |
    And the user views the plans of the below plan type
      | Plan Type | <MAplantype> |
    # And the user selects plan year
    #	|Plan Year	| <planyear>|
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <MAplanName> |
      | Plan Type | <MAplantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    #Then the user validates cancellation and Save Return Later modal for OLE Page
    #Then the user cancels enrollment and navigates to homepage
    Then user closes current tab and navigate to previous tab
    #----------Repeat the steps for PDP Plan-----------------#
    Given the user is on medicare acquisition site landing page fro campaign Traffic
    	|Site| <site>|
		Given the user navigates to following Campaign acquisition site page
      | PagePath | <path>     |
    And the user views the plans of the below plan type
      | Plan Type | <PDPplantype> |
    # And the user selects plan year
    #	|Plan Year	| <planyear>|
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <PDPplanName> |
      | Plan Type | <PDPplantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then user closes current tab and navigate to previous tab
    #----------Repeat the steps for SNP Plan-----------------#
    Given the user is on medicare acquisition site landing page fro campaign Traffic
    	|Site| <site>|
		Given the user navigates to following Campaign acquisition site page
      | PagePath | <path>     |
    And the user views the plans of the below plan type
      | Plan Type | <SNPplantype> |
    # And the user selects plan year
    #	|Plan Year	| <planyear>|
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <SNPplanName> |
      | Plan Type | <SNPplantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to clicks on Enroll Now from Plan details page to start the OLE flow
      | Plan Type | <SNPplantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    # Then the user validates cancellation and Save Return Later modal for OLE Page
    Then user closes current tab and navigate to previous tab
    #-------------------Repeat the steps for Medsupp Plan----------------------------------------------
    Given the user is on medicare acquisition site landing page fro campaign Traffic
    	|Site| <site>|
		Given the user navigates to following Campaign acquisition site page
      | PagePath | <path>     |
    And the user views the plans of the below plan type
      | Plan Type | <MSplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user validates SAM icons on Medsupp page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |
    Then user closes current tab and navigate to previous tab
    #---------------------Privacy link in Medicare plans 11 page--------------------
    Given the user is on medicare acquisition site landing page fro campaign Traffic
    	|Site| <site>|
		Given the user navigates to following Campaign acquisition site page
      | PagePath | <path2>     |
    Then the user validates SAM icons on privacy page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then user closes current tab and navigate to previous tab

    @CampaignExternalLink_E2E_Scenario_6_Stage
    Examples: 
      | Scenario                              | site | PlanType | path                                                                               	|path2                                 |  planyear | planYear | zipcode | isMultutiCounty | county            | MAplantype | planyear | MAplanName                           | cardtype | TFNNo          | TFNxpath                                                                                   | TFNxpath1                                          | PDPplantype | SNPplantype | MSplantype | PDPplanName                     | SNPplanName                                       | TFNxpath2                         | TFNxpath3                         | planIndex | planIndex1 |
      | E2E Scenario 6_aarp-medicare-plans-11_stage | AARP | MAPD-MBI | /health-plans.html?zipcode=33111&WT.mc_id=8000158&county=120&state=12#/plan-summary | privacy-policy.html?WT.mc_id=8000158 |future   | future   |   33111 | NO              | Miami-Dade County | MAPD       | future   | AARP Medicare Advantage Choice (PPO) | MBI      | 1-844-850-6592 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | (//a[contains(@class,'js-tel js-track-event')])[1] | PDP         | SNP         | MS         | AARP MedicareRx Walgreens (PDP) | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[1] |         1 |          2 |

	
	
	@Scenario1
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links
    Given user is on campaign external Links page
      | External Link | <externallink> |
     Then user verify TFN on AARP external links page
      | TFN No      | <TFNNo>      |
      | TFN Xpath   | <TFNxpath1>  |
      | Working hrs | <workingHrs> |
    When user clicks on Find Plans and Pricing to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
 When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <planname> |
      | Plan Type | <plantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab
    #PDP Plan#
    When user clicks on Find Plans and Pricing to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <PDPplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <PDPplanname> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab
    #Med Sup Plan#
    When user clicks on Find Plans and Pricing to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
	And the user views the plans of the below plan type
      | Plan Type | <Medsupplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    #And the user validates SAM icons on Medsupp page
    	#| TFN No    | <TFNNo1>     |
      #| TFN Xpath | <TFNxpath2> |
    #Then the user validates TFN Number on Right Rail
     # | TFN No    | <TFNNo1>     |
      #| TFN Xpath | <TFNxpath2> |
    And user closes current tab and navigate to previous tab
    #Find Plans in your Area and SNP plantype*****#
    When user clicks on Find Plans in your area to open a new tab
    Then user should be navigated on Shop for a plan page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <SNPPlanName> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans> |
      And Navigate to Visitor Profile page
       And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab
    #DCE###
    When user clicks on Estimate Your Prescription Drug Costs from external page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    And user should be able to see Medicare Advantage plan by default
    And user should be able to toggle between plan types
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user saves and updates pharmacy from list
    Then the pharmacy name should be updated on summary page
    And user closes current tab and navigate to previous tab
    #PRE Flow##
    When user clicks on Start Now to get start the PRE flow from external page
    And clicks on get started button and runs a questionnaire
      | Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |

   @CampaignExternal_Scenario1_AARP1
    Examples: 
      | Scenario                                             | externallink                                             | zipcode | isMultutiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode |TFNNo1|pscCode|
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |   33111 | No              | Miami-Dade County | MAPD       | 1-855-264-3792 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 |1-866-408-5545|8012869|

    @CampaignExternal_Scenario1_UHC1
    Examples: 
      | Scenario                                             | externallink                                                | zipcode | isMultutiCounty | county            | MAplantype | TFNNo          | TFNxpath1                                     | workingHrs                              | plantype | planname                             | TFNxpath                                                                                   | planIndex | planIndex1 | PDPplantype | PDPplanname                     | planyear | TFNxpath3                         | Medsupplantype | SNPPlanName | testPlans                                         | TFNxpath2                                                                                          | drug1 | drug2   | drug3   | drug4   | zipCode |
      | Campaign External Links - E2E Scenario 1_UMS_English | https://ma.uhcmedicaresolutions.com/aarp-medicare-advantage |   33111 | No              | Miami-Dade County | MAPD       | 1-877-801-0043 | //a[contains(@class,'js-tel js-track-event')] | Hours: 8 a.m. to 8 p.m., 7 days a week* | MAPD     | AARP Medicare Advantage Choice (PPO) | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |         1 |          2 | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] | MS             | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | Emsam | Lipitor | Orfadin | Humalog |   27053 |

  Scenario Outline: <Scenario>: Validate TFN and SAM Call popup in MA, Medsupp page, PRE, VPP Plan Summary from External link: <externallink>
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on morganstanley external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #-------------------Learn About Medicare from Morgan Stanley page------------------
    Then the user clicks on Learn About Medicare button on Morgan Stanley external link page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number in Still have Questions section at bottom of page
      | TFN Xpath | <TFNxpath3> |
    #Then the user validates TFN Number on Right Rail
    #| TFN No    | <TFNNo>     |
    #| TFN Xpath | <TFNxpath3> |
    And the user clicks on Medicare Education Supplement Insurance Plans Link
    And the user validates SAM icons on Medsupp page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number in Still have Questions section at bottom of Medsupp page
      | TFN Xpath | <TFNxpath4> |
    And the user closes the new browser tab
    #--------------------PRE from Morgan Stanley page---------------------------
    Then the user clicks on Get Help Finding a Plan button on Morgan Stanley external link page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
   	And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And the user closes the new browser tab
    #---------------------VPP from Morgan Stanley page-------------------

    @Scenario5_AARP1
    Examples: 
      | Scenario                      | externallink                             | TFNNo          | TFNxpath1                                     | TFNxpath2                                                                                          | TFNxpath3                         |	TFNxpath4													|	pscCode	|	Zipcode	|	isMultiCounty	|	county						|	isCoverageOpt	|
      | E2E Scenario 5_ morganstanley | https://www.myuhcplans.com/morganstanley | 1-877-755-5345 | //a[contains(@class,'js-tel js-track-event')] | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | (//a[contains(@class, 'tel')])[1] |	(//a[contains(@class, 'tel')])[2]	|	8002977	|	65656		|	YES						|	Christian County	|	PDP						|

  Scenario Outline: <Scenario>: Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
    Given user is on campaign external Links page
      | External Link | <externallink> |
	 And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    Then User able to land  Shop for a plan page in new tab
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <planname>    |
      | Plan Type | <PDPplantype> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab
    #MAPD plantype
       And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    Then User able to land  Shop for a plan page in new tab
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <MAplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
  
     When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
     And the user views plan details of the above selected plan and validates
      | Plan Name | <MAplanname> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And user closes current tab and navigate to previous tab
              # SNP 
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    Then User able to land  Shop for a plan page in new tab
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    And the user views the plans of the below plan type
      | Plan Type | <SNPPlanName> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And the user views the plans of the below plan type
      | Plan Type | <planname> |
    And user closes current tab and navigate to previous tab
    #DCE###
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
     Then User able to land on Drug cost page in new tab
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    And user should be able to see Medicare Advantage plan by default
    And user should be able to toggle between plan types
     Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    When user saves and updates pharmacy from list
    Then the pharmacy name should be updated on summary page
    And user closes current tab and navigate to previous tab
     ## pharmacyflow##
     
    #Then the user check Still have a question
    @Scenario7_AARP1
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                                          | pscCode | zipcode | isMultutiCounty | county         | PDPplantype | planname                        | planyear | TFNxpath3                         | planIndex | planIndex1 | TFNxpath                                                                                   |	MAplantype	| MAplanname	|	SNPPlanName	|	 drug1 | drug2   | drug3   | drug4 | zipCode	|
      | E2E Scenario 7 _medicare-prescription-drug-plans-52 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | 8001024 |   36016 | Yes             | Barbour County | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] |         1 |          2 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |	MAPD	|	AARP Medicare Advantage Plan 1 (HMO)	|	UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP)	|	Emsam | Lipitor | Orfadin | Humalog | 27053	|
