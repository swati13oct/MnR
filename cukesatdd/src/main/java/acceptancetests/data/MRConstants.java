package acceptancetests.data;

import atdd.framework.MRScenario;

/**
 * @author pjaising
 *
 */
public class MRConstants {
	public static final String AARPM_URL = "https://member." + MRScenario.environment + "-aarpmedicareplans."
			+ getDomain();
	public static final String AARPM_URL_OFFLINE = "https://member.offline.aarpmedicareplans.com";
	// public static final String UHCM_URL =
	// "https://member."+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() + "/guest/home.html";
	// public static final String AARP_URL =
	// "https://www.awe-"+MRScenario.environment+"-aarpmedicareplans." + getDomain()
	// + "/";
	public static final String AARP_URL = "https://www." + MRScenario.environment + "-aarpmedicareplans." + getDomain()
	+ "/";
	public static final String AARP_URL_NEW = "https://stage-0-aarpmedicareplans." + getDomain()
	+ "/";

	public static final String AARP_URL_OFFLINE = "https://offline.aarpmedicareplans.com/";
	public static final String AARP_URL_PROD = "https://www.aarpmedicareplans.com/";
	public static final String UHCM_URL_PROD = "https://www.uhcmedicaresolutions.com/";
	public static final String UHCM_URL = "https://member." + MRScenario.environment + "-uhcmedicaresolutions."
			+ getDomain() + "/guest/login.html";
	public static final String UHCM_URL_OFFLINE = "https://member.offline.uhcmedicaresolutions.com";
	
	public static final String FLAGSMITH_AARP_URL = "https://www." + MRScenario.environment + "-aarpmedicareplans." + getDomain() + "/fsem/featuretest.html";

	public static final String FLAGSMITH_OFFLINE_PROD_AARP_URL = AARP_URL_OFFLINE + "fsem/featuretest.html";

	public static final String FLAGSMITH_PROD_AARP_URL = AARP_URL_PROD + "fsem/featuretest.html";

	public static final String FLAGSMITH_STAGE0_AARP_URL = AARP_URL_NEW + "fsem/featuretest.html";
	
	public static final String FLAGSMITH_UHC_URL = "https://www." + MRScenario.environment + "-uhcmedicaresolutions." + getDomain() + "/fsem/featuretest.html";

	public static final String FLAGSMITH_OFFLINE_PROD_UHC_URL = "https://offline.uhcmedicaresolutions.com/fsem/featuretest.html";

	public static final String FLAGSMITH_PROD_UHC_URL = UHCM_URL_PROD + "fsem/featuretest.html";

	public static final String FLAGSMITH_STAGE0_UHC_URL = "https://stage-0-uhcmedicaresolutions." + getDomain() + "/fsem/featuretest.html";

	public static final String AARP_SYSTEM_DATE_URL = "https://www." + MRScenario.environment + "-aarpmedicareplans." + getDomain() + "/planbenefitsinfo/profiledetail/aarp";

	public static final String OFFLINE_PROD_AARP_SYSTEM_DATE_URL = AARP_URL_OFFLINE + "planbenefitsinfo/profiledetail/aarp";

	public static final String PROD_AARP_SYSTEM_DATE_URL = AARP_URL_PROD + "planbenefitsinfo/profiledetail/aarp";

	public static final String STAGE0_AARP_SYSTEM_DATE_URL = "https://stage-0-aarpmedicareplans." + getDomain() + "/planbenefitsinfo/profiledetail/aarp";

	public static final String UHC_SYSTEM_DATE_URL = "https://www." + MRScenario.environment + "-uhcmedicaresolutions." + getDomain() + "/planbenefitsinfo/profiledetail/aarp";

	public static final String OFFLINE_PROD_UHC_SYSTEM_DATE_URL = "https://offline.uhcmedicaresolutions.com/planbenefitsinfo/profiledetail/aarp";

	public static final String PROD_UHC_SYSTEM_DATE_URL = UHCM_URL_PROD + "planbenefitsinfo/profiledetail/aarp";

	public static final String STAGE0_UHC_SYSTEM_DATE_URL = "https://stage-0-uhcmedicaresolutions." + getDomain() + "/planbenefitsinfo/profiledetail/aarp";
	
	public static final String UHCCP_URL_PROD = "https://www.uhccommunityplan.com/";
	
	public static final String UHCCP_URL_STAGE = "https://uhccommunityplan-stage.uhc.com/";
	
	public static final String SERVER_DATE_SEP_30 = "09/30";
	public static final String SERVER_DATE_OCT_1 = "10/01";
	public static final String SERVER_DATE_OCT_14 = "10/14";
	public static final String SERVER_DATE_OCT_15 = "10/15";
	public static final String SERVER_DATE_NOV_30 = "11/30";
	public static final String SERVER_DATE_DEC_31 = "12/31";
	public static final String SERVER_DATE_JAN_1 = "01/01";
	
	// public static final String UHC_URL =
	// "https://www."+MRScenario.environment+"-uhcmedicarsolutions." + getDomain() +
	// "/";
	public static final String AUTHOR_URL = "http://apvrt73396:8080";
	public static final String AARP_PLANPREVIEW_URL = "https://www." + MRScenario.environment + "-aarpmedicareplans."
			+ getDomain() + "/plan-preview.html";

