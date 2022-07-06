package main.com.retirement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import main.com.retirement.util.Constants;

public class PreRetirementCalculatorPage {

	WebDriver driver;
	public PreRetirementCalculatorPage(WebDriver driver) {
		this.driver= driver;
	}

	public void setCurrentAge(String value) {
		sendElementKeys(Constants.ID_CURRENT_AGE, value);
	}
	public void setRetirementAge(String value) {
		sendElementKeys(Constants.ID_RETIREMENT_AGE, value);
	}
	public void setCurrentIncome(String value) {
		setLocatorValue(Constants.ID_CURRENT_INCOME, value);
	}
	public void setSpouseIncome(String value) {
		setLocatorValue(Constants.ID_SPOUSE_INCOME, value);
	}
	public void setcurrentTotalSaving(String value) {
		setLocatorValue(Constants.ID_CURRENT_TOTAL_SAVING, value);
	}
	public void setcurrentAnualSaving(String value) {
		sendElementKeys(Constants.ID_CURRENT_ANNUAL_SAVING, value);
	}
	public void setSavingIncreaseRate(String value) {
		sendElementKeys(Constants.ID_SAVING_INCREASE_RATE , value);
	}
	public void setSocialBenefitStatusNo(String value) {
		setLocatorStatus(Constants.ID_NOBENEFITS , "true");
	}

	public void setSocialBenefitStatusYes(String arg1) {
		setLocatorStatus(Constants.ID_YESBENEFITS, "true");
	}
	public void setMaritalStatus(String arg1) {
		setLocatorStatus(Constants.ID_MARRIED , "true");
	}
	public void setSocialSecutityOveride(String value) {
		setLocatorValue(Constants.ID_SOCIAL_SECURITY_OVERRIDE,value);
	}
	public void setDefaultAdjustment(String value) {
		driver.findElement(By.xpath(value)).click();
	}
	public void setAdditionalIncome(String value) {
		setLocatorValue(Constants.ID_ADDITIONAL_INCOME , value);
	}
	public void setRetirementDuration(String value) {
		sendElementKeys(Constants.ID_RETIREMENT_DURATION, value);
	}
	public void setInflationStatus(String arg1) {
		setLocatorStatus(Constants.ID_INFLATION , "true");
	}
	public void setRetirementAnnualIncome(String value) {
		setLocatorValue(Constants.ID_RETIREMENT_ANNUAL_INCOME , value);
	}
	public void setPreRetirementRoi(String value) {
		setLocatorValue(Constants.ID_PRE_RETIREMENT_ROI, value);
	}
	public void setPostRetirementRoi(String value) {
		setLocatorValue(Constants.ID_POST_RETIREMENT_ROI, value);
	}
	public void setSaveChangesButton(String value) {
		driver.findElement(By.xpath(value)).click();
	}
	//calculate button clicked
	public void setCalculateButton(String value) {
		driver.findElement(By.xpath(value)).click();
	}

	public void setLocatorValue(String locator,String value) {
		WebElement element = driver.findElement(By.id(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].value = " + value, element );
	}

	public void setLocatorStatus(String locator,String status) {
		WebElement element = driver.findElement(By.id(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].checked = " + status, element );
	}

	public void sendElementKeys(String locator,String value) {
		driver.findElement(By.id(locator)).sendKeys(value);
	}


}
