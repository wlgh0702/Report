package com.domaji.erd.card.service;

import com.domaji.erd.card.dao.CardMapper;
import com.domaji.erd.card.dto.CardDTO;
import com.domaji.erd.card.dto.CardDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{

    private final CardMapper cardMapper;

    @Override
    @Transactional
    public int insertCard(CardDTO card) {

        int result = cardMapper.insertCard(card);

        return result;
    }

    @Override
    public List<CardDTO> cardList() {

        List<CardDTO> cardList = cardMapper.cardList();

        return cardList;
    }

    @Override
    public void issuanceCard(CardDetailDTO cardDetail) {

        StringBuilder sb = new StringBuilder();

        boolean check = true;
        while(check) {

            sb.append((int)(Math.random() * 8999) + 1000);
            sb.append("-");
            sb.append((int)(Math.random() * 8999) + 1000);
            sb.append("-");
            sb.append((int)(Math.random() * 8999) + 1000);
            sb.append("-");
            sb.append((int)(Math.random() * 8999) + 1000);

            String cardNumber = sb.toString();
            System.out.println(cardNumber.length());

            int result = cardMapper.countCard(cardNumber);

            if(result == 0) {
                cardDetail.setCardNumber(cardNumber);
                cardDetail.setCvc((int)(Math.random() * 999) + 100);
                cardMapper.issuanceCard(cardDetail);
                check = false;
            }

            sb.delete(0, sb.length());
        }
    }
}
