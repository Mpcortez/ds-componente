package com.mpcortez.dscomponente.services;

import com.mpcortez.dscomponente.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        var basic = order.getBasic();

        if (basic < 100) return 20.00;

        if (basic >= 100 && basic <= 200) return 12.00;

        return 0;
    }
}
