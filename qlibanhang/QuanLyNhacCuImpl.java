package qlibanhang;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    public NhacCu timKiemNhacCu(String ma) {
        for (NhacCu nc : danhSachNhacCu) {
            if (nc.getMaNhacCu().equalsIgnoreCase(ma)) {
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
        try {
            // Tao luong ghi file
            FileWriter fw = new FileWriter(tenFile);
            BufferedWriter bw = new BufferedWriter(fw);

            // Duyet qua danh sach va ghi tung dong
            for (NhacCu nc : danhSachNhacCu) {
                bw.write(nc.toString()); // Ghi noi dung cua nhac cu
                bw.newLine();            // Xuong dong
            }

            // Dong luong ghi file lai (Rat quan trong)
            bw.close();
            fw.close();
            
            System.out.println("-> Ghi file THANH CONG! Ten file: " + tenFile);
        } catch (IOException e) {
            System.out.println("-> Loi khi ghi file: " + e.getMessage());
        }
    }
}
