package org.dkustudy.devears.api.endpoint.constant;

public class ApiPath {

    public static final String API = "/api";

    public static class Github {

        public static final String ROOT = "/github";
        public static final String API_ROOT = API + ROOT;
        public static final String LOGIN = ROOT + "/login";
        public static final String LOGIN_CALLBACK = LOGIN + "/callback";

    }

}
