package co.grandcircus.bookclubapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.bookclubapi.model.ClubMember;

public interface ClubMemberRepository extends JpaRepository<ClubMember, Long> {
	
}
