package com.example.behaviorscore;

import com.example.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;
import java.util.List;

public class BehaviorClient extends WebServiceGatewaySupport {
    public ScoreData getScoreCard(String iin) {
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
        JAXBElement<ScoreResponse> test = (JAXBElement<ScoreResponse>) getWebServiceTemplate().marshalSendAndReceive(request, new SecurityHeader(myheader));
        ScoreResponse test1 = test.getValue();
        ScoreData results1 = test1.getReturn();
        return results1;

    }

}
