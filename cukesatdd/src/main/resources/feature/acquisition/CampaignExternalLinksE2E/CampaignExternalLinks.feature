 Feature: 1.05.5. UAT Scripts Campaign External Links

  Scenario Outline: TID: <Scenario> -plan type: <plantype> - OLE End to end from external Links
 
  Given user is on campaign external Links page
    	|External Link| <externallink>|
		Then the user validate aarp medicare plans11 page external link
       | Zip Code        | <zipcode>         | 	
	Then the user validates whether SAM icons on a page
	 			| TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
  	And the user views the plans of the below plan type
      | Plan Type | <MAplantype> |
    And the user selects plan year
    	|Plan Year	| <planyear>|
	#And the user validates plan summary for the below plan
     # | Plan Name | <planName> |
   	Then the user validates whether SAM icons on a page
     And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user validates whether SAM icons on a page
    #And I select "<plantype>" plans to compare and click on compare plan link
    #----------------
    And the user clicks on compare plans button on plan details page and navigate to compare page
    Then verify plan compare page is loaded
    Then the user clicks on back on all plan link in Plan Compare page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
   # When user clicks on Select a plan button on NBA
#    Then user should be able to see the Select Plan for Enroll Modal with saved plans
#      | Test Plans | <testplans> |
  #  When user clicks on Enroll in plan button on the select plan modal on vpp summary page
   Then the user validates whether SAM icons on a page
    Then the user navigates to clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <MAplanName> |
    Then the user validates the Plan details on OLE
    Then the user validates whether SAM icons on a page
     Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
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
   	Then the user validates whether SAM icons on a page
		Then the user validates cancellation and Save Return Later modal for OLE Page
		Then the user navigate back to external link of aarp medicare plans11 page
   	Then the user validates whether SAM icons on a page
	 
		@CampaignExternalLink_E2E_Scenario_6
    Examples: 
      | Scenario                               | site|PlanType   |externallink                                               |planyear|planYear|zipcode | isMultutiCounty | county            | MAplantype |planyear| MAplanName                                | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |  healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType                 |TFNNo          |TFNxpath                                                                                        |
      | E2E Scenario 6_aarp-medicare-plans-11  | AARP |MAPD-MBI  | https://info.aarpmedicareplans.com/aarp-medicare-plans-11 |future  |future  |33111   | NO              | Miami-Dade County | MAPD       |future  |AARP Medicare Advantage Choice (PPO)       | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |      0123456789  | true     | 04261944 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | FL           |      33111 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false      |                   | NO      | NO |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid    |1-855-264-3792 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')]     |
			
			
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
