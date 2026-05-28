package com.arl.reading_list.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.arl.reading_list.entity.Book;
import com.arl.reading_list.repository.BookRepository;


@Service
public class BookService {

    @Autowired private BookRepository repo;

    public Page<Book> getAll(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }

    public Page<Book> search(String q, int page, int size) {
    return repo.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
        q, q, PageRequest.of(page, size));
}

    public Book create(Book book) { return repo.save(book); }

    public Book update(Book updated) {

    Book book = repo.findById(updated.getId())
        .orElseThrow(() -> new RuntimeException("Book not found"));
    book.setTitle(updated.getTitle());
    book.setAuthor(updated.getAuthor());
    book.setCategory(updated.getCategory());
    book.setDescription(updated.getDescription());
    return repo.save(book);
}

    public void delete(Long id) { 
        if (!repo.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        repo.deleteById(id); }
}

