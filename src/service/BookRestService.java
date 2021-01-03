package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ma.ensias.ejb3.tp1.SearchBookFacadeLocal;
@Stateless
@Path("/")
public class BookRestService {
	@EJB
	private SearchBookFacadeLocal metier;

	
	@GET
	@Path("/booksTypes/{bookType}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> bookSearch(@PathParam(value ="bookType")String bookType) {
		return metier.bookSearch(bookType.toUpperCase());
	}
	@GET
	@Path("/booksCountry/{country}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> bookSearchByCountry(@PathParam(value ="country")String country) {
		List<String> newList = new ArrayList<String>();
		newList.addAll(metier.bookSearchByCountry(country.toUpperCase()).get("JAVA"));
		newList.addAll(metier.bookSearchByCountry(country.toUpperCase()).get("C++"));
		return newList;
	}
	
	
}
