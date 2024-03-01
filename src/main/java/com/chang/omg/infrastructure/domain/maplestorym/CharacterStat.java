package com.chang.omg.infrastructure.domain.maplestorym;

import java.util.List;

public record CharacterStat(List<Stat> stat) {

    record Stat(String statName, String statValue) {

    }
}
