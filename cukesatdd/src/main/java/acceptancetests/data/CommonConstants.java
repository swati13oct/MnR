/**
 * 
 */
package acceptancetests.data;

/**
 * @author pjaising
 *
 */
public class CommonConstants {

	public static final String FLOW_NAME = "registration/planconfirmation";

	public static final String REG_FAILURE_FLOW_NAME = "registration/registrationfailure";

	public static final String LOGIN_ASSISTANCE_FAILURE_FLOW_NAME = "loginassistance/loginassistancefailure";

	public static final String PROPERTY_FILE_FOLDER = "/config";

	public static final String PROPERTY_FILE_NAME = "config.properties";

	public static final String DEFAULT_ENVIRONMENT_CI = "ci";
	
	public static final String USER_PASSWORD = "userPassword";
	
	public static final String BUSINESS_CATEGORY = "businessCategory";
	
	public static final String ATTRIB_FIRST_NAME = "givenName";

	public static final String ATTRIB_LAST_NAME = "sn";
	
	public static final String ATTRIB_COMMON_NAME = "cn";
	
	public static final String ATTRIB_OBJECT_CLASS = "objectClass";

	public static final String UID = "uid";

	public static final String DB_URL = "DBUrl";

	public static final String DB_USERNAME = "DBUsername";

	public static final String DB_PASSWORD = "DBPassword";
	
	public static final String HSIDDB_URL = "HSIDDBURL";

	public static final String HSIDDB_USERNAME = "HSIDDBUsername";

	public static final String HSIDDB_PASSWORD = "HSIDDBPassword";
	
	public static final String HSID_ENV = "HSID_ENV";
	

	public static final String DB_SCHEMA = "DBSchema";

	public static final String LDAP_BASE = "ldapBase";

	public static final String LDAP_USER = "ldapBindUser";

	public static final String LDAP_PASSWORD = "ldapBindPassword";

	public static final String LDAP_URL = "ldapUrl";

	public static final String WEBDRIVER = "webDriver";

	public static final String DEVICE_NAME = "DeviceName";

	public static final String CHROME_DRIVER = "ChromeDriver";

	public static final String PLAN_BENEFITS_AND_COVERAGE = "planBenefitsAndCoverage";

	public static final String BENEFITS_AND_COVERAGE_PDP_NONLIS_NONUS_PAGE_DATA = "planbenefitsandcoveragenonlisnotusother.json";

	public static final String BENEFITS_AND_COVERAGE_PAGE_DATA = "benefitsandcoveragelisnonlis.json";

	public static final String BENEFITS_AND_COVERAGE_PAGE_DIRECTORY = "/jsonresponse/member/ulayer/benefitsandcoverage/";

	public static final String BENEFITS_AND_COVERAGE_PAGE_BLAYER_DIRECTORY = "/jsonresponse/member/bluelayer/benefitsandcoverage/";

	public static final String BENEFITS_AND_COVERAGE_DIRECTORY = "/jsonresponse/member/ulayer/planbenefitsandcoverage/";

	public static final String ACCOUNT_HOME_PAGE_DATA = "myaccounthome.json"; // Group

	public static final String PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER = "/page-objects/member/ulayer/";

	public static final String PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER = "/page-objects/member/bluelayer/";

	public static final String PLAN_SUMMARY_PAGE_DATA = "plansummarypdp.json";

	public static final String PLAN_SUMMARY_DIRECTORY = "/jsonresponse/Member/ulayer/planSummary/";

	public static final String REGISTRATION_COMMON_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/registration/registrationcommon/";

	public static final String REGISTRATION_COMMON_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/registration/registrationcommon/";

	private static final String TERMINATED_ACCOUNT_DIRECTORY = "/jsonresponse/Member/ulayer/terminatedaccount/";

	private static final String MANAGE_DRUG_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/managedrug/";

	public static final String ADD_DRUG_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/adddrug/";

	public static final String DRUG_DOSAGE_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/drugdosage/";

	public static final String LOW_COST_OPTIONS_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/lowcostoptions/";

	private static final String SELECT_PHARMACY_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/selectpharmacy/";

	public static final String CONTACT_US = "contactus";

	private static final String CONTACT_US_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/contactus/";

	public static final String DTM_TAG_MEMBER_FILENAME = "member";
	public static final String DTM_TAG_ACQ_FILENAME = "acquisition";
	public static final String PAGE_OBJECT_DTM_TAG_DIR = "/page-objects/dtm-common-data/";
	public static final String NEW_PAYMENT_HISTORY_PAGE_DATA = "newpaymenthistory.json";

	public static final String PAYMENT_HISTORY_MOBILE = "payment_history_mobile";

	public static final String PAYMENT_HISTORY_MOBILE_DATA = "paymenthistory_mobile.json";
	
	public static final String  PAYMENT_HISTORY_BLUELAYER_DIRECTORY_MOBILE ="/jsonresponse/mobile/member/bluelayer/payment-history/";
	
	public static final String  DASHBOARD_PAYMENT_HISTORY_ULAYER_DIRECTORY_MOBILE ="/jsonresponse/mobile/member/ulayer/payment-history/";

	private static final String DASHBOARD_DRUGCOSTESTIMATOR_DIRECTORY = "/jsonresponse/member/dashboard/drugcostestimator/";

	public static final String ADD_DRUG_DETAILS = "adddrugdetails";
	
