@fastandfurious @OLE @OLE_UHC
Feature: 2.05-VBF-ACQ-To test OLE common tool flow flow UMS site

  @junerelease2018 @september_release_2018 @december_release_2018 @OLE_PCP_Medica_UHC @OEP_CHANGES
  Scenario Outline: TID: <TID> - plan type: <PlanType> - OLE Landing from UHC Acquisition site VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
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
    Then the user validates the Plan details in Medicare Info OLE Right Rail
    Then the user navigates to Preliminary Questions Page
    ##Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
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
    Then the user validates the Plan details in SEP Page OLE Right Rail
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
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
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
#    Then the user validates Plan and Member Details on Confirmation Page
 #   Then the user Validates Next Steps in Confirmation Page for the Plan Type.

    Examples: 
      | TID   | PlanType         | zipcode | isMultutiCounty | county             | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
      | 15513 | MA-HICN          |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | false      | true       | true        | true        | NO                | NO      |
      | 15514 | MA-PFFS-RRID     |   85923 | NO              | Navajo County      | MA       | UnitedHealthcare MedicareDirect Essential (PFFS)     | RRID     | John      | Doe      | AAA998877665   | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text         | yes     | no           | false     | false      | true       | false       | true        | NO                | NO      |
      | 15515 | MA-MBI           |   80002 | YES             | Adams County       | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | true      | false      | true       | true        | true        | NO                | NO      |
      | 15493 | MAPD-PFFS-HICN   |   85923 | NO              | Navajo County      | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)            | HICN     | John      | Doe      | 987456321A1    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | None apply                                                                                                                                                                                                                                          |                           | yes     | no           | false     | false      | true       | false       | true        | NO                | NO      |
      | 15496 | PCP-MAPD-RRID    |   33143 | NO              | Miami-Dade County  | MAPD     | Preferred Choice Dade (HMO)                          | RRID     | John      | Doe      | rrr012345678   | false   |  01012010 |  01012010 |                | false    | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | moved outside of the service area                                                                                                                                                                                                                   |                  01012018 | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15497 | MAPD-MBI         |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      631665465 | false    | 01011901 | Male   | 001 Morris Rd | Los Angeles | No                     | 801 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | no           | true      | false      | true       | true        | true        | NO                | NO      |
      | 15516 | PDP-HICN         |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | HICN     | John      | Doe      | 121242525p     | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15517 | PDP-RRID         |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP)                     | RRID     | John      | Doe      | eo981321668    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15518 | PDP-MBI          |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)                      | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15575 | Medica-DSNP-HICN |   33143 | NO              | Miami-Dade County  | SNP      | Medica HealthCare Plans MedicareMax Plus (HMO SNP)   | HICN     | John      | Doe      | 998877665t     | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                  | 01012018/01012018         | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15576 | DSNP-RRID        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | RRID     | John      | Doe      | rr000000000    | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15577 | DSNP-MBI         |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)             | MBI      | John      | Doe      | 2n22C33YK33    | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |

