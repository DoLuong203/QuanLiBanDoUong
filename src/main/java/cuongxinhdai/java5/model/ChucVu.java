package cuongxinhdai.java5.model;

import cuongxinhdai.java5.request.ChucVuVMD;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChucVu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChucVu {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "chucVu")
    private List<NhanVien> listNv;

public void loadFormVMD(ChucVuVMD vmd){
    this.setMa(vmd.getMa());
    this.setTen(vmd.getTen());
}
}
