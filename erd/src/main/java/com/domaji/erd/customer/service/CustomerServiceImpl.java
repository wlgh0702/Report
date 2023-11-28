package com.domaji.erd.customer.service;

import com.domaji.erd.customer.dao.CustomerMapper;
import com.domaji.erd.customer.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    @Transactional
    public int insertCustomer(CustomerDTO customer) {

        int result = customerMapper.insertCustomer(customer);

        return result;
    }

    @Override
    public List<CustomerDTO> getCustomerList() {

        List<CustomerDTO> customerList = customerMapper.getCustomerList();

        return customerList;
    }
}
