import java.io.*;
import java.util.Scanner;

public class QLKhachHang implements ChucNang, DataBase {
	private static double loiNhuan = 0;
	private static KhachHang[] khachHang = new KhachHang[100];
	private static int soLuongKhachHang;

	public QLKhachHang() {
	}

	public static double getLoiNhuan() {
		return loiNhuan;
	}

	public static void setLoiNhuan(double loiNhuan) {
		QLKhachHang.loiNhuan = loiNhuan;
	}

	public static KhachHang[] getKh() {
		return khachHang;
	}

	public static void setKh(KhachHang[] khachHang) {
		QLKhachHang.khachHang = khachHang;
	}

	public static int getSoLuongKhachHang() {
		return soLuongKhachHang;
	}

	public static void setSoLuongKhachHang(int soLuongKhachHang) {
		QLKhachHang.soLuongKhachHang = soLuongKhachHang;
	}

	@Override
	public void thongKeTheoMa(String ma) {
		int i;
		for (i = 0; i < soLuongKhachHang; i++) {
			if ((khachHang[i].getIdKhachHang().equals(ma))) {
				khachHang[i].xuat();
				break;
			}
		}
		if (i == soLuongKhachHang) {
			System.out.println("Khong co thong tin!");
			System.out.println();
		}
	}

	@Override
	public void thongKeTheoTen(String ten) {
		System.out.println();
		int stt = 0;
		System.out.printf("%-3s|%-5s|%-20s|%-11s|%-5s|%-10s|%-20s|%-5s|%-7s|%-6s|%-25s|%-8s\n", "STT", "IDKH", "Ho Ten",
				"SDT", "GTinh", "NgaySinh", "Email", "IDCB", "LoaiGhe", "VTNgoi", "Phi", "TimeBay");
		for (int i = 0; i < soLuongKhachHang; i++)
			if (khachHang[i].getHoTen().contains(ten)) {
				System.out.printf("%-3s|", ++stt);
				System.out.println(khachHang[i]);
			}
		if (stt == 0) {
			System.out.println("Khong co thong tin!");
		}
		System.out.println();
	}

	@Override
	public void sapXep() {
		for (int i = 0; i < soLuongKhachHang - 1; i++) {
			for (int j = i + 1; j < soLuongKhachHang; j++) {
				if (khachHang[i].getHoTen().compareTo(khachHang[j].getHoTen()) > 0) {
					KhachHang temp = new KhachHang();
					temp = khachHang[i];
					khachHang[i] = khachHang[j];
					khachHang[j] = temp;
				}
			}
		}
	}

	// tìm tất cả khách hàng có vé máy bay có mã chuyến bay == ma
	@Override
	public void thongKeChuyenBay(String ma) {
		int stt = 0;
		System.out.println();
		System.out.printf("%-3s|%-5s|%-20s|%-11s|%-5s|%-10s|%-20s|%-5s|%-7s|%-6s|%-25s|%-8s\n", "STT", "IDKH", "Ho Ten",
				"SDT", "GTinh", "NgaySinh", "Email", "IDCB", "LoaiGhe", "VTNgoi", "Phi", "TimeBay");
		for (int i = 0; i < soLuongKhachHang; i++) {
			if (khachHang[i].getVe().getCb().getIdCB().equals(ma)) {
				System.out.printf("%-3d|", ++stt);
				System.out.println(khachHang[i]);
			}
		}
		if (stt == 0) {
			System.out.println("Khong co thong tin!");
		}
		System.out.println();
	}

	@Override
	public void them() {
		KhachHang kh = new KhachHang();
		kh.nhap();
		for (int i = 0; i < soLuongKhachHang; i++) {
			if (khachHang[i].getIdKhachHang().equals(kh.getIdKhachHang())) {
				System.out.println("ID KHACH HANG DA TON TAI!");
				return;
			}
		}
		khachHang[soLuongKhachHang] = new KhachHang();
		khachHang[soLuongKhachHang++] = kh;
		loiNhuan += kh.getVe().getPhi();
	}

