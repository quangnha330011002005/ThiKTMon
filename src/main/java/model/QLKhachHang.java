package model;

import java.util.ArrayList;
import util.FileHelper;
/*
  Tác giả: Trần Quang Nhã
*/
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    //sinh viên cải đặt cho các phương thức xử lý sau
   
    public void DocKhachHang(String filename) {
        ArrayList<String>input= FileHelper.readFileText(filename);
        dsKhachHang.clear();
        for(String item:input){
            String[]arr=item.split(";");
            KhachHang kh=new KhachHang();
            
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setLoai(Integer.parseInt(arr[2]));
            kh.setChisocu(Double.valueOf(arr[3]));
            kh.setChisomoi(Double.valueOf(arr[4]));
            dsKhachHang.add(kh);
        }
        
        
        
    }

    public boolean GhiHoaDon(String filename) {
        
       ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getLoai() + ";" + kh.getChisocu()+";"+kh.getChisomoi();
            data.add(info);
        }
        return FileHelper.writeFileText(filename, data);
    }
   
    public void sapXepTheoLoaiHinh() {
               
    }
    
    public double getTieuThuCaoNhat()
    {
      return 0;    
    }
    
    public double getTieuThuThapNhat()
    {
       return 0;  
    }
    
    public double getTieuThuTrungBinh()
    {
      double TongKwh=0;
      for(KhachHang kh:dsKhachHang){
          TongKwh+=kh.getTieuThu();
      }
      return TongKwh/dsKhachHang.size();
    }
}
