package com.oracle.jhon.service;

import com.oracle.jhon.model.request.Request;
import com.oracle.jhon.model.response.Response;
import reactor.core.publisher.Mono;

public interface TrxService {
    Mono<Response> getTrx(Request request);
}
