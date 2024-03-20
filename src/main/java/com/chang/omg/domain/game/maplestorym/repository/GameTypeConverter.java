package com.chang.omg.domain.game.maplestorym.repository;

import com.chang.omg.domain.game.maplestorym.domain.GameType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;

@Convert
public final class GameTypeConverter implements AttributeConverter<GameType, String> {

    @Override
    public String convertToDatabaseColumn(final GameType gameType) {
        return gameType.getName();
    }

    @Override
    public GameType convertToEntityAttribute(final String gameName) {
        return GameType.from(gameName);
    }
}
