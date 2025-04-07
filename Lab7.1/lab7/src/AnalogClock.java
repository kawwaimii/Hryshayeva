public class AnalogClock {
    private int hourHandAngle;
    private int minuteHandAngle;

    public AnalogClock(int hourHandAngle, int minuteHandAngle) {
        this.hourHandAngle = hourHandAngle;
        this.minuteHandAngle = minuteHandAngle;
    }

    public int getHourHandAngle() {
        return hourHandAngle;
    }

    public int getMinuteHandAngle() {
        return minuteHandAngle;
    }
}
