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