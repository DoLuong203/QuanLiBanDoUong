package cuongxinhdai.java5.model;

import cuongxinhdai.java5.request.SanPhamVMD;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ValueGenerationType;

import java.util.UUID;

@Entity
@Table(name="SanPham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {
@Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
@Column(name="Ma")
    private String ma;
@Column(name="Ten")
    private String ten;
public void loadFormVMD(SanPhamVMD vmd){
    this.setMa(vmd.getMa());
    this.setTen(vmd.getTen());
}
}
