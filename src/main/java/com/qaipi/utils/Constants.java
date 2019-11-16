package com.qaipi.utils;

public final class Constants {

    /**
     * A private constructor.
     */
    private Constants() {
        // Keep this empty.
    }

    public static final long WEB_DRIVER_TIMEOUT_IN_SECONDS   = 10;
    public static final String AETNA_HEALTH_DEV_ENV = "https://aetnahealth.dev.aetnadigital.net";
    public static final String AETNA_HEALTH_USRS_FILE = "userLogins/%suserLogin.json";
    public static final String ANDROID_PROPERTIES_FILE = "src/main/resources/android.properties";
    public static final String COMMON_PROPERTIES_FILE   = "src/main/resources/common.properties";
    public static final String DEFAULT_APPIUM_LOCAL_URL = "http://localhost:4723/wd/hub";
    public static final String HEALTH_CLOUD = "Health Cloud";
    public static final String IOS_PROPERTIES_FILE = "src/main/resources/ios.properties";
    public static final String OUT_DIR = "test-output/";
    public static final String OUTPUT_PERFORMANCE_HAR_FILE = "./har-output/PineApplePerformance.har";
    public static final String PINEAPPLE_HEALTHHUB_SURVEY_MOCK = "src/main/resources/pineapplesurveyresources" +
            "/HealthHubSurvey_Mock.yml";
    public static final String PINEAPPLE_HEALTHHUB_SURVEY_LIVE = "src/main/resources/pineapplesurveyresources" +
            "/HealthHubSurvey_liveapi.yml";
    public static final String PINEAPPLE_USERS = "userLogins/%spineAppleUserLogin.json";
    public static final long TIME_OUT_IN_SECONDS = 10;
    public static final String USER_COMPLETED_NOT_SUBMIT = "Completed survey but did not Submit";
    public static final String USER_SURVEY_IN_PROGRESS = "Survey in-progress";
    public static final String USER_SURVEY_NOT_STARTED = "Has not started survey";
    public static final String START_SURVEY_USER = "Default QA User";

    //region CKD

    public static final String CKD_USER = "Ckd User";
    public static final String CKD_USERS_FILE = "userLogins/labCkdUserLogin.json";
    public static final String BULLET_SALTY_FOOD_TEXT = "Say no to salty food";
    public static final String BULLET_QUENCH_THIRST_TEXT = "Try techniques to quench your thirst";
    public static final String BULLET_PAY_ATTENTION_TEXT = "Pay attention to what’s around you";
    public static final String MAKING_A_MATCH_TEXT = "Making a Match";
    public static final String TIMING_A_TRANSPLANT_TEXT = "Timing a Transplant";
    public static final String LIFE_AFTER_TRANSPLANT_TEXT = "Life After Transplant";
    public static final int NUMBER_OF_PROS_CONS = 2;

    // end region CKD

    //region Adobe

    public static final String HEALTH_CLOUD_WELCOME_URL = "https://pineapple-web-lab.hc.ds.aetna.com/welcome";
    public static final String RESUME_SURVEY_ADOBE_TAG = "wellbeing_hc:web:homepage" +
            ":dimensions_of_wellbeing_survey_resume_select";
    public static final String START_SURVEY_ADOBE_TAG = "wellbeing_hc:web:homepage" +
            ":dimensions_of_wellbeing_get_started_select";

    // endregion

    public static final String ELEMENT_NOT_FOUND = "Element not found";
}
