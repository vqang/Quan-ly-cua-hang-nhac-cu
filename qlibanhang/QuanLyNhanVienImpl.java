package qlibanhang;

import java.util.ArrayList;
import java.io.BufferedWriter; 
import java.io.FileWriter;     
import java.io.IOException;    

public class QuanLyNhanVienImpl implements IQuanLyNhanVien,IReadWrite {
    private ArrayList<NhanVien> danhSachNhanVien;
    
    public QuanLyNhanVienImpl() {
        this.danhSachNhanVien = new ArrayList<>();
    }

    @Override
    public void themNhanVien(NhanVien nv) {
        danhSachNhanVien.add(nv);
    }
    @Override
    public boolean xoaNhanVien(String maNV) {
        return danhSachNhanVien.removeIf(nv -> nv.getMaNV().equals(maNV));
    }
    @Override
    public NhanVien timKiemNhanVien(String maNV) {
         for (NhanVien nv : danhSachNhanVien) {
            if (nv.getMaNV().equals(maNV)) return nv;
        }
        return null;
    }
    @Override
    public void hienThiDanhSach() {
        for(NhanVien nv : danhSachNhanVien) nv.hienThiThongTin();
    }

    @Override
    public void ReadData(String tenFile) {
        System.out.println("Doc danh sach du lieu tu file: " + tenFile);
    }
    @Override
    public void WriteData(String tenFile) {
        try {
            FileWriter fw = new FileWriter(tenFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (NhanVien nv : danhSachNhanVien) {
                bw.write(nv.toString());
                bw.newLine();
            }

            bw.close();
            fw.close();
            System.out.println("-> Ghi file NHAN VIEN thanh cong! (" + tenFile + ")");
        } catch (IOException e) {
            System.out.println("-> Loi ghi file: " + e.getMessage());
        }
    }
}
