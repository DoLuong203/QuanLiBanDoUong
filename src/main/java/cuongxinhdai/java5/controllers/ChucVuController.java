package cuongxinhdai.java5.controllers;

import cuongxinhdai.java5.model.ChucVu;
import cuongxinhdai.java5.model.CuaHang;
import cuongxinhdai.java5.repository.ChucVuRepository;
import cuongxinhdai.java5.repository.CuaHangRepository;
import cuongxinhdai.java5.request.ChucVuVMD;
import cuongxinhdai.java5.request.CuaHangVMD;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ChucVuController {
    @Autowired
    private ChucVuRepository cvRepo;
    @Autowired
    private ChucVuVMD vmd;

    @GetMapping("chuc_vu/index")
    public String index(Model model) {
        model.addAttribute("danhSachCV", cvRepo.findAll());
        model.addAttribute("view","/views/chuc_vu/index.jsp");
        return "layout";
    }

    @GetMapping("chuc_vu/create")
    public String create(Model model) {
        model.addAttribute("cv", vmd);
        model.addAttribute("action", "store");
        model.addAttribute("view","/views/chuc_vu/creates.jsp");
        return "layout";
    }

    @GetMapping("chuc_vu/edit/{id}")
    public String edit(@PathVariable("id") ChucVu cv, Model model) {
        vmd.loadFromEntity(cv);
        model.addAttribute("cv", vmd);
        model.addAttribute("action", "/chuc_vu/update/" + cv.getId());
        model.addAttribute("view","/views/chuc_vu/creates.jsp");
        return "layout";
    }

    @PostMapping("chuc_vu/update/{id}")
    public String update(
            @PathVariable("id") ChucVu cv,
            @Valid ChucVuVMD vmd, BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            vmd.loadFromEntity(cv);
            model.addAttribute("cv",vmd);
            model.addAttribute("action", "/chuc_vu/update/" + cv.getId());
            model.addAttribute("view","/views/chuc_vu/creates.jsp");
            return "layout";
        }
        cv.loadFormVMD(vmd);
        this.cvRepo.save(cv);
        return "redirect:/chuc_vu/index";
    }
    @PostMapping("chuc_vu/store")
    public String store(Model model,
            @Valid @ModelAttribute("cv") ChucVuVMD vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println( result.getAllErrors().get(0).toString() );
            model.addAttribute("cv", vm);
            model.addAttribute("action", "/chuc_vu/store");
            model.addAttribute("view","/views/chuc_vu/creates.jsp");
            return "layout";
        }

ChucVu cv=new ChucVu();
        cv.loadFormVMD(vm);
        this.cvRepo.save(cv);

        return "redirect:/chuc_vu/index";
    }
    @GetMapping("chuc_vu/delete/{id}")
    public String delete(@PathVariable("id") ChucVu cv)
    {
        this.cvRepo.delete(cv);
        return "redirect:/chuc_vu/index";
    }
}
