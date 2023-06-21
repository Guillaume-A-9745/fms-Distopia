package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/cinemas")
    public String cinemas(Model model, @RequestParam(name="idCity" , defaultValue = "") Long id) {
        List<Cinema> cinemas = iBusiness.findAllContainsCityId(id);
        model.addAttribute("listCinema", cinemas);
        return  "cinemas";
    }
    @GetMapping("/rooms")
    public String rooms(Model model, @RequestParam(name="idCinema" , defaultValue = "") Long id) {
        List<Room> rooms = iBusiness.findAllContainsCinemaId(id);
        model.addAttribute("listRoom", rooms);
        return  "rooms";
    }
    @GetMapping("/cinemaStreeming")
    public String cinemaStreeming(Model model, @RequestParam(name="idRoom" , defaultValue = "") Long id) {
        List<CinemaStreeming> cinemaStreemings = iBusiness.findAllContainsRoomId(id);
        model.addAttribute("listCinemaStreeming", cinemaStreemings);
        return  "cinemaStreeming";
    }
    @GetMapping("/editCinemaStreeming")
    public String editCinemaStreeming(Model model, Long id) {
        CinemaStreeming cinemaStreeming = iBusiness.getCinemaStreemingById(id);
        model.addAttribute("movies", iBusiness.getMovies());
        model.addAttribute("cinemaStreeming", cinemaStreeming);
        return "editCinemaStreeming";
    }
}
