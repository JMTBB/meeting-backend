package per.lai.mapper;

import per.lai.pojo.UserMeeting;

import java.util.List;


public interface UserMeetingMapper {
    int addEntity(UserMeeting userMeeting);

    int deleteEntityByPrimaryKey(int pMeetingId, int pLoginId);

    List<UserMeeting> getPartInfoByMeetingId(int meetingId);
}
