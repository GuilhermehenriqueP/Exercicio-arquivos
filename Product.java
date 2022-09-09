public class Product {
    
    private String name;
    private Double price;
    private Integer quantidade;

    public Product(String name, Double price, Integer quantidade) {
        this.name = name;
        this.price = price;
        this.quantidade = quantidade;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double total(){
        return price * quantidade;
    }
   
}
