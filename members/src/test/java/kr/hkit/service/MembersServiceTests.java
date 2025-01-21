package kr.hkit.service;

import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.hkit.domain.MembersVO;
import kr.hkit.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MembersServiceTests {
	@Setter(onMethod_ = @Autowired)
	private MembersService service;
	
	//@Test
	public void testExist() {
		assertNotNull(service);
		log.info(service);
	}
	
	@Test
	public void testRegister() {
		MembersVO members = new MembersVO();
		members.setEmail("new13@mail");
		members.setPwd("13");
		members.setMname("new13");
		
		service.register(members);
		log.info("신규 members 번호 : " + members.getMno());
	}
	
	//@Test
	public void testGet() {
		log.info("!!!!" + service.get(2L));
	}
	
	//@Test
	public void testModify() {
		MembersVO members = service.get(2);
		members.setEmail("new22@mail");
		members.setPwd("22");
		members.setMname("new22");
		
		log.info("!!!!수정결과 : " + service.modify(members));
	}
	
	//@Test
	public void testRemove() {
		log.info("!!!!삭제결과 : " + service.remove(2L));
	}
	
	//@Test
	public void testGetList() {
		
		service.getList(new Criteria(1, 5)).forEach(members->log.info("!!!! : " + members));
	}
}