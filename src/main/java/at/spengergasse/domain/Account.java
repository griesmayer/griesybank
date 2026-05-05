package at.spengergasse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
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
@EqualsAndHashCode(of = "accountId", callSuper = false)
@Entity
public class Account implements Cloneable {
    @Id
    private Long      accountId;

    @NotEmpty(message = "FirstName is required!")
    @Size(min = 3, max = 40, message = "FirstName min 3 max 40 charters")
    private String    firstName;

    @NotNull(message = "Opening Date is required!")
    @PastOrPresent(message = "Opening date must be in the past or present!")
    private LocalDate openingDate;

    @NotBlank(message = "Account Type is required!")
    @Pattern(
            regexp = "Checking|Savings|Fixed Deposit|Business|Joint",
            message = "Invalid account type"
    )
    private String    accountType;

    @NotNull(message = "Amount is required!")
    @DecimalMin(value = "-1000.0", message = "Fehler: über dem Creditlimit!")
    @DecimalMax(value = "100000.0", message = "Fehler: max 100.000 Euro!")
    private Double    amount;

    private Boolean   active;

    private static final AtomicLong sequence = new AtomicLong(1000);

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

    @Override
    public Account clone() {
        return new Account(accountId, firstName, openingDate, accountType, amount, active);
    }
}
