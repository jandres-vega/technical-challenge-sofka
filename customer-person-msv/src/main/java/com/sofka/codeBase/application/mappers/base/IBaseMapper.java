package com.sofka.codeBase.application.mappers.base;

@FunctionalInterface
public interface IBaseMapper<S, O> {
    O map(S source);
}
