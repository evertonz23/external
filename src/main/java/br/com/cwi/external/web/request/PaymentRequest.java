package br.com.cwi.external.web.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {

    private String id;
    private BigDecimal total;
    private String card;
}
