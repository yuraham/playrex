package sk.memberPrivate.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sk.management.ManagementDao;
import sk.management.ManagementInfo;
import sk.memberPrivate.PrivateDao;
import sk.memberPrivate.PrivateInfo;

class MemberPrivateTest {
	PrivateDao data = new PrivateDao();
	ManagementDao data2 = new ManagementDao();

	@Test
	void testInsertPrivate() { // 사원등록된 사원 개인정보 등록 (사이트가입)
		ManagementInfo management = new ManagementInfo();
		management.setName("테스트");
		management.setDivision("테스트신입");
		management.setPosition("테스트신입");
		management.setMemo("테스트메모");
		data2.insertManagement(management);
		
		int lastNum = data2.lastNum();
		
		PrivateInfo privacy = new PrivateInfo();
		privacy.setWorker_number(lastNum);
		privacy.setPass("1234");
		privacy.setPhone("1234");
		privacy.setPhone2(null);
		privacy.setE_mail("123@4");
		privacy.setAddress("1234");
		
		assertEquals(1, data.insertPrivate(privacy));
	}
	
	@Test
	void testGetPrivate() { //개인정보 조회
		assertNotNull(data.getPrivate(1));
		
	}
	
	@Test
	void testSiteMember() { //사이트 가입 여부 확인
		assertTrue(data.siteMember(1));
		
	}
	
	@Test
	void testIsMember() { //로그인할때 아이디 비번 확인 
		int number = data2.lastNum();
		String pass = data.getPrivate(number).getPass();
		assertTrue(data.isMember(number, pass));
	}
	
	@Test
	void testUpdateMember() { //개인정보 수정 
		PrivateInfo privacy = new PrivateInfo();
		privacy.setWorker_number(data2.lastNum());
		privacy.setPass("4567");
		privacy.setPhone("4657");
		privacy.setPhone2(null);
		privacy.setE_mail("465@4");
		privacy.setAddress("수정된 주소");
		
		assertEquals(1, data.updateMember(privacy, data2.lastNum()));
		
	}

}
