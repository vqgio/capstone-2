public enum ToppingType {
    STEAK(ToppingQuality.PREMIUM_MEAT),
    HAM(ToppingQuality.PREMIUM_MEAT),
    SALAMI(ToppingQuality.PREMIUM_MEAT),
    ROAST_BEEF(ToppingQuality.PREMIUM_MEAT),
    CHICKEN(ToppingQuality.PREMIUM_MEAT),
    BACON(ToppingQuality.PREMIUM_MEAT),
    AMERICAN_CHEESE(ToppingQuality.PREMIUM_CHEESE),
    PROVOLONE_CHEESE(ToppingQuality.PREMIUM_CHEESE),
    CHEDDAR_CHEESE(ToppingQuality.PREMIUM_CHEESE),
    SWISS_CHEESE(ToppingQuality.PREMIUM_CHEESE),
    LETTUCE(ToppingQuality.REGULAR),
    PEPPERS(ToppingQuality.REGULAR),
    ONIONS(ToppingQuality.REGULAR),
    TOMATOES(ToppingQuality.REGULAR),
    JALAPENOS(ToppingQuality.REGULAR),
    CUCUMBERS(ToppingQuality.REGULAR),
    PICKLES(ToppingQuality.REGULAR),
    GUACAMOLE(ToppingQuality.REGULAR),
    MUSHROOMS(ToppingQuality.REGULAR),
    MAYONNAISE(ToppingQuality.REGULAR),
    MUSTARD(ToppingQuality.REGULAR),
    KETCHUP(ToppingQuality.REGULAR),
    RANCH(ToppingQuality.REGULAR),
    THOUSAND_ISLANDS(ToppingQuality.REGULAR),
    VINAIGRETTE(ToppingQuality.REGULAR),
    AU_JUS(ToppingQuality.REGULAR),
    SAUCE(ToppingQuality.REGULAR),
    ;

    ToppingType(ToppingQuality quality) {
        this.quality = quality;
    }

    public ToppingQuality getQuality() {
        return quality;
    }

    private final ToppingQuality quality;

}