	public static final String UHC_PLANPREVIEW_URL = "https://www." + MRScenario.environment + "-uhcmedicaresolutions."
			+ getDomain() + "/plan-preview.html";

	public static final String UHCRETIREE_URL = "https://www." + MRScenario.environment + "-uhcretiree.uhc.com/";

	public static final String TEAM_UHCRETIREE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.ocp-ctc-dmz-nonprod.optum.com/";

	public static final String VERIZON_PROVIDER_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/verizon/find_a_provider.html";

	public static final String VERIZON_SITE_MAP_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/verizon/site_map.html";

	public static final String VERIZON_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/verizon/home.html";

	public static final String CALPERS_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/calpers/home.html";

	public static final String JOHNSONANDJOHNSON_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/jnj/home.html";

	public static final String METLIFE_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/metlife/home.html";

	public static final String San_Francisco_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/sfhss/home.html";

	public static final String KTRS_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/ktrs/home.html";

	public static final String PFIZER_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/pfizer/home.html";

	public static final String NCSHP_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/ncshp/home.html";

	public static final String SDCERA_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/content/gr/en/sdcera/home.html";

	public static final String UHCRETIREE_SITE_MAP_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/site_map.html";

	// public static final String UHCRETIREE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/";

	// public static final String VERIZON_PROVIDER_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/verizon/find_a_provider.html";

	// public static final String VERIZON_SITE_MAP_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/verizon/site_map.html";

	// public static final String VERIZON_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/verizon/home.html";

	// public static final String CALPERS_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/calpers/home.html";

	// public static final String JOHNSONANDJOHNSON_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/jnj/home.html";

	// public static final String METLIFE_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/metlife/home.html";

	// public static final String San_Francisco_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/sfhss/home.html";

	// public static final String KTRS_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/trs/home.html";

	// public static final String PFIZER_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/pfizer/home.html";

	// public static final String NCSHP_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/ncshp/home.html";

	// public static final String SDCERA_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/content/gr/en/sdcera/home.html";

	// public static final String UHCRETIREE_SITE_MAP_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/site_map.html";

	// public static final String UHC_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() + "/";
	public static final String UHC_URL = "https://www." + MRScenario.environment + "-uhcmedicaresolutions."
			+ getDomain() + "/";

	public static final String UHC_URL_NEW = "https://stage-0-uhcmedicaresolutions."
			+ getDomain() + "/";
//	public static final String CHARGERS_UHC_URL="https://chargers-uhc."+ getDomain() + "/medicare/";
//	
//	public static final String UHC_TEST2_URL="https://uhc-test2."+ getDomain() + "/medicare/";
//	
//	public static final String UHC_STAGE_URL="https://uhc-stg."+ getDomain() + "/medicare/";
	
	public static final String CHARGERS_UHC_URL="https://chargers-uhc."+ getDomain() + "/ums-test-page";
	
	public static final String UHC_TEST2_URL="https://uhc-test2."+ getDomain() + "/medicare/";
	
	public static final String UHC_STAGE_URL="https://uhc-stg."+ getDomain() + "/ums-test-page";
	
	public static final String UHC_OFFLINE_STAGE_URL="https://uhc-stg."+ getDomain() + "/ums-test-page";
	
	public static final String UHC_URL_OFFLINE = "https://offline.uhcmedicaresolutions.com/";


	public static final String MEDICA_REGISTRATION_URL = "https://www.awe-" + MRScenario.environment
			+ "-mymedicamedicare.uhc.com/guest/registration.html";

	public static final String MEDICA_PASSWORD_ASSISTANCE_URL = "https://www.awe-" + MRScenario.environment
			+ "-mymedicamedicare.uhc.com/guest/login/username-and-password-assistance.html";

	public static final String AARPM_REGISTRATION_URL = "https://member." + MRScenario.environment
			+ "-aarpmedicareplans." + getDomain() + "/guest/registration.html";

	public static final String PCP_MOBILE_URL = "https://member.awe-" + MRScenario.environment
			+ "-mypcpmedicare.uhc.com/mobile/guest/login.html";
	public static final String PCP_REGISTRATION_URL = "https://www.awe-" + MRScenario.environment
			+ "-mypcpmedicare.uhc.com/guest/registration.html";

	public static final String PCP_PASSWORD_ASSISTANCE_URL = "https://www.awe-" + MRScenario.environment
			+ "-mypcpmedicare.uhc.com/guest/login/username-and-password-assistance.html";

	public static final String MEM_AUTH_URL = "https://awe-stage-generic.uhc.com/content/medicare/memberauth.html";
	
	public static final String AMP_URL = "https://www.stage-aarpmedicareplans.uhc.com/dolphin-authoring/redesigned-home-page.html";

	public static final String UMS_URL = "https://www.stage-uhcmedicaresolutions.uhc.com/dolphin-authoring/redesigned-home-page.html";
	
	public static final String PCP_PAGE_URL = "https://www.awe-" + MRScenario.environment + "-mypcpmedicare.uhc.com/";

	public static final String MEDICA_PAGE_URL = "https://www.awe-" + MRScenario.environment
			+ "-mymedicamedicare.uhc.com/";

	public static final String UHCM_REGISTRATION_URL = "https://member." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain() + "/guest/registration.html";

	public static final String AARP_OUR_PLANS_URL = "https://www." + MRScenario.environment + "-aarpmedicareplans."
			+ getDomain() + "/health-plans.html";

