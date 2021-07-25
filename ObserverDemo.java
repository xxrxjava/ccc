
public class ObserverDemo {
    public static void main(String[] args) {
        Observer observer = new GFObserver("范冰冰");
        Observer observer1 = new GFObserver("杨幂");
        MassageSubject subject = new MassageSubject();
        /*关联起来*/
        subject.attach(observer);
        subject.attach(observer1);

        subject.change("大保健");
    }
}

class MassageSubject extends Subject {

    public void change(String state) {
        notifyObserver(state);
    }
}

/*女朋友子类*/
  class GFObserver implements Observer {
    public String getName() {
        return name;
    }


    private String name;

    GFObserver(String name) {
        this.name = name;
    }


    @Override
    public void update(String state) {
        System.out.println(this.name+"女朋友最新状态");
    }
}

/*自己*/
abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("增加女朋友"+observer.getName());
    }
    public void remove(Observer observer) {
        observers.remove(observer);
        System.out.println("移除女朋友");
    }
    public  void  notifyObserver(String state) {
        for (Observer o:observers
             ) {
            o.update(state);
        }
    }
}

/*女朋友*/
interface Observer {

    public String getName();
    void update(String state);
}
