package cuongxinhdai.java5.controllers;

import cuongxinhdai.java5.model.ChucVu;
import cuongxinhdai.java5.model.SanPham;
import cuongxinhdai.java5.repository.ChucVuRepository;
import cuongxinhdai.java5.repository.SanPhamRepository;
import cuongxinhdai.java5.request.ChucVuVMD;
import cuongxinhdai.java5.request.SanPhamVMD;
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
public class SanPhamController {
    @Autowired
    private SanPhamRepository spRepo;
    @Autowired
    private SanPhamVMD vmd;

    @GetMapping("san_pham/index")
    public String index(Model model) {
        model.addAttribute("danhSachSP", spRepo.findAll());
        model.addAttribute("view","/views/san_pham/index.jsp");
        return "layout";

    }

    @GetMapping("san_pham/create")
    public String create(Model model) {
        model.addAttribute("sp", vmd);
        model.addAttribute("action", "store");
        model.addAttribute("view","/views/san_pham/creates.jsp");
        return "layout";
    }

    @GetMapping("san_pham/edit/{id}")
    public String edit(@PathVariable("id") SanPham sp, Model model) {
        vmd.loadFromEntity(sp);
        model.addAttribute("sp", vmd);
        model.addAttribute("action", "/san_pham/update/" + sp.getId());
        model.addAttribute("view","/views/san_pham/creates.jsp");
        return "layout";
    }

    @PostMapping("san_pham/update/{id}")
    public String update(
            @PathVariable("id") SanPham sp,
            @Valid SanPhamVMD vmd, BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            vmd.loadFromEntity(sp);
            model.addAttribute("sp", vmd);
            model.addAttribute("action", "/san_pham/update/" + sp.getId());
            model.addAttribute("view","/views/san_pham/creates.jsp");
            return "layout";
        }
        sp.loadFormVMD(vmd);
        this.spRepo.save(sp);
        return "redirect:/san_pham/index";
    }
    @PostMapping("san_pham/store")
    public String store(Model model,
            @Valid @ModelAttribute("") SanPhamVMD vmd,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("sp", vmd);
            model.addAttribute("action", "store");
            model.addAttribute("view","/views/san_pham/creates.jsp");
            return "layout";
        }

        SanPham sp = new SanPham();
        sp.loadFormVMD(vmd);
        this.spRepo.save(sp);

        return "redirect:/san_pham/index";
    }
    @GetMapping("san_pham/delete/{id}")
    public String delete(@PathVariable("id") SanPham sp)
    {
        this.spRepo.delete(sp);
        return "redirect:/san_pham/index";
    }
}
