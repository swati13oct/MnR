@UATRegression @visitorProfile @visitorProfileUpdated
Feature: 1.08. UAT- Visitor profile 

@sanity
  Scenario Outline: TID: <Scenario> Validate that M&R Prospective client has the ability to Enroll in plans available in Guest Profile. Additional functionality tested: global flyout menu, saved plans, alert tip, external links
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
    When user clicks on change pharmacy link from summary page
    Then the user selects following pharmacy and returns to DCE Summary page
    |	SelectPharmacy	|	<SelectPharmacy>	|
     When user should be able to click on plan and view drug cost
    	|	planType	|	<planType>	|
    	|	planName	|	<planName>	|
    Then user should be able to save drugs
    And the user clicks on the shopping cart icon from DCE
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
      And the user selects plan and navigates back to profile
    |	PlanName	|	<testPlan>	|
    And the user views the drugs added
    
    @regressionAARP
    Examples: 
      | Scenario                                             | externallink                                             | drug1 | drug2   | drug3   | drug4   | zipCode |	testPlans	|	planName	|	planType	|	SelectPharmacy	| userName  | password   |
      | Scenario 4 | https://ma.aarpmedicareplans.com/aarp-medicare-advantage |	Nexium	|	Advair Diskus	|	aripiprazole	|	insulin lispro	|	80243	|	 AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Plan 2 (HMO)	|	UnitedHealthcare Dual Complete (HMO D-SNP)	|	Medicare Special Needs Plans	|	UCHEALTH OUTPATIENT PHARMACY CCM	|	vdatdd_06 | Password@1 |

 	@regressionUHC
    Examples: 
      | Scenario                                             | externallink                                             | drug1 | drug2   | drug3   | drug4   | zipCode |	testPlans	|	planName	|	planType	|	SelectPharmacy	| userName  | password   |
      | Scenario 4 | https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 |	Nexium	|	Advair Diskus	|	aripiprazole	|	insulin lispro	|	80243	|	 AARP Medicare Advantage SecureHorizons Plan 1 (HMO),AARP Medicare Advantage SecureHorizons Plan 2 (HMO)	|	UnitedHealthcare Dual Complete (HMO D-SNP)	|	Medicare Special Needs Plans	|	UCHEALTH OUTPATIENT PHARMACY CCM	|	vdatdd_06 | Password@1 |


 Scenario Outline: Validate that M&R Prospective client has the ability to Enroll in plans available in Guest Profile. Additional functionality tested: log in, provider search
  Given user is on campaign external Links page
      | External Link | <externallink> |
    When user clicks on Estimate Your Prescription Drug Costs from external page
    Then the user validates Get Started Page
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
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
	Then user saves two plans as favorite 
		| Test Plans | <testPlans> |
		| Plan Type  | <plantype>  |
	Then user selects keepshopping on the pop-up 
	And the user views the plans of the below plan type 
		| Plan Type | <plantype1> |
	And the user selects plan year 
		| Plan Year | <planyear> |
		| Plan Type | <plantype1> |
	And user saves plan as favorite on vpp summary page 
		| Test Plans | <testPlans1> |
	And the user views the plans of the below plan type 
		| Plan Type | <plantype2> |
	And the user selects plan year 
		| Plan Year | <planyear> |
		| Plan Type | <plantype2> |
	And user saves plan as favorite on vpp summary page 
		| Test Plans | <testPlans2> |
	And the user clicks on the shopping cart icon 
	And user validates the added plans on visitor profile page 
		| Test Plans | <testPlans> |
	And user validates the added plans on visitor profile page 
		| Test Plans | <testPlans1> |
	And user validates the added plans on visitor profile page 
		| Test Plans | <testPlans2> |	 
	And the user enrolls the plan from VisitorProfile
		| Plan Name | <PlanName> |
	Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name               | <firstname>              |
      | Last Name                | <lastname>               |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | MedicaidNumber           | <medicaidnumber>         |
    # | Middle Name         		 | <middlename>       |
    Then the user enters following information in Personal Information Page
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
      | Home Number        | <phoneno>           |
      | Mobile Number      | <mobileno>          |
      | Middle Name        | <middlename>        |
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    #Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to Medicare Information Page
    #Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      # | PartA Date         | <partadate>         |
      # | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    #Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    #    Then the user navigates to Preliminary Questions Page
    Then the user validates Medicaid Number in confirm Eligibility Page
      | MedicaidNumber | <medicaidnumber> |
      | Plan Year      | <planYear>       |
    #    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
    Then the user answers following questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user validates the long term questions in Medicare Information Page
      | Health Insurance Name | <healthinsurancename> |
      | Group Number          | <groupnumber>         |
      | Member Number         | <membernumber>        |
    Then the user validates the Prescription drug coverage questions in Medicare Information Page
      | Prescription Name | <prescriptioncoveragename> |
      | PD Group Number   | <pdgroupnumber>            |
      | PD Member Number  | <pdmembernumber>           |
    Then the user navigates to SEP Page
      | Input Data     | <inputdataType>  |
      | PartA Date     | <partadate>      |
      | PartB Date     | <partbdate>      |
      | MedicaidNumber | <medicaidnumber> |
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    #    Then the user navigates to Coverage and Health Information Page
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user selects payment type
      | Payment Type           | <paymentType>         |
      | Card No                | <cardno>              |
      | Card Expiration Month  | <cardexpirationmonth> |
      | Card Expiration Year   | <cardexpirationyear>  |
      | Card Holder First Name | <firstname>           |
      | Card Holder Last Name  | <lastname>            |
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    #Then the user validates required fields for Authorization Page
    Then the user validates required fields for Authorization Page Representative
      | authorizationFirstname      | <authorizefirstN>       |
      | authorizationLastname       | <authorizelastN>        |
      | authorizationAddress        | <authorizeaddress>      |
      | authorizationApartmentSuite | <authorizeapartment>    |
      | authorizationCity           | <authorizecity>         |
      | authorizationZip            | <authorizezip>          |
      | authorizationPhoneNo        | <authorizephonenumber>  |
      | authorizationRelationship   | <authorizeRelationship> |
      | authorizationStateDisplay   | <authorizestate>        |
      | authorizationAgree          | <authorizationagree>    |
    Then the user navigates to Review and Submit Page
    #Then the user validates the Plan and Member details on Review and Submit Page
    Then the user validates the Online Enrollment details on Review and Submit Page
    #Then the user clicks on Submit Enrollment to complete enrollment
    Then the user validates the OLE Submission Details in GPS
      | Plan Type                | <plantype>               |
      | Auth Flag                | <authflag>               |
      | Mailing Address Question | <mailingaddressquestion> |
	
	Then the user validates whether call icon is visible 
	And user delets the added plans on visitor profile page 
		| Test Plans | <testPlans> |
		
	@regressionAARP 	
	Examples: 
		|	externallink	| state   | planyear | zipcode | isMultiCounty | county          | userName  | password   | plantype | testPlans                                                                                              |	plantype1	|	testPlans1							|	plantype2	|	testPlans2											|	PlanName	|cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
		| https://ma.aarpmedicareplans.com/aarp-medicare-advantage | Alabama | future   |   30342 | NO            | Fulton County 	| vdatdd_05 | Password@1 | MAPD     |	UnitedHealthcare Medicare Advantage Choice (Regional PPO),AARP Medicare Advantage Walgreens (HMO) |	PDP			|	AARP MedicareRx Walgreens (PDP)		|	SNP			|	UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP)	|	AARP Medicare Advantage Walgreens (HMO)	| MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01011983 | Male   | 001 Morris Rd | New York | No                     | 801 MailingSt | Mailing LA  | NY           |      30342 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
	@regressionUHC 	
	Examples: 
		|	externallink	| state   | planyear | zipcode | isMultiCounty | county          | userName  | password   | plantype | testPlans                                                                                              |	plantype1	|	testPlans1							|	plantype2	|	testPlans2											|	PlanName	|cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen | phoneno    | mobileno   | healthinsurancename | groupnumber | membernumber | prescriptioncoveragename | pdgroupnumber | pdmembernumber | inputdataType | middlename | authorizefirstN | authorizelastN | authorizeaddress | authorizeapartment | authorizecity | authorizezip | authorizephonenumber | authorizeRelationship | authorizestate | authorizationagree | permaptno | mailingaptno | authflag | paymentType | cardno  | cardexpirationmonth | cardexpirationyear |
		|  https://pdp.aarpmedicareplans.com/medicare-prescription-drug-plans-52 | Alabama | future   |   30342 | NO            | Fulton County 	| vdatdd_05 | Password@1 | MAPD     |	UnitedHealthcare Medicare Advantage Choice (Regional PPO),AARP Medicare Advantage Walgreens (HMO) |	PDP			|	AARP MedicareRx Walgreens (PDP)		|	SNP			|	UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP)	|	AARP Medicare Advantage Walgreens (HMO)	| MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |     0123456789 | false    | 01011983 | Male   | 001 Morris Rd | New York | No                     | 801 MailingSt | Mailing LA  | NY           |      30342 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      | 1234567890 | 2345678901 | HealthInsurance     | HI1562759   | ABC12345DEF  | PrescriptionCoverage     | PD5646136     | BCD12345EFG    | Valid         | [blank]    | Test_K          | Test_M         | 122 2ND AVE      |                655 | MINNEAPOLIS   |        55455 |           1235678901 | FRIEND                | MN             | Agree              |       566 |          677 | true     | Pay By Mail | [blank] | [blank]             | [blank]            |
			
 Scenario Outline: Validate that M&R Prospective client has the ability Save plans, sync to authenticated profile, DCE, Provider search
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And the user back to VPP plan summary page
    When the user views the plans of the below plan type and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    Then Navigate to Visitor Profile page
    Then Verify X out of Y provider covered information is displayed on visitor profile page
      | PlanName | <planname> |
    And user delets all the added providers on visitor profile page
      | PlanName | <planname> |

    @visitorProfile_AARP @regressionAARP
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName  | password   | plantype | planname                             |
      | AARP | New York |   10001 | NO              | New York County | vdatdd_03 | Password@1 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |

    @visitorProfile_UHC @regressionUHC
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName      | password   | plantype | planname                             |
      | UHC  | New York |   10001 | NO              | New York County | vdatdd_03_uhc | Password@1 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |
	
			
 Scenario Outline: Validate that M&R Prospective client has the ability to Add plan, remove plan, view plan details
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
	Then user saves two plans as favorite 
		| Test Plans | <testPlans> |
		| Plan Type  | <plantype>  |
	Then user selects keepshopping on the pop-up 
	And the user clicks on the shopping cart icon
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And the user selects plan and navigates back to profile
    |	PlanName	|	<testPlan>	|
    
        @visitorProfile_AARP @regressionAARP
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName  | password   | plantype | planname                             | planyear |	 testPlans	|	testPlan	|
      | AARP | King County |   98105 | NO              | New York County | vdatdd_03 | Password@1 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | future   | 	UnitedHealthcare Medicare Advantage Choice (Regional PPO),AARP Medicare Advantage Walgreens (HMO) 	|	UnitedHealthcare Medicare Advantage Choice (Regional PPO)	|

    @visitorProfile_UHC @regressionUHC
    Examples: 
      | site | state    | zipcode | isMultutiCounty | county          | userName      | password   | plantype | planname                             |planyear |	 testPlans	|	testPlan	|
      | UHC  | King County |   98105 | NO              | New York County | vdatdd_03_uhc | Password@1 | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |future   | 	UnitedHealthcare Medicare Advantage Choice (Regional PPO),AARP Medicare Advantage Walgreens (HMO) 	|	UnitedHealthcare Medicare Advantage Choice (Regional PPO)	|
      
	