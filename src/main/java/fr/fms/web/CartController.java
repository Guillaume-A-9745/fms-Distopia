package fr.fms.web;

import fr.fms.business.IBusinessImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @Autowired
    IBusinessImpl iBusiness;

    @GetMapping("/displayCart")
    public String dispalyCart(Model model) {
        model.addAttribute("cart", iBusiness.getCart());
        double total = iBusiness.getTotalAmount();
        model.addAttribute("total",total);
        model.addAttribute("nbArt",iBusiness.getNbInCart());
        return "cart";
    }

    @GetMapping("/addToCart")
    public String addToCart(Long id,Long idRoom) {
        iBusiness.addCinemaStreemingToCard(iBusiness.getCinemaStreemingById(id));
        return "redirect:/cinemaStreeming?idRoom=" + idRoom;
    }

    @GetMapping("/removeToCart")
    public String removeToCart(Long id) {
        iBusiness.removeCinemaStreemingToCard(id);
        return "redirect:/displayCart";
    }
}
