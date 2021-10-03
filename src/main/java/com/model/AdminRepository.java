package com.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface AdminRepository extends CrudRepository<User_org, Integer> {}

