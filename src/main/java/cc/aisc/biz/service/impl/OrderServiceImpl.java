package cc.aisc.biz.service.impl;

import cc.aisc.biz.model.Order;
import cc.aisc.biz.service.OrderService;
import cc.aisc.core.base.AbstractService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class OrderServiceImpl extends AbstractService<Order, String> implements OrderService {
}
