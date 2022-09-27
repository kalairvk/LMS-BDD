package com.lms.model.program;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lms.utils.DriverProvider;

public class ProgramEditor {

	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(ProgramEditor.class);

	private By editButtonBy = By.xpath("//tr[1]//button[contains(@icon,'pi pi-pencil')]");
	private By programdetailsDialogBy = By.xpath("//div/span[text()='Program Details']");
	//private By addNewProgramBy = By.id("new");
	private By successAlertBy = By.xpath("//div[@role='alert']");
	//private By successAlertCloseBy = By.xpath("//div[@role='alert']//button");
	private By errorMsgBy = By.xpath("//small");

	public ProgramEditor() {
		this.driver = DriverProvider.getdriver();

	}

	public void clickEditBtn() {
		driver.findElement(editButtonBy).click();
		var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']/div[1]")));

	}

	public String getProgramDetailsDialogHeader() {
		String dialogHeader = driver.findElement(programdetailsDialogBy).getText();
		if (dialogHeader.equalsIgnoreCase("Program Details")) {
			logger.info("Program Details Modal Dialog box is present");
			logger.info(dialogHeader);
		} else {
			logger.info("Program Details Modal Dialog box is not present");
		}
		return dialogHeader;
	}

	public boolean isDialogOpen() {
		try {
			driver.findElement(By.xpath("//div[@role='dialog']"));
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}
	}

	public void setfield(String fieldName, String value) {
		// driver.findElement(By.id(fieldName)).click();
		driver.findElement(By.id(fieldName)).clear();
		driver.findElement(By.id(fieldName)).sendKeys(value);
	}

	public String checkUpdatedProgramName() {
		return driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
	}

	public String checkUpdatedProgramDesc() {
		// driver.findElement(programDescBy).clear();
		// driver.findElement(programDescBy).sendKeys(progDesc);
		return driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
	}

	public String checkUpdatedStatus() {
		String updatedStatus = driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
		return updatedStatus;
	}

	public void clickCancel(String btnName) {
		driver.findElement(By.xpath("//button[@label='" + btnName + "']")).click();
		var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='dialog']/div[1]")));
	}

	public void clickSave(String btnName) {
		driver.findElement(By.xpath("//button[@label='" + btnName + "']")).click();
	}

	public String getSuccessAlertMsg() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg = driver.findElement(successAlertBy).getText();
		//driver.findElement(successAlertCloseBy).click();
		return msg;

	}

	public void addNewProgram(String addBtn) {
		driver.findElement(By.xpath("//button[@label='" + addBtn + "']")).click();
		var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']/div[1]")));
	}

	public String getErrorMsgUnderNameField() {
		return driver.findElement(errorMsgBy).getText();
	}

	public void selectStatus(String status) {
		driver.findElement(By.xpath("//p-radiobutton[@ng-reflect-input-id='" + status + "']")).click();
	}

	public String checkPrognameEntered() {
		return driver.findElement(By.id("programName")).getAttribute("ng-reflect-model");
	}

	public String checkProgdescEntered() {
		return driver.findElement(By.id("programDescription")).getAttribute("ng-reflect-model");
	}

	public String checkStatusSelected() {
		return driver.findElement(By.id("Inactive")).getAttribute("value");
	}

	public void open() {
		if (!isDialogOpen()) {
			addNewProgram("A New Program");
		}

	}

}
