package com.chang.omg.infrastructure.dto;

import com.chang.omg.infrastructure.domain.maplestorym.CharacterBasic;
import com.chang.omg.infrastructure.domain.maplestorym.CharacterItemEquipment;

public record MapleStoryMCharacterInfoResponse(
        CharacterBasic characterBasic,
        CharacterItemEquipment characterItemEquipment
) {

    public static MapleStoryMCharacterInfoResponse of(
            final CharacterBasic characterBasic,
            final CharacterItemEquipment characterItemEquipment
    ) {
        return new MapleStoryMCharacterInfoResponse(characterBasic, characterItemEquipment);
    }
}
