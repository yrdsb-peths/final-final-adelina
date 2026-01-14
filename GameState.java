/**
 * Stores persistent game state across levels.
 * Tracks unlocked levels and high scores.
 */
public class GameState  
{
    /** Level 1 unlocked status */
    public static boolean level1Unlocked = true;
    
    /** Level 2 unlocked status */
    public static boolean level2Unlocked = false;
    
    /** Level 3 unlocked status */
    public static boolean level3Unlocked = false;

    /** High scores for each level */
    public static int[] levelRecordScore = {0, 0, 0};
}
