package gsmserver.Components.Checkout;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class PaymentService {

    /**
     * Give an id of payment service. Find locators [data-sm-role='checkout.payment-select'] and get part of [data-sm-target='checkout.payment-service-***]
     * @param idOfPaymentService
     * String value of id of payment service
     * @return
     * object Payment
     */
    @Step("Choose payment service: [{0}] and check cost")
    public PaymentService choosePaymentServiceAndCheckCost(final String idOfPaymentService){
        SelenideElement paymentService = $("tr[data-sm-target='checkout.payment-service-" + idOfPaymentService);
        String cost = paymentService.$("td>strong").getText();
        paymentService.click();
        $("div[data-sm-name='checkout.payment-service-"+idOfPaymentService).$(".price-delivery strong").shouldHave(Condition.text(cost));
        return this;
    }

}
