package cc.aisc.core.config.db.support;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by sjf on 16-3-21.
 */

public class DynamicDataSource  extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSource();
    }

}
