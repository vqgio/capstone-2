public enum ToppingType {
    //meat
    STEAK(ToppingQuality.PREMIUM_MEAT),
    HAM(ToppingQuality.PREMIUM_MEAT),
    SALAMI(ToppingQuality.PREMIUM_MEAT),
    ROAST_BEEF(ToppingQuality.PREMIUM_MEAT),
    CHICKEN(ToppingQuality.PREMIUM_MEAT),
    BACON(ToppingQuality.PREMIUM_MEAT),
    //cheese
    AMERICAN_CHEESE(ToppingQuality.PREMIUM_CHEESE),
    PROVOLONE_CHEESE(ToppingQuality.PREMIUM_CHEESE),
    CHEDDAR_CHEESE(ToppingQuality.PREMIUM_CHEESE),
    SWISS_CHEESE(ToppingQuality.PREMIUM_CHEESE),
    //veggies
    LETTUCE(ToppingQuality.REGULAR),
    PEPPERS(ToppingQuality.REGULAR),
    ONIONS(ToppingQuality.REGULAR),
    TOMATOES(ToppingQuality.REGULAR),
    JALAPENOS(ToppingQuality.REGULAR),
    CUCUMBERS(ToppingQuality.REGULAR),
    PICKLES(ToppingQuality.REGULAR),
    GUACAMOLE(ToppingQuality.REGULAR),
    MUSHROOMS(ToppingQuality.REGULAR),
    //sauces
    MAYONNAISE(ToppingQuality.REGULAR),
    MUSTARD(ToppingQuality.REGULAR),
    KETCHUP(ToppingQuality.REGULAR),
    RANCH(ToppingQuality.REGULAR),
    THOUSAND_ISLANDS(ToppingQuality.REGULAR),
    VINAIGRETTE(ToppingQuality.REGULAR),
    //sides
    AU_JUS(ToppingQuality.REGULAR),
    SAUCE(ToppingQuality.REGULAR),
    //the semicolon is mandatory to tell the compiler where the constant declarations end and the other enum members begin.
    ;

    ToppingType(ToppingQuality quality) {
        this.quality = quality;
    }

    public ToppingQuality getQuality() {
        return quality;
    }

    private final ToppingQuality quality;

}
