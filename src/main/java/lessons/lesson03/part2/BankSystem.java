package lessons.lesson03.part2;

import java.math.BigDecimal;
import java.util.List;

public class BankSystem {
    private List<BankAccount> bankAccounts;

    public void getAccountInfo(Long accountNumber){
        bankAccounts.forEach(account -> {
            if(account.getAccountNumber().equals(accountNumber)){
                System.out.println(account.getAccountInfo());
            }
        });
    }

    public void addAccount(BankAccount bankAccount){
        bankAccounts.add(bankAccount);
    }

    public void deleteAccount(Long accountNumber){
        bankAccounts.removeIf(account -> account.getAccountNumber().equals(accountNumber));
    }

    public void replenishAccount(BankAccount bankAccount, BigDecimal amount){
        bankAccounts.forEach(account -> {
            if(account.getAccountNumber().equals(bankAccount.getAccountNumber())){
                account.replenish(amount);
            }
        });
    }

    public void transferMoneyBetweenAccounts(BankAccount fromAccount, BankAccount toAccount, BigDecimal amount){
        for(BankAccount bankAccount : bankAccounts){
            if(bankAccount.getAccountNumber().equals(fromAccount.getAccountNumber())){
                fromAccount = bankAccount;
            } else if(bankAccount.getAccountNumber().equals(toAccount.getAccountNumber())){
                toAccount = bankAccount;
            }
        }
        fromAccount.withdraw(amount);
        toAccount.replenish(amount);
    }

}
