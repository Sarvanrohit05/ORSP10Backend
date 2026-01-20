package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.CustomerDAOInt;
import com.rays.dto.CustomerDto;

public class CustomerServiceImpl extends BaseServiceImpl<CustomerDto, CustomerDAOInt> implements CustomerServiceInt {

	@Autowired
	CustomerDAOInt customerDAO;

	@Override
	public CustomerDto findByName(String name, UserContext userContext) {

		return baseDao.findByUniqueKey("name", name, userContext);
	}

}
