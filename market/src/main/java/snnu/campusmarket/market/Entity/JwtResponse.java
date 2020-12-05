package snnu.campusmarket.market.Entity;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionId=1L;
    private String token;

    public static long getSerialVersionId() {
        return serialVersionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponse(String token) {
        this.token = token;
    }
}
