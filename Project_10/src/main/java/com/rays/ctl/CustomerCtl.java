package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CustomerDto;
import com.rays.form.CustomerForm;
import com.rays.service.CustomerServiceInt;

public class CustomerCtl extends BaseCtl<CustomerForm, CustomerDto, CustomerServiceInt> {

	@Autowired
	private CustomerServiceInt customerService;

	@GetMapping("/perload")
	public ORSResponse preload() {

		ORSResponse res = new ORSResponse(true);
		CustomerDto dto = new CustomerDto();
		List<DropdownList> list = customerService.search(dto, userContext);
		res.addResult("inlist", list);
		return res;

	}
}