	public static final Page[] PAGES = { new Page(CommonConstants.GLOBAL, CommonConstants.GLOBAL_DIRECTORY),
			new Page(CommonConstants.MY_ACCOUNT_HOME, CommonConstants.MY_ACCOUNT_HOME_DIRECTORY),
			new Page(CommonConstants.MY_ACCOUNT_HOME_COMBO, CommonConstants.MY_ACCOUNT_HOME_COMBO_DIRECTORY),
			new Page(CommonConstants.PHR, CommonConstants.PHR_DIRECTORY),
			new Page(CommonConstants.COMMON, CommonConstants.COMMON_DIRECTORY),
			new Page(CommonConstants.PLAN_SUMMARY, CommonConstants.PLAN_SUMMARY_DIRECTORY),
			new Page(CommonConstants.PAYMENT_HISTORY, CommonConstants.PAYMENT_HISTORY_DIRECTORY),
			new Page(CommonConstants.ONE_TIME_PAYMENT_SUCCESS, CommonConstants.ONE_TIME_PAYMENT_DIRECTORY),
			new Page(CommonConstants.SET_UP_PAYMENT_SUCCESS, CommonConstants.SET_UP_PAYMENT_DIRECTORY),
			new Page(CommonConstants.FORMS_AND_RESOURCES, CommonConstants.FORMS_AND_RESOURCES_DIRECTORY),
			new Page(CommonConstants.ORDER_PLAN_MATERIALS, CommonConstants.ORDER_PLAN_MATERIALS_DIRECTORY),
			new Page(CommonConstants.PLAN_CONFIRMATION, CommonConstants.PLAN_CONFIRMATION_DIRECTORY),
			new Page(CommonConstants.REGISTRATION, CommonConstants.REGISTRATION_DIRECTORY),
			new Page(CommonConstants.ADD_PLAN, CommonConstants.ADD_PLAN_DIRECTORY),
			new Page(CommonConstants.PHARMACY_RESULT, CommonConstants.PHARMACY_RESULT_DIRECTORY),
			new Page(CommonConstants.DRUG_COST_BENEFIT_SUMMARY, CommonConstants.DRUG_COST_BENEFIT_SUMMARY_DIRECTORY),
			new Page(CommonConstants.BENEFITS_AND_COVERAGE_PDP_NONLIS_NONUS_PAGE_DATA,
					CommonConstants.BENEFITS_AND_COVERAGE_DIRECTORY),
			new Page(CommonConstants.DRUG_CLAIMS_SUMMARY, CommonConstants.DRUG_CLAIMS_SUMMARY_DIRECTORY),
			new Page(CommonConstants.DRUG_CLAIMS_DETAILS, CommonConstants.DRUG_CLAIMS_DETAILS_DIRECTORY),
			new Page(CommonConstants.MEDICAL_CLAIMS_SUMMARY, CommonConstants.MEDICAL_CLAIMS_SUMMARY_DIRECTORY),
			new Page(CommonConstants.MEDICAL_CLAIMS_DETAILS, CommonConstants.MEDICAL_CLAIMS_DETAILS_DIRECTORY),

			new Page(CommonConstants.MY_PROFILES, CommonConstants.MY_PROFILES_DIRECTORY),
			new Page(CommonConstants.MY_PREFERENCES, CommonConstants.MY_PREFERENCES_DIRECTORY),
			new Page(CommonConstants.VIEW_DRUG_COST, CommonConstants.VIEW_DRUG_COST_ULAYER_DIRECTORY),
			new Page(CommonConstants.MEDICAL_EOB, CommonConstants.MEDICAL_EOB_DIRECTORY),
			new Page(CommonConstants.PRESCRIPTION_DRUG_EOB, CommonConstants.PRESCRIPTION_DRUG_EOB_DIRECTORY),
			new Page(CommonConstants.MANAGE_DRUG, CommonConstants.MANAGE_DRUG_ULAYER_DIRECTORY),
			new Page(CommonConstants.ADD_DRUG, CommonConstants.ADD_DRUG_ULAYER_DIRECTORY),
			new Page(CommonConstants.DRUG_DOSAGE, CommonConstants.DRUG_DOSAGE_ULAYER_DIRECTORY),
			new Page(CommonConstants.LOW_COST_OPTIONS, CommonConstants.LOW_COST_OPTIONS_ULAYER_DIRECTORY),
			new Page(CommonConstants.SELECT_PHARMACY, CommonConstants.SELECT_PHARMACY_ULAYER_DIRECTORY),
			new Page(CommonConstants.TERMINATED_ACCOUNT, CommonConstants.TERMINATED_ACCOUNT_DIRECTORY),
			new Page(CommonConstants.REGISTRATION_SUCCESS, CommonConstants.REGISTRATION_SUCCESS_DIRECTORY),
			new Page(CommonConstants.MY_PREFERENCES_BEFORE_UPDATE,
					CommonConstants.MY_PREF_BEFORE_UPDATE_ULAYER_DIRECTORY),
			new Page(CommonConstants.MY_PREFERENCES_AFTER_UPDATE,
					CommonConstants.MY_PREF_AFTER_UPDATE_ULAYER_DIRECTORY),
			new Page(CommonConstants.CONTACT_US, CommonConstants.CONTACT_US_ULAYER_DIRECTORY),
			new Page(CommonConstants.BENEFITS_SUMMARY, CommonConstants.BENEFITS_SUMMARY_DIRECTORY),
			new Page(CommonConstants.BENEFITS_DETAIL, CommonConstants.BENEFITS_DETAIL_DIRECTORY),
			new Page(CommonConstants.PLAN_COMPARE, CommonConstants.PLAN_COMPARE_ULAYER_DIRECTORY),
			new Page(CommonConstants.ADD_PLAN_CONFIRMATION, CommonConstants.ADD_PLAN_CONFIRMATION_ULAYER_DIRECTORY),
			new Page(CommonConstants.PAYMENT_HISTORY_MOBILE,
					CommonConstants.DASHBOARD_PAYMENT_HISTORY_ULAYER_DIRECTORY_MOBILE),
			new Page(CommonConstants.ADD_DRUG_DETAILS,
					CommonConstants.DASHBOARD_DRUGCOSTESTIMATOR_DIRECTORY),
					new Page(CommonConstants.ADD_NEW_DRUG_MODAL,
                            CommonConstants.DASHBOARD_DRUGCOSTESTIMATOR_DIRECTORY),

	};

	public static final String BENEFITS_SUMMARY_DIRECTORY = "/jsonresponse/mobile/member/ulayer/benefits-summary/";

	public static final String BENEFITS_SUMMARY = "benefitssummary";

	public static final String BENEFITS_DETAIL = "benefitsdetail";

	public static final String BENEFITS_DETAIL_DIRECTORY = "/jsonresponse/mobile/member/ulayer/benefits-detail/";

	public static final String BENEFITS_SUMMARY_BLAYER = "benefitssummary";

	public static final String BENEFITS_SUMMARY_DIRECTORY_BLAYER = "/jsonresponse/mobile/member/bluelayer/benefits-summary/";

	public static final String GLOBAL_DIRECTORY = "/jsonresponse/member/ulayer/global/";

	public static final String GLOBAL = "global";

	public static final String DIRECTORY = "/src/main/resources/";

	public static final String MY_ACCOUNT_HOME_DIRECTORY = "/jsonresponse/member/ulayer/myaccounthome/";

	public static final String MY_ACCOUNT_HOME = "myaccounthome";

	public static final String MY_ACCOUNT_HOME_COMBO_DIRECTORY = "/jsonresponse/member/ulayer/myaccounthomecombo/";

	public static final String MY_ACCOUNT_HOME_COMBO = "myaccounthomecombo";

	public static final String PHR_FEDERAL_PAGE_DATA = "phrfederal.json";

	public static final String PHR_DIRECTORY = "/jsonresponse/member/ulayer/phr/";

