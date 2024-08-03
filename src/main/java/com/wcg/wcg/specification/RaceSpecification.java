package com.wcg.wcg.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.domain.Specification;

import com.wcg.wcg.api.dto.search.RaceSearchDto;
import com.wcg.wcg.entity.RaceEntity;
import com.wcg.wcg.entity.RaceEntity_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RaceSpecification implements Specification<RaceEntity> {

    private final RaceSearchDto searchValues;

   @Override
    public Predicate toPredicate(Root<RaceEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if(searchValues.getSearchText()!=null)
        {
            String searchQuery = "%" + searchValues.getSearchText().trim().replaceAll(" +", "%") + "%";
            predicates.add(createSearch(searchQuery, criteriaBuilder, 
                root.get(RaceEntity_.name)
            ));
        }
        return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
    }

    @SafeVarargs
    public final Predicate createSearch(String searchQuery, CriteriaBuilder cb, Path<String>... paths)
    {
        return cb.or(Stream.of(paths).map((path)->cb.like(path, searchQuery)).toArray(Predicate[]::new));
    }
    
}
