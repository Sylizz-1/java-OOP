import java.util.Scanner;

public class ThoiGian {
    private int gio;
    private int phut;
    private int giay;
    static Scanner sc = new Scanner(System.in);
    public ThoiGian() {
    }

    public ThoiGian(int gio, int phut, int giay) {
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }

    public int getGio() {
        return gio;
    }

    public void setGio(int gio) {
        this.gio = gio;
    }

    public int getPhut() {
        return phut;
    }

    public void setPhut(int phut) {
        this.phut = phut;
    }

    public int getGiay() {
        return giay;
    }

    public void setGiay(int giay) {
        this.giay = giay;
    }

    public void nhap()
    {
        boolean check;
        do {
            System.out.print("Nhap gio: ");
            this.gio = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap phut: ");
            this.phut = Integer.parseInt(sc.nextLine());
            this.giay = 0;
            check = Check.checkThoiGian(this);
            if (!check){
                System.out.println("nhap khong hop le! Vui long nhap lai.");
            }
        } while (!check);

    }

    @Override
    public String toString() {
        return this.gio + ":" + this.phut + ":" + this.giay;
    }

    public void xuat() {
        System.out.println(this.toString());
    }
}
