package qlibanhang;

public abstract class Nguoi {
    protected String ho;
    protected String ten;
    protected String gioiTinh;
    protected String ngaySinh;
    protected String SDT;
    protected String email;
    protected String diaChi;

    public Nguoi() {
    }

    public Nguoi(String ho, String ten, String gioiTinh,String ngaySinh, String SDT, String email, String diaChi) {
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.setSdt(SDT); // Gọi hàm setSdt để đảm bảo dữ liệu đầu vào được kiểm tra ngay từ khi khởi tạo
        this.email = email;
        this.diaChi = diaChi;
    }
    // Getters and Setters
    public String getHo() {
        return ho;
    }
    public void setHo(String ho) {
        this.ho = ho;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getSDT() {
        return SDT;
    }
    public void setSdt(String SDT) {
        if (SDT != null && SDT.length() >= 10) { // Ví dụ: SĐT phải dài hơn 10 số
            this.SDT = SDT;
        } else {
            System.out.println("So dien thoai khong hop le!");
        }
    }

    public void hienThiThongTin() {
        System.out.printf("Ho ten: %s %s |  Gioi tinh:%s | Ngay sinh: %s | SDT: %s | Email: %s | D/C: %s%n", 
                          ho, ten, gioiTinh, ngaySinh, SDT, email, diaChi);
    }
    
    @Override
    public String toString() {
        return String.format("Ho:%s | Ten:%s | GioiTinh:%s | ngaySinh:%s | SDT:%s | Email:%s | DiaChi:%s",
                ho, ten, gioiTinh, ngaySinh, SDT, email, diaChi);
    }
}
