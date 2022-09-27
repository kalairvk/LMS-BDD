package com.lms.model.batch;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lms.utils.DriverProvider;

public class BatchPage {

	WebDriver driver;
	WebDriverWait wait;
	public static int batchDetailsPage =0;
	public static int checkBoxSelected =0;
	public static String batchNameChkBox1;
	public static int newBatchDetailsPage =0;
	

	/*---- Login-------------*/

	@FindBy (id = "username")WebElement user;
	@FindBy (id = "password")WebElement pass;
	@FindBy (id = "login")WebElement lmsLogin;
	
	/*---- Login Ends-------------*/
	
	@FindBy (xpath = "//span[text()='Batch']")
	WebElement batchTab;
	
	@FindBy (xpath = "//span[text()='Program']")
	WebElement programTab;
	
	@FindBy (xpath = "//div[text()=' Manage Program']")
	WebElement manageProgramHeading;
	
	@FindBy (xpath = "//div[text()=' Manage Batch']")
	WebElement manageBatchHeading;
	
	@FindBy (xpath = "//div[@class='signin-content']//button")
	WebElement deleteButton;
	
	@FindBy (xpath = "//tbody") List<WebElement> tableBody;
	@FindBy (xpath = "//tbody/tr")List<WebElement> tableRowElements;
	
	@FindBy (xpath = "//input[@placeholder='Search...']")
	WebElement search;
	
	@FindBy (xpath = "//tbody/tr/td[2]")
	WebElement FirstbatchNameElement;
	
	@FindBy (xpath = "//tbody//button[1]")
	WebElement editButton;
	
	@FindBy (xpath = "//span[text()='Batch Details']")
	WebElement batchDetailsHeading;
	
	@FindBy (id= "batchName")
	WebElement batchNameE;
	
	@FindBy (id= "batchDescription")
	WebElement batchDescription;
	
	
	@FindBy (xpath = "//button[@label='Save']")
	WebElement saveButton;
	
	@FindBy (xpath = "//tbody/tr/td[3]")
	WebElement tdDescription;
	
	@FindBy (xpath = "//tbody/tr/td[6]")
	WebElement tdProgramName;
	
	@FindBy (xpath = "//input[@placeholder='Select a Program name']")WebElement programName;
	
	@FindBy (xpath = "//div[@role='button']/span")WebElement programNameDropDown;
	
	@FindBy (xpath = "//span[text()='TestPrograme23']")WebElement programNameSelect;
	
	@FindBy (xpath = "//tbody/tr/td[4]")WebElement tdBatchStatus;
	
	@FindBy (xpath = "//p-radiobutton[@ng-reflect-input-id='ACTIVE']/div")WebElement radioBtnActive;
	@FindBy (xpath = "//p-radiobutton[@ng-reflect-input-id='INACTIVE']/div")WebElement radioBtnInActive;
	@FindBy (xpath = "//tbody/tr/td[5]")WebElement tdNoOfClasses;
	
	@FindBy (id= "batchNoOfClasses")WebElement batchNoOfClasses;
	@FindBy (xpath = "//button[@label='Cancel']")WebElement cancelBtn;
	@FindBy (xpath = "//tbody/tr[1]//div[@role='checkbox']")WebElement tableChkBox1;
	@FindBy (xpath = "//tbody/tr[2]//div[@role='checkbox']")WebElement tableChkBox2;
	
	@FindBy (xpath = "//div[@class='signin-content']//button")WebElement deleteBtnCmn;
	@FindBy (xpath = "//span[text()='Confirm']")WebElement dialogBoxDelete;
	@FindBy (xpath = "//span[text()='Yes']")WebElement dialogBoxYes;
	@FindBy (xpath = "//span[text()='No']")WebElement dialogBoxNo;
	@FindBy (xpath = "//div[@role='alert']")WebElement successBatch;
	
	
	@FindBy (xpath = "//tr[1]//div[@class='action']/span[2]/button")WebElement DeleteRow;
	@FindBy (xpath = "//span[text()='A New Batch']") WebElement newbatchElement;
	@FindBy (xpath = "//small[text()='Name is required.']")WebElement nameReqMsg;
	
