@enrollInPlanUHC
Feature: To test enroll in plan on UHC site 

@OLEBlayerMapd
Scenario Outline: Verify enroll in plan in UHC site for federal plan type member  
Given the user is on the UHC medicare solutions landing page OLE UHC
When user performs plan search using following information in UHC site OLE UHC
        | Zip Code    | <zipcode> |
        | County Name | <countyName>  |
And the user views plans of the below plan type in UHC site OLE UHC
        | Plan Type | <planType> |
And the user enrolls for the below plan in UHC site OLE UHC
        | <planName> |
And the user select the answer of this question Do you have End-Stage Renal Disease in UHC site OLE UHC
        |<answer>|
And the user navigates to Benefit information step in UHC site OLE UHC
And the user fill following information in beneficiary information step in UHC site OLE UHC
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
And the user navigates to Additional Information step in UHC site OLE UHC
And the user reviews the personal and plan data by naviagting to Review application step in UHC site OLE UHC
And the user navigates to submit application step in UHC site OLE UHC
And the user selects "I am the applicant listed on this enrollment application" for the question "What is your relationship to the applicant listed on this enrollment application" in UHC site OLE UHC
And the user submits application by selecting agree to the Statement of Understanding in UHC site OLE UHC
Then the user validates the enrollment application confimation in UHC site OLE UHC
    
  Examples:
  |zipcode |countyName   | planType   | planName                                           |answer|firstName|middleInitial|lastName|birthDate  |selectedGender        | medicareClaimNumber|hospitalEffectiveDate        |medicalEffectiveDate        |address    |  city          | apartment |mainPhoneNumber |otherPhoneNumber| emailAddress   | confirmEmailAddress | languagePreference |
  |27009   |Adams County | MA         |AARP MedicareComplete Choice (PPO)|No    | First   |  m          |  last  |01/01/1940 |  Male                | 111-11-1111-A      |07/01/1988                   |07/01/1988                  |1234            | Colorado    | UHG       |9999911111      |1111199999      | bhavana.pilli@optum.com   | bhavana.pilli@optum.com    |  English           |
## |80002  |Adams County | MA         |AARP MedicareComplete SecureHorizons Essential (HMO)|No    | john    |  l          |Abhra   |11/12/1988 |  Male                | 111-11-1111-B      |07/01/1989                   |07/01/1989                  |Dlf City   | UB    | a-11    |  No                |B2             | MUM           | C2             |TEXAS               |73301          |8800340918      |9414710603      |b@uhg.com   |b@uhg.com          |  English         |  Yes                  | 11/12/1999      | 11/12/1999  | Yes         |  11/12/1999      |   Yes           |11/12/1999 |   Yes                    | LIC                |  1212       | 123457       |       Yes                        | E     |F       | G     | H               | TEXAS        |73301    | 8800340918   | 11/12/1999    |     Yes                   |2222          |   Yes                    |   SAHARA                   |234    | 2222   |  Yes              | Yes                     |1113    |  yes                          |Xyz          |kumar           |agraw        | friend                    | b-11      | udaipur  | banglow1    | TEXAS        |73301   |9414710603     |  Agree          |                         
## |80002  |Adams County | PDP        |AARP MedicareRx Preferred (PDP)                     |No    | miller  |  j          |desh    |11/12/1989 |  Male                | 222-22-2222-C      |07/01/1989                   |07/01/1989                  |Ggn City   | Bang  | a-12    |  No                |B3             | DEL           | C3             |TEXAS               |73301          |8800340917      |9414710604      |c@uhg.com   |c@uhg.com          |  English         |  Yes                  | 11/12/1999      | 11/12/1999  | Yes         |  11/12/1999      |   Yes           |11/12/1999 |   Yes                    | LIC                |  1213       | 123458       |       Yes                        | I     |J       | K     | L               | TEXAS        |73301    | 8800340917   | 11/12/1999    |     Yes                   |3333          |   Yes                    |   ZEX                      |456    | 3333   |  Yes              | Yes                     |1114    |  yes                          |Abc          |kumar           |saini        | brother                   | b-12      | agra     | banglow2    | TEXAS        |73301   |9414710604     |  Agree          | 
    

Scenario Outline: Verify enroll in plan in UHC site for federal plan type member  
Given the user is on UHC medicare site landing page OLE UHC
When user performs plan search using following information in UHC site OLE UHC
        | Zip Code    | <zipcode> |
        | County Name | <countyName>  |
And the user views plans of the below plan type in UHC site OLE UHC
        | Plan Type | <planType> |
And the user enrolls for the below plan in UHC site OLE UHC
        | <planName> |
