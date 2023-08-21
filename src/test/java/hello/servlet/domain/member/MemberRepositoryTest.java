package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {

	MemberRepository memberRepository = MemberRepository.getInstance();

	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void save() {
		Member member = new Member("KIM", 30);

		Member saveMember = memberRepository.save(member);

		Member findMember = memberRepository.findById(saveMember.getId());
		assertThat(saveMember).isEqualTo(findMember);
	}

	@Test
	void findAll() {
		Member member1 = new Member("kim1", 30);
		Member member2 = new Member("kim2", 30);

		memberRepository.save(member1);
		memberRepository.save(member2);

		List<Member> members = memberRepository.findAll();

		assertThat(members.size()).isEqualTo(2);
		assertThat(members).contains(member1, member2);
	}
}