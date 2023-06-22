package fr.fms.business;

import fr.fms.entities.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBusiness {
    /**
     * Méthode qui ajoute une séance au panier
     * @param cinemaStreeming
     */
    void addCinemaStreemingToCard(CinemaStreeming cinemaStreeming);

    /**
     * Métode qui retire une séance du panier
     * @param id  id de l'article à retirer
     */
    void removeCinemaStreemingToCard(Long id);

    /**
     * Méthode qui vide le panier
     */
    void deleteCart();

    /**
     * Méthode qui retourne le contenu du panier
     * @return une liste de séance
     */
    List<CinemaStreeming> getInCart();

    /**
     * Méthode qui retourne le nombre de séance dans le panier
     * @return le nombre
     */
    int getNbInCart();

    /**
     * Méthode qui affiche les films par page
     * @param kw est un mot dont on souhaite afficher tous les articles le contenant
     * @param page correspond à la page active côté front, cela assure la pagination
     * @return liste de films
     */
    Page<Movie> getMoviesPages(String kw, int page);

    /**
     * Méthode qui permet de retourner un film par son id
     * @param id id ciblé
     * @return film ayant l'id
     */
    Movie getMovieById(Long id);

    /**
     * Méthode qui sauvegardde un film en base
     * @param movie
     */
    void saveMovie(Movie movie);

    /**
     * Méthode qui supprime un film de la base
     * @param id du film à supprimer
     */
    void deleteMovie(Long id);

    /**
     * Méthode recherche toutes les villes en base
     * @return une liste de ville
     */
    List<City> findAll();

    /**
     * Méthode qui recherche tous les cinémas d'une ville
     * @param id de la ville ciblée
     * @return liste des cinémas d'une ville
     */
    List<Cinema> findAllContainsCityId(Long id);

    /**
     * Méthode qui recherche toutes les salles d'un cinéma
     * @param id du cinéma ciblé
     * @return liste des salles d'un cinéma
     */
    List<Room> findAllContainsCinemaId(Long id);

    /**
     * Méthode qui recheche toutes les séances d'une salle
     * @param id de la salles ciblée
     * @return la liste des séances de la salle
     */
    List<CinemaStreeming> findAllContainsRoomId(Long id);

    /**
     * Méthode qui recherche une séance par son id
     * @param id de la séance ciblée
     * @return la séance ciblée
     */
    CinemaStreeming getCinemaStreemingById(Long id);

    /**
     * Méthode qui sauvegarde une séance en base
     * @param cinemaStreeming
     */
    void saveCinemaStreeming(CinemaStreeming cinemaStreeming);
}
