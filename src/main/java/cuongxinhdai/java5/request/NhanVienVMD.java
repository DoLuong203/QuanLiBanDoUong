package cuongxinhdai.java5.request;

import cuongxinhdai.java5.model.ChucVu;
import cuongxinhdai.java5.model.NhanVien;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class NhanVienVMD {

    @NotEmpty(message = "Không được để trống")
    private String ma;
    @NotEmpty(message = "Không được để trống")
    private String ten;
    @NotEmpty(message = "Không được để trống")
    private String tenDem;
    @NotEmpty(message = "Không được để trống")
    private String ho;

    private String gioiTinh;
    @NotEmpty(message = "Không được để trống")
    private String ngaySinh;
    @NotEmpty(message = "Không được để trống")
    private String Sdt;
    @NotEmpty(message = "Không được để trống")
    private String diaChi;
    //@NotEmpty(message = "Không được để trống")
    private UUID chucVuVMD;
    private UUID cuaHangVMD;
    @NotEmpty(message = "Không được để trống")
    private String matKhau;

    public void loadFromEntity(NhanVien nv)
    {
        this.setChucVuVMD(nv.getChucVu().getId());
        this.setMa( nv.getMa() );
        this.setTen( nv.getTen() );
        this.setTenDem(nv.getTenDem());
        this.setHo(nv.getHo());
        this.setGioiTinh(nv.getGioiTinh());
        this.setNgaySinh(nv.getNgaySinh());
        this.setSdt(nv.getSdt());
        this.setMatKhau(nv.getMatKhau());
        this.setDiaChi( nv.getDiaChi() );
        this.setCuaHangVMD(nv.getCuaHang().getId());
    }
}
