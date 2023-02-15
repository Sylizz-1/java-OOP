import java.io.*;
import java.util.Scanner;

public class QLChuyenBay implements ChucNang, DataBase {
	static Scanner sc = new Scanner(System.in);
	private static ChuyenBay[] chuyenBay = new ChuyenBay[100];
	private static int soLuongCB = 0;

	public QLChuyenBay() {
	}

	public static ChuyenBay[] getChuyenBay() {
		return chuyenBay;
	}

	public static void setChuyenBay(ChuyenBay[] chuyenBay) {
		QLChuyenBay.chuyenBay = chuyenBay;
	}

	public static int getSoLuongCB() {
		return soLuongCB;
	}

	public static void setSoLuongCB(int soLuongCB) {
		QLChuyenBay.soLuongCB = soLuongCB;
	}

	public void xuat() {
		System.out.printf("\t\t\t\t\t\t==================%s=====================\n", "DANH SACH CHUYEN BAY");
		System.out.printf(
				"%-3s|%-6s|%-10s|%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|%-10s|%-10s|%-10s|%-10s|%-20s|%-8s\n",
				"STT", "ID", "DIEMDI", "DIEMDEN", "SANBAYDI", "SANBAYDEN", "THOIGIANKHOIHANH", "THOIGIANHACANH",
				"NGAYKHOIHANH", "NGAYVE", "GHETHUONG", "GHEVIP", "IDMAYBAY", "TENMAYBAY", "GIA");
		for (int i = 0; i < soLuongCB; i++) {
			System.out.printf(
					"%-3d|%-6s|%-10s|%-10s|%-15s|%-15s|%-16s|%-15s|%-15s|%-10s|%-10d|%-10d|%-10s|%-20s|%-8.2f\n",
					i, chuyenBay[i].getIdCB(), chuyenBay[i].getDiemDi(), chuyenBay[i].getDiemDen(),
					chuyenBay[i].getSanBayDi(), chuyenBay[i].getSanBayDen(),
					chuyenBay[i].getThoiGianKhoiHanh(), chuyenBay[i].getThoiGianHaCanh(),
					chuyenBay[i].getNgayKhoiHanh(), chuyenBay[i].getNgayVe(),
					chuyenBay[i].getSoLuongGheThuong(), chuyenBay[i].getSoLuongGheVip(),
					chuyenBay[i].getMayBay().getIdMayBay(), chuyenBay[i].getMayBay().getTenMayBay(),
					chuyenBay[i].getMayBay().giaTien());
		}
		System.out.println();
	}

	public void xuatDieuKien(String tenMB, String noiDi, String noiDen) {
		int i;
		for (i = 0; i < soLuongCB; ++i) {
			if (chuyenBay[i].getMayBay().getTenMayBay().contains(tenMB)
					&& (chuyenBay[i].getDiemDi().contains(noiDi) && chuyenBay[i].getDiemDen().contains(noiDen)))
				break;
		}
		if (i < soLuongCB) {
			System.out.printf("\t\t\t\t\t\t==================%s=====================\n", "DANH SACH CHUYEN BAY");
			System.out.printf(
					"%-3s|%-6s|%-10s|%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|%-10s|%-10s|%-10s|%-10s|%-20s|%-8s\n",
					"STT", "ID", "DIEMDI", "DIEMDEN", "SANBAYDI", "SANBAYDEN", "THOIGIANKHOIHANH", "THOIGIANHACANH",
					"NGAYKHOIHANH", "NGAYVE", "GHETHUONG", "GHEVIP", "IDMAYBAY", "TENMAYBAY", "GIA");
			for (i = 0; i < soLuongCB; ++i) {
				if (chuyenBay[i].getMayBay().getTenMayBay().contains(tenMB)
						&& (chuyenBay[i].getDiemDi().contains(noiDi) && chuyenBay[i].getDiemDen().contains(noiDen)))
					System.out.printf(
							"%-3d|%-6s|%-10s|%-10s|%-15s|%-15s|%-16s|%-15s|%-15s|%-10s|%-10d|%-10d|%-10s|%-20s|%-8.2f\n",
							i, chuyenBay[i].getIdCB(), chuyenBay[i].getDiemDi(), chuyenBay[i].getDiemDen(),
							chuyenBay[i].getSanBayDi(), chuyenBay[i].getSanBayDen(),
							chuyenBay[i].getThoiGianKhoiHanh(), chuyenBay[i].getThoiGianHaCanh(),
							chuyenBay[i].getNgayKhoiHanh(), chuyenBay[i].getNgayVe(),
							chuyenBay[i].getSoLuongGheThuong(), chuyenBay[i].getSoLuongGheVip(),
							chuyenBay[i].getMayBay().getIdMayBay(), chuyenBay[i].getMayBay().getTenMayBay(),
							chuyenBay[i].getMayBay().giaTien());
			}
			System.out.println();
		}
		else {
			System.out.println("Chuyen bay ban can hien khong co!");
			xuat();
			System.out.println();
		}
	}

