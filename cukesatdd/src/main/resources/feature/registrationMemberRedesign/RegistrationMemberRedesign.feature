@registrationRedesign @Gladiators
Feature: To test registration flow in redesign portal

  Scenario Outline: To verify member is navigated to the registeration plan Information page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then member will be navigated to registration plan information page
    And Verify correct plan name is displayed
      | Plan name | <planname> |

    Examples: 
      | Plantype           | planMemberId | dateOfBirth | planname                                             |
    #team-h and dev-c
      | MAPD COSMOS     | 930096952    | 08-05-1950  | AARP MedicareComplete Choice (PPO)| AAEDBF DAADCDAFA |
     # | MAPD COSMOS        | 935442812    | 03-03-1952  | UnitedHealthcare MedicareComplete Plan 1 (HMO)       |
      #| MA NICE            | 001605069    | 09-06-1935  | AARP MedicareComplete SecureHorizons Essential (HMO) |
      #| MA COSMOS          | 944089527    | 09-16-1945  | AARP MedicareComplete Essential (HMO)                |
      #| MAPD NICE          | 006916255    | 08-13-1931  | Sharp SecureHorizons Plan by UnitedHealthcare (HMO)  |
      # | PDP                | 0018651611   | 05-20-1935  | AARP MedicareRx Preferred (PDP)                      |
      #team-h and dev-c
      #| PCP                | 949291584    | 02-17-1952  | Preferred Choice Palm Beach (HMO)                    |
     # | MEDICA             | 954480470    | 03-01-1952  | Medica HealthCare Plans MedicareMax (HMO)            |
     # | SHIP/MED SUPP      | 365348555-11 | 03-01-1949  | AARP MEDICARE SUPPLEMENT PLAN                        |
     # | 50-64              | 375682722-11 | 03-01-1964  | AARP PERSONAL HEALTH INSURANCE COMPREHENSIVE PLAN    |
     # | SHIP MedSupp + PDP | 1011277011   | 05-13-1929  | AARP MedicareRx Saver Plus (PDP)                     |
     # | SHIP MedSupp + PDP | 101127701-11 | 05-13-1929  | AARP MEDICARE SUPPLEMENT PLAN                        |
     #team-h and dev-c
     # | SHIP 50-64 + MA    | 006880152    | 05-09-1934  | AARP MedicareComplete SecureHorizons Essential (HMO) |
      #| SHIP 50-64 + MA    | 006880152-11 | 05-09-1934  | AARP GROUP HOSPITAL PLAN                             |
     # | SHIP 50-64 + MAPD  | 006969409    | 03-16-1953  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
     # | SHIP 50-64 + MAPD  | 006969409-11 | 03-16-1953  | AARP GROUP HOSPITAL PLAN                             |
     # | SHIP 50-64 + PDP   | 1012231271   | 10-28-1942  | AARP MedicareRx Preferred (PDP)                      |
      #| SHIP 50-64 + PDP   | 101223127-11 | 10-28-1942  | AARP GROUP HOSPITAL PLAN                             |
      #| Group MAPD NICE    | 007399823    | 05-18-1946  | UnitedHealthcare Group Medicare Advantage (HMO)      |
     # | Group MAPD COSMOS  | 927159089    | 06-21-1923  | UnitedHealthcare Group Medicare Advantage (PPO)      |
     # | Group MA COSMOS    | 968438341    | 01-04-1918  | UnitedHealthcare Group Medicare Advantage (PPO)      |
     # | Group MA NICE      | 004145183    | 01-20-1923  | UnitedHealthcare Group Medicare Advantage (HMO)      |
     # | Group SSUP         | 975499851    | 11-12-1930  | UnitedHealthcare Senior Supplement                   |
     # | Group SSRD         | 915897367    | 10-13-1946  | UnitedHealthcare Senior Supplement                   |
     # | Group PDP          | 0130686931   | 03-12-1948  | UnitedHealthcare MedicareRx for Groups (PDP)         |
