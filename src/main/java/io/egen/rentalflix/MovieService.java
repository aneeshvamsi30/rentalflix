package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
	private ArrayList<Movie> list;
	private HashMap<Integer, String> rentMovie;
	
	public MovieService() {
		list = new ArrayList<Movie>();
		list.add(new Movie(1, 2008,"Batman Begins","English"));
		list.add(new Movie(2, 2010,"The Dark Knight","English"));
		list.add(new Movie(3, 2012,"The Dark Knight Rises","English"));
		list.add(new Movie(4, 2016,"Batman vs Superman","English"));
		list.add(new Movie(5, 2012,"Taare Zameen Par","Hindi"));
		rentMovie = new HashMap<Integer,String>();
		rentMovie.put(1,"SSHM");
	}

	@Override
	public List<Movie> findAll() {
	
		return list;
	}

	@Override
	public List<Movie> findByName(String name) {
		
		ArrayList<Movie> nameList = new ArrayList<Movie>();
		
		for(int i=0; i<list.size();i++)
		if(list.get(i).getTitle().equals(name))
			nameList.add(list.get(i));
		
		return nameList;
	}

	@Override
	public Movie create(Movie movie) {
		list.add(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		
		for(int i=0; i<list.size();i++)
		if(list.get(i).getId()==movie.getId())
		
			{ 	
				list.set(i, movie);
				return list.get(i);
			}
		
		throw new IllegalArgumentException();
				
	}

	@Override
	public Movie delete(int id) {
		
		for(int i=0; i<list.size();i++)
			if(list.get(i).getId()==id)
			{
				 Movie deletedMovie = list.get(i);
				list.remove(i);
				return deletedMovie;
			}
			
		throw new IllegalArgumentException();
		
	}

	@Override
	public boolean rentMovie(int movieId, String user) {
		
		if(rentMovie.containsKey(new Integer(movieId)))
		{
			throw new IllegalArgumentException();
		}
		
		rentMovie.put(new Integer(movieId), "User");
		
		return true;
			
	}

}
