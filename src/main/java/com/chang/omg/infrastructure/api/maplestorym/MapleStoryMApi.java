package com.chang.omg.infrastructure.api.maplestorym;

import com.chang.omg.infrastructure.api.maplestorym.dto.Character;
import com.chang.omg.infrastructure.api.maplestorym.dto.CharacterBasic;
import com.chang.omg.infrastructure.api.maplestorym.dto.CharacterGuild;
import com.chang.omg.infrastructure.api.maplestorym.dto.CharacterItemEquipment;
import com.chang.omg.infrastructure.api.maplestorym.dto.CharacterStat;

public interface MapleStoryMApi {

    Character getCharacterOcid(final String characterName, final String worldName);

    CharacterBasic getCharacterBasic(final String ocid);

    CharacterItemEquipment getCharacterItem(final String ocid);

    CharacterStat getCharacterStat(final String ocid);

    CharacterGuild getCharacterGuild(final String ocid);
}
