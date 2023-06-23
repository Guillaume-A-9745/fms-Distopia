package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class CinemaController {
    @Autowired
    IBusinessImpl iBusiness;

    /**
     * Méthode qui permet l'accès à la page cities.html
     * @param model
     * @return cities.html
     */
    @GetMapping("/cities")
    public String management(Model model) {
        List<City> city = iBusiness.findAll();
        model.addAttribute("listCity", city);
        return "cities";
    }

    /**
     * Méthode qui permet l'accès à la page d'ajout de ville
     * @param model
     * @return addCity.html
     */
    @GetMapping("/addCity")
    public String addCity(Model model) {
        model.addAttribute("city",new Movie());
        return "addCity";
    }

    /**
     * Méthode qui sauvegarde une ville en base
     * @param city
     * @return redirection vers la page cities.html
     */
    @PostMapping("/saveCity")
    public String saveCity(City city) {
        iBusiness.saveCity(city);
        return "redirect:/cities";
    }

    /**
     * Méthode qui permet de supprimer une ville en base
     * @param id du ville ciblée
     * @return redirection vers la page cities.html
     */
    @GetMapping("/deleteCity")
    public String deleteCity(Long id) {
        iBusiness.getDeleteCity(id);
        return "redirect:/cities";
    }

    /**
     * Méthode qui permet l'accès à la pade de modification d'une ville
     * @param id
     * @param model
     * @return editCity.html
     */
    @GetMapping("/editCity")
    public String editCity(Long id, Model model) {
        City city = iBusiness.getCityById(id);
        model.addAttribute("city", city);
        return "editCity";
    }



    /**
     * Méthode qui permet d'afficher les cinémas d'une ville
     * @param model
     * @param id de la ville ciblée
     * @return cinemas.html
     */
    @GetMapping("/cinemas")
    public String cinemas(Model model, @RequestParam(name="idCity" , defaultValue = "") Long id) {
        List<Cinema> cinemas = iBusiness.findAllContainsCityId(id);
        model.addAttribute("listCinema", cinemas);
        return  "cinemas";
    }
    /**
     * Méthode qui permet l'accès à la page d'ajout d'un cinema
     * @return
     */
    @GetMapping("/addCinema")
    public String addCinema(){
        //TODO
        return null;
    }

    /**
     * Méthode qui permet l'accès à la page de modification d'un cinema
     * @return
     */
    @GetMapping("/editCinema")
    public String editCinema(){
        //TODO
        return null;
    }

    /**
     * Méthode qui permet de sauvegarder un cinema en base
     * @return
     */
    @PostMapping("/saveCinema")
    public String saveCinema(){
        //TODO
        return null;
    }

    /**
     * Méthode qui permet la suppression d'un cinema en base
     * @return
     */
    @GetMapping("/deleteCinema")
    public String deleteCinema(){
        //TODO
        return null;
    }


    /**
     * Méthode  qui permet d'afficher les salles d'un cinéma
     * @param model
     * @param id du cinéma ciblé
     * @return rooms.html
     */
    @GetMapping("/rooms")
    public String rooms(Model model, @RequestParam(name="idCinema" , defaultValue = "") Long id) {
        List<Room> rooms = iBusiness.findAllContainsCinemaId(id);
        model.addAttribute("listRoom", rooms);
        return  "rooms";
    }

    /**
     * Méthode qui permet l'accès à la page d'ajout d'une salle
     * @return
     */
    @GetMapping("/addRoom")
    public String addRoom(){
        //TODO
        return null;
    }

    /**
     * Méthode qui permet l'accès à la page de modification d'une salle
     * @return
     */
    @GetMapping("/editRoom")
    public String editRoom(){
        //TODO
        return null;
    }

    /**
     * Méthode qui permet de sauvegarder une salle en base
     * @return
     */
    @PostMapping("/saveRoom")
    public String saveRoom(){
        //TODO
        return null;
    }

    /**
     * Méthode qui permet la suppression d'une salle en base
     * @return
     */
    @GetMapping("/deleteRoom")
    public String deleteRoom(){
        //TODO
        return null;
    }


    /**
     * Méthode qui permet d'afficher les séances d'une salle
     * @param model
     * @param id de la salle
     * @return cinemaStreeming.html
     */
    @GetMapping("/cinemaStreeming")
    public String cinemaStreeming(Model model, @RequestParam(name="idRoom" , defaultValue = "") Long id) {
        List<CinemaStreeming> cinemaStreemings = iBusiness.findAllContainsRoomId(id);
        List<Movie> movies;
        model.addAttribute("listCinemaStreeming", cinemaStreemings);
        model.addAttribute("idRoom",id);
        return  "cinemaStreeming";
    }

    /**
     * Méthode qui permet l'accès à la page d'ajout d'une séance
     * @return
     */
    @GetMapping("/addcinemaStreeming")
    public String addcinemaStreeming(){
        //TODO
        return null;
    }

    /**
     * Méthode qui permet l'accès à la page de modification d'une séance
     * @param model
     * @param id de la séance ciblée
     * @return editCinemaStreeming.html
     */
    @GetMapping("/editCinemaStreeming")
    public String editCinemaStreeming(Model model, Long id) {
        CinemaStreeming cinemaStreeming = iBusiness.getCinemaStreemingById(id);
        model.addAttribute("movies", iBusiness.getMovies());
        model.addAttribute("cinemaStreeming", cinemaStreeming);
        return "editCinemaStreeming";
    }

    /**
     * Méthode qui permet la sauvgarde en base d'une séance
     * @param cinemaStreeming
     * @return redirection vers l'accueil
     */
    @PostMapping("/saveCinemaStreeming")
    public String saveCinemaStreeming(CinemaStreeming cinemaStreeming) {
        iBusiness.saveCinemaStreeming(cinemaStreeming);
        return "redirect:/index";
    }

    /**
     * Méthode qui permt le suppression d'une séance en base
     * @param id de la séance ciblée
     * @return redirection vers cinemaStreeming.html
     */
    @GetMapping("/deleteCinemaStreeming")
    public String deleteCinemaStreeming(Long id){
        iBusiness.getDeleteCinemaStreeming(id);
        return "redirect:/cinemaStreeming";
    }
}
