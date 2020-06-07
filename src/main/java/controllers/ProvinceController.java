package controllers;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import service.province.IProvinceService;

@Controller
public class ProvinceController {

    @Autowired
    private IProvinceService provinceService;

    @GetMapping("/province")
    public ModelAndView listProvinces(Pageable pageable){
        Iterable<Province> provinces = provinceService.findAll(pageable);
        return new ModelAndView("province/provinceList", "province", provinces);
    }
}
