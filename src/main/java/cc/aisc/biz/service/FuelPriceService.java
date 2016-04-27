package cc.aisc.biz.service;

import cc.aisc.biz.model.FuelPrice;
import cc.aisc.core.base.BaseService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

/**
 * Created by sjf on 16-4-25.
 */
public interface FuelPriceService extends BaseService<FuelPrice, Integer>{
    Optional<BigDecimal> findByDate(Date date);
    int insert(FuelPrice fuelPrice);
}
