package com.raymondsugiarto.springbootcacheredis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raymond on 01/03/23
 */
@RestController
@RequiredArgsConstructor
public class TransactionController {

  private TransactionService transactionService;

  // example for lock
  @PostMapping("/transaction")
  public String transactionLock() {
    return transactionService.startTransaction();
  }
}
