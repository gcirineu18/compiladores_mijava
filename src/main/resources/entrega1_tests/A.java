 class Main {
    public static void main(String[] args) {
     System.out.println(0);
    }
}
class B {
    public int g(int a) {
        return 42;
    }
}

public class A {
    public  int f(B b) {
        return b.g(); // Usa método da classe B
    }
}


