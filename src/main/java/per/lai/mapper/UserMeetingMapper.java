package per.lai.mapper;

import per.lai.pojo.UserMeeting;


public interface UserMeetingMapper {
    int addEntity(UserMeeting userMeeting);
    int deleteEntityByPrimaryKey(int pMeetingId, int pLoginId);
}