	@Override
	public void thongKeChuyenBay(String ma) {
		System.out.println(
				"\n------------------------------------------------------------------------------------------------");
		System.out.println(ma.toUpperCase());
		System.out.println("so luong chuyen bay: " + soLuongCB);
		int vn = 0, vj = 0, js = 0;
		for (int i = 0; i < soLuongCB; i++) {
			if (chuyenBay[i].getMayBay().getTenMayBay().equals("VietNamAirLines"))
				vn++;
			else if (chuyenBay[i].getMayBay().getTenMayBay().equals("VietJetAir"))
				vj++;
			else if (chuyenBay[i].getMayBay().getTenMayBay().equals("JetStarAirWay"))
				js++;
		}
		System.out.println("so luong may bay VietNamAirLines: " + vn);
		System.out.println("so luong may bay VietJetAir: " + vj);
		System.out.println("so luong may bay JetStarAirWay: " + js);
		System.out.println(
				"------------------------------------------------------------------------------------------------\n");

	}

	public ChuyenBay timChuyenBay(String ma) {
		for (int i = 0; i < soLuongCB; i++) {
			if (chuyenBay[i].getIdCB().contains(ma))
				return chuyenBay[i];
		}
		return chuyenBay[0];
	}

	// Tìm kiếm theo tên máy bay
	@Override
	public void thongKeTheoTen(String ten) {
		System.out.println();
		System.out.printf(
				"%-3s|%-6s|%-10s|%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|%-10s|%-10s|%-10s|%-10s|%-20s|%-8s\n",
				"STT", "ID", "DIEMDI", "DIEMDEN", "SANBAYDI", "SANBAYDEN", "THOIGIANKHOIHANH", "THOIGIANHACANH",
				"NGAYKHOIHANH", "NGAYVE", "GHETHUONG", "GHEVIP", "IDMAYBAY", "TENMAYBAY", "GIA");
		int stt=0;
		for (int i = 0; i < soLuongCB; i++) {
			if (chuyenBay[i].getMayBay().getTenMayBay().contains(ten)) {
				System.out.printf(
						"%-3d|%-6s|%-10s|%-10s|%-15s|%-15s|%-16s|%-15s|%-15s|%-10s|%-10d|%-10d|%-10s|%-20s|%-8.2f\n",
						++stt, chuyenBay[i].getIdCB(), chuyenBay[i].getDiemDi(), chuyenBay[i].getDiemDen(),
						chuyenBay[i].getSanBayDi(), chuyenBay[i].getSanBayDen(),
						chuyenBay[i].getThoiGianKhoiHanh(), chuyenBay[i].getThoiGianHaCanh(),
						chuyenBay[i].getNgayKhoiHanh(), chuyenBay[i].getNgayVe(),
						chuyenBay[i].getSoLuongGheThuong(), chuyenBay[i].getSoLuongGheVip(),
						chuyenBay[i].getMayBay().getIdMayBay(), chuyenBay[i].getMayBay().getTenMayBay(),
						chuyenBay[i].getMayBay().giaTien());
			}
		}
		if(stt == 0) {
			System.out.println("Khong co thong tin!");
		}
		System.out.println();
	}

