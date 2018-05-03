@enrollInPlanUHC
Feature: To test enroll in plan on UHC site 
@OLE_MA
Scenario Outline: Verify enroll in plan in UHC site for federal plan type member  
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in row form
When user performs plan search using following information in UHC site
        | Zip Code    | <zipcode> |
        | County Name | <countyName>  |
And the user views plans of the below plan type in UHC site
        | Plan Type | <planType> |
And the user enrolls for the below plan in UHC site
        | <planName> |
And the user select the answer of this question Do you have End-Stage Renal Disease in UHC site
        |<answer>|
And the user navigates to Benefit information step in UHC site
And the user fill following information in beneficiary information step in UHC site
     | First Name                        | <firstName>                    |
     | Middle Initial                    | <middleInitial>            |
     | Last Name                         | <lastName>                    |
     | Birth Date                        | <birthDate>                    |
     | Gender                            | <selectedGender>            |
     | Medicare Claim Number             | <medicareClaimNumber>    |  
     | Hospital (Part A) Effective Date  | <hospitalEffectiveDate>  |
     | Medical (Part B) Effective Date   | <medicalEffectiveDate>   |
     | Address                           | <address>                    |  
     | Apartment                         | <apartment>                    |
     | City                              | <city>                    |
     | Same Mailing Address                 | Yes                            |
     | Main Phone Number                 | <mainPhoneNumber>            |  
     | Other Phone Number                 | <otherPhoneNumber>            |
     | Email Address                         | <emailAddress>            |
     | Confirm Email Address                 | <confirmEmailAddress>    |
     | Language Preference                 | <languagePreference>     |
And the user navigates to Additional Information step in UHC site
And the user reviews the personal and plan data by naviagting to Review application step in UHC site
And the user navigates to submit application step in UHC site
And the user selects "I am the applicant listed on this enrollment application" for the question "What is your relationship to the applicant listed on this enrollment application" in UHC site
And the user submits application by selecting agree to the Statement of Understanding in UHC site
Then the user validates the enrollment application confimation in UHC site
    
  Examples:
  |zipcode |countyName   | planType   | planName                                           |answer|firstName|middleInitial|lastName|birthDate  |selectedGender        | medicareClaimNumber|hospitalEffectiveDate        |medicalEffectiveDate        |address    |  city          | apartment |mainPhoneNumber |otherPhoneNumber| emailAddress   | confirmEmailAddress | languagePreference |
  |80002   |Adams County | MA         |AARP MedicareComplete SecureHorizons Essential (HMO)|No    | First   |  m          |  last  |01/01/1940 |  Male                | 111-11-1111-A      |07/01/1988                   |07/01/1988                  |1234            | Colorado    | UHG       |9999911111      |1111199999      | test@uhc.com   | test@uhc.com        |  English           |
## |80002  |Adams County | MA         |AARP MedicareComplete SecureHorizons Essential (HMO)|No    | john    |  l          |Abhra   |11/12/1988 |  Male                | 111-11-1111-B      |07/01/1989                   |07/01/1989                  |Dlf City   | UB    | a-11    |  No                |B2             | MUM           | C2             |TEXAS               |73301          |8800340918      |9414710603      |b@uhg.com   |b@uhg.com          |  English         |  Yes                  | 11/12/1999      | 11/12/1999  | Yes         |  11/12/1999      |   Yes           |11/12/1999 |   Yes                    | LIC                |  1212       | 123457       |       Yes                        | E     |F       | G     | H               | TEXAS        |73301    | 8800340918   | 11/12/1999    |     Yes                   |2222          |   Yes                    |   SAHARA                   |234    | 2222   |  Yes              | Yes                     |1113    |  yes                          |Xyz          |kumar           |agraw        | friend                    | b-11      | udaipur  | banglow1    | TEXAS        |73301   |9414710603     |  Agree          |                         
## |80002  |Adams County | PDP        |AARP MedicareRx Preferred (PDP)                     |No    | miller  |  j          |desh    |11/12/1989 |  Male                | 222-22-2222-C      |07/01/1989                   |07/01/1989                  |Ggn City   | Bang  | a-12    |  No                |B3             | DEL           | C3             |TEXAS               |73301          |8800340917      |9414710604      |c@uhg.com   |c@uhg.com          |  English         |  Yes                  | 11/12/1999      | 11/12/1999  | Yes         |  11/12/1999      |   Yes           |11/12/1999 |   Yes                    | LIC                |  1213       | 123458       |       Yes                        | I     |J       | K     | L               | TEXAS        |73301    | 8800340917   | 11/12/1999    |     Yes                   |3333          |   Yes                    |   ZEX                      |456    | 3333   |  Yes              | Yes                     |1114    |  yes                          |Abc          |kumar           |saini        | brother                   | b-12      | agra     | banglow2    | TEXAS        |73301   |9414710604     |  Agree          | 
    
