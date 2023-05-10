package Colors;

/**
 *
 * @author khaledhazime
 */
public enum Colors {
    // Set terminal colors enums
    RESET("\033[0m"),
    WHITE("\033[0;37m"),
    RED("\033[0;31m"),
    GREEN("\033[0;32m"),
    BLUE("\033[0;34m");
    
    private final String colorCode;
    Colors(String colorCode){
        this.colorCode = colorCode;
    }

    public String getColorCode(){
        return this.colorCode;
    }

    public String setColor(int color){
        return switch (color) {
            case 0 -> Colors.WHITE.getColorCode();
            case 1 -> Colors.BLUE.getColorCode();
            case 2 -> Colors.RED.getColorCode();
            case 3 -> Colors.GREEN.getColorCode();
            default -> Colors.WHITE.getColorCode();
        };
    }

}
