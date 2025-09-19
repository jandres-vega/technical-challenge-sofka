package com.sofka.codeBase.application.ports.in;

/**
 * Interface for handling commands.
 *
 * @param <Tin> Command type.
 */
public interface ICommandHandler<Tin, Tout>{
    Tout handle(Tin command);
}
