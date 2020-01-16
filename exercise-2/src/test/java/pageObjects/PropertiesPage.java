package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertiesPage extends PageObjectBase {
  public PropertiesPage(WebDriver driver) {
    super(driver);
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(searchResultsContainer));
  }

  @FindBy(className="location-field")
  private WebElement locationField;

  @FindBy(className = "hwta-property-list")
  private WebElement propertyList;



  @FindBy(id = "fabResultsContainer")
  private WebElement searchResultsContainer;

  public String getLocationValue() {
    return locationField.getAttribute("value");
  }

  public boolean searchResultsAreVisible() {
    return propertyList.isDisplayed() && searchResultsContainer.isDisplayed();
  }
}
