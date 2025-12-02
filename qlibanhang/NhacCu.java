package qlibanhang;

public abstract class NhacCu implements IGiaBan, IKiemKe {
    protected String maNhacCu;
    protected String loaiNhacCu;
    protected String tenNhacCu;
    protected String hangSX;
    protected int namSX;
    protected double giaCoBan;
    protected int soLuong;

    public NhacCu() {}
    
    public NhacCu(String maNhacCu, String loaiNhacCu, String tenNhacCu, String hangSX, int namSX, double giaCoBan, int soLuong) {
        this.maNhacCu = maNhacCu;
        this.loaiNhacCu = loaiNhacCu;
        this.tenNhacCu = tenNhacCu;
        this.hangSX = hangSX;
        this.namSX = namSX;
        this.giaCoBan = giaCoBan;
        this.soLuong = soLuong;
    }

    public String getMaNhacCu() {
        return maNhacCu; }
    public void setMaNhacCu(String maNhacCu) {
        this.maNhacCu = maNhacCu; }
    public String getLoaiNhacCu() {
        return loaiNhacCu; }
    public void setLoaiNhacCu(String loaiNhacCu) {
        this.loaiNhacCu = loaiNhacCu; }
    public String getTenNhacCu() {
        return tenNhacCu; } 
    public void setTenNhacCu(String tenNhacCu) {
        this.tenNhacCu = tenNhacCu; }
    public String getHangSX() {
        return hangSX; }    
    public void setHangSX(String hangSX) {
        this.hangSX = hangSX; }
    public int getNamSX() {
        return namSX; }
    public void setNamSX(int namSX) {
        this.namSX = namSX; }
    public double getGiaCoBan() {
        return giaCoBan; }  
    public void setGiaCoBan(double giaCoBan) {
        this.giaCoBan = giaCoBan; } 
    public int getSoLuong() {
        return soLuong; }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong; }

    public void hienThiThongTin() {
        System.out.printf("Ma: %s | Ten: %s | Gia ban: %.0f VND%n", maNhacCu, tenNhacCu, tinhGiaBan());
    }

    @Override
    public abstract double tinhGiaBan(); 

    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        return this.soLuong >= soLuongToiThieu;
    }

    @Override
    public void capNhatSoLuongMoi(int soLuongMoi) {
        this.soLuong = soLuongMoi;
        System.out.println("Da cap nhat so luong moi: " + soLuongMoi);
    }

    @Override
    public String toString() {
        return String.format("Ma:%s | Loai:%s | Ten:%s | HangSX:%s | NamSX:%d | GiaCoBan:%.0f | SoLuong:%d",
                maNhacCu, loaiNhacCu, tenNhacCu, hangSX, namSX, giaCoBan, soLuong);
    }
}