And the user navigates to Benefit information step in UHC site OLE UHC
And the user fill following information in beneficiary information step in UHC site OLE UHC
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
And the user navigates to Additional Information step in UHC site OLE UHC
And the user reviews the personal and plan data by naviagting to Review application step in UHC site OLE UHC
And the user navigates to submit application step in UHC site OLE UHC
And the user selects "I am the applicant listed on this enrollment application" for the question "What is your relationship to the applicant listed on this enrollment application" in UHC site OLE UHC
And the user submits application by selecting agree to the Statement of Understanding in UHC site OLE UHC
Then the user validates the enrollment application confimation in UHC site OLE UHC

    
  Examples:
  |zipcode |countyName   | planType   | planName                           |firstName|middleInitial|lastName|birthDate  |selectedGender        | medicareClaimNumber|hospitalEffectiveDate        |medicalEffectiveDate        |address    |  city          | apartment |mainPhoneNumber |otherPhoneNumber| emailAddress   | confirmEmailAddress | languagePreference |
  |78006   |Comal County | PDP         |AARP MedicareRx Preferred (PDP)    | First   |  m          |  last  |01/01/1940 |  Male                | 111-22-2222-A      |07/01/1988                   |07/01/1988                  |1234            | Colorado    | UHG       |9999911111      |1111199999      | test@uhc.com   | test@uhc.com        |  English           |
     
    
    
    
   
Scenario Outline: Verify enroll in plan  in UHC site for federal plan type member  
Given the following zipcode for UHC site OLE UHC
                 | Zip Code    | <zipcode>    |
                 | County Name | <countyName> |
When the user performs a plan search in VPP flow for UHC site OLE UHC
         | Plan Type | <plantype> |
And the user views enroll in plan in UHC site OLE UHC
         | Plan Name  | <planName>  |         
##Then the user validate following plan information
##    | Plan     |
##    | ZIP      |
##    | Premium  |
And the user click enroll in a plan in UHC site OLE UHC
And the user performs to continue to online enrollment OLE UHC                                                                                                                                                                                                                                                    
##And the user select plan information after enrollment
##Then the user validate enrollment disclaimer information in plan information
And the user select the answer of this question "Do you have End-Stage Renal Disease?"  OLE UHC
    |<answer>|
And the user select next step OLE UHC
    |<nextStepSelected>|
And the user fill following information in beneficiary information OLE UHC    
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

 And the user select the answer of this question "Is your mailing address the same as your permanent street address?" OLE UHC 
     |<answerMailingAddress>|
     
 And the user fill following information after selecting answer OLE UHC 
     |Main Phone Number      | <mainPhoneNumber>    |  
     |Other Phone Number     | <otherPhoneNumber>   |
     |Email Address          | <emailAddress>       |
     |Confirm Email Address  | <confirmEmailAddress>|
  And the user select language in language preference OLE UHC 
     |Language Preference    | <languagePreference> |     
  And the user select next step OLE UHC
     |<nextStepSelected>| 
  
  And the user select the answer for special election period in Additional Information OLE UHC
     |<answerForElectionPeriod>|     
  And the user select the answer for prescription drug coverage OLE UHC
     |answerPrescriptionSelected|   
 
  And the user select the answer for this question "Do you live in a nursing home or a long-term care facility?" in long-term care facility OLE UHC  
     |<answerLongTermCareFacilitySelected>     | 
      
  And the user select the answer for this question "Are you enrolled in your State Medicaid program?" for state medicaid program OLE UHC
     |<answerStateMedicaidSelected>|
         
  And the user select the answer in other health insurance OLE UHC
     |<answerOtherHealthInsurance>|
   
 ## And the user select provider in primary care provider
 
  And the user select the answer for this question "Do you want to add a dental supplemental benefit?" in supplemental benefits OLE UHC 
     |answerRiderSelected|
      
  And the user select option for plan payment options OLE UHC
     |<planPaymentOptionSelected>|      
  And the user fill agent or broker id OLE UHC 
     |Broker Id |<brokerId>|       
  And the user select next step OLE UHC
    |<nextStepSelected>|   
    

 ## And the user validates following information
 ##    |Monthly Premium Costs   |  
  ##   |Plan Information        |  
  ##   |Beneficiary Information |  
 ##    |Additional Information  |  
 
   And the user select next step OLE UHC
    |<nextStepSelected>|  
   And the user select the question "What is your relationship to the applicant listed on this enrollment application?" in authorized representative OLE UHC 
    |<applicantRepresentativeSeleced>|
  And the user select statement of understanding OLE UHC
     |<statementSelected>|
     
##  And the user view submit application  
  And the user select submit application OLE UHC
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
       