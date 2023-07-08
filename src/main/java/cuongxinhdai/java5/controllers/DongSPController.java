package cuongxinhdai.java5.controllers;

import cuongxinhdai.java5.model.ChucVu;
import cuongxinhdai.java5.model.DongSP;
import cuongxinhdai.java5.repository.ChucVuRepository;
import cuongxinhdai.java5.repository.DongSPRepository;
import cuongxinhdai.java5.request.ChucVuVMD;
import cuongxinhdai.java5.request.DongSPVMD;
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
public class DongSPController {
    @Autowired
    private DongSPRepository dspRepo;
    @Autowired
    private DongSPVMD vmd;

    @GetMapping("dsp/index")
    public String index(Model model) {
        model.addAttribute("danhSachDSP", dspRepo.findAll());
        model.addAttribute("view","/views/dsp/index.jsp");
        return "layout";
    }

    @GetMapping("dsp/create")
    public String create(Model model) {
        model.addAttribute("dsp", vmd);
        model.addAttribute("action", "store");
        model.addAttribute("view","/views/dsp/creates.jsp");
        return "layout";
    }

    @GetMapping("dsp/edit/{id}")
    public String edit(@PathVariable("id") DongSP dsp, Model model) {
        vmd.loadFromEntity(dsp);
        model.addAttribute("dsp", vmd);
        model.addAttribute("action", "/dsp/update/" + dsp.getId());
        model.addAttribute("view","/views/dsp/creates.jsp");
        return "layout";
    }

    @PostMapping("dsp/update/{id}")
    public String update(
            @PathVariable("id") DongSP dsp,
            @Valid DongSPVMD vmd, BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("dsp", vmd);
            model.addAttribute("action", "/dsp/update/" + dsp.getId());
            model.addAttribute("view","/views/dsp/creates.jsp");
            return "layout";
        }
        dsp.loadFormVMD(vmd);
        this.dspRepo.save(dsp);
        return "redirect:/dsp/index";
    }
    @PostMapping("dsp/store")
    public String store(Model model,
            @Valid @ModelAttribute("dsp") DongSPVMD vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("dsp", vm);
            model.addAttribute("action", "store");
            model.addAttribute("view","/views/dsp/creates.jsp");
            return "layout";
        }

        DongSP dsp = new DongSP();
        dsp.loadFormVMD(vm);
        this.dspRepo.save(dsp);

        return "redirect:/dsp/index";
    }
    @GetMapping("dsp/delete/{id}")
    public String delete(@PathVariable("id") DongSP dsp)
    {
        this.dspRepo.delete(dsp);
        return "redirect:/dsp/index";
    }
}
