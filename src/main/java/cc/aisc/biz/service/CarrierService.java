package cc.aisc.biz.service;

import cc.aisc.biz.model.Carrier;
import cc.aisc.core.base.BaseService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by sjf on 16-4-26.
 */
public interface CarrierService extends BaseService<Carrier, Integer>{
    Optional<Map<String, Object>> findValidById(Integer id);
}
