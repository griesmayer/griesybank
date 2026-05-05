package at.spengergasse.service;

import at.spengergasse.domain.Account;
import at.spengergasse.domain.AccountException;
import com.github.javafaker.Faker;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BankService {
    private ArrayList<Account> accounts;

    public BankService() {
        accounts = new ArrayList<>(1000);
        fillTestData(500);
    }

    public void fillTestData(int count) {
        String[] accounttypes = { "Checking", "Savings", "Fixed Deposit", "Business", "Joint" };
        Account   a;
        Faker     faker = new Faker();
        String    firstName;
        LocalDate openingDate;
        String    accountType;
        Double    amount;
        Boolean   active;

        for (int i=0; i<count; i++) {
            firstName = faker.address().firstName();
            openingDate = LocalDate.now().minusDays((int) Math.random() * 3650);
            accountType = accounttypes[faker.random().nextInt(0, accounttypes.length - 1)];
            amount = faker.number().randomDouble(2, 0, 50000);
            active = faker.bool().bool();
            a = new Account(firstName, openingDate, accountType, amount, active);
            accounts.add(a);
        }
    }

    public ArrayList<Account> findAll() {
        ArrayList<Account> copy;
        copy = new ArrayList<>(accounts);
        return copy;
    }

    @Override
    public String toString() {
        return accounts.stream()
                .map(s -> s.toString())
                .collect(Collectors.joining("\n"));
    }

    public void removeAllAccouts() {
        accounts.clear();
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public void remove1(Long accountId) {
        if (accountId == null)
            throw new AccountException("Fehler: kein Account!");
        boolean gef = accounts.removeIf(a -> a.getAccountId().equals(accountId));
        if (! gef)
            throw new AccountException("Fehler: Account nicht gefunden!");
    }

    public void remove1Old(Long accountId) {
        boolean gef;
        Account a;
        Iterator<Account> it;

        if (accountId == null)
            throw new AccountException("Fehler: kein Account!");
        gef = false;
        it = accounts.iterator();
        while (it.hasNext()) {
            a = it.next();
            if (a.getAccountId().equals(accountId)) {
                it.remove();
                gef = true;
            }
        }
        if (gef == false)
            throw new AccountException("Fehler: Account nicht gefunden!");
    }

    public void add100Eur(Long accountId) {
        accounts.stream()
                .filter(a -> a.getAccountId().equals(accountId))
                .forEach(a -> a.setAmount(a.getAmount()+100));
    }
}