	@Override
	public void sapXep() {
		for (int i = 0; i < soLuongCB - 1; i++)
			for (int j = i + 1; j < soLuongCB; j++)
				if (chuyenBay[i].getIdCB().compareTo(chuyenBay[j].getIdCB()) > 0) {
					ChuyenBay temp = new ChuyenBay();
					temp = chuyenBay[i];
					chuyenBay[i] = chuyenBay[j];
					chuyenBay[j] = temp;
				}
	}

	@Override
	public void thongKeTheoMa(String ma) {
		System.out.println();
		System.out.printf(
				"%-3s|%-6s|%-10s|%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|%-10s|%-10s|%-10s|%-10s|%-20s|%-8s\n",
				"STT", "ID", "DIEMDI", "DIEMDEN", "SANBAYDI", "SANBAYDEN", "THOIGIANKHOIHANH", "THOIGIANHACANH",
				"NGAYKHOIHANH", "NGAYVE", "GHETHUONG", "GHEVIP", "IDMAYBAY", "TENMAYBAY", "GIA");
		int stt=0;
		for (int i = 0; i < soLuongCB; i++) {
			if (chuyenBay[i].getMayBay().getIdMayBay().contains(ma)) {
				System.out.printf(
						"%-3d|%-6s|%-10s|%-10s|%-15s|%-15s|%-16s|%-15s|%-15s|%-10s|%-10d|%-10d|%-10s|%-20s|%-8.2f\n",
						++stt, chuyenBay[i].getIdCB(), chuyenBay[i].getDiemDi(), chuyenBay[i].getDiemDen(),
						chuyenBay[i].getSanBayDi(), chuyenBay[i].getSanBayDen(),
						chuyenBay[i].getThoiGianKhoiHanh(), chuyenBay[i].getThoiGianHaCanh(),
						chuyenBay[i].getNgayKhoiHanh(), chuyenBay[i].getNgayVe(),
						chuyenBay[i].getSoLuongGheThuong(), chuyenBay[i].getSoLuongGheVip(),
						chuyenBay[i].getMayBay().getIdMayBay(), chuyenBay[i].getMayBay().getTenMayBay(),
						chuyenBay[i].getMayBay().giaTien());
			}
		}
		if(stt==0) {
			System.out.println("Khong co thong tin!");
		}
		System.out.println();
	}

	@Override
	public void them() {
		ChuyenBay cb = new ChuyenBay();
		cb.nhap();
		for (int i = 0; i < soLuongCB; i++) {
			if (chuyenBay[i].getIdCB().equals(cb.getIdCB())) {
				System.out.println("ID CHUYEN BAY DA TON TAI!");
				return;
			}
		}
		chuyenBay[soLuongCB] = cb;
		soLuongCB++;
	}