	public static final String PHR = "phr";

	public static final String COMMON = "common";

	public static final String COMMON_DIRECTORY = "/jsonresponse/member/ulayer/common/";

	public static final String EXPECTED_DATA_MAP = "expectedDataMap";

	private static final String GLOBAL_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/global/";

	private static final String MY_ACCOUNT_HOME_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/myaccounthome/";

	private static final String COMMON_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/common/";

	private static final String PHR_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/phr/";

	private static final String PLAN_SUMMARY_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/plansummary/";

	public static final String PLAN_SUMMARY = "plansummary";

	private static final String FORMS_AND_RESOURCES_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/formsandresources/";

	private static final String BENEFITS_AND_COVERAGE_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/benefitsandcoverage/";

	private static final String PLAN_CONFIRMATION_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/registration/planconfirmation/";

	private static final String ADD_PLAN_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/addplan/";

	private static final String MY_ACCOUNT_HOME_COMBO_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/myaccounthomecombo/";

	private static final String PAYMENT_HISTORY_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/payment/paymenthistory/";

	private static final String ONE_TIME_PAYMENT_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/payment/onetimepaymentsuccess/";

	private static final String SET_UP_PAYMENT_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/payment/setuppaymentsuccess/";

	private static final String CLAIM_SUMMARY_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/claims/claimsummary/";

	private static final String CLAIM_DETAILS_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/claims/claimdetails/";

	private static final String MY_PROFILES_BEFORE_UPDATE_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/profilesandpref/myprofiles/beforeupdate/";

	private static final String MY_PROFILES_AFTER_UPDATE_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/profilesandpref/myprofiles/afterupdate/";

	private static final String MY_PREF_BEFORE_UPDATE_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/profilesandpref/mypreferences/beforeupdate/";

	private static final String MY_PREF_AFTER_UPDATE_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/profilesandpref/mypreferences/afterupdate/";

	private static final String MY_PREF_BEFORE_UPDATE_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/profilesandpref/mypreferences/beforeupdate/";

	private static final String MY_PREF_AFTER_UPDATE_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/profilesandpref/mypreferences/afterupdate/";

	private static final String DRUG_COST_BENEFIT_SUMMARY_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/drugcostbenefitsummary/";

	private static final String ORDER_PLAN_MATERIALS_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/orderplanmaterials/";

	private static final String PREFERENCES_COMMON_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/profilesandpref/mypreferences/preferencescommon/";

	private static final String PRESCRIPTION_DRUG_EOB_BLUELAYER_DIRECTORY = "/jsonresponse/Member/bluelayer/prescriptiondrugeob/";

	public static final String MY_PROFILES_BEFORE_UPDATE = "myprofilebeforeupdate";

	public static final String MY_PROFILES_AFTER_UPDATE = "myprofileafterupdate";

	public static final String MY_PREFERENCES_BEFORE_UPDATE = "mypreferencesbeforeupdate";

	public static final String MY_PREFERENCES_AFTER_UPDATE = "mypreferencesafterupdate";

	public static final String PREFERENCES_COMMON = "preferenceColumn";

	public static final String PAYMENT_HISTORY_MOBILE_DIRECTORY = "/page-objects/mobile/member/bluelayer/";

	public static final String PAYMENT_HISTORY_MOBILE_ULAYER = "payment_history_mobile_ulayer";
	public static final String PAYMENT_HISTORY_MOBILE_ULAYER_DIRECTORY = "/page-objects/mobile/member/ulayer/";

	public static final String PAYMENT_HISTORY_ULAYER_DIRECTORY_MOBILE = "/jsonresponse/mobile/member/ulayer/paymenthistory/";

	public static final Page[] PAGES_BLUELAYER = {
			new Page(CommonConstants.GLOBAL, CommonConstants.GLOBAL_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MY_ACCOUNT_HOME, CommonConstants.MY_ACCOUNT_HOME_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.COMMON, CommonConstants.COMMON_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PHR, CommonConstants.PHR_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PLAN_SUMMARY, CommonConstants.PLAN_SUMMARY_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.FORMS_AND_RESOURCES, CommonConstants.FORMS_AND_RESOURCES_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PLAN_BENEFITS_AND_COVERAGE,
					CommonConstants.BENEFITS_AND_COVERAGE_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PHARMACY_RESULT, CommonConstants.PHARMACY_RESULT_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.ADD_PLAN, CommonConstants.ADD_PLAN_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MY_ACCOUNT_HOME_COMBO, CommonConstants.MY_ACCOUNT_HOME_COMBO_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PAYMENT_HISTORY, CommonConstants.PAYMENT_HISTORY_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.ONE_TIME_PAYMENT_SUCCESS, CommonConstants.ONE_TIME_PAYMENT_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.SET_UP_PAYMENT_SUCCESS, CommonConstants.SET_UP_PAYMENT_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.CLAIM_SUMMARY, CommonConstants.CLAIM_SUMMARY_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.CLAIM_DETAILS, CommonConstants.CLAIM_DETAILS_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MY_PROFILES_BEFORE_UPDATE,
					CommonConstants.MY_PROFILES_BEFORE_UPDATE_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MY_PROFILES_AFTER_UPDATE,
					CommonConstants.MY_PROFILES_AFTER_UPDATE_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MY_PREFERENCES_BEFORE_UPDATE,
					CommonConstants.MY_PREF_BEFORE_UPDATE_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MY_PREFERENCES_AFTER_UPDATE,
					CommonConstants.MY_PREF_AFTER_UPDATE_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PREFERENCES_COMMON, CommonConstants.PREFERENCES_COMMON_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.DRUG_COST_BENEFIT_SUMMARY,
					CommonConstants.DRUG_COST_BENEFIT_SUMMARY_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.ORDER_PLAN_MATERIALS, CommonConstants.ORDER_PLAN_MATERIALS_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.VIEW_DRUG_COST, CommonConstants.VIEW_DRUG_COST_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.PRESCRIPTION_DRUG_EOB, CommonConstants.PRESCRIPTION_DRUG_EOB_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.MANAGE_DRUG, CommonConstants.MANAGE_DRUG_BLUE_LAYER_DIRECTORY),
			new Page(CommonConstants.ADD_DRUG, CommonConstants.ADD_DRUG_BLUE_LAYER_DIRECTORY),
			new Page(CommonConstants.DRUG_DOSAGE, CommonConstants.DRUG_DOSAGE_BLUE_LAYER_DIRECTORY),
			new Page(CommonConstants.LOW_COST_OPTIONS, CommonConstants.LOW_COST_OPTIONS_BLUE_LAYER_DIRECTORY),
			new Page(CommonConstants.SELECT_PHARMACY, CommonConstants.SELECT_PHARMACY_BLUE_LAYER_DIRECTORY),
			new Page(CommonConstants.REGISTRATION_SUCCESS, CommonConstants.REGISTRATION_SUCCESS_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.ADD_PLAN_CONFIRMATION, CommonConstants.ADD_PLAN_CONFIRMATION_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.BENEFITS_SUMMARY_BLAYER, CommonConstants.BENEFITS_SUMMARY_DIRECTORY_BLAYER),
			new Page(CommonConstants.PAYMENT_HISTORY_MOBILE,
					CommonConstants.PAYMENT_HISTORY_BLUELAYER_DIRECTORY_MOBILE) };

