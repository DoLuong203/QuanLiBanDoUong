package cuongxinhdai.java5.controllers;

import cuongxinhdai.java5.model.ChucVu;
import cuongxinhdai.java5.model.MauSac;
import cuongxinhdai.java5.repository.ChucVuRepository;
import cuongxinhdai.java5.repository.MauSacRepository;
import cuongxinhdai.java5.request.ChucVuVMD;
import cuongxinhdai.java5.request.MauSacVMD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MauSacController {
    @Autowired
    private MauSacRepository msRepo;
    @Autowired
    private MauSacVMD vmd;

    @GetMapping("mau_sac/index")
            public String index(Model model){
        model.addAttribute("danhSachMS", msRepo.findAll());
        model.addAttribute("view","/views/mau_sac/index.jsp");
        return "layout";
    }


    @GetMapping("mau_sac/create")
    public String create(Model model) {
        model.addAttribute("ms", vmd);
        model.addAttribute("action", "store");
        model.addAttribute("view","/views/mau_sac/creates.jsp");
        return "layout";
    }

    @GetMapping("mau_sac/edit/{id}")
    public String edit(@PathVariable("id") MauSac ms, Model model) {
        vmd.loadFromEntity(ms);
        model.addAttribute("ms", vmd);
        model.addAttribute("action", "/mau_sac/update/" + ms.getId());
        model.addAttribute("view","/views/mau_sac/creates.jsp");
        return "layout";
    }

    @PostMapping("mau_sac/update/{id}")
    public String update(
            @PathVariable("id") MauSac ms,
            @Valid MauSacVMD vmd, BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            vmd.loadFromEntity(ms);
            model.addAttribute("ms", vmd);
            model.addAttribute("action", "/mau_sac/update/" + ms.getId());
            model.addAttribute("view","/views/mau_sac/creates.jsp");
            return "layout";
        }
        ms.loadFormVMD(vmd);
        this.msRepo.save(ms);
        return "redirect:/mau_sac/index";
    }
    @PostMapping("mau_sac/store")
    public String store(Model model,
            @Valid @ModelAttribute("ms") MauSacVMD vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println( result.getAllErrors().get(0).toString() );
            model.addAttribute("ms", vm);
            model.addAttribute("action", "store");
            model.addAttribute("view","/views/mau_sac/creates.jsp");
            return "layout";
        }

        MauSac ms = new MauSac();
        ms.loadFormVMD(vm);
        this.msRepo.save(ms);

        return "redirect:/mau_sac/index";
    }
    @GetMapping("mau_sac/delete/{id}")
    public String delete(@PathVariable("id") MauSac ms)
    {
        this.msRepo.delete(ms);
        return "redirect:/mau_sac/index";
    }
}
