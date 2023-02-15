public class VietNamAirLines extends HangMayBay{
    public VietNamAirLines() {
    }

    public VietNamAirLines(String idMayBay, String tenMayBay, double gia) {
        super(idMayBay, tenMayBay, gia);
    }

    @Override
    public double giaTien() {
//        DecimalFormat df = new DecimalFormat("0.#");
        return this.gia * 4.0f;
    }
    @Override
    public String toString() {
        return super.toString()+ " " + this.giaTien();
    }

    public void xuat() {
        System.out.println(this.toString());
    }
    @Override
    public void nhap() {
        super.nhap();
    }
}
