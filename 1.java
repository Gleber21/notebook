
class Ноутбук {
    private String модель;
    private int озу; // Оперативная память в ГБ
    private int объемЖД; // Объем жесткого диска в ГБ
    private String операционнаяСистема;
    private String цвет;

    public Ноутбук(String модель, int озу, int объемЖД, String операционнаяСистема, String цвет) {
        this.модель = модель;
        this.озу = озу;
        this.объемЖД = объемЖД;
        this.операционнаяСистема = операционнаяСистема;
        this.цвет = цвет;
    }

    public String getМодель() {
        return модель;
    }

    public int getОзу() {
        return озу;
    }

    public int getОбъемЖД() {
        return объемЖД;
    }

    public String getОперационнаяСистема() {
        return операционнаяСистема;
    }

    public String getЦвет() {
        return цвет;
    }

    @Override
    public String toString() {
        return "Ноутбук{" +
                "модель='" + модель + '\'' +
                ", озу=" + озу +
                ", объемЖД=" + объемЖД +
                ", операционнаяСистема='" + операционнаяСистема + '\'' +
                ", цвет='" + цвет + '\'' +
                '}';
    }
}

