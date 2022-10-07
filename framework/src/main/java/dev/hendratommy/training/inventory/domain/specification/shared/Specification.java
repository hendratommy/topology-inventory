package dev.hendratommy.training.inventory.domain.specification.shared;

public interface Specification<T> {

    boolean isSatisfiedBy(T t);

    Specification<T> and(Specification<T> specification);
}