	public static final String PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER = "/page-objects/member/bluelayer/";

	public static final String PAGE_OBJECT_DIRECTORY_MYMEDICA_MEMBER = "/page-objects/member/mymedica/";

	public static final String RETIREE_PAGE_OBJECT_DIRECTORY = "/page-objects/uhcretiree/acquisition/";

	public static final String REGISTRATION = "registration";

	public static final String REGISTRATION_SUCCESS = "registrationsuccess";

	public static final String REGISTRATION_SUCCESS_DIRECTORY = "/jsonresponse/member/ulayer/registration/registrationsuccess/";

	public static final String REGISTRATION_DIRECTORY = "/jsonresponse/member/ulayer/registration/registrationsuccess/";

	public static final String REGISTRATION_SUCCESS_PAGE_DATA = "registrationsuccess.json";

	public static final String PLAN_CONFIRMATION = "planconfirmation";

	public static final String PLAN_CONFIRMATION_DIRECTORY = "/jsonresponse/member/ulayer/registration/planconfirmation/";

	public static final String PLAN_CONFIRMATION_PAGE_DATA = "planconfirmation.json";

	public static final String PAYMENT_HISTORY = "paymentHistory";

	public static final String PAYMENT_HISTORY_PAGE_DATA = "paymenthistory.json";

	public static final String PAYMENT_HISTORY_DIRECTORY = "/jsonresponse/Member/ulayer/payment/paymenthistory/";

	public static final String ONE_TIME_PAYMENT_SUCCESS = "onetimepaymentsuccess";

	public static final String ONE_TIME_PAYMENT_DIRECTORY = "/jsonresponse/Member/ulayer/payment/onetimepaymentsuccess/";

	public static final String ONE_PAYMENT_SUCCESS_PAGE_DATA = "onetimepaymentsuccess.json";

	public static final String FORMS_AND_RESOURCES = "formsandresources";

	public static final String FORMS_AND_RESOURCES_DIRECTORY = "/jsonresponse/Member/ulayer/formsandresources/";

	public static final String FR_NEXTYEAR_DIRECTORY = "/jsonresponse/Member/ulayer/Nextyearpdf/";

	public static final String FORMS_AND_RESOURCES_PAGE_DATA = "formsandresources.json";

	public static final String ORDER_PLAN_MATERIALS = "orderplanmaterials";

	public static final String ORDER_PLAN_MATERIALS_DIRECTORY = "/jsonresponse/Member/ulayer/orderplanmaterials/";

	public static final String ORDER_PLAN_MATERIALS_PAGE_DATA = "orderplanmaterials.json";

	public static final String SET_UP_PAYMENT_SUCCESS = "setuppaymentsuccess";

	public static final String SET_UP_PAYMENT_DIRECTORY = "/jsonresponse/Member/ulayer/payment/setuppaymentsuccess/";

	public static final String SET_UP_PAYMENT_SUCCESS_PAGE_DATA = "setuppaymentsuccess.json";

	public static final String PHARMACY_RESULT = "pharmacyresult";

	public static final String PHARMACY_RESULT_PAGE_DATA = "pharmacyresult.json";

	public static final String PHARMACY_RESULT_DIRECTORY = "/jsonresponse/member/ulayer/locatepharmacy/";

	public static final String PHARMACY_RESULT_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/locatepharmacy/";

	public static final String REGISTRATION_COMMON = "registrationCommon";

	public static final String ADD_PLAN = "addplan";

	public static final String ADD_PLAN_DIRECTORY = "/jsonresponse/member/ulayer/addplan/";

	public static final String DRUG_COST_BENEFIT_SUMMARY = "drugcostbenefitsummary";

	public static final String DRUG_COST_BENEFIT_SUMMARY_SUCCESS = "drugcostbenefitsummary";

	public static final String DRUG_COST_BENEFIT_SUMMARY_DIRECTORY = "/jsonresponse/Member/ulayer/drugcostbenefitsummary/";

	public static final String DRUG_COST_BENEFIT_SUMMARY_PAGE_DATA = "drugcostbenefitsummary.json";

	public static final String ACCOUNT_HOME_PAGE_INDIVIDUAL_DATA = "myaccounthomeindividual.json";

	public static final String CLAIM_SUMMARY_PAGE_DATA = "claimsummary.json";

	public static final String CLAIM_SUMMARY = "claimsummary";

	public static final String MEDICAL_CLAIM_DETAILS_PAGE_DATA = "medicalclaimdetails.json";

	public static final String CLAIM_DETAILS = "claimdetails";

	public static final String VPP_PLAN_SUMMARY_PAGE_DATA = "vppplansummary.json";

	public static final String PAGE_OBJECT_DIRECTORY_ULAYER_ACQ = "/page-objects/acquisition/ulayer/";

	public static final String SITE_ULAYER = "ulayer";

	public static final String SITE_BLUELAYER = "bluelayer";

	public static final String SITE_MYMEDICA = "mymedica";

	public static final String SITE_MYPCP = "mypcp";

	public static final String SITE_UHCRETIREE = "uhcretiree";

	public static final String SITE_BLUELAYER_MEMBER = "bluelayer";

	public static final String SITE_ULAYER_MEMBER = "ulayer";

	public static final String ACQUISITION_EXPECTED_DIRECTORY = "/jsonresponse/acquisition";

	public static final String MEMBER_EXPECTED_DIRECTORY = "/jsonresponse/member";

	public static final String DRX_EXPECTED_DIRECTORY = "/jsonresponse/drx";

	public static final String DRUG_CLAIMS_SUMMARY = "drugclaimsummary";

	public static final String DRUG_CLAIMS_SUMMARY_DIRECTORY = "/jsonresponse/member/ulayer/claims/drugclaimsummary/";

	public static final String DRUG_CLAIMS_SUMMARY_PAGE_DATA = "drugclaimsummary.json";

	public static final String DRUG_CLAIMS_DETAILS = "drugclaimdetails";