	@Override
	public void xoa(String ma) {
		for (int i = 0; i < soLuongKhachHang; i++) {
			if (khachHang[i].getIdKhachHang().equalsIgnoreCase(ma)) {
				if (!khachHang[i].getVe().getLoaiGhe()) {
					QLChuyenBay cb = new QLChuyenBay();
					int num = cb.timChuyenBay(khachHang[i].getVe().getCb().getIdCB()).getSoLuongGheThuong();
					cb.timChuyenBay(khachHang[i].getVe().getCb().getIdCB()).setSoLuongGheThuong(++num);
				} else {
					QLChuyenBay cb = new QLChuyenBay();
					int num = cb.timChuyenBay(khachHang[i].getVe().getCb().getIdCB()).getSoLuongGheVip();
					cb.timChuyenBay(khachHang[i].getVe().getCb().getIdCB()).setSoLuongGheVip(++num);
				}
				for (int j = i; j < soLuongKhachHang - 1; j++)
					khachHang[j] = khachHang[j + 1];
				soLuongKhachHang--;
				System.out.println("XOA THANH CONG!");
				return;
			}
		}
		System.out.println("XOA THAT BAI HOAC KHONG TIM THAY!");
	}

	public boolean checkCot(String cot) {
		cot = cot.trim();
		if (cot.equals("IDKH") || cot.equals("Ho Ten") || cot.equals("SDT") || cot.equals("GTinh")
				|| cot.equals("NgaySinh") || cot.equals("Email") || cot.equals("IDCB") || cot.equals("LoaiGhe")
				|| cot.equals("VTNgoi") || cot.equals("Phi") || cot.equals("TimeBay"))
			return true;
		return false;
	}

	@Override
	public void suaThongTin(String ma) {
		int i = 0;
		for (i = 0; i < soLuongKhachHang; i++) {
			if (khachHang[i].getIdKhachHang().equals(ma)) {
				khachHang[i].xuat();
				break;
			}
		}
		if (i == soLuongKhachHang) {
			System.out.println("Khong tim thay khach hang!");
			return;
		} else {
			Scanner sc = new Scanner(System.in);
			String cot;
			do {
				System.out.print("Nhap cot thong tin muon sua: ");
				cot = sc.nextLine();
				if (!checkCot(cot))
					System.out.println("Nhap sai, moi ban nhap lai: ");
			} while (!checkCot(cot));
			switch (cot) {
			case "IDKH":
				System.out.print("Nhap IDKH moi: ");
				khachHang[i].setIdKhachHang(sc.nextLine());
				break;
			case "Ho Ten":
				System.out.print("Nhap Ho Ten moi: ");
				khachHang[i].setHoTen(sc.nextLine());
				break;
			case "SDT":
				System.out.print("Nhap SDT moi: ");
				khachHang[i].setSoDienThoai(sc.nextLine());
				break;
			case "GTinh":
				System.out.print("Nhap GTinh moi (Nam/Nu): ");
				khachHang[i].setGioiTinh(sc.nextLine());
				;
				break;
			case "NgaySinh":
				NgayThangNam ntn = new NgayThangNam();
				System.out.println("Nhap NgaySinh moi: ");
				ntn.nhap();
				khachHang[i].setNgaySinh(ntn);
				break;
			case "Email":
				System.out.print("Nhap Email moi: ");
				khachHang[i].setEmail(sc.nextLine());
				break;
			case "IDCB":
				ChuyenBay cb = khachHang[i].getVe().getCb();
				System.out.print("Nhap IDCB moi: ");
				cb.setIdCB(sc.nextLine());
				VeMayBay ve = khachHang[i].getVe();
				ve.setCb(cb);
				khachHang[i].setVe(ve);
				break;
			case "LoaiGhe":
				System.out.print("Nhap LoaiGhe moi (true-vip/false-thuong): ");
				ve = khachHang[i].getVe();
				ve.setLoaiGhe(Boolean.parseBoolean(sc.nextLine()));
				khachHang[i].setVe(ve);
				break;
			case "VTNgoi":
				System.out.print("Nhap VTNgoi moi: ");
				ve = khachHang[i].getVe();
				ve.setViTriNgoi(Integer.parseInt(sc.nextLine()));
				khachHang[i].setVe(ve);
				break;
			case "Phi":
				System.out.print("Nhap Phi moi: ");
				ve = khachHang[i].getVe();
				ve.setPhi(Double.parseDouble(sc.nextLine()));
				khachHang[i].setVe(ve);
				break;
			case "TimeBay":
				System.out.println("Nhap TimeBay moi: ");
				ThoiGian time = new ThoiGian();
				time.nhap();
				cb = khachHang[i].getVe().getCb();
				cb.setThoiGianKhoiHanh(time);
				ve = khachHang[i].getVe();
				ve.setCb(cb);
				khachHang[i].setVe(ve);
				break;
			}
		}
	}

