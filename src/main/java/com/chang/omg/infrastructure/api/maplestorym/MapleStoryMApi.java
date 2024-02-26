package com.chang.omg.infrastructure.api.maplestorym;

import com.chang.omg.infrastructure.domain.maplestorym.CharacterBasic;
import com.chang.omg.infrastructure.domain.maplestorym.CharacterItemEquipment;
import com.chang.omg.infrastructure.domain.maplestorym.Ocid;

public interface MapleStoryMApi {

    Ocid getCharacterOcid(final String characterName, final String worldName);

    CharacterBasic getCharacterBasic(final String ocid);

    CharacterItemEquipment getCharacterItem(final String ocid);
}
