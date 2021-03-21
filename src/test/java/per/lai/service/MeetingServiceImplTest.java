package per.lai.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MeetingServiceImplTest {


    @Test
    public void testGet() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MeetingService meetingService = context.getBean("meetingServiceImpl", per.lai.service.Impl.MeetingServiceImpl.class);
        System.out.println(meetingService.getAllMeeting());
    }


}
