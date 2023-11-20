package lab9.ex2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	private List<AnPham> dsAnPham;
	public DanhMucAnPham(List<AnPham> dsAnPham) {
        this.dsAnPham = dsAnPham;
    }
    public boolean loaiAnPham(SachThamKhao anPham) {
        return anPham.getLoaiAnPham().equals("Sach tham khao");
    }
    public boolean coPhaiTapChiVaSanXuatCach10Nam(TapChi tapChi) {
        int year = 2021;
        return (year - tapChi.namXuatBan >= 10);
    }
    public boolean coCungLoaiVaCungTacGia(AnPham anPham1, AnPham anPham2) {
        return  anPham1.getTacGia().equals(anPham2.getTacGia()) &&
                anPham1.getLoaiAnPham().equals(anPham2.getLoaiAnPham());
    }
    public int tongTien(){
        int sum = 0;
        for (AnPham anPham : dsAnPham) {
            sum += anPham.getGiatien();
        }
        return sum;
    }
    public SachThamKhao sachCoSoTrangNhieuNhat() {
        SachThamKhao sachThamKhao = null;
        int max = 0;
        for (AnPham anPham : dsAnPham) {
            if (anPham instanceof SachThamKhao) {
                SachThamKhao sach = (SachThamKhao) anPham;
                if (sach.getSoTrang() > max) {
                    max = sach.getSoTrang();
                    sachThamKhao = sach;
                }
            }
        }
        return sachThamKhao;
    }
    public boolean timTapChiBoiTen(String tenTapChi){
        for (AnPham anPham : dsAnPham) {
            if (anPham instanceof TapChi) {
                TapChi tapChi = (TapChi) anPham;
                if (tapChi.getTenTapChi().equals(tenTapChi)) {
                    return true;
                }
            }
        }
        return false;
    }
    public List<TapChi> tapChiXuatBanMotNamTruoc(int year){
        List<TapChi> dsTapChi = new ArrayList<>();
        for(AnPham anPham : dsAnPham) {
            if (anPham instanceof TapChi) {
                TapChi tapChi = (TapChi) anPham;
                if (tapChi.getNamXuatBan() == year) {
                    dsTapChi.add(tapChi);
                }
            }
        }
        return dsTapChi;
    }
    public void sapXepTangDanTieuDeVaGiamDanTheoNamXuatBan(){
        dsAnPham.sort(new Comparator<AnPham>() {
            @Override
            public int compare(AnPham o1, AnPham o2) {
                if (o1.getTieuDe().compareTo(o2.getTieuDe()) == 0) {
                    return o2.getNamXuatBan() - o1.getNamXuatBan();
                }
                return o1.getTieuDe().compareTo(o2.getTieuDe());
            }
        });
    }
    public Map<Integer,Integer> thongkeSoLuongAnPhamTheoNamXuatBan(){
        Map<Integer,Integer> map = new java.util.HashMap<>();
        for(AnPham anPham : dsAnPham) {
            int year = anPham.getNamXuatBan();
            if (map.containsKey(year)) {
                map.put(year, map.get(year) + 1);
            } else {
                map.put(year, 1);
            }
        }
        return map;
    }
}