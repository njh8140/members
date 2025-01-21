package kr.hkit.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class MembersControllerTests {
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;

	private MockMvc mockMvc;
	
	@Before 
	public void setup() {
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
				.build();
	}
	
	@Test //전체목록
	public void testList() throws Exception{
		
		log.info("!!!! " + mockMvc.perform(MockMvcRequestBuilders
			.get("/members/list"))
			.andReturn()
			.getModelAndView()
			.getModelMap());
	}
	
	//@Test //신규 등록
	public void testRegister() throws Exception{
		
		log.info("!!!! " + mockMvc.perform(MockMvcRequestBuilders
			.post("/members/register")
			.param("email", "신규 메일")
			.param("pwd", "1")
			.param("mname", "이름"))
			.andReturn().getModelAndView().getViewName());
	}
	
	//@Test //조건부 검색
	public void testGet() throws Exception{
		
		log.info("!!!! " + mockMvc.perform(MockMvcRequestBuilders
			.get("/members/get")
			.param("mno", "1"))
			.andReturn().getModelAndView().getModelMap());
	}
	
	//@Test //업데이트(수정)
	public void testModify() throws Exception{
		
		log.info("!!!! " + mockMvc.perform(MockMvcRequestBuilders
			.post("/members/modify")
			.param("mno", "1")
			.param("email", "메일 업데")
			.param("pwd", "11")
			.param("mname", "이름 업데"))
			.andReturn().getModelAndView().getModelMap());
	}
	
	
	//@Test //삭제
	public void testRemove() throws Exception{
		
		log.info("!!!! " + mockMvc.perform(MockMvcRequestBuilders
			.post("/members/remove")
			.param("mno", "1"))
			.andReturn().getModelAndView().getModelMap());
	}
}
