package com.mpcortez.dscomponente.services;

import com.mpcortez.dscomponente.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ShippingService shippingService;

    public double total(Order order) {
        var discount = order.getBasic() * (order.getDiscount() / 100);
        return (order.getBasic() - discount) + shippingService.shipment(order);
    }
}
