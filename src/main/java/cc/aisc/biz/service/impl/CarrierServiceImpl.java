package cc.aisc.biz.service.impl;

import cc.aisc.biz.mapper.CarrierMapper;
import cc.aisc.biz.model.Carrier;
import cc.aisc.biz.service.CarrierService;
import cc.aisc.core.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class CarrierServiceImpl extends AbstractService<Carrier, Integer> implements CarrierService {

    @Autowired
    private CarrierMapper carrierMapper;

    @Override
    public Optional<Map<String, Object>> findValidById(Integer id) {
        return Optional.ofNullable(carrierMapper.selectValidById(id));
    }


}
