package qlibanhang;

import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    static QuanLyNhacCuImpl qlNhacCu = new QuanLyNhacCuImpl();
    static QuanLyNhanVienImpl qlNhanVien = new QuanLyNhanVienImpl();
    static QuanLyKhachHangImpl qlKhachHang = new QuanLyKhachHangImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== HE THONG QUAN LY CUA HANG NHAC CU ==========");
            System.out.println("1. Quan ly Nhac cu (Guitar/Piano)");
            System.out.println("2. Quan ly Nhan vien");
            System.out.println("3. Quan ly Khach hang");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("-> Moi ban chon chuc nang: ");
            
            int chon = 0;
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Loi: Vui long nhap so!");
                continue;
            }

            switch (chon) {
                case 1: menuNhacCu(); break;
                case 2: menuNhanVien(); break;
                case 3: menuKhachHang(); break;
                case 0: 
                    System.out.println("Tam biet!");
                    System.exit(0);
                default: System.out.println("Lua chon khong hop le!");
            }
        }
    }

    // 1. MENU QUAN LY NHAC CU 
    public static void menuNhacCu() {
        while (true) {
            System.out.println("\n--- [ QUAN LY NHAC CU ] ---");
            System.out.println("1. Them nhac cu moi");
            System.out.println("2. Xoa nhac cu ");
            System.out.println("3. Cap nhat THONG TIN "); 
            System.out.println("4. Cap nhat SO LUONG ");    
            System.out.println("5. Tim kiem nhac cu ");
            System.out.println("6. Hien thi danh sach");
            System.out.println("7. Tinh tong so luong ton kho");
            System.out.println("8. Ghi du lieu ra file");
            System.out.println("9. Check gia ban ");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("-> Moi chon chuc nang (0-9): ");
            
            int chon = 0;
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Loi: Vui long nhap so nguyen!");
                continue;
            }

            switch (chon) {
                case 1: themNhacCuMoi(); break;
                case 2: xoaNhacCu(); break;
                case 3: capNhatThongTinNhacCu(); break;
                case 4: capNhatSoLuongTonKho(); break;
                case 5: timKiemNhacCu(); break;
                case 6: qlNhacCu.hienThiDanhSach(); break;
                case 7: System.out.println("Tong so luong ton kho: " + qlNhacCu.tinhTongSoLuong()); break;
                case 8: qlNhacCu.WriteData("DanhSachNhacCu.txt"); break;
                case 9: tinhGiaBanCuThe(); break;
                case 0: return;
                default: System.out.println("Chuc nang khong ton tai!");
            }
        }
    }

    public static void xoaNhacCu() {
        System.out.print("\nNhap MA nhac cu can xoa: ");
        String maXoa = sc.nextLine();
        if (qlNhacCu.xoaNhacCu(maXoa)) {
            System.out.println("-> Da xoa thanh cong!");
        } else {
            System.out.println("-> Loi: Khong tim thay MA nhac cu nay.");
        }
    }

    public static void capNhatThongTinNhacCu() {
        System.out.println("\n--- CAP NHAT THONG TIN NHAC CU ---");
        System.out.print("Nhap MA nhac cu can sua: "); 
        String maTim = sc.nextLine();
        
        NhacCu nc = qlNhacCu.timKiemNhacCu(maTim);

        if (nc != null) {
            System.out.println("-> Tim thay: " + nc.getTenNhacCu());
            System.out.println("Moi nhap thong tin moi (Nhan Enter neu khong muon doi):");

            System.out.print("Ten moi (" + nc.getTenNhacCu() + "): ");
            String tenMoi = sc.nextLine();
            if (!tenMoi.isEmpty()) nc.setTenNhacCu(tenMoi);

            System.out.print("Hang SX moi (" + nc.getHangSX() + "): ");
            String hangMoi = sc.nextLine();
            if (!hangMoi.isEmpty()) nc.setHangSX(hangMoi);

            System.out.print("Gia co ban moi (" + nc.getGiaCoBan() + "): ");
            String giaMoiStr = sc.nextLine();
            if (!giaMoiStr.isEmpty()) {
                try {
                    double giaMoi = Double.parseDouble(giaMoiStr);
                    nc.setGiaCoBan(giaMoi);
                } catch (Exception e) {
                    System.out.println("-> Loi: Gia phai la so! (Giu nguyen gia cu)");
                }
            }
            System.out.println("-> Cap nhat thong tin HOAN TAT!");
        } else {
            System.out.println("-> Loi: Khong tim thay MA nhac cu nay!");
        }
    }

    public static void capNhatSoLuongTonKho() {
        System.out.println("\n--- CAP NHAT SO LUONG KHO ---");
        System.out.print("Nhap MA nhac cu can chinh so luong: "); 
        String maTim = sc.nextLine();
        
        NhacCu nc = qlNhacCu.timKiemNhacCu(maTim);

        if (nc != null) {
            System.out.println("-> San pham: " + nc.getTenNhacCu());
            System.out.println("-> So luong hien tai: " + nc.getSoLuong());
            System.out.print("Nhap so luong MOI trong kho: ");
            try {
                int slMoi = Integer.parseInt(sc.nextLine());
                if (slMoi >= 0) {
                    nc.capNhatSoLuongMoi(slMoi); 
                } else {
                    System.out.println("-> Loi: So luong khong duoc am!");
                }
            } catch (Exception e) {
                System.out.println("-> Loi: Vui long nhap so nguyen!");
            }
        } else {
            System.out.println("-> Loi: Khong tim thay MA nhac cu nay!");
        }
    }

    public static void timKiemNhacCu() {
        System.out.print("\nNhap MA nhac cu can tim: ");
        String maTim = sc.nextLine();
        
        NhacCu kq = qlNhacCu.timKiemNhacCu(maTim);
        
        if (kq != null) {
            System.out.println("\nKET QUA TIM KIEM:");
            kq.hienThiThongTin();
        } else {
            System.out.println("-> Khong tim thay!");
        }
    }

    public static void tinhGiaBanCuThe() {
        System.out.println("\n--- CHECK GIA BAN NHAC CU ---");
        System.out.print("Nhap MA nhac cu muon check gia: "); 
        String maCheck = sc.nextLine();
        
        NhacCu kq = qlNhacCu.timKiemNhacCu(maCheck);
        
        if (kq != null) {
            System.out.println("---------------------------------");
            System.out.println("San pham: " + kq.getTenNhacCu());
            System.out.printf("Gia Nhap (Goc): %.0f VND%n", kq.getGiaCoBan());
            System.out.printf("GIA BAN RA (Da cong lai): %.0f VND%n", kq.tinhGiaBan());
            System.out.println("---------------------------------");
        } else {
            System.out.println("Loi: Khong tim thay nhac cu nao co Ma la '" + maCheck + "'");
        }
    }

    public static void themNhacCuMoi() {
        System.out.println("\n--- THEM NHAC CU MOI ---");
        System.out.print("-> Ban muon them loai nao? (1: Guitar, 2: Piano): ");
        int loai = 0;
        try {
            loai = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Loi: Vui long nhap so 1 hoac 2!");
            return;
        }

        if (loai != 1 && loai != 2) {
            System.out.println("Lua chon khong hop le!");
            return;
        }

        System.out.print("Nhap Ma: "); String ma = sc.nextLine();
        System.out.print("Nhap Ten: "); String ten = sc.nextLine();
        System.out.print("Nhap Hang SX: "); String hang = sc.nextLine();
        System.out.print("Nhap Nam SX: "); int nam = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap Gia Co Ban: "); double gia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap So Luong: "); int sl = Integer.parseInt(sc.nextLine());

        if (loai == 1) { 
            System.out.print("Loai Guitar (Dien/Acoustic/Classic): "); String loaiDan = sc.nextLine();
            System.out.print("Loai Day (Sat/Nilon): "); String loaiDay = sc.nextLine();
            System.out.print("So Day (6/12): "); int soDay = Integer.parseInt(sc.nextLine());
            DanGuitar guitar = new DanGuitar(ma, ten, hang, nam, gia, sl, loaiDan, loaiDay, soDay);
            qlNhacCu.themNhacCu(guitar);
            System.out.println("-> Da them Guitar thanh cong!");
        } else if (loai == 2) { 
            System.out.print("Loai Piano (Upright/Grand/Digital): "); String loaiDan = sc.nextLine();
            DanPiano piano = new DanPiano(ma, ten, hang, nam, gia, sl, loaiDan);
            qlNhacCu.themNhacCu(piano);
            System.out.println("-> Da them Piano thanh cong!");
        }
    }

    // 2. MENU QUAN LY NHAN VIEN
    public static void menuNhanVien() {
        while (true) {
            System.out.println("\n--- [ QUAN LY NHAN VIEN ] ---");
            System.out.println("1. Them nhan vien moi");
            System.out.println("2. Xoa nhan vien ");
            System.out.println("3. Cap nhat thong tin "); 
            System.out.println("4. Tim kiem nhan vien ");
            System.out.println("5. Hien thi danh sach");
            System.out.println("6. Ghi du lieu ra file");            
            System.out.println("0. Quay lai menu chinh");
            System.out.print("-> Chon: ");
            
            int chon = 0;
            try { chon = Integer.parseInt(sc.nextLine()); } catch(Exception e) {}

            switch (chon) {
                case 1: 
                    System.out.print("Ho: "); String ho = sc.nextLine();
                    System.out.print("Ten: "); String ten = sc.nextLine();
                    System.out.print("Gioi tinh: "); String gt = sc.nextLine();
                    System.out.print("Ngay sinh: "); String ns = sc.nextLine();
                    System.out.print("SDT: "); String sdt = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Dia chi: "); String dc = sc.nextLine();
                    System.out.print("Ma NV: "); String ma = sc.nextLine();
                    System.out.print("Chuc vu: "); String cv = sc.nextLine();
                    System.out.print("Luong: "); double luong = Double.parseDouble(sc.nextLine());
                    
                    NhanVien nv = new NhanVien(ho, ten, gt, ns, sdt, email, dc, ma, cv, luong);
                    qlNhanVien.themNhanVien(nv);
                    break;

                case 2: 
                    System.out.print("Nhap Ma NV can xoa: ");
                    if(qlNhanVien.xoaNhanVien(sc.nextLine())) System.out.println("-> Da xoa!");
                    else System.out.println("-> Khong tim thay Ma NV.");
                    break;

                case 3: 
                    System.out.print("Nhap Ma NV can sua: ");
                    NhanVien nvTim = qlNhanVien.timKiemNhanVien(sc.nextLine());
                    if (nvTim != null) {
                        System.out.println("Tim thay: " + nvTim.getTen());
                        System.out.print("SDT moi (" + nvTim.getSDT() + "): ");
                        String sdtMoi = sc.nextLine();
                        if(!sdtMoi.isEmpty()) nvTim.setSdt(sdtMoi);

                        System.out.print("Luong moi (" + nvTim.getLuong() + "): ");
                        String luongMoi = sc.nextLine();
                        if(!luongMoi.isEmpty()) nvTim.setLuong(Double.parseDouble(luongMoi));
                        
                        System.out.println("-> Cap nhat xong!");
                    } else {
                        System.out.println("-> Khong tim thay!");
                    }
                    break;

                case 4: 
                    System.out.print("Nhap Ma NV can tim: ");
                    NhanVien kq = qlNhanVien.timKiemNhanVien(sc.nextLine());
                    if (kq != null) kq.hienThiThongTin();
                    else System.out.println("-> Khong tim thay!");
                    break;

                case 5: 
                    qlNhanVien.hienThiDanhSach();
                    break;

                case 6: 
                    qlNhanVien.WriteData("DanhSachNhanVien.txt");
                    break;

                case 0: return;
                default: System.out.println("Chon sai!");
            }
        }
    }

    // 3. MENU QUAN LY KHACH HANG 
    public static void menuKhachHang() {
        while (true) {
            System.out.println("\n--- [ QUAN LY KHACH HANG ] ---");
            System.out.println("1. Them khach hang moi");
            System.out.println("2. Xoa khach hang ");
            System.out.println("3. Cap nhat thong tin "); 
            System.out.println("4. Tim kiem khach hang ");
            System.out.println("5. Hien thi danh sach");
            System.out.println("6. Ghi du lieu ra file");               
            System.out.println("0. Quay lai menu chinh");
            System.out.print("-> Chon: ");
            
            int chon = 0;
            try { chon = Integer.parseInt(sc.nextLine()); } catch(Exception e) {}

            switch (chon) {
                case 1: 
                    System.out.print("Ho: "); String ho = sc.nextLine();
                    System.out.print("Ten: "); String ten = sc.nextLine();
                    System.out.print("Gioi tinh: "); String gt = sc.nextLine();
                    System.out.print("Ngay sinh: "); String ns = sc.nextLine();
                    System.out.print("SDT: "); String sdt = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Dia chi: "); String dc = sc.nextLine();
                    System.out.print("Ma KH: "); String ma = sc.nextLine();
                    System.out.print("Diem tich luy: "); int diem = Integer.parseInt(sc.nextLine());
                    
                    KhachHang kh = new KhachHang(ho, ten, gt, ns, sdt, email, dc, ma, diem);
                    qlKhachHang.themKhachHang(kh);
                    break;

                case 2: 
                    System.out.print("Nhap Ma KH can xoa: ");
                    if(qlKhachHang.xoaKhachHang(sc.nextLine())) System.out.println("-> Da xoa!");
                    else System.out.println("-> Khong tim thay Ma KH.");
                    break;

                case 3: 
                    System.out.print("Nhap Ma KH can sua: ");
                    KhachHang khTim = qlKhachHang.timKiemKhachHang(sc.nextLine());
                    if (khTim != null) {
                        System.out.println("Tim thay: " + khTim.getTen());
                        System.out.print("SDT moi (" + khTim.getSDT() + "): ");
                        String sdtMoi = sc.nextLine();
                        if(!sdtMoi.isEmpty()) khTim.setSdt(sdtMoi);

                        System.out.print("Diem tich luy moi (" + khTim.getDiemTichLuy() + "): ");
                        String diemMoi = sc.nextLine();
                        if(!diemMoi.isEmpty()) khTim.setDiemTichLuy(Integer.parseInt(diemMoi));
                        
                        System.out.println("-> Cap nhat xong!");
                    } else {
                        System.out.println("-> Khong tim thay!");
                    }
                    break;

                case 4: 
                    System.out.print("Nhap Ma KH can tim: ");
                    KhachHang kq = qlKhachHang.timKiemKhachHang(sc.nextLine());
                    if (kq != null) kq.hienThiThongTin();
                    else System.out.println("-> Khong tim thay!");
                    break;

                case 5: 
                    qlKhachHang.hienThiDanhSach();
                    break;

                case 6: 
                    qlKhachHang.WriteData("DanhSachKhachHang.txt");
                    break;

                case 0: return;
                default: System.out.println("Chon sai!");
            }
        }
    }
}