package cuongxinhdai.java5.model;

import cuongxinhdai.java5.request.NhanVienVMD;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="NhanVien")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NhanVien {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name="Ma")
    private String ma;
    @Column(name="Ten")
    private String ten;
    @Column(name="TenDem")
    private String tenDem;
    @Column(name="Ho")
    private String ho;
    @Column(name="GioiTinh")
    private String gioiTinh;
    @Column(name="NgaySinh")
    private String ngaySinh;
    @Column(name="Sdt")
    private String Sdt;
    @Column(name="DiaChi")
    private String diaChi;
    @Column(name="MatKhau")
    private String matKhau;
    @ManyToOne
    @JoinColumn(name = "IdCV")

    public ChucVu chucVu;
    @ManyToOne
    @JoinColumn(name = "IdCH")
    public CuaHang cuaHang;
    @OneToMany(mappedBy = "nhanVien")
    private List<HoaDon> listHd;
    public void loadFromVMD(NhanVienVMD vmd)
    {
        this.setMa( vmd.getMa() );
        this.setTen( vmd.getTen() );
       this.setTenDem(vmd.getTenDem());
       this.setHo(vmd.getHo());
       this.setGioiTinh(vmd.getGioiTinh());
       this.setNgaySinh(vmd.getNgaySinh());
       this.setSdt(vmd.getSdt());
       this.setMatKhau(vmd.getMatKhau());
        this.setDiaChi( vmd.getDiaChi() );

    }
}
