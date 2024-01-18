package com.oracle.jhon.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Sampleservicerq{
    private String service_id;
    private String order_type;
    private String type;
    private String trx_id;
}