package Colors;

/**
 *
 * @author khaledhazime
 */
public class Colors {
    // Set terminal colors enums
    static String WHITE = "\033[0;37m";
    static String RED = "\033[0;31m";
    static String GREEN = "\033[0;32m";
    static String BLUE = "\033[0;34m";
    static String YELLOW = "\033[0;33m";
    
    // Set terminal colors methods
    public static String getColor(int color){
        return switch (color) {
            case 1 -> BLUE;
            case 2 -> RED;
            case 3 -> GREEN;
            case 4 -> YELLOW;
            default -> WHITE;
        };
    }

}
