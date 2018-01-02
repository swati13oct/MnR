@registrationRedesign
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
      | MAPD COSMOS        | 935442812    | 03-03-1952  | UnitedHealthcare MedicareComplete Plan 1 (HMO)       |
      | MA NICE            | 001605069    | 09-06-1935  | AARP MedicareComplete SecureHorizons Essential (HMO) |
      | MA COSMOS          | 944089527    | 09-16-1945  | AARP MedicareComplete Essential (HMO)                |
      | MAPD NICE          | 006916255    | 08-13-1931  | Sharp SecureHorizons Plan by UnitedHealthcare (HMO)  |
      | PDP                | 0018651611   | 05-20-1935  | AARP MedicareRx Preferred (PDP)                      |
      | PCP                | 949291584    | 02-17-1952  | Preferred Choice Palm Beach (HMO)                    |
      | MEDICA             | 954480470    | 03-01-1952  | Medica HealthCare Plans MedicareMax (HMO)            |
      | SHIP/MED SUPP      | 365348555-11 | 03-01-1949  | AARP MEDICARE SUPPLEMENT PLAN                        |
      | 50-64              | 375682722-11 | 03-01-1964  | AARP PERSONAL HEALTH INSURANCE COMPREHENSIVE PLAN    |
      | SHIP MedSupp + PDP | 1011277011   | 05-13-1929  | AARP MedicareRx Saver Plus (PDP)                     |
      | SHIP MedSupp + PDP | 101127701-11 | 05-13-1929  | AARP MEDICARE SUPPLEMENT PLAN                        |
      | SHIP 50-64 + MA    | 006880152    | 05-09-1934  | AARP MedicareComplete SecureHorizons Essential (HMO) |
      | SHIP 50-64 + MA    | 006880152-11 | 05-09-1934  | AARP GROUP HOSPITAL PLAN                             |
      | SHIP 50-64 + MAPD  | 006969409    | 03-16-1953  | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    |
      | SHIP 50-64 + MAPD  | 006969409-11 | 03-16-1953  | AARP GROUP HOSPITAL PLAN                             |
      | SHIP 50-64 + PDP   | 1012231271   | 10-28-1942  | AARP MedicareRx Preferred (PDP)                      |
      | SHIP 50-64 + PDP   | 101223127-11 | 10-28-1942  | AARP GROUP HOSPITAL PLAN                             |
      | Group MAPD NICE    | 007399823    | 05-18-1946  | UnitedHealthcare Group Medicare Advantage (HMO)      |
      | Group MAPD COSMOS  | 927159089    | 06-21-1923  | UnitedHealthcare Group Medicare Advantage (PPO)      |
      | Group MA COSMOS    | 968438341    | 01-04-1918  | UnitedHealthcare Group Medicare Advantage (PPO)      |
      | Group MA NICE      | 004145183    | 01-20-1923  | UnitedHealthcare Group Medicare Advantage (HMO)      |
      | Group SSUP         | 975499851    | 11-12-1930  | UnitedHealthcare Senior Supplement                   |
      | Group SSRD         | 915897367    | 10-13-1946  | UnitedHealthcare Senior Supplement                   |
      | Group PDP          | 0130686931   | 03-12-1948  | UnitedHealthcare MedicareRx for Groups (PDP)         |

  Scenario Outline: To verify registration Additional Information Section
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member navigate to additional information section
    And member enter additional information
      | Zip Code   | <zipCode>   |
      | First Name | <firstName> |
      | Last Name  | <lastName>  |

    Examples: 
      | planMemberId | dateOfBirth | zipCode | firstName | lastName |
      | 920748371    | 03-02-1940  | 03855   | AABE      | BEAAEEF  |
      | 008666811    | 02-22-1951  | 95380   | BCDBC     | DBDE     |
      | 0186083571   | 05-27-1951  | 24524   | CDABDAF   | FFACFEFC |

  Scenario Outline: To verify registration existing member error page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate existing member error message

    Examples: 
      | Plantype          | planMemberId | dateOfBirth |
      | MAPD COSMOS       | 957566851    | 03-26-1952  |
      | MA NICE           | 008511769    | 05-09-1946  |
      | MA COSMOS         | 930564080    | 03-01-1952  |
      | MAPD NICE         | 002776817    | 10-07-1943  |
      | PDP               | 0183275881   | 02-17-1950  |
      | PCP               | 969148901    | 12-29-1935  |
      # | MEDICA      | 914429086    | 08-28-1927  |
      | SHIP/MED SUPP     | 356357672-11 | 03-01-1949  |
      | SHIP 50-64        | 378564935-11 | 12-01-1956  |
      | SHIP 50-64 + MA   | 861622172    | 07-27-1940  |
      | SHIP 50-64 + MA   | 861622172-11 | 07-27-1940  |
      | SHIP 50-64 + MAPD | 805816168    | 01-26-1934  |
      | SHIP 50-64 + MAPD | 805816168-11 | 01-26-1934  |
      | SHIP 50-64 + PDP  | 9809909891   | 10-13-1927  |
      | SHIP 50-64 + PDP  | 980990989-11 | 10-13-1927  |

  Scenario Outline: To verify registration inactive or terminated member error page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate inactive or terminated error message

    Examples: 
      | Plantype          | planMemberId | dateOfBirth |
      | MAPD NICE         | 004560292    | 05-01-1945  |
      | MAPD COSMOS       | 977402259    | 12-25-1947  |
      | MA COSMOS         | 945618448    | 02-15-1952  |
      | MA NICE           | 008437131    | 02-15-1952  |
      | Medica            | 920950691    | 02-25-1952  |
      | PCP               | 937615545    | 02-29-1952  |
      | PDP               | 0019389581   | 04-30-1935  |
      | PDP Symphonix     | 0189838581   | 05-13-1954  |
      | Group MAPD NICE   | 811516933    | 10-08-1944  |
      | Group MAPD COSMOS | 947288438    | 10-09-1934  |
      | Group MA COSMOS   | 932907892    | 07-20-1936  |
      | Group MA NICE     | 007442377    | 03-07-1949  |
      | Group SSUP        | 919903974    | 09-28-1946  |
      | Group SSRD        | 970839429    | 11-11-1929  |
      | Group PDP         | 0152322881   | 06-11-1949  |
      | SHIP/MED SUPP     | 363335622-11 | 02-01-1939  |

  Scenario Outline: To verify registration Future effective member error page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate future effective error message

    Examples: 
      | Plantype          | planMemberId | dateOfBirth |
      | MAPD NICE         | 008502739    | 02-02-1952  |
      | MAPD COSMOS       | 957566851    | 03-26-1952  |
      | MA COSMOS         | 976326464    | 02-20-1952  |
      | MA NICE           | 008511769    | 05-09-1946  |
      | Medica            | 927593325    | 02-09-1952  |
      | PCP               | 953028092    | 02-21-1952  |
      | PDP               | 0183275881   | 02-17-1950  |
      | PDP Symphonix     | 0184295991   | 10-25-1963  |
      | Group MAPD NICE   | 007922344    | 02-15-1941  |
      | Group MAPD COSMOS | 864188443    | 04-13-1941  |
      | Group MA COSMOS   | 927729952    | 12-27-1940  |
      | Group MA NICE     | 004568181    | 11-27-1947  |
      | Group SSUP        | 918226927    | 10-24-1951  |
      | Group SSRD        | 968832852    | 09-17-1926  |
      | Group PDP         | 0128086331   | 11-14-1947  |
      | SHIP 50-64        | 399492182-11 | 12-01-1956  |

  Scenario Outline: To verify registration member not found error page
    Given the member is on registration page of new portal part of redesign
    When the member enter the member ID into Member ID field
      | Plan Member ID | <planMemberId> |
    And member enter date of birth in the date of birth dropdown
      | Date of birth | <dateOfBirth> |
    When member click Next
    Then the member validate member not found error message

    Examples: 
      | planMemberId | dateOfBirth |
      | 897948810    | 10-09-1946  |
