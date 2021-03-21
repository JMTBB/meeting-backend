package per.lai.service;

import per.lai.pojo.UserMeeting;

import java.util.List;

public interface UserMeetingService {
    int addEntity(UserMeeting userMeeting);

    int deleteEntityByPrimaryKey(int pMeetingId, int pLoginId);

    List<UserMeeting> getPartInfoByMeetingId(int meetingId);
}
