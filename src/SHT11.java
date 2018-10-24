package lab.sht11;

import processing.core.*;

public class SHT11 {
    PApplet parent;
    public static final int address = 0x40;

    public static class temperature {
        public static final int register = 0xE3;
        public static final int bytes = 3;

        public static float value(int[] data) {
            if (data.length == 0)
                return 0;
            float result = data[0] << 8 | data[1];
            result *= 175.72;
            result /= 65536;
            result -= 46.85;
            return result;
        }
    }

    public static class humidity {
        public static final int register = 0xE5;
        public static final int bytes = 3;

        public static float value(int[] data) {
            if (data.length == 0)
                return 0;
            float result = data[0] << 8 | data[1];
            result *= 125;
            result /= 65536;
            result -=6;
            return result;
        }
    }

    public SHT11(PApplet parent) {
        this.parent = parent;
        parent.registerMethod("dispose", this);
    }

    public void dispose() {
    }

    

}