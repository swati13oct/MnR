Feature: 1.05.4.ACQ-OLE common tool flow E2E SNP AARP Mobile

 @SNP_OLE_Mobile @prod
  Scenario Outline: TID: <TID> - Plan Type: <plantype> - OLE SNP End to end from Acquisition site VPP Plan Summary
    Given the user is on AARP medicare acquisition site landing page

    
    Examples: 
     # | TID   | zipcode | isMultiCounty | county           | plantype | planyear |
     # | 00001 |   78006 | YES           | Bexar County     | SNP      | current  |
     | TID   | PlanType     | Plan Year|planYear|zipcode | isMultutiCounty | county            | plantype | planName                              | cardtype | firstname | lastname | medicarenumber | ssnflag | partadate | partbdate | medicaidnumber | esrdflag | dob      | gender | permstreet  | permcity    | mailingaddressquestion | mailingstreet | mailingcity | mailingstate | mailingzip | email         | selectoptions                                      | optiondata        | pdpFlag | longTermFlag | riderflag | emailConfirmation | goGreen |healthinsurancename|groupnumber| membernumber|prescriptioncoveragename|pdgroupnumber|pdmembernumber|inputdataType|
     | 15574 | PCP-DSNP-MBI |  current |current | 33143 | NO              | Miami-Dade County | SNP      | Preferred Medicare Assist Plan 2 (HMO D-SNP) | MBI      | GOTTFRIED | GARRAND     | 5N69QY6ET34    | false|   09011997 |  11012002 |     0123456789 | true     | 04261944 | Female | 123 Perm Rd | Los Angeles | Yes                    | 876 MailingSt | Mailing LA  | FL           |      33143 | test@test.com | losing coverage/ moved outside of the service area | 01012018/01012018 | yes     | no           | false     | NO                | NO      |HealthInsurance             |HI1562759    | ABC12345DEF     |PrescriptionCoverage            |PD5646136   | BCD12345EFG |Valid|
 		
