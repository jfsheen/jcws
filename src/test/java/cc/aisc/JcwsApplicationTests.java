package cc.aisc;

import cc.aisc.biz.model.Carrier;
import cc.aisc.biz.service.CarrierService;
import cc.aisc.biz.service.FuelPriceService;
import cc.aisc.sys.model.Menu;
import cc.aisc.sys.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JcwsApplication.class)
public class JcwsApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(JcwsApplicationTests.class);

	@Autowired
	MenuService menuService;
	@Autowired
	FuelPriceService fuelPriceService;
	@Autowired
	CarrierService carrierService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		//FuelPrice fp1 = new FuelPrice(2, DateUtils.addMonths(new Date(), 0), DateUtils.addMonths(new Date(), 3), BigDecimal.valueOf(5.55));

		/*FuelPrice fp2 = new FuelPrice(0, DateUtils.addMonths(new Date(), 3), DateUtils.addMonths(new Date(), 5), BigDecimal.valueOf(5.65));
		FuelPrice fp3 = new FuelPrice(0, DateUtils.addMonths(new Date(), 5), DateUtils.addMonths(new Date(), 8), BigDecimal.valueOf(5.45));
		Integer i2 = fuelPriceService.insert(fp2);
		logger.debug("i2 = {}", i2);
		Integer i3 = fuelPriceService.insert(fp3);
		logger.debug("i3 = {}", i3);*/
		//fuelPriceService.insert(DateUtils.addMonths(new Date(), 3), DateUtils.addMonths(new Date(), 5), BigDecimal.valueOf(5.65));
		//fuelPriceService.insert(DateUtils.addMonths(new Date(), 5), DateUtils.addMonths(new Date(), 8), BigDecimal.valueOf(5.45));

		/*BigDecimal p = fuelPriceService.findByTime(org.apache.commons.lang3.time.DateUtils.addHours(new Date(), 3333)).get();

		logger.debug("p = {}", p);*/

		/*Date now = DateUtils.addDays(new Date(), RandomUtils.number(1, 100));
		logger.debug("{}", now);
		Date start = DateUtils.truncate(now, Calendar.DAY_OF_MONTH);
		logger.debug("{}", start);
		Date end = DateUtils.ceiling(now, Calendar.DAY_OF_MONTH);
		end = DateUtils.addMilliseconds(end, -1);
		logger.debug("{}", end);

		BigDecimal p = fuelPriceService.findByDate(org.apache.commons.lang3.time.DateUtils.addHours(new Date(), 3333)).get();

		logger.debug("p = {}", p);*/

		Menu m = menuService.findById(1).get();
		Carrier c = carrierService.findById(1).get();

		logger.debug("{}", m.getText());
		logger.debug("{}", c.getAddress());



	}
}
