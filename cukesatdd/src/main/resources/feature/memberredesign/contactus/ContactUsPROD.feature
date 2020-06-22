@contactUsPROD @CodeTranformer 
Feature: 1.16 Prod Member Contact us Page 

#TestCaseIndi1
@regressionMemberPROD1
Scenario Outline: UID: <UID> -Plan Type: <planType> Verify labels and telephone numbers for individual member on contactUs page 
	Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
    When the user navigates to contact us page in UHC site
    Then On contactUs page the user should see Help With This Website and Help With Your Plan sections
    | PlanType       | <planType>       |
    | techSupportTFN | <techSupportTFN> |
    | planSupportTFN | <planSupportTFN> |
   
    Examples:   
    | UID        | username | password | member            | planType      | techSupportTFN     | planSupportTFN    |
	| TestCase1  | jkuma14  | Brock@02 | LMHOCHSCHILD11    |	MAPD       |	1-800-721-0627  |	1-844-876-6177  |
	| TestCase2  | jkuma14  | Brock@02 | MOLAR1            |	PDP        |	1-800-721-0627  |	1-866-870-3470  |
	
#TestCaseCombo2	
@regressionMemberPROD1
Scenario Outline: UID: <UID> -Plan Type: <planType> Verify labels and telephone numbers for combo member on contactUs page
	Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
    When the user navigates to contact us page in UHC site
    Then validate contactUs page for combo plan member
    | PlanType       | <planType>       |
   
    Examples:   
    | UID        | username | password | member            | planType      | 
	| TestCase3  | jkuma14  | Brock@02 | DKELLY27          | ComboPDPSSUP  |
	| TestCase4  | jkuma14  | Brock@02 | OLGITA@68         | ComboPdpSHIP  |				

#TestCasePCP3
 @regressionMemberPROD2
  Scenario Outline: UID: <UID> -Plan Type: <planType> Verify labels and telephone numbers for PCP member on contactUs page
 Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
    When the user navigates to contact us page in UHC site
    Then the pcp and Medica user validates the labels and contact numebers on the page
    | PlanType       | <planType>       |
    | techSupportTFN | <techSupportTFN> |
    | planSupportTFN | <planSupportTFN> |
    And the user click on view questions button and validate the questions links
    | Plan Type       | <planType>       |
  Examples:   
    | UID        | username | password | member            | planType      |  techSupportTFN     | planSupportTFN    |
	| TestCase3  | jkuma14  | Brock@02 | marylamb823       | PCP           |   1-800-721-0627  |	1-866-231-7201  |

#TestCaseSHIP4
  @regressionMemberPROD2
   Scenario Outline: UID: <UID> -Plan Type: <planType> Verify SHIP Email Us Widget Confirm Request in contact us redesign page
   Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
    When the user navigates to contact us page in UHC site
    Then for Ship member validates labels and TFNs on the contactUS page
      | callUsSHIPTFN          | <callUsSHIPTFN>    |
      | generalQueTFN          | <generalQueTFN>    |
      | claimQueTFN            | <claimQueTFN>      |
    Then user click on EmailUs and fill all the detail and click on cancel button
      | Enquiry Type          | <enquiryType>          |
      | Message               | <message>              |
      | AARPMembership Number | <aarpMemberShipNumber> |
      | First Name            | <firstName>            |
      | Last Name             | <lastName>             |
      | First Name            | <firstName>            |
      | Email Address         | <emailAddress>         |
      | ConfirmEmail Address  | <confirmEmailAddress>  |
      | Date                  | <date>                 |
      | Month                 | <month>                |
      | Year                  | <year>                 |

    Examples: 
      | UID   | plantype | username | password | member        | enquiryType | message | aarpMemberShipNumber | firstName | lastName | emailAddress   | confirmEmailAddress | date | month | year | callUsSHIPTFN     | generalQueTFN    | claimQueTFN |
      | 15380 | PHIP     | jkuma14  | Brock@02 | Pramila1946  | Claims      | Testing |           1234567890 | test      | test     | test@optum.com | test@optum.com      |   01 |    01 | 1950 | 1-866-254-3132    | 1-800-523-5800   | 1-800-523-5880 |
	  

#TestCaseClickTOCallCancel5
@regressionMemberPROD2
 Scenario Outline: UID: <UID> -Plan Type: <planType> Verify clickToCall Widget Expansion -Drop-Down, Text Box and Button UI- and click on cancel on contactUS redesign page
	Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
    When the user navigates to contact us page in UHC site
    And user clicks on cancel button on Request a call widget
      | Phone Number | <phoneNumber> |

    Examples: 
      | UID   | planType | username | password | member         | phoneNumber |
      | 15224 | MAPD     |  jkuma14 | Brock@02 | LMHOCHSCHILD11 |  9999999999 |

#TestCaseClickTOCallCancel6
@regressionMemberPROD3
 Scenario Outline: UID: <UID> -Plan Type: <planType> Verify View qquestion button and common questions on the contactUS redesign page
   Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
    When the user navigates to contact us page in UHC site
    And the user click on view questions button and validate the questions links
   | Plan Type   | <plantype>   |
    
     Examples: 
      | UID       | planType | username | password | member         |
      | 152201    | MAPD     |  jkuma14 | Brock@02 | LMHOCHSCHILD11 |
      | US2438941 | PHIP     | jkuma14  | Brock@02 | Pramila1946  |
      | 152255    | PCP     | jkuma14  | Brock@02 | marylamb823       |
      
#TestCaseClickTOCallCancel7
@regressionMemberPROD2
  Scenario Outline: UID: <UID> -Plan Type: <planType> Verify terminated members view on contact us redesign page
     Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
    When the user navigates to contact us page in UHC site
    Then user should only see the Technical Support and Plan Support components

    Examples: 
     | UID   | planType | username | password | member         | 
     | 15224 | MA     |  jkuma14 | Brock@02 | BEVERLY_BOB5 |
      
      
#TestCaseClickTOCallCancel8
@regressionMemberPROD3
  Scenario Outline: UID: <UID> -Plan Type: <planType> Verify the See how to guide link on the contactUs page
    Given the user is on member auth login flow page 
	When the member is able to login with correct username and password 
		| Username | <username> |
		| Password | <password> |
	And Member Enters the Username he wants to search 
		| MemUsername | <member> |
	And user clicks on member to select 
    When the user navigates to contact us page in UHC site
    Then Verify and navigate the see how to guide link on the contactUs page
     Examples: 
      | UID       | planType | username | password | member         |
      | 152201    | MAPD     |  jkuma14 | Brock@02 | LMHOCHSCHILD11 |
      
      