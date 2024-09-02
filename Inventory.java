import java.util.ArrayList;
import java.util.List;

class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(String id, int quantity) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setQuantity(quantity);
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void deleteProduct(String id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStockProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getQuantity() < threshold) {
                lowStockProducts.add(product);
            }
        }
        return lowStockProducts;
    }

    public List<Product> getProducts() {
        return products;
    }
}
