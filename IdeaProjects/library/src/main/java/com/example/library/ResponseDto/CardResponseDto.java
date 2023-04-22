package com.example.library.ResponseDto;

import com.example.library.Enum.CardStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResponseDto {
    private int cardId;
    private CardStatus status;
    private Date issueDate;
    private  Date UpdationDate;
    private String validTill;
}
