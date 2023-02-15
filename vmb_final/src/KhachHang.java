import java.text.ParseException;

public class KhachHang extends ConNguoi {
	private String idKhachHang;
	private VeMayBay ve;

	public KhachHang() {
		this.ve = new VeMayBay();
	}

	public KhachHang(String hoTen, String email, String soDienThoai, String gioiTinh, NgayThangNam ngaySinh,
			String idKhachHang, VeMayBay ve) {
		super(hoTen, email, soDienThoai, gioiTinh, ngaySinh);
		this.idKhachHang = idKhachHang;
		this.ve = ve;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public VeMayBay getVe() {
		return ve;
	}

	public void setVe(VeMayBay ve) {
		this.ve = ve;
	}

	@Override
	public void nhap() {
		QLChuyenBay cb = new QLChuyenBay();
		boolean check;
		super.nhap();
		do {
			System.out.print("nhap id khach hang: ");
			this.idKhachHang = sc.nextLine();
			check = Check.checkIDKH(idKhachHang);
			if (!check) {
				System.out.println("nhap khong hop le! Vui long nhap lai.");
			}
		} while (!check);
		String tmb, ndi, nden;
		System.out.println("nhap ten may bay muon di[VietNamAirLines/VietJetAir/JetStarAirWay]: ");
		tmb = sc.nextLine();
		System.out.print("nhap noi di: ");
		ndi = sc.nextLine();
		System.out.print("nhap noi den: ");
		nden = sc.nextLine();
		cb.xuatDieuKien(tmb, ndi, nden);
		int op;
		do {
			System.out.print("chon chuyen bay theo STT: ");
			op = Integer.parseInt(sc.nextLine());
			if (QLChuyenBay.getChuyenBay()[op].getSoLuongGheThuong() == 0
					&& QLChuyenBay.getChuyenBay()[op].getSoLuongGheVip() == 0)
				System.out.println("CHUYEN BAY DA HET CHO! VUI LONG CHON CHUYEN BAY KHAC.");
		} while (QLChuyenBay.getChuyenBay()[op].getSoLuongGheThuong() == 0
				&& QLChuyenBay.getChuyenBay()[op].getSoLuongGheVip() == 0);
		this.getVe().setCb(QLChuyenBay.getChuyenBay()[op]);
		int op1;
		do {
			System.out.print("nhap loai ghe [0-thuong / 1-vip]: ");
			op1 = Integer.parseInt(sc.nextLine());
			if (op1 == 0 && QLChuyenBay.getChuyenBay()[op].getSoLuongGheThuong() != 0)
				break;
			else if (op1 == 1 && QLChuyenBay.getChuyenBay()[op].getSoLuongGheVip() != 0)
				break;
			else
				System.out.println("NHAP KHONG HOP LE HOAC CHO NGOI DA HET CHO! VUI LONG CHON LAI!");
		} while (true);
		if (op1 == 0) {
			this.getVe().setLoaiGhe(false);
			int num = QLChuyenBay.getChuyenBay()[op].getSoLuongGheThuong();
			this.getVe().setViTriNgoi(num);
			this.getVe().setPhi(QLChuyenBay.getChuyenBay()[op].giaTien() * 2);
			num--;
			QLChuyenBay.getChuyenBay()[op].setSoLuongGheThuong(num);
		} else {
			this.getVe().setLoaiGhe(true);
			int num = QLChuyenBay.getChuyenBay()[op].getSoLuongGheVip();
			this.getVe().setViTriNgoi(num);
			this.getVe().setPhi(QLChuyenBay.getChuyenBay()[op].giaTien() * 4);
			num--;
			QLChuyenBay.getChuyenBay()[op].setSoLuongGheVip(num);
		}
//        this.getVe().setViTriNgoi(QLChuyenBay.getChuyenBay()[op].getSoLuongGheThuong());
	}

	@Override
	public String toString() {
		String loaiGhe = (!ve.getLoaiGhe()) ? "thuong" : "vip";
		return String.format("%-5s|%-20s|%-11s|%-5s|%-10s|%-20s|%-5s|%-7s|%-6d|%-25f|%-8s",
				idKhachHang, super.getHoTen(), super.getSoDienThoai(), super.getGioiTinh(), super.getNgaySinh(),
				super.getEmail(), ve.getCb().getIdCB(),loaiGhe ,ve.getViTriNgoi(), ve.getPhi(),
				ve.getCb().getThoiGianKhoiHanh()); 
	} 
 
	@Override
	public void xuat() {
		System.out.println();
		System.out.printf("%-5s|%-20s|%-11s|%-5s|%-10s|%-20s|%-5s|%-7s|%-6s|%-25s|%-8s\n","IDKH", "Ho Ten", "SDT",
				"GTinh", "NgaySinh", "Email", "IDCB", "LoaiGhe", "VTNgoi", "Phi", "TimeBay");
		System.out.println(toString());
		System.out.println();
	}

}