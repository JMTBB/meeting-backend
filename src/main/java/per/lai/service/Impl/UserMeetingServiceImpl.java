package per.lai.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import per.lai.mapper.UserMeetingMapper;
import per.lai.pojo.UserMeeting;
import per.lai.service.UserMeetingService;

public class UserMeetingServiceImpl implements UserMeetingService {
    private UserMeetingMapper userMeetingMapper;

    @Autowired
    public void setUserMeetingMapper(UserMeetingMapper userMeetingMapper) {
        this.userMeetingMapper = userMeetingMapper;
    }

    @Override
    public int addEntity(UserMeeting userMeeting) {
        return 0;
    }

    @Override
    public int deleteEntityByPrimaryKey(int pMeetingId, int pLoginId) {
        return 0;
    }
}
