package com.chang.omg.infrastructure.api.maplestorym;

import com.chang.omg.domain.game.maplestorym.Character;
import com.chang.omg.domain.game.maplestorym.CharacterBasic;
import com.chang.omg.domain.game.maplestorym.CharacterGuild;
import com.chang.omg.domain.game.maplestorym.CharacterItemEquipment;
import com.chang.omg.domain.game.maplestorym.CharacterStat;

public interface MapleStoryMApi {

    Character getCharacterOcid(final String characterName, final String worldName);

    CharacterBasic getCharacterBasic(final String ocid);

    CharacterItemEquipment getCharacterItem(final String ocid);

    CharacterStat getCharacterStat(final String ocid);

    CharacterGuild getCharacterGuild(final String ocid);
}
