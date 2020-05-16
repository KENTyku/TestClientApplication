package com.testapp.testclient;

/**
 * Application-wide registry of error messages and error codes that are exposed via web services
 */
public enum ASErrors implements ASError {

    // ***********************************
    //    COMMON ERRORS
    // ***********************************
    INTERNAL_SERVER_ERROR(
            "Internal Server Error"),
    UNAUTHORIZED(
            "401 Unauthorized"),
    FORBIDDEN(
            "403 Forbidden"),
    RESOURCE_NOT_FOUND(
            "Object with such ID not found"),
    DATA_CONFLICT(
            "Data conflict"),
    INVALID_DATA(
            "Invalid request data"),
    INCORRECT_EMAIL_FORMAT(
            "Incorrect email format"),
    DUPLICATE_DATA(
            "Duplicate data"),
    MULTI_ERROR_ARRAY(
            "Multiple errors"),

    LINK_EXPIRED("This link has expired or has been already used"),

    REQUEST_TIME_OUT("Request timeout error"),

    // ***********************************
    //    SERVICES
    // ***********************************

    AS_SERVICE_ERROR("Service error"),

    // Login

    LOGIN_WILEY_USER("Users with Wiley emails are not supported. "
            + "If you need access to the Admin application, please use different URL to login"),

    // Registration

    REGISTRATION_WILEY_USER(
            "User is wiley user. Please, request access or log in."),

    REGISTRATION_EMAIL_ALREADY_REGISTERED_AS_PRIMARY(
            "Email already registered in AS as primary email"),

    REGISTRATION_EMAIL_ALREADY_REGISTERED_AS_SECONDARY(
            "Email already registered in AS as secondary email"),

    REGISTRATION_ORCID_ALREADY_EXISTS(
            "User already exists with the same ORCID Id"),

    REGISTRATION_ANOTHER_USER_FOUND(
            "List of users found. Please select or continue"),

    REGISTRATION_INVITED_USER_ALREADY_REGISTERED(
            "You seem to be already registered - please log in"),

    REGISTRATION_INVITATION_NOT_FOUND(
            "No invitation data found."),

    REGISTRATION_VERIFY_ACCOUNT_ALREADY_ACTIVE(
            "User already activated."),

    REGISTRATION_VERIFY_ACCOUNT_SUSPENDED(
            "User suspended."),

    REGISTRATION_VERIFY_ACCOUNT_NOT_FOUND(
            "No verification record found. It might have been expired,"
                    + " or your account may have already been activated. Please, try to log in."),

    REGISTRATION_EXPIRED("Your registration is expired, please start from the beginning"),

    REGISTRATION_PASSWORD_RESTRICTION_VIOLATED(
            "Password must be between 10 and 32 characters long and must contain characters from at least 2 of the "
                    + "following categories (Uppercase (A), lowercase (a), digits (1,2,3...), special (!?#...)"),

    REGISTRATION_SQ_ANSWER_LIMIT_EXCEEDED(
            "You have exceeded the maximum number of retries. Please try resetting password through email"),

    REGISTRATION_AREA_OF_INTEREST_REQUIRED_IF_SUBSCRIBED(
            "You haven't provided Area of interest but it is required if you selected to receive information"),

    // User Profile
    PROFILE_WILEY_USER(
            "Wiley email cannot be used as primary account email"),
    PROFILE_PRIMARY_EMAIL_NOT_FOUND(
            "User with such primary email is not found"),
    PROFILE_SECONDARY_EMAIL_NOT_FOUND_FOR_PRIMARY(
            "User is found by primary email, but specified secondary email is not defined for this user"),
    PROFILE_PRIMARY_EMAIL_UPDATE_CONFLICT(
            "This email is already linked to another user"),

    PROFILE_PRIMARY_EMAIL_EQUALS_SECONDARY_FOR_ANOTHER_USER(
            "This email is a secondary email for another user"),

    PROFILE_PRIMARY_EMAIL_EQUALS_SECONDARY_FOR_SELF(
            "Your new primary email is equal to the current recovery email."
                    + " Please remove or change your recovery email, and then try again"),

    PROFILE_SECONDARY_EMAIL_EQUALS_PRIMARY_FOR_ANOTHER_USER(
            "This secondary email is a primary email for another user"),

    PROFILE_SECONDARY_EMAIL_EQUALS_PRIMARY_FOR_SELF(
            "This secondary email is equal to your current primary email."
                    + " Please choose another email address as a recovery email"),

