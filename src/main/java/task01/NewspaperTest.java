package task01;

public class NewspaperTest {
    public static void main(String[] args) {
        Newspaper newspaper = new Newspaper();

        // Создаем массив читателей
        int readerCount = 100;
        Reader[] readers = new Reader[readerCount];
        for (int i = 0; i < readerCount; i++) {
            readers[i] = new Reader(newspaper);
        }

        // Запускаем читателей в отдельных потоках
        for (Reader reader : readers) {
            new Thread(reader).start();
        }

        // Запускаем писателя в отдельном потоке
        Writer writer = new Writer(newspaper);
        new Thread(writer).start();
    }
}

class Reader implements Runnable {
    private final Newspaper newspaper;

    public Reader(Newspaper newspaper) {
        this.newspaper = newspaper;
    }

    @Override
    public void run() {
        try {
            newspaper.readNewspaper();
            System.out.println("Читатель прочитал газету");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Writer implements Runnable {
    private final Newspaper newspaper;

    public Writer(Newspaper newspaper) {
        this.newspaper = newspaper;
    }

    @Override
    public void run() {
        try {
            newspaper.editNewspaper();
            System.out.println("Писатель отредактировал газету");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
