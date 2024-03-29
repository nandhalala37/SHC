package driverutilities;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import constants.ConfigurationValues;
import fileReaders.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Alphi-Nandhalala
 *
 */
public class DriverFactory {

	private static WebDriver driver;
	/**
	 * set driver instance value
	 * @return
	 * @throws Exception
	 */
	public static WebDriver getDriver() throws Exception {
		
		String browser = ConfigurationReader.get(ConfigurationValues.browser);
		if(Objects.isNull(browser)) {
			throw new Exception("Invalid browser name");
		}
		else {
			if(browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(DriverOptions.getChromeoptions());
				System.out.println(Objects.nonNull(driver));
			}else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(DriverOptions.getEdgeoptions());
			}else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(DriverOptions.getFirefoxoptions());
			}
		}
		driver.manage().window().maximize();
		System.out.println(Objects.nonNull(driver));
		return driver;
	}
	
}
