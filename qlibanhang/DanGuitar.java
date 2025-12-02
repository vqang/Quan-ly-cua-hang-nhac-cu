package qlibanhang;

public class DanGuitar extends NhacCu  {
    private String loaiDan;
    private String loaiDay;
    private int soDay;
    
    public DanGuitar() {
    }

    public DanGuitar(String maNhacCu, String tenNhacCu, String hangSX, int namSX,
                     double giaCoBan, int soLuong, String loaiDan, String loaiDay, int soDay) {
        super(maNhacCu, "Guitar", tenNhacCu, hangSX, namSX, giaCoBan, soLuong);
        this.loaiDan = loaiDan;
        this.loaiDay = loaiDay;
        this.soDay = soDay;
    }

    public String getLoaiDan() {
        return loaiDan;
    }
    public String getLoaiDay() {
        return loaiDay;
    }
    public int getSoDay() {
        return soDay;
    }
    public void setLoaiDan(String loaiDan) {
        this.loaiDan = loaiDan;
    }
    public void setLoaiDay(String loaiDay) {
        this.loaiDay = loaiDay;
    }
    public void setSoDay(int soDay) {
        this.soDay = soDay;
    }

    @Override
    public void hienThiThongTin() {
        System.out.printf("GUITAR | Ma: %s | Ten: %s | Gia: %.0f | Loai: %s | Day: %s (%d day)%n", 
                          maNhacCu, tenNhacCu, tinhGiaBan(), loaiDan, loaiDay, soDay);
    }

    @Override
    public double tinhGiaBan() {
        return giaCoBan * 1.2; 
    }
    
    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        boolean ketQua = super.kiemTraTonKho(soLuongToiThieu);
        if (!ketQua) {
            System.out.println("Canh bao : Dan Guitar dang thieu hang.");
        }
        return ketQua;
    }

    @Override
    public void capNhatSoLuongMoi(int soLuongMoi) {
        super.capNhatSoLuongMoi(soLuongMoi);
        System.out.println("-> Da cap nhat kho Guitar xong.");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | LoaiDan:%s | LoaiDay:%s | SoDay:%d",
                loaiDan, loaiDay, soDay);
    }
}
