package sk.update.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sk.management.ManagementDao;
import sk.memberPrivate.PrivateDao;
import sk.update.InsertUpdateDao;
import sk.update.InsertUpdateInfo;

class InsertUpdateDaoTest { // 수정내역 추가하기
	InsertUpdateDao data = new InsertUpdateDao();
	ManagementDao data2 = new ManagementDao();
	
	
	@Test
	void testInsertUpdate() {
		InsertUpdateInfo update = new InsertUpdateInfo();
		update.setCategory("테스트");
		update.setFiled_name("테스트");
		update.setNew_data("테스트");
		update.setOld_data("테스트");
		
		assertEquals(1, data.insertUpdate(update, data2.lastNum()));
	}
	
	@Test
	void testGetList() { //수정내역 가져오기(리스트만들때)
		InsertUpdateInfo update = new InsertUpdateInfo();
		int number = data.getLastNum("테스트",data2.lastNum());
		update = data.getList(data2.lastNum(),"테스트", number);
		
		assertNotNull(update);
		
	}
	
	@Test
	void testGetLastNum() {//수정내역중에 가장 최근 추가된 내역의 번호 가져오기 
		int number = data2.lastNum();
		int num = data.getLastNum("테스트", number);
		
		assertNotNull(num);
		
	}

	
	@Test
	void testIsNumManagement() { //사원번호와 순번으로 인사정보 수정내용이 존재하는지 확인
		InsertUpdateInfo update = new InsertUpdateInfo();
		update.setCategory("인사정보");
		update.setFiled_name("테스트");
		update.setNew_data("테스트");
		update.setOld_data("테스트");
		
		data.insertUpdate(update, data2.lastNum());
		int lastNum = data.getLastNum("인사정보", data2.lastNum());
		assertTrue(data.isNumManagement(lastNum, data2.lastNum()));
	}
	
	@Test
	void testIsNumPrivate() {// 사원번호와 순번으로 개인정보 수정 내역이 존재하는지 확인
		InsertUpdateInfo update = new InsertUpdateInfo();
		update.setCategory("개인정보");
		update.setFiled_name("테스트");
		update.setNew_data("테스트");
		update.setOld_data("테스트");
		data.insertUpdate(update, data2.lastNum());
		int lastNum = data.getLastNum("개인정보", data2.lastNum());
		assertTrue(data.isNumPrivate(lastNum, data2.lastNum()));
		
	}
}

