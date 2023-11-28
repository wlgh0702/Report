package com.domaji.erd.savings.service;

import com.domaji.erd.savings.dto.SavingDTO;
import com.domaji.erd.savings.dto.SavingsDetailDTO;

public interface SavingsService {
    int insertSavings(SavingDTO saving);

    void createSavings(SavingsDetailDTO detail);
}
