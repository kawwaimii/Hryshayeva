public class AnalogToDigitalAdapter implements DigitalClock {
    private AnalogClock analogClock;

    public AnalogToDigitalAdapter(AnalogClock analogClock) {
        this.analogClock = analogClock;
    }

    @Override
    public String getTime() {
        int hour = analogClock.getHourHandAngle() / 30; // 30 градусов = 1 час
        int minute = analogClock.getMinuteHandAngle() / 6; // 6 градусов = 1 минута
        return String.format("%02d:%02d", hour, minute);
    }
}
