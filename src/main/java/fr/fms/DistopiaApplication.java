package fr.fms;

import fr.fms.dao.*;
import fr.fms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

@SpringBootApplication
public class DistopiaApplication implements CommandLineRunner {
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

	public static void main(String[] args) {
		SpringApplication.run(DistopiaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//generateData();
	}

	private void generateData() {
		City paris = cityRepository.save(new City(null, "Paris", null));
		City marseille = cityRepository.save(new City(null, "Marseille", null));
		City lyon = cityRepository.save(new City(null, "Lyon", null));
		City lille = cityRepository.save(new City(null, "Lille", null));
		City bordeaux = cityRepository.save(new City(null, "Bordeaux", null));
		City bayonne = cityRepository.save(new City(null, "Bayonne", null));

		Cinema etoile = cinemaRepository.save(new Cinema(null, "L'étoile", "22 avenue des lumières", paris, null));
		Cinema star = cinemaRepository.save(new Cinema(null, "Star", "22 avenue du vent", paris, null));
		Cinema tournesol = cinemaRepository.save(new Cinema(null, "Les tournesols", "22 avenue des tournesols", paris, null));
		Cinema rose = cinemaRepository.save(new Cinema(null, "La rose blanche", "22 avenue des roses", paris, null));
		Cinema tulipes = cinemaRepository.save(new Cinema(null, "La tulipe", "22 avenue des tulipes", paris, null));

		Cinema azur = cinemaRepository.save(new Cinema(null, "L'Azur", "22 avenue des palmiers", marseille, null));
		Cinema select = cinemaRepository.save(new Cinema(null, "Le Select", "22 avenue des champs", marseille, null));
		Cinema olivier = cinemaRepository.save(new Cinema(null, "Les oliviers", "22 avenue des oliviers", marseille, null));
		Cinema laurier = cinemaRepository.save(new Cinema(null, "Les lauriers", "22 avenue des lauriers", marseille, null));
		Cinema cactus = cinemaRepository.save(new Cinema(null, "Le cactus", "22 avenue des cactus", marseille, null));

		Cinema passion = cinemaRepository.save(new Cinema(null, "La Passion", "22 avenue des fleuves", lyon, null));
		Cinema voie = cinemaRepository.save(new Cinema(null, "La Voie", "22 avenue des montagnes", lyon, null));
		Cinema colline = cinemaRepository.save(new Cinema(null, "La colline", "22 avenue des collines", lyon, null));
		Cinema prairie = cinemaRepository.save(new Cinema(null, "Les prairies", "22 avenue des prairies", lyon, null));
		Cinema vallee = cinemaRepository.save(new Cinema(null, "Ciné de la vallée", "22 avenue des vallées", lyon, null));

		Cinema bouquet = cinemaRepository.save(new Cinema(null, "Le Bouquet", "22 avenue des jardins", lille, null));
		Cinema barquette = cinemaRepository.save(new Cinema(null, "La Barquette", "22 avenue des plages", lille, null));
		Cinema foret = cinemaRepository.save(new Cinema(null, "La forêt", "22 avenue des forêts", lille, null));
		Cinema ruisseau = cinemaRepository.save(new Cinema(null, "Ciné des ruisseaux", "22 avenue des ruisseaux", lille, null));
		Cinema cascade = cinemaRepository.save(new Cinema(null, "La cascade", "22 avenue des cascades", lille, null));

		Cinema rex = cinemaRepository.save(new Cinema(null, "Rex", "22 avenue des vignes", bordeaux, null));
		Cinema nuage = cinemaRepository.save(new Cinema(null, "Le nuage", "22 avenue des nuages", bordeaux, null));
		Cinema tempete = cinemaRepository.save(new Cinema(null, "La tempête", "22 avenue des tempêtes", bordeaux, null));
		Cinema orage = cinemaRepository.save(new Cinema(null, "L'orage", "22 avenue des orages", bordeaux, null));
		Cinema vent = cinemaRepository.save(new Cinema(null, "Le vent", "22 avenue des vents", bordeaux, null));

		Cinema pluie = cinemaRepository.save(new Cinema(null, "La pluie", "22 avenue des pluies", bayonne, null));
		Cinema eclair = cinemaRepository.save(new Cinema(null, "L'éclair", "22 avenue des éclairs", bayonne, null));
		Cinema tonnerre = cinemaRepository.save(new Cinema(null, "Tonnerre", "22 avenue des tonnerres", bayonne, null));
		Cinema arc = cinemaRepository.save(new Cinema(null, "L'arc-en-ciel", "22 avenue des arcs-en-ciel", bayonne, null));
		Cinema aurores = cinemaRepository.save(new Cinema(null, "L'aurore", "22 avenue des aurores", bayonne, null));

		Room andromede = roomRepository.save(new Room(null, "Andromède", 70, etoile,null));
		Room capricorne = roomRepository.save(new Room(null, "Capricorne", 80, etoile,null));
		Room sirius = roomRepository.save(new Room(null, "Sirius", 150, etoile,null));
		Room polaris = roomRepository.save(new Room(null, "Polaris", 45, etoile,null));
		Room vega = roomRepository.save(new Room(null, "Vega", 60, etoile,null));
		Room betelgeuse = roomRepository.save(new Room(null, "Betelgeuse", 90, etoile,null));
		Room sagittaire = roomRepository.save(new Room(null, "Sagittaire", 180, etoile,null));

		Room deneb1 = roomRepository.save(new Room(null, "Deneb 1", 60, star,null));
		Room deneb2 = roomRepository.save(new Room(null, "Deneb 2", 70, star,null));
		Room deneb3 = roomRepository.save(new Room(null, "Deneb 3", 80, star,null));
		Room roomStar1 = roomRepository.save(new Room(null, "Star 1", 50, star,null));
		Room roomStar2 = roomRepository.save(new Room(null, "Star 2", 80, star,null));
		Room roomStar3 = roomRepository.save(new Room(null, "Star 3", 100, star,null));

		Room roomTournesol1 = roomRepository.save(new Room(null, "Tournesol 1", 50, tournesol,null));
		Room roomTournesol2 = roomRepository.save(new Room(null, "Tournesol 2", 80, tournesol,null));
		Room roomTournesol3 = roomRepository.save(new Room(null, "Tournesol 3", 100, tournesol,null));

		Room roomRose1 = roomRepository.save(new Room(null, "Rose 1", 50, rose,null));
		Room roomRose2 = roomRepository.save(new Room(null, "Rose 2", 80, rose,null));
		Room roomRose3 = roomRepository.save(new Room(null, "Rose 3", 100, rose,null));

		Room roomTulipes1 = roomRepository.save(new Room(null, "Tulipes 1", 50, tulipes,null));
		Room roomTulipes2 = roomRepository.save(new Room(null, "Tulipes 2", 80, tulipes,null));
		Room roomTulipes3 = roomRepository.save(new Room(null, "Tulipes 3", 100, tulipes,null));

		Room roomAzur1 = roomRepository.save(new Room(null, "Azur 1", 50, azur,null));
		Room roomAzur2 = roomRepository.save(new Room(null, "Azur 2", 80, azur,null));
		Room roomAzur3 = roomRepository.save(new Room(null, "Azur 3", 100, azur,null));

		Room roomSelect1 = roomRepository.save(new Room(null, "Select 1", 50, select,null));
		Room roomSelect2 = roomRepository.save(new Room(null, "Select 2", 80, select,null));
		Room roomSelect3 = roomRepository.save(new Room(null, "Select 3", 100, select,null));

		Room roomOlivier1 = roomRepository.save(new Room(null, "Olivier 1", 50, olivier,null));
		Room roomOlivier2 = roomRepository.save(new Room(null, "Olivier 2", 80, olivier,null));
		Room roomOlivier3 = roomRepository.save(new Room(null, "Olivier 3", 100, olivier,null));

		Room roomLaurier1 = roomRepository.save(new Room(null, "Laurier 1", 50, laurier,null));
		Room roomLaurier2 = roomRepository.save(new Room(null, "Laurier 2", 80, laurier,null));
		Room roomLaurier3 = roomRepository.save(new Room(null, "Laurier 3", 100, laurier,null));

		Room roomCactus1 = roomRepository.save(new Room(null, "Cactus 1", 50, cactus,null));
		Room roomCactus2 = roomRepository.save(new Room(null, "Cactus 2", 80, cactus,null));
		Room roomCactus3 = roomRepository.save(new Room(null, "Cactus 3", 100, cactus,null));

		Room roomPassion1 = roomRepository.save(new Room(null, "Passion 1", 50, passion,null));
		Room roomPassion2 = roomRepository.save(new Room(null, "Passion 2", 80, passion,null));
		Room roomPassion3 = roomRepository.save(new Room(null, "Passion 3", 100, passion,null));

		Room roomVoie1 = roomRepository.save(new Room(null, "Voie 1", 50, voie,null));
		Room roomVoie2 = roomRepository.save(new Room(null, "Voie 2", 80, voie,null));
		Room roomVoie3 = roomRepository.save(new Room(null, "Voie 3", 100, voie,null));

		Room roomColline1 = roomRepository.save(new Room(null, "Colline 1", 50, colline,null));
		Room roomColline2 = roomRepository.save(new Room(null, "Colline 2", 80, colline,null));
		Room roomColline3 = roomRepository.save(new Room(null, "Colline 3", 100, colline,null));

		Room roomPrairie1 = roomRepository.save(new Room(null, "Prairie 1", 50, prairie,null));
		Room roomPrairie2 = roomRepository.save(new Room(null, "Prairie 2", 80, prairie,null));
		Room roomPrairie3 = roomRepository.save(new Room(null, "Prairie 3", 100, prairie,null));

		Room roomVallee1 = roomRepository.save(new Room(null, "Vallee 1", 50, vallee,null));
		Room roomVallee2 = roomRepository.save(new Room(null, "Vallee 2", 80, vallee,null));
		Room roomVallee3 = roomRepository.save(new Room(null, "Vallee 3", 100, vallee,null));

		Room roomBouquet1 = roomRepository.save(new Room(null, "Bouquet 1", 50, bouquet,null));
		Room roomBouquet2 = roomRepository.save(new Room(null, "Bouquet 2", 80, bouquet,null));
		Room roomBouquet3 = roomRepository.save(new Room(null, "Bouquet 3", 100, bouquet,null));

		Room roomBarquette1 = roomRepository.save(new Room(null, "Barquette 1", 50, barquette,null));
		Room roomBarquette2 = roomRepository.save(new Room(null, "Barquette 2", 80, barquette,null));
		Room roomBarquette3 = roomRepository.save(new Room(null, "Barquette 3", 100, barquette,null));

		Room roomForet1 = roomRepository.save(new Room(null, "Foret 1", 50, foret,null));
		Room roomForet2 = roomRepository.save(new Room(null, "Foret 2", 80, foret,null));
		Room roomForet3 = roomRepository.save(new Room(null, "Foret 3", 100, foret,null));

		Room roomRuisseau1 = roomRepository.save(new Room(null, "Ruisseau 1", 50, ruisseau,null));
		Room roomRuisseau2 = roomRepository.save(new Room(null, "Ruisseau 2", 80, ruisseau,null));
		Room roomRuisseau3 = roomRepository.save(new Room(null, "Ruisseau 3", 100, ruisseau,null));

		Room roomCascade1 = roomRepository.save(new Room(null, "Cascade 1", 50, cascade,null));
		Room roomCascade2 = roomRepository.save(new Room(null, "Cascade 2", 80, cascade,null));
		Room roomCascade3 = roomRepository.save(new Room(null, "Cascade 3", 100, cascade,null));

		Room roomRex1 = roomRepository.save(new Room(null, "Rex 1", 50, rex,null));
		Room roomRex2 = roomRepository.save(new Room(null, "Rex 2", 80, rex,null));
		Room roomRex3 = roomRepository.save(new Room(null, "Rex 3", 100, rex,null));

		Room roomNuage1 = roomRepository.save(new Room(null, "Nuage 1", 50, nuage,null));
		Room roomNuage2 = roomRepository.save(new Room(null, "Nuage 2", 80, nuage,null));
		Room roomNuage3 = roomRepository.save(new Room(null, "Nuage 3", 100, nuage,null));

		Room roomTempete1 = roomRepository.save(new Room(null, "Tempete 1", 50, tempete,null));
		Room roomTempete2 = roomRepository.save(new Room(null, "Tempete 2", 80, tempete,null));
		Room roomTempete3 = roomRepository.save(new Room(null, "Tempete 3", 100, tempete,null));

		Room roomOrage1 = roomRepository.save(new Room(null, "Orage 1", 50, orage,null));
		Room roomOrage2 = roomRepository.save(new Room(null, "Orage 2", 80, orage,null));
		Room roomOrage3 = roomRepository.save(new Room(null, "Orage 3", 100, orage,null));

		Room roomVent1 = roomRepository.save(new Room(null, "Vent 1", 50, vent,null));
		Room roomVent2 = roomRepository.save(new Room(null, "Vent 2", 80, vent,null));
		Room roomVent3 = roomRepository.save(new Room(null, "Vent 3", 100, vent,null));

		Room roomPluie1 = roomRepository.save(new Room(null, "Pluie 1", 50, pluie,null));
		Room roomPluie2 = roomRepository.save(new Room(null, "Pluie 2", 80, pluie,null));
		Room roomPluie3 = roomRepository.save(new Room(null, "Pluie 3", 100, pluie,null));

		Room roomEclair1 = roomRepository.save(new Room(null, "Eclair 1", 50, eclair,null));
		Room roomEclair2 = roomRepository.save(new Room(null, "Eclair 2", 80, eclair,null));
		Room roomEclair3 = roomRepository.save(new Room(null, "Eclair 3", 100, eclair,null));

		Room roomTonnerre1 = roomRepository.save(new Room(null, "Tonnerre 1", 50, tonnerre,null));
		Room roomTonnerre2 = roomRepository.save(new Room(null, "Tonnerre 2", 80, tonnerre,null));
		Room roomTonnerre3 = roomRepository.save(new Room(null, "Tonnerre 3", 100, tonnerre,null));

		Room roomArc1 = roomRepository.save(new Room(null, "Arc 1", 50, arc,null));
		Room roomArc2 = roomRepository.save(new Room(null, "Arc 2", 80, arc,null));
		Room roomArc3 = roomRepository.save(new Room(null, "Arc 3", 100, arc,null));

		Room roomAurores1 = roomRepository.save(new Room(null, "Aurores 1", 50, aurores,null));
		Room roomAurores2 = roomRepository.save(new Room(null, "Aurores 2", 80, aurores,null));
		Room roomAurores3 = roomRepository.save(new Room(null, "Aurores 3", 100, aurores,null));

		Movie theFlash = movieRepository.save(new Movie((Long) null,"The Flash","Andy Muschietti", "Ezra Miller, Sasha Calle, Michael Shannon","Les réalités s’affrontent dans THE FLASH lorsque Barry se sert de ses super-pouvoirs pour remonter le temps et modifier son passé.",144,new Date(), null));

		CinemaStreeming firstSession = cinemaStreemingRepository.save(new CinemaStreeming((Long) null,13.50,new Date(),1, roomAurores3,theFlash));

	}
}