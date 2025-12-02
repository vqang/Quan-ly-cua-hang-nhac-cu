package qlibanhang;

public class KhachHang extends Nguoi {
    private String maKH;
    private int diemTichLuy;

    public KhachHang() {
    }

    public KhachHang(String ho, String ten, String gioiTinh,String ngaySinh, String SDT, String email, String diaChi,
                     String maKH, int diemTichLuy) {
        super(ho, ten, gioiTinh, ngaySinh, SDT, email, diaChi);
        this.maKH = maKH;
        this.diemTichLuy = diemTichLuy;
    }

    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public int getDiemTichLuy() {
        return diemTichLuy;
    }
    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }
    public void datHang() {
        System.out.println("Khach hang " + ho + " " + ten + " đang dat hang...");
    }
    public void xemHoaDon() {
        System.out.println("Đang xem hoa don cua khach hang " + maKH);
    }
    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Ma KH: " + maKH + ", Diem tich luy: " + diemTichLuy);
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" | MaKH:%s | Diem:%d", maKH, diemTichLuy);
    }
}
