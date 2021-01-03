package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import ma.ensias.ejb3.tp1.SearchBookFacadeLocal;

@WebService
public class BookService {

	@EJB
	private SearchBookFacadeLocal metier;

	@WebMethod
	public List<String> bookSearch(@WebParam(name="bookType")String bookType) {
		return metier.bookSearch(bookType);
	}

	@WebMethod
	public List<String> bookSearchByCountry(@WebParam(name="country")String country) {
		List<String> newList = new ArrayList<String>();
		newList.addAll(metier.bookSearchByCountry(country).get("JAVA"));
		newList.addAll(metier.bookSearchByCountry(country).get("C++"));
		return newList;
	}
	
	
	
}
