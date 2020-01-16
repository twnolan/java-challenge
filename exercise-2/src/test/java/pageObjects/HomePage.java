package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObjectBase {
  public HomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id="home-search-keywords")
  private WebElement searchBox;


  @FindBy(className="submit-search-form")
  private WebElement letsGoButton;

  @FindBy(className="suggestions")
  private WebElement suggestionsDropdown;

  @FindBy(className="hover")
  private WebElement citySuggestion;

  public void enterCityInSearchBox(String city) {
    this.searchBox.clear();
    this.searchBox.sendKeys(city);
  }

  public void clickLetsGoButton() {
    this.letsGoButton.click();
  }

  public void clickOnCitySuggestion() {
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(suggestionsDropdown));
    this.citySuggestion.click();
  }
}
