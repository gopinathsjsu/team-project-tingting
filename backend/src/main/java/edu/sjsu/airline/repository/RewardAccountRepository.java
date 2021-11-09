package edu.sjsu.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.sjsu.airline.model.RewardAccount;

@Repository
public interface RewardAccountRepository extends JpaRepository<RewardAccount, Long> {
	
	@Query("FROM RewardAccount WHERE customer_user_id = :userId")
	Optional<RewardAccount> findByUserId( Long userId );
	
}
