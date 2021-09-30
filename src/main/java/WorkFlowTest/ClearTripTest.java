package WorkFlowTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ClearTripTest {
	WebDriver driver;

	@FindBy(css ="#root > div > div > div.container.w-100p.flex-1 > div > div.col-5.pr-0 > div.mt-2.mb-2.d-block.fs-6 > ul > li.humbger > a > div")
	private WebElement flights;

	@FindBy(css="#root > div > div > div.container.w-100p.flex-1 > div > div.col-13.homeba > div > div.flex.flex-between.flex-middle.px-4.mt-2.mb-4 > label:nth-child(2) > div.flex.flex-start.p-relative.flex-middle > span")
	private WebElement roundTrip;

	@FindBy(css="#root > div > div > div.container.w-100p.flex-1 > div > div.col-13.homeba > div > div.row.pt-3.pb-6.p-relative.px-4 > div.col.flex.flex-middle > div:nth-child(1) > div > div > div.p-relative > input")
	private WebElement from;

	@FindBy(css="#root > div > div > div.container.w-100p.flex-1 > div > div.col-13.homeba > div > div.row.pt-3.pb-6.p-relative.px-4 > div.col.flex.flex-middle > div:nth-child(1) > div > div > div.bg-white.br-4.elevation-5.p-1.p-absolute.mt-1.z-50.l-0 li")
	private List<WebElement> fromList;

	@FindBy(css="#root > div > div > div.container.w-100p.flex-1 > div > div.col-13.homeba > div > div.row.pt-3.pb-6.p-relative.px-4 > div.col.flex.flex-middle > div:nth-child(5) > div > div > div.p-relative > input")
	private WebElement to;

	@FindBy(css="#root > div > div > div.container.w-100p.flex-1 > div > div.col-13.homeba > div > div.row.pt-3.pb-6.p-relative.px-4 > div.col.flex.flex-middle > div:nth-child(5) > div > div > div.bg-white.br-4.elevation-5.p-1.p-absolute.mt-1.z-50.l-0 li")
	private List<WebElement> toList;

	@FindBy( css="#root > div > div > div.container.w-100p.flex-1 > div > div.col-13.homeba > div > div.row.pt-3.pb-6.p-relative.px-4 > div.row.pl-4.pr-4.p-relative > div > div > div > div > button:nth-child(1)")
	private WebElement departOn;

	@FindBy(css="#root > div > div> div.container .DayPicker-Body div div div div")
	private List<WebElement> departAndReturnOnDate;

	@FindBy(css="#root > div > div > div.container.w-100p.flex-1 > div > div.col-13.homeba > div > div.row.pt-3.pb-6.p-relative.px-4 > div.row.pl-4.pr-4.p-relative > div > div > div > div > button:nth-child(3)")
	private WebElement returnOn;

	@FindBy(xpath="//*[@class='DayPicker-Body']/div/div/div//parent::div[@aria-selected='true']")
	private WebElement currentDate;

	@FindBy(css="#root  div.mb-4 > select")
	private WebElement adultDropdown;

	@FindBy(css="#root  div.col.flex.flex-middle > button")
	private WebElement searchFlightButton;

	@FindBy(css="#root > div > main > div > div.row > div.col-5 > div > aside > div.pr-2 > div:nth-child(2) > div:nth-child(2) > div > label:nth-child(1) > div.flex.flex-start.p-relative.flex-middle > span")
	private WebElement nonStopCheckBox;

	@FindBy(xpath="//*[@id='root']/div/main/div/div/div[2]/div[2]/div[12]/div[1]/div[1]/div/div/div/div/div/div/img")
	private List<WebElement> flightFromDepart;

	@FindBy(xpath="//*[@id='root']/div/main/div/div/div[2]/div[2]/div[12]/div[2]/div[1]/div/div/div/div/div/div/img")
	private List<WebElement> flightFromReturn;

	@FindBy(xpath="//*[@id='root']/div/main/div/div/div[2]/div[2]/div[7]/div/div[2]/button")
	private WebElement bookButton;

	@FindBy(xpath="//*[@id='root']/div/div[2]/div/div[1]/main/div[2]/div/div/div[25]/div[1]/button")
	private WebElement continueButton;

	@FindBy(xpath="/html/body/div/div/div/div/div[1]/div[1]/div/button")
	private WebElement selectButton;

	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div/div[1]/main/div[5]/div/div/button")
	private WebElement contiButton;

	@FindBy(xpath="//input[@data-testid='mobileNumber']")
	private WebElement mobileNumber;

	@FindBy(xpath="//input[@data-testid='email']")
	private WebElement email;


	@FindBy(xpath="//*[@id='root']/div/div[2]/div/div[1]/main/div[8]/div/div/div[7]/button")
	private WebElement addContinuBtn;

	@FindBy(xpath="//*[@id='root']//div[2]/div[3]/div[1]/div[1]/input")
	private WebElement firstAdultName;

	@FindBy(xpath="//*[@id='root']//div[3]/div[2]/div[1]/div[1]/input")
	private WebElement secondAdultName;

	@FindBy(xpath="//*[@id='root']//div[3]/div[2]/div[1]/input")
	private WebElement firstAdultLastName;

	@FindBy(xpath="//*[@id='root']//div[3]/div[2]/div[2]/div[1]/input")
	private WebElement secondAdultLastName;


	@FindBy(xpath="//*[@id='root']//div[3]/div[3]/div[1]/div/button")
	private WebElement firstAdultGender;

	@FindBy(xpath="//*[@id='root']//div[3]/div[3]/div/div/div/ul/li[1]")
	private WebElement firstAdultGenderOption;

	@FindBy(xpath="//*[@id='root']//div[2]/div[3]/div[1]/div/button")
	private WebElement secondAdultGender;

	@FindBy(xpath="//*[@id='root']//div[3]/div/div/div/ul/li[1]")
	private WebElement secondAdultGenderOption;

	@FindBy(xpath="//*[@id='root']//div[11]/div/div/div[7]/div/button")
	private WebElement continueToPayment;

	@FindBy(xpath="//*[@id='root']//p[contains(text(),'Net banking')]")
	private WebElement netBanking;

	@FindBy(xpath="//*[@id='root']//div[1]/div[5]/div[2]/div[1]/label/div[1]")
	private WebElement kotak;

	@FindBy(xpath="//*[@id='root']//div[4]/div[3]/div/div[3]/button")
	private WebElement payNowButton;

	Select select;
	WebDriverWait wait ;


	DateFormat dateFormat = new SimpleDateFormat("dd");
	Date date = new Date();
	String day=dateFormat.format(date);
	public ClearTripTest() {
		System.setProperty("webdriver.chrome.driver",".\\lib\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}


	@BeforeTest	
	public void SetUp() {
		driver.get("https://www.cleartrip.com/");
	}


	@Test
	public void Test() {
		wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(flights));
		// Select "Flights" tab
		flights.click();
		wait.until(ExpectedConditions.elementToBeClickable(roundTrip));
		// Search 'Round Trip' flight from Mumbai to Delhi. Depart date is 5 days from today and return date is 6 days from today
		roundTrip.click();
		from.click();
		for(int i=0;i<fromList.size();i++) {
			if(fromList.get(i).getText().equalsIgnoreCase("Mumbai, IN - Chatrapati Shivaji Airport (BOM)")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", fromList.get(i));
				break;
			}
		}
		to.click();
		for(int i=0;i<toList.size();i++) {
			if(toList.get(i).getText().equalsIgnoreCase("New Delhi, IN - Indira Gandhi Airport (DEL)")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", toList.get(i));
				break;
			}
		}
		departOn.click();
		for(int i=0;i<departAndReturnOnDate.size();i++) {
			if(departAndReturnOnDate.get(i).getText().equals(day)){
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", departAndReturnOnDate.get(i+4));
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				if(currentDate.getAttribute("aria-selected").equals("true")) {
					driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
					i=Integer.parseInt(departAndReturnOnDate.get(i+4).getText());
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", departAndReturnOnDate.get(i+1));
					driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				}
				break;
			}
		}

		// Select Adults travelling
		select=new Select(adultDropdown);
		select.selectByVisibleText("2");
		// Click on 'Search'
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchFlightButton);
		wait.until(ExpectedConditions.elementToBeClickable(nonStopCheckBox));
		// Select a non-stop flight
		nonStopCheckBox.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Select the second (Spice Jet / Indigo) from depart
		for(int i=0;i<flightFromDepart.size();i++) {
			if(flightFromDepart.get(i).getAttribute("alt").contentEquals("SpiceJet")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", flightFromDepart.get(i));	
				break;
			}
		}
		//Select the second (Jet Airways / Go Air) from return
		for(int i=0;i<flightFromReturn.size();i++) {
			if(flightFromReturn.get(i).getAttribute("alt").contentEquals("GO FIRST")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", flightFromReturn.get(i));
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Click 'Book'
		bookButton.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		// Click 'Continue Booking'
		driver.switchTo().window(tabs.get(1).toString());
		//Click 'Continue Booking'
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.getWindowHandle();
		selectButton.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		contiButton.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//Enter the details
		mobileNumber.sendKeys("1234567890");
		email.sendKeys("verve@sample.com");
		addContinuBtn.click();
		firstAdultName.sendKeys("Sachin");
		firstAdultLastName.sendKeys("Tendulkar");
		firstAdultGender.click();
		firstAdultGenderOption.click();
		secondAdultName.sendKeys("Virat");
		secondAdultLastName.sendKeys("Sharma");
		secondAdultGender.click();
		secondAdultGenderOption.click();
		// Click on Continue button
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueToPayment);
		wait.until(ExpectedConditions.elementToBeClickable(netBanking));
		//On the Payments page, use net banking and select 'Kotak Bank' and Click 'Payment'
		netBanking.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", kotak);
		payNowButton.click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//Verify Kotak Net Banking page has opened up
		Assert.assertEquals(driver.getTitle(),"Kotak Mahindra Bank - Payment Gateway");
	}


	@AfterTest
	public void AfterTest() {
		driver.close();
		driver.quit();
	}
}
