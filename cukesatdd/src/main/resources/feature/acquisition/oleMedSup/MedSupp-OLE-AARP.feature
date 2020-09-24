@CT @OLE @OLE_Ulayer @OLE_VPP_UHC_ResumeApplication
Feature: 1.06. ACQ- MedSupp OLE flow AARP

  @OLE_VPP_UHC @UHC_Resume_App_AARP @OLE_Regression @oleMedSupUlayer @prodRegression
Scenario Outline: MedSup Resume Application with Application ID
Given the user is on AARP medicare acquisition site landing page
   When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
     When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
     Then the AARP site user clicks on Start Application Button proceed to next pages for getting resume application key
       | DOB           | <DOB>         |
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    |
     Then user clicks on resume application button in the AARP site
    		| DOB           | <DOB>         |
    		| Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    |     
     #Then the user signs in with optum Id credentials to resume application in AARP site
      | User Name | <userName> |
      | Password  | <password> | 
     Then the user signs in with optum Id in medsup flow
     		|User Name | <username> |
     		|Password | <password>|
     Then the user validate retrieve application URL in AARP Site
     | AARP URL    | <AARPUrl> |
     |AARP URL STG|<AARPUrl-stg>|
     #Then user enters data to resume the application in the AARP site
       | applicationType| <applicationType>|
       | ApplicationID |<ApplicationID>|
       | DOB           | <DOB>         |
      | zipcode       | <zipcode>     |    
     # Then user validates the resume application processed in the AARP site
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    |
    
      
       Examples: 
      | zipcode | isMultutiCounty |AARPUrl							| county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType | username | password |AARPUrl-stg|
      |   90210 | NO              |aarpsupplementalhealth.com/ole/ms.olelaunch.html |Los Angeles County | MS       | 11/13/1950 | John      | Carry   |    ABCD        | Resume          |mmnrqavd3 | Password@1|https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html|
	#		|   90210 | NO              |https://aarpsupplementalhealth-stg.uhc.com/ole/ms.olelaunch.html|Los Angeles County | MS       | 11/13/1950 | John      | Carry   |    ABCD        | Resume          |mmnrqavd3 | Password@1|https://aarpsupplementalhealth-stg.uhc.com/ole/ms.olelaunch.html|     
  
@UHC_Retrive_App_AARP @oleMedSupUlayer
Scenario Outline: MedSup Retrieve Application with Application ID
Given the user is on AARP medicare acquisition site landing page
   When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
   Then the AARP site user clicks on Start Application Button proceed to next pages for getting resume application key
       | DOB           | <DOB>         |
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    |
   Then user clicks on resume application button in the AARP site
     Then user enters data to resume the application in the AARP site
       | ApplicationID     | <ApplicationID>   |
       | DOB               | <DOB>         |
       | zipcode           | <zipcode>     |
       | applicationType           | <applicationType>     |
      
      Then user validates the Retrive application in the AARP site
    | ApplicationID     | <ApplicationID>   |
     
       Examples: 
     | zipcode | isMultutiCounty | county             | plantype | DOB      | Firstname | Lastname  |  ApplicationID   | applicationType |
     |   90210 | NO              | Los Angeles County | MS       | 11131950 | Donald     | Abrahm   |   E-PMO6-T5HH-78  | Retrive          |

@MedSuppOLEULayerSmoke
Scenario Outline: MedSup OLE End to end from AARP Acquisition site VPP Plan Summary
Given the user is on AARP medicare acquisition site landing page
  When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
     Then user clicks on Start Application Button proceed to next pages
     | Zip Code        | <zipcode>         |
       | DOB           | <DOB>         |
      When user fill medsupp form details and proceed to next pages  
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    | 
      Then User navigates to plan summary page of AARP site 
   Examples: 
     | zipcode | isMultutiCounty | county             | plantype | DOB      | Firstname | Lastname  | 
     |   90002 | NO              | Los Angeles County | MS       | 11/11/1949 | test     | test   |         
     
     
     @MedSuppOLEBLayerSmoke
Scenario Outline: MedSup OLE End to end from AARP Acquisition site VPP Plan Summary
Given the user is on UHC medicare acquisition site page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
     Then user clicks on Start Application Button proceed to next pages
      | Zip Code        | <zipcode>         |
       | DOB           | <DOB>         |
      When user fill medsupp form details and proceed to next pages  
       | Firstname     | <Firstname>   |
       | Lastname      | <Lastname>    | 
      Then User navigates to plan summary page of AARP site 
   Examples: 
     | zipcode | isMultutiCounty | county             | plantype | DOB      | Firstname | Lastname  | 
     |   90002 | NO              | Los Angeles County | MS       | 11/11/1949 | test     | test   |         
