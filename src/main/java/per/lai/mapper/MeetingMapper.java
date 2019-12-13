package per.lai.mapper;

import per.lai.pojo.Meeting;

import java.util.List;

public interface MeetingMapper {
    List<Meeting> getMeetingBySponsorId(int sponsorId);
    List<Meeting> getAllMeeting();
    List<Meeting> getMeetingPass(int sponsorId);

    int addMeeting(Meeting meeting);
    int deleteMeetingById(int meetingId);
    int checkMeetingById(int meetingId);


}
