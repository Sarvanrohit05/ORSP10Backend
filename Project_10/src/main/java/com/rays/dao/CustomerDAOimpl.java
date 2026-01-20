package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CustomerDto;

public class CustomerDAOimpl extends BaseDAOImpl<CustomerDto> implements CustomerDAOInt {

	@Override
	protected List<Predicate> getWhereClause(CustomerDto dto, CriteriaBuilder builder, Root<CustomerDto> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getClientName())) {

			whereCondition.add(builder.like(qRoot.get("clientName"), dto.getClientName() + "%"));
		}

		if (!isEmptyString(dto.getLocation())) {

			whereCondition.add(builder.like(qRoot.get("location"), dto.getLocation() + "%"));
		}
		if (!isZeroNumber(dto.getContactNumber())) {

			whereCondition.add(builder.equal(qRoot.get("contactNumber"), dto.getContactNumber()));
		}

		if (!isEmptyString(dto.getImportance())) {

			whereCondition.add(builder.like(qRoot.get("importance"), dto.getImportance() + "%"));
		}

		return whereCondition;
	}

	@Override
	public Class<CustomerDto> getDTOClass() {
		return CustomerDto.class;
	}

}
