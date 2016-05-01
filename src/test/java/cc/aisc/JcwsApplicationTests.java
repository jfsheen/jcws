package cc.aisc;

import cc.aisc.biz.model.Carrier;
import cc.aisc.biz.service.CarrierService;
import cc.aisc.biz.service.FuelPriceService;
import cc.aisc.sys.model.Menu;
import cc.aisc.sys.service.MenuService;
import com.google.common.collect.Collections2;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

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
	public void test() throws IOException {
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

		/*Carrier c = carrierService.findWithDetails(1).get();

		logger.debug("{}", c.toString());*/

		StringTokenizer st = new StringTokenizer("a,b,c,d",",; \t\n");
		List<String> tokens = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			String token = st.nextToken().trim();
			if (token.length() > 0) {
				tokens.add(token);
			}
		}
		for (String s : tokens)
			logger.info(s);

		String scope = "武汉,北京";
		String[] strArr = scope.split(",");
		logger.info("{}", strArr.length);

		String b64 = Base64.encodeBase64String(scope.getBytes());
		logger.info(b64);

		String ue = URLEncoder.encode(scope, "utf-8");
		logger.info(ue);

		String ud = URLDecoder.decode(ue, "utf-8");
		logger.info(ud);

		String s = new String(com.sun.org.apache.xerces.internal.impl.dv.util.Base64.decode(b64), "utf-8");

		String s1 = new String(Base64.decodeBase64(b64), "utf-8");

		String s2 = new String(new BASE64Decoder().decodeBuffer(b64), "utf-8");

		logger.info(s);

		logger.info(s1);

		logger.info(s2);

	}
}
