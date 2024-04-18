package DashEsgApi.DashEsgApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import DashEsgApi.DashEsgApi.entities.Books;
import DashEsgApi.DashEsgApi.model.BookModel;


public interface BooksRepository extends JpaRepository<Books, Integer>{
	
	@Nullable
	List<Books> findAll();
	
	@Nullable
	Books findById(int id);
	
	Books save(Books book);
	
	void deleteById(int id);

}