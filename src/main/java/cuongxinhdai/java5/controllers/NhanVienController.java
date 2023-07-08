package cuongxinhdai.java5.controllers;

import cuongxinhdai.java5.model.ChucVu;
import cuongxinhdai.java5.model.CuaHang;
import cuongxinhdai.java5.model.NhanVien;
import cuongxinhdai.java5.repository.ChucVuRepository;
import cuongxinhdai.java5.repository.CuaHangRepository;
import cuongxinhdai.java5.repository.NhanVienRepository;
import cuongxinhdai.java5.request.NhanVienVMD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class NhanVienController {
    @Autowired
    private NhanVienRepository nvRepo;
    @Autowired
    private NhanVienVMD vmd;
    @Autowired
    private ChucVuRepository cvRepo;
    @Autowired
    private CuaHangRepository chRepo;
@GetMapping("nhan_vien/index")
    public String index(Model model){
    model.addAttribute("danhSachNV",nvRepo.findAll());
        model.addAttribute("view","/views/nhan_vien/index.jsp");
        return "layout";
}
    @GetMapping("nhan_vien/create")
    public String create(Model model)
    {
        model.addAttribute("nv", vmd);
        model.addAttribute("action", "store");
        model.addAttribute("danhSachCV",cvRepo.findAll());
        model.addAttribute("danhSachCH",chRepo.findAll());
        model.addAttribute("view","/views/nhan_vien/creates.jsp");
        return "layout";
    }
    @PostMapping("nhan_vien/store")
    public String store(Model model,
            @Valid  @ModelAttribute("nv") NhanVienVMD vmd,
            BindingResult result

    ) {
        if (result.hasErrors()) {
            System.out.println( result.getAllErrors().get(0).toString() );
            model.addAttribute("nv",vmd);
            model.addAttribute("action", "/nhan_vien/store");
            model.addAttribute("danhSachCH", chRepo.findAll() );
            model.addAttribute("danhSachCV", cvRepo.findAll() );
            model.addAttribute("view","/views/nhan_vien/creates.jsp");
            return "layout";
        }

        NhanVien nv = new NhanVien();
        nv.loadFromVMD(vmd);
        CuaHang entity = this.chRepo.findById(vmd.getCuaHangVMD()).get();
        nv.setCuaHang(entity);
        ChucVu entity1 = this.cvRepo.findById(vmd.getChucVuVMD()).get();
        nv.setChucVu(entity1);
        this.nvRepo.save(nv);
        return "redirect:/nhan_vien/index";
    }
    @GetMapping("nhan_vien/delete/{id}")
    public String delete(@PathVariable("id")  NhanVien nhanVien)
    {
        this.nvRepo.delete(nhanVien);
        return "redirect:/nhan_vien/index";
    }

    @GetMapping("nhan_vien/edit/{id}")
    public String edit(
            @PathVariable("id") NhanVien nv,
            Model model
    ) {
        vmd.loadFromEntity(nv);
        model.addAttribute("nv", vmd);
        model.addAttribute("action", "/nhan_vien/update/" + nv.getId());
        model.addAttribute("danhSachCH", chRepo.findAll() );
        model.addAttribute("danhSachCV", cvRepo.findAll() );
        model.addAttribute("view","/views/nhan_vien/creates.jsp");
        return "layout";
    }

    @PostMapping("nhan_vien/update/{id}")
    public String update(
            @PathVariable("id") NhanVien nhanVien,
            @Valid NhanVienVMD vmd,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            vmd.loadFromEntity(nhanVien);
            model.addAttribute("nv", vmd);
            model.addAttribute("action", "/nhan_vien/update/" + nhanVien.getId());
            model.addAttribute("danhSachCH", chRepo.findAll() );
            model.addAttribute("danhSachCV", cvRepo.findAll() );
            model.addAttribute("view","/views/nhan_vien/creates.jsp");
            return "layout";
        } else {

            nhanVien.loadFromVMD(vmd);
            nhanVien.setId(nhanVien.getId());
            CuaHang entity = this.chRepo.findById(vmd.getCuaHangVMD()).get();
            nhanVien.setCuaHang(entity);
            ChucVu idChucVu = this.cvRepo.findById(vmd.getChucVuVMD()).get();
            nhanVien.setChucVu(idChucVu);
            this.nvRepo.save(nhanVien);
            return "redirect:/nhan_vien/index";
        }
    }
}

