package cc.aisc.biz.service.impl;

import cc.aisc.biz.mapper.FuelPriceMapper;
import cc.aisc.biz.model.FuelPrice;
import cc.aisc.biz.service.FuelPriceService;
import cc.aisc.core.base.AbstractService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * Created by sjf on 16-4-25.
 */
@Service
@Transactional
public class FuelPriceServiceImpl extends AbstractService<FuelPrice, Integer> implements FuelPriceService {

    @Autowired
    private FuelPriceMapper fuelPriceMapper;

    @Override
    public Optional<BigDecimal> findByDate(Date date) {
        return Optional.ofNullable(fuelPriceMapper.selectByDate(date));
    }

    @Override
    public int insert(FuelPrice fuelPrice) {
        Date start = DateUtils.truncate(fuelPrice.getStart(), Calendar.DAY_OF_MONTH);
        Date end = DateUtils.ceiling(fuelPrice.getEnd(), Calendar.DAY_OF_MONTH);
        end = DateUtils.addMilliseconds(end, -1);
        fuelPrice.setStart(start);
        fuelPrice.setEnd(end);
        return super.insert(fuelPrice);
    }
}
