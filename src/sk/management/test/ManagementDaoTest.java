package sk.management.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sk.management.ManagementDao;
import sk.management.ManagementInfo;

class ManagementDaoTest {
	//최초에 관리자 사원을 등록해줘야 테스트 가능 사원번호:1, 이름: 사용자1
	ManagementDao data = new ManagementDao();

	@Test
	void testInsertManagement() { // 인사정보 등록
		ManagementInfo management = new ManagementInfo();
		management.setName("홍길동");
		management.setDivision("신입");
		management.setPosition("신입");
		management.setMemo("메모");
		assertEquals(1, data.insertManagement(management));
	}
	
	@Test
	void testIsManagement() { // 사원등록조회(사이트 가입 여부)
//		assertEquals(true, data.isManagement(1,"사용자1"));
		assertTrue(data.isManagement(1,"사용자1"));
	}
	@Test
	void testIsManagement2() { //사원번호 등록 여부 조회
//		assertEquals(true, data.isManagement2(1));
		assertTrue(data.isManagement2(1));
	}
	
	@Test
	void testGetManagement() {//인사정보 조회
		assertNotNull(data.getManagement(1));
	}
	
	@Test
	void testGetList() { //인사정보 조회 리스트 만들기 
		assertNotNull(data.getList("사용자1", 1));
	}
	
	@Test
	void testUpdateMember() { //인사정보 수정
		ManagementInfo testManagement = new ManagementInfo();
		testManagement.setDivision("테스트");
		testManagement.setPosition("테스트");
		testManagement.setLeave_date(null);
		testManagement.setActive("1");
		testManagement.setMemo("테스트메모");
		assertEquals(1, data.updateMember(testManagement, 1));
	}
	
	
	@Test
	void testLastNum() {// 마지막으로 등록한 사원 번호 가져오기 
		assertNotNull(data.lastNum());
		
	}
	
	
}
