package controllers;

import jdk.nashorn.internal.runtime.options.Option;
import model.Customer;
import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.customer.ICustomerService;
import service.province.IProvinceService;

import java.util.Optional;

@Controller
@RequestMapping("")

public class CustomerController {
    @Autowired
    public ICustomerService customerService;
    @Autowired
    public IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Page<Province> provinces(Pageable pageable) {
        return provinceService.findAll(pageable);
    }

    @GetMapping("customer")
    public ModelAndView showAllList(@PageableDefault(value = 5) Pageable pageable, @RequestParam("s") Optional<String> s) {
        Page<Customer> list;
        if (s.isPresent()) {
            list = customerService.findAllByFirstNameContaining(s.get(), pageable);
        } else {
            list = customerService.findAll(pageable);
        }
        return new ModelAndView("customer/customerList", "list", list);
    }

    @GetMapping("customer/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer/showEditForm");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("customer/edit/{id}")
    public String edit(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("customer/delete/{id}")
    public String delete(@PathVariable Long id) {
        customerService.delete(id);
        return "redirect:/customer";
    }

    @GetMapping("customer/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("customer/createForm", "customer", new Customer());
    }

    @PostMapping("customer/create")
    public String create(@ModelAttribute Customer customer, BindingResult rs) {
        System.out.println(rs);
        customerService.save(customer);
        return "redirect:/customer";
    }
}
