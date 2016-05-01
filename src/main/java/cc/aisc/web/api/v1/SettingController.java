package cc.aisc.web.api.v1;

import cc.aisc.biz.model.*;
import cc.aisc.biz.service.*;
import cc.aisc.sys.service.DictionaryService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private final VehicleOverallService vehicleOverallService;

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
                             VehicleOverallService vehicleOverallService) {
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
        this.vehicleOverallService = vehicleOverallService;
    }

    @RequestMapping(value = "/driver", method = RequestMethod.POST)
    public void addDriver(@RequestBody OwnDriver driver){
        ownDriverService.insert(driver);
    }
    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public List<OwnDriver> getDrivers(@RequestParam Integer toPage, @RequestParam Integer pageSize){
        PageHelper.startPage(toPage, pageSize);
        try{
            return (ArrayList<OwnDriver>)ownDriverService.findAll().get();
        }catch (NoSuchElementException e){
            LOGGER.error("NO dirver in system!");
        }
        return null;
    }
    @RequestMapping(value = "/driver/{id}", method = RequestMethod.GET)
    public OwnDriver getDriver(@PathVariable Integer id){
        try{
            return ownDriverService.findById(id).get();
        }catch (NoSuchElementException e){
            LOGGER.info("no driver id = {}", id);
        }
        return null;
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


    @RequestMapping(value = "/tractors", method = RequestMethod.GET)
    public List<OwnTractor> getTractors(@RequestParam Integer toPage, @RequestParam Integer pageSize){
        PageHelper.startPage(toPage, pageSize);
        try{
            return (ArrayList<OwnTractor>)ownTractorService.findAll().get();
        }catch (NoSuchElementException e){
            LOGGER.error("NO tractor in system!");
        }
        return null;
    }
    @RequestMapping(value = "/trailers", method = RequestMethod.GET)
    public List<OwnTrailer> getTrailers(@RequestParam Integer toPage, @RequestParam Integer pageSize){
        PageHelper.startPage(toPage, pageSize);
        try{
            return (ArrayList<OwnTrailer>)ownTrailerService.findAll().get();
        }catch (NoSuchElementException e){
            LOGGER.error("NO trailer in system!");
        }
        return null;
    }
    @RequestMapping(value = "/trucks", method = RequestMethod.GET)
    public List<OwnTruck> getTrucks(@RequestParam Integer toPage, @RequestParam Integer pageSize){
        PageHelper.startPage(toPage, pageSize);
        try{
            return (ArrayList<OwnTruck>)ownTruckService.findAll().get();
        }catch (NoSuchElementException e){
            LOGGER.error("NO truck in system!");
        }
        return null;
    }

}
