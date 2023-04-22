package com.example.library.Repository;

import com.example.library.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query(value = "select * from Transaction t where t.card_card_id =:CardId AND t.transaction_status='SUCCESS'", nativeQuery = true)
    List<Transaction>getAllSucessfullTransactionByCardID(int CardId);


}
