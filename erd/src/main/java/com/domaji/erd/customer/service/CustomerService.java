package com.domaji.erd.customer.service;

import com.domaji.erd.customer.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    int insertCustomer(CustomerDTO customer);

    List<CustomerDTO> getCustomerList();
}
