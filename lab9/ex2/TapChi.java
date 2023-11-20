package lab9.ex2;

public class TapChi extends AnPham {
	private String tenTapChi;
	public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giatien, String tenTapChi) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giatien);
		this.tenTapChi = tenTapChi;
	}
    public String getTenTapChi() {
        return tenTapChi;
    }
    @Override
    public String getLoaiAnPham() {
        return "Tap chi";
    }
}