package com.kmt.jpaspec.specification;

import com.kmt.jpaspec.domain.Member;
import com.kmt.jpaspec.web.model.FilterRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class MemberSpecification extends BaseSpecification<Member, FilterRequest> {

    @Override
    public Specification getFilter( FilterRequest request ) {
        return (root, query, cb) -> {
            query.distinct(true);
            query.orderBy(cb.asc(root.get("lastName")));
            return where(isActive(request.getActive())
                    .and(inZipCode(request.getZipFilter())))
                    .toPredicate(root, query, cb);
        };
    }

    private Specification<Member> isActive( Boolean isActive) {
        return (root, query, cb) -> {
            if (isActive != null) {
                return cb.equal(root.get("active"), isActive);
            } else {
                return null;
            }
        };
    }

    private Specification<Member> inZipCode(String zipFilter) {
        return (root, query, cb) -> {
            if (zipFilter != null) {
                return cb.like(root.get("zipCode"), cb.literal(zipFilter + "%"));
            } else {
                return null;
            }
        };
    }

}
