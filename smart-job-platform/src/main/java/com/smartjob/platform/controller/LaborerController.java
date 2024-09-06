// LaborerController.java
package com.smartjob.platform.controller;
import java.util.List;
import com.smartjob.platform.model.Laborer;
import com.smartjob.platform.repository.LaborerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LaborerController {

    @Autowired
    private LaborerRepository laborerRepository;

    @GetMapping("/laborers")
    public String listLaborers(Model model) {
        model.addAttribute("laborers", laborerRepository.findAll());
        return "laborers";
    }

    @GetMapping("/laborers/new")
    public String showCreateLaborerForm(Model model) {
        model.addAttribute("laborer", new Laborer());
        return "create_laborer";
    }

    @PostMapping("/laborers")
    public String createLaborer(@ModelAttribute Laborer laborer) {
        laborerRepository.save(laborer);
        return "redirect:/laborers";
    }
}
