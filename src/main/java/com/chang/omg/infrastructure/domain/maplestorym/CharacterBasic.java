package com.chang.omg.infrastructure.domain.maplestorym;

public record CharacterBasic(
        String characterName,
        String worldName,
        String characterDateCreate,
        String characterDateLastLogin,
        String characterDateLastLogout,
        String characterJobName,
        String characterGender,
        String characterExp,
        String characterLevel
) {

}
