package cc.aisc.web.api.v1;

import cc.aisc.biz.service.CarrierService;
import cc.aisc.biz.service.ReceiverService;
import cc.aisc.biz.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sjf on 16-4-27.
 */
@RestController
@RequestMapping("/com/api/v1")
public class CompanyController {

    private final SupplierService supplierService;
    private final ReceiverService receiverService;
    private final CarrierService carrierService;

    @Autowired
    public CompanyController(SupplierService supplierService, ReceiverService receiverService, CarrierService carrierService) {
        this.supplierService = supplierService;
        this.receiverService = receiverService;
        this.carrierService = carrierService;
    }
}