	@Override
	public void xoa(String ma) {
		for (int i = 0; i < soLuongCB; i++) {
			if (chuyenBay[i].getIdCB().equalsIgnoreCase(ma)) {
				for (int j = i; j < soLuongCB - 1; j++)
					chuyenBay[j] = chuyenBay[j + 1];
				soLuongCB--;
				System.out.println("XOA THANH CONG!");
				return;
			}
		}
		System.out.println("XOA THAT BAI HOAC KHONG TIM THAY!");
	}
	public boolean checkCot(String cot) {
		cot = cot.trim();
		return cot.equals("ID") || cot.equals("DIEMDI") || cot.equals("DIEMDEN") || cot.equals("SANBAYDI")
				|| cot.equals("SANBAYDEN") || cot.equals("THOIGIANKHOIHANH") || cot.equals("THOIGIANHACANH") || cot.equals("NGAYKHOIHANH")
				|| cot.equals("NGAYVE") || cot.equals("GHETHUONG") || cot.equals("GHEVIP")
				|| cot.equals("IDMAYBAY") || cot.equals("TENMAYBAY") || cot.equals("GIA");
	}
	@Override
	public void suaThongTin(String ma) {
		int i;
		for (i = 0; i < soLuongCB; i++) {
			if (ma.equals(chuyenBay[i].getIdCB())) {
				break;
			}
		}
		if (i == soLuongCB) {
			System.out.println();
			System.out.println("Khong co chuyen bay hoac id chuyen bay khong dung!");
			System.out.println();
			return;
		}
		System.out.println();
		System.out.printf(
				"%-6s|%-10s|%-10s|%-15s|%-15s|%-15s|%-15s|%-15s|%-10s|%-10s|%-10s|%-10s|%-20s|%-8s\n",
				"ID", "DIEMDI", "DIEMDEN", "SANBAYDI", "SANBAYDEN", "THOIGIANKHOIHANH", "THOIGIANHACANH",
				"NGAYKHOIHANH", "NGAYVE", "GHETHUONG", "GHEVIP", "IDMAYBAY", "TENMAYBAY", "GIA");
		for (i = 0; i < soLuongCB; i++) {
			if (ma.equals(chuyenBay[i].getIdCB())) {
				System.out.printf(
						"%-6s|%-10s|%-10s|%-15s|%-15s|%-16s|%-15s|%-15s|%-10s|%-10d|%-10d|%-10s|%-20s|%-8.2f\n",
						chuyenBay[i].getIdCB(), chuyenBay[i].getDiemDi(), chuyenBay[i].getDiemDen(),
						chuyenBay[i].getSanBayDi(), chuyenBay[i].getSanBayDen(),
						chuyenBay[i].getThoiGianKhoiHanh(), chuyenBay[i].getThoiGianHaCanh(),
						chuyenBay[i].getNgayKhoiHanh(), chuyenBay[i].getNgayVe(),
						chuyenBay[i].getSoLuongGheThuong(), chuyenBay[i].getSoLuongGheVip(),
						chuyenBay[i].getMayBay().getIdMayBay(), chuyenBay[i].getMayBay().getTenMayBay(),
						chuyenBay[i].getMayBay().giaTien());
				break;
			}
		}
		System.out.println();
		String str;
		do {
			System.out.print("Nhap cot thong tin muon sua: ");
			str = sc.nextLine();
			if (!checkCot(str))
				System.out.println("Nhap sai, moi ban nhap lai: ");
		} while (!checkCot(str));
		switch (str) {
		case "ID":
			System.out.print("Nhap ID: ");
			str = sc.nextLine();
			chuyenBay[i].setIdCB(str);
			break;
		case "DIEMDI":
			System.out.print("Nhap DIEMDI: ");
			str = sc.nextLine();
			chuyenBay[i].setDiemDi(str);
			break;
		case "DIEMDEN":
			System.out.print("Nhap DIEMDEN: ");
			str = sc.nextLine();
			chuyenBay[i].setDiemDen(str);
			break;
		case "SANBAYDI":
			System.out.print("Nhap SANBAYDI: ");
			str = sc.nextLine();
			chuyenBay[i].setSanBayDi(str);
			break;
		case "SANBAYDEN":
			System.out.print("Nhap SANBAYDEN: ");
			str = sc.nextLine();
			chuyenBay[i].setSanBayDen(str);
			break;
		case "THOIGIANKHOIHANH":
			ThoiGian t = new ThoiGian();
			System.out.println("Nhap THOIGIANKHOIHANH: ");
			t.nhap();
			chuyenBay[i].setThoiGianKhoiHanh(t);
			break;
		case "THOIGIANHACANH":
			ThoiGian t1 = new ThoiGian();
			System.out.println("Nhap THOIGIANHACANH: ");
			t1.nhap();
			chuyenBay[i].setThoiGianHaCanh(t1);
			break;
		case "NGAYKHOIHANH":
			System.out.println("Nhap NGAYKHOIHANH: ");
			NgayThangNam t2 = new NgayThangNam();
			t2.nhap();
			chuyenBay[i].setNgayKhoiHanh(t2);
			break;
		case "NGAYVE":
			System.out.println("Nhap NGAYVE: ");
			NgayThangNam t3 = new NgayThangNam();
			t3.nhap();
			chuyenBay[i].setNgayKhoiHanh(t3);
			break;
		case "GHETHUONG":
			System.out.print("Nhap GHETHUONG: ");
			int t4 = sc.nextInt();
			chuyenBay[i].setSoLuongGheThuong(t4);
			break;
		case "GHEVIP":
			System.out.print("Nhap GHEVIP: ");
			t4 = sc.nextInt();
			chuyenBay[i].setSoLuongGheVip(t4);
			break;
		case "IDMAYBAY":
			System.out.print("Nhap IDMAYBAY: ");
			HangMayBay t_hmb = chuyenBay[i].getMayBay();
			t_hmb.setIdMayBay(sc.nextLine());
			chuyenBay[i].setMayBay(t_hmb);
			break;
		case "TENMAYBAY":
			System.out.print("Nhap TENMAYBAY: ");
			t_hmb = chuyenBay[i].getMayBay();
			t_hmb.setTenMayBay(sc.nextLine());
			chuyenBay[i].setMayBay(t_hmb);
			break;
		case "GIA":
			System.out.print("Nhap GIA: ");
			t_hmb = chuyenBay[i].getMayBay();
			t_hmb.setGia(sc.nextDouble());
			chuyenBay[i].setMayBay(t_hmb);
			break;
		}
	}
	
