package co.micol.prj.research.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.research.service.ResearchQuestionService;
import co.micol.prj.research.service.ResearchResponseService;
import co.micol.prj.research.service.ResearchService;
import co.micol.prj.research.vo.ResearchQuestionVO;
import co.micol.prj.research.vo.ResearchResponseVO;
import co.micol.prj.research.vo.ResearchVO;
import co.micol.prj.research.vo.ResultVO;

@Controller
public class ResearchController {
	@Autowired
	@Qualifier("researchDao")
	private ResearchService dao;
	
	@Autowired
	private ResearchQuestionService questionDao;
	@Autowired
	private ResearchResponseService responseDao;
	
	@RequestMapping("researchList.do")
	public String researchList(@ModelAttribute("lists") ResultVO vo,  Model model) {
		model.addAttribute("lists", dao.researchSelectList());
		return "research/researchList";
	}
	
	@RequestMapping("researchSelect.do")
	public String researchSelect(ResearchVO vo, Model model) {
		model.addAttribute("vo", dao.researchSelect(vo));
		return "research/researchSelect";
	}
	
	@RequestMapping("researchAppend.do")
	public String researchAppend(ResearchVO vo, Model model) {
		ResearchQuestionVO rvo = new ResearchQuestionVO();
		rvo.setId(vo.getId());
		model.addAttribute("researchTitle", dao.researchSelect(vo));
		model.addAttribute("qlists",questionDao.questionList(rvo));
		return "research/researchAppend";
	}
	
	@RequestMapping("researchAppendwrite.do")
	public String responseInsert(HttpServletRequest request, Model model) {
		List<ResearchResponseVO> list = new ArrayList<ResearchResponseVO>();
		ResearchResponseVO vo = new ResearchResponseVO();
		//넘겨받을 값 id, qid, order, result
		
		//int id, qid, order
		//qResult[1] 동일한 객체로
		//while(){ vo 초기화
		//	넘어온객체 vo에 담고
		//	리스트추가
		
		int n = responseDao.responseInsert(list);
		String message;
		if(n>0)
			message ="설문이 정상등록 되었습니다.";
		else
			message="설문 등록이 실패했습니다.";
		model.addAttribute("str",n);
		return "research/researchAppendwrite";
	}
}