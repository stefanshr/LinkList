package ch.stefanhohl.sh.linklist.security;

/**
 * @version 10.12.2020
 * votingtool - AuthenticationUserModel
 * <p>
 * Responsible for temporarily managing user credentials (=> secure against XSS)
 */

public class JwtAuthenticationUserModel {
    private String username;
    private String password;

    public JwtAuthenticationUserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}