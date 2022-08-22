package com.example.behaviorscore;

import com.example.wsdl.Score;
import com.example.wsdl.ScoreResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BehaviorScoreApplication {
    public static <iinAttribute> void main(String[] args) {


        ApplicationContext ctx = SpringApplication.run(BehaviorClientConfiguration.class, args);

        BehaviorClient client = ctx.getBean(BehaviorClient.class);

        String iin = "940331451224";
        if (args.length > 0) {
            iin = args[0];
        }
        List <iinAttribute> = new ArrayList<>("IIN", iin);

        ScoreResponse response =  client.getScoreCard();


        //Score response = BehaviorClient.getScoreCard();
        //BehaviorClient.printResponse(response);
    }
}

