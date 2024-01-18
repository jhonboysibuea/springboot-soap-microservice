package com.oracle.jhon.service.impl;

import com.oracle.jhon.model.request.Request;
import com.oracle.jhon.model.response.Response;
import com.oracle.jhon.service.TrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class TrxServiceImpl implements TrxService {

    @Autowired
    private WebClient webClient;


    @Override
    public Mono<Response> getTrx(Request request) {
        return Mono.from(
                        webClient.post()
                                .uri("/external/services/rest/sample-service")
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(request)
                                .retrieve()
                                .toEntity(Response.class)
                ).map(responseResponseEntity -> responseResponseEntity.getBody())
                .onErrorResume(error -> Mono.empty());
    }
}
