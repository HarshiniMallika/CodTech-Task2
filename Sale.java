class Sale {
    private String id;
    private double total;

    public Sale(String id, double total) {
        this.id = id;
        this.total = total;
    }

    public String getId() { return id; }
    public double getTotal() { return total; }
}
