package fr.fms;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.CinemaStreeming;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class DistopiaApplicationTests {
	@Autowired
	IBusinessImpl iBusiness;

	@Test
	void testTotalAmontCart() {
		// Arrange
		iBusiness.addCinemaStreemingToCard(new CinemaStreeming((long)1,"10h",10, LocalDate.of(2023,06,23),1,null,null));
		iBusiness.addCinemaStreemingToCard(new CinemaStreeming((long)2,"11h",10,LocalDate.of(2023,06,23),1,null,null));
		iBusiness.addCinemaStreemingToCard(new CinemaStreeming((long)3,"12h",10,LocalDate.of(2023,06,23),1,null,null));

		// Act
		double amount = iBusiness.getTotalAmount();

		// Assert
		assertEquals(amount,30);
	}

	@Test
	void changeQuantityWhenAddSameCinemaStreemingToCart() {
		//GIVEN
		iBusiness.deleteCart();
		CinemaStreeming cinemaStreeming = new CinemaStreeming((long)1,"10h",10, LocalDate.of(2023,06,23),1,null,null);

		//WHEN
		iBusiness.addCinemaStreemingToCard(cinemaStreeming);
		iBusiness.addCinemaStreemingToCard(cinemaStreeming);
		iBusiness.addCinemaStreemingToCard(cinemaStreeming);

		//THEN
		System.out.println("-------------->" + iBusiness.getNbInCart());
		assertEquals(iBusiness.getNbInCart(),1);
	}
}
