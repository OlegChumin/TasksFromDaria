package task01;

import java.util.concurrent.Semaphore;

public class Newspaper {
    private final Semaphore readerSemaphore = new Semaphore(10); // Максимально 10 читателей одновременно
    private final Semaphore writerSemaphore = new Semaphore(1);  // Только 1 писатель может редактировать

    public void readNewspaper() throws InterruptedException {
        readerSemaphore.acquire(); // Запрашиваем доступ для читателя
        // Чтение газеты
        Thread.sleep(1000); // Предположим, что читатели читают газету 1 секунду
        readerSemaphore.release(); // Освобождаем доступ для читателя
    }

    public void editNewspaper() throws InterruptedException {
        writerSemaphore.acquire(); // Запрашиваем доступ для писателя
        // Редактирование газеты
        Thread.sleep(2000); // Предположим, что писатели редактируют газету 2 секунды
        writerSemaphore.release(); // Освобождаем доступ для писателя
    }
}
