package qlibanhang;

public class NhanVien extends Nguoi {
    private String maNV;
    private String chucVu;
    private double luong;
    
    public NhanVien() {
    }

    public NhanVien(String ho, String ten, String gioiTinh, String ngaySinh, String SDT, String email, String diaChi,
                    String maNV, String chucVu, double luong) {
        super(ho, ten, gioiTinh, ngaySinh, SDT, email, diaChi);
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public String getChucVu() {
        return chucVu;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    public double getLuong() {
        return luong;
    }
    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void lapHoaDon() {
        System.out.println("Nhan vien " + ten + " dang lap hoa don...");
    }
    public void quanLyKho() {
        System.out.println("Nhan vien " + ten + " dang quan ly kho...");
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Ma NV: " + maNV + ", Chuc vu: " + chucVu + ", Luong: " + luong);
    }
    @Override
    public String toString() {
        return super.toString() + String.format(" | MaNV:%s | ChucVu:%s | Luong:%.2f", maNV, chucVu, luong);
    }
}
