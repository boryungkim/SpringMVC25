package org.testboard.controller;

import org.testboard.controller.TestBoardController;
import org.testboard.domain.BoardVO;
import org.testboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller // url분기와 jsp 연동을 담당한다.
@Log4j2
@RequestMapping("/board/*") // http://192.168.111.104:80/board/* (모든경로)
@AllArgsConstructor // 생성자 자동 주입 (모든 필드를 보고 생성자 만듬)
public class TestBoardController {

	// 리스트와 curd를 담당하는 분기 설정 (url)

	private BoardService service; // 필드

	@GetMapping("/list") // http://192.168.111.104:80/board/list
	public void list(Model model) {
		// model은 스프링에서 데이터 관리용 객체 (예전에는 request영역, session 영역과 같은 의미)
		log.info("BoardController.list메서드 실행.....");

		model.addAttribute("list", service.getList());
		// 프로트에서 ${list} 로 활용한다. (for문을 사용해야 할 거 같다.

		// 컨트롤러에서 리턴타입이 void이면 경로와 같은 jsp를 찾는다.
	}

	@GetMapping("/register")
	public String register() {
		// jsp 페이지 전달용
		return "/board/register";
	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		// RedirectAttributes rttr 성공후 이동할 경로를 기입한다.

		log.info("BoardController.register메서드 실행.....");

		service.register(board); // 객체 등록 성공????
		// 이동할 경로를 배정
		rttr.addFlashAttribute("result", board.getBno());
		// 1회용 값을 생성한다. -> 이름 : result (나중에 프론트에서 alert 용으로 활용됨)

		return "redirect:/board/list"; // 성공시 다음 페이지
	}
}