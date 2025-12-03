package qlibanhang;

import java.util.ArrayList;
import java.io.BufferedWriter; 
import java.io.FileWriter;     
import java.io.IOException;   

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
        try {
            FileWriter fw = new FileWriter(tenFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (KhachHang kh : danhSachKhachHang) {
                bw.write(kh.toString());
                bw.newLine();
            }

            bw.close();
            fw.close();
            System.out.println("-> Ghi file KHACH HANG thanh cong! (" + tenFile + ")");
        } catch (IOException e) {
            System.out.println("-> Loi ghi file: " + e.getMessage());
        }
    }
    
}
