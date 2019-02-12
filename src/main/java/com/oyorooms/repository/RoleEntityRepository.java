package com.oyorooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oyorooms.entity.RoleEntity;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
	
	@Query(value = "select r.id from role_entity r where role_name = ?1", nativeQuery = true)
	Long findIdByName(String roleName);
}
