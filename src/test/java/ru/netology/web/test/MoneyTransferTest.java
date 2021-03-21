package ru.netology.web.test;


import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPageV2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {


  @Test
  void shouldTransferMoneyFromFirstCardToSecondCardMax() {
    val loginPage = open("http://localhost:9999", LoginPageV2.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
    val moneyTransferPage = dashboardPage.secondBill();
    int amount = 10000;
    moneyTransferPage.transferMoney(amount, DataHelper.getCardFirst());
    val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
    assertEquals((balanceFirstBillBeforeTransfer - amount), balanceFirstBillAfterTransfer);
    assertEquals((balanceSecondBillBeforeTransfer + amount), balanceSecondBillAfterTransfer);
  }
  @Test
  void shouldTransferMoneyFromFirstCardToSecondCardMin() {
    val loginPage = open("http://localhost:9999", LoginPageV2.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
    val moneyTransferPage = dashboardPage.secondBill();
    int amount = 1;
    moneyTransferPage.transferMoney(amount, DataHelper.getCardFirst());
    val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
    assertEquals((balanceFirstBillBeforeTransfer - amount), balanceFirstBillAfterTransfer);
    assertEquals((balanceSecondBillBeforeTransfer + amount), balanceSecondBillAfterTransfer);
  }
  @Test
  void shouldTransferMoneyFromFirstCardToSecondCard() {
    val loginPage = open("http://localhost:9999", LoginPageV2.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
    val moneyTransferPage = dashboardPage.secondBill();
    int amount = 5000;
    moneyTransferPage.transferMoney(amount, DataHelper.getCardFirst());
    val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
    assertEquals((balanceFirstBillBeforeTransfer - amount), balanceFirstBillAfterTransfer);
    assertEquals((balanceSecondBillBeforeTransfer + amount), balanceSecondBillAfterTransfer);
  }

  @Test
  void shouldTransferMoneyFromSecondCardToFirstCardMax() {
    val loginPage = open("http://localhost:9999", LoginPageV2.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
    val moneyTransferPage = dashboardPage.firstBill();
    int amount = 10000;
    moneyTransferPage.transferMoney(amount, DataHelper.getCardSecond());
    val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
    assertEquals((balanceFirstBillBeforeTransfer + amount), balanceFirstBillAfterTransfer);
    assertEquals((balanceSecondBillBeforeTransfer - amount), balanceSecondBillAfterTransfer);
  }
  @Test
  void shouldTransferMoneyFromSecondCardToFirstCardMin() {
    val loginPage = open("http://localhost:9999", LoginPageV2.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
    val moneyTransferPage = dashboardPage.firstBill();
    int amount = 1;
    moneyTransferPage.transferMoney(amount, DataHelper.getCardSecond());
    val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
    assertEquals((balanceFirstBillBeforeTransfer + amount), balanceFirstBillAfterTransfer);
    assertEquals((balanceSecondBillBeforeTransfer - amount), balanceSecondBillAfterTransfer);
  }
  @Test
  void shouldTransferMoneyFromSecondCardToFirstCard() {
    val loginPage = open("http://localhost:9999", LoginPageV2.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
    val moneyTransferPage = dashboardPage.firstBill();
    int amount = 1000;
    moneyTransferPage.transferMoney(amount, DataHelper.getCardSecond());
    val balanceFirstBillAfterTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillAfterTransfer = dashboardPage.getSecondCardBalance();
    assertEquals((balanceFirstBillBeforeTransfer + amount), balanceFirstBillAfterTransfer);
    assertEquals((balanceSecondBillBeforeTransfer - amount), balanceSecondBillAfterTransfer);
  }

  @Test
  void shouldMessageAmountBiggerBill() {
    val loginPage = open("http://localhost:9999", LoginPageV2.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
    val moneyTransferPage = dashboardPage.firstBill();
    int amount = 100000;
    moneyTransferPage.transferMoney(amount, DataHelper.getCardSecond());
    moneyTransferPage.errorMessage1();


  }
  @Test
  void shouldMessageAmountNull() {
    val loginPage = open("http://localhost:9999", LoginPageV2.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    val balanceFirstBillBeforeTransfer = dashboardPage.getFirstCardBalance();
    val balanceSecondBillBeforeTransfer = dashboardPage.getSecondCardBalance();
    val moneyTransferPage = dashboardPage.firstBill();
    int amount = 0;
    moneyTransferPage.transferMoney(amount, DataHelper.getCardSecond());
    moneyTransferPage.errorMessage2();


  }


  }



