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
    private String name;
    private String number;
    private String gender;
    private String org;
    private String fullId;
    private String ptime;
    private boolean needRoom;
}
