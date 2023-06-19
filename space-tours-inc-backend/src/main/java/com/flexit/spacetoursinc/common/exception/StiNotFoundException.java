package com.flexit.spacetoursinc.common.exception;

import com.flexit.spacetoursinc.common.enums.StiEntity;
import lombok.Getter;

import java.util.UUID;

@Getter
public class StiNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 4699636364667560957L;

    private final StiEntity notFoundEntity;
    private final UUID notFoundId;

    public StiNotFoundException(StiEntity notFoundEntity, UUID notFoundId) {
        super(String.format("Entity %s with id %s not found", notFoundEntity, notFoundId));
        this.notFoundEntity = notFoundEntity;
        this.notFoundId = notFoundId;
    }
}
