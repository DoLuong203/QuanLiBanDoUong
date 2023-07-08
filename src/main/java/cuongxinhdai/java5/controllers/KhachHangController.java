package cuongxinhdai.java5.controllers;

import cuongxinhdai.java5.model.KhachHang;
import cuongxinhdai.java5.repository.KhachHangRepository;
import cuongxinhdai.java5.request.KhachHangVMD;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KhachHangController {
@Autowired
    private KhachHangRepository khachHangRepo ;
@Autowired
private KhachHangVMD vmd;
@GetMapping("khach_hang/create")
public String create(Model model){
    model.addAttribute("kh",vmd);
    model.addAttribute("action","store");
    model.addAttribute("view","/views/khach_hang/creates.jsp");
    return "layout";
}
@PostMapping("khach_hang/store")
    public String store(Model model,@Valid @ModelAttribute("kh") KhachHangVMD vmd, BindingResult result){
    if(result.hasErrors()){
        model.addAttribute("kh",vmd);
        model.addAttribute("action","store");
        model.addAttribute("view","/views/khach_hang/creates.jsp");
        return "layout";
    }
    KhachHang kh=new KhachHang();
    kh.setMa(vmd.getMa());
    kh.setTen(vmd.getTen());
    kh.setTenDem(vmd.getTenDem());
    kh.setHo(vmd.getHo());
    kh.setNgaySinh(vmd.getNgaySinh());
    kh.setDiaChi(vmd.getDiaChi());
    kh.setSdt(vmd.getSdt());
    kh.setThanhPho(vmd.getThanhPho());
    kh.setQuocGia(vmd.getQuocGia());
    khachHangRepo.save(kh);
    return "redirect:index";
}
@GetMapping("khach_hang/edit/{id}")
public String edit(@PathVariable("id") KhachHang khachHang , Model model) {
    vmd = new KhachHangVMD();
    vmd.setMa(khachHang.getMa());
    vmd.setTen(khachHang.getTen());
    vmd.setTenDem(khachHang.getTenDem());
    vmd.setHo(khachHang.getHo());
    vmd.setNgaySinh(khachHang.getNgaySinh());
    vmd.setDiaChi(khachHang.getDiaChi());
    vmd.setSdt(khachHang.getSdt());
    vmd.setThanhPho(khachHang.getThanhPho());
    vmd.setQuocGia(khachHang.getQuocGia());
    vmd.setMatKhau(khachHang.getMatKhau());
    model.addAttribute("kh", vmd);
    model.addAttribute("action", "/khach_hang/update/" + khachHang.getId());
    model.addAttribute("view","/views/khach_hang/creates.jsp");
    return "layout";
}
    @PostMapping("khach_hang/update/{id}")
            public String update(@PathVariable("id") KhachHang khachHang,
            @Valid @ModelAttribute("kh") KhachHangVMD vmd,
            BindingResult result,
            Model model){
    if(result.hasErrors()){
        model.addAttribute("kh", vmd);
        model.addAttribute("action", "/khach_hang/update/" + khachHang.getId());
        model.addAttribute("view","/views/khach_hang/creates.jsp");
        return "layout";
    }else {
        KhachHang kh = new KhachHang();
        kh.setId(khachHang.getId());
        kh.setMa(vmd.getMa());
        kh.setTen(vmd.getTen());
        kh.setTenDem(vmd.getTenDem());
        kh.setHo(vmd.getHo());
        kh.setNgaySinh(vmd.getNgaySinh());
        kh.setDiaChi(vmd.getDiaChi());
        kh.setSdt(vmd.getSdt());
        kh.setThanhPho(vmd.getThanhPho());
        kh.setQuocGia(vmd.getQuocGia());
        kh.setMatKhau(vmd.getMatKhau());
        khachHangRepo.save(kh);
        return "redirect:/khach_hang/index";
    }
    }
    @GetMapping("khach_hang/delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang){
    this.khachHangRepo.delete(khachHang);
    return "redirect:/khach_hang/index";
    }
@GetMapping("khach_hang/index")
    public String index(Model model){
    model.addAttribute("danhSachKH",khachHangRepo.findAll());
    model.addAttribute("view","/views/khach_hang/index.jsp");
    return "layout";
}

}
