package verma.sparsh.bookmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import verma.sparsh.bookmanagement.model.Book;
import verma.sparsh.bookmanagement.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private BookRepository bookRepository;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> getAllBooks(Pageable pageable) {
        logger.info("Get All Books Service method called.");
        return bookRepository.findAll(pageable);
    }
}
