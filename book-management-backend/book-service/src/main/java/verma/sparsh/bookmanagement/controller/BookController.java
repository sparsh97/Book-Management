package verma.sparsh.bookmanagement.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import verma.sparsh.bookmanagement.model.Book;
import verma.sparsh.bookmanagement.service.BookService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/find-all")
    public ResponseEntity<Page<Book>> getAllBooks(Pageable pageable, HttpServletRequest request) {
        logger.info("fina-all books controller method called.");
        return new ResponseEntity<>(bookService.getAllBooks(pageable), HttpStatus.OK);
    }
}
