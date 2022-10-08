package tn.esprit.fundme.services;

import java.util.List;

import tn.esprit.fundme.entities.Credits;
import tn.esprit.fundme.entities.Offer;

public interface IOfferService {
	
	List<Offer> retrieveAllOffers();

	Offer addOffer(Offer o);

	void deleteOffer(Long id);

	Offer updateOffer(Offer o);

	Offer retrieveOffer(Long id);
	
	Offer searchOfferScore(int score);
	
	void assignOfferToCredit(Offer o , Credits  c);
	
	
}
