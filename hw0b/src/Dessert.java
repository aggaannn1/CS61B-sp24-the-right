public class Dessert {
    int flavor;
    int price;
    static int numDesserts=0;

    public Dessert (int a,int b)
    {
        this.flavor=a;
        this.price=b;
        this.numDesserts++;
    }
    public void printDessert()
    {
        System.out.println(flavor+" "+ price+" "+numDesserts);
    }
    public static void main(String[] args)
    {
        System.out.println("I love dessert!");
    }
}
