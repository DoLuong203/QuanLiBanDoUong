package cuongxinhdai.java5.request;

import cuongxinhdai.java5.model.ChucVu;
import cuongxinhdai.java5.model.MauSac;
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
public class MauSacVMD {
    @NotEmpty(message = "Không được đẻ trống")
    private String ma;
    @NotEmpty(message = "Không được đẻ trống")
    private String ten;

    public void loadFromEntity(MauSac ms){
        this.setMa(ms.getMa());
        this.setTen(ms.getTen());
    }
}
