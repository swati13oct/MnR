@UATRegression @visitorProfile 
Feature: 1.08. UAT- Visitor profile 

@Scenario1123
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to land into the portal pages via the different deep links
    Given user is on campaign external Links page
      | External Link | <externallink> |
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
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    And user should be able to see "Medicare Advantage Plans" by default
    Then user saves MAPD plan as favorite on drug summary page AARP site
     | Test Plans | <testPlans> |
     @regressionAARP
    Examples: 
      | Scenario                                             | externallink                                             | drug1 | drug2   | drug3   | drug4   | zipCode |	testPlans	|
      | Campaign External Links - E2E Scenario 1_AMP_English | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |	Nexium	|	Advair Diskus	|	aripiprazole	|	insulin lispro	|	80243	|	 AARP Medicare Advantage SecureHorizons Plan 1 (HMO)	|

@regressionAARP @sanity 
Scenario Outline:
Validate that M&R Prospective client has the ability to Enroll in plans available in Guest Profile - zip -<zipcode> 
	Given the user is on medicare acquisition site landing page 
		| Site | <site> |
	And the user clicks on the shopping cart icon 
	And the user clicks on the add plans button in the profile 
	When the user enters zipcode on health plans page 
		| Zip Code        | <zipcode>       |
		| County Name     | <county>        |
		| Is Multi County | <isMultiCounty> |
	Then user validates plan count for all plan types on plan summary page 
	And the user views the plans of the below plan type 
		| Plan Type | <plantype> |
	And the user selects plan year 
		| Plan Year | <planyear> |
		| Plan Type | <plantype> |
	Then the site user fills all the details in MedsuppPage
		|	DOB	|	<dob>	|
	Then user saves two plans as favorite 
		| Test Plans | <testPlans> |
		| Plan Type  | <plantype>  |
	Then user gets a create profile prompt
    Then user click on continue as guest button
	And user validates the added Ms plans on visitor profile page 
		| MS Test Plans | <MS Test Plans> |
	Then the site user clicks on MS Start Application Button and proceed Next
		|	DOB	|	<dob>	|
		| First Name               | <firstname>              |
      	| Last Name                | <lastname>               |
      	| PlanName	|	<PlanName>	|
	Then the site user clicks on continue application until confirmaion page
		| MedicareNumber    | <medicarenumber>    |	
		
		@regressionAARP
	Examples: 
		| site | state   | planyear | zipcode | isMultiCounty | county          | plantype | testPlans                                                                                              |	PlanName	|cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |MS Test Plans|
		| AARP | Alabama | future   |   44114 | NO            | Cuyahoga County 	| MS     |	Plan F,Plan N |	Plan N	| MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01/01/1946 | Male   | 001 Morris Rd | New York | No                     | 801 MailingSt | Mailing LA  | NY           |      30342 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |Plan F,Plan N	|		
	@regressionUHC
	Examples: 
		| site | state   | planyear | zipcode | isMultiCounty | county          | plantype | testPlans                                                                                              |	PlanName	|cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |MS Test Plans|
		| AARP | Alabama | future   |   44114 | NO            | Cuyahoga County 	| MS     |	Plan F,Plan N |	Plan N	| MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01/01/1946 | Male   | 001 Morris Rd | New York | No                     | 801 MailingSt | Mailing LA  | NY           |      30342 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |Plan F,Plan N	|		

 Scenario Outline: Validate that M&R Prospective client has the ability to Compare plans in Guest profile.
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans and "<count>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    Then Click on Add Icon on new Plan Compare and verify it navigates to plan summary page
    And check one plan and add it to plancompare
    Then Verify newly added plan displayed on new plan compare page
    And click on Add your Hospitals link and Navigate to Rally page
    And I click on Get Started on and Add PrimaryCare PCP from find care page
    And I access the DCE Redesign from Plan compare page
    Then the user searches and adds the following Drug to Drug List
	|	DrugName	|	<DrugName>	|
	Then the user clicks on return to compare link on build drug list page to returns to plan compare
	Then the user validates drug is displayed on the plan compare page
	|	DrugName	|	<DrugName>	|
	And click on Edit your doctors link and Navigate to Rally page
	And I click on Add Places from Hospitals find care page
    Then verify Your Hospital is loaded with doctor summary on Plan Compare page
    Then verify Your doctors is loaded with doctor summary on Plan Compare page
    And user clicks on heart icon and save plan on Plan Compare
	|	PlanName	|	<planName>	|
	Then remove "<removePlanIndices>" plan from new plan compare page
	Then Click on Add Icon on new Plan Compare and verify it navigates to plan summary page
	And check one plan and add it to plancompare
	Then Click on Add Icon on new Plan Compare and verify it navigates to plan summary page
	And the user views the plans of the below plan type
      | Plan Type | <plantype2> |
	And user saves plan as favorite on vpp summary page 
		| Test Plans | <testPlans2> |
	Then user selects keepshopping on the pop-up 
	And user saves plan as favorite on vpp summary page 
		| Test Plans | <testPlans3> |
	And the user clicks on the shopping cart icon
	And user selects plans to compare from visitor Profile
	|	Plantype	|	<plantype>	|
	Then user verify failure message after plan compare clicked
	|	Plantype	|	<plantype>	|
	And user selects plans to compare from visitor Profile
	|	Plantype	|	<plantype2>	|
	Then verify plan compare page is loaded when navigating from profile
    Then the user clicks on Enroll in plan and validates the Welcome to OLE Page on new Plan Compare


     @regressionAARP 
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear |	DrugName	| planName	|	removePlanIndices	|	plantype2	|	testPlans2	|	testPlans3	|
      | 00010 | AARP |   33111 | NO            | Los Angeles County | MAPD     |     2 | future   |	atorvastatin calcium	|	 AARP Medicare Advantage Choice (PPO)	|	3	|	PDP	|	AARP MedicareRx Walgreens (PDP)	|	AARP MedicareRx Preferred (PDP)	|

     @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultiCounty | county             | plantype | count | planyear |DrugName	| planName	|	removePlanIndices	|	plantype2	|	testPlans2	|	testPlans3	|
      | 00010 | UHC  |   90210 | NO            | Los Angeles County | MAPD     |     2 | future   |	atorvastatin calcium	|	 AARP Medicare Advantage Choice (PPO)	|	3	|	PDP	|	AARP MedicareRx Walgreens (PDP)	|	AARP MedicareRx Preferred (PDP)	|
      

	
