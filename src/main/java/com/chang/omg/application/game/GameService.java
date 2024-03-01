package com.chang.omg.application.game;

import org.springframework.stereotype.Service;

import com.chang.omg.domain.game.maplestorym.Character;
import com.chang.omg.domain.game.maplestorym.CharacterBasic;
import com.chang.omg.domain.game.maplestorym.CharacterGuild;
import com.chang.omg.domain.game.maplestorym.CharacterItemEquipment;
import com.chang.omg.domain.game.maplestorym.CharacterStat;
import com.chang.omg.infrastructure.api.maplestorym.MapleStoryMApi;
import com.chang.omg.presentation.game.dto.MapleStoryMCharacterInfoResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

    private final MapleStoryMApi mapleStoryMApi;

    public MapleStoryMCharacterInfoResponse getMapleStoryMCharacterInfo(
            final String characterName,
            final String worldName
    ) {
        final Character character = mapleStoryMApi.getCharacterOcid(characterName, worldName);
        final CharacterBasic characterBasic = mapleStoryMApi.getCharacterBasic(character.ocid());
        final CharacterItemEquipment characterItemEquipment = mapleStoryMApi.getCharacterItem(character.ocid());
        final CharacterStat characterStat = mapleStoryMApi.getCharacterStat(character.ocid());
        final CharacterGuild characterGuild = mapleStoryMApi.getCharacterGuild(character.ocid());

        return MapleStoryMCharacterInfoResponse.of(
                characterBasic,
                characterItemEquipment,
                characterStat,
                characterGuild
        );
    }
}
