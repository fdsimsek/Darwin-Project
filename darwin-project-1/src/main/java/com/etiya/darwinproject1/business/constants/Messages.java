package com.etiya.darwinproject1.business.constants;

public class Messages {

    public static class ErrorMessages {

        public static final String ThisFieldCanNotBeEmpty = "thisFieldCanNotBeEmpty";

        public static final String JsonFormatError = "jsonFormatError";
        public static final String ValidationError = "validationError";
        public static final String UserNameOrPasswordAreWrong = "userNameOrPasswordAreWrong";
        public static final String UserTypeNotValid = "userTypeNotValid";
        public static final String UserTypeNotFound = "userTypeNotFound";
        public static final String CharIdNotFound = "charIdNotFound";
        public static final String ProdOfferIdNotFound = "prodOfferIdNotFound";

    }

    public static class User {
        public static final String UserNameAndPwdMustBeEntered = "userNameAndPwdMustBeEntered";
        public static final String UserProfile = "userProfile";
        public static final String UserNameExists = "userNameExists";
        public static final String UserIdDoesNotExists = "userIdDoesNotExists";
        public static final String UserCreated = "userCreated";
        public static final String AdminCreated = "adminCreated";
        public static final String UsersListed = "usersListed";
    }

    public static class Order {
        public static final String SelectedOfferIdDoesNotExists = "selectedOfferIdDoesNotExists";
        public static final String OffersListed = "offersListed";
    }
}
