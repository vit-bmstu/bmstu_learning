/**1. Реализовать многопоточное приложение “Робот”. Надо написать робота, который умеет ходить.
 * За движение каждой его ноги отвечает отдельный поток. Шаг выражается в выводе в консоль LEFT или RIGHT.
 */

public  class Robot {
    Object CommunicationBetweenFoots = new Object();
    RightFoot RightFoot = new RightFoot(CommunicationBetweenFoots);
    LeftFoot LeftFoot = new LeftFoot(CommunicationBetweenFoots);

    public static void main(String[] args) {
        new Robot();
    }

    Robot() {
        RightFoot.start();
        LeftFoot.start();
    }

    class RightFoot extends Thread {
        Object CommunicationBetweenFoots = new Object();

        public RightFoot(Object communicationBetweenFoots) {
            this.CommunicationBetweenFoots = communicationBetweenFoots;
        }

        @Override
        public void run() {

            while (true) {
                try {
                    synchronized (CommunicationBetweenFoots) {
                        CommunicationBetweenFoots.wait();
                    }
                } catch (InterruptedException e) {
                }
                System.out.println("RIGHT");
                try {
                    sleep(1000);
                } catch (InterruptedException e1) {
                }
                synchronized (CommunicationBetweenFoots) {
                    CommunicationBetweenFoots.notify();
                }
            }
        }

    }

    class LeftFoot extends Thread {
        Object CommunicationBetweenFoots = new Object();

        public LeftFoot(Object communicationBetweenFoots) {
            this.CommunicationBetweenFoots = communicationBetweenFoots;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("LEFT");
                try {
                    sleep(1000);
                } catch (InterruptedException e1) {
                }
                synchronized (CommunicationBetweenFoots) {
                    CommunicationBetweenFoots.notify();
                }
                try {
                    synchronized (CommunicationBetweenFoots) {
                        CommunicationBetweenFoots.wait();
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
