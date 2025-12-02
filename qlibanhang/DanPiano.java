package qlibanhang;

public class DanPiano extends NhacCu {
    private String loaiDan;

    public DanPiano(){
    }

    public DanPiano(String maNhacCu, String tenNhacCu, String hangSX, int namSX, 
                    double giaCoBan, int soLuong, String loaiDan) {
        
        super(maNhacCu, "Piano", tenNhacCu, hangSX, namSX, giaCoBan, soLuong);
        this.loaiDan = loaiDan;
    }

    public String getLoaiDan() {
        return loaiDan;
    }
    public void setLoaiDan(String loaiDan) {
        this.loaiDan = loaiDan;
    }

    @Override
    public double tinhGiaBan() {
        return this.giaCoBan * 1.15;
    }

    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        boolean ketQua = super.kiemTraTonKho(soLuongToiThieu);
        if (!ketQua) {
            System.out.println(" Canh bao : Dan Piano dang thieu hang dong " + loaiDan);
        }
        return ketQua;
    }

    @Override
    public void capNhatSoLuongMoi(int soLuongMoi) {
        super.capNhatSoLuongMoi(soLuongMoi);
        System.out.println("-> Da cap nhat kho Piano xong.");
    }

    @Override
    public void hienThiThongTin() {
        System.out.printf("PIANO  | Ma: %s | Ten: %s | Gia: %.0f | Loai: %s%n", 
                          maNhacCu, tenNhacCu, tinhGiaBan(), loaiDan);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | LoaiDan:%s", loaiDan);
    }
}
