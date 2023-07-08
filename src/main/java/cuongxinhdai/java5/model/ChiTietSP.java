package cuongxinhdai.java5.model;

import cuongxinhdai.java5.request.ChiTietSPVMD;
import cuongxinhdai.java5.request.HoaDonVMD;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="ChiTietSP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietSP {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name="IdSP")
    public SanPham sanPham;
    @ManyToOne
    @JoinColumn(name = "IdNSX")
    public NSX nsx;
    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    public MauSac mauSac;
    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    public DongSP dsp;
    @Column(name="NamBH")
    private int namBH;
    @Column(name="MoTa")
    private String moTa;
    @Column(name="SoLuongTon")
    private int soLuongTon;
    @Column(name="GiaNhap")
    private int giaNhap;
    @Column(name="GiaBan")
    private int giaBan;
    public void loadFromVMD(ChiTietSPVMD vmd)
    {
        this.setNamBH( vmd.getNamBH() );
        this.setMoTa(vmd.getMoTa());
        this.setSoLuongTon(vmd.getSoLuongTon());
        this.setGiaNhap(vmd.getGiaNhap());
        this.setGiaBan(vmd.getGiaBan());
    }
}
