package cuongxinhdai.java5.controllers;

import cuongxinhdai.java5.model.ChucVu;
import cuongxinhdai.java5.model.NSX;
import cuongxinhdai.java5.repository.ChucVuRepository;
import cuongxinhdai.java5.repository.NSXRepository;
import cuongxinhdai.java5.request.ChucVuVMD;
import cuongxinhdai.java5.request.NSXVMD;
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
public class NSXController {
    @Autowired
    private NSXRepository nsxRepo;
    @Autowired
    private NSXVMD vmd;

    @GetMapping("nsx/index")
    public String index(Model model) {
        model.addAttribute("danhSachNSX", nsxRepo.findAll());
        model.addAttribute("view","/views/nsx/index.jsp");
        return "layout";
    }

    @GetMapping("nsx/create")
    public String create(Model model) {
        model.addAttribute("nsx", vmd);
        model.addAttribute("action", "store");
        model.addAttribute("view","/views/nsx/creates.jsp");
        return "layout";
    }

    @GetMapping("nsx/edit/{id}")
    public String edit(@PathVariable("id") NSX nsx, Model model) {
        vmd.loadFromEntity(nsx);
        model.addAttribute("nsx", vmd);
        model.addAttribute("action", "/nsx/update/" + nsx.getId());
        model.addAttribute("view","/views/nsx/creates.jsp");
        return "layout";
    }

    @PostMapping("nsx/update/{id}")
    public String update(
            @PathVariable("id") NSX nsx,
            @Valid NSXVMD vmd, BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            vmd.loadFromEntity(nsx);
            model.addAttribute("nsx", vmd);
            model.addAttribute("action", "/nsx/update/" + nsx.getId());
            model.addAttribute("view","/views/nsx/creates.jsp");
            return "layout";
        }
        nsx.loadFormVMD(vmd);
        this.nsxRepo.save(nsx);
        return "redirect:/nsx/index";
    }
    @PostMapping("nsx/store")
    public String store(Model model,
            @Valid @ModelAttribute("") NSXVMD vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("nsx", vm);
            model.addAttribute("action", "store");
            model.addAttribute("view","/views/nsx/creates.jsp");
            return "layout";
        }

        NSX nsx = new NSX();
        nsx.loadFormVMD(vm);
        this.nsxRepo.save(nsx);

        return "redirect:/nsx/index";
    }
    @GetMapping("nsx/delete/{id}")
    public String delete(@PathVariable("id") NSX nsx)
    {
        this.nsxRepo.delete(nsx);
        return "redirect:/nsx/index";
    }
}
