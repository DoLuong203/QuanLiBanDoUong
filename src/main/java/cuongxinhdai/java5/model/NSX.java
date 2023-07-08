package cuongxinhdai.java5.model;

import cuongxinhdai.java5.request.ChucVuVMD;
import cuongxinhdai.java5.request.NSXVMD;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "NSX")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NSX {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;

    public void loadFormVMD(NSXVMD vmd){
        this.setMa(vmd.getMa());
        this.setTen(vmd.getTen());
    }
}
