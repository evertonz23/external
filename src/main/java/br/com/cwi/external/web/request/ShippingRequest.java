package br.com.cwi.external.web.request;

import lombok.Data;

@Data
public class ShippingRequest {

    private String zipOrigin;
    private String zipDestination;
    private Integer volume;
}
