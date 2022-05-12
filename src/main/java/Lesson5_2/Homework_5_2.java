package Lesson5_2;

public class Homework_5_2 {
    static final int size = 1_000_000;
    static final int halfSize = 500_000;

    public static void main(String[] args) throws InterruptedException {
        Method1();
        Method2();
    }

    public static void Method1() {
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1.0f;
        }
        long time = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }

        System.out.println("Ушло времени на выполнение первого метода: " + (System.currentTimeMillis() - time) + " мс");
    }

    public static void Method2() throws InterruptedException {
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1.0f;
        }
        long time = System.currentTimeMillis();

        float[] left = new float[halfSize], right = new float[halfSize];
        System.arraycopy(array, 0, left, 0, halfSize);
        System.arraycopy(array, halfSize, right, 0, halfSize);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {
                left[i] = (float) (left[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
            }
            System.arraycopy(left, 0, array, 0, halfSize);
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {
                right[i] = (float) (right[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
            }
            System.arraycopy(right, 0, array, halfSize, halfSize);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Ушло времени на выполнение второго метода: " + (System.currentTimeMillis() - time) + " мс");
    }
}
