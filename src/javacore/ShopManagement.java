package javacore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {

	static List<Categories> listC = new ArrayList<Categories>();
	static List<Product> listD = new ArrayList<Product>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ShopManagement sm = new ShopManagement();
		ShopManagement.readObjectFromFileProd();
		ShopManagement.readObjectFromFileCate();
		sm.showMenu(sc, sm);
	}

	// đọc ghi file
	public static void writeToFileCate(List<Categories> listC) {
		try {
			// B1. Khoi tao doi tuong File
			File file = new File("C:\\Users\\Nam\\eclipse-workspace\\BTL_BKAP\\categories.txt");
			// B2. Khoi tao doi tuong FileOutputStream
			FileOutputStream fos = new FileOutputStream(file);
			// B3. Khoi tao doi tuong ObjectOutputStream
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// B4. Ghi file
			oos.writeObject(listC);
			// B5. Dong doi tuong
			oos.close();
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void readObjectFromFileCate() {
		try {
			// B1. Khoi tao doi tuong file
			File file = new File("C:\\Users\\Nam\\eclipse-workspace\\BTL_BKAP\\categories.txt");
			// B2. Khoi tao doi tuong FileInputStream
			FileInputStream fis = new FileInputStream(file);
			// B3. KHoi tao toi duong ObjectInputStream
			ObjectInputStream ois = new ObjectInputStream(fis);
			// B4. Doc du lieu tu file
			listC = (List<Categories>) ois.readObject();
			// B5. dong
			ois.close();
			fis.close();
			System.out.println("Dữ liệu danh mục đọc được từ file categories.txt: ");
			for (Categories categories : listC) {
				categories.displayData();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void writeToFileProd(List<Product> listD) {
		try {
			// B1. Khoi tao doi tuong File
			File file = new File("C:\\Users\\Nam\\eclipse-workspace\\BTL_BKAP\\products.txt");
			// B2. Khoi tao doi tuong FileOutputStream
			FileOutputStream fos = new FileOutputStream(file);
			// B3. Khoi tao doi tuong ObjectOutputStream
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// B4. Ghi file
			oos.writeObject(listD);
			// B5. Dong doi tuong
			oos.close();
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void readObjectFromFileProd() {
		try {
			// B1. Khoi tao doi tuong file
			File file = new File("C:\\Users\\Nam\\eclipse-workspace\\BTL_BKAP\\products.txt");
			// B2. Khoi tao doi tuong FileInputStream
			FileInputStream fis = new FileInputStream(file);
			// B3. KHoi tao toi duong ObjectInputStream
			ObjectInputStream ois = new ObjectInputStream(fis);
			// B4. Doc du lieu tu file
			listD = (List<Product>) ois.readObject();
			// B5. dong
			ois.close();
			fis.close();
			System.out.println("Dữ liệu sản phẩm đọc được từ file product.txt: ");
			for (Product product : listD) {
				product.displayData();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// Menu
	public void showMenu(Scanner sc, ShopManagement sm) {
		do {
			System.out.println("***********MENU************");
			System.out.println("1. Quản lý danh mục");
			System.out.println("2. Quản lý sản phẩm");
			System.out.println("3. Thoát");
			System.out.print("Sự lựa chọn của bạn: ");
			int n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				sm.showMenuDanhMuc(sc, sm);
				break;
			case 2:
				sm.showMenuSanPham(sc, sm);
				break;
			case 3:
				System.exit(0);
				break;

			default:
				System.err.println("Vui lòng nhập từ 1 đến 3");
				break;
			}
		} while (true);
	}

	public void showMenuDanhMuc(Scanner sc, ShopManagement sm) {
		boolean returnFlag = true;
		do {
			System.out.println("***********QUẢN LÝ DANH MỤC************");
			System.out.println("1. Danh sách danh mục");
			System.out.println("2. Thêm danh mục");
			System.out.println("3. Xoá danh mục");
			System.out.println("4. Tìm kiếm danh mục");
			System.out.println("5. Quay lại");
			System.out.print("Sự lựa chọn của bạn: ");
			int n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				sm.showMenuListDanhMuc(sc, sm);
				break;
			case 2:
				sm.inputListCategories(sc);
				sm.writeToFileCate(listC);
				break;
			case 3:
				sm.deleteCategories(sc);
				sm.writeToFileCate(listC);
				break;
			case 4:
				sm.searchCategoriesByName(sc);
				break;
			case 5:
				returnFlag = false;
				break;
			default:
				System.err.println("Vui lòng nhập từ 1 đến 5");
				break;
			}
		} while (returnFlag);
	}

	public void showMenuListDanhMuc(Scanner sc, ShopManagement sm) {
		boolean returnFlag = true;
		do {
			System.out.println("***********DANH SÁCH DANH MỤC************");
			System.out.println("1. Danh sách cây danh mục");
			System.out.println("2. Thông tin chi tết danh mục");
			System.out.println("3. Quay lại");
			System.out.print("Sự lựa chọn của bạn: ");
			int n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:

				break;
			case 2:
				sm.displayListCategories();
				break;
			case 3:
				returnFlag = false;
				break;
			default:
				System.err.println("Vui lòng nhập từ 1 đến 3");
				break;
			}
		} while (returnFlag);
	}

	public void showMenuSanPham(Scanner sc, ShopManagement sm) {
		boolean returnFlag = true;
		do {
			System.out.println("***********QUẢN LÝ SẢN PHẨM************");
			System.out.println("1. Thêm sản phẩm mới");
			System.out.println("2. Tính lợi nhuận sản phẩm");
			System.out.println("3. Hiển thị thông tin sản phẩm");
			System.out.println("4. Sắp xếp sản phẩm");
			System.out.println("5. Cập nhật thông tin sản phẩm");
			System.out.println("6. Cập nhật trạng thái sản phẩm");
			System.out.println("7. Quay lại");
			System.out.print("Sự lựa chọn của bạn: ");
			int n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				sm.inputListProduct(sc);
				sm.writeToFileProd(listD);
				break;
			case 2:
				sm.calListProfit();
				sm.writeToFileProd(listD);
				break;
			case 3:
				sm.showMenuListSanPham(sc, sm);
				break;
			case 4:
				sm.showMenuSortSanPham(sc, sm);
				break;
			case 5:
				sm.updateProductByProductId(sc);
				sm.writeToFileProd(listD);
				break;
			case 6:
				sm.updateProductStatus(sc);
				sm.writeToFileProd(listD);
				break;
			case 7:
				returnFlag = false;
				break;
			default:
				System.err.println("Vui lòng nhập từ 1 đến 7");
				break;
			}
		} while (returnFlag);
	}

	public void showMenuListSanPham(Scanner sc, ShopManagement sm) {
		boolean returnFlag = true;
		do {
			System.out.println("***********THÔNG TIN SẢN PHẨM************");
			System.out.println("1. Hiển thị sản phẩm theo danh mục");
			System.out.println("2. Hiển thị chi tiết sản phẩm");
			System.out.println("3. Quay lại");
			System.out.print("Sự lựa chọn của bạn: ");
			int n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				sm.displayProductByCatID();
				break;
			case 2:
				sm.displayProductByProductName(sc);
				break;
			case 3:
				returnFlag = false;
				break;
			default:
				System.err.println("Vui lòng nhập từ 1 đến 3");
				break;
			}
		} while (returnFlag);
	}

	public void showMenuSortSanPham(Scanner sc, ShopManagement sm) {
		boolean returnFlag = true;
		do {
			System.out.println("***********SẮP XẾP SẢN PHẨM************");
			System.out.println("1. Sắp xếp sản phẩm theo giá xuất tăng dần");
			System.out.println("2. Sắp xếp sản phẩm theo lợi nhuận giảm dần");
			System.out.println("3. Quay lại");
			System.out.print("Sự lựa chọn của bạn: ");
			int n = Integer.parseInt(sc.nextLine());
			switch (n) {
			case 1:
				sm.sortProductByExPrice();
				sm.writeToFileProd(listD);
				break;
			case 2:
				sm.sortProductByProfit();
				sm.writeToFileProd(listD);
				break;
			case 3:
				returnFlag = false;
				break;
			default:
				System.err.println("Vui lòng nhập từ 1 đến 3");
				break;
			}
		} while (returnFlag);
	}

	// method inputlistCategories
	public void inputListCategories(Scanner sc) {
		System.out.println("Nhập vào số danh mục cần thêm: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			Categories cat = new Categories();
			// Nhập thông tin cho danh mục
			System.out.println("Nhập vào mã danh mục: ");
			do {
				try {
					cat.setCatalogId(Integer.parseInt(sc.nextLine()));
					if (cat.getCatalogId() > 0) {
						// Kiem tra duy nhat
						boolean checkExistId = false;
						for (Categories categories : listC) {
							if (categories.getCatalogId() == cat.getCatalogId()) {
								checkExistId = true;
								break;
							}
						}
						if (checkExistId) {
							System.err.println("Mã danh mục đã tồn tại. Vui lòng nhập lại!");
						} else {
							break;
						}
					} else {
						System.err.println("Mã danh mục phải lớn hơn 0. Vui lòng nhập lại.");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("Mã danh mục phải là số nguyên. Vui lòng nhập lại");
				}
			} while (true);
			cat.inputData();
			listC.add(cat);
		}
	}

	// method displayListCategories
	public void displayListCategories() {
		System.out.println("Thông tin chi tiết các danh mục là: ");
		for (Categories categories : listC) {
			categories.displayData();
		}
	}

	// method deleteCategories
	public void deleteCategories(Scanner sc) {
		System.out.println("Nhập vào mã danh mục cần xoá: ");
		int deleteId = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < listC.size(); i++) {
			if (deleteId == listC.get(i).getCatalogId()) {
				listC.remove(i);
				System.out.println("Xoá thành công");
				break;
			} else {
				System.out.println("Không tìm thấy danh mục cần xoá");
				break;
			}
		}
	}

	// method searchCategoriesByName
	public void searchCategoriesByName(Scanner sc) {
		System.out.println("Nhập vào tên danh mục cần tìm: ");
		String categoriesNameSearch = sc.nextLine();
		boolean check = false;
		for (Categories categories : listC) {
			if (categories.getCatalogName().equals(categoriesNameSearch)) {
				categories.displayData();
				check = true;
			}
		}
		if (!check) {
			System.out.println("Không tìm được tên danh mục như vậy");
		}
	}

	// method inputListProduct
	public void inputListProduct(Scanner sc) {
		System.out.println("Nhập vào số sản phẩm cần điền thông tin: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			Product prod = new Product();
			// Nhap thong tin cho ma thanh pho
			System.out.println("Nhập vào mã sản phẩm: ");
			do {
				prod.setProductID(sc.nextLine());
				if (prod.getProductID().length() == 4) {
					if (prod.getProductID().startsWith("C")) {
						// Kiem tra duy nhat
						boolean checkExistId = false;
						for (Product product : listD) {
							if (prod.getProductID().equals(product.getProductID())) {
								checkExistId = true;
								break;
							}
						}
						if (checkExistId) {
							System.err.println("Mã sản phẩm đã tồn tại. Vui lòng nhập lại!");
						} else {
							break;
						}
					} else {
						System.err.println("Mã sản phẩm phải bắt đầu bằng ký tự C, Vui lòng nhập lại!");
					}
				} else {
					System.err.println("Mã sản phẩm phải bao gồm 4 ký tự, Vui lòng nhập lại!");
				}
			} while (true);

			System.out.println("Nhập vào tên sản phẩm: ");
			do {
				prod.setProductName(sc.nextLine());
				if (prod.getProductName().length() >= 6 && prod.getProductName().length() <= 50) {
					// Kiem tra duy nhat
					boolean checkExistId = false;
					for (Product product : listD) {
						if (prod.getProductName().equals(product.getProductName())) {
							checkExistId = true;
							break;
						}
					}
					if (checkExistId) {
						System.err.println("Tên sản phẩm đã tồn tại. Vui lòng nhập lại!");
					} else {
						break;
					}
				} else {
					System.err.println("Tên sản phẩm phải dài từ 6 đến 50 ký tự");
				}
			} while (true);
			System.out.println("Chọn danh mục sản phẩm của sản phẩm: ");
//			for (int j = 0; j < listC.size(); j++) {
//				prod.setCatalog(listC.get(j));
//				break;
//			}

			do {
				int a = Integer.parseInt(sc.nextLine());
//				Categories cat = new Categories();
//				if (a == listC.ge.getCatalogId()) {
//					for (Categories categories : listC) {
//						prod.setCatalog(cat);
//						break;
//					}
//				} else {
//					
//				}
				for (int j = 0; j < listC.size(); j++) {
					if(a==listC.get(j).getCatalogId()) {
						prod.setCatalog(listC.get(j));
						break;
					}
				}
				break;
			} while (true);
			prod.inputData();
			listD.add(prod);
		}

	}

	// method callistProfit
	public void calListProfit() {
		for (Product product : listD) {
			product.calProfit();
		}
		System.out.println("Đã tính xong lợi nhuận sản phẩm");
	}

	// method displayProductByCatID
	public void displayProductByCatID() {
		/*
		 * Product p = new Product(); for (int i = 0; i < listD.size(); i++) { if
		 * (p.getCatalog() == listC.get(i)) { p.displayData(); } }
		 */
		for (Product product : listD) {
			product.displayData();
		}
	}

	// method displayProductByProductName
	public void displayProductByProductName(Scanner sc) {
		System.out.println("Nhập vào tên sản phẩm cần tìm: ");
		String productNameSearch = sc.nextLine();
		boolean check = false;
		for (Product product : listD) {
			if (product.getProductName().equals(productNameSearch)) {
				product.displayData();
				check = true;
			}
		}
		if (!check) {
			System.out.println("Không tìm được tên sản phẩm như vậy");
		}
	}

	// method sortProductByExPrice
	public void sortProductByExPrice() {
		Collections.sort(listD, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return o1.getProductName().compareTo(o2.getProductName());
			}
		});
		System.out.println("Đã sắp xếp xong sản phẩm theo giá xuất tăng dần");
	}

	// method sortProductByProfit
	public void sortProductByProfit() {
		Collections.sort(listD, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				// TODO Auto-generated method stub
				return o1.getProfit() >= o2.getProfit() ? -1 : 1;
			}
		});
		System.out.println("Đã sắp xếp xong sản phẩm theo lợi nhuận giảm dần");
	}

	// method updateProductStatus
	public void updateProductStatus(Scanner sc) {
		System.out.println("Nhập vào mã sản phẩm cần cập nhập trạng thái: ");
		String productIdUpdate = sc.nextLine();
		for (int i = 0; i < listD.size(); i++) {
			if (productIdUpdate.equals(listD.get(i).getProductID())) {
				if (listD.get(i).isProductStatus() == true) {
					listD.get(i).setProductStatus(false);
					System.out.println("Cập nhật thành công");
					break;
				} else {
					listD.get(i).setProductStatus(true);
					System.out.println("Cập nhật thành công");
					break;
				}
			} else {
				System.out.println("Không tìm thấy mã sản phẩm cần cập nhật");
				break;
			}
		}

	}

	// method updateProductByProductId
	public void updateProductByProductId(Scanner sc) {
		System.out.println("Nhập vào mã sản phẩm cần cập nhập trạng thái: ");
		String productIdUpdate = sc.nextLine();
		for (int i = 0; i < listD.size(); i++) {
			if (productIdUpdate.equals(listD.get(i).getProductID())) {
				String productNameNew;
				String titleNew;
				float importPriceNew;
				float exportPriceNew;
				String descriptionsNew;
				boolean productStatusNew;
				System.out.println("Nhập vào tên sản phẩm mới: ");
				productNameNew = sc.nextLine();
				listD.get(i).setProductName(productNameNew);

				System.out.println("Nhập vào tiêu đề sản phẩm mới: ");
				titleNew = sc.nextLine();
				listD.get(i).setTitle(titleNew);

				System.out.println("Nhập vào giá nhập sản phẩm mới: ");
				importPriceNew = Float.parseFloat(sc.nextLine());
				listD.get(i).setImportPrice(importPriceNew);

				System.out.println("Nhập vào giá xuất sản phẩm mới: ");
				exportPriceNew = Float.parseFloat(sc.nextLine());
				listD.get(i).setExportPrice(exportPriceNew);

				System.out.println("Nhập vào mô tả sản phẩm mới: ");
				descriptionsNew = sc.nextLine();
				listD.get(i).setDescriptions(descriptionsNew);

				System.out.println("Nhập vào trạng thái sản phẩm mới: ");
				productStatusNew = Boolean.parseBoolean(sc.nextLine());
				listD.get(i).setProductStatus(productStatusNew);

				listD.get(i).setProfit(exportPriceNew - importPriceNew);
			}
		}
	}

	// method displayListCategoriesTree
//	public void displayListCategoriesTree() {
//		for (int i = 0; i < listC.size(); i++) {
//			int id0 = 1;
//			if (listC.get(i).getParentId() == 0) {
//				System.out.printf("%d.%s",id0,listC.get(i).getCatalogName());
//				id0++;
//			}
//		}
//	}
}
