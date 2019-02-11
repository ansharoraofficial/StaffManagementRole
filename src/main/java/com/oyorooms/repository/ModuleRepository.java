package com.oyorooms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oyorooms.entity.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

	List<Module> findByRoleEntityId(Long roleId);

	@Query(value = "select distinct m.read_action from module m where module_name = :moduleName", nativeQuery = true)
	String findReadActionByModuleName(@Param("moduleName") String moduleName);

	@Query(value = "select distinct m.write_action from module m where module_name = :moduleName", nativeQuery = true)
	String findWriteActionByModuleName(@Param("moduleName") String moduleName);

	@Query(value = "select m.module_name from module m where m.read_action = :action or m.write_action = :action", nativeQuery = true)
	String getModuleByAction(@Param("action") String action);

	@Query(value = "select m.id from module m where m.module_name=:moduleName and m.role_entity_id=:id", nativeQuery = true)
	Long getModuleIdByName(@Param("moduleName") String moduleName, @Param("id") Long id);

//	@Query(value = "select m from module m where m.module_name = :moduleName limit 1", nativeQuery = true)
//	Module findActionsByModuleName(@Param("moduleName") String moduleName);
}
