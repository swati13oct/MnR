@UATRegression @regressionAARP
Feature: 1.05.9 UAT-OLE MedSupp Flow
    
   @MedSupp_OLE_Common@MedSupp_OLE_Common_AARP1
  Scenario Outline: <scenario> MedSup E2E Flow through Shop Pages
  Given the user is on the Acquisition Site landing page and navigate to Shop a plan page mobile
   		|Site| <site>|
   And click on Enroll Plan on shoppages for Medsupp plans
   When the user performs plan search using Shop Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the site user fills all the details in MedsuppPage
   		| DOB           | <DOB>         |  		
   	Then the site user validates the RightRails Links on Medsupp Page
   Then user validate the plandetails on medsupp plans
  Then the site user clicks on Start Application Button and proceed Next 
      | DOB           | <DOB>         |
      | Firstname     | <Firstname>   |
      | Lastname      | <Lastname>    |
    Then the site user clicks on continue application until confirmaion page
    | MedicareNumber | <medicarenumber> |
      
    
   
   Examples: 
    |scenario            | zipcode | isMultutiCounty | AARPUrl																					| county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType | username | password |AARPUrl-stg|site|medicarenumber|
    |E2E Scenario 3_AMP  |   90002 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html|Los Angeles County | MS       | 11/13/1940 | John      | Carry   |    ABCD        | Resume          |TiggerOptumID29 | TiggerTigger1|https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html|AARP|1EG1TE1MK12|
	
#	@MedSupp_OLE_Common_UHC
 #  Examples: 
 #  |scenario   | zipcode | isMultutiCounty | AARPUrl																					| county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType | username | password |AARPUrl-stg|site|medicarenumber|
 #  | E2E Scenario 3_UMS  |   90002 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html|Los Angeles County | MS       | 11/13/1940 | John      | Carry   |    ABCD        | Resume          |TiggerOptumID29 | TiggerTigger1|https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html|UHC|1EG1TE1MK13|
  
  
 @MedSupp_OLE_Common 
Scenario Outline: <scenario> MedSup E2E Flow through VPP Pages
   Given the user is on medicare acquisition site landing page
   		|Site| <site>|
		When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
		When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then the site user fills all the details in MedsuppPage
   		| DOB           | <DOB>         |  		
   #	Then the site user validates the RightRails Links on Medsupp Page
   	#Then user validate the plandetails on medsupp plans
  Then the site user clicks on Start Application Button and proceed Next 
      | DOB           | <DOB>         |
      | Firstname     | <Firstname>   |
      | Lastname      | <Lastname>    |
    Then the site user clicks on continue application until confirmation page
    | MedicareNumber | <medicarenumber> |
       
   @MedSupp_OLE_Common_AARP @regressionAARP
   Examples: 
    |scenario            | zipcode | isMultutiCounty | AARPUrl																					| county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType | username | password |AARPUrl-stg|site|medicarenumber|
    |E2E Scenario 1_AMP  |   90002 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html|Los Angeles County | MS       | 11/13/1940 | John      | Carry   |    ABCD        | Resume          |TiggerOptumID29 | TiggerTigger1|https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html|AARP|1EG1TE1MK12|
	
	@MedSupp_OLE_Common_UHC
   Examples: 
   |scenario   | zipcode | isMultutiCounty | AARPUrl																					| county             | plantype | DOB      | Firstname | Lastname|  ApplicationID | applicationType | username | password |AARPUrl-stg|site|medicarenumber|
   | E2E Scenario 1_UMS  |   90002 | NO              | aarpsupplementalhealth.com/ole/ms.olelaunch.html|Los Angeles County | MS       | 11/13/1940 | John      | Carry   |    ABCD        | Resume          |TiggerOptumID29 | TiggerTigger1|https://aarpsupplementalhealth-stg.uhc.com/content/aarpsupplementalhealth/ole/ms.olelaunch.html|UHC|1EG1TE1MK13|
  