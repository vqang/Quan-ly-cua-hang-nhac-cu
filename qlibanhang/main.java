package qlibanhang;

public class main {
    public static void main(String[] args) {
        System.out.println(" CHUONG TRINH QUAN LY CUA HANG NHAC CU ");
        // 1. TEST QUAN LY NHAC CU
        System.out.println("\n--- [1] QUAN LY NHAC CU ---");
        QuanLyNhacCuImpl qlNhacCu = new QuanLyNhacCuImpl();

        // Guitar: Gia goc 5tr -> Gia ban se la 6tr
        DanGuitar guitar1 = new DanGuitar("GT01", "Fender Stratocaster", "Fender", 2023, 
                                          5000000, 10, "Guitar dien", "Sat", 6);
        
        // Piano: Gia goc 50tr -> Gia ban se la 57.5tr
        DanPiano piano1 = new DanPiano("PN01", "Yamaha U1", "Yamaha", 2022, 
                                       50000000, 2, "Upright");

        // Them vao danh sach
        qlNhacCu.themNhacCu(guitar1);
        qlNhacCu.themNhacCu(piano1);

        // Hien thi danh sach
        qlNhacCu.hienThiDanhSach();

        // Test chuc nang tinh tong so luong
        System.out.println("-> Tong so luong nhac cu trong kho: " + qlNhacCu.tinhTongSoLuong());

        // Test chuc nang canh bao ton kho (Muc toi thieu 3)
        System.out.println("\n-> Kiem tra ton kho (Muc toi thieu 3):");
        if (!guitar1.kiemTraTonKho(3)) System.out.println("Guitar thieu hang"); 
        if (!piano1.kiemTraTonKho(3)) System.out.println("Piano thieu hang");   

        // Test chuc nang Ghi File
        qlNhacCu.WriteData("DanhSachNhacCu.txt");

        // 2. TEST QUAN LY NHAN VIEN
        System.out.println("\n--- [2] QUAN LY NHAN VIEN ---");
        QuanLyNhanVienImpl qlNhanVien = new QuanLyNhanVienImpl();

        // Tao nhan vien (SDT phai >= 10 so)
        NhanVien nv1 = new NhanVien("Hoang Dinh", "Vinh Quang", "Nam", "01/01/1990", 
                                    "0935276477", "quang21042006@gmail.com", "Da Nang", 
                                    "NV01", "Nhan vien", 1500000);

        // Thu tao nhan vien voi SDT sai (123)
        System.out.println("Test nhap SDT sai (123):");
        NhanVien nv2 = new NhanVien("Hoang Dinh", "Hong", "Nam", "05/05/1995", 
                                    "123", "hong@gmail.com", "TP HCM", 
                                    "NV02", "Quan ly", 8000000); 

        // Sua lai SDT cho dung de them vao list
        nv2.setSdt("0912345678");

        qlNhanVien.themNhanVien(nv1);
        qlNhanVien.themNhanVien(nv2);

        qlNhanVien.hienThiDanhSach();
        
        // Test hanh dong rieng
        nv1.lapHoaDon();
        nv2.quanLyKho();

        // 3. TEST QUAN LY KHACH HANG
        System.out.println("\n--- [3] QUAN LY KHACH HANG ---");
        QuanLyKhachHangImpl qlKhachHang = new QuanLyKhachHangImpl();

        KhachHang kh1 = new KhachHang("Ngo Thi", "Thu Ha", "Nu", "10/10/2000", 
                                      "0909090909", "ha@gmail.com", "Ha Noi", 
                                      "KH01", 500);

        qlKhachHang.themKhachHang(kh1);
        qlKhachHang.hienThiDanhSach();

        // Test chuc nang doc file
        qlKhachHang.ReadData("DataKhachHang.txt");
    }
}