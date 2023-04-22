package com.example.library.Controller;

import com.example.library.Entity.Transaction;
import com.example.library.RequestDto.IssueBookRequestDto;
import com.example.library.ResponseDto.IssueBookResponseDto;
import com.example.library.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue_book")
    public ResponseEntity issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){
        IssueBookResponseDto issueBookResponseDto;
        try {
           issueBookResponseDto= transactionService.issueBook(issueBookRequestDto);
        }
        catch (Exception e){
           return  new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
return new ResponseEntity(issueBookResponseDto,HttpStatus.OK);
    }

    @GetMapping("/get")
    public String getAllTransaction(@RequestParam("cardId") int cardId){
        return transactionService.getAllSucessfullTransactionByCardID(cardId);
    }

}
