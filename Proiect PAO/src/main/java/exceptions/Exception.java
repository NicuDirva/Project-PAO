package exceptions;

public class Exception extends java.lang.Exception {

        private String message;

        public Exception(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
}