	public static final String UHC_OUR_PLANS_URL = "https://www." + MRScenario.environment + "-uhcmedicaresolutions."
			+ getDomain() + "/health-plans.html";

	public static final String GOOGLE_SEARCH_ENGINE_URL = "https://www.google.com";

	public static final String YAHOO_SEARCH_ENGINE_URL = "https://www.yahoo.com";

	public static final String BING_SEARCH_ENGINE_URL = "https://www.bing.com";

	public static final String AARPM_MOBILE_URL = "https://member.awe-" + MRScenario.environment + "-aarpmedicareplans."
			+ getDomain() + "/mobile/guest/login.html";

	public static final String UHCM_MOBILE_URL = "https://member.awe-" + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain() + "/mobile/guest/login.html";

	public static final String MRREST_TIME_ADMIN_URL = "https://" + MRScenario.environment
			+ "-generic.uhc.com/MRRestWAR/rest/zadmin/time/";
	public static final String AARP_SITE_MAP_PAGE_URL_OFFLINE = "https://" + MRScenario.environment
			+ ".aarpmedicareplans.com" + "/sitemap.html";

	public static final String MA_PLAN_PRES_DRUGS_TRANSITION_PLANS_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain()
			+ "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/ma-drug-transition.html";

	public static final String MA_HOW_TO_APPOINT_REPRESENTIVE_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain()
			+ "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/how_to_appoint_a_representative.html";
	public static final String PARTD_TIME_ADMIN_URL = "https://" + MRScenario.environment
			+ "-generic.uhc.com/PartDPortalWeb/rest/zadmin/time/";

	public static final String GENERIC_PORTLET_URL = "https://portal.uhc.com/bConnectedDCE/home.html";

	public static final String UHCRETIREE_OEHWF_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/oehwf/home.html";

	public static final String OEHWF_SITE_MAP_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/oehwf/site_map.html";

	public static final String UHCRETIREE_TRAVELERS_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/travelers/home.html";

	public static final String TRAVELERS_SITE_MAP_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/travelers/site_map.html";

	public static final String UHCRETIREE_SITE_MAP_TRAVELERS_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/travelers/site_map.html";

	public static final String UHCRETIREE_EDISON_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/edison/home.html";

	public static final String UHCRETIREE_ASRS_PAGE = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/asrs/home.html";

	public static final String UHCRETIREE_SHBP_PAGE = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/shbp/home.html";

	public static final String UAW_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/uawtrust/home.html";

	public static final String ILLINOIS_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/soi/home.html";

	public static final String MA_ENROLLMENT_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain()
			+ "/health-plans/medicare-advantage-plans/medicare-enrollment.html";

	public static final String MA_PLAN_INFORMATION_AND_PLANS_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain()
			+ "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms.html";

	public static final String MA_PLANS_AND_GRIEVANCES_URL = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain()
			+ "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/medicare-appeal.html";

	public static final String MA_RIGHTS_AND_RESPONSIBILITIES_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain()
			+ "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/medicare-rights-center.html";

	public static final String AARP_SITE_MAP_PAGE_URL = "https://www." + MRScenario.environment + "-aarpmedicareplans."
			+ getDomain() + "/sitemap.html";

	// public static final String MA_PLAN_PRES_DRUGS_TRANSITION_PLANS_PAGE_URL =
	// "https://www."+MRScenario.environment+"-uhcmedicaresolutions." + getDomain()
	// +
	// "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/ma-drug-transition.html";

	// public static final String MA_HOW_TO_APPOINT_REPRESENTIVE_PAGE_URL =
	// "https://www."+MRScenario.environment+"-uhcmedicaresolutions." + getDomain()
	// +
	// "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/how_to_appoint_a_representative.html";

	public static final String OUR_PLANS_MA_HOW_TO_PAY_YOUR_PREMIUM_URL = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain()
			+ "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/how_to_pay_your_premium.html";

	public static final String MA_REQUEST_MORE_HELP_AND_INFORMATION_URL = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain()
			+ "/health-plans/medicare-advantage-plans/resources-plan-material.html";

	public static final String MA_RESOURCES_AND_PLAN_TAB_URL = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain()
			+ "/health-plans/medicare-advantage-plans/resources-plan-material.html";

	// public static final String UHCRETIREE_OEHWF_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/oehwf/home.html";

	// public static final String OEHWF_SITE_MAP_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/oehwf/site_map.html";

	// public static final String UHCRETIREE_TRAVELERS_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/travelers/home.html";

	// public static final String TRAVELERS_SITE_MAP_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/travelers/site_map.html";

	// public static final String UHCRETIREE_SITE_MAP_TRAVELERS_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/travelers/site_map.html";

	// public static final String UHCRETIREE_EDISON_URL
	// ="https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/edison/home.html";

	// public static final String UHCRETIREE_ASRS_PAGE =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/asrs/home.html";

	// public static final String UHCRETIREE_SHBP_PAGE =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/shbp/home.html";

	// public static final String UAW_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/uawtrust/home.html";

	// public static final String ILLINOIS_HOME_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcretiree.uhc.com/soi/home.html";

	// public static final String MA_ENROLLMENT_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() +
	// "/health-plans/medicare-advantage-plans/medicare-enrollment.html";

