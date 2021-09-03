package com.agusrichard.todo.todo;

import com.agusrichard.todo.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SELECT t FROM Todo t WHERE account_id=:account_id")
    List<Todo> getTodoListByAccount(@Param("account_id") Long accountId);
}
