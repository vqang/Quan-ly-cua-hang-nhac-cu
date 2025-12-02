package qlibanhang;

import java.util.ArrayList;

public class QuanLyNhacCuImpl implements IQuanLyNhacCu, IReadWrite {
    private ArrayList<NhacCu> danhSachNhacCu;

    public QuanLyNhacCuImpl() {
        this.danhSachNhacCu = new ArrayList<>();
    }

    @Override
    public void themNhacCu(NhacCu nhacCu) {
        danhSachNhacCu.add(nhacCu);
        System.out.println("Da them nhac cu: " + nhacCu.getTenNhacCu());
    }

    @Override
    public boolean xoaNhacCu(String maNhacCu) {
        return danhSachNhacCu.removeIf(n -> n.getMaNhacCu().equals(maNhacCu));
    }

    @Override
    public boolean capNhatNhacCu(String maNhacCu, NhacCu nhacCuMoi) {
        for (int i = 0; i < danhSachNhacCu.size(); i++) {
            if (danhSachNhacCu.get(i).getMaNhacCu().equals(maNhacCu)) {
                danhSachNhacCu.set(i, nhacCuMoi);
                return true;
            }
        }
        return false;
    }

    @Override
    public NhacCu timKiemNhacCu(String ten) {
        for (NhacCu nc : danhSachNhacCu) {
            if (nc.getTenNhacCu().equalsIgnoreCase(ten)) {
                return nc;
            }
        }
        return null;
    }

    @Override
    public void hienThiDanhSach() {
        System.out.println("--- DANH SACH NHAC CU ---");
        for (NhacCu nc : danhSachNhacCu) {
            nc.hienThiThongTin();
        }
    }

    @Override
    public int tinhTongSoLuong() {
        int tong = 0;
        for (NhacCu nc : danhSachNhacCu) {
            tong += nc.soLuong;
        }
        return tong;
    }

    @Override
    public void ReadData(String tenFile) {
        System.out.println("Doc danh sach nhac cu tu file: " + tenFile);
    }

    @Override
    public void WriteData(String tenFile) {
        System.out.println("Ghi danh sach nhac cu vao file: " + tenFile);
    }
}
