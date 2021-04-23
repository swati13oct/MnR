@MedSupp_OLE_Common
Feature: 1.05.9 -OLE MedSupp Flow
  
@MedSupp_OLE_Common
  Scenario Outline: MedSup Resume Application with Application ID on acq site -<site>
   Given the user is on medicare acquisition site landing page
   		|Site| <site>|
		When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
		When the user views the plans of the below plan type
      | Plan Type | <plantype> |
		Then the site user clicks on Start Application Button proceed to next pages
      | DOB           | <DOB>         |
      | Firstname     | <Firstname>   |
      | Lastname      | <Lastname>    |
    Then user clicks on resume application button
   	 	| DOB           | <DOB>         |
   	 	| Firstname     | <Firstname>   |
      | Lastname      | <Lastname>    |
    #Then the user signs in with optum Id credentials to resume application in UHC site
    #  | User Name | <userName> |
    #  | Password  | <password> |
    Then the user signs in with optum Id
     	|User Name | <username>|
     	|Password  | <password>|
    Then the user validate retrieve application URL
      | AARP URL    | <AARPUrl> 	|
      |AARP URL STG |<AARPUrl-stg>|
    #Then the user enters data to resume the application
    #  | applicationType| <applicationType>|
    #	 | ApplicationID |<ApplicationID>|
    #  | DOB           | <DOB>         |
    #  | Zipcode       | <zipcode>     |   
    #Then The user validates the resume application processed
    #  | Firstname     | <Firstname>   |
    #  | Lastname      | <Lastname>    |
  
   @MedSupp_OLE_Common_AARP @regressionAARP  
   Examples: 
      | zipcode | isMultutiCounty | AARPUrl                                          | county             | plantype | DOB        | Firstname | Lastname | ApplicationID | applicationType | username  | password   | AARPUrl-stg                                                                                     | site |
      |   90002 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html | Los Angeles County | MS       | 11/13/1940 | John      | Carry    | ABCD          | Resume          | mnrqavd11 | Password@1 | https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html | AARP |

	@MedSupp_OLE_Common_UHC
   Examples: 
      | zipcode | isMultutiCounty | AARPUrl																					| county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType | username | password |AARPUrl-stg|site|
      |   90002 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html|Los Angeles County | MS       | 11/13/1940 | John      | Carry   |    ABCD        | Resume          |mnrqavd11 | Password@1|https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html|UHC|
  
  
   @MedSupp_OLE_Common
  Scenario Outline: <scenario> MedSup E2E Flow through Shop Pages
   Given the user is on medicare acquisition site landing page
   		|Site| <site>|
   And the user hovers screen over the shop for a plan
   And click on Enroll Plan on shoppages for Medsupp plans
     When the user performs plan search using Shop Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
  Then the site user clicks on Start Application Button and proceed Next 
      | DOB           | <DOB>         |
      | Firstname     | <Firstname>   |
      | Lastname      | <Lastname>    |
    Then the site user clicks on continue application until confirmaion page
    | MedicareNumber | <medicarenumber> |
      
    
#   @MedSupp_OLE_Common_AARP @regressionAARP   
   Examples: 
    |scenario            | zipcode | isMultutiCounty | AARPUrl																					| county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType | username | password |AARPUrl-stg|site|medicarenumber|
    |E2E Scenario 3_AMP  |   90002 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html|Los Angeles County | MS       | 11/13/1940 | John      | Carry   |    ABCD        | Resume          |TiggerOptumID29 | TiggerTigger1|https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html|AARP|1EG1TE1MK12|
	
#	@MedSupp_OLE_Common_UHC
   Examples: 
   |scenario   | zipcode | isMultutiCounty | AARPUrl																					| county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType | username | password |AARPUrl-stg|site|medicarenumber|
   | E2E Scenario 3_UMS  |   90002 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html|Los Angeles County | MS       | 11/13/1940 | John      | Carry   |    ABCD        | Resume          |TiggerOptumID29 | TiggerTigger1|https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html|UHC|1EG1TE1MK13|
  
  
  
