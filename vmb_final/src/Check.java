public class Check {
    public static boolean checkEmail(String email) {
        return email.matches("(\\w|^)[\\w-_\\.+]*\\@(gmail|yahoo)\\.com(\\w|$)");
    }

    public static boolean checkNTN(NgayThangNam ntn) {
        switch (ntn.getThang()) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return ntn.getNgay() >= 1 && ntn.getNgay() <= 31;
            case 2:
                if (ntn.getNam() % 400 == 0 || (ntn.getNam() % 4 == 0 && ntn.getNam() % 100 != 0))
                    return ntn.getNgay() >= 1 && ntn.getNgay() <= 29;
                else
                    return ntn.getNgay() >= 1 && ntn.getNgay() <= 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return ntn.getNgay() >= 1 && ntn.getNgay() <= 30;
            default:
                return (ntn.getThang() >= 1 && ntn.getThang() <= 12) && ntn.getNam() > 0;
        }
    }

    public static boolean checkSDT(String sdt) {
        return sdt.substring(0, 2).equals("09") && sdt.length() == 10;
    }

    public static boolean checkIDKH(String kh) {
        return kh.matches("(KH)\\d+");
    }

    public static boolean checkIDNV(String nv) {
        return nv.matches("(NV)\\d+");
    }

    public static boolean checkThoiGian(ThoiGian tg) {
        return (tg.getGiay() >= 0 && tg.getGiay() <= 59) && (tg.getPhut() >= 0 && tg.getPhut() <= 59)
                && (tg.getGio() >= 0 && tg.getGio() <= 59);
    }

    public static boolean checkHoTen(String ht) {
        return ht.matches("[a-zA-Z\\s+]{1,50}$");
    }

    public static boolean checkIDCB(String cb) {
        return cb.matches("(CB)[0-9]{2}");
    }

    public static boolean checkIDMB(String mb) {
        return mb.matches("(VJ|VN|JS)[0-9]{1}[0-9]{2}[0-9]?");
    }
}
