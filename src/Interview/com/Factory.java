public class Factory {
    public static void main(String[] args) {

        carFactory test = new carFactory();
        System.out.println(String.valueOf(test.Factorycar("baoma")));


    }
}



interface car{
    private void run(){};
}

class benchi implements car {
    public void run() {

    }
}
class baoma implements car {
    public void run() {

    }
}

class carFactory{
    public  car Factorycar(String type){
        if (type=="benchi"){
            return  new benchi();
        }
        return new baoma();

    }

}