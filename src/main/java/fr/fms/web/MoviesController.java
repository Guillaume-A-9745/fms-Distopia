package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoviesController {
    @Autowired
    IBusinessImpl iBusiness;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page" , defaultValue = "0") int page,
                        @RequestParam(name="keyword" , defaultValue = "") String kw) {
        Page<Movie> movies = iBusiness.getMoviesPages(kw,page);
        model.addAttribute("listMovie",movies.getContent());
        model.addAttribute("pages", new int[movies.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        return "movies";
    }

    @GetMapping("/detail")
    public String detail(Long id, Model model) {
        Movie movie = iBusiness.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("/addMovie")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "addMovie";
    }

    @PostMapping("/save")
    public String save(Model model, Movie movie) {
        iBusiness.saveMovie(movie);
        return "redirect:/index";
    }

    @GetMapping("/edit")
    public String edit(Long id, Model model) {
        Movie movie = iBusiness.getMovieById(id);
        model.addAttribute("movie", movie);
        return "editMovie";
    }

    @GetMapping("/delete")
    public String delete(Long id, int page, String keyword) {
        iBusiness.deleteArticle(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
}
