package cuongxinhdai.java5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="KhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class KhachHang {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private UUID id;
    @Column(name="Ma")
    private String ma;
    @Column(name="Ten")
    private String ten;
    @Column(name="TenDem")
    private String tenDem;
    @Column(name="Ho")
    private String ho;
    @Column(name="NgaySinh")
    private String ngaySinh;
    @Column(name="Sdt")
    private String Sdt;
    @Column(name="DiaChi")
    private String diaChi;
    @Column(name="ThanhPho")
    private String thanhPho;
    @Column(name="QuocGia")
    private String quocGia;
    @Column(name="MatKhau")
    private String matKhau;

    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> listHd;
}
