public class JetStarAirWay extends HangMayBay {
    @Override
    public double giaTien() {
//        DecimalFormat df = new DecimalFormat("###.##");
        return this.gia * 2;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.giaTien();
    }

    public JetStarAirWay() {
    }

    public JetStarAirWay(String idMayBay, String tenMayBay, double gia) {
        super(idMayBay, tenMayBay, gia);
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
