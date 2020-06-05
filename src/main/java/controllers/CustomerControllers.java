package controllers;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.customer.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("")

public class CustomerControllers {
    @Autowired
    public ICustomerService customerService;

    @GetMapping("/")
    public ModelAndView showAllList(){
        List<Customer> list = customerService.findAll();
        return new  ModelAndView("showList", "list",list);
    }
}
