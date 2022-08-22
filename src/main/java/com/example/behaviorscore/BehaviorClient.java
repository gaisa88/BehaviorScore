package com.example.behaviorscore;

import com.example.wsdl.CigWsHeader;
import com.example.wsdl.Score;
import com.example.wsdl.ScoreAttribute;
import com.example.wsdl.ScoreData;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;

public class BehaviorClient extends WebServiceGatewaySupport {
    public Score getScoreCard(String iin) {
        CigWsHeader myheader = new CigWsHeader();
        myheader.setCulture("ru-RU");
        myheader.setPassword("7752217879");
        myheader.setVersion("1");
        myheader.setUserName("7752217879");
        myheader.setUserId(0);
        myheader.setSecurityToken("0");
        Score request = new Score();
        ScoreAttribute consentConfirmed = new ScoreAttribute();
        consentConfirmed.setName("ConsentConfirmed");
        consentConfirmed.setValue("1");
        ScoreAttribute iinAttribute = new ScoreAttribute();
        iinAttribute.setName("IIN");
        iinAttribute.setValue(iin);


        request.setScoreCard("BehaviorScoring");

        request.getAttributes().add(consentConfirmed);
        request.getAttributes().add(iinAttribute);
        return (Score) getWebServiceTemplate().marshalSendAndReceive(request, new SecurityHeader(myheader));

    }

}
