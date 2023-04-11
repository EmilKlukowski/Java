package PPJ20;

public class Ball {
    public double radius;
    public static int ballCounter;

    public Ball(double radius) {
        this.radius = radius;
    }

    public static Ball makeBall(){
        double random = 10+(Math.random()*10);
        Ball pilka1 = new Ball(random);
        ballCounter++;
        return pilka1;
    }

    public static void showCounter(){
        System.out.println("Liczba pilek " + ballCounter);
    }

}