@OLE_PDP
Scenario Outline: Verify enroll in plan in UHC site for federal plan type member  
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When user performs plan search using following information in UHC site
        | Zip Code    | <zipcode> |
        | County Name | <countyName>  |
And the user views plans of the below plan type in UHC site
        | Plan Type | <planType> |
And the user enrolls for the below plan in UHC site
        | <planName> |
And the user navigates to Benefit information step in UHC site
And the user fill following information in beneficiary information step in UHC site
     | First Name                        | <firstName>                    |
     | Middle Initial                    | <middleInitial>            |
     | Last Name                         | <lastName>                    |
     | Birth Date                        | <birthDate>                    |
     | Gender                            | <selectedGender>            |
     | Medicare Claim Number             | <medicareClaimNumber>    |  
     | Hospital (Part A) Effective Date  | <hospitalEffectiveDate>  |
     | Medical (Part B) Effective Date   | <medicalEffectiveDate>   |
     | Address                           | <address>                    |  
     | Apartment                         | <apartment>                    |
     | City                              | <city>                    |
     | Same Mailing Address                 | Yes                            |
     | Main Phone Number                 | <mainPhoneNumber>            |  
     | Other Phone Number                 | <otherPhoneNumber>            |
     | Email Address                         | <emailAddress>            |
     | Confirm Email Address                 | <confirmEmailAddress>    |
     | Language Preference                 | <languagePreference>     |
And the user navigates to Additional Information step in UHC site
And the user reviews the personal and plan data by naviagting to Review application step in UHC site
And the user navigates to submit application step in UHC site
And the user selects "I am the applicant listed on this enrollment application" for the question "What is your relationship to the applicant listed on this enrollment application" in UHC site
And the user submits application by selecting agree to the Statement of Understanding in UHC site
Then the user validates the enrollment application confimation in UHC site

    
  Examples:
  |zipcode |countyName   | planType   | planName                           |firstName|middleInitial|lastName|birthDate  |selectedGender        | medicareClaimNumber|hospitalEffectiveDate        |medicalEffectiveDate        |address    |  city          | apartment |mainPhoneNumber |otherPhoneNumber| emailAddress   | confirmEmailAddress | languagePreference |
  |78006   |Comal County | PDP         |AARP MedicareRx Preferred (PDP)    | First   |  m          |  last  |01/01/1940 |  Male                | 111-11-1111-A      |07/01/1988                   |07/01/1988                  |1234            | Colorado    | UHG       |9999911111      |1111199999      | test@uhc.com   | test@uhc.com        |  English           |
     
@OLE_MAPD
Scenario Outline: Verify enroll in plan  in UHC site for federal plan type member  
Given the following zipcode for UHC site 
                 | Zip Code    | <zipcode>    |
                 | County Name | <countyName> |
When fetch the data attributes in map form
When fetch the data attributes in row form
When the user performs a plan search in VPP flow for UHC site
         | Plan Type | <plantype> |
And the user views enroll in plan in UHC site
         | Plan Name  | <planName>  |         
##Then the user validate following plan information
##    | Plan     |
##    | ZIP      |
##    | Premium  |
And the user click enroll in a plan in UHC site
And the user performs to continue to online enrollment                                                                                                                                                                                                                                                        
##And the user select plan information after enrollment
##Then the user validate enrollment disclaimer information in plan information
And the user select the answer of this question "Do you have End-Stage Renal Disease?"
    |<answer>|
And the user select next step
    |<nextStepSelected>|
