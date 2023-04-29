package verma.sparsh.bookmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity(name = "author")
public class Author {

    @Id
    private long id;
    private String authorName;
    @OneToMany(mappedBy = "author")
    private List<Book> book;
}
