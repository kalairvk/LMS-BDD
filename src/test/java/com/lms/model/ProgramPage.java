package com.lms.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lms.utils.DriverProvider;

public class ProgramPage {

	private WebDriver driver;
	private static Logger logger = LogManager.getLogger(ProgramPage.class);

	private By tblHeaderBy = By.xpath("//div[contains(text(),'Manage')]");
	private By tblFooterPaginationBy = By.xpath("//div[contains(@class,'p-paginator-bottom')]/span[1]");
	private By tblFootertextBy = By.xpath("//div[contains(@class,'p-datatable-footer')]/div[1]");
	private By deletebuttonBy = By.xpath("//div/button[contains(@ng-reflect-icon,'pi pi-trash')]");
	private By numberofRecordsBy = By.xpath("//table/tbody/tr");
	private By searchBoxTxtBy = By.xpath("//input[@placeholder='Search...']");
	private By paginationNextBy = By.xpath("//button[contains(@class,'p-paginator-next')]");
	private By paginationFirstBy = By.xpath("//button[contains(@class,'p-paginator-first')]");
	private By paginationPrevBy = By.xpath("//button[contains(@class,'p-paginator-prev')]");
	private By paginationLastBy = By.xpath("//button[contains(@class,'p-paginator-last')]");
	private By deleteBtnBy = By.xpath("//tr[1]//button[contains(@icon,'pi pi-trash')]");
	private By confirmDialogBy = By.xpath("//div[contains(@class,'p-dialog-header')]/span");
	private By successDeletionAlertBy = By.xpath("//div[@role='alert']/div");

	public ProgramPage() {
		this.driver = DriverProvider.getdriver();

	}

	public void loadProgramPage() {
		driver.findElement(By.xpath("//button/span[text()='Program']")).click();
	}

	public String getTableHeader() {
		return driver.findElement(tblHeaderBy).getText();
	}

	public String getTableFooterPaginationText() {
		return driver.findElement(tblFooterPaginationBy).getText();
	}

	public String getTableFooterText() {
		return driver.findElement(tblFootertextBy).getText();

	}

	public boolean isDeleteButtonEnabled() {
		return driver.findElement(deletebuttonBy).isEnabled();
	}

	public int getNumberofRecordsOnTable() {
		return driver.findElements(numberofRecordsBy).size();

	}

	public String verifySearchBox() {
		return driver.findElement(searchBoxTxtBy).getAttribute("placeholder");

	}

	public void search(String keyword) {
		driver.findElement(searchBoxTxtBy).clear();
		driver.findElement(searchBoxTxtBy).sendKeys(keyword);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// var wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tbody/tr"))));
	}

	public boolean allTableRowsContain(String keyword) {
		List<Boolean> rowLevelPresenceList = new ArrayList<>();
		boolean goNext = false;
		do { // check each page of the table
			List<WebElement> tableRows = driver.findElements(By.xpath("//tbody/tr"));
			for (int i = 0; i < tableRows.size(); i++) {
				WebElement row = tableRows.get(i);
				List<WebElement> tableColumn = row.findElements(By.xpath("//td"));
				boolean result = false;
				for (WebElement column : tableColumn) {
					if (column.getText().toLowerCase().contains(keyword.toLowerCase())) {
						result = true;
						break;
					}
				}
				// when any row does not have the keyword it shows error
				if (result == false) {
					logger.error("The row {} does not have the keyword {}", i + 1, keyword);
				}
				rowLevelPresenceList.add(result);
			}
			// Navigate to the next page if its available
			boolean paginationNext = driver.findElement(paginationNextBy).isEnabled();
			goNext = paginationNext;
			if (paginationNext) {
				driver.findElement(paginationNextBy).click();
			}
		} while (goNext);

		// loop the result and return false even if one row did not have the search
		// keyword
		boolean finalResult = true;
		for (boolean v : rowLevelPresenceList) {
			if (v == false) {
				finalResult = false;
				break;
			}
		}
		return finalResult;
	}

	public void sortByColumn(String colName, String order) {
		WebElement th = driver.findElement(By.xpath("//table[@role='grid']//th[contains(text(),'" + colName + "')]"));
		th.click();
		String sortOrder = th.getAttribute("aria-sort");
		if (!order.equalsIgnoreCase(sortOrder)) {
			th.click();
		}
	}

