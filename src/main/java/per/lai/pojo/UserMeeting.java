package per.lai.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMeeting {
    private int pMeetingId;
    private int pLoginId;
    private String pInfo;
}