And the user fill following information in beneficiary information    
     | First Name                        | <firstName>    |
     | Middle Initial                    | <middleInitial>|
     | Last Name                         | <lastName>     |
     | Birth Date                        | <birthDate>    |
     | Sex                               | <selectedSex>  |
     | Medicare Claim Number             | <medicareClaimNumber>            |  
     | Hospital (Part A) Effective Date  | <hospital(Part A)EffectiveDate>  |
     | Medical (Part B) Effective Date   | <medical(Part B)EffectiveDate>   |
     | Address                           | <address>      |  
     | City                              | <city>         |
     | Apartment                         | <apartment>    |

 And the user select the answer of this question "Is your mailing address the same as your permanent street address?" 
     |<answerMailingAddress>|
     
 And the user fill following information after selecting answer 
     |Main Phone Number      | <mainPhoneNumber>    |  
     |Other Phone Number     | <otherPhoneNumber>   |
     |Email Address          | <emailAddress>       |
     |Confirm Email Address  | <confirmEmailAddress>|
  And the user select language in language preference 
     |Language Preference    | <languagePreference> |     
  And the user select next step
     |<nextStepSelected>| 
  
  And the user select the answer for special election period in Additional Information
     |<answerForElectionPeriod>|     
  And the user select the answer for prescription drug coverage
     |answerPrescriptionSelected|   
 
  And the user select the answer for this question "Do you live in a nursing home or a long-term care facility?" in long-term care facility  
     |<answerLongTermCareFacilitySelected>     | 
      
  And the user select the answer for this question "Are you enrolled in your State Medicaid program?" for state medicaid program
     |<answerStateMedicaidSelected>|
         
  And the user select the answer in other health insurance
     |<answerOtherHealthInsurance>|
   
 ## And the user select provider in primary care provider
 
  And the user select the answer for this question "Do you want to add a dental supplemental benefit?" in supplemental benefits 
     |answerRiderSelected|
      
  And the user select option for plan payment options
     |<planPaymentOptionSelected>|      
  And the user fill agent or broker id 
     |Broker Id |<brokerId>|       
  And the user select next step
    |<nextStepSelected>|   
    

 ## And the user validates following information
 ##    |Monthly Premium Costs   |  
  ##   |Plan Information        |  
  ##   |Beneficiary Information |  
 ##    |Additional Information  |  
 
   And the user select next step
    |<nextStepSelected>|  
   And the user select the question "What is your relationship to the applicant listed on this enrollment application?" in authorized representative 
    |<applicantRepresentativeSeleced>|
  And the user select statement of understanding
     |<statementSelected>|
     
##  And the user view submit application  
  And the user select submit application
    |<submitApplicationSelected>|   
 ## Then the user validates following enrollment application confirmation information
 ##   | Plan                    |
 ##   | ZIP                     |
 ##   | Premium                 |
 ##   | Proposed Effective Date |
 ##   | Confirmation Number     |   
    
  Examples:
             |zipcode |countyName   | planType   | planName                                           |answer|nextStepSelected|firstName|middleInitial|lastName|selectedSex|medicareClaimNumber|hospital(Part A)EffectiveDate|medical(Part B)EffectiveDate|address|city|apartment|answerMailingAddress|address|city|apartment|stateSelected|zip|mainPhoneNumber|otherPhoneNumber|emailAddress|confirmEmailAddress|languagePreference|nextStepSelected|answerForElectionPeriod|lastDayOfCoverage|moving date|medicaidCheck|lastDayOfCoverage|longTermCareCheck|moving date|answerPrescriptionSelected|nameOfOtherInsurance|groupIdNumber|memberIdNumber|answerLongTermCareFacilitySelected|name|address|city|apartmentOrSuite|stateSelected|zip|phoneNumber|dateMoved|answerStateMedicaidSelected|medicaidNumber|answerOtherHealthInsurance|nameOfHealthInsuranceCompany|groupId|memberId|answerRiderSelected|planPaymentOptionSelected|brokerId|nextStepSelected|nextStepSelected|authorizedRepresentativeSeleced|firstName|middleInitial|lastName|relationshipToApplicant|address|city|apartment|stateSelected|zip|phoneNumber|statementSelected|submitApplicationSelected|||                      
        ##     |80002   |Adams County | MAPD       |AARP MedicareComplete SecureHorizons Plan 2 (HMO)   |Yes/No|                |         |             |        |           |
       ##    |80002   |             | MA         |
       ##    |80002   |             | PDP        |
       
      