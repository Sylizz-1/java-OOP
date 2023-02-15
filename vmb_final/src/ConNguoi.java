import java.util.Scanner;

public class ConNguoi {
	private String hoTen;
	private String email;
	private String soDienThoai;
	private String gioiTinh;
	private NgayThangNam ngaySinh;
	static Scanner sc = new Scanner(System.in);

	public ConNguoi() {
		this.ngaySinh = new NgayThangNam();
	}

	public ConNguoi(String hoTen, String email, String soDienThoai, String gioiTinh, NgayThangNam ngaySinh) {
		this.hoTen = hoTen;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public NgayThangNam getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(NgayThangNam ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public void nhap() {
		do {
			System.out.println("Nhap ho ten: ");
			this.hoTen = sc.nextLine();
			if (!Check.checkHoTen(this.hoTen)) {
				System.out.println("nhap khong hop le! Vui long nhap lai.");
			}
		} while (!Check.checkHoTen(this.hoTen));

		do {
			System.out.println("Nhap so dien thoai [09....]: ");
			this.soDienThoai = sc.nextLine();
			if (!Check.checkSDT(this.soDienThoai)) {
				System.out.println("nhap khong hop le! Vui long nhap lai.");
			}
		} while (!Check.checkSDT(this.soDienThoai));

		do {
			System.out.println("Nhap gioi tinh [Nam/Nu]: ");
			this.gioiTinh = sc.nextLine();
			if (!this.gioiTinh.equalsIgnoreCase("nam") && !this.gioiTinh.equalsIgnoreCase("nu")) {
				System.out.println("nhap khong hop le! Vui long nhap lai.");
			}
		} while (!this.gioiTinh.equalsIgnoreCase("nam") && !this.gioiTinh.equalsIgnoreCase("nu"));

		do {
			System.out.println("Nhap ngay sinh: ");
			this.ngaySinh.nhap();
			if (!Check.checkNTN(this.ngaySinh)) {
				System.out.println("nhap khong hop le! Vui long nhap lai.");
			}
		} while (!Check.checkNTN(this.ngaySinh));

		do {
			System.out.println("Nhap email: ");
			this.email = sc.nextLine();
			if (!Check.checkEmail(this.email)) {
				System.out.println("nhap khong hop le! Vui long nhap lai.");
			}
		} while (!Check.checkEmail(this.email));
	}

	@Override
	public String toString() {
		return String.format("%-20s|%-11s|%-5s|%-10s|%-20s", hoTen, soDienThoai, gioiTinh, ngaySinh, email);
	}

	public void xuat() {
		System.out.printf("%-20s|%-11s|%-5s|%-10s|%-20s", "Ho Ten", "SDT", "GTinh", "NgaySinh", "Email");
		System.out.print(this.toString());
	}
}
