package cc.aisc.web.api.v1;

import cc.aisc.biz.service.OrderAdditionalCostService;
import cc.aisc.biz.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sjf on 16-4-27.
 */
@RestController
@RequestMapping("/ord/api/v1")
public class OrderController {

    private final OrderService orderService;
    private final OrderAdditionalCostService orderAdditionalCostService;

    @Autowired
    public OrderController(OrderService orderService, OrderAdditionalCostService orderAdditionalCostService) {
        this.orderService = orderService;
        this.orderAdditionalCostService = orderAdditionalCostService;
    }
}
