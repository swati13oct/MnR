
Feature: 1.05.1. OLE common tool flow E2E MA

  	Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on medicare acquisition site landing page fro campaign Traffic
    	|Site| <site>|
		Given the user directly navigates to welcome OLE page
     		 | PagePath | <path>     |
       	| Plan Name | <planName> |
         | Plan Type | <plantype> |
         |Plan Year	| <planyear>|
    Then the user validates the Plan details on OLE
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
      |Home Number         | <phoneno>       |
      | Mobile Number       | <mobileno>      |   
      | Middle Name         | <middlename>    |  
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      # | PartA Date         | <partadate>         |
      # | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    	Then the user validates Medicaid Number in confirm Eligibility Page
      | MedicaidNumber | <medicaidnumber> |
      | Plan Year      | <planYear>       |
    Then the user validates the dispalyed sections for the Plan Type in Medicare Information Page
    Then the user answers following questions in Medicare Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to SEP Page
      | Input Data     | <inputdataType>  |
      | PartA Date     | <partadate>      |
      | PartB Date     | <partbdate>      |
      | MedicaidNumber | <medicaidnumber> |
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
    | Payment Type | <paymentType> |
    | Card No | <cardno> |
    | Card Expiration Month | <cardexpirationmonth> |
    | Card Expiration Year | <cardexpirationyear> |
    | Card Holder First Name               | <firstname>              |
    | Card Holder Last Name                | <lastname>               |    
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
       | Rider Flag | <riderflag> |
    #Then the user validates required fields for Authorization Page
    Then the user validates required fields for Authorization Page Representative
      	|authorizationFirstname|<authorizefirstN>|
      	|authorizationLastname|<authorizelastN>|
       	|authorizationAddress|<authorizeaddress>|
       	|authorizationApartmentSuite|<authorizeapartment>|
        |authorizationCity|<authorizecity>|
        |authorizationZip|<authorizezip>|
        |authorizationPhoneNo|<authorizephonenumber>|
        |authorizationRelationship| <authorizeRelationship>|
        |authorizationStateDisplay|<authorizestate>|
        |authorizationAgree  |<authorizationagree>|
    Then the user navigates to Review and Submit Page
    #    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user validates the Online Enrollment details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    # Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.
		Then the user validates the OLE Submission Details in GPS
    	| Plan Type | <plantype> |
	      | Auth Flag | <authflag> |
		 | Mailing Address Question | <mailingaddressquestion> |
    
    @OLE_PlanBenefits_AARP
        Examples: 
    | TID   | site|PlanType |planyear|planYear|zipcode | isMultutiCounty | county          | plantype | planName                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |phoneno   | mobileno |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|middlename|authorizefirstN|authorizelastN|authorizeaddress|authorizeapartment|authorizecity|authorizezip|authorizephonenumber|authorizeRelationship|authorizestate|authorizationagree|permaptno|mailingaptno|authflag|paymentType|cardno|cardexpirationmonth|cardexpirationyear|path|
    | 15556 |AARP| MAPD-RRID-MBI|future|future |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 1 (HMO) | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      0123456789  | false    | 01011983 | Male   | 001 Morris Rd | New York | No                    | 801 MailingSt | Mailing LA  | NY           |      10001 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | yes          | true      | NO                | NO      |1234567890|2345678901|HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|                |Test_K|Test_M|122 2ND AVE|655|MINNEAPOLIS|55455|1235678901|FRIEND|MN|Agree|566|677|true|Pay By Mail||||health-plans/medicare-advantage-plans/medicare-enrollment/united-healthcare-medicare-advantage-online-application.html/welcome?oleClient=%7B"PlanName":"AARP%20Medicare%20Advantage%20Plan%201%20(HMO)","Year":"2021","Zip":"10001","CountyName":"New%20York%20County","Premium":"54.00","PlanType":"MAPD","StateCode":"NY","FipsCode":"061","HNumber":"H3307","PBPNumber":"002","RiderFlag":"true","CMScode":"420","PrefferedPlanId":"H3307002000","PlanCode":"undefined","mapsPlanType":"HMO","env":"nonProd","OLEisCNS":"false","clientProdCode":"undefined","lineOfBusiness":"undefined","OLEisCSNP":"false","fitness":"true","vision":"true","hearing":"true","dental":"true","segmentId":"000","salesAgentID":"","siteId":"uhc","clientCode":"UHCMS1","TFN":"1-877-596-3258","psc":"880180","sessionId":""%7D&cid=em:2021-dsnp-acquisition:0de603a4&WT.mc_id=8020279 |
		
 

