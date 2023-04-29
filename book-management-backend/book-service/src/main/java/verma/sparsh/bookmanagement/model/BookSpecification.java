package verma.sparsh.bookmanagement.model;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookSpecification implements Specification<Book> {

    List<SearchCriteria> searchCriteria;

    BookSpecification() {
        searchCriteria = new ArrayList<>();
    }

    public void  add(SearchCriteria searchCriteria){
        this.searchCriteria.add(searchCriteria);
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();
        for(SearchCriteria criteria: searchCriteria) {
            if(criteria.getOperation().equalsIgnoreCase("Equal")) {
                predicateList.add(criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue()));
            }
        }
        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }

    public List<SearchCriteria> getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(List<SearchCriteria> searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
