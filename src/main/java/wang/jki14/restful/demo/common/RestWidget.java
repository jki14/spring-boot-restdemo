package wang.jki14.restful.demo.common;

public class RestWidget {
    public static boolean isInt32Nonnegative(String cadidate) {
        if (cadidate != null) {
            if (cadidate.matches("[0-9]+")) {
                if (cadidate.length() < 10) {
                    return true;
                }
                if (cadidate.length() == 10 && cadidate.compareTo("2147483647") <= 0) {
                    return true;
                }
            }
        }
        return false;
    }
}