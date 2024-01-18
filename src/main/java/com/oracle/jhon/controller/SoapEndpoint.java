package com.oracle.jhon.controller;
import com.oracle.external.services.sampleservice.request.v1.Authenticationheader;
import com.oracle.external.services.sampleservice.request.v1.ObjectFactory;
import com.oracle.external.services.sampleservice.request.v1.Sampleservicerq;
import com.oracle.external.services.sampleservice.request.v1.Sampleservicers;
import com.oracle.jhon.model.request.Request;
import com.oracle.jhon.model.response.Response;
import com.oracle.jhon.service.TrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Component
public class SoapEndpoint {

    @Autowired
    TrxService trxService;

    @PayloadRoot(namespace = "http://www.oracle.com/external/services/sampleservice/request/v1.0", localPart = "sampleservicerq")
    @ResponsePayload
    public Sampleservicers processSampleRequest(@RequestPayload  Sampleservicerq request) {
        Sampleservicers response = new ObjectFactory().createSampleservicers();
        Request reqExternal=new Request();
        com.oracle.jhon.model.request.Sampleservicerq sampleservicerq=new com.oracle.jhon.model.request.Sampleservicerq();
        sampleservicerq.setTrx_id(request.getTrxId());
        sampleservicerq.setType(request.getType());
        sampleservicerq.setOrder_type(request.getOrderType());
        sampleservicerq.setService_id(request.getServiceId());
        reqExternal.setSampleservicerq(sampleservicerq);
        Response sampleservicers=trxService.getTrx(reqExternal).block();
        //Response sampleservicers=new Response();
        response.setErrorCode(sampleservicers.getSampleservicers().getError_code());
        response.setTrxId(sampleservicers.getSampleservicers().getTrx_id());
        response.setErrorMsg(sampleservicers.getSampleservicers().getError_msg());
        return response;
    }

    @PayloadRoot(namespace = "http://www.oracle.com/external/services/sampleservice/request/v1.0", localPart = "authenticationheader")
    public void processAuthenticationHeader(Authenticationheader authenticationHeader) {

    }
}
