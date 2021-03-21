package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {



    private SelenideElement amount = $("[type='text']");
    private SelenideElement from = $("[data-test-id='from'] input");
    private SelenideElement buttonTransfer = $("[data-test-id='action-transfer']");
    private SelenideElement buttonCancel = $("[data-test-id='action-cancel']");

    public MoneyTransferPage() {

    }

    public DashboardPage transferMoney(int amountTransfer, DataHelper.Card card) {
        amount.setValue(String.valueOf(amountTransfer));
        from.setValue(card.getNumber());
        buttonTransfer.click();
        return new DashboardPage();
    }

    public SelenideElement errorMessage1(){
        return $(withText("У вас недостаточно средств на карте")).shouldBe(Condition.visible);
    }

    public SelenideElement errorMessage2(){
        return $(withText("Отмена. Минимальный перевод 1 рубль")).shouldBe(Condition.visible);
    }


}