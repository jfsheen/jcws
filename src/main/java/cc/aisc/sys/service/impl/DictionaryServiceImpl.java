package cc.aisc.sys.service.impl;

import cc.aisc.core.base.AbstractService;
import cc.aisc.sys.model.Dictionary;
import cc.aisc.sys.service.DictionaryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by sjf on 16-4-26.
 */
@Service
@Transactional
public class DictionaryServiceImpl extends AbstractService<Dictionary, Integer> implements DictionaryService {
}
