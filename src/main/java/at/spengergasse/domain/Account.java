package at.spengergasse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "orderId", callSuper = false)
@Entity
public class Account implements Cloneable {
    @Id
    private Long      accountId;
    private String    firstName;
    private LocalDate openingDate;
    private String    accountType;
    private Double    amount;
    private Boolean   active;

    private static final AtomicLong sequence = new AtomicLong(1000);
    private static final String[] accounttypes = { "Checking", "Savings", "Fixed Deposit", "Business", "Joint" };

    public Account() {
        setAccountId ();
        setFirstName ("UNKN");
        setOpeningDate (LocalDate.now());
        setAccountType ("Credit");
        setAmount (0.0);
        setActive (true);
    }

    public Account(String firstName, LocalDate openingDate, String accountType, Double amount, Boolean active) {
        setAccountId ();
        setFirstName (firstName);
        setOpeningDate (openingDate);
        setAccountType (accountType);
        setAmount (amount);
        setActive (active);
    }

    public Account(Long accountId, String firstName, LocalDate openingDate, String accountType, Double amount, Boolean active) {
        setAccountId (accountId);
        setFirstName (firstName);
        setOpeningDate (openingDate);
        setAccountType (accountType);
        setAmount (amount);
        setActive (active);
    }

    public void setAccountId() {
        accountId = sequence.getAndIncrement();
    }

    public void setAmount(Double amount) {
        if (amount.doubleValue() < -1000)
            throw new AccountException("Fehler: über dem Creditlimit!");
        if (amount.doubleValue() > 100000)
            throw new AccountException("Fehler: max 100.000 Euro!");
    }

    public void setAccountType(String accountType) {
        if (! Arrays.asList(accounttypes).contains(accountType))
            throw new AccountException("Fehler: falscher Account Type!");
        this.accountType = accountType;
    }

    @Override
    public Account clone() {
        return new Account(accountId, firstName, openingDate, accountType, amount, active);
    }
}
