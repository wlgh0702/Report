package com.domaji.erd.card.dao;

import com.domaji.erd.card.dto.CardDTO;
import com.domaji.erd.card.dto.CardDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardMapper {
    int insertCard(CardDTO card);

    int countCard(String cardNumber);

    void issuanceCard(CardDetailDTO cardDetail);

    List<CardDTO> cardList();
}
