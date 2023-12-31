package hello.servlet.web.springmvc.v3;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
	private final MemberRepository memberRepository = MemberRepository.getInstance();

	@GetMapping("/new-form")
	public String join() {
		return "new-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam String username, @RequestParam int age, Model model) {
		Member member = new Member(username, age);
		memberRepository.save(member);

		model.addAttribute("member", member);
		return "save-result";
	}

	@GetMapping
	public String list(Model model) {
		List<Member> members = memberRepository.findAll();
		model.addAttribute("members", members);

		return "members";
	}
}