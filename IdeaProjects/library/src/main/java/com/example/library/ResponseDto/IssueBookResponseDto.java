package com.example.library.ResponseDto;

import com.example.library.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {
private int transactionId;
private TransactionStatus transactionStatus;
private String bookName;
}
