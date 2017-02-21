package com.example.service.consumer;

import com.example.service.Greetings;
import com.example.service.api.IMobPushMsgService;
import com.example.service.exception.ServiceException;
import com.example.service.param.MobPushMsgQueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@SpringBootApplication
@ImportResource({"classpath:services.xml"})
@RestController
public class Application {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @RequestMapping("/")
    public String greetings(){
        Greetings greetingService = (Greetings)context.getBean("greetingService");
        String result = greetingService.say("Dubbo Docker");
        return result;
    }

    @RequestMapping("/dina/")
    public Long counts(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        MobPushMsgQueryParams params = new MobPushMsgQueryParams();
        try {
            params.setStartDate(sdf.parse("20150101"));
            params.setPushId(-1);
            params.setPushName("阿里云");
            params.setSspName("nnn");
            params.setEndDate(sdf.parse("20161231"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        IMobPushMsgService mobPushMsgService = (IMobPushMsgService)context.getBean("mobPosAdService");
        long result = 0;
        try {
            result = mobPushMsgService.count(params);
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
