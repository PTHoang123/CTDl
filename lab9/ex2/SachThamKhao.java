package lab9.ex2;

import java.util.List;

public class SachThamKhao extends AnPham{
	
	private String linhVuc;
	private List<ChuongSach> dsChuongSach;
	public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giatien, String linhVuc, List<ChuongSach> dsChuongSach) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giatien);
		this.linhVuc = linhVuc;
		this.dsChuongSach = dsChuongSach;
	}
    @Override
    public String getLoaiAnPham() {
        return "Sach tham khao";
    }
}
