Feature: 1.05.5. UAT Scripts Campaign External Links for Scenario7 related to prescription-drug-plans-52

   
  Scenario Outline: <Scenario>: Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links.
    Given user is on campaign external Links page
      | External Link | <externallink> |
    And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    #-------------------------PDP plantype---------------------------------------
    Then User able to land on Shop for a plan page in new tab
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user should be able to see "Medicare Prescription Drug Plans" expanded by default
    Then the user view plan details of the above selected plan in site vpp
      | Plan Name | <PDPplanname> |
      | Plan Type | <PDPplantype> |
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
     Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN Xpath | <TFNxpath3> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    #-------------------------MAPD plantype---------------------------------------
    Then User able to land on Shop for a plan page in new tab
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user views the plans of the below plan type
      | Plan Type | <MAplantype> |  
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail
      | TFN Xpath | <TFNxpath4> |
     And the user views plan details of the above selected plan and validates
      | Plan Name | <MAplanname> |
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    When user clicks on Add to compare checkbox on plan detail page
    And the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then verify the Add to compare checkbox is checked for selected plan
      | Plan index | <planIndex> |
    When user select "<planIndex1>" plans to compare
    And user clicks on compare button
    Then verify plan compare page is loaded
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN Xpath | <TFNxpath3> |
    Then the user navigates to Personal Information Page
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    #-----------------------------------SNP plantype-------------------------------
    Then User able to land on Shop for a plan page in new tab
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user views the plans of the below plan type
      | Plan Type | <SNPPlanType> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail
      | TFN Xpath | <TFNxpath4> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <SNPPlanName> |
    And the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail OLE page
      | TFN Xpath | <TFNxpath3> |
    And the user navigates to Personal Information Page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    #---------------------------------Medsupp Plantype-------------------------
    Then User able to land on Shop for a plan page in new tab
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Zipcode component
      | TFN Xpath | <TFNxpath4> |
    When the user performs plan search using following information using external link
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    Then the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
		And the user views the plans of the below plan type
      | Plan Type | <Medsupplantype> |
    And the user validates SAM icons on Medsupp page from External page
    	| TFN No    | <TFNNo1>    |
      | TFN Xpath | <TFNxpath2> |
     And user closes current tab and navigate to previous tab
    #------------------------------DCE from External Link----------------------------------#
    And the user clicks on Estimate your drug costs to land on Drug cost page from External link
    #And the user validates Get Started Page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    And user should be able to see Medicare Advantage plan by default
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    Then the user verify the default Retail chain pharmacy on drug summary page
    	|DefaultPharmacy| <defaultPharmacy>|
    And user should be able to toggle between plan types
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And user click on PDP plan to view drug pricing
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
 		#--------------------------DCE from Look Up your Drugs---------------------##
    When user click on Estimate your Drug Cost button under Look up your drugs title
    #And the user validates Get Started Page
    And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
    And the user closes the new browser tab
    ##--------------------------------- pharmacyflow from External Link------------------------##
   When user clicks on Start Now to get start the Pharmacy flow from external page
   And the user validates SAM icons on the page
      | TFN Xpath | <TFNxpath2> |
   And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>		|
      | Distance    | <distance>	|
      | County Name | <county> 		|
     
     
    #Then the user check Still have a question
   @Scenario7_AARP
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                                          | pscCode | zipcode | isMultutiCounty | county         | PDPplantype | PDPplanname                     | TFNxpath3                         | planIndex | planIndex1 | TFNxpath4                         |	MAplantype	| MAplanname														|	SNPPlanType	|	SNPPlanName																				|	drug1 | drug2   | drug3   | drug4 	| zipCode	|	Medsupplantype	|	TFNNo1					|	defaultPharmacy																																							|	testPlans																	|
      | E2E Scenario 7 _medicare-prescription-drug-plans-52 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | 8001024 |   36016 | Yes             | Barbour County | PDP         | AARP MedicareRx Walgreens (PDP) | (//a[contains(@class, 'tel')])[3] |         1 |          2 | (//a[contains(@class, 'tel')])[1] |	MAPD				|	AARP Medicare Advantage Plan 1 (HMO)	|	SNP					|	UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP)	|	Emsam | Lipitor | Orfadin | Humalog | 27053		|	MS							|	1-844-895-7228 	|	Retail Chain Pharmacy (Pricing is based off of a Preferred Pharmacy for applicable plans.)	|	AARP Medicare Advantage Plan 2 (HMO-POS)	|
