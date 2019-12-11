package per.lai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int loginId;
    private String loginPassword;
    private String loginName;
    private boolean isAdmin;
}
