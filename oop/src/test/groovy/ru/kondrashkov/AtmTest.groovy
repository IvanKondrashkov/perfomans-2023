package ru.kondrashkov

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ru.kondrashkov.service.Atm
import ru.kondrashkov.model.Card
import ru.kondrashkov.model.Money
import ru.kondrashkov.model.Currency
import static org.junit.jupiter.api.Assertions.assertThrows

class AtmTest {
    private Money money
    private Card card
    private Atm service

    @BeforeEach
    void init() {
        money = new Money(Currency.RUB)
        card = new Card(money)
        service = new Atm(card)
    }

    @AfterEach
    void tearDown() {
        service.clear(money.currency)
    }

    @Test
    void checkPlus() {
        Money money1 = new Money(100, Currency.RUB)
        money = service + money1

        assert service.balance(money.currency) == 100
    }

    @Test
    void checkMinus() {
        Money money1 = new Money(100, Currency.RUB)
        money = service + money1
        Money money2 = new Money(300, Currency.RUB)
        money = service + money2
        Money money3 = new Money(200, Currency.RUB)
        money = service - money3

        assert service.balance(money.currency) == 200
    }

    @Test
    void checkTakeByNotValidAmount() {
        Money money1 = new Money(1000, Currency.RUB)

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            money = service - money1
        })

        String expectedMessage = exception.getMessage()
        String actualMessage = "Your balance=${service.balance(money.currency)} is less than the requested amount=${money1.amount}!"

        assert expectedMessage == actualMessage
    }

    @Test
    void checkBalance() {
        Money money1 = new Money(100, Currency.RUB)
        money = service + money1

        assert service.balance(money.currency) == 100
    }

    @Test
    void checkClear() {
        Money money1 = new Money(100, Currency.RUB)
        money = service + money1
        service.clear(money.currency)

        assert service.balance(money.currency) == 0
    }
}