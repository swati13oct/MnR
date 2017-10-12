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
|Benefit & Coverage 						|q3_sep_ulayer001 |/Member/benefits-coverage.html|
|Claims													|q3_sep_ulayer001 |/Member/claims.html					 |
|Drug Cost Estimator 						|q3_sep_ulayer001 |/Member/sso/outbound?outboundTo=optumrx&deepLink=manageprescriptions|
|Go Green (Paperless) 					|q3_sep_ulayer001 |/Member/preferences.html|
|Materials											|q3_sep_ulayer001 |/Member/order-plan-materials.html|
|EOB Search Page								|q3_sep_ulayer001 |/Member/eob.html|
|Payments History     					|q3_sep_ulayer001 |/Member/premium-payments.html|
|Pharmacy Search      					|q3_sep_ulayer001 |/Member/pharmacy-locator.html|
|Preferred Mail Service Pharmacy|q3_sep_ulayer001 |/about/mail-service-pharmacy-mapd.html|
|Profile & Preferences					|q3_sep_ulayer001 |/Member/profile.html|
|Provider Search                |q3_sep_ulayer001 |/Member/provider-search.html|