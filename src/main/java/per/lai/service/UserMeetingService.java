package per.lai.service;

import per.lai.pojo.UserMeeting;

public interface UserMeetingService {
    int addEntity(UserMeeting userMeeting);
    int deleteEntityByPrimaryKey(int pMeetingId, int pLoginId);
}
