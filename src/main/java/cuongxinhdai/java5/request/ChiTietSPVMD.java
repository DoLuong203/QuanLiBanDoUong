package cuongxinhdai.java5.request;

import cuongxinhdai.java5.model.ChiTietSP;
import cuongxinhdai.java5.model.NhanVien;
import jakarta.validation.constraints.NotBlank;
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
public class ChiTietSPVMD {

    private UUID sanPhamVMD;
    private UUID nsxVMD;
    private UUID mauSacVMD;
    private UUID dspVMD;
    @NotNull(message = "Không được để trống")
    private int namBH;
    @NotEmpty(message = "Không được để trống")
    private String moTa;
    @NotNull(message = "Không được để trống")
    private int soLuongTon;
    @NotNull(message = "Không được để trống")
    private int giaNhap;
    @NotNull(message = "Không được để trống")
    private int giaBan;
    public void loadFromEntity(ChiTietSP ctsp)
    {
        this.setSanPhamVMD(ctsp.getSanPham().getId());
        this.setNsxVMD(ctsp.getNsx().getId());
        this.setMauSacVMD(ctsp.getMauSac().getId());
        this.setDspVMD(ctsp.getDsp().getId());
        this.setNamBH( ctsp.getNamBH() );
        this.setMoTa(ctsp.getMoTa());
        this.setSoLuongTon(ctsp.getSoLuongTon());
        this.setGiaNhap(ctsp.getGiaNhap());
        this.setGiaBan(ctsp.getGiaBan());
    }
}
