package snnu.campusmarket.market.Entity;

import java.io.Serializable;

public class JwtRequest implements Serializable {
    private static final long serialVersionId=1L;
    private String username;
    private String password;

    public static long getSerialVersionId() {
        return serialVersionId;
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

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
