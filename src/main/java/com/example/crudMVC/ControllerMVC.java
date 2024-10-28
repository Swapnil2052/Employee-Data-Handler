package com.example.crudMVC;

import com.example.crudMVC.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class ControllerMVC {
    EmployeeService employeeService;
    @Autowired
    public ControllerMVC(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
      List<Employee> list=employeeService.findAll();
      model.addAttribute("employee",list);
      return "listEmployee";
    }

    @GetMapping("/showAddForm")
    public String addForm(Model model){
        model.addAttribute("employee",new Employee());
        return "saveForm";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showUpdateForm")
    public String updateForm(@RequestParam("employeeID")int id, Model model){
        Employee employee=employeeService.findByID(id);
        model.addAttribute("employee",employee);
        return "saveForm";
    }

    @GetMapping("/showDelete")
    public String showDelete(@RequestParam("employeeID") int id){
        employeeService.deleteByID(id);
        return "redirect:/employees/list";
    }
}
