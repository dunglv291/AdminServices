package projectbackend.petbackend.Common;

public abstract class Constant {
    public static class RESPONSE_KEY {
        public static final String SUCCESS = "SUCCESS";
        public static final String DELETE_SUCCESS = "DELETE_SUCCESS";
        public static final String ERROR = "ERROR";
        public static final String WARNING = "WARNING";
        public static final String RECORD_DELETED = "RECORD_DELETED";
        public static final String RECORD_INUSED = "RECORD_INUSED";
        public static final String RECORD_NOT_EXIST = "RECORD_NOT_EXIST";
        public static final String RECORD_SIGNING = "RECORD_SIGNING";
        public static final String RECORD_APPROVED = "RECORD_APPROVED";
    }

    public static class SEQUENCE_KEY {
        public static final String EMPLOYEE = "EMPLOYEE_SEQ";
    }

    public static class AUTH_KEY {
        public static final String HEADER_KEY = "Authorization";
        public static final String PREFIX_KEY = "Bearer";
        public static final int EXPIRATION_MS = 86400000;
    }
}
