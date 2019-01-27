package pl.sdacademy;

public class LoginValidator {

    /**
     * This method validates if userName and password are correct
     * If userName or password are empty then return false.
     * If userName or password length is smaller than 6 then return false.
     * If userName is JavaKTW9 and password is SDA2019 then return true
     * UserName and password are case sensitive.
     * @param userName
     * @param password
     * @return
     */

    boolean isValid (String userName, String password) {

        if (userName.length() < 6 || password.length() < 6) {
            return false;
        }

        if (userName.isEmpty() || password.isEmpty()) {
            return false;
        }
        return userName.equals("JavaKTW9") && password.equals("SDA2019");

    }

}
