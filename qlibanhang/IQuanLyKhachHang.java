package qlibanhang;

public interface IQuanLyKhachHang {
    void themKhachHang(KhachHang kh);
    boolean xoaKhachHang(String maKH);
    KhachHang timKiemKhachHang(String maKH);
    void hienThiDanhSach();
}
