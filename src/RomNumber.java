public enum RomNumber {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10);

    private final int associations;

    RomNumber(int associations) {
        this.associations = associations;

    }

    int getAssociations() {
        return associations;
    }

}
