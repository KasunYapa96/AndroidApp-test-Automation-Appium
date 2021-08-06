package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Tests extends BaseClass {

	
	@Test(priority=1)
	public void verifyTitle() {
		
		MobileElement element = (MobileElement) driver.findElementByClassName("android.widget.TextView");
		String ActualTitle = element.getText();
		String ExpectedTitle = "Coffee Shop App";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
			
	}
	
	
	@Test(priority=2)
	public void darkMode() throws InterruptedException {
		
		//https://sqa.stackexchange.com/questions/20186/unable-to-locate-element-throwing-a-org-openqa-selenium-nosuchelementexception-i
		WebDriverWait wait = new WebDriverWait(driver, 100);
		
		Thread.sleep(1000);
		MobileElement element1= (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@index='0']")));
		element1.click();
		
		Thread.sleep(1000);
		MobileElement element2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='Settings']")));
		element2.click();
		
		Thread.sleep(1000);
		MobileElement element3 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Dark Mode']")));
		element3.click();
		
		Thread.sleep(1000);
		MobileElement element4 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='Dark']")));
		element4.click();
		
		Thread.sleep(1000);
		MobileElement element5= (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@index='0']")));
		element1.click();
		
//		MobileElement element1 = (MobileElement)driver.findElementsByXPath("//android.widget.TextView[@text='Snacks']");
//		element1.click();

	}
	
	@Test(priority=3)
	public void buyFoods() throws InterruptedException {
		
		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		
	
		/*
		MobileElement element6= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
				+"new UiSelector().xpath(\"//android.widget.TextView[@text='Chocolate Smoothie']\")));")));
		element6.click();
		
		*/
		
		Thread.sleep(1000);
		MobileElement element6= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
		         ".scrollIntoView(new UiSelector().text(\"Chocolate Smoothie\"))")));
		
		Thread.sleep(1000);
		MobileElement element7= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Chocolate Smoothie']")));
		element7.click();  //Clicks on chocolate smoothie
		
		Thread.sleep(1000);
		MobileElement element8= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@index='2']")));
		
		
		Thread.sleep(1000);
		for(int i=2;i<=5;i++) {
			element8.click();  //Change Quantity to 5
		}
		
		
		Thread.sleep(1000);
		MobileElement element9= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='ADD TO ORDER']")));
		element9.click();  //Add to order
		
		Thread.sleep(1000);
		MobileElement element10= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Snacks']")));
		element10.click();  //Go to "Snacks"
		
		
		
		/*
		MobileElement element11= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().resourceId(\"com.apps.ac.martin.coffeeshopapp:id/search\")).setAsVerticalList()" +
		         ".scrollIntoView(new UiSelector().text(\"android.widget.TextView\"))")));
		
		}
		
		Tried to perform the Scroll up action and ,serch pancakes and couldn't be completed
		
		*/
		
		
		
		Thread.sleep(1000);
		MobileElement element12= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='5 ITEMS']")));
		element12.click();  //Go to the Checkout list 
		
		
		
		/* Here I have verified the total price amount with expected total price amount */
		
		Thread.sleep(1000);
		MobileElement totalPriceElement= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@index='1']")));

		String s1 =totalPriceElement.getText();
		
		String[] words=s1.split("\\s");//splits the string based on whitespace  
		//using java foreach loop to print elements of string array  
	
		String strNewPrice = words[1].replace(",", "");
		System.out.println(strNewPrice);
		
		int price=Integer.parseInt(strNewPrice);
		int expectedPrice=3000;
		System.out.println(price);
		
		Assert.assertEquals(expectedPrice, price,"Prices matches.Test succeeded");
		
		
		
	
		Thread.sleep(1000);
		MobileElement element13= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='CHECKOUT']")));
		element13.click();  //Tap on Checkout
	
		Thread.sleep(1000);
		MobileElement element14= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='While using the app']")));
		element14.click();  //GPS mode
	
		Thread.sleep(1000);
		MobileElement element15= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='PICK LOCATION']")));
		element15.click();  //Tap on PickLocations
		
		Thread.sleep(1000);
		MobileElement element16= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@text='Name, This field is required']")));
		element16.sendKeys("Kasun"); //Name
		
		MobileElement elementscroll2= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
		         ".scrollIntoView(new UiSelector().text(\"CONFIRM ORDER\"))")));
		
		Thread.sleep(1000);
		MobileElement element17= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@text='Id number (will be used for confirmation on delivery), This field is required']")));
		element17.sendKeys("962730760v"); //ID
		
		Thread.sleep(1000);
		MobileElement element18= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@text='Phone, This field is required']")));
		element18.sendKeys("0779673458"); //Phone
		
		MobileElement element19= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RadioButton[@text='Cash']")));
		element19.click();  //Radio btn Payment method to Cash
		
		Thread.sleep(1000);
		MobileElement element20= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='CONFIRM ORDER']")));
		element20.click();  //Confirm order
		
		Thread.sleep(1000);
		MobileElement element21= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='BACK TO HOME PAGE']")));
		element21.click();  //Continue to homepage back
		
		
		
		
		/*
		MobileElement elementscroll3= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
		         ".scrollIntoView(new UiSelector().text(\"Snacks\"))")));
		
		MobileElement element22= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@index='0']")));
		element22.click();
		
		MobileElement element23= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.CheckedTextView[@text='Orders']")));
		element23.click();
		
		MobileElement element24= (MobileElement) wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='View details']")));
		element24.click();
		
		*/
		
		Thread.sleep(3000);
		
		
}
	
	
}
