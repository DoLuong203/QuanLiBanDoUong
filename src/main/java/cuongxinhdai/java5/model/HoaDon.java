package cuongxinhdai.java5.model;

import cuongxinhdai.java5.request.HoaDonVMD;
import cuongxinhdai.java5.request.NhanVienVMD;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="HoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name="IdKH")
    public KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "IdNV")
    public NhanVien nhanVien;
    @Column(name="Ma")
    private String ma;
    @Column(name="NgayTao")
    private String ngayTao;
    @Column(name="NgayThanhToan")
    private String ngayThanhToan;
    @Column(name="NgayShip")
    private String ngayShip;
    @Column(name="NgayNhan")
    private String ngayNhan;
    @Column(name="TinhTrang")
    private Integer tinhTrang;
    @Column(name="TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name="DiaChi")
    private String diaChi;
    @Column(name="Sdt")
    private String sdt;
    public void loadFromVMD(HoaDonVMD vmd)
    {
        this.setMa( vmd.getMa() );
        this.setTenNguoiNhan( vmd.getTenNguoiNhan() );
        this.setMa(vmd.getMa());
        this.setNgayTao(vmd.getNgayTao());
        this.setNgayThanhToan(vmd.getNgayThanhToan());
        this.setNgayShip(vmd.getNgayShip());
        this.setSdt(vmd.getSdt());
        this.setNgayNhan(vmd.getNgayNhan());
        this.setDiaChi( vmd.getDiaChi() );
        this.setTinhTrang(vmd.getTinhTrang());
    }
}
