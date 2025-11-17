package kr.ac.kopo.su.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.ac.kopo.su.bookmarket.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>
{
    Member findByMemberId(String memberId);

}
