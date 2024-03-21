package com.chang.omg.application.game;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chang.omg.domains.game.domain.GameCharacterSearchLog;
import com.chang.omg.domains.game.domain.GameCharacterSearchRank;
import com.chang.omg.domains.game.domain.GameType;
import com.chang.omg.domains.game.repository.GameCharacterSearchLogRepository;
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
@Transactional
public class GameService {

    private final MapleStoryMApi mapleStoryMApi;
    private final GameCharacterSearchLogRepository gameCharacterSearchLogRepository;

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
                .gameType(GameType.MAPLESTORYM)
                .worldName(worldName)
                .characterName(characterName)
                .build();

        gameCharacterSearchLogRepository.save(gameCharacterSearchLog);
    }

    @Transactional(readOnly = true)
    public List<GameCharacterSearchRank> getGameCharacterSearchRank(final GameType gameType) {
        return gameCharacterSearchLogRepository.findGameCharacterSearchRank(gameType);
    }
}
