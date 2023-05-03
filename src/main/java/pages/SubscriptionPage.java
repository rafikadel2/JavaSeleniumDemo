package pages;


import helpers.DriverAction;
import helpers.Localization;
import org.openqa.selenium.By;

import java.util.List;

public class SubscriptionPage {

    private DriverAction action;

    By liteTitleName = By.xpath("(//strong[contains(@id,\"name\")])[1]");
    By liteTitleSelectionButton = By.xpath("(//a[contains(@id,\"selection\")])[1]");

    By classicTitleName = By.xpath("(//strong[contains(@id,\"name\")])[2]");
    By classicTitleSelectionButton = By.xpath("(//a[contains(@id,\"selection\")])[2]");

    By premiumTitleName = By.xpath("(//strong[contains(@id,\"name\")])[3]");
    By premiumTitleSelectionButton = By.xpath("(//a[contains(@id,\"selection\")])[3]");

    By litePrice = By.xpath("(//*[contains(@id,\"currency\")])[1]");
    By classicPrice = By.xpath("(//*[contains(@id,\"currency\")])[2]");
    By premiumPrice = By.xpath("(//*[contains(@id,\"currency\")])[3]");

    By countryLabel = By.id("country-name");

    By languageButton = By.id("translation-btn");


    CountriesModal countriesModal;
    public SubscriptionPage() {
        action = DriverAction.getInstance();
        countriesModal = new CountriesModal();
    }


    public String getLiteTitleName() {
        return action.getText(liteTitleName);
    }

    public String getLiteTitleSelectionButton() {
        return action.getText(liteTitleSelectionButton);
    }

    public String getLitePrice() {
        return action.getText(litePrice);
    }
    public String getClassicPrice() {
        return action.getText(classicPrice);
    }
    public String getPremiumPrice() {
        return action.getText(premiumPrice);
    }

    public String getClassicTitleName() {
        return action.getText(classicTitleName);
    }

    public String getClassicTitleSelectionButton() {
        return action.getText(classicTitleSelectionButton);
    }

    public String getPremiumTitleName() {
        return action.getText(premiumTitleName);
    }

    public String getPremiumTitleSelectionButton() {
        return action.getText(premiumTitleSelectionButton);
    }


    public  void selectCountry()
    {
        action.click(countryLabel);
        countriesModal.selectCountry();
    }

    public void selectLanguage()
    {
        Localization localization = Localization.getInstance();
        String language = localization.getLocale().value;

        if (action.getHref(languageButton).contains("en")&&language.contains("en"))
            action.click(languageButton);
        else if (action.getHref(languageButton).contains("ar")&&language.contains("ar"))
            action.click(languageButton);


    }




}
