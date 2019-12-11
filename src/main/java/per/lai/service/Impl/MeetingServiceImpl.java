package per.lai.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import per.lai.mapper.MeetingMapper;
import per.lai.pojo.Meeting;
import per.lai.service.MeetingService;

import java.util.List;

public class MeetingServiceImpl implements MeetingService {
    private MeetingMapper meetingMapper;

    @Autowired
    public void setMeetingMapper(MeetingMapper meetingMapper) {
        this.meetingMapper = meetingMapper;
    }

    @Override
    public List<Meeting> getMeetingBySponsorId(int sponsorId) {
        return meetingMapper.getMeetingBySponsorId(sponsorId);
    }

    @Override
    public List<Meeting> getAllMeeting() {
        return meetingMapper.getAllMeeting();
    }

    @Override
    public int addMeeting(Meeting meeting) {
        return meetingMapper.addMeeting(meeting);
    }

    @Override
    public int deleteMeetingById(int meetingId) {
        return meetingMapper.deleteMeetingById(meetingId);
    }

    @Override
    public int checkMeetingById(int meetingId) {
        return meetingMapper.checkMeetingById(meetingId);
    }
}
