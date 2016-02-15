package io.egen.rentalflix;

import org.junit.Assert;
import org.junit.Test;



/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {

	@Test
	public void findByNameTest1()
	{
		Assert.assertNotEquals(null, new MovieService().findAll());

	}
	@Test
	public void findByNameTest2()
	{
		Assert.assertEquals("Batman vs Superman", new MovieService().findByName("Batman vs Superman").get(0).getTitle());

	}
	@Test	
	public void findAll ()
	{
		Assert.assertNotEquals(null, new MovieService().findAll());
		
	}
	
	@Test
	public void create ()
	{
		Movie movie = new Movie(1,2012,"Abcd","Telugu");
		Assert.assertEquals(movie, new MovieService().create(movie));
	}
	
	@Test
	public void update ()
	{
		Movie movie = new Movie(1,2012,"Abcd","Telugu");
		Assert.assertEquals(movie, new MovieService().update(movie));
	}
	@Test(expected=IllegalArgumentException.class)
	public void updateException ()
	{
		Movie movie = new Movie(12,2012,"Abcd","Telugu");
		 new MovieService().update(movie);
	}
	@Test
	public void delete_deleteList ()
	{
		
		Assert.assertEquals(new Integer(2), new Integer(new MovieService().delete(2).getId()));
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void delete_Exception ()
	{
		
		Movie movie = new Movie(15,2012,"Abcd","Telugu");
		new MovieService().delete(movie.getId());
		
	}
	@Test
	public void delete_MovieList ()
	{
		MovieService instance = new MovieService();
		int movieListSize = instance.findAll().size(); 
		instance.delete(3);
		int size = instance.findAll().size();
		Assert.assertEquals(new Integer(movieListSize-1), new Integer(size));
		
	}
	@Test
	public void rentMovie ()
	{
		Assert.assertEquals(true, new MovieService().rentMovie(2,"asa"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void rentMovie_Exception()
	{
		new MovieService().rentMovie(1,"SS");
		
	}
}

