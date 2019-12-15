package per.lai.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import per.lai.mapper.UserMeetingMapper;
import per.lai.pojo.UserMeeting;
import per.lai.service.UserMeetingService;

import java.util.List;

public class UserMeetingServiceImpl implements UserMeetingService {
    private UserMeetingMapper userMeetingMapper;

    @Autowired
    public void setUserMeetingMapper(UserMeetingMapper userMeetingMapper) {
        this.userMeetingMapper = userMeetingMapper;
    }

    @Override
    public int addEntity(UserMeeting userMeeting) {
        return userMeetingMapper.addEntity(userMeeting);
    }

    @Override
    public int deleteEntityByPrimaryKey(int pMeetingId, int pLoginId) {
        return userMeetingMapper.deleteEntityByPrimaryKey(pMeetingId, pLoginId);
    }

    @Override
    public List<UserMeeting> getPartInfoByMeetingId(int meetingId) {
        return userMeetingMapper.getPartInfoByMeetingId(meetingId);
    }
}
