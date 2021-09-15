package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * You have two classes:
 * <p>
 * Transaction: uuid: String,  state: State (CANCELED, FINISHED, PROCESSING), sum: Long, created: Date
 * Account: number: String, balance: Long, transactions: List<Transaction>
 * <p>
 * Both classes have getters for all fields with the corresponding names
 * (getState(), getSum(), getTransactions() and so on).
 * Write a method using Stream API that calculates the total sum of canceled transactions for all
 * non-empty accounts (balance > 0). Perhaps, flatMap method can help you to implement it.
 * Classes Transaction, Account and enum State will be available during testing.
 * You can define your own classes for local testing.
 * <p>
 * Important. Use the given template for your method. Pay attention to type of an
 * argument and the returned value. Please, use only Stream API, no cycles.
 * <p>
 * Examples: there are 2 accounts (in JSON notation) below. The result is 10 000.
 * <p>
 * [
 * {
 * "number": "1001",
 * "balance": 0,
 * "transactions": [
 * {
 * "uuid": "774cedda-9cde-4f53-8bc2-5b4d4859772a",
 * "state": "CANCELED",
 * "sum": 1000,
 * "created": "2016.12.12 18:30:05"
 * }
 * ]
 * },
 * {
 * "number": "1002",
 * "balance": 8000,
 * "transactions": [
 * {
 * "uuid": "337868a7-f469-43c0-9042-3422ce37ee26a",
 * "state": "FINISHED",
 * "sum": 8000,
 * "created": "2016.12.12 17:30:55"
 * },
 * {
 * "uuid": "f8047f86-89e7-4226-8b75-74c55a4d7e31",
 * "state": "CANCELED",
 * "sum": 10000,
 * "created": "2016.12.12 18:10:18"
 * }
 * ]
 * }
 * ]
 */
public class Task7 {

    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        //TODO Write your code here

        return accounts.stream()
                .filter((account -> account.getBalance() > 0))
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState().equals(State.CANCELED))
                .mapToLong(Transaction::getSum)
                .sum();
    }

    public static List<Account> hardcoreInputData(String... jsonStrings) {
        final List<Account> result = new ArrayList<>();
        final ObjectMapper mapper = new ObjectMapper();

        Arrays.stream(jsonStrings).forEach((jsonString) -> {
            try {
                result.add(mapper.readValue(jsonString, Account.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        return result;
    }

}

class Transaction {
    String uuid;
    State state;
    Long sum;
    Date created;

    public Transaction() {
    }

    public Transaction(String uuid, State state, Long sum, Date created) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
        this.created = created;
    }

    public String getUuid() {
        return uuid;
    }

    public State getState() {
        return state;
    }

    public Long getSum() {
        return sum;
    }

    public Date getCreated() {
        return created;
    }
}

class Account {
    String number;
    Long balance;
    List<Transaction> transactions;

    public Account() {
    }

    public Account(String number, Long balance, List<Transaction> transactions) {
        this.number = number;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getNumber() {
        return number;
    }
}

enum State {
    CANCELED,
    FINISHED
}