	public static final String DRUG_CLAIMS_DETAILS_DIRECTORY = "/jsonresponse/Member/ulayer/claims/drugclaimdetails/";

	public static final String DRUG_CLAIMS_DETAILS_PAGE_DATA = "drugclaimdetails.json";

	public static final String MEDICAL_CLAIMS_SUMMARY = "medicalclaimsummary";

	public static final String MEDICAL_CLAIMS_SUMMARY_DIRECTORY = "/jsonresponse/member/ulayer/claims/medicalclaimsummary/";

	public static final String MEDICAL_CLAIMS_SUMMARY_PAGE_DATA = "medicalclaimsummary.json";

	public static final String MEDICAL_CLAIMS_DETAILS = "medicalclaimdetails";

	public static final String MEDICAL_CLAIMS_DETAILS_DIRECTORY = "/jsonresponse/Member/ulayer/claims/medicalclaimdetails/";

	public static final String MEDICAL_CLAIMS_DETAILS_PAGE_DATA = "medicalclaimdetails.json";

	public static final String PLAN_CATEGORY = "planCategory";

	public static final String CLAIM_SUMMARY_INDIVIDUAL_PAGE_DATA = "claimsummaryindividual.json";

	public static final String DRUG_CLAIM_DETAILS_INDIVIDUAL_PAGE_DATA = "drugclaimdetailsindividual.json";

	public static final String DRUG_CLAIM_DETAILS_PAGE_DATA = "drugClaimDetails.json";

	public static final String PLAN_TYPE = "planType";

	public static final String MY_PROFILES = "myprofiles";

	public static final String MY_PROFILES_DIRECTORY = "/jsonresponse/Member/ulayer/profilesandprefereneces/myprofiles/";

	public static final String MY_PROFILES_PAGE_DATA = "myprofiles.json";

	public static final String MY_PREFERENCES = "mypreferences";

	public static final String MY_PREFERENCES_DIRECTORY = "/jsonresponse/Member/ulayer/profilesandprefereneces/mypreferences/";

	public static final String MY_PREFERENCES_PAGE_DATA = "mypreferences.json";

	public static final String VIEW_DRUG_COST_ULAYER_DIRECTORY = "/jsonresponse/Member/ulayer/druglookup/viewdrugcost/";

	public static final String VIEW_DRUG_COST_PDP_PAGE_DATA = "viewdrugcostpdp.json";

	public static final String VIEW_DRUG_COST_MAPD_PAGE_DATA = "viewdrugcostmapd.json";

	public static final String VIEW_DRUG_COST_PAGE_DATA = "viewdrugcost.json";

	public static final String MEDICAL_EOB = "medicaleob";

	public static final String MEDICAL_EOB_DIRECTORY = "/jsonresponse/Member/ulayer/eob/medical/";

	public static final String MEDICAL_EOB_PAGE_DATA = "medicaleob.json";

	public static final String PRESCRIPTION_DRUG_EOB_DIRECTORY = "/jsonresponse/Member/ulayer/eob/drug/";

	public static final String DRUG_LOOK_UP = "druglookup";

	public static final String DRUG_LOOK_UP_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/druglookup/";

	public static final String DRUG_LOOK_UP_PAGE_DATA = "druglookup.json";

	public static final String DRUG_LIST = "druglist";

	public static final String DRUG_LIST_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/druglist/";

	public static final String SELECT_GENERIC_PAGE_DATA = "selectgeneric.json";

	public static final String DRUG_DOSAGE = "drugdosage";

	public static final String DRUG_DOSAGE_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/drugdosage/";

	public static final String DRUG_DOSAGE_PAGE_DATA = "drugdosage.json";

	public static final String ADD_DRUG = "adddrug";

	public static final String ADD_DRUG_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/adddrug/";

	public static final String ADD_DRUG_PAGE_DATA = "adddrug.json";

	public static final String DRUG_SEARCH_PAGE_DATA = "searchdrug.json";

	public static final String LOW_COST_OPTIONS = "lowcostoptions";

	public static final String LOW_COST_OPTIONS_DIRECTORY = "/jsonresponse/member/ulayer/druglookup/lowcostoptions/";

	public static final String LOW_COST_OPTIONS_PAGE_DATA = "lowcostoptions.json";

	public static final Page[] PAGES_REGISTRATION_BLUELAYER = {
			new Page(CommonConstants.PLAN_CONFIRMATION, CommonConstants.PLAN_CONFIRMATION_BLUELAYER_DIRECTORY),
			new Page(CommonConstants.REGISTRATION_COMMON, CommonConstants.REGISTRATION_COMMON_BLUELAYER_DIRECTORY) };

	public static final Page[] PAGES_REGISTRATION_ULAYER = {
			new Page(CommonConstants.PLAN_CONFIRMATION, CommonConstants.PLAN_CONFIRMATION_DIRECTORY),
			new Page(CommonConstants.REGISTRATION_COMMON, CommonConstants.REGISTRATION_COMMON_ULAYER_DIRECTORY) };

	public static final String PRESCRIPTION_DRUG_EOB_PAGE_DATA = "prescriptiondrugeob.json";

	public static final String PRESCRIPTION_DRUG_EOB = "prescriptionDrugEob";

	public static final String TERMINATED_ACCOUNT_PAGE_DATA = "terminatedaccount.json";

	public static final String TERMINATED_ACCOUNT = "terminatedAccount";

	public static final String PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ = "/page-objects/acquisition/bluelayer/";

	public static final String PAGE_OBJECT_DIRECTORY_DRX = "/page-objects/drx/";

	public static final String PHR_SHIP_PAGE_DATA = "phrship.json";

	public static final String PHR_PAGE_DATA = "phr.json";

	public static final String MANAGE_DRUG = "manageDrug";

	public static final String MANAGE_DRUG_BLUE_LAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/managedrug/";

	public static final String MANAGE_DRUG_BLUE_LAYER_PAGE_DATA = "managedrug.json";

	public static final String MANAGE_DRUG_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "managedrugindividual.json";

	public static final String ADD_DRUG_BLUE_LAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/adddrug/";

	public static final String ADD_DRUG_BLUE_LAYER_PAGE_DATA = "adddrug.json";

	public static final String ADD_DRUG_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "adddrugindividual.json";

	public static final String DRUG_DOSAGE_BLUE_LAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/drugdosage/";

	public static final String DRUG_DOSAGE_BLUE_LAYER_PAGE_DATA = "drugdosage.json";

	public static final String DRUG_DOSAGE_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "drugdosageindividual.json";

	public static final String LOW_COST_OPTIONS_BLUE_LAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/lowcostoptions/";

