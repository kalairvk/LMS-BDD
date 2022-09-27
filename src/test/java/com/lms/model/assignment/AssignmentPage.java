package com.lms.model.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.lms.utils.DriverProvider;


public class AssignmentPage  {

	WebDriver driver;
	//XLUtility xLUtility;
	
	public AssignmentPage() {
		this.driver=DriverProvider.getdriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//span[text()='Assignment']") WebElement assignmentHeader;
	@FindBy(how=How.XPATH, using="//div[contains(text(), ' Manage Assignment')]") WebElement manageAssmnt;
	@FindBy(how=How.XPATH, using="//span[contains(text(), 'Showing 1 to')]") WebElement noOfEntries;
	@FindBy(how=How.XPATH, using="//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']") WebElement totalNumEntries;
	@FindBy(how=How.XPATH, using="//input[@placeholder='Search...']") WebElement searchText;
	@FindBy(how=How.XPATH, using="//input[@class='p-inputtext p-component p-filled']") WebElement txtInSrcBox;
	@FindBy(how=How.XPATH, using="//input[@type='text']") WebElement srcBox;
	@FindBy(how=How.XPATH, using="//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]") WebElement singleCheckBox;
	@FindBy(how=How.XPATH, using="//div[@class='p-checkbox-box p-component']") List<WebElement>checkboxList;
	@FindBy(how=How.XPATH, using="//span[@class='p-button-icon pi pi-pencil'][1]") WebElement editButton;
	@FindBy(how=How.XPATH, using="//span[text()='Assigment Details']") WebElement assignmentDetails;
	@FindBy(how=How.XPATH, using="//input[@id='assignment']") WebElement assnmntNameField;
	@FindBy(how=How.XPATH, using="//input[@id='assignmentDescription']") WebElement assnmntDesField;
	@FindBy(how=How.XPATH, using="//input[@id='assignmentGraderId']") WebElement assnmntGradeField;
	@FindBy(how=How.XPATH, using="//input[@id='icon']") WebElement dueDateField;
	@FindBy(how=How.XPATH, using="//span[text()='Save']") WebElement saveButton;
	@FindBy(how=How.XPATH, using="//span[text()='Cancel']") WebElement cancelButton;
	@FindBy(how=How.XPATH, using="//div[@role='alert']//div//div[2]") WebElement createdMsg;
	@FindBy(how=How.XPATH, using="//div[@role='alert']//div//div[2]") WebElement updatedMsg;
	@FindBy(how=How.XPATH, using="//tbody/tr[1]/td[6]/div[1]/span[2]/button[1]") WebElement deleteButton;
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Confirm')]") WebElement confirmEle;
	@FindBy(how=How.XPATH, using="//span[contains(text(), 'Yes')]") WebElement yesButton;
	@FindBy(how=How.XPATH, using="//span[contains(text(), 'Yes')]") WebElement noButton;
	@FindBy(how=How.XPATH, using="//div[@role='alert']//div//div[2]") WebElement deletedMsg;
	@FindBy(how=How.XPATH, using="//span[contains(text(), 'A New')]") WebElement newAssnmntEle;
	@FindBy(how=How.XPATH, using="//tbody/tr/td[1]")	List<WebElement>checkList;
	@FindBy(how=How.XPATH, using="//tbody/tr/td[2]")	List<WebElement>assnNameList;
	@FindBy(how=How.XPATH, using="//small[contains(text(),'Name is required.')]") WebElement nameRequiredEle;
	@FindBy(how=How.XPATH, using="//p-tableheadercheckbox/div[1]/div[2]") WebElement multipleAssnBtn;
	@FindBy(how=How.XPATH, using="//thead/tr[1]/th[2]") WebElement ascDescOrderArrowForName;
	@FindBy(how=How.XPATH, using="//thead/tr[1]/th[3]") WebElement ascDescOrderArrowForDesc;


	
	public void clickAssignmentHeader() {
		assignmentHeader.click();
	}
	
	public boolean verifyManageAssn() {
		return manageAssmnt.isDisplayed();
	}
	
	public String getTextofNumEntries() {
		String text=noOfEntries.getText();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	return text;
	}
	
	public String getTextofTotalNumOfEntries() {
		String totalTxt= totalNumEntries.getAttribute("innerHTML");
		System.out.println(totalTxt);
		return totalTxt;
	}
	
	public boolean verifySearchText() {
		return searchText.isDisplayed();	
	}
	
	public void insertTextInSearch(String txt) {
	srcBox.sendKeys(txt);
	}
	
	public boolean verifyTxtInSearch() {
	return txtInSrcBox.isDisplayed();
	}
	
	public void clickCheckBox() throws InterruptedException{
		if(singleCheckBox.isDisplayed())	{
		singleCheckBox.click();
	}
		Thread.sleep(3000);
	}
	
	
	public boolean verifyCheckboxSelected() throws InterruptedException {
		String classAttr=singleCheckBox.getAttribute("class");
		
		if (classAttr.contains("p-checkbox-box p-component p-highlight")) {
			return true;
		}
		return false;
	}	
	
	public void clickEditBtn() {
		editButton.click();
	}
	
	public boolean verifyAssnDetailsForm() {
		return assignmentDetails.isDisplayed();
	}
	

	public String verifyAssnNameValue() {
		String actualName=assnmntNameField.getAttribute("value");
		return actualName;	
	}
	
	public String verifyAssnDescValue() {
		String actualDesc=assnmntDesField.getAttribute("value");
		return actualDesc;	
	}
	
	public String verifyAssnGradeValue() {
		String actualGrade=assnmntGradeField.getAttribute("value");
		return actualGrade;	
	}
	
	public String verifyAssnDuedate() throws InterruptedException {
		String actualDate=dueDateField.getAttribute("value");
		Thread.sleep(2000);
		return actualDate;	
	}
	
	public void clickSaveBtn() throws InterruptedException {
		saveButton.click();
		Thread.sleep(2000);
	}
	
	public void clickDeleteBtn() throws InterruptedException {
		deleteButton.click();
		Thread.sleep(3000);
	}
	
	public String verifyUpdatedMsg() {
		return updatedMsg.getText();
	}
		
	String beofreXpath="//tbody/tr[";
	String afterXpath="]/td[1]";
	
	
	public void clickMultipleAssnChkbox() {
	//	checkList=driver.findElements(By.xpath("//tbody/tr/td[1]"));
			for(int i=1; i<=checkList.size(); i++) {
			driver.findElement(By.xpath(beofreXpath+i+afterXpath)).click();
		}
	}
	
		public boolean verifyMultiCheckboxSelected() {
		//	checkList=driver.findElements(By.xpath("//tbody/tr/td[1]"));
			for(int i=1; i<=checkList.size(); i++) {
				String attribute=driver.findElement(By.xpath(beofreXpath+i+afterXpath)).getAttribute("class");
				
				if (attribute.contains("p-checkbox-box p-component p-highlight")) {
					return true;
			}
		}	
			return false;
	}
	
		public void clickNewAssnBtn() {
			newAssnmntEle.click();
		}

		public String getNameReqMsg() {
		return nameRequiredEle.getText();
		}
		
		String insertedName;
		public void enterAssnName(String name) throws InterruptedException {
			assnmntNameField.clear();
			insertedName=name;
			assnmntNameField.sendKeys(insertedName);
			Thread.sleep(2000);
		}
		
		public void enterAssnDescription(String desc) {
			assnmntDesField.clear();
			assnmntDesField.sendKeys(desc);
		}
		
		public void enterAssnGrade(String grd) {
			assnmntGradeField.clear();
			assnmntGradeField.sendKeys(grd);
		}
		
		public void enterAssnDueDate(String dd) {
			dueDateField.click();
			String s=Keys.chord(Keys.CONTROL, "a");
			dueDateField.sendKeys(s);
			dueDateField.sendKeys(Keys.DELETE);
			dueDateField.sendKeys(dd);
		}
	
		public String verifyCreatedMsg() {
			return createdMsg.getText();
		}
		
		public void clickCancel() {
			cancelButton.click();
		}
		
		
		//tbody/tr[1]/td[2]
		String beforeXPath1="//tbody/tr[";
		String afterXpath1="]/td[2]";
		
		//tbody/tr[1]/td[6]/div[1]/span[2]/button[1]
		String beforeXPath2="//tbody/tr[";
		String afterXPath2="]/td[6]/div[1]/span[2]/button[1]";
		
		public void clickDeleteAssignment() throws InterruptedException {
		int size=assnNameList.size();
		for(int i=1; i<=size; i++) {
			String newName=driver.findElement(By.xpath(beforeXPath1+i+afterXpath1)).getText();
			
									
			if(newName.contains("Sql")) {
				driver.findElement(By.xpath(beforeXPath2+i+afterXPath2)).click();
				Thread.sleep(2000);
				break;	
		}
		}
		}
		
		public boolean verifyConfirmDeletionForm() {
			return confirmEle.isDisplayed();
		}
		
		 public void clickYesBtn() {
			 yesButton.click();
		 }
		
		 public void clickNoBtn() {
			 noButton.click();
		 }
		 
		 public String verifyDeletedMsg() {
			 return deletedMsg.getText();
		 }
		 
		 public void clickAscDescArrowForName() {
			 ascDescOrderArrowForName.click();
		 }
		 
		 public void clickAscDescArrowForDesc() {
			 ascDescOrderArrowForDesc.click();
		 }
		 
		 
}
