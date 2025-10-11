package lessons.lesson03.part2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BankAccount {
    private Long accountNumber;
    private String fio;
    private BigDecimal balance;

    public String getAccountInfo(){
        return String.format("Account number: %d, fio: %s,  balance: %.2f",
            accountNumber, fio, balance);
    }

    public void replenish(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        balance = balance.add(amount);
        System.out.println("Replenishment of account number " + accountNumber);
    }

    public void withdraw(BigDecimal amount){
        if (amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (balance.subtract(amount).compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance = balance.subtract(amount);
    }
}
