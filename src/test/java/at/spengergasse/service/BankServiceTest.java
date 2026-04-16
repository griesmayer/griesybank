package at.spengergasse.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @Test
    public void testFillTestData() {
        BankService spar = new BankService();
        System.out.println(spar);
    }

    @Test
    public void testFindAll() {
        BankService bank = new BankService();
        System.out.println(bank.findAll());
    }
}