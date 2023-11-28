package com.domaji.erd.customer.dao;

import com.domaji.erd.customer.dto.CustomerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    int insertCustomer(CustomerDTO customer);

    List<CustomerDTO> getCustomerList();
}
