public class VietJetAir extends HangMayBay {
    public VietJetAir() {
    }

    public VietJetAir(String idMayBay, String tenMayBay, double gia) {
        super(idMayBay, tenMayBay, gia);
    }

    @Override
    public double giaTien() {
//        DecimalFormat df = new DecimalFormat("###.##");
        return this.gia * 3;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.giaTien();
    }

    @Override
    public void xuat() {
        System.out.println(this.toString());
    }
    @Override
    public void nhap() {
        super.nhap();
    }
}
