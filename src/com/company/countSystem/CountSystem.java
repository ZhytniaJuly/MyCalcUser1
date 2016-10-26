package com.company.countSystem;

/**
 * Created by yzhitnia on 26.10.16.
 */
public enum CountSystem {
    BINARY_SYSTEM(2) {
        @Override
        public String printValue(Integer value) {
            return Integer.toBinaryString(value);
        }
    },
    DECIMAL_SYSTEM(10) {
        @Override
        public String printValue(Integer value) {
            return Integer.toString(value);
        }
    },
    HEX_SYSTEM(16) {
        @Override
        public String printValue(Integer value) {
            return Integer.toHexString(value);
        }
    };

    private int systemRang;

    CountSystem(int systemRang) {
        this.systemRang = systemRang;
    }

    public abstract String printValue(Integer value);

    public static CountSystem getCountSystemByRange(Integer value) {
        switch (value) {
            case 2:
                return BINARY_SYSTEM;
            case 10:
                return DECIMAL_SYSTEM;
            case 16:
                return HEX_SYSTEM;
            default:
                throw new IllegalArgumentException("There is no such system with rang " + value);
        }
    }


    public Integer getRang() {
        return systemRang;
    }
}
