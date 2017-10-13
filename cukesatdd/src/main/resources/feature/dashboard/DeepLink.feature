@deepLinkFnF
@F118429
Feature: Deep Links for Member Site Redesign

Scenario Outline: Deep Links - Registered Users ( Non- Health Line )
Given I am an registered user and clicks on deeplink
|DeepLinkURL    |<deepLinkURL>|
And then upon successful sign-in, directed to the desired page
|DeepLinkPage   |<deepLinkPage>|
|UserName       |<userName>|
Examples:
|deepLinkPage										|userName         |deepLinkURL                   |

# *************** NON - HEALTHLINE ***********************************************
#Ulayer Mapd
|Benefits Overview  						|q3_sep_ulayer001 |/Member/benefits-coverage.html|
|claims													|q3_sep_ulayer001 |/Member/claims.html					 |
#ssoError
|Drug Cost Estimator 						|q3_sep_ulayer001 |/Member/sso/outbound?outboundTo=optumrx&deepLink=manageprescriptions|
#Go Green (Paperless)
|My Preferences       					|q3_sep_ulayer001 |/Member/preferences.html| 
#Blank Page
|Materials											|q3_sep_ulayer001 |/Member/order-plan-materials.html|
|EOB Search     								|q3_sep_ulayer001 |/Member/eob.html|
|Payments History     					|q3_sep_ulayer001 |/Member/premium-payments.html|
#Blank Page
|Pharmacy Search      					|q3_sep_ulayer001 |/Member/pharmacy-locator.html|
#Blank Page
|Preferred Mail Service Pharmacy|q3_sep_ulayer001 |/about/mail-service-pharmacy-mapd.html|
#Profile & Preferences
|My Profile           					|q3_sep_ulayer001 |/Member/profile.html|
|Provider Search                |q3_sep_ulayer001 |/Member/provider-search.html|


#MAPD+Med Supp
|Benefits Overview  						|q3_sep_combo012  |/Member/benefits-coverage.html|
|claims													|q3_sep_combo012  |/Member/claims.html					 |
#ssoError
|Drug Cost Estimator 						|q3_sep_combo012  |/Member/sso/outbound?outboundTo=optumrx&deepLink=manageprescriptions|
#Go Green (Paperless)
|My Preferences       					|q3_sep_combo012  |/Member/preferences.html| 
#Blank Page
|Materials											|q3_sep_combo012  |/Member/order-plan-materials.html|
|EOB Search     								|q3_sep_combo012  |/Member/eob.html|
|Payments History     					|q3_sep_combo012  |/Member/premium-payments.html|
#Blank Page
|Pharmacy Search      					|q3_sep_combo012  |/Member/pharmacy-locator.html|
#Blank Page
|Preferred Mail Service Pharmacy|q3_sep_combo012  |/about/mail-service-pharmacy-mapd.html|
#Profile & Preferences
|My Profile           					|q3_sep_combo012  |/Member/profile.html|
|Provider Search                |q3_sep_combo012  |/Member/provider-search.html|


#HIP (HOSPITAL INDEMNITY PLAN) 50-64
|Benefits Overview  						|q3_sep_ship021  |/Member/benefits-coverage.html|
|claims													|q3_sep_ship021  |/Member/claims.html					 |
#ssoError
|Drug Cost Estimator 						|q3_sep_ship021  |/Member/sso/outbound?outboundTo=optumrx&deepLink=manageprescriptions|
#Go Green (Paperless)
|My Preferences       					|q3_sep_ship021  |/Member/preferences.html| 
#Blank Page
|Materials											|q3_sep_ship021  |/Member/order-plan-materials.html|
|EOB Search     								|q3_sep_ship021  |/Member/eob.html|
|Payments History     					|q3_sep_ship021  |/Member/premium-payments.html|
#Blank Page
|Pharmacy Search      					|q3_sep_ship021  |/Member/pharmacy-locator.html|
#Blank Page
|Preferred Mail Service Pharmacy|q3_sep_ship021  |/about/mail-service-pharmacy-mapd.html|
#Profile & Preferences
|My Profile           					|q3_sep_ship021  |/Member/profile.html|
|Provider Search                |q3_sep_ship021  |/Member/provider-search.html|

