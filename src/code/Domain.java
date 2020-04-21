package code;

public class Domain {
    public static final int Y_DOMAIN = 1;
    public static final int X_DOMAIN = 2;


    int typeOFDomain;
    int beginning;
    int end;

    public Domain(int typeOFDomain, int beginning, int end) {
        this.typeOFDomain = typeOFDomain;
        this.beginning = beginning;
        this.end = end;
    }

    public int getTypeOFDomain() {
        return typeOFDomain;
    }

    public int getBeginning() {
        return beginning;
    }

    public int getEnd() {
        return end;
    }

}
