package com.domaji.erd.card.service;

import com.domaji.erd.card.dto.CardDTO;
import com.domaji.erd.card.dto.CardDetailDTO;

import java.util.List;

public interface CardService {
    int insertCard(CardDTO card);

    void issuanceCard(CardDetailDTO cardDetail);

    List<CardDTO> cardList();
}
