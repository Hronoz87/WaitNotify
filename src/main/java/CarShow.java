import java.util.ArrayList;
import java.util.List;

public class CarShow {

    List<Auto> autos = new ArrayList<>(10);

    List<Auto> getAutos() {
        return autos;
    }

    public synchronized void buyAuto() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в магазин");
            Thread.sleep(3000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
    }

    public synchronized Auto sellAuto() {
        try {
            System.out.println("Машин нет");
            Thread.sleep(3000);
            getAutos().add(new Auto());
            System.out.println("Производитель Toyota выпустил 1 авто");
            while (getAutos().size() == 0) {
                System.out.println("Автомобилей в наличие нет");
                wait();
            }
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getAutos().remove(0);
    }
}