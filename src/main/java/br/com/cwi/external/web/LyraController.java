package br.com.cwi.external.web;

import br.com.cwi.external.web.request.PaymentRequest;
import br.com.cwi.external.web.request.ShippingRequest;
import br.com.cwi.external.web.response.PaymentResponse;
import br.com.cwi.external.web.response.PaymentStatusResponse;
import br.com.cwi.external.web.response.ShippingResponse;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

import static br.com.cwi.external.web.response.PaymentStatusResponse.PaymentStatus.APROVADO;
import static br.com.cwi.external.web.response.PaymentStatusResponse.PaymentStatus.PENDENTE;

@RestController
@RequestMapping("/lyra/payment")
public class LyraController {

    @PostMapping
    public PaymentResponse payment(@RequestBody PaymentRequest request) {
        return PaymentResponse.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }

    @GetMapping("/{id}/status")
    public PaymentStatusResponse status(@PathVariable("id") String id) {
        return PaymentStatusResponse.builder()
                .id(id)
                .status(getStatus())
                .build();
    }

    private PaymentStatusResponse.PaymentStatus getStatus() {
        return new Random().nextInt(10+1) % 2 != 0 ? PENDENTE : APROVADO;
    }
}
