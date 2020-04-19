public class day03 {
    public static void main(String[] args) {


        new Thread("thread-one"){
            public void run(){

                for (int i = 0; i < 1000000; i++) {
                    if (i == 99) {
                        System.out.println("i==99");
                    }

                }

                System.out.println("thread-one：结束");

            }
        }.start();

        System.out.println("thread-one：结束22222");

    }



}