    PROFILE_SECONDARY_EMAIL_EQUALS_SECONDARY_FOR_ANOTHER_USER(
            "This secondary email is a secondary email for another user"),

    PROFILE_EXISTING_PASSWORD_DOES_NOT_MATCH(
            "Existing password does not match"),

    PROFILE_UPDATE_ORCID_ID_CONFLICT(
            "There is already an account with such ORCID ID"),

    PROFILE_SOCIETY_ALREADY_ADDED(
            "You are already a member of this society for the given period of time"),

    PROFILE_SOCIETY_DELETION_USED_IN_DISCOUNT(
            "This society cannot be deleted, because a discount from this society was used"),

    PROFILE_RESEARCH_FUNDER_ALREADY_ADDED(
            "Research funder with such name is already added to profile"),

    PROFILE_PREFERRED_JOURNAL_ALREADY_ADDED(
            "Journal is already added to profile"),

    PROFILE_IMAGE_MORE_THAN_ONE_MB(
            "Profile image should be less then 1 mb"),

    PROFILE_AFFILIATION_ALREADY_ADDED(
            "You are already affiliated with this institution for the given period of time"),

    PROFILE_SECURITY_QUESTION_VALIDATION_FAILED(
            "An error occurred when validating answer for security question"),
    PROFILE_SECURITY_QUESTIONS_ARE_NOT_SET(
            "User does not have security questions"),
    PROFILE_SQ_UPDATE_CONFLICT(
            "Some of the questions you selected are already defined in your profile. You can only select new questions"
    ),
    PROFILE_SQ_INCORRECT_NUMBER(
            "You need to provide answers to all three security questions"),
    PROFILE_SQ_REPEATING_ANSWERS(
            "Some of the answers are repeating. Please provide different answers to each security question"),
    PROFILE_PRIMARY_EMAIL_INVALID_CONFIRMATION_CODE(
            "Invalid confirmation code"
    ),
    PROFILE_VALIDATION_ADDRESS_MANDATORY_FIELDS(
            "Some of follow mandatory fields of address are missing"),

    // Orcid Controller
    ORCID_FETCH_DETAILS_ERROR(
            "Unable to To Fetch the ORCID Details Try Again Later"),

    ORCID_ID_FROM_TOKEN_MISMATCHES_LINKED_ONE(
            "You have entered different ORCID profile than linked with your AS profile. "
                    + "Please log out from ORCID and enter valid profile then."),
    // Product service
    PRODUCT_SERVICE_NOT_FOUND_ERROR(
            "Data not found in Product Service (PDH)"),
    PRODUCT_SERVICE_OO_BASE_PRICE_NOT_FOUND(
            "Base Online Open price is unavailable for Journal"),

    // Orders
    ORDER_VALIDATION_DUPLICATE_DRAFT_FOR_ARTICLE(
            "There is already order draft for this article"),
    ORDER_VALIDATION_NO_WPG_TOKEN(
            "Credit card is not yet validated"),
    ORDER_VALIDATION_ADDRESS_MANDATORY_FIELDS(
            "Some of follow mandatory fields are missing"),
    ORDER_PAYMENT_UNAVAILABLE_FOR_COUNTRY(
            "Sorry, but payment is unavailable for selected country"),

    // OO order
    OO_ORDER_WOA_FUNDER_CALC_WOA_ACCOUNT_ERROR(
            "Failed to calculate WOA account for selected WOA institution"),
    OO_ORDER_VALIDATION_ERROR(
            "OnlineOpen order validation failed"),
    OO_ORDER_VALIDATION_USER_IS_NOT_CO_AUTHOR(
            "User is not a corresponding author of this article"),
    OO_ORDER_VALIDATION_INVALID_ADDRESSES(
            "Correspondence or billing addresses incorrect."),
    OO_ORDER_VALIDATION_JOURNAL_NOT_OO(
            "Journal is not OnlineOpen"),
    OO_ORDER_VALIDATION_NO_PARTICIPATION_FOR_SELECTION_FOR_OOO(
            "Journal doesn't participate in selection for OOO"),
    OO_ORDER_DISCOUNT_VALIDATION_ERROR(
            "Discount data is not valid"),
    OO_ORDER_TAX_VALIDATION_ERROR(
            "Tax/VAT data is not valid"),
    OO_ORDER_CANCELLED(
            "OnlineOpen order is cancelled"),
    OO_ORDER_CANCEL_ALREADY_PAID(
            "OnlineOpen orders for this article cannot be canceled because it is already paid"),
    OO_ORDER_CANCEL_FUNDER_PAID(
            "OnlineOpen orders for this article cannot be canceled because it is has funder paid type"),
    OO_ORDER_MODIFY_PAID(
            "Paid OnlineOpen arder cannot be modified"),
    OO_ORDER_NOT_POSSIBLE_AT_THIS_TIME(
            "OO order is not possible at this time"),
    OO_ORDER_REQUEST_NO_CORR_AUTHOR(
            "Request cannot be submitted, because article does not have corresponding author"),

