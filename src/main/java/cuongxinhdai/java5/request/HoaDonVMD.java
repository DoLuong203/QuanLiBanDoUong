package cuongxinhdai.java5.request;


import cuongxinhdai.java5.model.HoaDon;
import cuongxinhdai.java5.model.NhanVien;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class HoaDonVMD {
//@NotEmpty(message = "không được để trống")
    private UUID khachHangVMD;
  //  @NotEmpty(message = "không được để trống")
    private UUID nhanVienVMD;
    @NotEmpty(message = "không được để trống")
    private String ma;
    @NotEmpty(message = "không được để trống")
    private String ngayTao;
    @NotEmpty(message = "không được để trống")
    private String ngayThanhToan;
    @NotEmpty(message = "không được để trống")
    private String ngayShip;
    @NotEmpty(message = "không được để trống")
    private String ngayNhan;
  //  @NotEmpty(message = "không được để trống")
    private Integer tinhTrang;
    @NotEmpty(message = "không được để trống")
    private String tenNguoiNhan;
    @NotEmpty(message = "không được để trống")
    private String diaChi;
    @NotEmpty(message = "không được để trống")
    private String sdt;
    public void loadFromEntity(HoaDon hd)
    {
        this.setKhachHangVMD(hd.getKhachHang().getId());
        this.setNhanVienVMD(hd.getNhanVien().getId());
        this.setMa(hd.getMa());
        this.setNgayTao( hd.getNgayTao() );
        this.setNgayThanhToan(hd.getNgayThanhToan());
        this.setNgayShip(hd.getNgayShip());
        this.setNgayNhan(hd.getNgayNhan());
        this.setTinhTrang(hd.getTinhTrang());
        this.setSdt(hd.getSdt());
        this.setDiaChi( hd.getDiaChi() );
        this.setTenNguoiNhan(hd.getTenNguoiNhan());
    }
}
