package com.oyorooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oyorooms.entity.RoleEntity;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {

}
