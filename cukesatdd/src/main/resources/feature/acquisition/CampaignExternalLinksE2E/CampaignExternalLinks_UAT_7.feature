Feature: 1.05.5. UAT Scripts Campaign External Links for Scenario7 related to prescription-drug-plans-52

   
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
 ## DCE alternate##
     And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
     When user click on Estimate your Drug Cost button under Look up your drugs title
    Then the user validates Get Started Page
     And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
      Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible
    And user closes current tab and navigate to previous tab
    ##medsupp
   And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
    Then User able to land  Shop for a plan page in new tab
    #And the user validates SAM icons on the page
     # | TFN Xpath | <TFNxpath2> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
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
    And the user validates SAM icons on Medsupp page from External page
    	| TFN No    | <TFNNo1>     |
      | TFN Xpath | <TFNxpath2> |
    Then the user validates TFN Number on Right Rail
      | TFN No    | <TFNNo1>     |
      | TFN Xpath | <TFNxpath2> |
     And user closes current tab and navigate to previous tab
   ## pharmacyflow##
   And the user validate links and other options on medicare prescription drug external link page
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |
   When user clicks on Start Now to get start the Pharmacy flow from external page
   And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
      And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
     
     
    #Then the user check Still have a question
   @Scenario7_AARP
    Examples: 
      | Scenario                                            | externallink                                                          | TFNNo          | TFNxpath1                               | TFNxpath2                                                                                          | pscCode | zipcode | isMultutiCounty | county         | PDPplantype | planname                        | planyear | TFNxpath3                         | planIndex | planIndex1 | TFNxpath                                                                                   |	MAplantype	| MAplanname	|	SNPPlanName	|	 drug1 | drug2   | drug3   | drug4 | zipCode	|	Medsupplantype	|	TFNNo1	|
      | E2E Scenario 7 _medicare-prescription-drug-plans-52 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | 1-866-308-8818 | //*[@id="tfn-614028214"]/p[2]/span[1]/a | //span[contains(@class,'sam__button__container')]//*[contains(@class,'sam__button__text desktop')] | 8001024 |   36016 | Yes             | Barbour County | PDP         | AARP MedicareRx Walgreens (PDP) | future   | (//a[contains(@class, 'tel')])[1] |         1 |          2 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |	MAPD	|	AARP Medicare Advantage Plan 1 (HMO)	|	UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP)	|	Emsam | Lipitor | Orfadin | Humalog | 27053	|	MS	|	1-844-895-7228 	|
