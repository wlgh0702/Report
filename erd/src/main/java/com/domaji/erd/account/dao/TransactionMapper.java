package com.domaji.erd.account.dao;

import com.domaji.erd.account.dto.TransactionDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionMapper {
    void payment(TransactionDTO transaction);
}
