#Author: namita_meher@optum.com
Feature: OLE Enrol Pages

 @uhccp
 Scenario Outline: OLE Without County Selection - <zipcode> - Language: <lang>
    Given User is on the UHCCP landing page
    And the user selects language
    	|	Language	|	<lang> |
    When the user performs plan search in UHCCP homepage 
    	| Zip Code        | <zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>        |
      | Plan Name				| <planname>			|
    And User views Plan Details of the below Plan
    	| Plan Name	| <planname>	|
    And the user clicks on Enroll in Plan and validates Welcome to OLE Page
   	Then the user navigates to OLE Personal Information Page
   	Then the user enters following required information in Personal Information Page
      | First Name               | <firstname>              |
      | Middle Name              | <middlename>             |
      | Last Name                | <lastname>               |
      | DOB                      | <dob>                    |
      | Gender                   | <gender>                 |
      | Perm_Street              | <permstreet>             |
      | Perm_city                | <permcity>               |
      | Perm_AptNo               | <permaptno>              |
      | Mailing Address Question | <mailingaddressquestion> |
      | Mailing_Street           | <mailingstreet>          |
      | Mailing_AptNo            | <mailingaptno>           |
      | Mailing_City             | <mailingcity>            |
      | Mailing_State            | <mailingstate>           |
      | Mailing_Zip              | <mailingzip>             |
      | Email                    | <email>                  |
      | Email Confirmation | <emailConfirmation>            |
      | Go Green           | <goGreen>                      |
      | Home Number        | <phoneno>                      |
      | Mobile Number      | <mobileno>                     |
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Information
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | Card Type          | <cardtype>          |
   	Then the user validates Medicaid Number in OLE Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user navigates to Confirm your Eligibility Page
      | Input Data     | <inputdataType>  |
      | PartA Date     | <partadate>      |
      | PartB Date     | <partbdate>      |
      | MedicaidNumber | <medicaidnumber> |
    
    
    Examples: 
      | zipcode | isMultiCounty	|	county	|	lang		|	planname																						|	firstname       | middlename      | lastname        | dob        | gender	| permstreet    				| permcity    |	permaptno	| mailingaddressquestion| mailingstreet | mailingaptno	|	mailingcity 	| mailingstate	| mailingzip	| email         |	emailConfirmation | goGreen | phoneno				| mobileno   		|	medicarenumber	| ssnflag	|	cardtype	|	medicaidnumber	| partadate	|	partbdate	|       
      | 35057   | No						|	Alabama	|	Es			|	UnitedHealthcare Dual Complete Plan 1 (HMO D-SNP)		|	Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | Female	|	12529 State Road 535 	| Ste   			| 566				|	No										|	802 MailingSt	|	566						|	Montgomery    | AL						| 35057				|	test@test.com	|	<blank>						|	<blank>	|	952-931-4701	| 837-625-4803	| 1EG4-TE5-MK99 	| false		|	MBI				|	1234567892 			| 05012015 	|	05012015	|
      #| 85925   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Phoenix       | ARIZONA        | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 94501   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | San Francisco | CALIFORNIA     | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 14215   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Yonkers       | NEW YORK       | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 45693   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Akron         | OHIO           | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 45011   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Columbus      | OHIO           | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 17325   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Pittsburgh    | PENNSYLVANIA   | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 02809   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | War Wick      | RHODE ISLAND   | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      #| 78520   | Test_Portals_FN | Test_Portals_MN | Test_Portals_LN | 11-11-1993 | 12529 State Road 535 | Ste   | Houston       | TEXAS          | 952-931-4701 | 837-625-4803 | test@test.com | 1EG4-TE5-MK72 | 1234567892 | 07-30-2021 |
      
 
 #Then click on Next Page button for OLE form
  #  And User enters First Name as "<fname>" for OLE form
   # And User enters Middle Name as "<mname>" for OLE form
    #And User enters Last Name as "<lname>" for OLE form
   # And User enters Date of birth as "<dob>" for OLE form
   # And User selects the gender for OLE form
   # And User enters Street Address as "<adr1>" for OLE form
   # And User enters Apartment/Suite as "<adr2>" for OLE form
   # And User enters City as "<city>" for OLE form
    #And User enters State as "<state>" for OLE form
    #And User enters Zip Code as "<zipcode>" for OLE form
  #  And User enters Main Phone Number as "<mnphnum>" for OLE form
   # And User enters Mobile Phone Number as "<mbphnum>" for OLE form
   # And User enters Primary Email Address as "<email>" click on next for OLE form
   # Then click on Next Page button for OLE form
   # And User enters Medicare number as "<mcnum>" for OLE form
   # And User selects Medicaid number for OLE form
   # And User enters Medicaid number as "<mdnum>" for OLE form
   # And User enters Hospital (Part A) Effective Date as "<date>" for OLE form
   # And User enters Medical (Part B) Effective Date  as "<date>" click on next for OLE form
   # And User selects Other Health Insurance for OLE form
   # And User selects Prescription Drug Coverage click on next for OLE form
   # And User selects Special Election Period click on next for OLE form
   # And User clicks next on provider search page for OLE form
   # And User clicks next on Lookup your provider page for OLE form
   # And User clicks next on Payement information page for OLE form   
   # And User selects on Authorizations and Approvals for OLE form
   # And User selects on Statement of Understanding clicks on next for OLE form
   # Then User clicks on Submit Application for OLE form
   # Then User Checks for confirmation message for OLE form
   # And close browser for OLE form
 
 
 
 
 
 
 
 
 
 
 
 
 
 
    
   
