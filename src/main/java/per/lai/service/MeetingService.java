package per.lai.service;

import per.lai.pojo.Meeting;

import java.util.List;

public interface MeetingService {
    List<Meeting> getMeetingBySponsorId(int sponsorId);
    List<Meeting> getAllMeeting();

    int addMeeting(Meeting meeting);
    int deleteMeetingById(int meetingId);
    int checkMeetingById(int meetingId);
}
