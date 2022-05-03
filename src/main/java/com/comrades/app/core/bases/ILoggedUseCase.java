package com.comrades.app.core.bases;

import java.io.Serializable;

@FunctionalInterface
public interface ILoggedUseCase {
    Serializable loggedEntityId();
}
