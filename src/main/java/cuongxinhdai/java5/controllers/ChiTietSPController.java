package cuongxinhdai.java5.controllers;

import cuongxinhdai.java5.model.*;
import cuongxinhdai.java5.repository.*;
import cuongxinhdai.java5.request.ChiTietSPVMD;
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
public class ChiTietSPController {
    @Autowired
    private ChiTietSPRepository ctspRepo;
    @Autowired
    private ChiTietSPVMD vmd;
    @Autowired
    private SanPhamRepository spRepo;
    @Autowired
    private NSXRepository nsxRepo;
    @Autowired
    private DongSPRepository dspRepo;
    @Autowired
    private MauSacRepository msRepo;
@GetMapping("ctsp/index")
    public String index(Model model){
    model.addAttribute("danhSachCTSP",ctspRepo.findAll());
model.addAttribute("view","/views/ctsp/index.jsp");
    return "layout";
}
    @GetMapping("ctsp/create")
    public String create(Model model)
    {
        model.addAttribute("ctsp", vmd);
        model.addAttribute("action", "store");
        model.addAttribute("danhSachMS",msRepo.findAll());
        model.addAttribute("danhSachNSX",nsxRepo.findAll());
        model.addAttribute("danhSachDSP",dspRepo.findAll());
        model.addAttribute("danhSachSP",spRepo.findAll());
        model.addAttribute("view","/views/ctsp/creates.jsp");
        return "layout";
    }
    @PostMapping("ctsp/store")
    public String store(Model model,
            @Valid  @ModelAttribute("ctsp") ChiTietSPVMD vmd,
            BindingResult result

    ) {
        if (result.hasErrors()) {
            System.out.println( result.getAllErrors().get(0).toString() );
            model.addAttribute("ctsp",vmd);
            model.addAttribute("action", "/ctsp/store");
            model.addAttribute("danhSachMS",msRepo.findAll());
            model.addAttribute("danhSachNSX",nsxRepo.findAll());
            model.addAttribute("danhSachDSP",dspRepo.findAll());
            model.addAttribute("danhSachSP",spRepo.findAll());
            model.addAttribute("view","/views/ctsp/creates.jsp");
            return "layout";
        }

        ChiTietSP ctsp = new ChiTietSP();
        ctsp.loadFromVMD(vmd);
        MauSac entity = this.msRepo.findById(vmd.getMauSacVMD()).get();
        ctsp.setMauSac(entity);
        NSX entity1 = this.nsxRepo.findById(vmd.getNsxVMD()).get();
        ctsp.setNsx(entity1);
        DongSP entity2 = this.dspRepo.findById(vmd.getDspVMD()).get();
        ctsp.setDsp(entity2);
         SanPham entity3 = this.spRepo.findById(vmd.getSanPhamVMD()).get();
        ctsp.setSanPham(entity3);
        this.ctspRepo.save(ctsp);
        return "redirect:/ctsp/index";
    }
    @GetMapping("ctsp/delete/{id}")
    public String delete(@PathVariable("id")  ChiTietSP nhanVien)
    {
        this.ctspRepo.delete(nhanVien);
        return "redirect:/ctsp/index";
    }

    @GetMapping("ctsp/edit/{id}")
    public String edit(
            @PathVariable("id") ChiTietSP ctsp,
            Model model
    ) {
        vmd.loadFromEntity(ctsp);
        model.addAttribute("ctsp", vmd);
        model.addAttribute("action", "/ctsp/update/" + ctsp.getId());
        model.addAttribute("danhSachMS",msRepo.findAll());
        model.addAttribute("danhSachNSX",nsxRepo.findAll());
        model.addAttribute("danhSachDSP",dspRepo.findAll());
        model.addAttribute("danhSachSP",spRepo.findAll());
        model.addAttribute("view","/views/ctsp/creates.jsp");
        return "layout";
    }

    @PostMapping("ctsp/update/{id}")
    public String update(
            @PathVariable("id") ChiTietSP ctsp,
            @Valid ChiTietSPVMD vmd,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            vmd.loadFromEntity(ctsp);
            model.addAttribute("ctsp", vmd);
            model.addAttribute("action", "/ctsp/update/" + ctsp.getId());
            model.addAttribute("danhSachMS",msRepo.findAll());
            model.addAttribute("danhSachNSX",nsxRepo.findAll());
            model.addAttribute("danhSachDSP",dspRepo.findAll());
            model.addAttribute("danhSachSP",spRepo.findAll());
            model.addAttribute("view","/views/ctsp/creates.jsp");
            return "layout";
        } else {

            ctsp.loadFromVMD(vmd);
            ctsp.setId(ctsp.getId());
            MauSac entity = this.msRepo.findById(vmd.getMauSacVMD()).get();
            ctsp.setMauSac(entity);
            NSX entity1 = this.nsxRepo.findById(vmd.getNsxVMD()).get();
            ctsp.setNsx(entity1);
            DongSP entity2 = this.dspRepo.findById(vmd.getDspVMD()).get();
            ctsp.setDsp(entity2);
            SanPham entity3 = this.spRepo.findById(vmd.getSanPhamVMD()).get();
            ctsp.setSanPham(entity3);
            this.ctspRepo.save(ctsp);
            return "redirect:/ctsp/index";
        }
    }
}