#Med Supp + 50-64
|Benefits Overview  						|q3_sep_ship063  |/Member/benefits-coverage.html|
|claims													|q3_sep_ship063  |/Member/claims.html					 |
#ssoError
|Drug Cost Estimator 						|q3_sep_ship063  |/Member/sso/outbound?outboundTo=optumrx&deepLink=manageprescriptions|
#Go Green (Paperless)
|My Preferences       					|q3_sep_ship063  |/Member/preferences.html| 
#Blank Page
|Materials											|q3_sep_ship063  |/Member/order-plan-materials.html|
|EOB Search     								|q3_sep_ship063  |/Member/eob.html|
|Payments History     					|q3_sep_ship063  |/Member/premium-payments.html|
#Blank Page
|Pharmacy Search      					|q3_sep_ship063  |/Member/pharmacy-locator.html|
#Blank Page
|Preferred Mail Service Pharmacy|q3_sep_ship063  |/about/mail-service-pharmacy-mapd.html|
#Profile & Preferences
|My Profile           					|q3_sep_ship063  |/Member/profile.html|
|Provider Search                |q3_sep_ship063  |/Member/provider-search.html|

#MAPD-COSMOS
|Benefits Overview  						|q3_sep_blayer001  |/Member/benefits-coverage.html|
|claims													|q3_sep_blayer001  |/Member/claims.html					 |
#ssoError
|Drug Cost Estimator 						|q3_sep_blayer001  |/Member/sso/outbound?outboundTo=optumrx&deepLink=manageprescriptions|
#Go Green (Paperless)
|My Preferences       					|q3_sep_blayer001  |/Member/preferences.html| 
#Blank Page
|Materials											|q3_sep_blayer001  |/Member/order-plan-materials.html|
|EOB Search     								|q3_sep_blayer001  |/Member/eob.html|
|Payments History     					|q3_sep_blayer001  |/Member/premium-payments.html|
#Blank Page
|Pharmacy Search      					|q3_sep_blayer001  |/Member/pharmacy-locator.html|
#Blank Page
|Preferred Mail Service Pharmacy|q3_sep_blayer001  |/about/mail-service-pharmacy-mapd.html|
#Profile & Preferences
|My Profile           					|q3_sep_blayer001  |/Member/profile.html|
|Provider Search                |q3_sep_blayer001  |/Member/provider-search.html|

#MA-NICE
|Benefits Overview  						|q3_sep_grp002  |/Member/benefits-coverage.html|
|claims													|q3_sep_grp002  |/Member/claims.html					 |
#ssoError
|Drug Cost Estimator 						|q3_sep_grp002  |/Member/sso/outbound?outboundTo=optumrx&deepLink=manageprescriptions|
#Go Green (Paperless)
|My Preferences       					|q3_sep_grp002  |/Member/preferences.html| 
#Blank Page
|Materials											|q3_sep_grp002  |/Member/order-plan-materials.html|
|EOB Search     								|q3_sep_grp002  |/Member/eob.html|
|Payments History     					|q3_sep_grp002  |/Member/premium-payments.html|
#Blank Page
|Pharmacy Search      					|q3_sep_grp002  |/Member/pharmacy-locator.html|
#Blank Page
|Preferred Mail Service Pharmacy|q3_sep_grp002  |/about/mail-service-pharmacy-mapd.html|
#Profile & Preferences
|My Profile           					|q3_sep_grp002  |/Member/profile.html|
|Provider Search                |q3_sep_grp002  |/Member/provider-search.html|

# *************** NON - HEALTHLINE ***********************************************