	public static final String LOW_COST_OPTIONS_BLUE_LAYER_PAGE_DATA = "lowcostoptions.json";

	public static final String LOW_COST_OPTIONS_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "lowcostoptionsindividual.json";

	public static final String SELECT_PHARMACY = "selectpharmacy";
	
	public static final String LOCATE_PHARMACIES_PAGE_DATA = "locatepharmacy.json";

	public static final String SELECT_PHARMACY_BLUE_LAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/selectpharmacy/";

	public static final String SELECT_PHARMACY_BLUE_LAYER_PAGE_DATA = "selectpharmacy.json";

	public static final String SELECT_PHARMACY_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "selectpharmacyindividual.json";

	public static final String VIEW_DRUG_COST = "viewdrugCost";

	private static final String VIEW_DRUG_COST_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/estimatedrugcosts/viewdrugcost/";

	public static final String VIEW_DRUG_COST_BLUE_LAYER_PAGE_DATA = "viewdrugcost.json";

	public static final String PLAN_SELECTOR_PAGE_DATA = "planselector.json";

	public static final String VIEW_DRUG_COST_INDIVIDUAL_BLUE_LAYER_PAGE_DATA = "viewdrugcostindividual.json";

	public static final String GROUP = "Group";

	public static final String LEARN_ABOUT_PLAN_PAGE_DATA = "learnaboutmedicare.json";

	public static final String INITIAL_ENROLL_PAGE_DATA = "initialenroll.json";

	public static final String MANAGE_DRUG_ULAYER_PAGE_DATA = "manageDrug.json";

	public static final String ADD_DRUG_ULAYER_PAGE_DATA = "adddrug.json";

	public static final String SELECT_PHARMACY_ULAYER_PAGE_DATA = "selectpharmacy.json";

	public static final String CATEGORY = "category";

	public static final String INDIVIDUAL = "Individual";

	public static final String ADD_PLAN_CONFIRMATION = "addplanconfirmation";

	private static final String ADD_PLAN_CONFIRMATION_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/registration/addplanconfirmation/";

	public static final String ADD_PLAN_CONFIRMATION_PAGE_DATA = "addplanconfirmation.json";

	public static final String ZIPCODE_SELECTION_PAGE_DATA = "zipselection.json";

	public static final String ZIPCODE_SELECTION_HOME_PAGE_DATA = "zipselectionhome.json";

	public static final long TIMEOUT_30 = 30;

	public static final long TIMEOUT_40 = 40;

	public static final String SELECTED_DRUG_INFORMATION_PAGE_DATA = "selectedDrugInformation.json";

	public static final String MANAGE_DRUG_PAGE_DATA = "managedrug.json";

	public static final String DRUG_LIST_PAGE_DATA = "druglist.json";

	public static final String SELECT_PHARMACIES_PAGE_DATA = "selectpharmacy.json";

	public static final String PHARMACY_INFORMATION_PAGE_DATA = "pharmacyInformation.json";

	public static final String GLOBAL_FOOTER_PAGE_DATA = "globalfooteractual.json";

	public static final String OLE_DTMOBJECT_PAGE_DATA = "oledtmObject.json";

	public static final String OLE_DTMOBJECT_PART2_PAGE_DATA = "oledtmObjectPart2.json";

	public static final String SITE_MAP_PAGE_DATA = "sitemap.json";

	public static final String ABOUT_US_PAGE_DATA = "aboutus.json";

	public static final String CONTACT_US_PAGE_DATA = "contactus.json";

	public static final String AGENTS_AND_BROKERS_PAGE_DATA = "agentsandbrokers.json";

	public static final String HOME_PAGE_DISCLAIMER_DATA = "viewalldisclaimer.json";

	public static final String GLOBAL_HEADER_PAGE_DATA = "globalheaderactual.json";

	public static final String ALREADY_PLAN_MEMBER_PAGE_DATA = "alreadyPlanMemberActual.json";

	public static final String HEADER_PAGE_DATA = "headeractual.json";

	public static final String ENROLL_PLAN_INFO_PAGE_DATA = "enrollinplan.json";

	public static final String MA_PLAN_INFORMATION_PAGE_DATA = "maplaninformation.json";

	public static final String PDP_PLAN_INFORMATION_PAGE_DATA = "pdpplaninformation.json";

	public static final String INTRODUCTION_INFORMATION_PAGE_DATA = "introductioninformation.json";

	public static final String BENEFICIARY_INFORMATION_PAGE_DATA = "beneficiaryinformation.json";

	public static final String SEP_INFORMATION_PAGE_DATA = "sepinformation.json";

	public static final String ESRD_PAGE_DATA = "esrd.json";

	public static final String PRESCRIPTION_DRUG_COVERAGE_PAGE_DATA = "prescriptiondrugcoverage.json";

	public static final String LONG_TERM_CARE_PAGE_DATA = "longtermcare.json";

	public static final String MEDICAID_PAGE_DATA = "medicaid.json";

	public static final String OTHER_HEALTH_INSURANCE_PAGE_DATA = "otherhealthinsurance.json";

	public static final String PRIMARY_CARE_PROVIDER_PAGE_DATA = "primarycareprovider.json";

	public static final String PLAN_PAYMENT_OPTION_PAGE_DATA = "planpaymentoption.json";

	public static final String OPTIONAL_RIDERS_PAGE_DATA = "optionalriders.json";

	public static final String PED_PAGE_DATA = "proposedEffectiveDate.json";

	public static final String MA_REVIEW_AND_SUMMIT_PAGE_DATA = "mareviewandsubmit.json";

	public static final String PDP_REVIEW_AND_SUMMIT_PAGE_DATA = "pdpreviewandsubmit.json";

	public static final String MA_ADDITIONAL_INFORMATION_PAGE_DATA = "maadditionalinformation.json";

	public static final String PDP_ADDITIONAL_INFORMATION_PAGE_DATA = "pdpadditionalinformation.json";

	public static final String MA_REVIEW_APPLICATION_PAGE_DATA = "mareviewapplication.json";

	public static final String PDP_REVIEW_APPLICATION_PAGE_DATA = "pdpreviewapplication.json";

	public static final String SUBMIT_APPLICATION_PAGE_DATA = "submitapplication.json";

	public static final String ENROLLMENT_CONFIRMATION_PAGE_DATA = "enrollmentconfirmation.json";

	public static final String LOGIN_ASSISTANCE_MESSAGE_PAGE_DATA = "loginassistancemessage.json";

	public static final String AGENT_CONFIRMATION_PAGE_DATA = "agentappointmentconfirmation.json";

	public static final String MA_VPP_PAGE_DATA = "maVpp.json";

