// SearchController.java
package com.smartjob.platform.controller;
import java.util.List;
import com.smartjob.platform.model.Laborer;
import com.smartjob.platform.repository.LaborerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private LaborerRepository laborerRepository;

    @GetMapping("/search")
    public String searchLaborers(@RequestParam String skills, @RequestParam String availability, Model model) {
        List<Laborer> laborers = laborerRepository.findBySkillsContainingAndAvailabilityContaining(skills, availability);
        model.addAttribute("laborers", laborers);
        return "search_results";
    }
}
