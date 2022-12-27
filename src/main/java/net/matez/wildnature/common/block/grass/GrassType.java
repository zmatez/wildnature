package net.matez.wildnature.common.block.grass;

public enum GrassType {
    BARREN("barren",true),
    TROPICAL("tropical",true)
    ;
    private final String idBase;
    private final boolean tinted;

    GrassType(String idBase, boolean tinted){
        this.idBase = idBase;
        this.tinted = tinted;
    }

    public String getIdBase() {
        return idBase;
    }

    public boolean isTinted() {
        return tinted;
    }
}
