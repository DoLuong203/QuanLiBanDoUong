package cuongxinhdai.java5.request;

import cuongxinhdai.java5.model.ChucVu;
import cuongxinhdai.java5.model.SanPham;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class SanPhamVMD {
    @NotEmpty(message = "Khoong duoc de trong")
    private String ma;
    @NotEmpty(message = "Khong duoc de trong")
    private String ten;
    public void loadFromEntity(SanPham sp){
this.setMa(sp.getMa());
this.setTen(sp.getTen());
    }
}
