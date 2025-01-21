package kr.hkit.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.hkit.domain.MembersVO;

import kr.hkit.mapper.MembersMapper;

import kr.hkit.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MembersMapperTests {

	@Setter(onMethod_ = @Autowired)
	private MembersMapper mapper;
	
	//@Test //insert
	public void testInsert() {
		MembersVO members = new MembersVO();
		members.setEmail("spring");
		members.setPwd("1");
		members.setMname("nam");
		
		mapper.insert(members);
		
		log.info(members);
	}
	
	//@Test 
	public void MembersTest() {
		
		mapper.getList().forEach(members->log.info("@@ " + members));
	}
	
	//@Test //select insert
	public void testInsetSelectKey() {
		MembersVO members = new MembersVO();
		members.setEmail("spring3");
		members.setPwd("33");
		members.setMname("nam3");
		
		mapper.insertSelectKey(members);
		log.info(members);
		
	}
	
	//@Test // select where
	public void testRead() {
		MembersVO members =mapper.read(1L);
		log.info("0000"+members);
	}
	
	//@Test
	public void testDelete() {
		mapper.delete(483L);
		log.info("삭제완료 : " + mapper.delete(483L));
	} 
	
	//@Test //update
	public void testUpdate() {
		MembersVO members = new MembersVO();
		members.setMno(1L);
		members.setEmail("spring333");
		members.setPwd("333");
		members.setMname("nam333");
		
		mapper.update(members); 
		
		log.info("수정 완료 : " + mapper.update(members));
	}
	
	//@Test //paging
	public void testPaging() {
		Criteria cri = new Criteria(2, 20);
		mapper.getListWithPaging(cri).forEach(members-> log.info("!!!!" + members));
	}
	
	//@Test
	public void testGetTotal() {
		Criteria cri = new Criteria();
		
		cri.setType("W");
		cri.setKeyword("Lee");
		
		log.info("(db갯수)total : "+mapper.getTotal(cri)); 
	}
	
	//@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		
		cri.setType("T");
		cri.setKeyword("spring333");
		
		mapper.getListWithPaging(cri).forEach(members->log.info(members));
		
	}
}