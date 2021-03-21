package per.lai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import per.lai.pojo.CustomResponse;
import per.lai.pojo.UserMeeting;
import per.lai.service.UserMeetingService;

import java.util.List;

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
        return new ResponseEntity<CustomResponse>(new CustomResponse(message, code, userMeeting), HttpStatus.OK);
    }

    @RequestMapping(path = "/userMeeting/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomResponse> getPartInfoById(@PathVariable int id) {
        List<UserMeeting> list = userMeetingService.getPartInfoByMeetingId(id);
        boolean result = !(list.size() == 0);
        int code = result ? 241 : 141;
        String message = result ? "获取成功" : "没有人参加此会议";
        return new ResponseEntity<>(new CustomResponse(message, code, list), HttpStatus.OK);
    }
}
