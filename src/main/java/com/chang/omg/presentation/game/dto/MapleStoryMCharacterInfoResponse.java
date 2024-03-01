package com.chang.omg.presentation.game.dto;

import com.chang.omg.domain.game.maplestorym.CharacterBasic;
import com.chang.omg.domain.game.maplestorym.CharacterGuild;
import com.chang.omg.domain.game.maplestorym.CharacterItemEquipment;
import com.chang.omg.domain.game.maplestorym.CharacterStat;

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
