package cuongxinhdai.java5.controllers;

import cuongxinhdai.java5.model.*;
import cuongxinhdai.java5.repository.*;
import cuongxinhdai.java5.request.HoaDonVMD;
import cuongxinhdai.java5.request.NhanVienVMD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HoaDonController {
    @Autowired
    private HoaDonRepository hdRepo;
    @Autowired
    private HoaDonVMD vmd;
    @Autowired
    private KhachHangRepository khRepo;
    @Autowired
    private NhanVienRepository nvRepo;

    @GetMapping("hoa_don/index")
    public String index(Model model) {
        model.addAttribute("danhSachHD", hdRepo.findAll());
            model.addAttribute("view","/views/hoa_don/index.jsp");
            return "layout";

    }

    @GetMapping("hoa_don/create")
    public String create(Model model) {
        model.addAttribute("hd", vmd);
        model.addAttribute("action", "store");
        model.addAttribute("danhSachKH", khRepo.findAll());
        model.addAttribute("danhSachNV", nvRepo.findAll());
        model.addAttribute("view","/views/hoa_don/creates.jsp");
        return "layout";
    }

    @PostMapping("hoa_don/store")
    public String store(Model model,
                        @Valid @ModelAttribute("hd") HoaDonVMD vmd,
                        BindingResult result

    ) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors().get(0).toString());
            model.addAttribute("hd", vmd);
            model.addAttribute("action", "/hoa_don/store");
            model.addAttribute("danhSachKH", khRepo.findAll());
            model.addAttribute("danhSachNV", nvRepo.findAll());
            model.addAttribute("view","/views/hoa_don/creates.jsp");
            return "layout";
        }

        HoaDon hd = new HoaDon();
        hd.loadFromVMD(vmd);
        KhachHang entity = this.khRepo.findById(vmd.getKhachHangVMD()).get();
        hd.setKhachHang(entity);
        NhanVien idNhanVien = this.nvRepo.findById(vmd.getNhanVienVMD()).get();
        hd.setNhanVien(idNhanVien);
        this.hdRepo.save(hd);
        return "redirect:/hoa_don/index";
    }

    @GetMapping("hoa_don/delete/{id}")
    public String delete(@PathVariable("id") HoaDon hoaDon) {
        this.hdRepo.delete(hoaDon);
        return "redirect:/hoa_don/index";
    }

    @GetMapping("hoa_don/edit/{id}")
    public String edit(
            @PathVariable("id") HoaDon hd,
            Model model
    ) {
        vmd.loadFromEntity(hd);
        model.addAttribute("hd", vmd);
        model.addAttribute("action", "/hoa_don/update/" + hd.getId());
        model.addAttribute("danhSachKH", khRepo.findAll());
        model.addAttribute("danhSa  chNV", nvRepo.findAll());
        model.addAttribute("view","/views/hoa_don/creates.jsp");
        return "layout";
    }

    @PostMapping("hoa_don/update/{id}")
    public String update(
            @PathVariable("id") HoaDon hoaDon,
            @Valid HoaDonVMD vmd,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            vmd.loadFromEntity(hoaDon);
            model.addAttribute("hd", vmd);
            model.addAttribute("action", "/hoa_don/update/" + hoaDon.getId());
            model.addAttribute("danhSachKH", khRepo.findAll());
            model.addAttribute("danhSachNV", nvRepo.findAll());
            model.addAttribute("view","/views/hoa_don/creates.jsp");
            return "layout";
        } else {

            hoaDon.loadFromVMD(vmd);
            hoaDon.setId(hoaDon.getId());
            KhachHang entity = this.khRepo.findById(vmd.getKhachHangVMD()).get();
           hoaDon.setKhachHang(entity);
            NhanVien idNhanVien = this.nvRepo.findById(vmd.getNhanVienVMD()).get();
            hoaDon.setNhanVien(idNhanVien);
            this.hdRepo.save(hoaDon);
            return "redirect:/hoa_don/index";
        }
    }
}
