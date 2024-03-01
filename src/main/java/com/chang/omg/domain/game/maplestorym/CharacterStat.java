package com.chang.omg.domain.game.maplestorym;

import java.util.List;

public record CharacterStat(List<Stat> stat) {

    record Stat(String statName, String statValue) {

    }
}
