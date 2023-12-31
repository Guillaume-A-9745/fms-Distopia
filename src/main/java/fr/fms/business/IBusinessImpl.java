package fr.fms.business;

import fr.fms.dao.*;
import fr.fms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class IBusinessImpl implements IBusiness{
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    CinemaStreemingRepository cinemaStreemingRepository;
    @Autowired
    MovieRepository movieRepository;

    private HashMap<Long,CinemaStreeming> cart;
    private Customer customer;

    public IBusinessImpl() {
        cart = new HashMap<>();
        customer = null;
    }

    @Override
    public void addCinemaStreemingToCard(CinemaStreeming cinemaStreeming) {
        CinemaStreeming c = cart.get(cinemaStreeming.getId());
        if(c != null) {
            c.setQuantity(c.getQuantity() + 1);
        } else {
            cart.put(cinemaStreeming.getId(), cinemaStreeming);
        }
    }

    @Override
    public void removeCinemaStreemingToCard(Long id) { cart.remove(id); }

    @Override
    public void deleteCart() { cart.clear(); }

    @Override
    public List<CinemaStreeming> getCart() {
        return new ArrayList<>(cart.values());
    }

    @Override
    public int getNbInCart() {
        return cart.size();
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    @Override
    public Page<Movie> getMoviesPages(String kw, int page) {
        return movieRepository.findByNameContains(kw , PageRequest.of(page, 5));
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> optional = movieRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<City> findAll() {
        List<City> cities = cityRepository.findAll();
        return cities;
    }

    @Override
    public List<Cinema> findAllContainsCityId(Long id) {
        List<Cinema> cinemas = cinemaRepository.findCityIdContains(id);
        return cinemas;
    }

    @Override
    public List<Room> findAllContainsCinemaId(Long id) {
        List<Room> rooms = roomRepository.findCinemaIdContains(id);
        return rooms;
    }

    @Override
    public List<CinemaStreeming> findAllContainsRoomId(Long id) {
        List<CinemaStreeming> cinemaStreemings = cinemaStreemingRepository.findRoomIdContains(id);
        return cinemaStreemings;
    }

    @Override
    public CinemaStreeming getCinemaStreemingById(Long id) {
        Optional<CinemaStreeming> cinemaStreeming = cinemaStreemingRepository.findById(id);
        return cinemaStreeming.isPresent() ? cinemaStreeming.get() : null;
    }

    @Override
    public void saveCinemaStreeming(CinemaStreeming cinemaStreeming) {
        cinemaStreemingRepository.save(cinemaStreeming);
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }

    public void getDeleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        return city.isPresent() ? city.get() : null;
    }

    public void getDeleteCinemaStreeming(Long id) {
        cinemaStreemingRepository.deleteById(id);
    }

    public double getTotalAmount(){
        double total = 0;
        for(CinemaStreeming article : cart.values()) {
            total += article.getPrice()*article.getQuantity();
        }
        return total;
    };

    public String great() { return "Hello World"; }
}
