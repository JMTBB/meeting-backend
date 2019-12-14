package per.lai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import per.lai.pojo.CustomResponse;
import per.lai.pojo.UserMeeting;
import per.lai.service.UserMeetingService;

@RestController
public class UserMeetingController {
    private UserMeetingService userMeetingService;

    @Autowired
    public void setUserMeetingService(UserMeetingService userMeetingService) {
        this.userMeetingService = userMeetingService;
    }


    /*
    * 参加会议接口
    *   code
    *       240 参加成功
    *       141 参加失败
    *
    * */
    @RequestMapping(path = "/userMeeting", method = RequestMethod.POST)
    public ResponseEntity<CustomResponse> addJoinEntry(@RequestBody UserMeeting userMeeting) {
        int backCode = userMeetingService.addEntity(userMeeting);
        System.out.println(userMeeting.getPMeetingId());
        String message = (backCode == 1) ? "添加成功" : "添加失败";
        int code = (backCode == 1) ? 240 : 140;
        boolean data = backCode == 1;
        return new ResponseEntity<>(new CustomResponse(message, code, userMeeting), HttpStatus.OK);
    }
}
