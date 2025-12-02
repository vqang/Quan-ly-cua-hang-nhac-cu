package qlibanhang;

import java.util.ArrayList;

public class QuanLyKhachHangImpl implements IQuanLyKhachHang,IReadWrite {
    private ArrayList<KhachHang> danhSachKhachHang;

    public QuanLyKhachHangImpl() {
        this.danhSachKhachHang = new ArrayList<>();
    }

    @Override
    public void themKhachHang(KhachHang kh) {
        danhSachKhachHang.add(kh);
    }
    @Override
    public boolean xoaKhachHang(String maKH) {
        return danhSachKhachHang.removeIf(kh -> kh.getMaKH().equals(maKH));
    }
    @Override
    public KhachHang timKiemKhachHang(String maKH) {
         for (KhachHang kh : danhSachKhachHang) {
            if (kh.getMaKH().equals(maKH)) return kh;
        }
        return null;
    }
    @Override
    public void hienThiDanhSach() {
        for(KhachHang kh : danhSachKhachHang) kh.hienThiThongTin();
    }

    @Override
    public void ReadData(String tenFile) {
        System.out.println("Dang doc du lieu tu file: " + tenFile);
    }
    @Override
    public void WriteData(String tenFile) {
        System.out.println("Dang ghi du lieu vao file: " + tenFile);
    }
    
}
