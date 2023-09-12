public class Main {
    static enum MyEnum implements Funcional {
        On,Off,
    }
    public static void main(String[] args) {



    }
}

class Holder {

    Holder(OnOffButton o) {
        o.changeFunctions(Main.MyEnum.On);
    }

}

interface Funcional {

}

class OnOffButton {
    Funcional myEnum;
    enum Functions {

    }
    public void changeFunctions(Funcional enumFunction) {

    }

    OnOffButton(Funcional myEnum) {
        this.myEnum = myEnum;
    }
}