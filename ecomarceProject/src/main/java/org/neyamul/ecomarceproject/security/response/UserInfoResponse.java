package org.neyamul.ecomarceproject.security.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {

    private Long id;
    private String jwtToken;
    private String username;
    private List<String> roles;



    public UserInfoResponse(Long id,String username, List<String> roles, String jwtToken) {
        this.id=id;
        this.username = username;
        this.roles = roles;
        this.jwtToken = jwtToken;
    }
}
