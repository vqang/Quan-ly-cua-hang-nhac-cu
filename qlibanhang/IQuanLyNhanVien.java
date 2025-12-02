package qlibanhang;

public interface IQuanLyNhanVien {
    void themNhanVien(NhanVien nv);
    boolean xoaNhanVien(String maNV);
    NhanVien timKiemNhanVien(String maNV);
    void hienThiDanhSach();
}