	// public static final String MA_PLAN_INFORMATION_AND_PLANS_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() +
	// "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms.html";

	// public static final String MA_PLANS_AND_GRIEVANCES_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() +
	// "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/medicare-appeal.html"
	// ;

	// public static final String MA_RIGHTS_AND_RESPONSIBILITIES_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() +
	// "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/medicare-rights-center.html"
	// ;

	// public static final String AARP_SITE_MAP_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-aarpmedicareplans." + getDomain()
	// + "/sitemap.html";

	// public static final String MA_PLAN_PRES_DRUGS_TRANSITION_PLANS_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() +
	// "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/ma-drug-transition.html";

	// public static final String MA_HOW_TO_APPOINT_REPRESENTIVE_PAGE_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() +
	// "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/how_to_appoint_a_representative.html";

	// public static final String OUR_PLANS_MA_HOW_TO_PAY_YOUR_PREMIUM_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() +
	// "/health-plans/medicare-advantage-plans/resources-plan-material/ma-medicare-forms/how_to_pay_your_premium.html";

	// public static final String MA_REQUEST_MORE_HELP_AND_INFORMATION_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() +
	// "/health-plans/medicare-advantage-plans/resources-plan-material.html";

	// public static final String MA_RESOURCES_AND_PLAN_TAB_URL =
	// "https://www.awe-"+MRScenario.environment+"-uhcmedicaresolutions." +
	// getDomain() +
	// "/health-plans/medicare-advantage-plans/resources-plan-material.html";

	public static final String SERVER_DATE_PARTD_PORTAL_WEB = "https://" + MRScenario.environment
			+ "-generic.uhc.com/PartDPortalWeb/jsp/zadmin/timeAdmin.jsp?server=1";

	public static final String SERVER_DATE_MR_REST_WAR = "https://" + MRScenario.environment
			+ "-generic.uhc.com/MRRestWAR/jsp/zadmin/timeAdmin.jsp?server=1";

	public static final String UHCM_MEMBER_URL = "https://member." + MRScenario.environment + "-uhcmedicaresolutions."
			+ getDomain() + "/guest/home.html";

	public static final String UHCM_MOBILE_TEAM_C_URL = "https://member." + MRScenario.environment
			+ "-uhcmedicaresolutions." + getDomain() + "/mobile/guest/login.html";

	public static final String AARP_MOBILE_TEAM_C_URL = "https://member." + MRScenario.environment
			+ "-aarpmedicareplans." + getDomain() + "/mobile/guest/login.html";

	public static final String REDESIGN_AARPM_URL = "https://member." + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com/content/medicare/member/contact-us/overview.html";

	public static final String AARPM_URL_TEAMB_TESTHARNESS = "https://member." + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com/content/medicare/login/overview.html?testharness=true";

	public static final String TEAMH_URL_TESTHARNES = "https://" + MRScenario.environment
			+ "-werally.uhc.com/medicare/login/overview.html?testharness=true";

	public static final String TEAM_MEDICARE_TESTHARNESS = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/?testharness=true";

	public static final String STAGE_DASHBOARD_NEW_DOMAIN_URL = "https://" + MRScenario.environment
			+ "-medicare.uhc.com/";

	public static final String TEAM_CI1_NEW_DASBOARD_URL = "https://team-ci1-medicare.ose-elr-core.optum.com/";

	public static final String AARP_MOBILE_TEAM_URL = "https://member." + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com/mobile/guest/login.html";

	public static final String UHCM_URL_REDESIGN = "https://member." + MRScenario.environment
			+ "-uhcmedicaresolutions.uhc.com/content/uhcm/home//testharness.html";

	public static final String MEDICARE_UHC_REDESIGN = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/medicare/login/overview.html?testharness=true";

	public static final String AARPM_URL_RESEDIGN = "https://member." + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com/#?target=test-harness";

	public static final String UHCM_URL_TEAMB_TESTHARNESS = "https://member." + MRScenario.environment
			+ "-uhcmedicaresolutions.uhc.com/content/medicare/login/overview.html?testharness=true";

	public static final String STAGE_URL_TESTHARNES = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/?testharness=true";

	public static String TeamC_VPP_PAGE_AARPM_URL = "https://www." + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com";

	public static String Local_URL = "https://www.aarpmedicareplans.com/";

	public static final String TeamDigital_AARP_URL = "https://digital-uat-" + MRScenario.environment
			+ ".ocp-elr-core-nonprod.optum.com/";

	public static final String TeamDigital_UHC_URL = "https://digital-uat-" + MRScenario.environment
			+ ".ocp-elr-core-nonprod.optum.com/";

	public static final String TeamC_ULayer_Member_URL = "https://member." + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com";

	public static final String TeamH_ULayer_Member_URL = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com";

	public static final String TEAMB_TIME_ADMIN_PAGE_URL = "http://apsrt0245.uhc.com:9083/DCERestWAR/dcerest/timeAdmin";

	public static final String Stage_UNPWAssistancePage_URL = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/content/medicare/login/reset.html#/start";

	public static String TeamC_MultipleEmail_address_URL = "https://member." + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com/content/dashboard/guest/multipleemailaddress.html";

	public static String DEREGISTER_STAGE_URL = "https://apsrs0261.uhc.com:9443/PartDPortalWeb/deregister.jsp";

	public static final String MEMBER_AUTH_REDESIGN_LOGIN_URL = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/content/dashboard/guest/memberauth.html#/memberAuthLogin";