    WPG_NOT_AVAILABLE(
            "WPG is not available"),

    // OA order
    OA_ORDER_QUOTE_NOT_FOUND(
            "Open Access order is not possible, because quote for this article does not exist"),
    OA_ORDER_VALIDATION_ERROR(
            "OA order validation failed"),
    OA_ORDER_VALIDATION_NO_BILLING_COUNTRY(
            "No billing country is available in the Quote"),
    OA_ORDER_VALIDATION_ARTICLE_NEEDS_OA_PAYMENT_FALSE(
            "OA order validation failed: article needs Open Access payment"),
    OA_ORDER_VALIDATION_USER_IS_NOT_CO_AUTHOR(
            "OA order validation failed: User is not co-author of this article"),
    OA_ORDER_VALIDATION_DUPLICATE_ORDER_FOR_ARTICLE(
            "OA order validation failed: There is already existing Open Access order for this article"),
    OA_ORDER_VALIDATION_JOURNAL_IS_NOT_INVITED_IN_AS(
            "OA order validation failed: Journal is not invited in AS"),
    OA_ORDER_VALIDATION_JOURNAL_IS_NOT_OPEN_ACCESS(
            "OA order validation failed: not an Open Access journal"),
    OA_ORDER_TAX_VALIDATION_ERROR(
            "OA order validation failed: Tax/VAT data is not valid"),
    OA_ORDER_MODIFY_PAID(
            "Paid Open Access order cannot be modified"),
    OA_ORDER_NOT_POSSIBLE_AT_THIS_TIME(
            "OA order is not possible at this time"),

    // license signing and uploading

    LICENSE_SIGNING_NO_SIGN_OR_UPLOAD_LICENSE_TASK(
            "Sign license or Upload license task is not found for provided article"),
    LICENSE_SIGNING_NO_CHOICE_AVAILABLE(
            "No Licence choices returned from WALS"),
    LICENSE_SIGNING_REMOVING_RESTRICTED_RESEARCH_FUNDER(
            "Removing a restricted research funder"),
    LICENSE_NOT_FOUND(
            "No license data found in WALS"),
    LICENSE_UPLOADING_NO_UPLOAD_LICENSE_TASK(
            "Upload license task is not found for provided article"),
    LICENSE_UPLOADING_UNSUPPORTED_FILE_TYPE(
            "Unsupported file type for license"),
    LICENSE_UPLOADING_TOTAL_FILE_SIZE_EXCEEDED(
            "Total files size exceeds the limit"),
    LICENSE_UPLOADING_TOTAL_FILE_NUMBER_EXCEEDED(
            "Total files number exceeds the limit"),

    LICENSE_VERIFICATION_EXPIRED(
            "License verification is expired, or the license was already verified"),
    LICENSE_VERIFICATION_ALREADY_DONE(
            "License verification already performed or license has been reset"),
    LICENSE_UPLOADING_FILE_IS_CORRUPTED(
            "One or more uploaded files are corrupted"),

    // Routing
    POSSIBLE_OUTDATED_DATA("The data in the page is outdated"),

    // colleague invitation

    COLLEAGUE_INVITATION_MATCH_AUTHOR_PRIMARY_EMAIL(
            "Colleague's email match primary email of one of the article authors"),
    COLLEAGUE_INVITATION_MATCH_AUTHOR_SECONDARY_EMAIL(
            "Colleague's email match secondary email of one of the article authors"),
    COLLEAGUE_IS_ALREADY_INVITED(
            "Colleague is already invited to view this article"),

    // ***********************************
    //    EXTERNAL SERVICES
    // ***********************************
    ALM_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting ALM"),

    // Participants service
    PARTICIPANTS_COMMUNICATION_ERROR(
            "An error occurred when requesting Participants service"),
    PARTICIPANTS_CONFLICT_ERROR(
            "Conflict with existing participants data"),
    PARTICIPANTS_NOT_FOUND_ERROR(
            "Participant not found"),

    // Profile Service
    PROFILE_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting Profile service"),

