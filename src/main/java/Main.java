public class Main {
    public static void main(String[] args) {

       final   CarShow carShow = new CarShow();


        new Thread(null, carShow::buyAuto, "Покупатель1").start();
        new Thread(null, carShow::buyAuto, "Покупатель2").start();
        new Thread(null, carShow::buyAuto, "Покупатель3").start();

        new Thread(null, carShow::sellAuto, "Продавец").start();

    }

}