	public static final String NEW_REDESIGN_URL = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/login/overview.html?testharness=true";

	public static final String NEW_REDESIGN_REGISTRATION_URL = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/content/medicare/member-registration.html#/memberRegistration";

	public static final String NEW_REDESIGN_STAGE_REGISTRATION_URL = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/medicare/member-registration.html#/get-started";

	public static final String TeamH_BLayer_Member_URL = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/";

	public static final String BNCBURL = "https://member." + MRScenario.environment + "-uhcmedicaresolutions.uhc.com/";

	public static final String HSIDURL = "https://" + MRScenario.environment + "-medicare.uhc.com/";

	public static final String UHCM_TEAM_E_URL = "https://member." + MRScenario.environment
			+ "-uhcmedicaresolutions.uhc.com";

	// old public static final String MEMBER_AUTH =
	// "https://"+MRScenario.environment+"-generic."+
	// getDomain()+"/content/medicare/memberauth.html#/memberAuthLogin";
	public static final String MEMBER_AUTH = "https://" + MRScenario.environment + "-mnrgeneric2." + getDomain()
	+ "/content/medicare/memberauth.html#/memberAuthLogin";

	public static final String MEMBER_AUTH_STAGE = "https://" + MRScenario.environment
			+ "-generic.uhc.com/content/medicare/memberauth.html#/memberAuthLogin";

	public static final String MEMBER_AUTH_TEAM = "https://" + MRScenario.environment
			+ "-medicare.ose-elr-core.optum.com/content/medicare/memberauth.html#/memberAuthLogin";

	public static final String PORTFOLIO_PAGE_URL = "https://www." + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com";

	public static String CAMPAIGN_PAGE_URL1 = "https://www." + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/available-plans.html?msg=nonzero&lang=sp&zipcode=90003&WT.mc_id=832467";

	public static String CAMPAIGN_PAGE_URL2 = "https://www." + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com/health-plans/medicare-advantage-plans/available-plans.html?msg=zero&lang=en&zipcode=02211&WT.mc_id=832467";

	public static String EOB_DIRECT_URL = "https://" + MRScenario.environmentMedicare + "-medicare.uhc.com";

	public static final String DEEPLINK_URL = "https://" + MRScenario.environment
			+ "-werally.uhc.com/login.html?TARGET=SMSR";

	public static final String EATON_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/eaton/home.html";

	public static final String NOKIA_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/nokia/home.html";

	public static final String NONCUSTOM_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/noncustomgroups/home.html";

	public static final String OELOCAL12_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/oelocal12/home.html";

	public static final String PEEHIP_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/peehip/home.html";

	public static final String UNIVERSITYOFMISSOURI_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/umsystem/home.html";

	public static final String WELLSFARGO_HOME_PAGE_URL = "https://www." + MRScenario.environment
			+ "-uhcretiree.uhc.com/wf/home.html";

	public static final String PORTFOLIO_PAGE_UHC_URL = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions.uhc.com/health-plans.html";

	public static String TeamC_UHC_VPP_URL = "https://www." + MRScenario.environment + "-uhcmedicaresolutions.uhc.com";

	public static final String Connector_model_url1 = "https://www." + MRScenario.environment
			+ "-uhcmedicaresolutions.uhc.com/health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897509&zipcode=32337&county=320&state=10&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Foptions&subdomain=options";

	public static final String SIGNINPAGE_MEMREDESIGN = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/";

	public static final String BLUE_LAYER_TEST_HARNESS_LINK = "https://member." + MRScenario.environment
			+ "-uhcmedicaresolutions.uhc.com/content/uhcm/home/testharness.html";

	public static final String TEAM_G_DEREGISTER_URL = "http://partd-teamg.ose.optum.com/PartDPortalWeb/deregister.jsp";

	public static final String REDESIGN_REGISTRATION_URL = "https://" + MRScenario.environmentMedicare
			+ "-medicare.uhc.com/medicare/member-registration.html#/get-started";

	public static final String DASHBOARD_URL = "https://" + MRScenario.environmentMedicare + "-medicare.uhc.com/";

	public static final String REDESIGN_LOGIN_URL = "https://" + MRScenario.environmentMedicare + "-medicare."
			+ getDomain();

	public static final String TEAM_T_NEW_TESTHANESS_URL = "https://team-t-medicare.ose-elr-core.optum.com/medicare/login/overview.html?testharness=true";

	public static final String STAGE_SSO_TESTHANESS_URL = "http://apsrs7264.uhc.com:8080/content/admin-tools/sso-test.html";

	public static final String AARP_TELESALES_AGENT_PAGE_URL = "https://www." + MRScenario.environment
			+ "-aarpmedicareplans.ocp-ctc-dmz-nonprod.optum.com/admin/shopper-profile.html/login";

	public static final String AARP_TELESALES_AGENT_PAGE_URL_STAGE = "https://" + MRScenario.environment
			+ "-aarpmedicareplans.uhc.com/admin/shopper-profile.html/login";

	public static final String AARP_TELESALES_AGENT_TEAM_E_PAGE_URL = "https://www.team-e-aarpmedicareplans.ocp-elr-core-nonprod.optum.com/admin/shopper-profile.html/login";

