package com.wcg.wcg.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.domain.Specification;

import com.wcg.wcg.api.dto.search.TalentSearchDto;
import com.wcg.wcg.entity.TalentEntity;
import com.wcg.wcg.entity.TalentEntity_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TalentSpecification implements Specification<TalentEntity> {

    private final TalentSearchDto searchValues;

    @Override
    public Predicate toPredicate(Root<TalentEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if(searchValues.getSearchText()!=null)
        {
            String searchQuery = "%" + searchValues.getSearchText().trim().replaceAll(" +", "%") + "%";
            predicates.add(createSearch(searchQuery, criteriaBuilder, 
                root.get(TalentEntity_.name),
                root.get(TalentEntity_.description)
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
