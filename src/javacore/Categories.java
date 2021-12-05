package javacore;

import java.io.Serializable;
import java.util.Scanner;

public class Categories implements ICategories, Serializable {

	// Khai báo biến
	private int catalogId;
	private String catalogName;
	private String descriptions;
	private boolean catalogStatus;
	private int parentId;

	// constructors

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Categories(int catalogId) {
		super();
		this.catalogId = catalogId;
	}


	public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus, int parentId) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.descriptions = descriptions;
		this.catalogStatus = catalogStatus;
		this.parentId = parentId;
	}
	// getter & setter

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public boolean isCatalogStatus() {
		return catalogStatus;
	}

	public void setCatalogStatus(boolean catalogStatus) {
		this.catalogStatus = catalogStatus;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public void inputData() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào tên danh mục: ");
		do {
			this.catalogName = sc.nextLine();
			if (this.catalogName.length() < 6 || this.catalogName.length() > 30) {
				System.err.println("Bạn nhập sai tên danh mục phải gồm từ 6 đến 30 ký tự. Vui lòng nhập lại!");
			} else {
				break;
			}

		} while (true);

		System.out.println("Nhập mô tả danh mục: ");
		do {
			this.descriptions = sc.nextLine();
			if (this.descriptions.length() == 0 || this.descriptions == null) {
				System.err.println("Không được bỏ trống mô tả danh mục. Vui lòng điền vào mô tả danh mục!");
			} else {
				break;
			}

		} while (true);
		System.out.println("Nhập trạng thái danh mục");
		do {
			String str = sc.nextLine();
			if (str.equals("true") || str.equals("false")) {
				this.catalogStatus = Boolean.parseBoolean(str);
				break;
			} else {
				System.err.println("Trạng thái của danh mục chỉ nhận giá trị true hoặc false. Vui lòng nhập lại!");
			}
		} while (true);
		System.out.println("Nhập mã danh mục cha");
		do {
			try {
				this.parentId = Integer.parseInt(sc.nextLine());
				if (this.parentId >= 0 && this.parentId <= 2) {
					break;
				} else {
					System.err.println("Mã danh mục cha phải từ 0 đến 2. Vui lòng nhập lại");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Mã danh mục cha phải là số nguyên. Vui lòng nhập lại!");
			}
		} while (true);

	}

	@Override
	public void displayData() {
		// TODO Auto-generated method stub
		String status;
		if (this.catalogStatus) {
			status = "Hoạt động";
		} else {
			status = "Không hoạt động";
		}
		System.out.printf("Mã danh mục: %d - Tên Danh mục: %s\n",this.catalogId,this.catalogName);
		System.out.printf("Mô tả: %s\n",this.descriptions);
		System.out.printf("Danh mục cha: %d - Trạng thái: %s\n",this.parentId,status);

	}

}
