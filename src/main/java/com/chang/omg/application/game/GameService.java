package com.chang.omg.application.game;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chang.omg.domain.game.maplestorym.domain.GameCharacterSearchLog;
import com.chang.omg.domain.game.maplestorym.domain.GameType;
import com.chang.omg.domain.game.maplestorym.repository.GameCharacterSearchLogRepository;
import com.chang.omg.infrastructure.api.maplestorym.MapleStoryMApi;
import com.chang.omg.infrastructure.api.maplestorym.dto.Character;
import com.chang.omg.infrastructure.api.maplestorym.dto.CharacterBasic;
import com.chang.omg.infrastructure.api.maplestorym.dto.CharacterGuild;
import com.chang.omg.infrastructure.api.maplestorym.dto.CharacterItemEquipment;
import com.chang.omg.infrastructure.api.maplestorym.dto.CharacterStat;
import com.chang.omg.presentation.game.dto.MapleStoryMCharacterInfoResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

    private final MapleStoryMApi mapleStoryMApi;
    private final GameCharacterSearchLogRepository gameCharacterSearchLogRepository;

    @Transactional
    public MapleStoryMCharacterInfoResponse getMapleStoryMCharacterInfo(
            final String characterName,
            final String worldName
    ) {
        final Character character = mapleStoryMApi.getCharacterOcid(characterName, worldName);
        final CharacterBasic characterBasic = mapleStoryMApi.getCharacterBasic(character.ocid());
        final CharacterItemEquipment characterItemEquipment = mapleStoryMApi.getCharacterItem(character.ocid());
        final CharacterStat characterStat = mapleStoryMApi.getCharacterStat(character.ocid());
        final CharacterGuild characterGuild = mapleStoryMApi.getCharacterGuild(character.ocid());

        saveGameCharacterSearchLog(worldName, characterName);

        return MapleStoryMCharacterInfoResponse.of(
                characterBasic,
                characterItemEquipment,
                characterStat,
                characterGuild
        );
    }

    private void saveGameCharacterSearchLog(final String worldName, final String characterName) {
        final GameCharacterSearchLog gameCharacterSearchLog = GameCharacterSearchLog.builder()
                .gameType(GameType.MAPLESTORY_M)
                .worldName(worldName)
                .characterName(characterName)
                .build();

        gameCharacterSearchLogRepository.save(gameCharacterSearchLog);
    }
}
