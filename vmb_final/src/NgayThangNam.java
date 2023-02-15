import java.util.Scanner;

public class NgayThangNam {
    private int ngay;
    private int thang;
    private int nam;
    static Scanner sc = new Scanner(System.in);

    public NgayThangNam(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public NgayThangNam() {
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public void nhap() {
        System.out.println("nhap ngay: ");
        this.ngay = Integer.parseInt(sc.nextLine());
        System.out.println("nhap thang: ");
        this.thang = Integer.parseInt(sc.nextLine());
        System.out.println("nhap nam: ");
        this.nam = Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        return this.ngay + "/" + this.thang + "/" + this.nam;
    }

    public void xuat() {
        System.out.println(toString());
    }
}

