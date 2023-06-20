package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CinemaController {
    @Autowired
    IBusinessImpl iBusiness;

    @GetMapping("/management")
    public String management(Model model) {
        List<City> city = iBusiness.findAll();
        model.addAttribute("listCity", city);
        return "cities";
    }
}