	public void sapXepTheoTen() {
		KhachHang t;
		for (int i = 0; i < soLuongKhachHang - 1; i++) {
			for (int j = i + 1; j < soLuongKhachHang; j++) {
				if (khachHang[i].getHoTen().compareTo(khachHang[j].getHoTen()) > 0) {
					t = khachHang[i];
					khachHang[i] = khachHang[j];
					khachHang[j] = t;
				}
			}
		}
		System.out.println("\nSap xep theo ten thanh cong!\n");
	}

	public void sapXepTheoId() {
		KhachHang t;
		for (int i = 0; i < soLuongKhachHang - 1; i++) {
			for (int j = i + 1; j < soLuongKhachHang; j++) {
				if (khachHang[i].getIdKhachHang().compareTo(khachHang[j].getIdKhachHang()) > 0) {
					t = khachHang[i];
					khachHang[i] = khachHang[j];
					khachHang[j] = t;
				}
			}
		}
		System.out.println("\nSap xep theo id thanh cong!\n");
	}

	public void themKKhachHang(int soLuong) {
		for (int i = 0; i < soLuong; i++) {
			them();
		}
	}
	

	@Override
	public void docFile() {
		QLChuyenBay cb = new QLChuyenBay();
		String[] str;
		String[] str1;
		String data;
		try {
			BufferedReader objReader = new BufferedReader(new FileReader("DataBase/KhachHang.txt"));
			while ((data = objReader.readLine()) != null) {
				str = data.split("\\|");
				str1 = str[3].split("/");

				NgayThangNam ntn = new NgayThangNam();
				ntn.setNgay(Integer.parseInt(str1[0]));
				ntn.setThang(Integer.parseInt(str1[1]));
				ntn.setNam(Integer.parseInt(str1[2]));

				VeMayBay ve = new VeMayBay();
				ve.setCb(cb.timChuyenBay(str[6]));
				ve.setViTriNgoi(Integer.parseInt(str[7]));
				ve.setLoaiGhe(Boolean.parseBoolean(str[8]));
				ve.setPhi(Double.parseDouble(str[9]));
				khachHang[soLuongKhachHang++] = new KhachHang(str[1], str[4], str[5], str[2], ntn, str[0], ve);
				loiNhuan += ve.getPhi();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void ghiFile() {
		try {
			FileWriter fr = new FileWriter("DataBase/KhachHang.txt");
			BufferedWriter bw = new BufferedWriter(fr);
			for (int i = 0; i < soLuongKhachHang; i++) {
				bw.write(khachHang[i].getIdKhachHang() + "|" + khachHang[i].getHoTen() + "|"
						+ khachHang[i].getGioiTinh() + "|" + khachHang[i].getNgaySinh().toString() + "|"
						+ khachHang[i].getEmail() + "|" + khachHang[i].getSoDienThoai() + "|"
						+ khachHang[i].getVe().getCb().getIdCB() + "|" + khachHang[i].getVe().getViTriNgoi() + "|"
						+ khachHang[i].getVe().getLoaiGhe() + "|" + khachHang[i].getVe().getPhi());
				bw.newLine();
			}
			bw.close();
			fr.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void xuat() {
		System.out.println();
		System.out.printf("%-3s|%-5s|%-20s|%-11s|%-5s|%-10s|%-20s|%-5s|%-7s|%-6s|%-25s|%-8s\n", "STT", "IDKH", "Ho Ten",
				"SDT", "GTinh", "NgaySinh", "Email", "IDCB", "LoaiGhe", "VTNgoi", "Phi", "TimeBay");
		for (int i = 0; i < soLuongKhachHang; i++) {
			System.out.printf("%-3d|", i + 1);
			System.out.println(khachHang[i]);
		}
		System.out.println();
	}

}
