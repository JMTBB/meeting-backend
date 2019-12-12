package per.lai.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meeting {
    private int meetingId;
    private String meetingName;
    private int sponsorId;
    private String beginTime;
    private String endTime;
    private String meetingLocation;
    private String meetingHosts;
    private String meetingHotel;
    private boolean isPass;
    private String infoCollector;
}