	public static final String AARP_TELESALES_AGENT_TEAM_CHARGERS_PAGE_URL = "https://www.chargers-qa-aarpmedicareplans.ocp-elr-core-nonprod.optum.com/admin/shopper-profile.html/login";

	public static final String AARP_TELESALES_AGENT_PAGE_URL_Team = "https://www." + MRScenario.environment
			+ "-aarpmedicareplans.ocp-elr-core-nonprod.optum.com/admin/shopper-profile.html/login";

	public static final String Team_H_NEW_URL_TESTHARNESS = "https://www.team-h-medicare.ocp-ctc-dmz-nonprod.optum.com/content/login/overview.html?testharness=true";

	public static String getDomain() {
		return (MRScenario.domain == null || MRScenario.domain.equals("")) ? "uhc.com" : MRScenario.domain;
	}

	// public static final String HSIDURL = "https://" + MRScenario.environment +
	// "-medicare.uhc.com/";
	public static final String TESTHARNESS = "https://" + MRScenario.environment + "-medicare." + MRScenario.domain
			+ "/content/medicare/login/overview.html/?testharness=true";
	public static final String TEAMCI_TESTHARNESS = "https://" + MRScenario.environment + "-medicare."
			+ MRScenario.domain + "/?testharness=true";
	public static final String DASHBOARD = "https://" + MRScenario.environment + "-medicare.uhc.com/";

	/** DeRegister URLs */
	public static final String STAGE_DEREGISTER_URL = "https://apsrs0261." + MRScenario.domain
			+ ":9443/PartDPortalWeb/deregister.jsp ";
	public static final String TEANCI_DEREGISTER_URL = " http://partdexternal-" + MRScenario.environment + "."
			+ MRScenario.domain + "/PartDPortalWeb/deregister.jsp";
	public static final String TEAM_H_DEREGISTER_URL = "http://partd-teamh.ose.optum.com/PartDPortalWeb/deregister.jsp";
	public static final String TEST_A_DEREGISTER_URL = "https://apsrt0245.uhc.com:9443/PartDPortalWeb/deregister.jsp";
	public static final String HEALTH_AND_WELLNESS_TESTHARNESS = "https://" + MRScenario.environment + "-medicare."
			+ MRScenario.domain + "/content/medicare/member/health-and-wellness.html";
	public static final String PROVIDER_TESTHARNESS = "https://member.int.uhc.com/aarp/find-care";
	public static final String MEMBER_AUTH_REDESIGN_URL = "https://awe-stage-generic.uhc.com/content/medicare/memberauth.html ";

	// public static final String TEANCI_1_DEREGISTER_URL = "
	// http://partdexternal-team-ci1.ose-elr-core.optum.com/PartDPortalWeb/deregister.jsp";
	/*
	 * public static final String MEDICA_REGISTRATION_URL =
	 * "https://www.awe-"+MRScenario.environment+
	 * "-mymedicamedicare.uhc.com/guest/registration.html";
	 * 
	 * public static final String MEDICA_PASSWORD_ASSISTANCE_URL =
	 * "https://www.awe-"+MRScenario.environment+
	 * "-mymedicamedicare.uhc.com/guest/login/username-and-password-assistance.html";
	 * 
	 * public static final String AARPM_REGISTRATION_URL =
	 * "https://member."+MRScenario.environment+
	 * "-aarpmedicareplans.uhc.com/guest/registration.html"; public static final
	 * String UHCM_REGISTRATION_URL = "https://member."+MRScenario.environment+
	 * "-uhcmedicaresolutions.uhc.com/guest/registration.html"; public static final
	 * String MEMBER_AUTH_REDESIGN_LOGIN_URL =
	 * "https://awe-stage-generic.uhc.com/content/medicare/memberauth.html "; public
	 * static final String REDESIGN_REGISTRATION_URL =
	 * "https://stage-medicare.uhc.com/medicare/member-registration.html";
	 */

	public static final String LEGACY_REDESIGN = "/content/medicare/login/memberRedesign.html";
	public static final String LEGACY_TESTHARNESS = "https://" + MRScenario.environment + "-medicare."
			+ MRScenario.domain + LEGACY_REDESIGN + "/?testharness=true";
	public static final String LEGACY_DASHBOARD = "https://" + MRScenario.environment + "-medicare." + MRScenario.domain
			+ LEGACY_REDESIGN;
	public static final String MEMBER_AUTH_PLM_REDESIGN_URL = "https://stage-generic.uhc.com/content/medicare/memberauth.html#/memberAuthLogin";
	public static final String TeamC_UHC_URL = "https://www.team-c-uhcmedicaresolutions.ose-elr-core.optum.com";
	public static final String LEGACY_PCP_TESTHARNESS = "https://" + MRScenario.environment + "-mymedicareaccount."
			+ MRScenario.domain + LEGACY_REDESIGN + "/?testharness=true";
	public static final String OSE_NEW_URL = "https://www." + MRScenario.environment + "-medicare." + MRScenario.domain
			+ "/?testharness=true";
	public static final String OSE_NEW_URL_PCP_OR_MEDIA = "https://www." + MRScenario.environment
			+ "-mymedicareaccount." + MRScenario.domain
			+ "/content/medicare/login/memberRedesign.html?testharness=true";
	public static final String OFFLINE_STAGE_TESTHARNESS = "https://" + MRScenario.environment + "-medicare."
			+ MRScenario.domain + "/medicare/login/overview.html?testharness=true";
	// public static final String OFFLINE_STAGE_TESTHARNESS = "https://"+
	// MRScenario.environment +"-medicare."+MRScenario.domain+"/?testharness=true";
	public static final String TEAM_ATEST_URL = "https://www." + MRScenario.environment + "-medicare."
			+ MRScenario.domain + "/AARP";
	public static final String TEAM_ATEST_URL_PCP_OR_MEDIA = "https://www." + MRScenario.environment
			+ "-mymedicareaccount." + MRScenario.domain
			+ "/content/medicare/login/memberRedesign.html?testharness=true";

