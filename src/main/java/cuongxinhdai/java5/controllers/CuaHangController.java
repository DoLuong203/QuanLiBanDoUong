package cuongxinhdai.java5.controllers;
import cuongxinhdai.java5.model.CuaHang;
import cuongxinhdai.java5.repository.CuaHangRepository;
import cuongxinhdai.java5.request.CuaHangVMD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class CuaHangController {
    @Autowired
    private CuaHangRepository cuaHangRepo;
    @Autowired
    private CuaHangVMD vm;

    @GetMapping("cua_hang/create")
    public String create( Model model)
    {
        model.addAttribute("ch1", vm);
        model.addAttribute("action", "store");
        model.addAttribute("view","/views/cua_hang/creates.jsp");
        return "layout";
    }

    @GetMapping("cua_hang/edit/{id}")
    public String edit(
            @PathVariable("id") CuaHang cuaHang,
            Model model
    ) {
        vm.loadFromEntity(cuaHang);
        model.addAttribute("ch1", vm);
        model.addAttribute("action", "/cua_hang/update/" + cuaHang.getId());
        model.addAttribute("view","/views/cua_hang/creates.jsp");
        return "layout";
    }

    @PostMapping("cua_hang/update/{id}")
    public String update(
            @PathVariable("id") CuaHang cuaHang,
            @Valid CuaHangVMD vm,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("ch1", vm);
            model.addAttribute("action", "/cua_hang/update/" + cuaHang.getId());
            model.addAttribute("view","/views/cua_hang/creates.jsp");
            return "layout";
        }
        cuaHang.loadFromVM(vm);
        this.cuaHangRepo.save(cuaHang);
        return "redirect:/cua_hang/index";
    }

    @PostMapping("cua_hang/store")
    public String store(Model model,
            @Valid @ModelAttribute("ch1") CuaHangVMD vm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("ch1", vm);
            model.addAttribute("action", "store");
            model.addAttribute("view","/views/cua_hang/creates.jsp");
            return "layout";
        }

        CuaHang ch = new CuaHang();
        ch.loadFromVM(vm);
        this.cuaHangRepo.save(ch);

        return "redirect:/cua_hang/index";
    }

    @GetMapping("cua_hang/index")
    public String index(Model model)
    {
        List<CuaHang> ds = this.cuaHangRepo.findAll();
        model.addAttribute("data", ds);
        model.addAttribute("view","/views/cua_hang/index.jsp");
        return "layout";
    }

    @GetMapping("cua_hang/delete/{id}")
    public String delete(@PathVariable("id") CuaHang cuaHang)
    {
        this.cuaHangRepo.delete(cuaHang);
        return "redirect:/cua_hang/index";
    }

}
