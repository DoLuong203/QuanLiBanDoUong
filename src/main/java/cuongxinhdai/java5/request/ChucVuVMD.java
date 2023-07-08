package cuongxinhdai.java5.request;

import cuongxinhdai.java5.model.ChucVu;
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
public class ChucVuVMD {
    @NotEmpty(message = "Không được đẻ trống")
    private String ma;
    @NotEmpty(message = "Không được đẻ trống")
    private String ten;

    public void loadFromEntity(ChucVu cv){
        this.setMa(cv.getMa());
        this.setTen(cv.getTen());
    }
}