	@FindBy (xpath = "//button[contains(@class,'p-paginator-first')]")WebElement paginatorFirst;
	@FindBy (xpath = "//button[contains(@class,'p-paginator-prev')]")WebElement paginatorPrev;
	@FindBy (xpath = "//button[contains(@class,'p-paginator-last')]")WebElement paginatorLast;
	@FindBy (xpath = "//button[contains(@class,'p-paginator-next')]")WebElement paginatorNext;
	
	
	
	
	public BatchPage(){
		
		this.driver = DriverProvider.getdriver();
		wait = new WebDriverWait(this.driver,Duration.ofSeconds(3));
		PageFactory.initElements(driver, this);
	}
	
	/*---- Login-------------*/

	public void login() throws InterruptedException {
		user.sendKeys("aaa");
		pass.sendKeys("bbbb");
		lmsLogin.click();
		wait.until(ExpectedConditions.visibilityOf(manageProgramHeading));
		
	}
	/*---- Login Ends-------------*/
	

	public void navigateToBatchPage()
	{
		System.out.println("*********** In navigateToBatchPage");
		//wait.until(ExpectedConditions.visibilityOf(manageProgramHeading));
		System.out.println("*********** In navigateToBatchPage"+driver.getCurrentUrl());
		if(driver.getCurrentUrl().equals("https://lms-frontend-phase2.herokuapp.com/"))
		{
		batchTab.click();
		System.out.println("*********** In navigateToBatchPage after Batch click ");
		wait.until(ExpectedConditions.visibilityOf(manageBatchHeading));
		System.out.println("*********** In navigateToBatchPage after wait over for manageBatchHeading ");
		}
	}
	
	public String verifyHeading()
	{
		String heading = manageBatchHeading.getText();
		return heading;
	}
	    
	public boolean deleteButtonStatus()
	{
		boolean status = deleteButton.isEnabled();
		return status;
	}
	
	public boolean isTableEmpty()
	{
		boolean status = tableBody.isEmpty();
		return status;
	}
	   
	public int numberOfRows()
	{
		programTab.click();
		wait.until(ExpectedConditions.visibilityOf(batchTab));
		batchTab.click();
		wait.until(ExpectedConditions.visibilityOf(programTab));
		int no_of_rows = tableRowElements.size();
		return no_of_rows;
	}
	
	public void search(String data)
	{
		search.clear();
		System.out.println("data :"+data);
		if(data!=null)
		search.sendKeys(data,Keys.ENTER);
	}
	public void searchClear()
	{
		search.clear();
		programTab.click();
		wait.until(ExpectedConditions.visibilityOf(batchTab));
		batchTab.click();
		wait.until(ExpectedConditions.visibilityOf(programTab));
	}
	
