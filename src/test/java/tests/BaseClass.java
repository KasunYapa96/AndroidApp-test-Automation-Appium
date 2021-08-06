package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		
		File f=new File("src/test/resources/apps");
		File fs=new File(f, "coffee-shop-app-demo_1.0_apkcombo.com (1).apk");
		
		
		DesiredCapabilities cap=new DesiredCapabilities(); //Takes the information in json structure and gives to the server
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_30_x86"); //Emulator name
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());  //App path (apk)
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		
		driver.findElementById("android:id/button1").click();
		
	}
	
	@AfterTest
	public void terminateApp() {
		
		driver.closeApp();

	}
	
	
	
}
