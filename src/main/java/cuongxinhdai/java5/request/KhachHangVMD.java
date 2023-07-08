package cuongxinhdai.java5.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class KhachHangVMD {
   // private UUID Id;
    @NotEmpty(message = "Khong duoc de trong")
    private String ma;

    @NotEmpty(message = "Khong duoc de trong")
    private String ten;
  @NotEmpty(message = "Khong duoc de trong")
  private String tenDem;
  @NotEmpty(message = "Khong duoc de trong")
  private String ho;
    @NotEmpty(message = "Khong duoc de trong")
    private String ngaySinh;
    @NotEmpty(message = "Khong duoc de trong")
    private String Sdt;
    @NotEmpty(message = "Khong duoc de trong")
    private String diaChi;
    @NotEmpty(message = "Khong duoc de trong")

    private String thanhPho;
    @NotEmpty(message = "Khong duoc de trong")
    private String quocGia;
  @NotEmpty(message = "Khong duoc de trong")
  private String matKhau;

}
