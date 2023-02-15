import java.util.Scanner;

public abstract class HangMayBay {
    static Scanner sc = new Scanner(System.in);
    protected String idMayBay;
    protected String tenMayBay;
    protected double gia;

    public HangMayBay() {
    }

    public HangMayBay(String idMayBay, String tenMayBay, double gia) {
        this.idMayBay = idMayBay;
        this.tenMayBay = tenMayBay;
        this.gia = gia;
    }

    public String getIdMayBay() {
        return idMayBay;
    }

    public void setIdMayBay(String idMayBay) {
        this.idMayBay = idMayBay;
    }

    public String getTenMayBay() {
        return tenMayBay;
    }

    public void setTenMayBay(String tenMayBay) {
        this.tenMayBay = tenMayBay;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void nhap() {
        boolean check;
        do {
            this.idMayBay = sc.nextLine();
            check = Check.checkIDMB(this.idMayBay);
            if (!check) {
                System.out.println("nhap id may bay khong hop le! Vui long nhap lai.");
            }
        } while (!check);
        System.out.print("nhap gia tien hang may bay: ");
        this.gia = Double.parseDouble(sc.nextLine());
        if (this.idMayBay.substring(0, 2).equals("VN"))
            this.tenMayBay = "VietNamAirLines";
        else if (this.idMayBay.substring(0, 2).equals("VJ"))
            this.tenMayBay = "VietJetAir";
        else this.tenMayBay = "JetStarAirWay";
    }

    @Override
    public String toString() { 
        return this.idMayBay + " " + this.tenMayBay;
    }

    public void xuat() {
        System.out.println(this.toString());
    }

    public abstract double giaTien();
}
