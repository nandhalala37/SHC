package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverUtilities.DriverActions;
import objectRepository.common_OR;

public class MCO837Page {

	@FindBy(xpath = common_OR.link_MCOHOME)
	private WebElement home;
	
	private WebDriver driver;
	
	public MCO837Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public MCOHomepage return_home() {
		DriverActions.Click(home, common_OR.home_elementname);
		return new MCOHomepage(driver);
	}
	
}