	public String verifyBatchName() {
		
		List<WebElement> tableRow =  driver.findElements(By.xpath("//tbody/tr"));
		String batchNameAct;
		if(tableRow.isEmpty())
		{
			batchNameAct = null;
			search.clear();
			programTab.click();
			wait.until(ExpectedConditions.visibilityOf(batchTab));
			batchTab.click();
			wait.until(ExpectedConditions.visibilityOf(programTab));
		}
		else {
			batchNameAct =FirstbatchNameElement.getText();
			search.clear();
			try {
				Thread.sleep(2000);
				} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				}
		}
		return batchNameAct;
	}
	
	public void editButtonClick()
	{
		//if(!(batchDetailsHeading.getText()=="Batch Details"))
		
			//wait.until(ExpectedConditions.visibilityOf(manageBatchHeading));
		if(batchDetailsPage==0)
		{
			System.out.println("*************editButtonClick");
			if(!isTableEmpty())
			{
				System.out.println("*************editButtonClick Table not empty");
				List<WebElement> tableRow =  driver.findElements(By.xpath("//tbody/tr"));
			editButton.click();
			batchDetailsPage = 1;
			}
		}
					
	}
	
	public String VerifybatchDetailsHeading()
	{
		String heading;
		if(!isTableEmpty())
		{
			wait.until(ExpectedConditions.visibilityOf(batchDetailsHeading));
			heading = batchDetailsHeading.getText();
			//cancelBtn.click();
			//wait.until(ExpectedConditions.invisibilityOf(batchDetailsHeading));
		}
		else
		{
			
			heading = null;
		}
		return heading;
	}
	public void editBatchName() throws InterruptedException
	{
		batchNameE.clear();
		batchNameE.sendKeys("Rose");
	}
	
	public boolean verifyEditedBatchName()
	{
		String batchName;
		if(batchNameE.isDisplayed())
		{
			batchName = batchNameE.getAttribute("ng-reflect-model");
			System.out.println("***************"+batchName);
			if(batchName.equals("Rose"))
				return true;
			else
				return false;
		}
		else 
			return false;
	}
	
	 //s7
	public void editBatchDescription() {
		//wait.until(ExpectedConditions.visibilityOf(batchDescription));
		batchDescription.clear();
		batchDescription.sendKeys("Program batch");
	}
	
	public boolean VerifyEditedBatchDescription()
	{
		String batchDesc;
		if(batchDescription.isDisplayed())
		{
			batchDesc = batchDescription.getAttribute("ng-reflect-model");
			if(batchDesc.equals("Program batch"))
				return true;
			else
				return false;
		}
		else 
			return false;
	}
	
	// s8
	
	public void editProgramName() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(programName));
		programName.clear();
		programName.sendKeys("SDET23");
	}
	
	public boolean VerifyEditedProgramName()
	{
		String pgmName;
		if(programName.isDisplayed())
		{
			pgmName = programName.getText();
			if(pgmName.equals("SDET23"))
				return true;
			else
				return false;
		}
		else 
			return false;
	}
	
	//s9
	
	public void changeStatus()
	{
		radioBtnInActive.click();
	}
	public boolean getBatchStatus()
	{
		boolean status= false;
		if(radioBtnInActive.isDisplayed())
		{
			System.out.println("*********getBatchStatus");
			status = radioBtnInActive.isEnabled();
		}
		return status;
	}
	
	//s10
	public void editNoOfClasses() {
		batchNoOfClasses.clear();
		batchNoOfClasses.sendKeys("35");
	}
	
	public boolean VerifyEditedNoOfClasses()
	{
		String noOfClasses;
		if(batchNoOfClasses.isDisplayed())
		{
			noOfClasses = batchNoOfClasses.getAttribute("ng-reflect-model");
			System.out.println("***********Noof classes :"+noOfClasses);
			if(noOfClasses.equals("35"))
				return true;
			else
				return false;
		}
		else 
			return false; 
	}
	
	//s11
	
	
	public List<String> cancelBatchDetails()
	{
		List<String> batchDetails = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOf(manageBatchHeading));
		String batchName = batchNameE.getAttribute("ng-reflect-model");
		String batStatus = "INACTIVE";
		String description = batchDescription.getAttribute("ng-reflect-model");
		String NoOfClasses = batchNoOfClasses.getAttribute("ng-reflect-model");
		String PgmName = programName.getText();
		
		batchDetails.add(batchName);
		batchDetails.add(batStatus);
		batchDetails.add(description);
		batchDetails.add(NoOfClasses);
		batchDetails.add(PgmName);
		cancelBtn.click();
		batchDetailsPage = 0;
		return batchDetails;
	}
	
	
	
	public List<String> getBatchDetails()
	{
		List<String> batchDetails = new ArrayList<String>();
		String batchName = FirstbatchNameElement.getText();
		String batStatus = tdBatchStatus.getText();
		String description = tdDescription.getText();
		String NoOfClasses = tdNoOfClasses.getText();
		String PgmName = tdProgramName.getText();
		batchDetails.add(batchName);
		batchDetails.add(batStatus);
		batchDetails.add(description);
		batchDetails.add(NoOfClasses);
		batchDetails.add(PgmName);
		return batchDetails;
	}
	
	//s12
	
	public List<String> saveBatchDetails() throws InterruptedException
	{
		editBatchName();
		editBatchDescription();
		editProgramName();	
		changeStatus();
		editNoOfClasses();
		List<String> batchDetails = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOf(manageBatchHeading));
		String batchName = batchNameE.getAttribute("ng-reflect-model");
		String batStatus = "INACTIVE";
		String description = batchDescription.getAttribute("ng-reflect-model");
		String NoOfClasses = batchNoOfClasses.getAttribute("ng-reflect-model");
		String PgmName = programName.getText();
		batchDetails.add(batchName);
		batchDetails.add(batStatus);
		batchDetails.add(description);
		batchDetails.add(NoOfClasses);
		batchDetails.add(PgmName);
		saveButton.click();
		//wait.until(ExpectedConditions.invisibilityOf(saveButton));
		batchDetailsPage = 0;
		return batchDetails;
	}
	
	
	
	//s14
	public String selectMultipleCheckBox()
	{
		if(checkBoxSelected==0)
		{
			if(tableChkBox1.isDisplayed())
			{
				tableChkBox1.click();
				batchNameChkBox1 = FirstbatchNameElement.getText();
				checkBoxSelected = 1;
			}
			if(tableChkBox2.isDisplayed())
			{
				tableChkBox2.click();
				checkBoxSelected = 2;
			}
			return batchNameChkBox1;
		}
		return null;
	}
	
	public boolean verifySelectMultipleBatches()
	{
		if(!isTableEmpty())
		{
			if((tableChkBox1.getAttribute("aria-checked").equals("true"))&&(tableChkBox1.getAttribute("aria-checked").equals("true")))
			{
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	//s15
	public void clickDeleteCmnBtn() {
		if(deleteBtnCmn.isEnabled())
		{
			System.out.println("*************Delete is enabled");
			deleteBtnCmn.click();
			
		}
	}
	
	public boolean VerifyConfirmDeleteAlert ()
	{
		boolean status;
		String text;
		
		wait.until(ExpectedConditions.visibilityOf(dialogBoxDelete));
		text = dialogBoxDelete.getText();
		System.out.println("******VerifyConfirmDeleteAlert"+text);
		if(text.equals("Confirm"))
			return true;
		else
			return false;
	}
	public void confirmWithYes()
	{
		if(dialogBoxYes.isDisplayed())
		{
			dialogBoxYes.click();
			checkBoxSelected=0;
			//wait.until(ExpectedConditions.invisibilityOf(dialogBoxYes));
		}
	}
	public boolean successMsg()
	{
		wait.until(ExpectedConditions.visibilityOf(successBatch));
		String msg = successBatch.getText();
		System.out.println("Success Msg :"+ msg);
		//wait.until(ExpectedConditions.invisibilityOf(successBatch));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(msg.contains("Successful"))
			return true;
		else
			return false;
	}
	
	public boolean verifyDeletedBatchNames()
	{
		if(isTableEmpty())
		{
			return true;
		}
		else
		{
			if((FirstbatchNameElement.getText()).equals(batchNameChkBox1))
			{
				return true;
			}
			else
				return false;
		}
	}
	
	public void cancelConfirmPopup()
	{
		if(dialogBoxNo.isDisplayed())
		{
			dialogBoxNo.click();
			checkBoxSelected=0;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isDleteAlertOpen() {
		if(dialogBoxNo.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean verifyCheckboxEnabled()
	{
		if (tableChkBox1.isEnabled() && tableChkBox2.isEnabled())
		{
			return true;
		}
		else
			return false;
	}
	
	public void uncheckChkBox()
	{
		if (tableChkBox1.isEnabled())
		{
			tableChkBox1.click();
		}
		if(tableChkBox2.isEnabled())
			tableChkBox2.click();
	}
	//s19
	
	public String clickDeleteBtnOfAnyBatch()
	{
		System.out.println("*************clickDeleteBtnOfAnyBatch");
		wait.until(ExpectedConditions.visibilityOf(FirstbatchNameElement));
		String text = FirstbatchNameElement.getText();
		
		wait.until(ExpectedConditions.elementToBeClickable(DeleteRow));
		DeleteRow.click();
		return text;
	}
	
	public boolean verifyBatchNotDeleted(String data)
	{
		if(data.equals(FirstbatchNameElement.getText()))
		{
			
			return true;
		}
		else
			return false;
	}
	
	public void clickNewBatch()
	{
		if(newBatchDetailsPage==0)
		{
			//wait.until(ExpectedConditions.elementToBeClickable(newbatchElement));
			newbatchElement.click();
			newBatchDetailsPage =1;
		}
	}
	
	//24
	
	public void saveNewBatchDetails()
	{
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
		newBatchDetailsPage = 0;
	}
	
	public boolean nameRquiredMessage(String data)
	{
		wait.until(ExpectedConditions.visibilityOf(nameReqMsg));
		String msg = nameReqMsg.getText();
		if(msg.equals(data))
			return true;
		else
			return false;
	}
	//33
	public void firstPageOfManageBatch()
	{
		wait.until(ExpectedConditions.visibilityOf(paginatorFirst));
		if(paginatorFirst.isEnabled())
		{
			paginatorFirst .click();
		}
	}
	public boolean isPreviousLinkDisabled()
	{
		System.out.println("paginatorLeft Enabled : "+paginatorPrev.isEnabled());
		if(paginatorPrev.isEnabled())
			return false;
		else
			return true;
		
	}
	
	//s34
	public void goToPage(String pageNo)
	{
		driver.findElement(By.xpath("//button[text()='" + pageNo + "']")).click();
	}
	
	public void goToNextPage()
	{
		if(paginatorNext.isEnabled())
		paginatorNext.click();
	}
	
	public boolean isInNavigatedPage(String pageNo)
	{
		String classeName = driver.findElement(By.xpath("//button[text()='" + pageNo + "']")).getAttribute("class");
		 if(classeName.contains("p-highlight"))
			 return true;
		 else
			 return false;
	}
	
	public void goToPrevPage()
	{
		if(paginatorPrev.isEnabled())
			paginatorPrev.click();
	}
	
	public void lastPageOfManageBatch()
	{
		wait.until(ExpectedConditions.visibilityOf(paginatorLast));
		if(paginatorLast.isEnabled())
		{
			paginatorLast .click();
		}
	}
	public boolean isNextLinkDisabled()
	{
		System.out.println("paginatorLeft Enabled : "+paginatorPrev.isEnabled());
		if(paginatorNext.isEnabled())
			return false;
		else
			return true;
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

		List<WebElement> tableHeaders = driver.findElements(By.xpath("//table[@role='grid']//th"));
		int columnIndex = 0;
		for (int i = 0; i < tableHeaders.size(); i++) {
			if (tableHeaders.get(i).getText().equals(colName)) {
				columnIndex = i + 1;
				break;
			}
		}

		List<String> result = new ArrayList<>();
		boolean goNext = false;
		do { 
			for (int i = 0; i < tableRowElements.size(); i++) {
				WebElement row = tableRowElements.get(i);
				String data = row.findElement(By.xpath("//td[" + columnIndex + "]")).getText();

				result.add(data.strip().toLowerCase());
			}
			boolean paginationNext = paginatorNext.isEnabled();
			goNext = paginationNext;
			if (paginationNext) {
				paginatorNext.click();
			}
		} while (goNext);

		return result;
	}
	
}