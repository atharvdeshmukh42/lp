import java.util.*;

class Item {
    int value, weight;
    Item(int v, int w) { value = v; weight = w; }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight of item " + (i+1) + ": ");
            int v = sc.nextInt();
            int w = sc.nextInt();
            items[i] = new Item(v, w);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Sort by value/weight ratio
        Arrays.sort(items, (a, b) -> Double.compare(
                (double)b.value/b.weight,
                (double)a.value/a.weight));

        double maxValue = 0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                maxValue += item.value;
            } else {
                maxValue += item.value * ((double)capacity / item.weight);
                break;
            }
        }

        System.out.println("Maximum Profit: " + maxValue);
    }
}
