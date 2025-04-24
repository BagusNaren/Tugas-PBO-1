package Auth;

import Model.Account;

public class Login {
    public static String login(String username, String password) {
        if (username.equals(Account.ADMIN_USERNAME) && password.equals(Account.ADMIN_PASSWORD)) {
            return "admin";
        } else if (username.equals(Account.CUSTOMER_USERNAME) && password.equals(Account.CUSTOMER_PASSWORD)) {
            return "customer";
        }
        return "invalid";
    }
}
