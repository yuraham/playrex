package sk.management.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sk.management.ManagementDao;
import sk.management.ManagementInfo;

class ManagementDaoTest {

	@Test
	void test() {
		ManagementDao data = new ManagementDao();
		assertEquals(true, data.isManagement(9, "양순규"));
	}
	
	@Test
	void test2() {
		ManagementDao data = new ManagementDao();
		ManagementInfo management = new ManagementInfo();
		management.setName("홍길동");
		
		assertEquals(1, data.insertManagement(management));
	}

}
