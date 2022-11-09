package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pompages.Home;
import pompages.MCOLoginpage;
import pompages.PORTALLoginpage;
import wait.WaitFactory;

public class LoginTest extends BaseClass {

	@Test
	public void mcologintest() {
		
		Home home = new Home(getDriver());
		
		MCOLoginpage loginpg = home.ClickMCOloginlink();
		
		loginpg.Login("shc/shctest", "Letmein@13");
		
		WaitFactory.waitforload(30);
		
	}
	
	@Test
	public void portallogintest() {
		
		Home home = new Home(getDriver());
		
		PORTALLoginpage portalloginpg = home.ClickPORTALloginlink();
		
		portalloginpg.Login("UATpermissiontest@portal.com", "Letmein@4");
		
		WaitFactory.waitforload(30);
		
	}
	
}
