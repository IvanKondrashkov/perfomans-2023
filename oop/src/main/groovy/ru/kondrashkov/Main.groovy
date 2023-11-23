package ru.kondrashkov

import ru.kondrashkov.model.Card
import ru.kondrashkov.model.Currency
import ru.kondrashkov.model.Money
import ru.kondrashkov.service.Atm
import ru.kondrashkov.service.AtmService

static void main(String[] args) {
  Money money = new Money(Currency.RUB)
  Card card = new Card(money)
  AtmService service = new Atm(card)
  Money money1 = new Money(100, Currency.RUB)
  money = service + money1
  println service.balance(money.currency)
  Money money2 = new Money(300, Currency.RUB)
  money = service + money2
  println service.balance(money.currency)
  Money money3 = new Money(300, Currency.RUB)
  money = service - money3
  println service.balance(money.currency)
  Money money4 = new Money(100, Currency.RUB)
  money = service - money4
  println service.balance(money.currency)
  Money money5 = new Money(1000, Currency.RUB)
  money = service + money5
  println service.balance(money.currency)
}