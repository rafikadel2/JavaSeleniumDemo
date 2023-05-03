package pages;

import helpers.DriverAction;
import helpers.Localization;
import org.openqa.selenium.By;

public class CountriesModal {


    By egyptIcon = By.id("eg");
    By emiratesIcon = By.id("ae");
    By algeriaIcon = By.id("dz");
    By djiboutyIcon = By.id("dj");
    By chadIcon = By.id("td");
    By iraqIcon = By.id("iq");
    By jordantIcon = By.id("jo");
    By lebanonIcon = By.id("lb");
    By moroccoIcon = By.id("ma");
    By tunisiaIcon = By.id("tn");
    By yemenIcon = By.id("ye");
    By omanIcon = By.id("om");
    By palestineIcon = By.id("ps");

    private DriverAction action;

    public CountriesModal() {
        action = DriverAction.getInstance();
    }

    public void selectCountry() {
        Localization localization = Localization.getInstance();
        switch (localization.getCountry()) {
            case EGYPT -> action.click(egyptIcon);
            case UAE -> action.click(emiratesIcon);
            case ALGERIA -> action.click(algeriaIcon);
            case DJIBOUTI -> action.click(djiboutyIcon);
            case CHAD -> action.click(chadIcon);
            case IRAQ -> action.click(iraqIcon);
            case OMAN ->  action.click(omanIcon);
            case YEMEN ->  action.click(yemenIcon);
            case JORDAN -> action.click(jordantIcon);
            case LEBANON -> action.click(lebanonIcon);
            case MOROCCO -> action.click(moroccoIcon);
            case PALESTINE -> action.click(palestineIcon);
            case TUNISIA -> action.click(tunisiaIcon);
        }

    }

}
