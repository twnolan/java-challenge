import org.junit.Test;
import pageObjects.HomePage;
import pageObjects.PropertiesPage;

import static org.junit.Assert.assertTrue;

public class SearchAndDropdownSelectionTest extends Base {
  @Test
  public void verifyThatUserIsOnCorrectPropertiesListForCorrectCityA() {
    driver.get("https://www.hostelworld.com/");
    String cityName = "Dublin";

    HomePage homePage = new HomePage(driver);

    homePage.enterCityInSearchBox(cityName);
    homePage.clickOnCitySuggestion();
    homePage.clickLetsGoButton();

    PropertiesPage propertiesPage = new PropertiesPage(driver);

    assertTrue(String.format("Location should contain %s", cityName),
      propertiesPage.getLocationValue().contains(cityName)
    );

    assertTrue("Search results are visible",
      propertiesPage.searchResultsAreVisible()
    );
  }
}
