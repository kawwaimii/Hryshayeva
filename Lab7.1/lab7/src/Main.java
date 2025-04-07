public class Main {
    public static void main(String[] args) {
        AnalogClock analogClock = new AnalogClock(90, 180);
        DigitalClock digitalClock = new AnalogToDigitalAdapter(analogClock);

        System.out.println("Время (цифровые часы): " + digitalClock.getTime());
    }
}
