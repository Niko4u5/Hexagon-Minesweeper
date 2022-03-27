public class Main {
    public static void main(String[] args) {
        MyCanvas window = new MyCanvas();
        window.setScene(new Start(window));

        long start = System.currentTimeMillis();
        /*while (true){
            if((System.currentTimeMillis()-start)>500){
                start = System.currentTimeMillis();
                window.repaint();
            }

        }*/
    }
}