	// vvv note:
	public static final String OFFLINE_PROD_MEMBER_AUTH = "https://offline-generic.uhc.com/memberonlineaccount#/memberAuthLogin";
	public static final String ONLINE_PROD_MEMBER_AUTH = "https://generic.uhc.com/memberonlineaccount#/memberAuthLogin";
	public static final String TEAMH_MEMBER_AUTH = "https://www.team-h-medicare.ocp-ctc-dmz-nonprod.optum.com/content/medicare/memberauth.html#/memberAuthLogin";
	// ^^^ note:
	public static final String STAGE_SSO_TESTHANESS_URL_bswift = "http://apsrd9524.uhc.com:9080/adapterTest2/ucpInboundTestHarness.html";

	public static final String MICROAPP_URL = "https://www." + MRScenario.environment
			+ "test-medicare.ocp-elr-core-nonprod.optum.com/";

	public static final String OSE_NEW_URL_PCP_OR_MEDIA_MICROAPP = "https://www." + MRScenario.environment
			+ "test-mymedicareaccount.ocp-elr-core-nonprod.optum.com/content/medicare/login/memberRedesign.html?testharness=true";

	public static final String STAGE_DEEPLINK_URL_payments = "https://stage-medicare.uhc.com/?TARGET=SMSR/medicare/member/payments/overview.html%3fdeeplink=true";
	public static final String STAGE_DEEPLINK_URL_claims = "https://stage-medicare.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true";
	public static final String STAGE_DEEPLINK_URL_eob = "https://stage-medicare.uhc.com/?TARGET=SMSR/member/eob.html%3fdeeplink=true";
	public static final String STAGE_DEEPLINK_URL_accountProfile = "https://stage-medicare.uhc.com/?TARGET=SMSR/member/account/profile.html%3fdeeplink=true";
	public static final String STAGE_DEEPLINK_URL_coverageandBenefit = "https://stage-medicare.uhc.com/?TARGET=SMSR/member/benefits/overview.html%3fdeeplink=true";
	public static final String STAGE_DEEPLINK_URL_health_and_wellness = "https://stage-medicare.uhc.com/?TARGET=SMSR/member/health-and-wellness.html%3fdeeplink=true";
	public static final String STAGE_DEEPLINK_URL_my_Documents = "https://stage-medicare.uhc.com/?TARGET=SMSR/member/documents/overview.html%3fdeeplink=true";
	public static final String AARP_CHAT_AGENT = "https://stg-wwe.uhc.com/ui/ad/v1/index.html";
	public static final String STAGE_DEEPLINK_URL_payments_overview = "https://stage-medicare.uhc.com/member/payments/overview.html";
	public static final String STAGE_DEEPLINK_URL_payments_overview_new = "https://stage-medicare.uhc.com/member/payments/overview-new.html";

	public static String PROV_NAME = "";
	public static String BEHAV_NAME = "";
	public static String DENT_NAME = "";
	public static final String AARP_HAWL = "http://stage-myaarpmedicare.uhc.com/extras";
	// public static final String
	// AARP_HAWL="https://stage-medicare.uhc.com/?TARGET=SMSR/healthlineu/health/uhcarticle/hwal-introducing-at-your-best%3fdeeplink=true";
	public static final String UHC_DEEPLINK_URL_Pharmacy = "http://stage-myuhcmedicare.uhc.com/hwp";
	public static final String AARP_DEEPLINK_URL_Pharmacy = "http://stage-myaarpmedicare.uhc.com/hwp";
	public static final String PCP_DEEPLINK_URL_Pharmacy = "http://stage-mypcpmedicare.uhc.com/hwp";
	public static final String Medica_DEEPLINK_URL_Pharmacy = "http://stage-mymedicamedicare.uhc.com/hwp";
	public static final String UHC_DEEPLINK_URL_VirtualVisit = "http://stage-myuhcmedicare.uhc.com/virtualvisits";
	public static final String AARP_DEEPLINK_URL_VirtualVisit = "http://stage-myaarpmedicare.uhc.com/virtualvisits";
	public static final String PCP_DEEPLINK_URL_VirtualVisit = "http://stage-mypcpmedicare.uhc.com/virtualvisits";
	public static final String Medica_DEEPLINK_URL_VirtualVisit = "http://stage-mymedicamedicare.uhc.com/virtualvisits";

