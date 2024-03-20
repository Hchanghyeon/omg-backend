package com.chang.omg.domain.game.maplestorym.domain;

import java.util.Objects;

import com.chang.omg.domain.game.common.domain.BaseEntity;
import com.chang.omg.domain.game.maplestorym.repository.GameTypeConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameCharacterSearchLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = GameTypeConverter.class)
    @Column(name = "game_type", nullable = false)
    private GameType gameType;

    @Column(name = "world_name")
    private String worldName;

    @Column(name = "character_name", nullable = false)
    private String characterName;

    @Builder
    private GameCharacterSearchLog(final GameType gameType, final String worldName, final String characterName) {
        this.gameType = Objects.requireNonNull(gameType);
        this.worldName = Objects.requireNonNull(worldName);
        this.characterName = Objects.requireNonNull(characterName);
    }
}
