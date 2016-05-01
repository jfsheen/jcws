package cc.aisc.web.api.v1;

import cc.aisc.biz.model.Carrier;
import cc.aisc.biz.model.Dealer;
import cc.aisc.biz.model.Supplier;
import cc.aisc.biz.service.CarrierService;
import cc.aisc.biz.service.DealerService;
import cc.aisc.biz.service.SupplierService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by sjf on 16-4-27.
 */
@RestController
@RequestMapping("/com/api/v1")
public class CompanyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    private final SupplierService supplierService;
    private final DealerService dealerService;
    private final CarrierService carrierService;

    @Autowired
    public CompanyController(SupplierService supplierService, DealerService dealerService, CarrierService carrierService) {
        this.supplierService = supplierService;
        this.dealerService = dealerService;
        this.carrierService = carrierService;
    }

    @RequestMapping(value = "/carriers", method = RequestMethod.GET)
    public List<Carrier> getCarriers(@RequestParam Integer toPage, @RequestParam Integer pageSize){
        PageHelper.startPage(toPage, pageSize);
        try{
            return (ArrayList<Carrier>)carrierService.findAll().get();
        }catch (NoSuchElementException e){
            LOGGER.error("NO carrier in system!");
        }
        return null;
    }

    @RequestMapping(value = "/carrier/{id}", method = RequestMethod.GET)
    public Map<String, Object> getCarriersValid(@PathVariable Integer id){
        try{
            return carrierService.findValidById(id).get();
        }catch (NoSuchElementException e){
            LOGGER.error("NO carrier in system!");
        }
        return null;
    }

    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public List<Supplier> getSuppliers(@RequestParam Integer toPage, @RequestParam Integer pageSize){
        PageHelper.startPage(toPage, pageSize);
        try{
            return (ArrayList<Supplier>)supplierService.findAll().get();
        }catch (NoSuchElementException e){
            LOGGER.error("NO supplier in system!");
        }
        return null;
    }

    @RequestMapping(value = "/dealers", method = RequestMethod.GET)
    public List<Dealer> getReceivers(@RequestParam Integer toPage, @RequestParam Integer pageSize){
        PageHelper.startPage(toPage, pageSize);
        try{
            return (ArrayList<Dealer>) dealerService.findAll().get();
        }catch (NoSuchElementException e){
            LOGGER.error("NO dealer in system!");
        }
        return null;
    }
    @RequestMapping(value = "/dealer/{id}", method = RequestMethod.GET)
    public Dealer getReceivers(@PathVariable Integer id){
        try{
            return dealerService.findById(id).get();
        }catch (NoSuchElementException e){
            LOGGER.error("NO dealer in system!");
        }
        return null;
    }
}