@2020Plans_OLE_UHC
  Scenario Outline: TID: <TID> - plan type: <PlanType> - OLE Landing from UHC Acquisition site VPP Plan Summary for 2020 plans
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
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
    Then the user validates the Plan details in SEP Page OLE Right Rail
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
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
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
      | TID   | PlanType         | zipcode | isMultutiCounty | county             | plantype | planName                                               | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata                | pdpFlag | longTermFlag | riderflag | DentalFlag | VisionFlag | FitnessFlag | HearingFlag | emailConfirmation | goGreen |
      | 15558 | MA-HICN          |   80210 | NO              | Denver County      | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | true      | false      | true       | true        | true        | NO                | NO      |
      | 15559 | MA-RRID          |   80002 | YES             | Adams County       | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | true      | false      | true       | true        | true        | NO                | NO      |
      | 15560 | MA-PFFS-MBI      |   85923 | NO              | Navajo County      | MA       | UnitedHealthcare MedicareDirect Essential (PFFS)       | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Other reason                                                                                                                                                                                                                                        | other reason text         | yes     | no           | false     | false      | true       | false       | true        | NO                | NO      |
      | 15555 | Medica-MAPD-HICN |   33143 | NO              | Miami-Dade County  | MAPD     | Medica HealthCare Plans MedicareMax (HMO)              | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |                | false    | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | moved outside of the service area                                                                                                                                                                                                                   |                  01012018 | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15556 | MAPD-RRID        |   80210 | NO              | Denver County      | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)    | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      631665465 | false    | 01011901 | Male   | 001 Morris Rd | Los Angeles | No                     | 801 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / / | yes     | no           | false     | false      | true       | true        | true        | NO                | NO      |
      | 15557 | MAPD-PFFS-MBI    |   85923 | NO              | Navajo County      | MAPD     | UnitedHealthcare MedicareDirect Rx (PFFS)              | MBI      | John      | Doe      | 3A33C22YK22    | false   |  01012010 |  01012010 |      231665465 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | None apply                                                                                                                                                                                                                                          |                           | yes     | no           | false     | false      | true       | false       | true        | NO                | NO      |
      | 15561 | PDP-HICN         |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                        | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15562 | PDP-RRID         |   80210 | NO              | Denver County      | PDP      | AARP MedicareRx Saver Plus (PDP)                       | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15563 | PDP-MBI          |   80002 | YES             | Adams County       | PDP      | AARP MedicareRx Preferred (PDP)                        | MBI      | John      | Doe      | 3A33C22YK22    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | NA         | NA         | NA          | NA          | NO                | NO      |
      | 15572 | DSNP-HICN        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)         | MBI      | John      | Doe      | 3A33C22YK22    | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15573 | DSNP-RRID        |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete RP (Regional PPO D-SNP) | MBI      | John      | Doe      | 2n22C33YK33    | true    |  01012010 |  01012010 |     0523456789 | true     | 01011904 | Female | 004 Morris Rd | Los Angeles | Yes                    | 803 MailingSt | Mailing LA  | CA           |      78006 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / /   | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |
      | 15574 | PCP-DSNP-MBI     |   33143 | NO              | Miami-Dade County  | SNP      | Preferred Medicare Assist (HMO D-SNP)                    | MBI      | John      | Doe      | 2n22C33YK33    | false   |  01012010 |  01012010 |     0123456789 | true     | 01011941 | Female | 123 Perm Rd   | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area                                                                                                                                                                                                  | 01012018/01012018         | yes     | no           | false     | true       | true       | true        | true        | NO                | NO      |


  @Flow_From_cmp_Page @acquisitionRegression @FastnFurious
  Scenario Outline: TID: <TID> -plan type: <plantype> - OLE End to end from UHC Acquisition site VPP Plan Summary
    Given the user is on UHC medicare acquisition site VPP Plan Summary page after hits Campaign URL
    When user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
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
    Then the user validates the Plan details in SEP Page OLE Right Rail
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
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
    Then the user navigates to Monthly Plan Premium Page
    Then the user navigates to Optional Benefits Page for following plans with available Riders
      | Rider Flag | <riderflag> |
    Then the user navigates to Authorization Page for plan as per following rider options
      | Rider Flag | <riderflag> |
    Then the user validates required fields for Authorization Page
    Then the user navigates to Review and Submit Page
    Then the user validates the Plan and Member details on Review and Submit Page
    #Then the user clicks on Submit Enrollment to complete enrollment
    #Then the user validates Plan and Member Details on Confirmation Page

    Examples: 
      | TID   | plantype | planName                                             | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet    | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                                                                                                                                                                                                                       | optiondata              | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      | 15564 | MAPD     | AARP MedicareComplete SecureHorizons Essential (HMO) | HICN     | John      | Doe      | 987456321BB    | false   |  01012010 |  01012010 |      431665465 | true     | 01011903 | Male   | 003 Morris Rd | Los Angeles | Yes                    |               |             | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |
      | 15565 | PDP      | AARP MedicareRx Saver Plus (PDP)                     | MBI      | John      | Doe      | eo981321668    | false   |  11012015 |  11012015 |                | false    | 01011902 | Female | 002 Morris Rd | Los Angeles | Yes                    | 802 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | Medicare Advantage Open Enrollment Period (MA OEP)/change in my Medicaid (newly got Medicaid)/Medicare (or my state)/(or my state helps pay for my Medicare premiums)/major disaster (as declared by the Federal Emergency Management Agency (FEMA) | /12202018/12202018/ / / | yes     | no           | false     | NO                | NO      |

  #---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  @NegativeValidations_MedicareInfoPage
  Scenario Outline: OLE Negative Validations for Required Fields
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
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
    Then the user validates error messages for Negative values and required fields on Medicare Info Page

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname          | lastname | medicarenumber | ssnflag | partadate | partbdate | emailConfirmation | goGreen |
      |   90210 | YES             | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) | HICN     |                 34 |          |       12345679 | false   | aisu323   |  01012020 | NO                | NO      |
      |   28035 | NO              | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO SNP)          | MBI      | Jo                 | Jo       |                | true    | 321651465 |  01012010 | NO                | NO      |
      |   90210 | YES             | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                   | HICN     | )089$              | Doe      | 2A22C22YK22    | false   |  12042020 | aisu323   | NO                | NO      |
      |   35045 | NO              | Chilton County     | SNP      | UnitedHealthcare Dual Complete (HMO SNP)          | MBI      | asdassdfsadfsdfsdf |    99898 | 123456789a     | false   |  01012010 |  01012010 | NO                | NO      |

  @OLE_PlanDetails_UHC
  Scenario Outline: OLE Landing from UHC Acquisition site VPP Plan Details
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site vpp
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow
    Then the user validates the Plan details on OLE

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          |
      |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |
      |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                   |
      |   35045 | YES             | Chilton County     | SNP      | UnitedHealthcare Dual Complete (HMO SNP)          |

  @OLE_PlanCompare_UHC
  Scenario Outline: OLE Landing from UHC Acuisition site VPP Plan Compare
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user selects plans to add to plan compare and navigates to Plan compare page in UHC site
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Compare Page for the following Plan to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          |
      |   90210 | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |
      |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                   |

  @DSNP_Enroll_Now @september_release_2018
  Scenario Outline: To test OLE Button for DSNP Plans Landing from VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search TeamC using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user validates the Enroll Now Button present for the plan type
      | Plan Name | <planName> |

    Examples: 
      | zipcode | county       | plantype | planName                                             |
      |   28105 | Union County | SNP      | UnitedHealthcare Dual Complete RP (Regional PPO SNP) |

  @CSNP_Enroll_Now @december_18
  Scenario Outline: To test OLE Button for CSNP Plans Landing from VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search TeamC using following information in UMS site
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user validates the Enroll Now Button present for the plan type
      | Plan Name | <planName> |

    Examples: 
      | zipcode | plantype | planName                                            |
      |   73301 | SNP      | UnitedHealthcare Medicare Silver (Regional PPO SNP) |

  @UHC_Disclosure @december_18
  Scenario Outline: To test Disclosure page for Chronic Plans Landing from VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search TeamC using following information in UMS site
      | Zip Code    | <zipcode> |
      | County Name | <county>  |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user validates the Enroll Now Button present for the Chronic plan type
      | Plan Name | <planName> |
    Then the user navigates to Medicare Information Page
    Then the user enters following required Medicare Information
      | First Name      | <firstname>      |
      | Last Name       | <lastname>       |
      | Medicare Number | <medicarenumber> |
      | SSN Flag        | <ssnflag>        |
      | PartA Date      | <partadate>      |
      | PartB Date      | <partbdate>      |
      | Card Type       | <cardtype>       |
    Then the user navigates to Diabetic Preliminary Questions Page
    Then the user navigates to Use and Disclosure Page

    Examples: 
      | zipcode | county         | plantype | planName                                    | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate |
      |   78006 | Kendall County | SNP      | UnitedHealthcare Chronic Complete (HMO SNP) | HICN     | John      | Doe      | 987456321t     | false   |  01012010 |  01012010 |

  #-------------------
  @preliminaryQuestion @spartans @december_release2018
  Scenario Outline: Test to check new question added to ole flow cardiovascular diabeties and chronic heart failure in UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    #Then the user validates the Plan details on OLE
    Then the user navigates to Medicare Information Page
    #Then the user validates Medicare Information Page required fields
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
    Then the user validates the presence for Preliminary Questions on Page
      | Plan Name | <planName> |

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planName                                            | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Chronic Complete (HMO SNP)         | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      | NO                | NO      |
      |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Medicare Silver (Regional PPO SNP) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | yes          | true      | NO                | NO      |

  @oleVBF @oleVppBlayerSmoke
  Scenario Outline: OLE Landing from UHC Acquisition site VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on UHC
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
    #Then the user validates the Plan details in SEP Page OLE Right Rail
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
    Then the user clicks on Submit Enrollment to complete enrollment
    Then the user validates Plan and Member Details on Confirmation Page

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | HICN     | John      | Doe      | 123456787t     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | true      | NO                | NO      |

  @acquisitionRegression @April_release_2019 @Ancillary_Widget @OLE_Regression
  Scenario Outline: TID: <TID> -plan type: <PlanType> - OLE End to end from UHC Acquisition site VPP Plan Summary for Anciallry Widget
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
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
    Then the user validates the Plan details in SEP Page OLE Right Rail
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
    #Then the user validates Look up Provider for MA MAPD and DSNP plans.
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

  @Feb_release_2019 @StandaloneUHC
  Scenario Outline: Verify Zip code serch from Standlaone zipcode to OLE
    Given the user is on the uhcmedicaresolutions site landing page
    And the user hovesr screen over the shop for a plan drop down
    And click on Enroll Plan on shop for plan
    And click on Learn how to enroll plan on enroll page
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    When the user performs plan search using Standalone Zipcode information in the UHC site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user validates the Plan details on OLE
    #Then the user Validates Ancillary benfit widget for "<DentalFlag>" "<VisionFlag>" "<FitnessFlag>" and "<HearingFlag>"
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

  @oleProdUHC
  Scenario Outline: TID: <TID> - plan type: <PlanType> - OLE from VPP flow for Prod without submission
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
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
    #Then the user validates the Plan details in SEP Page OLE Right Rail
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
      |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | HICN     | John      | Doe      | 123456787t     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | true      | NO                | NO      |

  @oleVppBlayerSmoke_VBF @vbfGate
  Scenario Outline: OLE Landing from UHC Acquisition site VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
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
    Then the user clicks on Submit Enrollment to complete enrollment

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) | HICN     | John      | Doe      | 987654333C     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | NO      | NO           | true      | NO                | NO      |

  @oleVppBlayerCurrentYrSmoke
  Scenario Outline: OLE Landing from UHC Acquisition site VPP Plan Summary
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
   When user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
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
    Then the user clicks on Submit Enrollment to complete enrollment

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                          | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |
      |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | MBI     | John      | Doe      | 3A33C22YK22     | false   |  01012010 |  01012010 |      231665465 | false    | 01011941 | Female | 123 Perm Rd | Los Angeles | No                     | 876 MailingSt | Mailing LA  | CA           |      90210 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | NO      | NO           | true      | NO                | NO      |
      
