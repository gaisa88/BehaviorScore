package com.example.behaviorscore;

import com.example.wsdl.CigWsHeader;
import com.example.wsdl.Score;
import com.example.wsdl.ScoreData;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;

public class BehaviorClient extends WebServiceGatewaySupport {
    public Score getScoreCard(String iin) {
        Score request = new Score();
        request.setScoreCard("BehaviorScoring");
        request.getAttributes().add(consentConfirmed);
        request.getAttributes().add(iinAttribute);
        return (Score) getWebServiceTemplate().marshalSendAndReceive(request, new SecurityHeader(new CigWsHeader("ru-RU", "7752217879", "0", "0", "7752217879", "1")));

    }

}
