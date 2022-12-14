package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverUtilities.DriverActions;
import objectRepository.common_OR;
import wait.WaitFactory;

public class MCOCOBPage {

	@FindBy(xpath = common_OR.link_MCOHOME)
	private WebElement home;
	
	@FindBy(xpath = common_OR.Loading)
	private WebElement Loading;
	
	private WebDriver driver;
	
	public MCOCOBPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public MCOHomepage return_home() {
		DriverActions.Click(home, common_OR.home_elementname);
		if(Loading.isDisplayed())
			WaitFactory.waitforloading();
		return new MCOHomepage(driver);
	}
	
}