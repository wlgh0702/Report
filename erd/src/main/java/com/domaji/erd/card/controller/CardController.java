package com.domaji.erd.card.controller;

import com.domaji.erd.card.dto.CardDTO;
import com.domaji.erd.card.dto.CardDetailDTO;
import com.domaji.erd.card.service.CardService;
import com.domaji.erd.common.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("/insert")
    public ResponseEntity<?> insertCard(@RequestBody CardDTO card) {

        int result = cardService.insertCard(card);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "insert 성공", null));
    }

    @GetMapping("/list")
    public ResponseEntity<?> cardList() {

        List<CardDTO> cardList = cardService.cardList();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "카드 목록 조회", cardList));
    }

    @PostMapping("/issuance")
    public ResponseEntity<?> issuanceCard(@RequestBody CardDetailDTO cardDetail) {

        cardService.issuanceCard(cardDetail);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "카드 발급 성공", null));
    }
}
