package com.example.spaintask.consumesoap.config;

import com.example.spaintask.consumesoap.stub.NumberToWordsResponse;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class SoapClient extends WebServiceGatewaySupport {

    public NumberToWordsResponse getWords(String url, Object request) {
        JAXBElement res = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(url, request, new WebServiceMessageCallback() {
            @Override
            public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
                ((SoapMessage) webServiceMessage)
                        .setSoapAction("http://www.dataaccess.com/webservicesserver/NumberConversionSoapType/NumberToWordsRequest");
            }
        });
        return (NumberToWordsResponse) res.getValue();
    }
}