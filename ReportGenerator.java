import java.util.List;

class ReportGenerator {
    public void generateLowStockReport(List<Product> products) {
        System.out.println("Low Stock Report:");
        for (Product product : products) {
            System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName() + ", Quantity: " + product.getQuantity());
        }
    }

    public void generateSalesSummary(List<Sale> sales) {
        double totalSales = 0;
        System.out.println("Sales Summary:");
        for (Sale sale : sales) {
            totalSales += sale.getTotal();
            System.out.println("Sale ID: " + sale.getId() + ", Total: $" + sale.getTotal());
        }
        System.out.println("Total Sales: $" + totalSales);
    }
}
