package za.ac.cput.util;

import java.util.regex.Pattern;

public class Helper {

        public static boolean validId(long id){
            return id <= 0;
        }
    public static boolean isLessThan(long value){
        return value <= 0;
    }

        public static boolean isNullOrEmpty(String a){
            return a == null || a.isEmpty();
        }

        public static boolean isValidNumber(String phoneNumber){
            String regex = "(\\+?27|0)(\\d{9})";
            return phoneNumber.matches(regex);
        }

        public static boolean isvalidEmail(String email){
            if (email == null || email.trim().isEmpty()) {
                return false;
            }
            final String regex2 = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

            final Pattern compile = Pattern.compile(regex2, Pattern.CASE_INSENSITIVE);

            return compile.matcher(email).matches();
        }

    }

