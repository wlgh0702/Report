package com.domaji.erd.savings.dao;

import com.domaji.erd.savings.dto.SavingDTO;
import com.domaji.erd.savings.dto.SavingsDetailDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SavingsMapper {
    int insertSavings(SavingDTO saving);

    void createSavings(SavingsDetailDTO detail);
}
