package main.com.retirement.test;
import org.testng.annotations.Test;
import main.com.retirement.pages.PreRetirementCalculatorPage;
import main.com.retirement.util.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public class PreRetirementCalculatorTest {
	
    WebDriver driver;
	PreRetirementCalculatorPage obj = new PreRetirementCalculatorPage(driver);

	@BeforeClass
	public void testSetup() {
		System.setProperty(Constants.CHROME_DRIVER,Constants.CHROME_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void openBrowser() {
		driver.get(Constants.TEST_URL);
		
	}

    /**
	 * This method calculates without social benefits and no default adjustment
	 **/
	@Test(priority = 0)
	public void formSubmissionWithoutSocialBenefitsNoAdjustments() {
		obj.setCurrentAge(Constants.CURRENT_AGE);
		obj.setRetirementAge(Constants.RETIREMENT_AGE);
		obj.setCurrentIncome(Constants.CURRENT_INCOME);
		obj.setSpouseIncome(Constants.SPOUSE_INCOME);
		obj.setcurrentTotalSaving(Constants.CURRENT_TOTAL_SAVINGS);
		obj.setcurrentAnualSaving(Constants.PERCENTAGE_CURRENT_SAVINGS);
		obj.setSavingIncreaseRate(Constants.PERCENTAGE_INCREASE_RATE);
		//No Social benefits selected
		obj.setSocialBenefitStatusNo("true");
		//Calculate button clicked
		obj.setCalculateButton(Constants.XPATH_CALCULATE_BUTTON);
		}

	/**
	 * This method calculates with social benefits and no default adjustment
	 **/
	@Test(priority = 1)
	public void formSubmissionWithSocialBenefitsNoAdjustments() {
		obj.setCurrentAge(Constants.CURRENT_AGE);
		obj.setRetirementAge(Constants.RETIREMENT_AGE);
		obj.setCurrentIncome(Constants.CURRENT_INCOME);
		obj.setSpouseIncome(Constants.SPOUSE_INCOME);
		obj.setcurrentTotalSaving(Constants.CURRENT_TOTAL_SAVINGS);
		obj.setcurrentAnualSaving(Constants.PERCENTAGE_CURRENT_SAVINGS);
		obj.setSavingIncreaseRate(Constants.PERCENTAGE_INCREASE_RATE);
		//Selected Social benefits
		obj.setSocialBenefitStatusYes("true");
		obj.setMaritalStatus("true");
		obj.setSocialSecutityOveride(Constants.OVERRIDE_AMOUNT);
		//Clicked the calculate button without default adjustment
		obj.setCalculateButton(Constants.XPATH_CALCULATE_BUTTON);
	}
	
	/**
	 * This method calculates with social benefits and default adjustment
	 **/
	@Test(priority = 2)
	public void formSubmissionWithSocialBenefitsAndAdjustments() {
		obj.setCurrentAge(Constants.CURRENT_AGE);
		obj.setRetirementAge(Constants.RETIREMENT_AGE);
		obj.setCurrentIncome(Constants.CURRENT_INCOME);
		obj.setSpouseIncome(Constants.SPOUSE_INCOME);
		obj.setcurrentTotalSaving(Constants.CURRENT_TOTAL_SAVINGS);
		obj.setcurrentAnualSaving(Constants.PERCENTAGE_CURRENT_SAVINGS);
		obj.setSavingIncreaseRate(Constants.PERCENTAGE_INCREASE_RATE);
		//Selected Social benefits
		obj.setSocialBenefitStatusYes("true");
		obj.setMaritalStatus("true");
		obj.setSocialSecutityOveride(Constants.OVERRIDE_AMOUNT);
		//Clicked on default adjustment
		obj.setDefaultAdjustment(Constants.XPATH_DEFAULT_ADJUSTMENT_LINK);
		System.out.println(" default adjustment link clicked!");
		obj.setAdditionalIncome(Constants.ADDITIONAL_INCOME);
		obj.setRetirementDuration(Constants.RETIREMENT_DURATION);
		obj.setInflationStatus("true");
		obj.setRetirementAnnualIncome( Constants.RETIREMENT_ANNUAL_INCOME);
		obj.setPreRetirementRoi(Constants.PRE_RETIREMENT_ROI);
		obj.setPostRetirementRoi(Constants.POST_RETIREMENT_ROI);
		//Clicked on save changes
		obj.setSaveChangesButton(Constants.XPATH_SAVE_CHANGES_BUTTON);
	    //Clicked the calculate button with default adjustment
		obj.setCalculateButton(Constants.XPATH_CALCULATE_BUTTON);
		}

	@AfterMethod
	public void postSubmission() {
		
		System.out.println("Form submission successful!");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}

}