	public void sapXepChuyenBayGiamTheoGia() {
		ChuyenBay t;
		for(int i=0;i<soLuongCB-1;i++) {
			for(int j=i+1;j<soLuongCB;j++) {
				if(chuyenBay[i].getMayBay().giaTien() < chuyenBay[j].getMayBay().giaTien()) {
					t = chuyenBay[i];
					chuyenBay[i] = chuyenBay[j];
					chuyenBay[j] = t;
				}
			}
		}
		System.out.println("\nSap xep giam theo gia thanh cong!\n");
	}
	
	public void sapXepChuyenBayTheoIDChuyenBay() {
		ChuyenBay t;
		for(int i=0;i<soLuongCB-1;i++) {
			for(int j=i+1;j<soLuongCB;j++) {
				if(chuyenBay[i].getIdCB().compareTo(chuyenBay[j].getIdCB()) > 0 ) {
					t = chuyenBay[i];
					chuyenBay[i] = chuyenBay[j];
					chuyenBay[j] = t;
				}
			}
		}
		System.out.println("\nSap xep theo id thanh cong!\n");
	}
	

	@Override
	public void docFile() {
		String[] str;
		String[] str1;
		String data;
		try {
//            File myObj = new File("DataBase/ChuyenBay.txt");
//            Scanner myReader = new Scanner(myObj);
			BufferedReader objReader = new BufferedReader(new FileReader("DataBase/ChuyenBay.txt"));
			while ((data = objReader.readLine()) != null) {

				str = data.split("\\|");
//                ChuyenBay cb = new ChuyenBay();
//                cb.setIdCB(str[0]);
//                cb.setDiemDi(str[1]);
//                cb.setDiemDen(str[2]);
//                cb.setSanBayDi(str[3]);
//                cb.setSanBayDen(str[4]);
//                cb.setSoLuongGheThuong(Integer.parseInt(str[9]));
//                cb.setSoLuongGheVip(Integer.parseInt(str[10]));
//                cb.getMayBay().setIdMayBay(str[11]);
//                cb.getMayBay().setTenMayBay(str[12]);
//                cb.getMayBay().setGia(Double.parseDouble(str[13]));
//                str1 = str[5].split(":");
//                cb.getThoiGianKhoiHanh().setGio(Integer.parseInt(str1[0]));
//                cb.getThoiGianKhoiHanh().setPhut(Integer.parseInt(str1[1]));
//                cb.getThoiGianKhoiHanh().setGiay(Integer.parseInt(str1[2]));
//                str1 = str[6].split(":");
//                cb.getThoiGianHaCanh().setGio(Integer.parseInt(str1[0]));
//                cb.getThoiGianHaCanh().setPhut(Integer.parseInt(str1[1]));
//                cb.getThoiGianHaCanh().setGiay(Integer.parseInt(str1[2]));
//                str1 = str[7].split("/");
//                cb.getNgayKhoiHanh().setNgay(Integer.parseInt(str1[0]));
//                cb.getNgayKhoiHanh().setThang(Integer.parseInt(str1[1]));
//                cb.getNgayKhoiHanh().setNam(Integer.parseInt(str1[2]));
//                str1 = str[8].split("/");
//                cb.getNgayVe().setNgay(Integer.parseInt(str1[0]));
//                cb.getNgayVe().setThang(Integer.parseInt(str1[1]));
//                cb.getNgayVe().setNam(Integer.parseInt(str1[2]));
				HangMayBay mb;
				String test = new String(str[12]);
				if (test.equalsIgnoreCase("VietNamAirLines")) {
					mb = new VietNamAirLines(str[11], str[12], Double.parseDouble(str[13]));
				} else if (test.equalsIgnoreCase("JetStarAirWay"))
					mb = new JetStarAirWay(str[11], str[12], Double.parseDouble(str[13]));
				else
					mb = new VietJetAir(str[11], str[12], Double.parseDouble(str[13]));

				str1 = str[5].split(":");
				ThoiGian tg = new ThoiGian(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]),
						Integer.parseInt(str1[2]));
				str1 = str[6].split(":");
				ThoiGian tg1 = new ThoiGian(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]),
						Integer.parseInt(str1[2]));
				str1 = str[7].split("/");
				NgayThangNam ntn = new NgayThangNam(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]),
						Integer.parseInt(str1[2]));
				str1 = str[8].split("/");
				NgayThangNam ntn1 = new NgayThangNam(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]),
						Integer.parseInt(str1[2]));

				chuyenBay[soLuongCB] = new ChuyenBay(str[0], str[1], str[2], str[3], str[4], tg, tg1, ntn, ntn1,
						Integer.parseInt(str[9]), Integer.parseInt(str[10]), mb);
				soLuongCB++;
			}
			objReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void ghiFile() {
		try {
			FileWriter fr = new FileWriter("DataBase/ChuyenBay.txt");
			BufferedWriter bw = new BufferedWriter(fr);
			for (int i = 0; i < soLuongCB; i++) {
				bw.write(chuyenBay[i].getIdCB() + "|");
				bw.write(chuyenBay[i].getDiemDi() + "|");
				bw.write(chuyenBay[i].getDiemDen() + "|");
				bw.write(chuyenBay[i].getSanBayDi() + "|");
				bw.write(chuyenBay[i].getSanBayDen() + "|");
				bw.write(chuyenBay[i].getThoiGianKhoiHanh().toString() + "|");
				bw.write(chuyenBay[i].getThoiGianHaCanh().toString() + "|");
				bw.write(chuyenBay[i].getNgayKhoiHanh().toString() + "|");
				bw.write(chuyenBay[i].getNgayVe() + "|");
				bw.write(chuyenBay[i].getSoLuongGheThuong() + "|");
				bw.write(chuyenBay[i].getSoLuongGheVip() + "|");
				bw.write(chuyenBay[i].getMayBay().getIdMayBay() + "|");
				bw.write(chuyenBay[i].getMayBay().getTenMayBay() + "|");
				bw.write(Double.toString(chuyenBay[i].getMayBay().getGia()));
				bw.newLine();
			}
			bw.close();
			fr.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
