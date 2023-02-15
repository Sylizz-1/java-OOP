import java.text.ParseException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		QLKhachHang kh = new QLKhachHang();
		QLChuyenBay cb = new QLChuyenBay();
		cb.docFile();
		kh.docFile();
		int op;
		String str;
		do {
			System.out.println("1. Quan ly khach hang.");
			System.out.println("2. Quan ly chuyen bay.");
			System.out.println("nhan '69' de thoat.");
			System.out.print("chon: ");
			op = Integer.parseInt(sc.nextLine());
			switch (op) {
			case 1:
				do {
					System.out.println("1. Them 1 khach hang.");
					System.out.println("2. Xoa khach hang bang ID Khach Hang.");
					System.out.println("3. Thong ke khach hang theo id.");
					System.out.println("4. Thong ke gan dung khach hang theo ten.");
					System.out.println("5. Thong ke khach hang theo chuyen bay.");
					System.out.println("6. Xuat tat ca khach hang.");
					System.out.println("7. Tong loi nhuan.");
					System.out.println("8. Sua thong tin khach hang bang ID khach hang.");
					System.out.println("9. Sap xep khach hang theo id khach hang.");
					System.out.println("10. Sap xep khach hang theo ten khach hang.");
					System.out.println("11. Them k khach hang.");
					System.out.println("12. Ghi danh sach khach hang vao file.");
					System.out.println("13. Doc danh sach khach hang tu file.");
					System.out.println("Nhap '68' de thoat.");
					System.out.print("chon: ");
					op = Integer.parseInt(sc.nextLine());
					switch (op) {
					case 1:
						kh.them();
						break;
					case 2:
						System.out.print("nhap id khach hang muon xoa: ");
						str = sc.nextLine();
						kh.xoa(str);
						break;
					case 3:
						System.out.print("nhap chinh xac id muon thong ke: ");
						str = sc.nextLine();
						kh.thongKeTheoMa(str);
						break;
					case 4:
						System.out.print("nhap gan dung ho ten muon thong ke: ");
						str = sc.nextLine();
						kh.thongKeTheoTen(str);
						break;
					case 5:
						System.out.print("nhap chinh xac id chuyen bay muon thong ke: ");
						str = sc.nextLine();
						kh.thongKeChuyenBay(str);
						break;
					case 6:
						kh.xuat();
						break;
					case 7:
						System.out.println("Tong loi nhuan: " + QLKhachHang.getLoiNhuan());
						break;
					case 8:
						System.out.print("Nhap chinh xac ID khach hang muon sua: ");
						str = sc.nextLine();
						kh.suaThongTin(str);
						break;
					case 9:
						kh.sapXepTheoId();
						break;
					case 10:
						kh.sapXepTheoTen();
						break;
					case 11:
						System.out.print("Nhap so luong khach hang muon them: ");
						int sl = Integer.parseInt(sc.nextLine());
						kh.themKKhachHang(sl);
						break;
					case 12:
						kh.ghiFile();
						System.out.println("Ghi file thanh cong!");
						break;
					case 13:
						kh.docFile();
						System.out.println("Doc file thanh cong!");
						break;
					case 68:
						System.out.println("DA THOAT!");
						break;
					default:
						System.out.println("NHAP KHONG HOP LE!");
						break;
					}
				} while (op != 68);
				break;
			case 2:
				do {
					System.out.println("1. Them 1 chuyen bay.");
					System.out.println("2. Xoa chuyen bay theo id chuyen bay.");
					System.out.println("3. Thong ke chuyen bay theo ID may bay.");
					System.out.println("4. Thong ke gan dung chuyen bay theo ten may bay.");
					System.out.println("5. Thong ke tinh hinh chuyen bay hien tai.");
					System.out.println("6. Xuat tat ca chuyen bay");
					System.out.println("7. Sua thong tin chuyen bay theo ID chuyen bay.");
					System.out.println("8. Them k chuyen bay.");
					System.out.println("9. Sap xep chuyen bay giam theo gia.");
					System.out.println("10. Sap xep chuyen bay theo id chuyen bay.");
					System.out.println("11. Doc file.");
					System.out.println("12. Ghi file.");
					System.out.println("Nhap '67' de thoat.");
					System.out.print("chon: ");
					op = Integer.parseInt(sc.nextLine());
					switch (op) {
					case 1:
						cb.them();
						break;
					case 2:
						System.out.print("Nhap id chuyen bay muon xoa: ");
						str = sc.nextLine();
						cb.xoa(str);
						break;
					case 3:
						System.out.print("Nhap id may bay muon thong ke (nhap id gan dung hoac id dung): ");
						str = sc.nextLine();
						cb.thongKeTheoMa(str);
						break;
					case 4:
						System.out.print(
								"nhap ten hang may bay muon thong ke[VietNamAirLines/VietJetAir/JetStarAirWay]: ");
						str = sc.nextLine();
						cb.thongKeTheoTen(str);
						break;
					case 5:
						cb.thongKeChuyenBay("TINH HINH CHUYEN BAY HIEN TAI:");
						break;
					case 6:
						cb.xuat();
						break;
					case 7:
						System.out.print("Nhap chinh xac id chuyen bay muon sua: ");
						str = sc.nextLine();
						cb.suaThongTin(str);
						break;
					case 8:
						int soLuong;
						System.out.print("Nhap so luong chuyen bay muon them: ");
						soLuong = Integer.parseInt(sc.nextLine());
						for (int i = 0; i < soLuong; i++) {
							System.out.println("==== Nhap thong tin chuyen bay thu " + (i + 1) + " ====");
							cb.them();
						}
						break;
					case 9:
						cb.sapXepChuyenBayGiamTheoGia();
						break;
					case 10:
						cb.sapXepChuyenBayTheoIDChuyenBay();
						break;
					case 11:
						cb.docFile();
						System.out.println("Doc file thanh cong!");
						break;
					case 12:
						cb.ghiFile();
						System.out.println("Ghi file thanh cong!");
						break;
					case 67:
						System.out.println("DA THOAT!");
						break;
					default:
						System.out.println("NHAP KHONG HOP LE!");
						break;
					}
				} while (op != 67);
				break;
			case 69:
				System.out.println("DA THOAT!");
				break;
			default:
				System.out.println("NHAP KHONG HOP LE!");
				break;
			}
		} while ((op != 69));
		kh.ghiFile();
		cb.ghiFile();
	}
}
