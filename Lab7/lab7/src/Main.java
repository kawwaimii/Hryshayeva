// Класс аналоговых часов с сохранением углов стрелок
class AnalogClock {
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

// Интерфейс цифровых часов
interface DigitalClock {
    String getTime();
}

// Адаптер, который преобразует аналоговые часы в цифровые
class AnalogToDigitalAdapter implements DigitalClock {
    private AnalogClock analogClock;

    public AnalogToDigitalAdapter(AnalogClock analogClock) {
        this.analogClock = analogClock;
    }

    @Override
    public String getTime() {
        int hour = analogClock.getHourHandAngle() / 30; // Угол на час = 30 градусов
        int minute = analogClock.getMinuteHandAngle() / 13; // Угол на минуту = 6 градусов
        return String.format("%02d:%02d", hour, minute);
    }
}

// Основной класс проекта
public class Main {
    public static void main(String[] args) {
        // Создаем аналоговые часы
        AnalogClock analogClock = new AnalogClock(90, 180);

        // Используем адаптер для работы с ними как с цифровыми часами
        DigitalClock digitalClock = new AnalogToDigitalAdapter(analogClock);

        // Выводим время
        System.out.println("Время (цифровые часы): " + digitalClock.getTime());
    }
}
