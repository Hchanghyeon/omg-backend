package com.chang.omg.domains.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chang.omg.domains.game.domain.GameCharacterSearchLog;
import com.chang.omg.domains.game.domain.GameCharacterSearchRank;
import com.chang.omg.domains.game.domain.GameType;

public interface GameCharacterSearchLogRepository extends JpaRepository<GameCharacterSearchLog, Long> {

    @Query("""
            SELECT new com.chang.omg.domains.game.domain.GameCharacterSearchRank
            (g.worldName, g.characterName, COUNT(g.characterName))
            FROM GameCharacterSearchLog g 
            WHERE g.createdAt > CURRENT_DATE AND g.gameType =:gameType
            GROUP BY g.characterName, g.worldName 
            ORDER BY COUNT(g.characterName) DESC
            LIMIT 5
            """)
    List<GameCharacterSearchRank> findGameCharacterSearchRank(final GameType gameType);
}