    // Authentication service
    AUTH_COMMUNICATION_ERROR(
            "An error occurred when requesting Authentication Service"),
    AUTH_FAILURE_INVALID_CREDENTIALS(
            "Please enter valid EmailId and Password"),
    AUTH_FAILURE_USER_LOCKED(
            "Please retry after few minutes"),
    AUTH_FAILURE_USER_GOT_LOCKED(
            "User account got locked"),
    AUTH_FAILURE_USER_UNREGISTERED(
            "User does not exist. Please register in the system."),
    AUTH_EMAIL_EXISTS_AS_SECONDARY(
            "Your email is registered as secondary. "
                    + "Please use primary email or contact Author Operations Support for further help."),
    AUTH_FAILURE_NOT_ACTIVATED(
            "Your account is not active. Please activate your account"),

    // Group service
    EXT_GROUP_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting Group service"),
    GROUP_NOT_FOUND_ERROR(
            "Group not found"),

    // Product service
    EXT_PRODUCT_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting Product service"),

    // Other external services
    CDM_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting CDM"),
    PDH_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting PDH/ESB"),
    PDH_SERVICE_VALIDATION_ERROR(
            "Bad data has come from PDH"),
    CDM_LOOKUP_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when getting lookup data from ESB"),
    WOA_FUNDER_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when getting WOA Funders data from ESB"),
    ORCID_COMMUNICATION_ERROR(
            "An error occurred when requesting ORCID"),
    ROLE_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting Role Service"),
    NOTIFICATION_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting Notification Service"),
    ADDRESS_VALIDATION_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting AddressValidation service"),
    RES_FUNDER_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting Research Funder service"),
    RES_FUNDER_SERVICE_ARTICLE_NOT_FOUND(
            "Requested article is not found in Research Funder service"),
    EXT_TAX_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting Pricing Service"),
    EXT_TAX_SERVICE_CALCULATION_ERROR(
            "Failed to calculate tax"),
    EXT_ORDER_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting ESB Order Service"),
    EXT_ORDER_SERVICE_ORDER_NOT_FOUND(
            "Order not found by OO Unique Id"),
    EXT_ORDER_SERVICE_ORDER_CANNOT_BE_CANCELLED(
            "Order cannot be cancelled from the Author Services. Please contact support."),
    EXT_ORDER_SERVICE_OPERATION_ERROR(
            "Order operation failed"),
    EXT_ORDER_ECORE_CUSTOMER_BILLING_ADDRESS_VALIDATION_ERROR(
            "Billing address validation error"),
    EXT_ORDER_ECORE_CUSTOMER_VAT_ID_VALIDATION_ERROR(
            "VAT ID is invalid, please enter correct VAT ID"),
    EXT_ORDER_ECORE_UNABLE_TO_SUBMIT_PAYMENT(
            "Unable to submit payment at this time. Please try again later."),
    EXT_ORDER_ECORE_CUSTOMER_ACCOUNT_ON_HOLD(
            "Customer Account on Hold. Please contact Wiley Customer Support."),
    EXT_ORDER_ECORE_CREDIT_CARD_DECLINED_US(
            "Credit card is declined. You can pay by a different credit card or wait for an invoice."
                    + " The invoice will be available soon."),
    EXT_QUOTE_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting Quote service"),

    EXT_ECORE_CUSTOMER_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting eCore customer service"),

    EXT_LICENSE_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting License service"),

    EXT_LICENSE_SERVICE_OPERATION_ERROR(
            "License service operation error"),

    BPM_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting BPM"),

    BPM_REQUEST_OO_ORDER_ALREADY_EXISTS_ERROR(
            "\"Request OO\" process already exists in BPM"),

    DISCOUNT_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting Discount service"),

    ARTICLE_PDF_DOWNLOADER_COMMUNICATION_ERROR(
            "An error occurred when requesting Article PDF"),

    INVOICE_DOWNLOADER_COMMUNICATION_ERROR(
            "An error occurred when requesting Invoice PDF"),

    EXT_SEARCH_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting search service"),
    LITERATUM_SERVICE_COMMUNICATION_ERROR(
            "An error occurred when requesting Literatum"),

    ELOQUA_COMMUNICATION_ERROR(
            "An error occurred when requesting Eloqua"),
    ELOQUA_CONTACT_CONFLICT_ERROR(
            "Conflict with existing contact in Eloqua");

    /**
     * Implementation
     */
    private final String code;
    private final String message;

    ASErrors(String message) {
        this.code = this.name();
        this.message = message;
    }

    ASErrors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
