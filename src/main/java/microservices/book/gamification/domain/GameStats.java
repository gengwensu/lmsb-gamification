package microservices.book.gamification.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This object contains the result of one or many iterations of the game.
 * It may contain any combination of {@link ScoreCard} objects and {@link BadgeCard} objects.
 * <p>
 * It can be used as a delta (as a single game iteration) or to represent the total amount of score/badges.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class GameStats {
    private final Long userId;
    private final int score;
    private final List<Badge> badges;

    public GameStats() {
        this(0L, 0, new ArrayList<>());
    }

    /**
     * Factory method to build an immutable empty instance (zero points and no badges)
     * @param userId the user's id
     * @return a {@link GameStats} object with 0 score and no badges
     */
    public static GameStats emptyStats(final Long userId){
        return new GameStats(userId, 0, Collections.emptyList());
    }

    /**
     * @return an unmodifiable view of the badge cards list
     */
    public List<Badge> getBadges() {
        return Collections.unmodifiableList(badges);
    }
}
