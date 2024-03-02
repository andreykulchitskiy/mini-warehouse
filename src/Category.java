public enum Category {
    ZELENINA("Zelenina"),
    OVOCE("Ovoce"),
    MASO("Maso"),
    TRVANLIVE("Trvanlivé");

    private final String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
