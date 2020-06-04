package com.company;
import java.util.ArrayList;
import java.util.Random;

public class PassGen {
    private static final String LOW = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "._-";

    private boolean useLow;
    private boolean useUpp;
    private boolean useNumbers;
    private boolean useSymbols;



    private PassGen(PassGenBuilder builder) {
        this.useLow = builder.useLow;
        this.useUpp = builder.useUpp;
        this.useNumbers = builder.useNumbers;
        this.useSymbols = builder.useSymbols;
    }




    public static class PassGenBuilder {
        private boolean useLow;
        private boolean useUpp;
        private boolean useNumbers;
        private boolean useSymbols;


        public PassGenBuilder() {
            this.useLow = false;
            this.useUpp = false;
            this.useNumbers = false;
            this.useSymbols = false;
        }

        public PassGenBuilder useLow(boolean useLow) {
            this.useLow = useLow;
            return this;
        }

        public PassGenBuilder useUpp(boolean useUpp) {
            this.useUpp = useUpp;
            return this;
        }

        public PassGenBuilder useNumbers(boolean useNumbers) {
            this.useNumbers = useNumbers;
            return this;
        }

        public PassGenBuilder useSymbols(boolean useSymbols) {
            this.useSymbols = useSymbols;
            return this;
        }

        public PassGen build() {
            return new PassGen(this);
        }


    }

    public String generate(int length) {
        if (length <= 0) {
            System.out.println("Incorrect password length");
            return "";
        }
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        ArrayList<String> symbolTypes = new ArrayList<String>(4);
        if (useLow) {
            symbolTypes.add(LOW);
        }
        if (useUpp) {
            symbolTypes.add(UPP);
        }

        //password starts with char only
        String symbolType = symbolTypes.get(random.nextInt(symbolTypes.size()));
        password.append(symbolType.charAt(0));

        if (useNumbers) {
            symbolTypes.add(NUMBERS);
        }
        if (useSymbols) {
            symbolTypes.add(SYMBOLS);
        }


        //password continues with all requirement chars
        for (int i = 1; i < length; i++) {
            symbolType = symbolTypes.get(random.nextInt(symbolTypes.size()));
            int position = random.nextInt(symbolType.length());
            password.append(symbolType.charAt(position));
        }

        return new String(password);
    }
}
