package com.chang.omg.application.game;

import org.springframework.stereotype.Service;

import com.chang.omg.infrastructure.api.maplestorym.MapleStoryMApi;
import com.chang.omg.infrastructure.domain.maplestorym.CharacterBasic;
import com.chang.omg.infrastructure.domain.maplestorym.CharacterItemEquipment;
import com.chang.omg.infrastructure.domain.maplestorym.Ocid;
import com.chang.omg.infrastructure.dto.MapleStoryMCharacterInfoResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

    private final MapleStoryMApi mapleStoryMApi;

    public MapleStoryMCharacterInfoResponse getMapleStoryMCharacterInfo(
            final String characterName,
            final String worldName
    ) {
        final Ocid ocid = mapleStoryMApi.getCharacterOcid(characterName, worldName);
        final CharacterBasic characterBasic = mapleStoryMApi.getCharacterBasic(ocid.ocid());
        final CharacterItemEquipment characterItemEquipment = mapleStoryMApi.getCharacterItem(ocid.ocid());

        return MapleStoryMCharacterInfoResponse.of(characterBasic, characterItemEquipment);
    }
}
