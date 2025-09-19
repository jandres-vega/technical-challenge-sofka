package com.sofka.codeBase.application.ports.in;

/**
 * Interface for handling queries.
 *
 * @param <Q> Query type.
 * @param <R> Response type.
 */
public interface IQueryHandler<Q extends IQuery, R> {
    R handle(Q query);
}
