package com.pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseUtilities;

public class Parcel extends BaseUtilities {

	public Parcel() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Onboard')]")
	private WebElement onBoard;
	@FindBy(id = "Type")
	private WebElement type;
	@FindBy(xpath = "//span[contains(text(),'Basic Info')]")
	private WebElement basicInfo;
	@FindBy(xpath = "//input[@id='ImageFile']")
	private WebElement chooseFile;
	@FindBy(id = "TotalNoOfFloors")
	private WebElement totalNoOfFloors;
	@FindBy(id = "TotalNoOfUnits")
	private WebElement totalNoOfUnits;
	@FindBy(id = "ParcelName")
	private WebElement parcel;
	@FindBy(id = "UniqueBuildingId")
	private WebElement parcelId;
	@FindBy(id = "Description")
	private WebElement description;
	@FindBy(id = "Latitude")
	private WebElement latitude;
	@FindBy(id = "Longitude")
	private WebElement longitude;
	@FindBy(id = "Zone")
	private WebElement zone;
	@FindBy(id = "AreaType")
	private WebElement areaType;
	@FindBy(xpath = "//span[contains(text(),\"Save\")]")
	private WebElement saveParcel;
	@FindBy(xpath = "//button[@class='btn btn-primary btn-lg float-end mb-4 ng-tns-c243-1']")
	private WebElement addDocumentCategory;
	@FindBy(xpath = "//input[@placeholder=\"Category Name\"]")
	private WebElement categoryName;
	@FindBy(xpath = "//button[@id=\"continue\"]")
	private WebElement saveCategoryName;
	@FindBy(xpath = "//span[contains(text(),\"KAFD Parcel Documents\")]")
	private WebElement kafdParcelDocuments;
	@FindBy(xpath = "(//div[@class='col'])[2]")
	private WebElement popupParcelSuccess;

	public WebElement getTotalNoOfFloors() {
		return totalNoOfFloors;
	}

	public WebElement getTotalNoOfUnits() {
		return totalNoOfUnits;
	}

	public WebElement getPopupParcelSuccess() {
		return popupParcelSuccess;
	}

	public WebElement getParcel() {
		return parcel;
	}

	public WebElement getLatitude() {
		return latitude;
	}

	public WebElement getLongitude() {
		return longitude;
	}

	public WebElement getZone() {
		return zone;
	}

	public WebElement getAreaType() {
		return areaType;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getParcelId() {
		return parcelId;
	}

	public WebElement getSaveParcel() {
		return saveParcel;
	}

	public WebElement getOnBoard() {
		return onBoard;
	}

	public WebElement getBasicInfo() {
		return basicInfo;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getChooseFile() {
		return chooseFile;
	}

	public WebElement getAddDocumentCategory() {
		return addDocumentCategory;
	}

	public WebElement getCategoryName() {
		return categoryName;
	}

	public WebElement getSaveCategoryName() {
		return saveCategoryName;
	}

	public WebElement getKafdParcelDocuments() {
		return kafdParcelDocuments;
	}

}
