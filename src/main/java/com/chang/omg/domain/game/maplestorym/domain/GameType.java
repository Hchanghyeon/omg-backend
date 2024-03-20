package com.chang.omg.domain.game.maplestorym.domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.chang.omg.common.exception.ApiException;
import com.chang.omg.common.exception.ApiExceptionCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GameType {
    MAPLESTORY_M("메이플스토리M"),
    CARTRIDER_RUSHPLUS("카트라이더러쉬플러스"),
    V4("V4"),
    HIT2("히트2"),
    KINGDOM_OF_THE_WINDS("바람의나라:연");

    private static final Map<String, GameType> gameTypeMap = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(GameType::getName, Function.identity())));

    private final String name;

    public static GameType from(final String value) {
        if (gameTypeMap.containsKey(value)) {
            return gameTypeMap.get(value);
        }

        throw new ApiException(ApiExceptionCode.API_GAME_TYPE_IS_INVALID, value);
    }
}
