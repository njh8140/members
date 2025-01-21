package kr.hkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.hkit.domain.MembersVO;
import kr.hkit.domain.Criteria;
import kr.hkit.domain.PageDTO;
import kr.hkit.service.MembersService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/members/*")
public class MembersController {
	
	@Setter(onMethod_ = @Autowired)
	private MembersService service;
	
	@GetMapping("/list") //전체 목록
	public void list(Criteria cri, Model model) {
		
		log.info("====list====" + cri);
		
		model.addAttribute("list", service.getList(cri));
		int total = service.getTotal(cri);
		
		log.info("total : " + total);
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		
	}
	
	@PostMapping("/register") // 신규 등록
	public String register(MembersVO members, RedirectAttributes rttr) {
		
		log.info("register : " + members);
		
		service.register(members);
		rttr.addFlashAttribute("result", members.getMno());
		
		
		return "redirect:/members/list";
	}
	
	@GetMapping("/register") // 신규 등록 페이지
	public void register() {
		log.info("/get register" );
	}
	
	@GetMapping({"/get", "/modify"}) // 조건부 검색
	public void get(@RequestParam("mno") long mno, @ModelAttribute("cri") Criteria cri, Model model) {
		
		log.info("/get or /modify ");
		model.addAttribute("members", service.get(mno));
	}
	 
	@PostMapping("/modify") // 업데이트(수정)
	public String modify(MembersVO members, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("modify : " + members);
		
		if(service.modify(members)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/members/list";
	}
	
	@PostMapping("/remove") // 삭제
	public String remove(@RequestParam("mno") long mno, @ModelAttribute("cri") Criteria cri ,RedirectAttributes rttr) {
		
		log.info("remove : " + mno);
		
		if(service.remove(mno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/members/list";
	}
	
}