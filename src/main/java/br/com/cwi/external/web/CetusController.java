package br.com.cwi.external.web;

import br.com.cwi.external.web.request.ShippingRequest;
import br.com.cwi.external.web.response.ShippingResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/cetus")
public class CetusController {

    @PostMapping("/shipping")
    public ShippingResponse shipping(@RequestBody ShippingRequest request) {
        return ShippingResponse.builder()
                .id(UUID.randomUUID().toString())
                .price(calculatePrice(request))
                .time(calculateTime(request))
                .build();
    }

    private BigDecimal calculatePrice(ShippingRequest request) {
        return BigDecimal.valueOf(request.getVolume() * 2L + 3L);
    }

    private int calculateTime(@RequestBody ShippingRequest request) {
        return request.getVolume() * 2;
    }
}