	public static final String ENQUIRY_KIT_CONFIRMATION_PAGE_DATA = "enquirykitconfirm.json";

	public static final String HEALTH_AND_WELLNESS_PAGE_DATA = "healthandwellness.json";

	public static final String HEALTH_AND_WELLNESS = "healthandwellness";

	public static final String MEDICARE_EDUCATION_SECTION_DATA = "medicareEducationSectionActual.json";

	public static final String OUR_PLANS_NAV_PAGE_DATA = "ourPlansDropdownActual.json";

	public static final String HEALTH_AND_WELLNESS_DROPDOWN_DATA = "healthandwellnessdropdownactual.json";

	public static final String OUR_PLANS_DROPDOWN_DATA = "ourplansdropdownactual.json";

	public static final String PLAN_COMPARE_PAGE_DATA = "plancompare.json";

	public static final String PLAN_COMPARE_DETAILS = "plancomparedetails.json";

	public static final String PLAN_COMPARE = "plancompare";

	private static final String PLAN_COMPARE_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/plancompare/";

	public static final String PROVIDER_SEARCH_PAGE_DATA = "providersearch.json";

	public static final String SELECT_FORMULARY_PAGE_DATA = "selectformulary.json";

	public static final String ENTER_DRUG_PAGE_DATA = "enterdrug.json";

	public static final String RETIREE_EXPECTED_DIRECTORY = "/jsonresponse/uhcretiree/acquisition/";

	public static final String AUTO_DRUG_SEARCH_PAGE_DATA = "autocompletedrugsearch.json";

	private static final String ADD_PLAN_CONFIRMATION_ULAYER_DIRECTORY = "/jsonresponse/member/ulayer/registration/addplanconfirmation/";

	private static final String REGISTRATION_SUCCESS_BLUELAYER_DIRECTORY = "/jsonresponse/member/bluelayer/registration/registrationsuccess/";

	public static final String SECOND_PLAN_INFO_BLUELAYER_PAGE_DATA = "secondplaninfo.json";

	public static final String AARP_BROWSER_CHECK_DATA = "aarpbrowsercheck.json";

	public static final String UHC_BROWSER_CHECK_DATA = "uhcbrowsercheck.json";

	public static final String UHCM_BROWSER_CHECK_DATA = "uhcmbrowsercheck.json";

	public static final String AARPM_BROWSER_CHECK_DATA = "aarpmbrowsercheck.json";

	public static final String AARPM_SECURE_EMAIL_DATA = "aarpmsecureemailwidget.json";

	public static final String GR_BROWSER_CHECK_DATA = "uhcretireebrowsercheck.json";

	public static final String UHCM_MOBILE_BROWSER_CHECK_DATA = "browsercheck_uhcm.json";

	public static final String COBROWSE_MODEL_WINDOW = "cobrowse.json";

	public static final String Request_For_Assistance_PAGE_DATA = "requestforassistance.json";

	public static final String CONFIRMATION_PAGE_DATA = "confirmation.json";
	public static final String ULAYER_DRUGDOSAGEPAGE_EXPECTED_DIRECTORY = "drugdosage";
	public static final String ULAYER_ADDADRUG_DROPDOWN_DIRECTORY = "dropdown";
	public static final String ULAYER_LOWCOSTOPTIONS_EXPECTED_DIRECTORY = "lowcostoptions";
	public static final String ADD_DRUG_ULAYER_DRUG_TYPE = "drugtype";
	public static final String ADD_DRUG_ULAYER_PHARMACIES = "pharmacies";

	public static final String PLAN_DOC_PDF_ACQ_PAGE_DATA = "plandocumentspdf.json";

	public static final String B_AND_C_PDF_MEMBER_PAGE_DATA = "benefitsandcoveragepdfs.json";

	public static final String PLAN_PREV_PDF_PAGE_DATA = "planpreviewpdf.json";

	public static final String AARPM_FR_PDF_PAGE_DATA = "nextyearpdfs.json";
	public static final String FORMS_AND_RESOURCES_PLANMATERIAL_SECTION_PDFS = "planmaterialpdfs.json";
	public static final String FORMS_AND_RESOURCES_PLANMATERIAL_SECTION_PDFS_AARP = "plandocpdfs.json";
	public static final String REGISTRATION_ERROR_PAGE_DATA = "registrationerrorpage.json";

	public static final String LOGIN_ASSISTANCE_PERSONAL_IDENTIFICATION_ERROR_SCENARIO = "personalIdentificationErrorScenario.json";

	public static final String NEXT_YEAR = "nextyear";
	
	public static final String YEAR_BUTTON_VPPPAGE = "yearBtnVppPageExists";

	public static final String BENEFITS_AND_COVERAGE_MAPD_LIS_NONUS_PAGE_DATA = "planbenefitsandcoveragelisnotusother.json";

	public static final String SIERRA_PLAN_NAME = "UnitedHealthcare MedicareComplete Choice (PPO)";

	public static final String NEW_PAYMENT_HISTORY_ACTUAL_JSON = "newPaymentHistoryActualJSON";
	public static final String NEW_PAYMENT_HISTORY_EXPECTED_JSON = "newPaymentHistoryexpectedJSON";

	public static final String PROFILE_AND_PREFERENCES_REDESIGN_PAGE_DATA = "profilenpreferencesredesign.json";
	
	 public static final String REVIEW_AUTOMATIC_PAGE_DATA = "reviewautomaticactual.json";
	 
	 public static final String REVIEW_ONE_TIME_PAGE_DATA = "reviewonetimeactual.json";
	 
	 public static final String SAVE_DRUG_PAGE_DATA="savedrugpagedata.json";
	 
	 public static final String DCEstimator = "DCEstimator.json";
	 
	 public static final String ADD_DRUG_DETAILS_PAGE_DATA = "adddrugdetailspagedata.json";
	 
	 public static final String PAGE_OBJECT_DIRECTORY_DCE_MEMBER = "/page-objects/member/dashboard/drugcostestimator/";
	 
	 public static final String ADD_NEW_DRUG_PAGE_DATA = "addnewdrugpagedata.json";
	 
	 public static final String SWITCH_GENERIC_PAGE_DATA = "switchgenericpagedata.json";
	 
	 public static final String NEW_CLAIM_DETAILS_PAGE_DATA = "newClaimDetailsPage.json";
	 
	 public static final String SWITCH_GENERIC="switchgeneric.json";
	 
	 public static final String ADD_NEW_DRUG_MODAL = "addnewdrugmodal";
	 
	 public static final String PROFILE_AND_PREFERNCES_PAGE_DIRECTORY = "/jsonresponse/member/ulayer/profilesandprefereneces/";

