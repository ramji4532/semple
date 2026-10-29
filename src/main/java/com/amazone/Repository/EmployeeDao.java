package com.amazone.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amazone.Entity.EmployeeEntity;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {
	
	@Query("select o from EmployeeEntity o where o.name = :empName ")
	
	//@Query(value = "select * from amazone_employee where  salary <60000", nativeQuery = true )
	public List<EmployeeEntity> findByName(@Param("empName") String name);

	//public List<EmployeeEntity> save(List<EmployeeEntity> employeeList);

}
