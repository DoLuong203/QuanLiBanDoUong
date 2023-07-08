package cuongxinhdai.java5.request;

import cuongxinhdai.java5.model.CuaHang;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CuaHangVMD {
    @NotBlank(message = "Không được để trống")
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;

    @NotBlank(message = "Không được để trống")
    private String diaChi;

    @NotBlank
    private String thanhPho;

    @NotBlank
    private String quocGia;

    public void loadFromEntity(CuaHang ch) {
        this.setMa(ch.getMa());
        this.setTen(ch.getTen());
        this.setThanhPho(ch.getThanhPho());
        this.setQuocGia(ch.getQuocGia());
        this.setDiaChi(ch.getDiaChi());
    }
}
