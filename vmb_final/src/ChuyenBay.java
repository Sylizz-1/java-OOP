import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChuyenBay {
    private String idCB;
    private String diemDi;
    private String diemDen;
    private String sanBayDi;
    private String sanBayDen;
    private ThoiGian thoiGianKhoiHanh;
    private ThoiGian thoiGianHaCanh;
    private NgayThangNam ngayKhoiHanh;
    private NgayThangNam ngayVe;
    private int soLuongGheVip;
    private int soLuongGheThuong;
    private HangMayBay mayBay;
    static Scanner sc = new Scanner(System.in);

    public ChuyenBay() {
        thoiGianHaCanh = new ThoiGian();
        thoiGianKhoiHanh = new ThoiGian();
        ngayKhoiHanh = new NgayThangNam();
        ngayVe = new NgayThangNam();
        mayBay = new VietJetAir();
    }

    public ChuyenBay(String idCB, String diemDi, String diemDen, String sanBayDi, String sanBayDen, ThoiGian thoiGianKhoiHanh, ThoiGian thoiGianHaCanh,
                     NgayThangNam ngayKhoiHanh, NgayThangNam ngayVe, int soLuongGheThuong, int soLuongGheVip, HangMayBay mayBay) {
        this.idCB = idCB;
        this.sanBayDi = sanBayDi;
        this.sanBayDen = sanBayDen;
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
        this.thoiGianHaCanh = thoiGianHaCanh;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayVe = ngayVe;
        this.soLuongGheVip = soLuongGheVip;
        this.soLuongGheThuong = soLuongGheThuong;
        this.mayBay = mayBay;
        this.diemDen = diemDen;
        this.diemDi = diemDi;
    }

    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getIdCB() {
        return idCB;
    }

    public void setIdCB(String idCB) {
        this.idCB = idCB;
    }

    public String getSanBayDi() {
        return sanBayDi;
    }

    public void setSanBayDi(String sanBayDi) {
        this.sanBayDi = sanBayDi;
    }

    public String getSanBayDen() {
        return sanBayDen;
    }

    public void setSanBayDen(String sanBayDen) {
        this.sanBayDen = sanBayDen;
    }

    public ThoiGian getThoiGianKhoiHanh() {
        return thoiGianKhoiHanh;
    }

    public void setThoiGianKhoiHanh(ThoiGian thoiGianKhoiHanh) {
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
    }

    public NgayThangNam getNgayVe() {
        return ngayVe;
    }

    public void setNgayVe(NgayThangNam ngayVe) {
        this.ngayVe = ngayVe;
    }

    public ThoiGian getThoiGianHaCanh() {
        return thoiGianHaCanh;
    }

    public void setThoiGianHaCanh(ThoiGian thoiGianHaCanh) {
        this.thoiGianHaCanh = thoiGianHaCanh;
    }

    public NgayThangNam getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(NgayThangNam ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public int getSoLuongGheVip() {
        return soLuongGheVip;
    }

    public void setSoLuongGheVip(int soLuongGheVip) {
        this.soLuongGheVip = soLuongGheVip;
    }

    public int getSoLuongGheThuong() {
        return soLuongGheThuong;
    }

    public void setSoLuongGheThuong(int soLuongGheThuong) {
        this.soLuongGheThuong = soLuongGheThuong;
    }

    public HangMayBay getMayBay() {
        return mayBay;
    }

    public void setMayBay(HangMayBay mayBay) {
        this.mayBay = mayBay;
    }

    public void nhap() {
        boolean check;
        do {
            System.out.print("nhap id chuyen bay: ");
            this.setIdCB(sc.nextLine());
            check = Check.checkIDCB(this.getIdCB());
            if (!check) {
                System.out.println("nhap khong hop le! Vui long nhap lai.");
            }
        } while (!check);
        System.out.print("nhap diem di: ");
        this.setDiemDi(sc.nextLine());
        System.out.print("nhap diem den: ");
        this.setDiemDen(sc.nextLine());
        System.out.print("nhap san bay di: ");
        this.setSanBayDi(sc.nextLine());
        System.out.print("nhap san bay den: ");
        this.setSanBayDen(sc.nextLine());
        System.out.println("nhap thoi gian khoi hanh. ");
        this.thoiGianKhoiHanh.nhap();
        System.out.println("nhap thoi gian ha canh. ");
        this.thoiGianHaCanh.nhap();
        System.out.println("nhap ngay khoi hanh.");
        this.ngayKhoiHanh.nhap();
        System.out.println("nhap ngay ve. ");
        this.ngayVe.nhap();

        do {
            System.out.print("nhap so luong ghe thuong: ");
            this.setSoLuongGheThuong(Integer.parseInt(sc.nextLine()));
            if (this.soLuongGheThuong <= 0) {
                System.out.println("nhap khong hop le! Vui long nhap lai.");
            }
        } while (this.soLuongGheThuong<= 0);

        do {
            System.out.print("nhap so luong ghe vip: ");
            this.setSoLuongGheVip(Integer.parseInt(sc.nextLine()));
            if (this.soLuongGheVip <= 0) {
                System.out.println("nhap khong hop le! Vui long nhap lai.");
            }
        } while (this.soLuongGheVip <= 0);

        System.out.println("chon may bay muon them: ");
        System.out.println("1. VietNamAirLines ");
        System.out.println("2. VietJetAir ");
        System.out.println("3. JetStarAirWay");
        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1:
                this.mayBay = new VietNamAirLines();
                System.out.print("nhap id may bay[VN--]: ");
                do {
                    this.mayBay.nhap();
                    if (!this.mayBay.getIdMayBay().startsWith("VN"))
                        System.out.println("nhap id may bay hop le! Vui long nhap lai.");
                } while (!this.mayBay.getIdMayBay().startsWith("VN"));


                break;
            case 2:
                this.mayBay = new VietJetAir();
                System.out.print("nhap id may bay[VJ--]: ");
                do {
                    this.mayBay.nhap();
                    if (!this.mayBay.getIdMayBay().startsWith("VJ"))
                        System.out.println("nhap id may bay hop le! Vui long nhap lai.");
                } while (!this.mayBay.getIdMayBay().startsWith("VJ"));
                break;
            case 3:
                this.mayBay = new JetStarAirWay();
                System.out.print("nhap id may bay[JS--]: ");
                do {
                    this.mayBay.nhap();
                    if (!this.mayBay.getIdMayBay().startsWith("JS"))
                        System.out.println("nhap id may bay hop le! Vui long nhap lai.");
                } while (!this.mayBay.getIdMayBay().startsWith("JS"));
                break;
        }
    }

    public double giaTien() {
        return this.mayBay.giaTien();
    }

    public String thoiGianBay() throws ParseException {
        String time1 = this.thoiGianKhoiHanh.getGio()
                + ":" + this.thoiGianKhoiHanh.getPhut() + ":" + this.thoiGianKhoiHanh.getGiay();
        String time2 = this.thoiGianHaCanh.getGio()
                + ":" + this.thoiGianHaCanh.getPhut() + ":" + this.thoiGianHaCanh.getGiay();

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
        return Long.toString((difference / 1000) / 60);
    }

    public static void main(String[] args) throws ParseException {
        ChuyenBay cb = new ChuyenBay();
        ThoiGian tg = new ThoiGian(24,5,2);
        ThoiGian tg1 = new ThoiGian(25,5,10);
        cb.setThoiGianKhoiHanh(tg);
        cb.setThoiGianHaCanh(tg1);
        System.out.println(cb.thoiGianBay());
    }
}
