package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MoviesController {
    @Autowired
    IBusinessImpl iBusiness;

    /**
     * Méthode d'accès à la page d'acceuil de l'application
     * @param model model sert à ajouter des éléments partagés avec la vue
     * @param page page correspond à la page active côté front, cela assure la pagination / par défaut vaut 0
     * @param kw est un mot dont on souhaite afficher tous les articles le contenant / par défaut chaine vide
     * @return la page movies.html
     */
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page" , defaultValue = "0") int page,
                        @RequestParam(name="keyword" , defaultValue = "") String kw,
                        @RequestParam(name="nbcart" , defaultValue = "0") int cart) {
        Page<Movie> movies = iBusiness.getMoviesPages(kw,page);
        model.addAttribute("listMovie",movies.getContent());
        model.addAttribute("pages", new int[movies.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        model.addAttribute("nbcart", iBusiness.getNbInCart());
        return "movies";
    }

    /**
     * Méthode qui permet l'accès à la page de détail d'un film
     * @param id du film ciblé
     * @param model
     * @return la page movie.html
     */
    @GetMapping("/detail")
    public String detail(Long id, Model model) {
        Movie movie = iBusiness.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie";
    }

    /**
     * Méthode qui permet l'accès à la page d'ajout de film
     * @param model
     * @return addMovie.html
     */
    @GetMapping("/addMovie")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "addMovie";
    }

    /**
     * Méthode qui permet de sauvegarder un film en base
     * @param model
     * @param movie
     * @return redirection vers la page d'acceuil
     */
    @PostMapping("/save")
    public String save(Model model, Movie movie) {
        iBusiness.saveMovie(movie);
        return "redirect:/index";
    }

    /**
     * Méthode qui permet l'accès à la page de modification d'un film
     * @param id du film ciblé
     * @param model
     * @return editMovie.html
     */
    @GetMapping("/edit")
    public String edit(Long id, Model model) {
        Movie movie = iBusiness.getMovieById(id);
        model.addAttribute("movie", movie);
        return "editMovie";
    }

    /**
     * Méthode qui permet la suppression d'un film de la base
     * @param id du film ciblé
     * @param page
     * @param keyword
     * @return redirection vers la page d'acceuil
     */
    @GetMapping("/delete")
    public String delete(Long id, int page, String keyword) {
        iBusiness.deleteMovie(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @RequestMapping("/greating")
    public @ResponseBody
    String greating() {
        return iBusiness.great();
    }
}
