package cc.aisc.web.api.v1;

import cc.aisc.biz.model.OwnDriver;
import cc.aisc.biz.model.OwnTractor;
import cc.aisc.biz.model.OwnTrailer;
import cc.aisc.biz.model.OwnTruck;
import cc.aisc.biz.service.*;
import cc.aisc.sys.service.DictionaryService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by sjf on 16-4-27.
 */
@RestController
@RequestMapping("/set/api/v1")
public class SettingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SettingController.class);

    private final OwnDriverService ownDriverService;
    private final OwnTractorService ownTractorService;
    private final OwnTrailerService ownTrailerService;
    private final OwnTruckService ownTruckService;
    private final StandbyCostService standbyCostService;
    private final SubsidyCostService subsidyCostService;
    private final SupplierPayDistanceService supplierPayDistanceService;
    private final SupplierPayStandardService supplierPayStandardService;
    private final TransferCostService transferCostService;
    private final FuelPriceService fuelPriceService;
    private final DictionaryService dictionaryService;
    private final CommercialCarService commercialCarService;

    @Autowired
    public SettingController(OwnDriverService ownDriverService,
                             OwnTractorService ownTractorService,
                             OwnTrailerService ownTrailerService,
                             OwnTruckService ownTruckService,
                             StandbyCostService standbyCostService,
                             SubsidyCostService subsidyCostService,
                             SupplierPayDistanceService supplierPayDistanceService,
                             SupplierPayStandardService supplierPayStandardService,
                             TransferCostService transferCostService,
                             FuelPriceService fuelPriceService,
                             DictionaryService dictionaryService,
                             CommercialCarService commercialCarService) {
        this.ownDriverService = ownDriverService;
        this.ownTractorService = ownTractorService;
        this.ownTrailerService = ownTrailerService;
        this.ownTruckService = ownTruckService;
        this.standbyCostService = standbyCostService;
        this.subsidyCostService = subsidyCostService;
        this.supplierPayDistanceService = supplierPayDistanceService;
        this.supplierPayStandardService = supplierPayStandardService;
        this.transferCostService = transferCostService;
        this.fuelPriceService = fuelPriceService;
        this.dictionaryService = dictionaryService;
        this.commercialCarService = commercialCarService;
    }

    @RequestMapping(value = "/driver", method = RequestMethod.POST)
    public void addDriver(@RequestBody OwnDriver driver){
        ownDriverService.insert(driver);
    }
    @RequestMapping(value = "/tractor", method = RequestMethod.POST)
    public void addTractor(@RequestBody OwnTractor tractor){
        ownTractorService.insert(tractor);
    }
    @RequestMapping(value = "/trailer", method = RequestMethod.POST)
    public void addTrailer(@RequestBody OwnTrailer trailer){
        ownTrailerService.insert(trailer);
    }
    @RequestMapping(value = "/truck", method = RequestMethod.POST)
    public void addTruck(@RequestBody OwnTruck truck){
        ownTruckService.insert(truck);
    }
    @RequestMapping(value = "/driver", method = RequestMethod.GET)
    public List<OwnDriver> getDrivers(@RequestParam Integer toPage, @RequestParam Integer pageSize){
        PageHelper.startPage(toPage, pageSize);
        try{
            ownDriverService.findById(1);
        }catch (NoSuchElementException e){
            LOGGER.error("no dirver in system!");
        }
        return null;
    }
}
