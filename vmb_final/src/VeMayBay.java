public class VeMayBay {
    private ChuyenBay cb;
    private int viTriNgoi;
    private boolean loaiGhe;
    private double phi;


    public ChuyenBay getCb() {
        return cb;
    }

    public void setCb(ChuyenBay cb) {
        this.cb = cb;
    }

    public int getViTriNgoi() {
        return viTriNgoi;
    }

    public void setViTriNgoi(int viTriNgoi) {
        this.viTriNgoi = viTriNgoi;
    }

    public boolean getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(boolean loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public VeMayBay() {
        cb = new ChuyenBay();
    }

    public VeMayBay(ChuyenBay cb, int viTriNgoi, boolean loaiGhe, double phi) {
        this.cb = cb;
        this.viTriNgoi = viTriNgoi;
        this.loaiGhe = loaiGhe;
        this.phi = phi;
    }
}
