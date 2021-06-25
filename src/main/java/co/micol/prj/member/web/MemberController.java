package co.micol.prj.member.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberDao;
	
	@RequestMapping("memberRegister.do")
	public String memberRegister(@ModelAttribute("memberVO") @RequestParam("confirmPassword") String confirmPassword, HttpServletRequest req, Model model) {	//@RequestParam("email")String email,  -> vo.setEamil(email); : vo에 존재하지 않는 변수 
		System.out.println(confirmPassword);
		
		MemberVO vo = new MemberVO();				//or (Member vo) -> memberDao.memberInsert(vo);
		vo.setEmail(req.getParameter("email"));
		vo.setName(req.getParameter("name"));
		vo.setPassword(req.getParameter("password"));
		
		int n = memberDao.memberInsert(vo);
		if(n != 0 ) {
			model.addAttribute("message", "입력 성공");
		}else {
			model.addAttribute("message","등록 실패");
		}
		model.addAttribute("memberVO", vo);
		//return "member/memberRegister";
		return "member/memberInputForm";
	}
	
	@RequestMapping("member/memberInputForm")
	public String memberInputForm(MemberVO vo, Model model) {
		model.addAttribute("memberVO", vo);
		return "member/memberInputForm";
	}
}
