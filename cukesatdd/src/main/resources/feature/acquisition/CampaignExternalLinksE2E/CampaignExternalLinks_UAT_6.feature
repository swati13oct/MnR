@campaignExternalLinks
Feature: 1.05.5. UAT Scripts Campaign External Links scenario 6 related to  medicare-plans-11 

  Scenario Outline: TID: <Scenario> -plan type: <plantype> - Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
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
    And the user views the plans for below plan type
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
    And the user views the plans for below plan type
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
    And the user views the plans for below plan type
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
    And the user views the plans for below plan type
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

	Scenario Outline: TID: <Scenario> -plan type: <plantype> - Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
	Given user is on campaign external Links page
      | External Link | <externallink> |
    Then the user validate links and other options on aarp medicare plans11 external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    Then the user validate aarp medicare plans11 page external link in lower env
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
    And the user views the plans for below plan type
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
    Then the user validate aarp medicare plans11 page external link in lower env
      | Zip Code | <zipcode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     Then the user validates TFN Number on Zipcode component
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user views the plans for below plan type
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
    Then the user validate aarp medicare plans11 page external link in lower env
      | Zip Code | <zipcode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     Then the user validates TFN Number on Zipcode component
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user views the plans for below plan type
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
    Then the user validate aarp medicare plans11 page external link in lower env
      | Zip Code | <zipcode> |
    Then the user validates SAM icons on the page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
     Then the user validates TFN Number on Zipcode component
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath3> |
    And the user views the plans for below plan type
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
    Then the user navigate back to aarp medicare plans11 privacy link in lower env
    Then the user validates SAM icons on privacy page
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then user closes current tab and navigate to previous tab
    
    @CampaignExternalLink_E2E_Scenario_6_Stage @regressionAARP @campaignExternalStage
    Examples: 
      | Scenario                              | site | PlanType | externallink                                              | planyear | planYear | zipcode | isMultutiCounty | county            | MAplantype | planyear | MAplanName                           | cardtype | TFNNo          | TFNxpath                                                                                   | TFNxpath1                                          | PDPplantype | SNPplantype | MSplantype | PDPplanName                     | SNPplanName                                       | TFNxpath2                         | TFNxpath3                         | planIndex | planIndex1 |TFNxpath4                          |pscCode|
      | E2E Scenario 6_aarp-medicare-plans-11 | AARP | MAPD-MBI | https://info.aarpmedicareplans.com/aarp-medicare-plans-11 | future   | future   |   33111 | NO              | Miami-Dade County | MAPD       | future   | AARP Medicare Advantage Choice (PPO) | MBI      | 1-844-850-6592 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | (//a[contains(@class,'js-tel js-track-event')])[1] | PDP         | SNP         | MS         | AARP MedicareRx Walgreens (PDP) | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[3] |         1 |          2 | (//a[contains(@class, 'tel')])[3] |8000158|