	public List<String> getColumnValues(String colName) {

		// Find the index of passed column
		List<WebElement> tableHeaders = driver.findElements(By.xpath("//table[@role='grid']//th"));
		int columnIndex = 0;
		for (int i = 0; i < tableHeaders.size(); i++) {
			if (tableHeaders.get(i).getText().equals(colName)) {
				columnIndex = i + 1;// In HTML, index starts from 1. So we add 1 here.
				break;
			}
		}

		List<String> result = new ArrayList<>();
		boolean goNext = false;
		do { // check each page of the table
			List<WebElement> tableRows = driver.findElements(By.xpath("//table[@role='grid']//tbody/tr"));
			for (int i = 0; i < tableRows.size(); i++) {
				WebElement row = tableRows.get(i);
				String data = row.findElement(By.xpath("//td[" + columnIndex + "]")).getText();

				result.add(data.strip().toLowerCase());
			}
			// Navigate to the next page if its available
			boolean paginationNext = driver.findElement(paginationNextBy).isEnabled();
			goNext = paginationNext;
			if (paginationNext) {
				driver.findElement(paginationNextBy).click();
			}
		} while (goNext);

		return result;
	}

	public void goToFirstPage() {
		WebElement firstPageLink = driver.findElement(paginationFirstBy);
		if (firstPageLink.isEnabled()) {
			firstPageLink.click();
		}
	}

	public void clickDeleteBtn() {
		driver.findElement(deleteBtnBy).click();
		var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDialogBy));
	}

	public String getConfirmDialog() {

		String confirmHeader = driver.findElement(confirmDialogBy).getText();
		if (confirmHeader.equalsIgnoreCase("Confirm")) {
			logger.info("Confirm Dialog box is present");
		} else {
			logger.info("Confirm Dialog box is not present");
		}
		return confirmHeader;
	}

	public void clickNoBtn(String btnName) {
		driver.findElement(By.xpath("//button[@ng-reflect-label='" + btnName + "']")).click();
		var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'p-dialog-header')]/span")));

	}

	public boolean isConfirmDialogOpen() {
		try {
			driver.findElement(confirmDialogBy);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}
	}

	public void clickYesBtn(String btnName) {
		driver.findElement(By.xpath("//button[@ng-reflect-label='" + btnName + "']")).click();
	}

	public String getSuccessDeletionAlert() {

		return driver.findElement(successDeletionAlertBy).getText();
	}

	public void selectCheckboxes() {
		String checkbox = "//div[@role='checkbox']";
		driver.findElement(By.xpath("//tbody//tr[1]" + checkbox)).click();
		driver.findElement(By.xpath("//tbody//tr[2]" + checkbox)).click();
	}

	public boolean isProgramSelected() {
		String checkbox = "//div[@role='checkbox']";
		String prog1 = driver.findElement(By.xpath("//tbody//tr[1]" + checkbox)).getAttribute("aria-checked");
		String prog2 = driver.findElement(By.xpath("//tbody//tr[2]" + checkbox)).getAttribute("aria-checked");
		return prog1.equals("true") && prog2.equals("true");
	}

	public void clickCommonDeleteOption() {
		driver.findElement(deletebuttonBy).click();
	}

	public boolean isPrevLinkEnabled() {
		return driver.findElement(paginationPrevBy).isEnabled();
	}

	public boolean isNextLinkEnabled() {
		return driver.findElement(paginationNextBy).isEnabled();
	}

	public void goToPage(String pageNo) {
		driver.findElement(By.xpath("//button[text()='" + pageNo + "']")).click();
	}

	public void goToNextPage() {
		WebElement nextPage = driver.findElement(paginationNextBy);
		if (nextPage.isEnabled()) {
			nextPage.click();
		}
	}

	public boolean isInPage(String pageNo) {
		String classes = driver.findElement(By.xpath("//button[text()='" + pageNo + "']")).getAttribute("class");
		return classes.contains("p-highlight");
	}

	public void goToPreviousPage() {
		WebElement prevPage = driver.findElement(paginationPrevBy);
		if (prevPage.isEnabled()) {
			prevPage.click();
		}
	}

	public void goToLastPage() {
		WebElement lastPage = driver.findElement(paginationLastBy);
		if (lastPage.isEnabled()) {
			lastPage.click();
		}
	}

	public boolean isOpen() {
		try {
			return "Manage Program".equals(getTableHeader());
		} catch (Exception e) {
			return false;
		}
	}
}
