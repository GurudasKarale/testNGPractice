package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class GoogleSteps {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Given("I open Google")
    public void openGoogle() {
        WebDriver webDriver = new ChromeDriver();
        driver.set(webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void searchFor(String query) {
        WebDriver webDriver = driver.get();
        WebElement searchBox = webDriver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    @Then("I should see results")
    public void shouldSeeResults() {
        WebDriver webDriver = driver.get();
        boolean isPresent = webDriver.findElements(By.cssSelector("h3")).size() > 0;
        assert isPresent : "No results found!";
        webDriver.quit();
    }

}
