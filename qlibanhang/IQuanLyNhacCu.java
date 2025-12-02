package qlibanhang;

public interface IQuanLyNhacCu {
    void themNhacCu(NhacCu nhacCu);
    boolean xoaNhacCu(String maNhacCu);
    boolean capNhatNhacCu(String maNhacCu, NhacCu nhacCuMoi);
    NhacCu timKiemNhacCu(String ten);
    void hienThiDanhSach();
    int tinhTongSoLuong();
}
