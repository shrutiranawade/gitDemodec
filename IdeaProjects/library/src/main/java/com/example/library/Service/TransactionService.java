package com.example.library.Service;

import com.example.library.Entity.Book;
import com.example.library.Entity.Card;
import com.example.library.Entity.Transaction;
import com.example.library.Enum.CardStatus;
import com.example.library.Enum.TransactionStatus;
import com.example.library.Repository.BookRepository;
import com.example.library.Repository.CardRepository;
import com.example.library.Repository.TransactionRepository;
import com.example.library.RequestDto.IssueBookRequestDto;
import com.example.library.ResponseDto.IssueBookResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

  //create transaction object & setting transaction id random & issueOperation
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        Card card;
        try{
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Card Id");
            transactionRepository.save(transaction);
            throw  new Exception("Invalid Card Id");
        }
        Book book;
        try {
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Book Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid Card Id");
        }
transaction.setBook(book);
        transaction.setCard(card);

        //card is not activated

        if (card.getStatus() != CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Card is not Activated");
            transactionRepository.save(transaction);
            throw  new Exception("Card is not Activated");
        }
        //if book is already issued
        if (book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Book is already Issued");
            transactionRepository.save(transaction);
            throw new Exception("Book is already Issued");
        }
//if every thing is valid & book is available,card is activated
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction completed Successfully");
      //  transactionRepository.save(transaction);
    book.setIssued(true);
    book.setCard(card);
book.getTransactions().add(transaction);
card.getTransactions().add(transaction);
card.getBooks().add(book);
cardRepository.save(card);  // save card is parent of book & transaction so they get saved automatically
//prepare ResponseDto
IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
    issueBookResponseDto.setBookName(book.getTitle());
    issueBookResponseDto.setTransactionId(transaction.getId());
    issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
    return  issueBookResponseDto;
    }
    public String getAllSucessfullTransactionByCardID(int cardId){
        List<Transaction>transactions = transactionRepository.getAllSucessfullTransactionByCardID(cardId);
        String ans ="";
        for (Transaction t : transactions){
            ans += t.getTransactionNumber();
            ans +="\n";
        }
        return ans;
    }
}