	public static final String FORMS_AND_RESOURCES_ACTUAL = null;

	public static final String BENEFITS_AND_COVERAGE = "benefitsandcoverage" ;
	
	public static final String DRUGCOSTESTIMATORDATAPAGE = "DrugCostEstimatorPage.json";
	
	public static final String PLAN_NAME_ON_PROFILE_PAGE= "planName";
    //Browsers supported in MRScenario
	public static final String BROWSER_NAME = "browsername";
	public static final String BROWSER_VERSION = "browserversion";
    public static final String JENKINS_BROWSER_PHANTOMJS = "headless";
    public static final String DESKTOP_WEBDRIVER = "WebDriver";
	public static final String JENKINS_BROWSER = "webdriverhost";
    public static final String HTMLUNIT_BROWSER = "HTMLUNIT";
    public static final String FIREFOX_BROWSER = "FIREFOX";
    public static final String CHROME_BROWSER = "CHROME";
    public static final String IE_BROWSER = "IE";
    public static final String MOBILE_BROWSER = "MOBILE";   
    public static final String SAUCE_BROWSER_WEB = "saucelabs";
    public static final String SAUCE_BROWSER_MOBILE = "SAUCE_BROWSER_MOBILE";

    public static final String DESKTOP_BROWSER_AGENT_STRING = "BrowserAgentString";
    public static final String JENKINS_BROWSER_AGENT_STRING = "JENKINS_BROWSER_AGENT_STRING";
	public static final String ACCOUNT_USER_NAME = null;

	public static final String IS_TESTHARNESS = "IS_TESTHARNESS";

	public static final String COMMONSTEPDEFINITIONMEMVBF = "commonStepDefinition";
	public static final String IS_HSID_COMPATIBLE	 = "isHSIDCompatible";
	public static final String CATEGORY_TERMIATED	 = "TerminatedFed";
	public static final long TIMEOUT_60 = 60;
	public static final long TIMEOUT_90 = 90;
	public static final String SAUCELABS_TUNNEL_IDENTIFIER = "saucelabstunnel";
	//public static final String SAUCELABS_DEFAULT_TUNNEL = "OptumSharedTunnel-Stg";
	public static final String SAUCELABS_DEFAULT_TUNNEL = "Optum-Stage";
	public static String MAIN_WINDOW_HANDLE_ACQUISITION = null;
	public static final String SAUCELABS_DEFAULT_MOBILE_TUNNEL = "None";
	//public static final String SAUCELABS_MOBILE_TUNNEL_IDENTIFIER = "SAUCELABS_MOBILE_TUNNEL_IDENTIFIER";
	public static final String SAUCELABS_MOBILE_TUNNEL_IDENTIFIER = "OptumRDC_Manual_Stage";
	
	public static final String APPIUM_DEFAULT_VERSION = "1.17.0";
	//1.17.0
	public static final String APPIUM_VERSION = "APPIUM_VERSION";
	public static final String MOBILE_DEVICE_TYPE = "MOBILE_DEVICE_TYPE";
	public static final String MOBILE_DEVICE_TYPE_DEFAULT = "Real";
	
	public static final String SCREEN_RESOLUTION = "screenResolution";
	/*public static final String CONNECTION_URL = "jdbc:sqlserver://120.130.10.2:1433;" +
			  "database=GPSST04SVC_TRN;" + "user=qaread;" + "password=testreadonly;" +
			  "encrypt=true;" + "trustServerCertificate=false;" + "loginTimeout=30;";
	*/
	//public static final String CONNECTION_URL = "jdbc:oracle:thin:qaread/testreadonly@localhost:1521:GPSST04SVC_TRN";
	//public static final String CONNECTION_URL = "jdbc:oracle:thin:qaread/testreadonly@orass0464:1521:GPSST04SVC_TRN";
	//public static final String CONNECTION_URL = "jdbc:oracle:thin:qaread/testreadonly@orass0464:1521/gpsst04svc_trn.uhc.com";
	
	public static final String CONNECTION_URL = "jdbc:oracle:thin:qaread/testreadonly@dbslt0102:1521/gpsts18";
	public static final String GPS_QUERY = "Select MEDICAID_IND,\n" + 
			"MEDICAID_NUMBER,\n" + 
			"MAILING_ZIP_CD,\n" + 
			"MAILING_STATE_CD,\n" + 
			"MAILING_CITY,\n" + 
			"MAILING_ADDRESS_LINE_2,\n" + 
			"MAILING_ADDRESS_LINE_1,\n" + 
			"FIRST_NAME,\n" + 
			"MIDDLE_INITIAL,\n" + 
			"LAST_NAME,\n" + 
			"DATE_OF_BIRTH,\n" + 
			"GENDER,\n" + 
			"ADDRESS_LINE_1,\n" + 
			"ADDRESS_LINE_2,\n" + 
			"CITY,\n" + 
			"STATE_CD,\n" + 
			"ZIP_CD,\n" + 
			"DAYTIME_PHONE_NUM,\n" + 
			"EVENING_PHONE_NUM,\n" + 
			"PAPERLESS_PREFERENCE_IND,\n" + 
			"EMAIL,\n" + 
			"LANGUAGE_PREFERENCE,\n" + 
			"MEDICARE_NUMBER,\n" + 
			"MEDICARE_PART_A_EFFECTIVE_DATE,\n" + 
			"MEDICARE_PART_B_EFFECTIVE_DATE,\n" + 
			"DO_YOU_HAVE_OTHER_HEALTH_INS,\n" + 
			"OTHER_HEALTH_INSURANCE_NAME,\n" + 
			"OTHER_HEALTH_INSURANCE_GRP_NUM,\n" + 
			"OTHER_HEALTH_INSURANCE_ID,\n" + 
			"SECONDARY_RX_COVERAGE_NAME,\n" + 
			"OTHER_RX_COVERAGE_NAME,\n" + 
			"SECONDARY_RX_GROUP,\n" + 
			"SECONDARY_RX_ID,\n" + 
			"NOTE,\n" + 
			"REQUESTED_EFFECTIVE_DATE,\n" + 
			"PRIMARY_CARE_PHYSICIAN_NUMBER,\n" + 
			"XEROX_STAGE_ID,\n" +
			"PRIMARY_CARE_PHYSICIAN,\n" + 
			"DENTAL_PLATINUM from Xerox_stage where xerox_stage_id =\n" + 
			"";
	public static final String GPS_QUERY_1 ="Select\n" + 
			"FIRST_NAME,\n" + 
			"LAST_NAME from Xerox_stage where xerox_stage_id = ";
	public static final String DB_ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
}
