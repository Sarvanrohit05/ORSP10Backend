package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.CustomerDto;

public interface CustomerServiceInt extends BaseServiceInt<CustomerDto> {

	public CustomerDto findByName(String name, UserContext userContext);

}
