package com.chang.omg.infrastructure.dto;

import com.chang.omg.infrastructure.domain.maplestorym.CharacterBasic;
import com.chang.omg.infrastructure.domain.maplestorym.CharacterGuild;
import com.chang.omg.infrastructure.domain.maplestorym.CharacterItemEquipment;
import com.chang.omg.infrastructure.domain.maplestorym.CharacterStat;

public record MapleStoryMCharacterInfoResponse(
        CharacterBasic characterBasic,
        CharacterItemEquipment characterItemEquipment,
        CharacterStat characterStat,
        CharacterGuild characterGuild
) {

    public static MapleStoryMCharacterInfoResponse of(
            final CharacterBasic characterBasic,
            final CharacterItemEquipment characterItemEquipment,
            final CharacterStat characterStat,
            final CharacterGuild characterGuild
    ) {
        return new MapleStoryMCharacterInfoResponse(
                characterBasic,
                characterItemEquipment,
                characterStat,
                characterGuild
        );
    }
}
