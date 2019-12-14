package per.lai.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.lai.pojo.CustomResponse;
import per.lai.pojo.Meeting;
import per.lai.service.MeetingService;

import java.util.List;

@RestController
public class MeetingController {
    private MeetingService meetingService;

    @Autowired
    @Qualifier("meetingServiceImpl")
    public void setMeetingService(MeetingService meetingService) {
        this.meetingService = meetingService;
    }
    /*
    * 添加会议接口
    * 状态码
    *   code
    *       220 添加成功
    *       120 添加失败
    * */
    @RequestMapping(path = "/meeting", method = RequestMethod.POST)
    public ResponseEntity<CustomResponse> addMeeting(@RequestBody Meeting meeting) {

        int backCode = meetingService.addMeeting(meeting);
        String message = (backCode == 1) ? "添加成功" : "添加失败，稍后重试";
        int code = (backCode == 1) ? 220 : 120;
        boolean data = backCode == 1;
        return new ResponseEntity<>(new CustomResponse(message,code,data), HttpStatus.OK);
    }
    /*
    * 获取所以会议列表
    * 状态码
    *   code
    *       230 获取成功
    *       130 获取失败 空列表
    * */
    @RequestMapping(path = "/meeting", method = RequestMethod.GET)
    public ResponseEntity<CustomResponse> getMeeting() {
        List<Meeting> meetings = meetingService.getAllMeeting();
        boolean result = !(meetings.size() == 0);
        int code = result ? 230 : 130;
        String message = result ? "获取成功" : "列表为空";
        return new ResponseEntity<>(new CustomResponse(message, code, meetings), HttpStatus.OK);
    }
    /*
    * 根据ID获取会议列表
    * 状态码
    *   code
    *       231 成功
    *       131 失败
    * */
    @RequestMapping(path = "/meeting/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomResponse> getMeetingBySponsorId(@PathVariable("id") int id) {
        List<Meeting> meetings = meetingService.getMeetingBySponsorId(id);
        boolean result = !(meetings.size() == 0);
        int code = result ? 231 : 131;
        String message = result ? "获取成功" : "会议列表为空";
        return new ResponseEntity<>(new CustomResponse(message, code, meetings), HttpStatus.OK);
    }
    /*
    * 根据ID获取可参加列表
    * 状态码
    *   code
    *       232 成功
    *       132 失败
    *
    * */
    @RequestMapping(path = "/passing/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomResponse> getMeetingPass(@PathVariable int id) {
        List<Meeting> meetings = meetingService.getMeetingPass(id);
        boolean result = !(meetings.size() == 0);
        int code = result ? 232 : 132;
        String message = result ? "获取成功" : "可参加列表为空";
        return new ResponseEntity<>(new CustomResponse(message, code, meetings),HttpStatus.OK);
    }
}
