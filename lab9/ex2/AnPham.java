package lab9.ex2;

public class AnPham {
    protected String tieuDe;
	protected int soTrang;
	protected int namXuatBan;
	protected String tacGia;
	protected int giatien;
	public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giatien) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.giatien = giatien;
	};
    public String getTieuDe() {
        return tieuDe;
    }
    public int getSoTrang() {
        return soTrang;
    }
    public int getNamXuatBan() {
        return namXuatBan;
    }
    public String getTacGia() {
        return tacGia;
    }
    public int getGiatien() {
        return giatien;
    }
    public String getLoaiAnPham() {
        return "An pham";
    }

}
