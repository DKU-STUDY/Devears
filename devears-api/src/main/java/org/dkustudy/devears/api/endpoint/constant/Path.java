package org.dkustudy.devears.api.endpoint.constant;

public class Path {

    public static final String API = "/api";

    public static class Github {

        public static final String ROOT = "/github";
        public static final String LOGIN = ROOT + "/login";
        public static final String LOGIN_CALLBACK = LOGIN + "/callback";

    }

    public static class UserApi {

        public static final String USER = API + "/user";
        public static final String LOGOUT = USER + "/logout";

    }

}
