import org.junit.Test;

public class SanityTest extends Base {
  @Test
  public void verifyPageLoadsToConfirmSeleniumIsWorking() {
    driver.get("https://www.hostelworld.com/");
  }
}
