@fastandfurious @OLE @OLE_Ulayer
Feature: 1.12-VBF-ACQ-To test OLE common tool flow in AARP site

  @acquisitionRegression @junerelease2018 @september_release_2018 @december_release_2018 @OLE_PCP_Medica_AARP @MACRAvalidation @OEP_CHANGES @OLE_Regression_Ulayer
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates TFN in Welcome OLE Right Rail
    #Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
      | Email Confirmation| <emailConfirmation> |
      | Go Green	    | <goGreen>		   |
      | Email                    | <email>  |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Review and Submit Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType         | zipcode | isMultutiCounty | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
      | 15558 | MA-HICN          |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | false      | true       | true        | true        |	NO					| NO	  |
      | 15559 | MA-RRID          |   80002 | YES             | Adams County       | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | RRID     | John      | Doe      | AAA998877665   | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | true      | false      | true       | true        | true        |	NO					| NO	  |
      | 15560 | MA-PFFS-MBI      |   85923 | NO              | Navajo County      | MA       | UnitedHealthcare MedicareDirect Essential (PFFS)     | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text         | yes     | no           | false     | false      | true       | false       | true        |	NO					| NO	  |
      | 15555 | Medica-MAPD-HICN |   33143 | NO              | Miami-Dade County  | MAPD     | Medica HealthCare Plans MedicareMax (HMO)            | HICN     | John      | Doe      | 987456321A1    | false   |  01012010 |  01012010 |                | false    | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | moved outside of the service area                                                                                                                                                                                                                   |                  01012018 | yes     | no           | false     | true       | true       | true        | true        |	NO					| NO	  |
      | 15556 | MAPD-RRID        |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | RRID     | John      | Doe      | rrr012345678   | false   |  01012010 |  01012010 |      631665465 | false    | 01011901 | Male   | 001 Morris Rd | Los Angeles | No                     | 801 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | no           | true      | false      | true       | true        | true        |	NO					| NO	  |
      | 15557 | MAPD-PFFS-MBI    |   85923 | NO              | Navajo County      | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)            | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | None apply                                                                                                                                                                                                                                          |                           | yes     | no           | false     | false      | true       | false       | true        |	NO					| NO	  |
      | 15561 | PDP-HICN         |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | HICN     | John      | Doe      | 121242525p     | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          |	NO					| NO	  |
      | 15562 | PDP-RRID         |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP)                     | RRID     | John      | Doe      | eo981321668    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          |	NO					| NO	  |
      | 15563 | PDP-MBI          |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)                      | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          |	NO					| NO	  |
      | 15572 | DSNP-HICN        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | HICN     | John      | Doe      | 998877665t     | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        |	NO					| NO	  |
      | 15573 | DSNP-RRID        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | RRID     | John      | Doe      | rr000000000    | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        |	NO					| NO	  |
      | 15574 | PCP-DSNP-MBI     |   33143 | NO              | Miami-Dade County  | SNP      | Preferred Medicare Assist (HMO SNP)                  | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                  | 01012018/01012018         | yes     | no           | false     | true       | true       | true        | true        |	NO					| NO	  |

  #-------------------------------------------------------------------------------------------
  #@OLE_Regression_CSNP_Ulayer
  @acquisitionRegression @junerelease2018 @september_release_2018 @december_release_2018 @OLE_PCP_Medica_AARP @MACRAvalidation @OEP_CHANGES
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <PlanType> |
    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
      | Email Confirmation| <emailConfirmation> |
      | Go Green	    | <goGreen>		   |
      | Email                    | <email>  |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page for CSNP and navigates to User and Disclosure plage
      | plan_type      | <plantype>       |
      | MedicaidNumber | <medicaidnumber> |
    Then the user enters provider details in Use and Disclosure Authorization page for CSNP and navidates to Personal information page
      | Provider Name           | <providername>    |
      | Provider Street Address | <provideraddress> |
      | City                    | <providercity>    |
      | Zip                     | <providerzipcode> |
      | Provider Phone Number   | <providernumber>  |
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Review and Submit Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType | zipcode | isMultutiCounty | county       | plantype | planName                                    | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
      | 15558 | CSNP     |   78006 | YES             | Bexar County | CSNP     | UnitedHealthcare Chronic Complete (HMO SNP) | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | true       | true       | true        | true        |	NO					| NO	  |

  @CampaignURL_OLE_Ulayer @acquisitionRegression @FastnFurious
  Scenario Outline: TID: <TID> -plan type: <plantype> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site VPP Plan Summary page after hits Campaign URL
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user validates TFN in Welcome OLE Right Rail
    #Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
      | Email Confirmation| <emailConfirmation> |
      | Go Green	    | <goGreen>		   |
      | Email                    | <email>  |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      | 15547 | MAPD     | AARP MedicareComplete (HMO)     | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     |	NO					| NO	  |
      | 15548 | PDP      | AARP MedicareRx Preferred (PDP) | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     |	NO					| NO	  |

  #-------------------------------------------------------------------------------
  @preliminaryQuestions @spartans @december_release2018
  Scenario Outline: Test to check new question added to ole flow cardiovascular diabeties and chronic heart failure
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
       | Email Confirmation| <emailConfirmation> |
      | Go Green	    | <goGreen>		   |
      | Email                    | <email>  |
    Then the user navigates to Preliminary Questions Page
    Then the user validates the presence for Preliminary Questions on Page
      | Plan Name | <planName> |

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planName                                            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO SNP)         | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      |	NO					| NO	  |
      |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Silver (Regional PPO SNP) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      |	NO					| NO	  |

  #	| 90210   | NO            | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
  #	| 90210		| NO            | Los Angeles County | PDP  | AARP MedicareRx Walgreens (PDP) 	|
  @oleVBF @oleVppUlayerSmoke
  Scenario Outline: OLE Landing from VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
      | Email Confirmation| <emailConfirmation> |
      | Go Green	    | <goGreen>		   |
      | Email                    | <email>  |
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    #Then the user selects the following options for SEP Page
    #      | Select Options | <selectoptions> |
    #      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    And the user clicks on Submit Enrollment to complete enrollment
    Then the user validates Plan and Member Details on Confirmation Page

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      |	NO					| NO	  |

  @OLE_PlanCompare_Aarp
  Scenario Outline: OLE Landing from VPP Plan Compare
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user selects plans to add to plan compare and navigates to Plan compare page
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Compare Page for the following Plan to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          |
      |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
      |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                   |

  @OLE_PlanDetails_Aarp
  Scenario Outline: OLE Landing from VPP Plan Details
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow
    Then the user validates the Plan details on OLE

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          |
      |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
      |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                   |

  @acquisitionRegression @April_release_2019 @Ancillary_Widget @OLE_Regression
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates TFN in Welcome OLE Right Rail
    #Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
      | Email Confirmation| <emailConfirmation> |
      | Go Green	    | <goGreen>		   |
      | Email                    | <email>  |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
   Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then user selects Optional Rider Benfits Dental "<DentalRiderFlag>"or fitness "<FitnessRiderFlag>" Riders
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user Validates Ancillary benfit widget for "<DentalRiderFlag>" "<VisionFlag>" "<FitnessRiderFlag>" and "<HearingFlag>" for selected riders
    Then the user navigates to Review and Submit Page
    Then the user Validates Ancillary benfit widget for "<DentalRiderFlag>" "<VisionFlag>" "<FitnessRiderFlag>" and "<HearingFlag>" for selected riders
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID       | PlanType  | zipcode | isMultutiCounty | county           | plantype | planName                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | DentalRiderFlag | FitnessRiderFlag | emailConfirmation | goGreen |
      | US1644081 | MAPD-HICN |   95682 | NO              | El Dorado County | MAPD     | AARP MedicareComplete SecureHorizons (HMO) | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | false      | true       | false       | true        | true            | true             |	NO					| NO	  |

  @Feb_release_2019 @StandaloneAARP
  Scenario Outline: Verify Zip code serch from Standlaone zipcode to OLE
    Given the user is on AARP medicare acquisition site landing page
    And the user hovers screen over the shop for a plan drop down in AARP
    And click on Enroll Plan on shop for plan for AARP
    And click on Learn how to enroll plan on enroll page for AARP
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    When the user performs plan search using Standalone Zipcode information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user validates the Plan details on OLE
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    #Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
      | Email Confirmation| <emailConfirmation> |
      | Go Green	    | <goGreen>		   |
      | Email                    | <email>  |
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Review and Submit Page
    Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType | zipcode | isMultutiCounty | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
      | 15513 | MA-HICN  |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | false      | true       | true        | true        |	NO					| NO	  |
      | 15515 | MA-MBI   |   80002 | YES             | Adams County       | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | false      | true       | true        | true        |	NO					| NO	  |
      | 15517 | PDP-RRID |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP)                     | RRID     | John      | Doe      | eo981321668    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          |	NO					| NO	  |
      | 15518 | PDP-MBI  |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)                      | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          |	NO					| NO	  |

    @oleProdAARP
    Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Prod flow without submission
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    #Then the user selects the following options for SEP Page
    #      | Select Options | <selectoptions> |
    #      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      |	NO					| NO	  |

 
  @oleVppUlayerSmoke_VBF @vbfGate
  Scenario Outline: OLE Landing from VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Informations
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
      | Email Confirmation| <emailConfirmation> |
      | Go Green	    | <goGreen>		   |
      | Email                    | <email>  |
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Pages
      | MedicaidNumber | <medicaidnumber> |
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user navigates to SEP Page
    Then the user navigates to Coverage and Health Information Page
        Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    And the user clicks on Submit Enrollment to complete enrollment
    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | NO     | NO          | true      |	NO					| NO	  |

  @acquisitionRegression @junerelease2018 @september_release_2018 @december_release_2018 @OLE_PCP_Medica_AARP @MACRAvalidation @OEP_CHANGES @OLE_Regression_Ulayer
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
   Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Review and Submit Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    #Then the user validates Plan and Member Details on Confirmation Page
   # Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType         | zipcode | isMultutiCounty | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
      | 15558 | MA-HICN          |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | false      | true       | true        | true        | NO                | NO      |
      | 15559 | MA-RRID          |   80002 | YES             | Adams County       | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | RRID     | John      | Doe      | AAA998877665   | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | true      | false      | true       | true        | true        | NO                | NO      |
      | 15560 | MA-PFFS-MBI      |   85923 | NO              | Navajo County      | MA       | UnitedHealthcare MedicareDirect Essential (PFFS)     | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text         | yes     | no           | false     | false      | true       | false       | true        | NO                | NO      |
      | 15555 | Medica-MAPD-HICN |   33143 | NO              | Miami-Dade County  | MAPD     | Medica HealthCare Plans MedicareMax (HMO)            | HICN     | John      | Doe      | 987456321A1    | false   |  01012010 |  01012010 |                | false    | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | moved outside of the service area                                                                                                                                                                                                                   |                  01012018 | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15556 | MAPD-RRID        |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | RRID     | John      | Doe      | rrr012345678   | false   |  01012010 |  01012010 |      631665465 | false    | 01011901 | Male   | 001 Morris Rd | Los Angeles | No                     | 801 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | no           | true      | false      | true       | true        | true        | NO                | NO      |
      | 15557 | MAPD-PFFS-MBI    |   85923 | NO              | Navajo County      | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)            | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | None apply                                                                                                                                                                                                                                          |                           | yes     | no           | false     | false      | true       | false       | true        | NO                | NO      |
      | 15561 | PDP-HICN         |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | HICN     | John      | Doe      | 121242525p     | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15562 | PDP-RRID         |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP)                     | RRID     | John      | Doe      | eo981321668    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15563 | PDP-MBI          |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)                      | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15572 | DSNP-HICN        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | HICN     | John      | Doe      | 998877665t     | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15573 | DSNP-RRID        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | RRID     | John      | Doe      | rr000000000    | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15574 | PCP-DSNP-MBI     |   33143 | NO              | Miami-Dade County  | SNP      | Preferred Medicare Assist (HMO SNP)                  | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                  | 01012018/01012018         | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |

  @2020Plans_OLE_AARP
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary for 2020 Plans
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
   Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Review and Submit Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    #Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType         | zipcode | isMultutiCounty | county             | plantype | planName                                               | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email                       | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
      | 15558 | MA-HICN          |   80210 | NO              | Denver County      | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | sneha.dwarakanath@optum.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | true      | false      | true       | true        | true        | NO                | NO      |
      | 15559 | MA-RRID          |   80002 | YES             | Adams County       | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | sneha.dwarakanath@optum.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | true      | false      | true       | true        | true        | NO                | NO      |
      | 15560 | MA-PFFS-MBI      |   85923 | NO              | Navajo County      | MA       | UnitedHealthcare MedicareDirect Essential (PFFS)       | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | sneha.dwarakanath@optum.com | Other reason                                                                                                                                                                                                                                        | other reason text         | yes     | no           | false     | false      | true       | false       | true        | NO                | NO      |
      | 15555 | Medica-MAPD-HICN |   33143 | NO              | Miami-Dade County  | MAPD     | Medica HealthCare Plans MedicareMax (HMO)              | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |                | false    | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | sneha.dwarakanath@optum.com | moved outside of the service area                                                                                                                                                                                                                   |                  01012018 | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15556 | MAPD-RRID        |   80210 | NO              | Denver County      | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)    | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      631665465 | false    | 01011901 | Male   | 001 Morris Rd | Los Angeles | No                     | 801 MailingSt | Mailing LA  | CA           |      90210 | sneha.dwarakanath@optum.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | no           | false     | false      | true       | true        | true        | NO                | NO      |
      | 15557 | MAPD-PFFS-MBI    |   85923 | NO              | Navajo County      | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)              | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | sneha.dwarakanath@optum.com | None apply                                                                                                                                                                                                                                          |                           | yes     | no           | false     | false      | true       | false       | true        | NO                | NO      |
      | 15561 | PDP-HICN         |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                        | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | sneha.dwarakanath@optum.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15562 | PDP-RRID         |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP)                       | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | sneha.dwarakanath@optum.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15563 | PDP-MBI          |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)                        | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | sneha.dwarakanath@optum.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15572 | DSNP-HICN        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)         | MBI      | John      | Doe      | 3A33C22YK22    | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | sneha.dwarakanath@optum.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15573 | DSNP-RRID        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete RP (Regional PPO D-SNP) | MBI      | John      | Doe      | 2n22C33YK33    | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | sneha.dwarakanath@optum.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15574 | PCP-DSNP-MBI     |   33143 | NO              | Miami-Dade County  | SNP      | Preferred Medicare Assist (HMO D-SNP)                  | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | sneha.dwarakanath@optum.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                  | 01012018/01012018         | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |

  #-------------------------------------------------------------------------------------------
  #@OLE_Regression_CSNP_Ulayer
  @acquisitionRegression @junerelease2018 @september_release_2018 @december_release_2018 @OLE_PCP_Medica_AARP @MACRAvalidation @OEP_CHANGES
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <PlanType> |
    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page for CSNP and navigates to User and Disclosure plage
      | plan_type      | <plantype>       |
      | MedicaidNumber | <medicaidnumber> |
    Then the user enters provider details in Use and Disclosure Authorization page for CSNP and navidates to Personal information page
      | Provider Name           | <providername>    |
      | Provider Street Address | <provideraddress> |
      | City                    | <providercity>    |
      | Zip                     | <providerzipcode> |
      | Provider Phone Number   | <providernumber>  |
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Review and Submit Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    #Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType | zipcode | isMultutiCounty | county       | plantype | planName                                    | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | providername | provideraddress | providercity | providerzipcode | providernumber | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
      | 15558 | CSNP     |   78006 | YES             | Bexar County | CSNP     | UnitedHealthcare Chronic Complete (HMO SNP) | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | John         | address of prov | Palmer       |           99645 |     1231231234 | true       | true       | true        | true        | NO                | NO      |

  @acquisitionRegression @FastnFurious @Flow_from_Cmpgn_Page
  Scenario Outline: TID: <TID> -plan type: <plantype> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site VPP Plan Summary page after hits Campaign URL
    And the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user validates PCP page for MA and MAPD PFFS plans
   Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    #Then the user validates Plan and Member Details on Confirmation Page
    #Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | plantype | planName                        | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      | 15547 | MAPD     | AARP MedicareComplete (HMO)     | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |
      | 15548 | PDP      | AARP MedicareRx Preferred (PDP) | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |

  #-------------------------------------------------------------------------------
  @preliminaryQuestions @spartans @december_release2018
  Scenario Outline: Test to check new question added to ole flow cardiovascular diabeties and chronic heart failure
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user navigates to Preliminary Questions Page
    Then the user validates the presence for Preliminary Questions on Page
      | Plan Name | <planName> |

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planName                                            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO SNP)         | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      | NO                | NO      |
      |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Silver (Regional PPO SNP) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      | NO                | NO      |

  #	| 90210   | NO            | Los Angeles County | MA	  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
  #	| 90210		| NO            | Los Angeles County | PDP  | AARP MedicareRx Walgreens (PDP) 	|
  @oleVBF @oleVppUlayerSmoke
  Scenario Outline: OLE Landing from VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    #Then the user selects the following options for SEP Page
    #      | Select Options | <selectoptions> |
    #      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    And the user clicks on Submit Enrollment to complete enrollment
    Then the user validates Plan and Member Details on Confirmation Page

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      | NO                | NO      |

  @OLE_PlanCompare_Aarp
  Scenario Outline: OLE Landing from VPP Plan Compare
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user selects plans to add to plan compare and navigates to Plan compare page
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Compare Page for the following Plan to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          |
      |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
      |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                   |

  @OLE_PlanDetails_Aarp
  Scenario Outline: OLE Landing from VPP Plan Details
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow
    Then the user validates the Plan details on OLE

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          |
      |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
      |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                   |

  @acquisitionRegression @April_release_2019 @Ancillary_Widget @OLE_Regression
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates TFN in Medicare Info OLE Right Rail
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then user selects Optional Rider Benfits Dental "<DentalRiderFlag>"or fitness "<FitnessRiderFlag>" Riders
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user Validates Ancillary benfit widget for "<DentalRiderFlag>" "<VisionFlag>" "<FitnessRiderFlag>" and "<HearingFlag>" for selected riders
    Then the user navigates to Review and Submit Page
    Then the user Validates Ancillary benfit widget for "<DentalRiderFlag>" "<VisionFlag>" "<FitnessRiderFlag>" and "<HearingFlag>" for selected riders
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID       | PlanType  | zipcode | isMultutiCounty | county           | plantype | planName                                   | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | DentalRiderFlag | FitnessRiderFlag | emailConfirmation | goGreen |
      | US1644081 | MAPD-HICN |   95682 | NO              | El Dorado County | MAPD     | AARP MedicareComplete SecureHorizons (HMO) | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | false      | true       | false       | true        | true            | true             | NO                | NO      |

  @Feb_release_2019 @StandaloneAARP
  Scenario Outline: Verify Zip code serch from Standlaone zipcode to OLE
    Given the user is on AARP medicare acquisition site landing page
    And the user hovers screen over the shop for a plan drop down in AARP
    And click on Enroll Plan on shop for plan for AARP
    And click on Learn how to enroll plan on enroll page for AARP
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    When the user performs plan search using Standalone Zipcode information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user validates the Plan details on OLE
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Medicare Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user validates the Plan details in Preliminary Questions Pag OLE Right Rail
    Then the user navigates to Personal Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates SEP options and Required Fields for PlanType in SEP Page
    Then the user selects the following options for SEP Page
      | Select Options | <selectoptions> |
      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates PCP page for MA and MAPD PFFS plans
    Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user navigates to Review and Submit Page
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
    Then the user validates the Plan and Member details on Review and Submit Page
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user validates Plan and Member Details on Confirmation Page
    Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType | zipcode | isMultutiCounty | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
      | 15513 | MA-HICN  |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | true      | false      | true       | true        | true        | NO                | NO      |
      | 15515 | MA-MBI   |   80002 | YES             | Adams County       | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | false      | true       | true        | true        | NO                | NO      |
      | 15517 | PDP-RRID |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP)                     | RRID     | John      | Doe      | eo981321668    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15518 | PDP-MBI  |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)                      | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |

  @oleProdAARP
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from AARP Prod flow without submission
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    Then the user navigates to Medicare Information Page
    Then the user validates Medicare Information Page required fields
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Page
      | MedicaidNumber | <medicaidnumber> |
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user validates the Plan details in Personal Information Page OLE Right Rail
    Then the user validates the Member details dynamic display in Personal Information Page
    Then the user navigates to SEP Page
    #Then the user validates SEP options and Required Fields for PlanType in SEP Page
    #Then the user selects the following options for SEP Page
    #      | Select Options | <selectoptions> |
    #      | Option Data    | <optiondata>    |
    Then the user navigates to Coverage and Health Information Page
    Then the user validates the dispalyed sections for the Plan Type in Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user validates Proposed Effective Date is Displayed
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      | NO                | NO      |

  @oleVppUlayerSmoke_VBF @vbfGate
  Scenario Outline: OLE Landing from VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Informations
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Pages
      | MedicaidNumber | <medicaidnumber> |
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user navigates to SEP Page
    Then the user navigates to Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    And the user clicks on Submit Enrollment to complete enrollment

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   90210 | NO              | Los Angeles County | MAPD     |AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | NO      | NO           | true      | NO                | NO      |


  @oleVppUlayerCurrentYrSmoke
  Scenario Outline: OLE Landing from VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |     
    Then the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Informations
      | First Name         | <firstname>         |
      | Last Name          | <lastname>          |
      | Medicare Number    | <medicarenumber>    |
      | SSN Flag           | <ssnflag>           |
      | PartA Date         | <partadate>         |
      | PartB Date         | <partbdate>         |
      | Card Type          | <cardtype>          |
      | Email Confirmation | <emailConfirmation> |
      | Go Green           | <goGreen>           |
      | Email              | <email>             |
    Then the user navigates to Preliminary Questions Page
    Then the user validates requierd fields for Preliminary Questions Pages
      | MedicaidNumber | <medicaidnumber> |
    Then the user navigates to Personal Information Page
    Then the user enters following required information in Personal Information Page
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
    Then the user navigates to SEP Page
    Then the user navigates to Coverage and Health Information Page
    Then the user answers following questions in Coverage and Health Information Page
      | PDP Question      | <pdpFlag>      |
      | LongTerm Question | <longTermFlag> |
    Then the user navigates to Proposed Effective Date Page
    Then the user navigates to PCP Page and validates PCP page is not displayed for PDP
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    And the user clicks on Submit Enrollment to complete enrollment

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   90210 | NO              | Los Angeles County | MAPD     |AARP MedicareComplete SecureHorizons Plan 1 (HMO) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | NO      | NO           | true      | NO                | NO      |
      

