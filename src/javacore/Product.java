package javacore;

import java.io.Serializable;
import java.util.Scanner;

public class Product implements IProduct, Serializable {

	// Khai báo biến
	private String productID;
	private String productName;
	private String title;
	private float importPrice;
	private float exportPrice;
	private float profit;
	private String descriptions;
	private boolean productStatus;
	private Categories catalog;

	// Constructor

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productID, String productName, String title, float importPrice, float exportPrice,
			float profit, String descriptions, boolean productStatus, Categories catalog) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.title = title;
		this.importPrice = importPrice;
		this.exportPrice = exportPrice;
		this.profit = profit;
		this.descriptions = descriptions;
		this.productStatus = productStatus;
		this.catalog = catalog;
	}

	// Getter && Setter

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(float importPrice) {
		this.importPrice = importPrice;
	}

	public float getExportPrice() {
		return exportPrice;
	}

	public void setExportPrice(float exportPrice) {
		this.exportPrice = exportPrice;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public Categories getCatalog() {
		return catalog;
	}

	public void setCatalog(Categories catalog) {
		this.catalog = catalog;
	}

	@Override
	public void inputData() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào tiêu đề sản phẩm: ");
		do {
			this.title = sc.nextLine();
			if (this.title.length() >= 6 && this.title.length() <= 30) {
				break;
			} else {
				System.err.println("Bạn nhập sai tiêu đề sản phẩm phải gồm từ 6 đến 30 ký tự. Vui lòng nhập lại!");
			}

		} while (true);
		System.out.println("Nhập vào giá nhập sản phẩm: ");
		do {
			try {
				this.importPrice = Float.parseFloat(sc.nextLine());
				if (this.importPrice > 0) {
					break;
				} else {
					System.err.println("Giá nhập của sản phẩm phải lớn hơn 0. Vui lòng nhập lại!");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Giá nhập của sản phẩm phải là 1 số thực. Vui lòng nhập lại!");
			}
		} while (true);
		System.out.println("Nhập vào giá xuất sản phẩm: ");
		do {
			try {
				this.exportPrice = Float.parseFloat(sc.nextLine());
				if (this.exportPrice > (this.importPrice + this.importPrice * MIN_INTEREST_RATE)) {
					break;
				} else {
					System.err.println("Giá xuất của sản phẩm phải lớn hơn 120% giá nhập sản phẩm. Vui lòng nhập lại!");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("Giá xuất của sản phẩm phải là 1 số thực. Vui lòng nhập lại!");
			}
		} while (true);
		System.out.println("Nhập vào mô tả sản phẩm: ");
		do {
			this.descriptions=sc.nextLine();
			if(this.descriptions.length()==0) {
				System.err.println("Không được bỏ trống mô tả sản phẩm. Vui lòng nhập vào mô tả sản phẩn!");
			}else {
				break;
			}
		} while (true);
		System.out.println("Nhập vào trạng thái sản phẩm: ");
		do {
			String str = sc.nextLine();
			if (str.equals("true") || str.equals("false")) {
				this.productStatus = Boolean.parseBoolean(str);
				break;
			} else {
				System.err.println("Trạng thái của sản phẩm chỉ nhận giá trị true hoặc false. Vui lòng nhập lại!");
			}
		} while (true);

	}

	@Override
	public void displayData() {
		// TODO Auto-generated method stub
		String status;
		if (this.productStatus) {
			status = "Hoạt động";
		} else {
			status = "Không hoạt động";
		}
		System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s\t - Tiêu đề: %s\n",this.productID,this.productName,this.title);
		System.out.printf("Giá nhập: %f\t - Giá xuất: %f\t - Lợi nhuận: %f\n",this.importPrice,this.exportPrice,this.profit);
		System.out.printf("Mô tả: %s\n",this.descriptions);
		System.out.printf("Trạng thái: %s\t - Danh mục sản phẩm của sản phẩm: %s\n",status,this.catalog);
	}

	@Override
	public void calProfit() {
		// TODO Auto-generated method stub
		this.profit = this.exportPrice - this.importPrice;

	}

}