	public static final String STAGE_DEEPLINK_URL_my_Documents_Edelivery = "https://stage-medicare.uhc.com/?TARGET=SMSR/medicare/member/my-documents/overview.html%3fdeeplink=true&WT.mc_ID=8003461&mrcid=email_fed_m";
	public static final String Offline_PROD_UHC_DEEPLINK_URL_VirtualVisit = "https://offline.myuhcmedicare.com/virtualvisits";
	public static final String Offline_PROD_AARP_DEEPLINK_URL_VirtualVisit = "https://offline.myaarpmedicare.com/virtualvisits";
	public static final String Offline_PROD_PCP_DEEPLINK_URL_VirtualVisit = "https://offline.mypcpmedicare.com/virtualvisits";
	public static final String Offline_PROD_Medica_DEEPLINK_URL_VirtualVisit = "https://offline.mymedicamedicare.com/virtualvisits";
	public static final String Offline_PROD_UHC_DEEPLINK_URL_HWP = "https://offline.myuhcmedicare.com/hwp";
	public static final String Offline_PROD_AARP_DEEPLINK_URL_HWP = "https://offline.myaarpmedicare.com/hwp";
	public static final String Offline_PROD_PCP_DEEPLINK_URL_HWP = "https://offline.mypcpmedicare.com/hwp";
	public static final String Offline_PROD_Medica_DEEPLINK_URL_HWP = "https://offline.mymedicamedicare.com/hwp";
	public static String AARP_GUEST_PAYMENTS_PAGE_URL = "https://" + MRScenario.environment + "-paymyaarppremium."
			+ "uhc.com";
	public static String UHC_GUEST_PAYMENTS_PAGE_URL = "https://" + MRScenario.environment + "-paymyuhcpremium."
			+ "uhc.com";
	public static String RETIREE_GUEST_PAYMENTS_PAGE_URL = "https://" + MRScenario.environment + "-paymyuhcpremium."
			+ "uhc.com" + "/retiree";
	public static String PCP_GUEST_PAYMENTS_PAGE_URL = "https://" + MRScenario.environment + "-paymypcppremium."
			+ "uhc.com";
	public static String MEDICA_GUEST_PAYMENTS_PAGE_URL = "https://" + MRScenario.environment + "-paymymedicapremium."
			+ "uhc.com";

	public static String AARP_GUEST_PAYMENTS_PAGE_URL_PROD = "https://www.medicare.uhc.com/aarp/premium-payment/#/";
	public static String UHC_GUEST_PAYMENTS_PAGE_URL_PROD = "https://www.medicare.uhc.com/premium-payment/#/";
	public static String RETIREE_GUEST_PAYMENTS_PAGE_URL_PROD = "https://www.medicare.uhc.com/retiree/premium-payment/#/";
	public static String PCP_GUEST_PAYMENTS_PAGE_URL_PROD = "https://www.medicare.uhc.com/pcp/premium-payment/#/";
	public static String MEDICA_GUEST_PAYMENTS_PAGE_URL_PROD = "https://www.medicare.uhc.com/medica/premium-payment/#/";
	public static String GUEST_PAYMENTS_PAGE_URL_TEAM_A_TEST = "https://www.team-atest-medicare.ocp-elr-core-nonprod.optum.com/content/medicare/guest-payment.html/#/";

	public static final String Offline_PROD_SHIP_extra = "https://offline.myaarpmedicare.com/Extras";
	public static final String Offline_PROD_edelivery = "https://offline.medicare.uhc.com/?TARGET=SMSR/medicare/member/my-documents/overview.html%3fdeeplink=true&WT.mc_ID=8003461&mrcid=email_fed_m";

	public static String DENTEGRA_DENTAL_DEEPLINK_URL = "https://stage-myaarpmedicare.uhc.com/dental";

	public static final String D_Rx_TESTHARNESS = "https://" + MRScenario.environment + "-medicare." + MRScenario.domain
			+ "/?testharness=true";
	public static final String PROD_UHC_DEEPLINK_URL_VirtualVisit = "https://myuhcmedicare.com/virtualvisits";
	public static final String PROD_AARP_DEEPLINK_URL_VirtualVisit = "https://myaarpmedicare.com/virtualvisits";
	public static final String PROD_PCP_DEEPLINK_URL_VirtualVisit = "https://mypcpmedicare.com/virtualvisits";
	public static final String PROD_Medica_DEEPLINK_URL_VirtualVisit = "https://mymedicamedicare.com/virtualvisits";
	public static final String PROD_SHIP_HWP = "https://myaarpmedicare.com/Extras";
	public static final String PROD_DEEPLINK_URL_my_Documents_Edelivery = "https://medicare.uhc.com/?TARGET=SMSR/medicare/member/my-documents/overview.html%3fdeeplink=true&WT.mc_ID=8003461&mrcid=email_fed_m";
	public static final String PROD_UHC_DEEPLINK_URL_HWP = "https://myuhcmedicare.com/hwp";
	public static final String PROD_AARP_DEEPLINK_URL_HWP = "https://myuhcmedicare.com/hwp";
	public static final String PROD_PCP_DEEPLINK_URL_HWP = "https://myuhcmedicare.com/hwp";
	public static final String PROD_Medica_DEEPLINK_URL_HWP = "https://myuhcmedicare.com/hwp";

	public static final String Stage_CrossDomain_URL = "https://stage-mymedicareaccount.uhc.com/";
	public static final String Stage_TestHarness_CrossDomain_URL = "https://stage-mymedicareaccount.uhc.com/?testharness=true";
	public static final String TeamH_TestHarness_CrossDomain_URL = "https://www.team-h-mymedicareaccount.ocp-ctc-dmz-nonprod.optum.com/content/login/overview.html?testharness=true";
}