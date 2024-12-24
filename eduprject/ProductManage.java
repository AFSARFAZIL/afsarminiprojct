package eduprject;
import java.util.*;

class Product {
    private int prodId;
    private String prodName;
    private double price;

    // Constructor
    Product(int prodId, String prodName, double price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }

    // Getter methods
    public int getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public double getPrice() {
        return price;
    }

    // toString method for displaying product details
    public String toString() {
        return prodId + " " + prodName + " " + price;
    }
}

class ProductManage {
    public static void main(String args[]) {
        List<Product> products = new ArrayList<Product>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);  // To handle string input
        Scanner s2 = new Scanner(System.in);  // To handle double input

        int ch;
        do {
            System.out.println("1 INSERT");
            System.out.println("2 DISPLAY");
            System.out.println("3 SEARCH");
            System.out.println("4 DELETE");
            System.out.println("5 UPDATE");
            System.out.print("Enter your choice: ");
            ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int prodId = s.nextInt();
                    System.out.print("Enter product name: ");
                    String prodName = s1.nextLine();
                    System.out.print("Enter product price: ");
                    double price = s2.nextDouble();
                    products.add(new Product(prodId, prodName, price));
                    System.out.println("-----------------------");
                    System.out.println("Product Inserted successfully");
                    System.out.println("-----------------------");
                    break;

                case 2:
                    System.out.println("-----------------------");
                    Iterator<Product> i = products.iterator();
                    while (i.hasNext()) {
                        Product p = i.next();
                        System.out.println(p);
                    }
                    System.out.println("-----------------------");
                    break;

                case 3:
                    boolean search = false;
                    System.out.print("Enter product ID: ");
                    prodId = s.nextInt();
                    i = products.iterator();
                    while (i.hasNext()) {
                        Product p = i.next();
                        if (p.getProdId() == prodId) {
                            search = true;
                            System.out.println("-----------------------");
                            System.out.println(p);
                        }
                    }
                    if (!search) {
                        System.out.println("-----------------------");
                        System.out.println("Product not found");
                    }
                    System.out.println("-----------------------");
                    break;

                case 4:
                    search = false;
                    System.out.print("Enter product ID you want to delete: ");
                    prodId = s.nextInt();
                    i = products.iterator();
                    while (i.hasNext()) {
                        Product p = i.next();
                        if (p.getProdId() == prodId) {
                            i.remove();
                            search = true;
                        }
                    }
                    if (!search) {
                        System.out.println("-----------------------");
                        System.out.println("Product not found");
                    } else {
                        System.out.println("-----------------------");
                        System.out.println("Product Deleted successfully");
                    }
                    System.out.println("-----------------------");
                    break;

                case 5:
                    search = false;
                    System.out.print("Enter product ID you want to update: ");
                    prodId = s.nextInt();
                    ListIterator<Product> li = products.listIterator();
                    while (li.hasNext()) {
                        Product p = li.next();
                        if (p.getProdId() == prodId) {
                            System.out.print("Enter product name: ");
                            prodName = s1.nextLine();
                            System.out.print("Enter product price: ");
                            price = s2.nextDouble();
                            li.set(new Product(prodId, prodName, price));
                            search = true;
                        }
                    }
                    if (!search) {
                        System.out.println("-----------------------");
                        System.out.println("Product not found");
                    } else {
                        System.out.println("Product Updated successfully");
                    }
                    System.out.println("-----------------------");
                    break;
            }
        } while (ch != 0);
    }
}


